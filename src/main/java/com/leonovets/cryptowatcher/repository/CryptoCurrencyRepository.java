package com.leonovets.cryptowatcher.repository;

import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Mikhail.Leonovets
 * @since 05/15/2023 - 00:29
 */
@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findBySymbol(final String symbol);

    @Query("SELECT cc FROM crypto_currency cc WHERE cc.id IN :ids")
    List<CryptoCurrency> findAllByIds(final List<Long> ids);

}
