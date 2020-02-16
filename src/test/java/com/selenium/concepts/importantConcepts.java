package com.selenium.concepts;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class importantConcepts{
	static WebDriver driver;
	@BeforeClass()
	public void webdriverSetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumit\\eclipse-workspace\\Selenium_Concepts\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.w3schools.com/tags/tag_a.asp");
	}
	@AfterClass()
	public void driverTearDown() {
		System.out.println("\n## Closing browser.");
		driver.close();
		driver.quit();
	}
//	
//	@Test(priority = 1)
//	public void contextMenuClick() throws InterruptedException, AWTException {
//		Actions actions=new Actions(driver);
//		WebElement elementBtn=driver.findElement(By.linkText("Try it Yourself »"));
//		Thread.sleep(5000);
//		System.out.println("Finding element");
//		actions.contextClick(elementBtn).perform();
//		System.out.println("Perform left click");
//		Thread.sleep(5000);
//		
//		Robot rbRobot=new Robot();
//		rbRobot.keyPress(KeyEvent.VK_ESCAPE);
//		rbRobot.keyRelease(KeyEvent.VK_ESCAPE);
//		System.out.println("Java Robot event for escape");
//		
//		Thread.sleep(5000);
//	}
//	
//	@Test(priority = 2)
//	public void switchingBetweenTabs() throws InterruptedException{
//		String parentTabId=driver.getWindowHandle();
//		
//		WebElement elementBtn=driver.findElement(By.linkText("Try it Yourself »"));
//		elementBtn.click();
//		
//		Set<String> handels=driver.getWindowHandles();
//		handels.remove(parentTabId);
//		for (String tmp:handels) {
//			driver.switchTo().window(tmp);
//			Thread.sleep(3000);
//			String newPageTitle=driver.getTitle();
//			System.out.println("\n## Page title: "+newPageTitle);
//		}
//		driver.switchTo().window(parentTabId);
//		String parentPageTitle=driver.getTitle();
//		System.out.println("\n## Parent page title: "+parentPageTitle);
//	}
	
	@Test(priority = 3)
	public void switchingFrames() throws InterruptedException {
		System.out.println("\nRedirecting to demo.automationtesting.in");
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		driver.switchTo().frame("singleframe");
		System.out.println("Switching to single frame");
		WebElement input=driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		
		input.sendKeys("XYZ");
		System.out.println("Input xyz");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		System.out.println("Switching on parent.");
		
		
		
		
		
		
		
		WebElement btn1=driver.findElement(By.linkText("Iframe with in an Iframe"));
		btn1.click();
		System.out.println("Clicked to multiple frame button");
		
		driver.switchTo().frame(0);
		System.out.println("Switch frame inside 2nd frame");
		System.out.println("\n## Page source"+driver.getPageSource());
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("123");
		
		Thread.sleep(5000);
	}
}