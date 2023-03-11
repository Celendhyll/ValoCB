package com.codebusters.ValoCB.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface ICurrencyConversionService {
    BigDecimal getCurrencyFactor(String currencyFrom, String currencyTo) throws RuntimeException;
}
