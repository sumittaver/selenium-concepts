package com.selenium.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.w3c.dom.UserDataHandler;

public class OptionMenu {
	@Test()
	public void testOptionMenu() throws InterruptedException {
		System.out.println("#######starting######");
		String driverPathString=System.getProperty("user.dir");
		System.out.println("Driver Path: "+driverPathString+"\\resources\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverPathString+"\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		WebElement dropDown = driver.findElement(By.id("testingDropdown"));
		Select opSelect = new Select(dropDown);
		opSelect.selectByVisibleText("Manual Testing");
		Thread.sleep(2000);
		opSelect.selectByValue("Database");
		Thread.sleep(2000);
		opSelect.selectByIndex(0);
		Thread.sleep(2000);
		
		
		
		driver.quit();
	}

}
