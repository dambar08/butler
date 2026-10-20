package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "account_statements")
public class AccountStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    @Column(name = "account_last4_hint", length = 4)
    private String accountLast4Hint;

    @Column(name = "account_name_hint", length = 200)
    private String accountNameHint;

    @Column(name = "byte_size", nullable = false)
    private Long byteSize;

    @Column(name = "checksum", nullable = false, length = 64)
    private String checksum;

    @Column(name = "closing_balance", precision = 19, scale = 4)
    private BigDecimal closingBalance;

    @Column(name = "content_sha256")
    private String contentSha256;

    @Column(name = "content_type", nullable = false, length = 100)
    private String contentType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", length = 3)
    private String currency;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @Column(name = "filename", nullable = false, length = 255)
    private String filename;

    @Column(name = "institution_name_hint", length = 200)
    private String institutionNameHint;

    @Column(name = "match_confidence", precision = 5, scale = 4)
    private BigDecimal matchConfidence;

    @Column(name = "opening_balance", precision = 19, scale = 4)
    private BigDecimal openingBalance;

    @Column(name = "parser_confidence", precision = 5, scale = 4)
    private BigDecimal parserConfidence;

    @Column(name = "period_end_on")
    private LocalDate periodEndOn;

    @Column(name = "period_start_on")
    private LocalDate periodStartOn;

    @Column(name = "review_status", nullable = false)
    private String reviewStatus;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "sanitized_parser_output", nullable = false)
    private JsonNode sanitizedParserOutput;

    @Column(name = "source", nullable = false)
    private String source;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "suggested_account_id", nullable = true)
    private Account suggestedAccount;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "upload_status", nullable = false)
    private String uploadStatus;
}
