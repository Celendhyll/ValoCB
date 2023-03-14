package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import com.codebusters.ValoCB.dto.ClientDTO;
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
class ClientServiceTest {

    @Autowired
    IClientService clientService;

    @Test
    void getClientCapital() {
        ClientDTO client = new ClientDTO("testClient");
        ProductDTO productOne = new ProductDTO("pTest1");
        productOne.getUnderlyings().add(new UnderlyingDTO("uTest1", "EUR", 10L));
        productOne.getUnderlyings().add(new UnderlyingDTO("uTest2", "EUR", 45L));
        ProductDTO productTwo = new ProductDTO("pTest1");
        productTwo.getUnderlyings().add(new UnderlyingDTO("uTest21", "EUR", 20L));
        productTwo.getUnderlyings().add(new UnderlyingDTO("uTest22", "EUR", 17L));
        client.getProductQuantityMap().put(productOne, 10L);
        client.getProductQuantityMap().put(productTwo, 1L);
        assert BigDecimal.valueOf(587L).equals(clientService.getClientCapital(client, "EUR"));
    }
}