package com.butler.app.repositories;

import com.butler.app.entities.FamilyMerchantAssociation;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMerchantAssociationRepository extends JpaRepository<FamilyMerchantAssociation, UUID> {
}
