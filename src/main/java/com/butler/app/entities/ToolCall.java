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
@Table(name = "tool_calls")
public class ToolCall {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extra_content")
    private JsonNode extraContent;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "function_arguments")
    private JsonNode functionArguments;

    @Column(name = "function_name")
    private String functionName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "function_result")
    private JsonNode functionResult;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;

    @Column(name = "provider_call_id")
    private String providerCallId;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
