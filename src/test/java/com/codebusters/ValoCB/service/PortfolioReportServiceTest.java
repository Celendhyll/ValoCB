package com.codebusters.ValoCB.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
class PortfolioReportServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Autowired
    IPortfolioReportService portfolioReportService;

    @Test
    void generateReport() {
        portfolioReportService.generateReport("EUR");
        assert new File(PortfolioReportService.PORTFOLIO_CSV_NAME).exists();
    }
}