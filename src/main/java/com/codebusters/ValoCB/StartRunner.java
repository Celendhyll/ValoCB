package com.codebusters.ValoCB;

import com.codebusters.ValoCB.service.IClientReportService;
import com.codebusters.ValoCB.service.IDataGeneratorService;
import com.codebusters.ValoCB.service.IPortfolioReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Runner for our app. Will call the services needed.
 */
@Component
public class StartRunner implements CommandLineRunner {

    @Autowired
    IDataGeneratorService dataGeneratorService;

    /**
     * Run method. Will call data generation then report generations.
     * Will be called when we launch the app.
     * @param args - args
     * @throws Exception - Exception
     */
    @Override
    public void run(String... args) throws Exception {
        dataGeneratorService.generateData();
    }
}
