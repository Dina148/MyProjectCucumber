package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ExellTest {

    public static void main(String[] args) throws IOException {


        String filePath = "/Users/puffdi/Desktop/ExellGulyaTest.xlsx";

        // It will define given file in java object
        File file = new File(filePath);

        FileInputStream inputStream = new FileInputStream(file);
        Workbook book=new XSSFWorkbook(inputStream);

        Sheet sheet=book.getSheet("GulyaTest1");
        Row row=sheet.getRow(1);
        Cell cell=row.getCell(1);
        System.out.println(cell);

       // cell.setCellValue();



    }

}
