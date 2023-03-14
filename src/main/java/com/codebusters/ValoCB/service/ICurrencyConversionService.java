package com.codebusters.ValoCB.service;

import java.math.BigDecimal;

/**
 * Interface used to handle operations related to CurrencyConversion.
 */
public interface ICurrencyConversionService {
    
    /**
     * Get the factor of conversion from a currency to another.
     * We suppose our data is correct and contains the direct conversion, non-direct conversion is not handled here.
     * @param currencyFrom - the currency to convert from
     * @param currencyTo - the currency to convert to
     * @return the factor of conversion between the two currencies
     * @throws RuntimeException - in case we don't find our currency conversion in our datas
     */
    BigDecimal getCurrencyFactor(String currencyFrom, String currencyTo) throws RuntimeException;
}
