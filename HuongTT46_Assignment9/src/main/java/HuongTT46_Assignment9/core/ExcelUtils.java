package HuongTT46_Assignment9.core;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;


public class ExcelUtils {
    public static Object[][] getTableArray(String filePath, String sheetName, int startCol, int totalCol){
        FileInputStream fis = null;
        String[][] table = null;
        try {
            fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();

            Row firstRow = sheet.getRow(0);
            if (firstRow == null) {
                throw new IllegalArgumentException("No data in this sheet.");
            }
            table = new String[rowCount][totalCol];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cj = 0;
                    for (int j = startCol; j < startCol+ totalCol; j++, cj++) {

                        Cell cell = row.getCell(j);
                        table[i - 1][cj] = (cell == null) ? "" : cell.toString();
                    }
                }
                workbook.close();
                fis.close();
            }
        } catch (Exception e) {
        }
        return table;

    }
}
