package com.codebusters.ValoCB;

import com.codebusters.ValoCB.dto.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class used to store all the data.
 */
@Data
@NoArgsConstructor
public class Datas {

    /**
     * Instance of the data.
     */
    private static Datas DATAS = null;

    /**
     * Getter for the unique instance of Datas.
     * @return the instance
     */
    public static Datas getInstance() {
        if (DATAS == null) {
            DATAS = new Datas();
        }
        return DATAS;
    }

    /**
     * Map of the clients, the key is the client name.
     */
    private Map<String, ClientDTO> clients = new HashMap<>();

    /**
     * List of all underlyings.
     */
    private List<UnderlyingDTO> underlyings = new ArrayList<>();

    /**
     * Map of the products, the key is the product name.
     */
    private Map<String, ProductDTO> products = new HashMap<>();

    /**
     * List of the currency conversions.
     */
    private List<CurrencyConversionDTO> currencyConversions = new ArrayList<>();

    /**
     * Map of the portfolios, the key is the portfolio name.
     */
    private Map<String, PortfolioDTO> portfolios = new HashMap<>();
}
