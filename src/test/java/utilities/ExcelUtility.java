package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public static List<List<String>> getData(String path, String sheetName) {
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                    rowData.add(cell.getStringCellValue());
                }
                data.add(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}