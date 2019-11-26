package com.demoqa;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public static WebDriver driver;
	
	@BeforeSuite()
	public void setupDriver() throws InterruptedException{
		String driverPaString=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPaString+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com");
		Reporter.log("###Browser opened sucessfully");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@AfterSuite()
	public void tireDownDriver() throws InterruptedException {
		driver.wait(5000);
		Reporter.log("###Closing Browser");
		driver.close();
		driver.quit();
	}
	
	@AfterTest()
	public void commonWaitAndBackButton() throws InterruptedException {
		Thread.sleep(2000);
		Reporter.log("### Redirecting to home page");
		driver.navigate().back();
	}
}
