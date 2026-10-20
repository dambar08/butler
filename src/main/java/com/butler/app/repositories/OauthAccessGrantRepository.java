package com.butler.app.repositories;

import com.butler.app.entities.OauthAccessGrant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessGrantRepository extends JpaRepository<OauthAccessGrant, Long> {
}
