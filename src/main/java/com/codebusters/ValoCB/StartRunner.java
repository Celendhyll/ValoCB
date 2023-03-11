package com.codebusters.ValoCB;

import com.codebusters.ValoCB.service.IClientReportService;
import com.codebusters.ValoCB.service.IDataGeneratorService;
import com.codebusters.ValoCB.service.IPortfolioReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    IDataGeneratorService dataGeneratorService;

    @Autowired
    IPortfolioReportService portfolioReportService;

    @Autowired
    IClientReportService clientReportService;

    @Override
    public void run(String... args) throws Exception {
        String wantedCurrency = "EUR";
        dataGeneratorService.generateData();
        // Testing in euros
        portfolioReportService.generateReport(wantedCurrency);
        clientReportService.generateReport(wantedCurrency);
        System.exit(0);
    }
}
