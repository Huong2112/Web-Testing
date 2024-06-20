package core;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    public Object[][] getTableArray(String filePath, String sheetName, int startColumn, int totalColumn){
        FileInputStream fileInputStream = null;
        String[][] table = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            Row firstRow = sheet.getRow(0);
            if (firstRow == null){
                throw new IllegalArgumentException("No data in this sheet");
            }

            table = new String[rowCount][totalColumn];
            for (int i = 1; i < rowCount; i++){
                Row row = sheet.getRow(i);
                int cj = 0;
                for (int j = startColumn; j < startColumn+ totalColumn;j++, cj++){
                    Cell cell = row.getCell(j);
                    if (cell != null){
                        table[i-1][cj] = cell.toString();
                    }
                }
            }
            workbook.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return table;
    }
}
