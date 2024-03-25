package cucumberpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] readData(String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rowCount][colCount];
        
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        
        workbook.close();
        inputStream.close();
        
        return data;
    }
}
