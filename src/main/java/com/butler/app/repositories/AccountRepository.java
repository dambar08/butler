package com.butler.app.repositories;

import com.butler.app.entities.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("""
        select account from Account account
        where (
            account.family.id = :familyId
            or exists (
                select accountShare.id from AccountShare accountShare
                where accountShare.account = account
                    and accountShare.user.id = :userId
            )
        )
        and (:includeDisabled = true or account.disabledAt is null)
        """)
    Page<Account> findVisibleToUser(
        @Param("familyId") UUID familyId,
        @Param("userId") UUID userId,
        @Param("includeDisabled") boolean includeDisabled,
        Pageable pageable
    );

    @Query("""
        select account from Account account
        where account.id = :accountId
            and (
                account.family.id = :familyId
                or exists (
                    select accountShare.id from AccountShare accountShare
                    where accountShare.account = account
                        and accountShare.user.id = :userId
                )
            )
            and (:includeDisabled = true or account.disabledAt is null)
        """)
    Optional<Account> findVisibleAccount(
        @Param("accountId") UUID accountId,
        @Param("familyId") UUID familyId,
        @Param("userId") UUID userId,
        @Param("includeDisabled") boolean includeDisabled
    );
}
