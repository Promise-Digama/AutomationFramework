package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReader {
   private String filePath;
   private String sheetName;

    public ExcelReader(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    public Object[][] readExcelData() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellValue(row.getCell(j));
            }
        }

        workbook.close();
        fis.close();

        return data;
    }

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case BLANK:
            default:
                return null;
        }
    }

}
