package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream file  = new FileInputStream("/home/nikhil/eclipse-workspace/SelTestDem/src/Demo/Data.properties");
        prop.load(file);

        //Configure Chrome

        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");

        //Fetching elements and sending values through properties file
        driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys(prop.getProperty("fname"));
        driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys(prop.getProperty("lname"));
        driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(prop.getProperty("address"));
        driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys(prop.getProperty("email"));
        driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(prop.getProperty("phone"));
        String gender = prop.getProperty("gender");
        if(gender.equalsIgnoreCase("male")){
            driver.findElement(By.xpath("//input[@value='Male']")).click();
        }
        else if (gender.equalsIgnoreCase("Female")){
            driver.findElement(By.xpath("//input[@value='Female']")).click();
        }

        //Hobbies
        List<String> hobbies = Stream.of(prop.getProperty("hobbies").split(",")).collect(Collectors.toList());
       List<WebElement> hlist = driver.findElements(By.xpath("//label[@class='checks']"));
       List<WebElement> hcheck = driver.findElements(By.xpath("//input[@type='checkbox']"));
       for(int i=0;i<hlist.size();i++){
           String s= hlist.get(i).getText();
           if(hobbies.contains(s)){
               hcheck.get(i).click();
           }
       }

       //Languages Selection
        List<String> langInput  = Stream.of(prop.getProperty("languages").split(",")).collect(Collectors.toList());
       driver.findElement(By.id("msdd")).click();
        List<WebElement> language = driver.findElements(By.xpath("//div[@style='display:block;']/ul/a"));
       for(int i=0;i<language.size();i++){
           String s= language.get(i).getText();
           if(langInput.contains(s)){
               language.get(i).click();
           }
       }

       //Skills
        List<String> skillsInput = Stream.of(prop.getProperty("skills").split(",")).collect(Collectors.toList());
       Select skillsList = new Select(driver.findElement(By.id("Skills")));
       for(String s: skillsInput){
           skillsList.selectByVisibleText(s);
       }


       //Country

        String country = prop.getProperty("country");
       List<WebElement> countryList = driver.findElements(By.xpath("//select[@id='countries']/option"));
       for(int i=0;i<countryList.size();i++){
           String s= countryList.get(i).getText();
           if(country.equalsIgnoreCase(s)){
               countryList.get(i).click();
               break;
           }
       }

       //Select Country

        String selCountry = prop.getProperty("selCountry");
       driver.findElement(By.xpath("//span[@role='combobox']")).click();
       Thread.sleep(2000);
       List<WebElement> selCountryList  = driver.findElements(By.xpath("ul[@id='select2-country-results']//li"));
       for(int i=0;i<selCountryList.size();i++){
           String s = selCountryList.get(i).getText();
           if(selCountry.equalsIgnoreCase(s)){
               selCountryList.get(i).click();
               break;
           }
       }

       //Date of birth
        //year

        String year = prop.getProperty("year");
        Select yearlist  = new Select(driver.findElement(By.id("yearbox")));
        yearlist.selectByVisibleText(year);

        //month
        String month = prop.getProperty("month");
        Select monthList = new Select(driver.findElement(By.xpath("//select[@ng-model='monthbox']")));
        monthList.selectByVisibleText(month);

        //day

        String day = prop.getProperty("day");
        Select daylist = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
        daylist.selectByVisibleText(day);

        String password = prop.getProperty("paswd");
        driver.findElement(By.id("firstpassword")).sendKeys(password);

        String confirmpass = prop.getProperty("confirmpass");
        driver.findElement(By.id("secondpassword")).sendKeys(confirmpass);

        driver.findElement(By.id("submitbtn")).click();




    }
}
