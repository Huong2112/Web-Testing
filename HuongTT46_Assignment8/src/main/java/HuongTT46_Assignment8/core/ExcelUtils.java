package HuongTT46_Assignment8.core;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getTableArrayToLogin(String filePath, String sheetName, int startCol, int totalCol) {
        String[][] table = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            int startRow = 1;
            int ci = 0, cj = 0;
            int totalRow = xssfSheet.getLastRowNum();
            table = new String[totalRow][totalCol];
            for (int i = startRow; i <= totalRow; i++, ci++) {
                for (int j = startCol; j < startCol+totalCol; j++, cj++) {
                    String value = xssfSheet.getRow(i).getCell(j).getStringCellValue();
                    table[ci][cj] = value;
                }
            }
        } catch (Exception e) {
        }
        return table;
    }

}
