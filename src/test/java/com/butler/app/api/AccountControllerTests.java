package com.butler.app.api;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.butler.app.entities.Account;
import com.butler.app.service.AccountService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class AccountControllerTests {

    private final AccountService accountService = mock(AccountService.class);
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(accountService)).build();
        when(accountService.listAccounts(isNull(), anyInt(), anyInt(), anyBoolean()))
            .thenAnswer(invocation -> {
                int page = invocation.getArgument(1);
                int perPage = invocation.getArgument(2);
                return new PageImpl<>(
                    List.<Account>of(),
                    PageRequest.of(page - 1, perPage),
                    0
                );
            });
    }

    @Test
    void indexDefaultsPerPageAndPage() throws Exception {
        mockMvc.perform(get("/api/v1/accounts"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.page").value(1))
            .andExpect(jsonPath("$.perPage").value(25))
            .andExpect(jsonPath("$.accounts").isArray());

        verify(accountService).listAccounts(isNull(), 1, 25, false);
    }

    @Test
    void indexClampsLargePerPageAndUsesRequestedPage() throws Exception {
        mockMvc.perform(get("/api/v1/accounts")
                .param("page", "3")
                .param("per_page", "101")
                .param("include_disabled", "true"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.page").value(3))
            .andExpect(jsonPath("$.perPage").value(100));

        verify(accountService).listAccounts(isNull(), 3, 100, true);
    }

    @Test
    void indexAcceptsPerPageBoundsAndClampsVeryLargeValues() throws Exception {
        mockMvc.perform(get("/api/v1/accounts").param("per_page", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.perPage").value(1));

        mockMvc.perform(get("/api/v1/accounts").param("per_page", "100"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.perPage").value(100));

        mockMvc.perform(get("/api/v1/accounts").param("per_page", "999999999999999999999"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.perPage").value(100));

        verify(accountService).listAccounts(isNull(), 1, 1, false);
        verify(accountService).listAccounts(isNull(), 1, 100, false);
    }

    @Test
    void indexDefaultsInvalidOrNonPositivePerPage() throws Exception {
        mockMvc.perform(get("/api/v1/accounts").param("per_page", "invalid"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.perPage").value(25));

        mockMvc.perform(get("/api/v1/accounts").param("per_page", "0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.perPage").value(25));
    }

    @Test
    void showReturnsNotFoundForMalformedId() throws Exception {
        mockMvc.perform(get("/api/v1/accounts/not-a-uuid"))
            .andExpect(status().isNotFound());

        verifyNoInteractions(accountService);
    }
}
