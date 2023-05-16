package com.leonovets.cryptowatcher.service.business.impl;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.leonovets.cryptowatcher.repository.entity.AppUser;
import com.leonovets.cryptowatcher.repository.entity.CryptoCurrency;
import com.leonovets.cryptowatcher.service.business.CryptoCurrencyOpenApiConsumerService;
import com.leonovets.cryptowatcher.service.crud.AppUserCrudService;
import com.leonovets.cryptowatcher.service.crud.CryptoCurrencyCrudService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Mikhail.Leonovets
 * @since 05/16/2023 - 16:58
 */
@ExtendWith(MockitoExtension.class)
class CryptoCurrencyUpdaterServiceImplTest {
    @Mock
    private CryptoCurrencyCrudService cryptoCurrencyCrudService;
    @Mock
    private CryptoCurrencyOpenApiConsumerService<String> cryptoCurrencyOpenApiConsumerService;
    @Mock
    private AppUserCrudService appUserCrudService;

    private CryptoCurrencyUpdaterServiceImpl cryptoCurrencyUpdaterService;
    private Logger logger;
    private ListAppender<ILoggingEvent> listAppender = new ListAppender<>();

    @BeforeEach
    void setUp() {
        cryptoCurrencyUpdaterService = new CryptoCurrencyUpdaterServiceImpl(
                cryptoCurrencyCrudService,
                cryptoCurrencyOpenApiConsumerService,
                appUserCrudService
        );
        logger = (Logger) LoggerFactory.getLogger(CryptoCurrencyUpdaterServiceImpl.class);
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @AfterEach
    void tearDown() {
        logger.detachAndStopAllAppenders();
        listAppender = null;
    }


    @Test
    void cryptoCurrencyUpdateLogsInfo() throws JsonProcessingException {
        // given
        final List<CryptoCurrency> cryptoCurrenciesFromDb = getCryptoCurrenciesFromDb();
        final List<CryptoCurrency> cryptoCurrenciesFromOpenApi = getCryptoCurrenciesFromOpenApi();
        final List<AppUser> appUsers = getAppUsers();

        Mockito.doReturn(cryptoCurrenciesFromDb).when(cryptoCurrencyCrudService).findAll();
        Mockito.doReturn(cryptoCurrenciesFromOpenApi).when(cryptoCurrencyOpenApiConsumerService).getCryptoCurrencies(Mockito.any());
        Mockito.doReturn(appUsers).when(appUserCrudService).findAllByCryptoCurrency_Id(Mockito.any());

        // when
        // then
        cryptoCurrencyUpdaterService.cryptoCurrencyUpdate();
        Assertions.assertEquals(listAppender.list.get(0).getMessage(), "CryptoCurrency symbol: BTC, Username: misha, " +
                        "Percent changes for all the time: 14.29%.");
    }

    private List<CryptoCurrency> getCryptoCurrenciesFromDb() {
        final CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(1L);
        cryptoCurrency.setSymbol("BTC");
        cryptoCurrency.setCurrentPrice(new BigDecimal("900"));
        return List.of(cryptoCurrency);
    }

    private List<CryptoCurrency> getCryptoCurrenciesFromOpenApi() {
        final CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(1L);
        cryptoCurrency.setSymbol("BTC");
        cryptoCurrency.setCurrentPrice(new BigDecimal("800"));
        return List.of(cryptoCurrency);
    }

    private List<AppUser> getAppUsers() {
        final CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setId(1L);
        cryptoCurrency.setSymbol("BTC");
        cryptoCurrency.setCurrentPrice(new BigDecimal("700"));

        final AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setCryptoCurrency(cryptoCurrency);
        appUser.setUsername("misha");
        appUser.setFirstCryptoPrice(cryptoCurrency.getCurrentPrice());

        return List.of(appUser);
    }
}