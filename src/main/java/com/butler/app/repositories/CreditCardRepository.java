package com.butler.app.repositories;

import com.butler.app.entities.CreditCard;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, UUID> {
}
