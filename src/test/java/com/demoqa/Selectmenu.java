package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Selectmenu extends Base{
	@Test(groups= {"smoke"})
	public void Select_menu () throws InterruptedException {
		driver.findElement(By.linkText("Selectmenu")).click();
		WebElement element_speed = driver.findElement(By.id("speed-button"));
		WebElement element_file = driver.findElement(By.id("files-button"));
		WebElement element_num = driver.findElement(By.id("number-button"));
		WebElement element_title = driver.findElement(By.id("salutation-button"));
		element_speed.click();
		driver.findElement(By.id("ui-id-4")).click();
		element_file.click();
		driver.findElement(By.id("ui-id-8")).click();
		element_num.click();
		driver.findElement(By.id("ui-id-21")).click();
		element_title.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='salutation']/option[4]"))).click();
		
	} 
}