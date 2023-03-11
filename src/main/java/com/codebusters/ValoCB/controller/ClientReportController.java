package com.codebusters.ValoCB.controller;

import com.codebusters.ValoCB.service.IClientReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for client report.
 */
@RestController
public class ClientReportController {

    @Autowired
    IClientReportService clientReportService;

    /**
     * Request to generate the client report with the wanted currency
     * @param currency - wanted currency
     */
    @GetMapping("/client/{currency}")
    public void generateClientReport(@PathVariable String currency) {
        clientReportService.generateReport(currency);
    }
}
