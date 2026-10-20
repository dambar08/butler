package com.butler.app.repositories;

import com.butler.app.entities.OnchainWalletAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnchainWalletAccountRepository extends JpaRepository<OnchainWalletAccount, UUID> {
}
