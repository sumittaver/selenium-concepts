package com.selenium.concepts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class MultiTab {
	public static void main(String[] args) throws InterruptedException {
		String urlString="https://www.toolsqa.com/automation-practice-switch-windows/";
		File file=new File("C:\\Users\\poonam\\eclipse-workspace\\SeleniumTest\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		WebDriver driver;
		driver=new ChromeDriver();
		driver.get(urlString);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		String parentWindowIdString=driver.getWindowHandle();
		System.out.println("Parent window id is: "+parentWindowIdString);
		
		Actions action = new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/div/div/div/div/p[5]/button"));
		action.moveToElement(element).build().perform();
		
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,200)");
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[1]/div[2]/div/div/div/div/p[5]/button")));
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]/div"
				+ "/div/div/div/p[5]/button")).click();
		
		ArrayList <String> otherTaList=new ArrayList<String>(driver.getWindowHandles());
		for (String st:otherTaList) {
			System.out.println("List items: "+st);
		}
		
		driver.switchTo().window(otherTaList.get(1));
		Thread.sleep(3000);
		
		String newPageTitleString=driver.getTitle();
		if (newPageTitleString.equals("Free QA Automation Tools Tutorial for Beginners with Examples")) {
			System.out.println("New page title is correct.");
		}else {System.out.println("Title is missmatch.");}
		driver.switchTo().window(parentWindowIdString);
		Thread.sleep(10000);
		driver.quit();
	}
}
