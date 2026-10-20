package com.butler.app.service;

import java.time.LocalDate;
import java.util.UUID;

public record EntrySearchDocument(
    UUID id,
    UUID familyId,
    UUID accountId,
    String accountName,
    String name,
    String notes,
    String amount,
    String currency,
    LocalDate date
) {
}
