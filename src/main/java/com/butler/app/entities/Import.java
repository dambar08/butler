package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "imports")
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "account_col_label")
    private String accountColLabel;

    @Column(name = "account_id")
    private UUID accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_statement_id", nullable = true)
    private AccountStatement accountStatement;

    @Column(name = "ai_summary")
    private String aiSummary;

    @Column(name = "amount_col_label")
    private String amountColLabel;

    @Column(name = "amount_type_identifier_value")
    private String amountTypeIdentifierValue;

    @Column(name = "amount_type_inflow_value")
    private String amountTypeInflowValue;

    @Column(name = "amount_type_strategy")
    private String amountTypeStrategy;

    @Column(name = "category_col_label")
    private String categoryColLabel;

    @Column(name = "checksum", length = 64)
    private String checksum;

    @Column(name = "client_chunk_id", length = 255)
    private String clientChunkId;

    @Column(name = "col_sep")
    private String colSep;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "column_mappings")
    private JsonNode columnMappings;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency_col_label")
    private String currencyColLabel;

    @Column(name = "date_col_label")
    private String dateColLabel;

    @Column(name = "date_format")
    private String dateFormat;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "entity_type_col_label")
    private String entityTypeColLabel;

    @Column(name = "error")
    private String error;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "error_details", nullable = false)
    private JsonNode errorDetails;

    @Column(name = "exchange_operating_mic_col_label")
    private String exchangeOperatingMicColLabel;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "expected_record_counts", nullable = false)
    private JsonNode expectedRecordCounts;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extracted_data")
    private JsonNode extractedData;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "import_session_id", nullable = true)
    private ImportSession importSession;

    @Column(name = "name_col_label")
    private String nameColLabel;

    @Column(name = "normalized_csv_str")
    private String normalizedCsvStr;

    @Column(name = "notes_col_label")
    private String notesColLabel;

    @Column(name = "number_format")
    private String numberFormat;

    @Column(name = "price_col_label")
    private String priceColLabel;

    @Column(name = "qty_col_label")
    private String qtyColLabel;

    @Column(name = "raw_file_str")
    private String rawFileStr;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "readback_verification", nullable = false)
    private JsonNode readbackVerification;

    @Column(name = "rows_count", nullable = false)
    private Integer rowsCount;

    @Column(name = "rows_to_skip", nullable = false)
    private Integer rowsToSkip;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "signage_convention")
    private String signageConvention;

    @Column(name = "status")
    private String status;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "summary", nullable = false)
    private JsonNode summary;

    @Column(name = "tags_col_label")
    private String tagsColLabel;

    @Column(name = "ticker_col_label")
    private String tickerColLabel;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
