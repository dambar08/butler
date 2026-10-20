package com.butler.app.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record EntrySearchResult(
    UUID id,
    UUID accountId,
    String accountName,
    String name,
    String notes,
    BigDecimal amount,
    String currency,
    LocalDate date
) {
}
