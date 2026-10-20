package com.butler.app.api;

import com.butler.app.api.AccountApiModels.AccountPageResponse;
import com.butler.app.api.AccountApiModels.AccountResponse;
import com.butler.app.service.AccountService;
import java.math.BigInteger;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private static final int DEFAULT_PER_PAGE = 25;
    private static final int MAX_PER_PAGE = 100;

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public AccountPageResponse index(
        @RequestParam(required = false) String page,
        @RequestParam(name = "per_page", required = false) String perPage,
        @RequestParam(name = "include_disabled", defaultValue = "false") boolean includeDisabled,
        Authentication authentication
    ) {
        int safePage = safePageParam(page);
        int safePerPage = safePerPageParam(perPage);
        Page<AccountResponse> accounts = accountService
            .listAccounts(authentication, safePage, safePerPage, includeDisabled)
            .map(AccountResponse::from);
        return new AccountPageResponse(
            accounts.getContent(),
            safePage,
            safePerPage,
            accounts.getTotalElements(),
            accounts.getTotalPages()
        );
    }

    @GetMapping("/{id}")
    public AccountResponse show(
        @PathVariable String id,
        @RequestParam(name = "include_disabled", defaultValue = "false") boolean includeDisabled,
        Authentication authentication
    ) {
        UUID accountId;
        try {
            accountId = UUID.fromString(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        if (!accountId.toString().equalsIgnoreCase(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        return AccountResponse.from(accountService.findAccount(authentication, accountId, includeDisabled));
    }

    private int safePerPageParam(String value) {
        if (value == null) {
            return DEFAULT_PER_PAGE;
        }
        try {
            BigInteger perPage = new BigInteger(value.trim());
            if (perPage.signum() <= 0) {
                return DEFAULT_PER_PAGE;
            }
            return perPage.min(BigInteger.valueOf(MAX_PER_PAGE)).intValue();
        } catch (NumberFormatException exception) {
            return DEFAULT_PER_PAGE;
        }
    }

    private int safePageParam(String value) {
        if (value == null) {
            return 1;
        }
        try {
            return Math.max(1, Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            return 1;
        }
    }
}
