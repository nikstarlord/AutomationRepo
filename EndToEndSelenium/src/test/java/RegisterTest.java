import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.AutoReg;
import resources.Base;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterTest extends Base {

    @Test
    public void testLanguage() throws IOException {
        driver = initializeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        List<String> ls= Stream.of(prop.getProperty("language").split(",")).collect(Collectors.toList());
        AutoReg reg = new AutoReg(driver);
        reg.getLan().click();
        List<WebElement> te = reg.getList();
        for(String s:ls){
            System.out.println(s);
        }
        int propSize = ls.size();
        int listSize = te.size();
        System.out.println(propSize+" "+listSize);
        for(int i=0;i<propSize;i++){
            for(int j=0;j<listSize;j++){
                String s = te.get(i).getText();
                System.out.println(s);
                if(s.equals(ls.get(j))){
                    te.get(i).click();
                }
            }
        }
    }
    @AfterTest
    public void close(){
        driver.quit();
    }

}
