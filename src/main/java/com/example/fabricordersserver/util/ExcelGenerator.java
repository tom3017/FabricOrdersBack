package com.example.fabricordersserver.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility to build simple XLSX files from list-of-maps data.
 * Each map represents one row; keys are used in header order provided.
 */
public class ExcelGenerator {

    /**
     * Build an XLSX workbook bytes from header order and rows.
     * @param headers ordered list of column headers
     * @param rows list of rows where each row is a map header->value
     * @return byte[] containing xlsx file
     */
    public static byte[] generateXlsx(List<String> headers, List<Map<String, Object>> rows) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            XSSFSheet sheet = workbook.createSheet("Export");

            int rowIdx = 0;

            // Header row
            Row headerRow = sheet.createRow(rowIdx++);
            for (int i = 0; i < headers.size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers.get(i));
            }

            // Data rows
            for (Map<String, Object> rowMap : rows) {
                Row row = sheet.createRow(rowIdx++);
                for (int i = 0; i < headers.size(); i++) {
                    String key = headers.get(i);
                    Object value = rowMap.get(key);
                    Cell cell = row.createCell(i);
                    if (value == null) {
                        cell.setCellValue("");
                    } else if (value instanceof Number) {
                        cell.setCellValue(((Number) value).doubleValue());
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            }

            workbook.write(out);
            return out.toByteArray();
        }
    }
}
