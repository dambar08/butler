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
@Table(name = "eval_samples")
public class EvalSample {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "context_data")
    private JsonNode contextData;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "difficulty")
    private String difficulty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "eval_dataset_id", nullable = false)
    private EvalDataset evalDataset;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "expected_output", nullable = false)
    private JsonNode expectedOutput;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "input_data", nullable = false)
    private JsonNode inputData;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata")
    private JsonNode metadata;

    @Column(name = "tags")
    private String tags;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
