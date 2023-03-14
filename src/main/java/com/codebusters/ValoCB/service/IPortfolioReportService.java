package com.codebusters.ValoCB.service;

/**
 * Interface used to handle operations related to Portfolio report generation.
 */
public interface IPortfolioReportService {

    /**
     * Generates the portfolio report according to a currency in a csv format.
     * @param currency - the wanted currency
     */
    void generateReport(String currency);
}
