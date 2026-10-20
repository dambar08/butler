package com.butler.app.repositories;

import com.butler.app.entities.Trading212Item;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Trading212ItemRepository extends JpaRepository<Trading212Item, UUID> {
}
