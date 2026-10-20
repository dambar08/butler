package com.butler.app.repositories;

import com.butler.app.entities.Merchant;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {
}
