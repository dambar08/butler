package com.butler.app.repositories;

import com.butler.app.entities.EnableBankingAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnableBankingAccountRepository extends JpaRepository<EnableBankingAccount, UUID> {
}
