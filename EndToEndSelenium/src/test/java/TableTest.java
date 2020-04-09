import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.W3SchoolTable;
import resources.Base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TableTest extends Base {

    @Test
    public void testTable() throws IOException {
        driver=initializeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        W3SchoolTable table = new W3SchoolTable(driver);
        List<WebElement> tables=table.getTable();
        List<String>content = new ArrayList<String>();
        System.out.println("Before sorting....");
        for(WebElement s:tables){
            content.add(s.getText());
        }
        for(String c:content){
            System.out.println(c);
        }

        content.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("After Sorting...");
        for(String s:content){
            System.out.println(s);
        }


    }
}
