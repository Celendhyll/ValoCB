package com.codebusters.ValoCB;

import com.codebusters.ValoCB.dto.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Datas {

    private static Datas DATAS = null;

    public static Datas getInstance() {
        if (DATAS == null) {
            DATAS = new Datas();
        }
        return DATAS;
    }
    private Map<String, ClientDTO> clients = new HashMap<>();
    private List<UnderlyingDTO> underlyings = new ArrayList<>();
    private Map<String, ProductDTO> products = new HashMap<>();
    private List<CurrencyConversionDTO> currencyConversions = new ArrayList<>();
    private Map<String, PortfolioDTO> portfolios = new HashMap<>();
}
