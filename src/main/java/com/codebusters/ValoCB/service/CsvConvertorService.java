package com.codebusters.ValoCB.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Service used to handle operations related to CSV files.
 */
@Service
public class CsvConvertorService implements ICsvConvertorService {

    /**
     * Delimiter used in CSV files.
     */
    public static String CSV_DELIMITER = ",";

    /**
     * {@inheritDoc}
     */
    public void convertToCsv(String csvName, List<String[]> lines) throws IOException {
        File csvFile = new File(csvName);
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            lines.stream().map(this::convertLineToCsv).forEach(pw::println);
        }
    }

    /**
     * Convert one line in a csv format.
     * @param line - the line to convert
     * @return the String correspond to the line, in a csv format
     */
    private String convertLineToCsv(String[] line) {
        return String.join(CSV_DELIMITER, line);
    }
}
