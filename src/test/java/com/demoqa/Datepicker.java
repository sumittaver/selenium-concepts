package com.demoqa;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Datepicker extends Base{
	@Test(groups= {"smoke"})
	public void Datepicker_test() {
		driver.findElement(By.linkText("Datepicker")).click();
		Reporter.log("### Selecting date");
		driver.findElement(By.className("hasDatepicker")).click();
		System.out.println("Today is : "+getCurrentDate());
		//String dateStrings=getCurrentDate();
		WebElement calander=driver.findElement(By.className("ui-icon ui-icon-circle-triangle-e"));
		calander.click();
				
		//WebElement calander=driver.findElement(By.className("ui-datepicker-calendar"));
		System.out.println(calander);
		List<WebElement> eList= calander.findElements(By.tagName("td"));
		for (WebElement el:eList) {
			System.out.println(el.getText());
		}
  		
	}
	public LocalDate getCurrentDate() {
		LocalDate i=java.time.LocalDate.now();
		return i; 
	}
}
