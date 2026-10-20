package com.butler.app.repositories;

import com.butler.app.entities.OtherAsset;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherAssetRepository extends JpaRepository<OtherAsset, UUID> {
}
