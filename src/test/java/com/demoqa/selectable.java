package com.demoqa;

import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class selectable extends Base{
	
	@Test(groups= {""})
	public void selectable() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(By.linkText("Selectable")).click();
		WebElement selection1 = driver.findElement(By.xpath("//*[@id='selectable']/li[2]"));
		WebElement selection3 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		
		action.sendKeys(Keys.COMMAND).click(selection1).click(selection3).build().perform();
		action.sendKeys(Keys.COMMAND).release().build().perform();
		
	}
}
