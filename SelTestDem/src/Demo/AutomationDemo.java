package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class AutomationDemo {

    WebDriver driver=null;
    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/mercurysignon.php");
    }

    @BeforeTest
    public void login(){
        driver.findElement(By.name("userName")).sendKeys("Nikhil");
        driver.findElement(By.name("password")).sendKeys("nikhil");
        driver.findElement(By.name("login")).click();
        String expected ="http://newtours.demoaut.com/mercuryreservation.php?";
        //Assert.assertEquals(expected,driver.getCurrentUrl());
       Assert.assertTrue(driver.getCurrentUrl().contains(expected));
    }

    @Test(enabled = false)
    public void reservationTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        Select passenger = new Select(driver.findElement(By.name("passCount")));
        passenger.selectByVisibleText("4");
        Select from = new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText("Sydney");
        Select month = new Select(driver.findElement(By.name("fromMonth")));
        month.selectByVisibleText("March");
        Select day = new Select(driver.findElement(By.name("fromDay")));
        day.selectByVisibleText("6");
        Select to = new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText("London");
        Select returnMonth = new Select(driver.findElement(By.name("toMonth")));
        returnMonth.selectByVisibleText("March");
        Select returnDay = new Select(driver.findElement(By.name("toDay")));
        returnDay.selectByVisibleText("23");
        driver.findElement(By.cssSelector("input[value='First']")).click();
        Select airline = new Select(driver.findElement(By.name("airline")));
        airline.selectByVisibleText("Blue Skies Airlines");
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(3000);
        String URl = "http://newtours.demoaut.com/mercuryreservation2.php";
        Assert.assertTrue(driver.getCurrentUrl().contains(URl));
    }

    @Test(dependsOnMethods = {"reservationTest"})
    public void reservationTest2() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
        driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$631$273$14:30']")).click();
        driver.findElement(By.name("reserveFlights")).click();
        Thread.sleep(3000);

        String url = "http://newtours.demoaut.com/mercurypurchase.php";
        Assert.assertTrue(driver.getCurrentUrl().contains(url));

    }

    @Test(dependsOnMethods = {"reservationTest2","reservationTest"}, enabled = false)
    public void purchaseTestWithoutPassengerDetails() throws InterruptedException {
        driver.findElement(By.name("buyFlights")).click();
        Thread.sleep(3000);

        String exp = "Your itinerary has been booked!";
        Assert.assertFalse(driver.findElement(By.xpath("//font[@size='+1']")).getText().equalsIgnoreCase(exp));
    }

    @Test(dependsOnMethods = {"reservationTest2","reservationTest"})
    public void purchaseTest() throws InterruptedException {
        driver.findElement(By.name("passFirst0")).sendKeys("Nikhil");
        driver.findElement(By.name("passLast0")).sendKeys("Sharma");
        Select meal = new Select(driver.findElement(By.name("pass.0.meal")));
        meal.selectByVisibleText("Hindu");
        Select creditCard = new Select(driver.findElement(By.name("creditCard")));
        creditCard.selectByVisibleText("Visa");
        driver.findElement(By.name("creditnumber")).sendKeys("1234567890");
        Select expmon = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
        expmon.selectByVisibleText("12");
        Select expyr = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
        expyr.selectByVisibleText("2009");
        driver.findElement(By.name("cc_frst_name")).sendKeys("Nikhil");
        driver.findElement(By.name("cc_last_name")).sendKeys("Sharma");
        driver.findElement(By.name("billAddress1")).sendKeys("D-7 site no2 industrial area panki kanpur");
        driver.findElement(By.name("billCity")).sendKeys("Kanpur");
        driver.findElement(By.name("billState")).sendKeys("U.P.");
        driver.findElement(By.name("billZip")).sendKeys("208022");
        Select country = new Select(driver.findElement(By.name("billCountry")));
        country.selectByVisibleText("INDIA");
        driver.findElements(By.name("ticketLess")).get(1).click();
        driver.findElement(By.name("buyFlights")).click();
        Thread.sleep(2000);
        String exp = "Your itinerary has been booked!";
        Assert.assertTrue(driver.findElement(By.xpath("//font[@size='+1']")).getText().equalsIgnoreCase(exp));
    }

    @Test(enabled = false)
    public void reservationTestWithSameToAndFromPlace() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        Select passenger = new Select(driver.findElement(By.name("passCount")));
        passenger.selectByVisibleText("4");
        Select from = new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText("London");
        Select month = new Select(driver.findElement(By.name("fromMonth")));
        month.selectByVisibleText("March");
        Select day = new Select(driver.findElement(By.name("fromDay")));
        day.selectByVisibleText("6");
        Select to = new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText("London");
        Select returnMonth = new Select(driver.findElement(By.name("toMonth")));
        returnMonth.selectByVisibleText("March");
        Select returnDay = new Select(driver.findElement(By.name("toDay")));
        returnDay.selectByVisibleText("23");
        driver.findElement(By.cssSelector("input[value='First']")).click();
        Select airline = new Select(driver.findElement(By.name("airline")));
        airline.selectByVisibleText("Blue Skies Airlines");
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(3000);
        String URl = "http://newtours.demoaut.com/mercuryreservation2.php";
        Assert.assertFalse(driver.getCurrentUrl().contains(URl));
    }


    @Test
    public void reservationTestWithFromDateGreaterThanToDate() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        Select passenger = new Select(driver.findElement(By.name("passCount")));
        passenger.selectByVisibleText("4");
        Select from = new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText("Sydney");
        Select month = new Select(driver.findElement(By.name("fromMonth")));
        month.selectByVisibleText("March");
        Select day = new Select(driver.findElement(By.name("fromDay")));
        day.selectByVisibleText("26");
        Select to = new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText("London");
        Select returnMonth = new Select(driver.findElement(By.name("toMonth")));
        returnMonth.selectByVisibleText("January");
        Select returnDay = new Select(driver.findElement(By.name("toDay")));
        returnDay.selectByVisibleText("23");
        driver.findElement(By.cssSelector("input[value='First']")).click();
        Select airline = new Select(driver.findElement(By.name("airline")));
        airline.selectByVisibleText("Blue Skies Airlines");
        driver.findElement(By.name("findFlights")).click();
        Thread.sleep(3000);
        String URl = "http://newtours.demoaut.com/mercuryreservation2.php";
        Assert.assertFalse(driver.getCurrentUrl().contains(URl));
    }

    @AfterSuite
    public void shut(){
        driver.quit();
    }

}
