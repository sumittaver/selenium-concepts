package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.awt.Desktop.Action;

public class Resizable extends Base{
	
	@Test(groups= {"smoke"})
	public void resizable() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement resize = driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[3]/a"));
		wait.until(ExpectedConditions.visibilityOf(resize));
		resize.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resizable']/div[3]")));
		WebElement element = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(element).moveByOffset(200, 300).build().perform();
		Thread.sleep(2000);
		
		act.clickAndHold(element).moveByOffset(300, 300).build().perform();
		
		Reporter.log("###Resizing done");
	}
}
