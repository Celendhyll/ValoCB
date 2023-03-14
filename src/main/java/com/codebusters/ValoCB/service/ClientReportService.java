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

/**
 * Service used to handle operations related to Client.
 */
@Service
public class ClientReportService implements IClientReportService {

    /**
     * Name of the csv report to be generated.
     */
    public static String CLIENT_CSV_NAME = "target/Reporting-client.csv";

    @Autowired
    IClientService clientService;

    @Autowired
    ICsvConvertorService csvConvertorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateReport(String currency) {
        try {
            Datas datas = Datas.getInstance();
            List<String[]> dataLines = new ArrayList<>();
            String[] titleLines = {"Client", "Capital"};
            dataLines.add(titleLines);
            // Our portfolios data is in a form of Map<ptfName, ptf>, here we only need our ptf, so we will iterate on map.values
            datas.getClients().values().forEach(client -> {
                String[] clientLine = {client.getName(), clientService.getClientCapital(client, currency).toPlainString()};
                dataLines.add(clientLine);
            });
            csvConvertorService.convertToCsv(CLIENT_CSV_NAME, dataLines);
        } catch (RuntimeException | IOException exception) {
            System.out.println("Error in the generation of the portfolio report: " + exception.getMessage());
        }
    }
}
