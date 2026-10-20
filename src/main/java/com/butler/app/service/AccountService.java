package com.butler.app.service;

import com.butler.app.entities.Account;
import com.butler.app.entities.User;
import com.butler.app.repositories.AccountRepository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CurrentUserService currentUserService;

    public AccountService(AccountRepository accountRepository, CurrentUserService currentUserService) {
        this.accountRepository = accountRepository;
        this.currentUserService = currentUserService;
    }

    @Transactional(readOnly = true)
    public Page<Account> listAccounts(Authentication authentication, int page, int perPage, boolean includeDisabled) {
        User user = currentUserService.requireCurrentUser(authentication);
        PageRequest pageRequest = PageRequest.of(
            page - 1,
            perPage,
            Sort.by(Sort.Order.asc("name"), Sort.Order.asc("id"))
        );
        return accountRepository.findVisibleToUser(
            user.getFamily().getId(),
            user.getId(),
            includeDisabled,
            pageRequest
        );
    }

    @Transactional(readOnly = true)
    public Account findAccount(Authentication authentication, UUID id, boolean includeDisabled) {
        User user = currentUserService.requireCurrentUser(authentication);
        return accountRepository.findVisibleAccount(
            id,
            user.getFamily().getId(),
            user.getId(),
            includeDisabled
        )
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
    }
}
