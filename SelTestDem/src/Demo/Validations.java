package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validations {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/nikhil/exercise/AutomationDemo.html");
       /* driver.findElement(By.id("male")).click();
        //boolean gender = driver.findElement(By.id("female")).isSelected();
        //System.out.println(gender);
        //if(gender){
          //  System.out.println("Passed.....");
        //}
        /else{
            System.out.println("Failed.....");
        }*/
       String str="Register";
       String title=driver.getTitle();
       String exp = "Automation Demo Site";
      // String act =
       if(str.equals(title)){
           System.out.println("Passed....");
       }
       else{
           System.out.println("Failed....");
       }
    }
}
