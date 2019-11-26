package com.selenium.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Iframe {
	@Test()
	public void iFrameTest() throws InterruptedException {
		String paString=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",paString+"\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		WebElement ele1=driver.findElement(By.id("cookie_action_close_header"));
		if (ele1.isDisplayed()) {
			driver.findElement(By.id("cookie_action_close_header")).click();
			System.out.println("##Cookie accepted");
		}else {
			System.out.println("##Cookie popup is not available");
		}
		if (driver.getTitle().equals("IFrame practice page")) {
			System.out.println("##Title is matched");
		}else {
			System.out.println("##Failed! Title is not matching, title name is: "+driver.getTitle());
		}
		
		//Switching to frame1
		driver.switchTo().frame("iframe1");
		driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/ul/li[4]/ul/li[4]/a/span/span")).click();
		String st2=driver.getTitle();
		System.out.println("1st Frame title is: "+st2);
		
		//Switching frame directly is not possible first we need to redirect to parent frame.
		driver.switchTo().parentFrame();
		
		//Switching to frame2
		driver.switchTo().frame("iframe2");
		driver.findElement(By.linkText("Droppable")).click();
		String st3=driver.getTitle();
		System.out.println("2nd Frame title is: "+st3);
		Thread.sleep(10000);
		driver.close();
		
		
		/*
		 * 
		 * IF1 
		 * Free Selenium Tutorial | Selenium WebDriver Tutorials | For Beginners 
		 * IF2
		 * Selectable – ToolsQA – Demo Website to Practice Automation
		 */
	}

}
