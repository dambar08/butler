package com.butler.app.repositories;

import com.butler.app.entities.OauthApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthApplicationRepository extends JpaRepository<OauthApplication, Long> {
}
