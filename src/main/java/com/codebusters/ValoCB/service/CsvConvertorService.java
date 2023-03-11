package com.codebusters.ValoCB.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvConvertorService implements ICsvConvertorService {
    public void convertToCsv(String csvName, List<String[]> lines) throws IOException {
        File csvFile = new File(csvName);
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            lines.stream().map(this::convertLineToCsv).forEach(pw::println);
        }
    }

    private String convertLineToCsv(String[] line) {
        return String.join(",", line);
    }
}
