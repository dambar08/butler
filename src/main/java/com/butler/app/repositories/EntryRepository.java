package com.butler.app.repositories;

import com.butler.app.entities.Entry;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, UUID> {

    List<Entry> findAllByAccount_Family_Id(UUID familyId);
}
