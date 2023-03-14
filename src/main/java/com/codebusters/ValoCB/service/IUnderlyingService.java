package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.UnderlyingDTO;

import java.math.BigDecimal;

/**
 * Interface used to handle operations related to Underlying.
 */
public interface IUnderlyingService {

    /**
     * Get the price of a wanted underlying in the wanted currency.
     * @param underlying - the wanted underlying
     * @param currency - the wanted currency
     * @return the price of the underlying
     * @throws RuntimeException - in case of an error with the calculus
     */
    BigDecimal getUnderlyingPrice(UnderlyingDTO underlying, String currency) throws RuntimeException;
}
