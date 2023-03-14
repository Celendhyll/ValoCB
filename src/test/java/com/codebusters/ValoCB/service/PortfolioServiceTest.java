package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.PortfolioDTO;
import com.codebusters.ValoCB.dto.ProductDTO;
import com.codebusters.ValoCB.dto.UnderlyingDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PortfolioServiceTest {

    @Autowired
    IPortfolioService portfolioService;

    @Test
    void getPortfolioPrice() {
        PortfolioDTO portfolio = new PortfolioDTO("ptf1");
        ProductDTO productOne = new ProductDTO("pTest1");
        productOne.getUnderlyings().add(new UnderlyingDTO("uTest1", "EUR", 10L));
        productOne.getUnderlyings().add(new UnderlyingDTO("uTest2", "EUR", 45L));
        ProductDTO productTwo = new ProductDTO("pTest1");
        productTwo.getUnderlyings().add(new UnderlyingDTO("uTest21", "EUR", 20L));
        productTwo.getUnderlyings().add(new UnderlyingDTO("uTest22", "EUR", 17L));
        portfolio.getProducts().add(productOne);
        portfolio.getProducts().add(productTwo);
        assert BigDecimal.valueOf(92L).equals(portfolioService.getPortfolioPrice(portfolio, "EUR"));
    }
}