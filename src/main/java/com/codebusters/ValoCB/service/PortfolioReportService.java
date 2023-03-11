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

@Service
public class PortfolioReportService implements IPortfolioReportService {

    @Autowired
    IProductService productService;

    @Autowired
    ICsvConvertorService csvConvertorService;

    @Override
    public void generateReport(String currency) {
        try {
            Datas datas = Datas.getInstance();
            String csvName = "Reporting-portfolio.csv";
            List<String[]> dataLines = new ArrayList<>();
            String[] titleLines = {"PTF", "Price"};
            dataLines.add(titleLines);
            // Our portfolios data is in a form of Map<ptfName, ptf>, here we only need our ptf, so we will iterate on map.values
            datas.getPortfolios().values().forEach(ptf -> {
                String[] ptfLine = {ptf.getName(), this.getPortfolioPrice(ptf, currency).toPlainString()};
                dataLines.add(ptfLine);
            });
            csvConvertorService.convertToCsv(csvName, dataLines);
        } catch (RuntimeException | IOException exception) {
            System.out.println("Error in the generation of the portfolio report: " + exception.getMessage());
        }
    }

    private BigDecimal getPortfolioPrice(PortfolioDTO portfolio, String currency) throws RuntimeException {
        try {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (ProductDTO product : portfolio.getProducts()) {
                totalPrice = totalPrice.add(productService.getProductPrice(product, currency));
            }
            return totalPrice.stripTrailingZeros();
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the price of the portfolio %1s: %2s", portfolio.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
