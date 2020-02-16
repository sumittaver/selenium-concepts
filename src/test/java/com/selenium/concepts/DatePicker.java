package com.selenium.concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePicker {
	public static WebDriver driver123;
	
	@BeforeTest
	public void setup() {
		String dir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", dir+"/resources/chromedriver.exe");
		driver123=new ChromeDriver();
		driver123.get("https://www.tutorialspoint.com/jqueryui/jqueryui_datepicker.htm");
		driver123.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closing() {
		driver123.quit();
	}
	
	@Test
	public void datePicker() {
		System.out.println(driver123.getCurrentUrl()+driver123.getTitle());
		WebDriverWait wait=new WebDriverWait(driver123, 5);
		try {
			
			List <WebElement> iframeStrings=driver123.findElements(By.tagName("iframe"));
			for (int i=0;i<iframeStrings.size();i++) {

				//driver123.switchTo().frame(driver123.findElement(By.xpath("//iframe[1]")));
				driver123.switchTo().frame(i);
				System.out.println("##Switch frame "+i);
				
				if(driver123.findElement((By.id("datepicker-1")))!=null) {
					System.out.println("##Find..");
				}
				
				
				
				driver123.switchTo().defaultContent();
//				driver123.findElement((By.id("datepicker-1"))).click();
//				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker-1"))).click();
//				System.out.println("## 1 ##");
//				WebElement calander=driver123.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));
//				List<WebElement> calanderDatesElements=calander.findElements(By.tagName("td"));
			}
			
			
			
			
			
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
