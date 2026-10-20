package com.butler.app.repositories;

import com.butler.app.entities.IbkrAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbkrAccountRepository extends JpaRepository<IbkrAccount, UUID> {
}
