package com.leonovets.cryptowatcher.repository;

import com.leonovets.cryptowatcher.repository.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 00:28
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(final String username);

    List<AppUser> findAllByCryptoCurrency_Id(final Long cryptoCurrencyId);

}
