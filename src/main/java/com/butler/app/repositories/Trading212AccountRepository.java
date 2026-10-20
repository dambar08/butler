package com.butler.app.repositories;

import com.butler.app.entities.Trading212Account;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Trading212AccountRepository extends JpaRepository<Trading212Account, UUID> {
}
