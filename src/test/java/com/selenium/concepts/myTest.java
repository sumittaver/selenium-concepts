package com.selenium.concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class myTest{
	@Test()
	public void test1() {
		String driverPaString=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPaString+"\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
	}
}
