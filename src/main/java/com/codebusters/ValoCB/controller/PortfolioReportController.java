package com.codebusters.ValoCB.controller;

import com.codebusters.ValoCB.service.IPortfolioReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for portfolio report.
 */
@RestController
public class PortfolioReportController {

    @Autowired
    IPortfolioReportService portfolioReportService;

    /**
     * Request to generate the portfolio report with the wanted currency
     * @param currency - wanted currency
     */
    @GetMapping("/portfolio/{currency}")
    public void generatePortfolioReport(@PathVariable String currency) {
        portfolioReportService.generateReport(currency);
    }
}
