package com.codebusters.ValoCB.service;

import com.codebusters.ValoCB.Datas;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DataGeneratorServiceTest {

    @Test
    void generateData() {
        // The method dataGeneratorService.generateData() is called on app running, we don't need to call it here
        Datas datas = Datas.getInstance();
        assert !datas.getClients().isEmpty();
        assert !datas.getPortfolios().isEmpty();
        assert !datas.getProducts().isEmpty();
        assert !datas.getUnderlyings().isEmpty();
        assert !datas.getCurrencyConversions().isEmpty();
    }
}