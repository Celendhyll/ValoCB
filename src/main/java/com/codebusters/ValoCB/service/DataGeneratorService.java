package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import com.codebusters.ValoCB.dto.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.Objects;

@Service
public class DataGeneratorService implements IDataGeneratorService {

    public static String DELIMITER = ",";

    public void generateData() {
        try {
            this.readForex();
            this.readPrices();
            this.readProduct();
            // TODO : ci-dessous à enlever une fois le debug terminer
            Datas datas = Datas.getInstance();
            System.out.println("OUT");
        } catch (IOException ioException) {
            System.err.println("IOException: " + ioException.getMessage());
        } catch (RuntimeException runtimeException) {
            System.err.println("RuntimeException: " + runtimeException.getMessage());
        }
    }

    private void readForex() throws IOException {
        Datas datas = Datas.getInstance();
        try (InputStream is = DataGeneratorService.class.getResourceAsStream("/Forex.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)))) {
            br.lines().skip(1).forEach(
                    line -> {
                        String[] values = line.split(DELIMITER);
                        datas.getCurrencyConversions().add(new CurrencyConversionDTO(values[0], values[1], new BigDecimal(values[2])));
                    }
            );
        }
    }

    private void readPrices() throws IOException {
        Datas datas = Datas.getInstance();
        try (InputStream is = DataGeneratorService.class.getResourceAsStream("/Prices.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)))) {
            br.lines().skip(1).forEach(
                    line -> {
                        String[] values = line.split(DELIMITER);
                        // Adding Underlying
                        UnderlyingDTO underlying = new UnderlyingDTO(values[2], values[3], Long.valueOf(values[4]));
                        datas.getUnderlyings().add(underlying);
                        // Adding product
                        String productName = values[1];
                        ProductDTO product = datas.getProducts().get(productName);
                        if (product == null) {
                            product = new ProductDTO(productName);
                            datas.getProducts().put(productName, product);
                            // Adding portfolio only if not added before (null in the data map)
                            String portfolioName = values[0];
                            PortfolioDTO portfolio = datas.getPortfolios().get(portfolioName);
                            if (portfolio == null) {
                                portfolio = new PortfolioDTO(portfolioName);
                                datas.getPortfolios().put(portfolioName, portfolio);
                            }
                            portfolio.getProducts().add(product);
                        }
                        // Adding underlying
                        product.getUnderlyings().add(underlying);
                    }
            );
        }
    }

    private void readProduct() throws IOException {
        Datas datas = Datas.getInstance();
        try (InputStream is = DataGeneratorService.class.getResourceAsStream("/Product.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)))) {
            br.lines().skip(1).forEach(
                    line -> {
                        // Adding client
                        String[] values = line.split(DELIMITER);
                        String clientName = values[1];
                        ClientDTO client = datas.getClients().get(clientName);
                        if (client == null) {
                            client = new ClientDTO(clientName);
                            datas.getClients().put(clientName, client);
                        }
                        String productName = values[0];
                        ProductDTO product = datas.getProducts().get(productName);
                        // If we don't find the product in our data product list we consider it non-existent
                        if (product != null) {
                            // Handling duplicates of client/product key
                            Long newQuantity = Long.valueOf(values[2]);
                            Long oldQuantity = client.getProductQuantityMap().get(product);
                            client.getProductQuantityMap().put(product, oldQuantity == null ? newQuantity : oldQuantity + newQuantity);
                        } else {
                            System.err.println("Product " + productName + " not found");
                        }
                    }
            );
        }
    }
}
