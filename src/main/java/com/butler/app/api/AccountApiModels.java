package com.butler.app.api;

import com.butler.app.entities.Account;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public final class AccountApiModels {

    private AccountApiModels() {
    }

    public record AccountResponse(
        UUID id,
        String name,
        String institutionName,
        String institutionDomain,
        BigDecimal balance,
        BigDecimal cashBalance,
        String currency,
        String classification,
        String subtype,
        String status,
        LocalDateTime disabledAt
    ) {
        public static AccountResponse from(Account account) {
            return new AccountResponse(
                account.getId(),
                account.getName(),
                account.getInstitutionName(),
                account.getInstitutionDomain(),
                account.getBalance(),
                account.getCashBalance(),
                account.getCurrency(),
                account.getClassification(),
                account.getSubtype(),
                account.getStatus(),
                account.getDisabledAt()
            );
        }
    }

    public record AccountPageResponse(
        List<AccountResponse> accounts,
        int page,
        int perPage,
        long totalElements,
        int totalPages
    ) {
    }
}
