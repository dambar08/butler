package com.butler.app.repositories;

import com.butler.app.entities.OnchainWalletItem;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnchainWalletItemRepository extends JpaRepository<OnchainWalletItem, UUID> {
}
