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

    @Autowired
    ICurrencyConversionService currencyConversionService;

    @Test
    void getCurrencyFactor() {
        assert BigDecimal.ONE.equals(currencyConversionService.getCurrencyFactor("EUR", "EUR"));
        assert BigDecimal.valueOf(2L).equals(currencyConversionService.getCurrencyFactor("EUR", "USD"));
        assert BigDecimal.valueOf(0.5).equals(currencyConversionService.getCurrencyFactor("USD", "EUR"));
    }
}