package com.codebusters.ValoCB.service;

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
class UnderlyingServiceTest {

    @Autowired
    IUnderlyingService underlyingService;

    @Test
    void getUnderlyingPrice() {
        UnderlyingDTO un = new UnderlyingDTO("un", "EUR", 47L);
        assert BigDecimal.valueOf(47L).equals(underlyingService.getUnderlyingPrice(un, "EUR"));
        // Not really "necessary" here but allows to test for the conversion in a method where it is called
        assert BigDecimal.valueOf(94L).equals(underlyingService.getUnderlyingPrice(un, "USD"));
    }
}