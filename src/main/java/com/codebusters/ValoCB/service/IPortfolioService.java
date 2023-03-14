package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.PortfolioDTO;
import java.math.BigDecimal;

/**
 * Interface used to handle operations related to Portfolio.
 */
public interface IPortfolioService {

    /**
     * Calculates the price of a portfolio according to a currency.
     * @param portfolio - the wanted portfolio
     * @param currency - the wanted currency
     * @return the capital of the portfolio client in the wanted currency
     * @throws RuntimeException - in case of an error with the calculus
     */
    BigDecimal getPortfolioPrice(PortfolioDTO portfolio, String currency) throws RuntimeException;
}
