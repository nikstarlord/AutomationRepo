package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemoTest1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/nikhil/Downloads/chromedriver_linux64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		//driver.get("https://google.com/");
		//System.out.println(driver.getCurrentUrl());//validate correct URl
		//System.out.println(driver.getTitle());//validate page title is correct
		//System.out.println(driver.getClass());
		//System.out.println(driver.getPageSource());//Print pageSource
		//driver.navigate().to("https://yahoo.com");
		//driver.navigate().back();//back to the previous url
		//driver.navigate().forward();//navigates to next url
		//driver.close();//closes the current browser
		//driver.quit();//closes all the child and parent windows opened by selenium 
		//driver.manage().window().maximize();//For maximizing the window
		driver.get("https://facebook.com");
		//driver.findElement(By.id("email")).sendKeys("nikhil.sharma");
		//driver.findElement(By.id("pass")).sendKeys("nik");
		//driver.findElement(By.id("u_0_b")).click();
		//driver.findElement(By.name("email")).sendKeys("nikhil");
		//driver.findElement(By.name("pass")).sendKeys("nik");
		//driver.findElement(By.xpath("//input[@class='inputtext login_form_input_box']")).click();
		//driver.findElement(By.partialLinkText("Forgotten ")).click();
		WebElement wb = driver.findElement(By.xpath("//*[ @id='email' and @type='email']"));
		wb.sendKeys("nikhil");
		//wb.clear();
		//driver.close();
	}

}
