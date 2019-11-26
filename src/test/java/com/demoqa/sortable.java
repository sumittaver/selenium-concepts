package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

//import demoqa.base;

public class sortable extends Base{
	@Test(groups= {"smoke"})
	public void sortable() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='sidebar']/aside[1]/ul/li[1]/a")).click();
		WebElement from = driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
		WebElement to = driver.findElement(By.xpath("//*[@id='sortable']/li[7]"));
		System.out.println("Value of the element is "+from);
		System.out.println("Value of the element is "+to);
		Actions action = new Actions(driver);
		action.clickAndHold(from).moveToElement(to).release(from).build().perform();
		
		//action.clickAndHold(from).moveToElement(to).release().build().perform();
		//action.dragAndDrop(from, to).build().perform();
		//act.dragAndDropBy(from,135,50).build().perform();
		Reporter.log("###Sorting done");
	}
	
}
