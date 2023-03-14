package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.dto.ProductDTO;
import com.codebusters.ValoCB.dto.UnderlyingDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    IProductService productService;

    @Test
    void getProductPrice() {
        String productName = "productTest";
        ProductDTO product = new ProductDTO(productName);
        product.getUnderlyings().add(new UnderlyingDTO("uTest1", "EUR", 10L));
        product.getUnderlyings().add(new UnderlyingDTO("uTest2", "EUR", 45L));
        assert BigDecimal.valueOf(55L).equals(productService.getProductPrice(product, "EUR"));
    }
}