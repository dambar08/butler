package com.butler.app.repositories;

import com.butler.app.entities.ToolCall;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolCallRepository extends JpaRepository<ToolCall, UUID> {
}
