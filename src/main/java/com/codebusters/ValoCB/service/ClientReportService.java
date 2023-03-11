package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import com.codebusters.ValoCB.dto.ClientDTO;
import com.codebusters.ValoCB.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClientReportService implements IClientReportService {

    @Autowired
    IProductService productService;

    @Autowired
    ICsvConvertorService csvConvertorService;

    @Override
    public void generateReport(String currency) {
        try {
            Datas datas = Datas.getInstance();
            String csvName = "Reporting-client.csv";
            List<String[]> dataLines = new ArrayList<>();
            String[] titleLines = {"Client", "Capital"};
            dataLines.add(titleLines);
            // Our portfolios data is in a form of Map<ptfName, ptf>, here we only need our ptf, so we will iterate on map.values
            datas.getClients().values().forEach(client -> {
                String[] clientLine = {client.getName(), this.getClientCapital(client, currency).toPlainString()};
                dataLines.add(clientLine);
            });
            csvConvertorService.convertToCsv(csvName, dataLines);
        } catch (RuntimeException | IOException exception) {
            System.out.println("Error in the generation of the portfolio report: " + exception.getMessage());
        }
    }

    private BigDecimal getClientCapital(ClientDTO client, String currency) throws RuntimeException {
        try {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (Map.Entry<ProductDTO, Long> productQuantity : client.getProductQuantityMap().entrySet()) {
                totalPrice = totalPrice.add(productService.getProductPrice(productQuantity.getKey(), currency))
                        .multiply(BigDecimal.valueOf(productQuantity.getValue()));
            }
            return totalPrice.stripTrailingZeros();
        } catch (RuntimeException runtimeException) {
            String msg = String.format("Error in calculating the capital of the client %1s: %2s", client.getName(),
                    runtimeException.getMessage());
            throw new RuntimeException(msg);
        }
    }
}
