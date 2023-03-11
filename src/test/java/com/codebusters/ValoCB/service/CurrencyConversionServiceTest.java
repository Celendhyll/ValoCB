package com.codebusters.ValoCB.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CurrencyConversionServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    ICurrencyConversionService currencyConversionService;

    @Test
    void getCurrencyFactor() {
        assert currencyConversionService.getCurrencyFactor("EUR", "EUR").equals(BigDecimal.ONE);
        assert currencyConversionService.getCurrencyFactor("EUR", "USD").equals(BigDecimal.valueOf(2L));
        assert currencyConversionService.getCurrencyFactor("USD", "EUR").equals(BigDecimal.valueOf(0.5));
    }
}