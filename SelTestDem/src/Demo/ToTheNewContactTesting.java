package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import com.pooji.selenium.WaitHandler;

public class ToTheNewContactTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        WebDriver wb = new ChromeDriver();
        wb.get("https://www.tothenew.com/");
        //WebElement addToWishList = findElementWithWait(wb, By.xpath("//span[text()='Add to WISHLIST"));
        //addToWishList.click();
        WebElement ele = wb.findElement(By.xpath("//*[@class='header']//*[@id='h-contact-us']"));
        ele.click();
        System.out.println(wb.getTitle());
        System.out.println(wb.getCurrentUrl());

    }
}
