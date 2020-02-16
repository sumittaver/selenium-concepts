package com.pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WordPressTest {
	static WebDriver driver;
	@BeforeTest
	public void myDriverSetup() {
		String root=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", root+"/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://wordpress.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Driver init complete");
		}
	
	@Test
	public void myTest() {
		WordPressPage wPage=new WordPressPage(driver);
		wPage=PageFactory.initElements(driver, WordPressPage.class);
		wPage.logInLink();
		System.out.println("Login link clicked");
		
	}
	
	@AfterTest
	public void closingDriver() {
		driver.quit();
	}
}
