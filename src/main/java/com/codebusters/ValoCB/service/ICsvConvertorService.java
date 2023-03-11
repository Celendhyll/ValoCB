package com.codebusters.ValoCB.service;

import java.io.IOException;
import java.util.List;

@FunctionalInterface
public interface ICsvConvertorService {
    void convertToCsv(String csvName, List<String[]> lines) throws IOException;
}
