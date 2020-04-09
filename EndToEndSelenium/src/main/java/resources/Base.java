package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fs = new FileInputStream("/home/nikhil/AutomationTestingCodes/EndToEndSelenium/src/main/java/resources/data.properties");
        prop.load(fs);
        String browserName = prop.getProperty("browser");


        //Checking for browser name
        if (browserName.equalsIgnoreCase("chrome")) {
            //initialize chrome driver

            System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/Softwares/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "/home/nikhil/Downloads/Softwares/geckodriver-v0.26.0-linux64/geckodriver");
            driver = new FirefoxDriver();
        }

       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }




}
