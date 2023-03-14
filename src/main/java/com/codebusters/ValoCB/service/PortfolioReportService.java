package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import com.codebusters.ValoCB.dto.PortfolioDTO;
import com.codebusters.ValoCB.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Service used to handle operations related to Portfolio report generation.
 */
@Service
public class PortfolioReportService implements IPortfolioReportService {

    /**
     * Name of the csv report to be generated.
     */
    public static String PORTFOLIO_CSV_NAME = "target/Reporting-portfolio.csv";

    @Autowired
    ICsvConvertorService csvConvertorService;

    @Autowired
    IPortfolioService portfolioService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateReport(String currency) {
        try {
            Datas datas = Datas.getInstance();
            List<String[]> dataLines = new ArrayList<>();
            String[] titleLines = {"PTF", "Price"};
            dataLines.add(titleLines);
            // Our portfolios data is in a form of Map<ptfName, ptf>, here we only need our ptf, so we will iterate on map.values
            datas.getPortfolios().values().forEach(ptf -> {
                String[] ptfLine = {ptf.getName(), portfolioService.getPortfolioPrice(ptf, currency).toPlainString()};
                dataLines.add(ptfLine);
            });
            csvConvertorService.convertToCsv(PORTFOLIO_CSV_NAME, dataLines);
        } catch (RuntimeException | IOException exception) {
            System.out.println("Error in the generation of the portfolio report: " + exception.getMessage());
        }
    }
}
