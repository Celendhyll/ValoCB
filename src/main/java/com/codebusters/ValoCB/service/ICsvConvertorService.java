package com.codebusters.ValoCB.service;

import java.io.IOException;
import java.util.List;

/**
 * Interface used to handle operations related to CSV files.
 */
public interface ICsvConvertorService {

    /**
     * Converts lines to a csv format and generates the csv files accordingly.
     * @param csvName - name of the csv to be generated
     * @param lines - lines to convert and put in the csv
     * @throws IOException - in case of error related to the file
     */
    void convertToCsv(String csvName, List<String[]> lines) throws IOException;
}
