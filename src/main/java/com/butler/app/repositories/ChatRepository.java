package com.butler.app.repositories;

import com.butler.app.entities.Chat;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
}
