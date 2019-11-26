package com.demoqa;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class KeyboardEventsSampleForm extends Base{
	@Test(groups= {"smoke"})
	public void KeyboardEventsSampleForm() {
		driver.findElement(By.xpath("//*[contains(text(),'Keyboard Events Sample Form')]")).click();
		driver.findElement(By.id("userName")).sendKeys("test name");
		driver.findElement(By.id("currentAddress")).sendKeys("gzb");
		driver.findElement(By.id("permanentAddress")).sendKeys("gzb2ND");
		driver.findElement(By.id("submit")).click();
		
		String popupText = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		
		org.testng.Assert.assertEquals("Expected text 'Thanks for submitting the information' is not found.", "Thanks for submitting the information", popupText);
		Reporter.log("### Sample form submited sucessfully");
		
	}
}
