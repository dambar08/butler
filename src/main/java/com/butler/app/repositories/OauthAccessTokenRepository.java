package com.butler.app.repositories;

import com.butler.app.entities.OauthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessTokenRepository extends JpaRepository<OauthAccessToken, Long> {
}
