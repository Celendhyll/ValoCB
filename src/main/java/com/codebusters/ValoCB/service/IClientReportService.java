package com.codebusters.ValoCB.service;

/**
 * Interface used to handle operations related to Client generation report.
 */
public interface IClientReportService {
    
    /**
     * Generates the client report according to a currency in a csv format.
     * @param currency - the wanted currency
     */
    void generateReport(String currency);
}
