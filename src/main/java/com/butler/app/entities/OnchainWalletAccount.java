package com.butler.app.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "onchain_wallet_accounts")
public class OnchainWalletAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "asset_kind", nullable = false)
    private String assetKind;

    @Column(name = "chain", nullable = false)
    private String chain;

    @Column(name = "content_hash")
    private String contentHash;

    @Column(name = "contract_address")
    private String contractAddress;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "current_balance", precision = 19, scale = 4)
    private BigDecimal currentBalance;

    @Column(name = "decimals", nullable = false)
    private Integer decimals;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extra", nullable = false)
    private JsonNode extra;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "onchain_wallet_item_id", nullable = false)
    private OnchainWalletItem onchainWalletItem;

    @Column(name = "quantity", nullable = false, precision = 32, scale = 18)
    private BigDecimal quantity;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_movements_payload")
    private JsonNode rawMovementsPayload;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "raw_payload")
    private JsonNode rawPayload;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "wallet_address", nullable = false)
    private String walletAddress;
}
