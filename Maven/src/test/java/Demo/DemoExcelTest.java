package Demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class DemoExcelTest {

    public ArrayList<String> getData(String testcasename) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream file = new FileInputStream("/home/nikhil/Documents/DemoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheets = workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Demo")){
                XSSFSheet sheet =workbook.getSheetAt(i);
                Iterator<Row> rows=sheet.iterator();
                Row firstrow  = rows.next();
                Iterator<Cell> cell=firstrow.cellIterator();
                int k=0;
                int coulumn=0;
                while (cell.hasNext()){
                    Cell value=cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        coulumn=k;
                    }
                    k++;
                }
               while(rows.hasNext()){
                   Row r = rows.next();
                   if(r.getCell(coulumn).getStringCellValue().equalsIgnoreCase(testcasename)){
                       Iterator<Cell> c=r.cellIterator();
                       while(c.hasNext()){
                           Cell cv=c.next();
                           a.add(cv.getStringCellValue());
                       }
                   }
               }
            }
        }

        return a;

    }

    public static void main(String[] args) throws IOException {
        DemoExcelTest demoExcelTest = new DemoExcelTest();
        ArrayList<String> ls = demoExcelTest.getData("Login");
        for(String a:ls){
            System.out.println(a);
        }
    }
}
