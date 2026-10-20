package com.butler.app.repositories;

import com.butler.app.entities.Crypto;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, UUID> {
}
