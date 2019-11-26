package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Droppable extends Base{
	@Test(groups= {"smoke"})
	public void Droppable() throws ElementNotVisibleException, InterruptedException {
		driver.findElement(By.linkText("Droppable")).click();
		Thread.sleep(2000);
		
		WebElement from = driver.findElement(By.xpath("//*[contains(text(),'Drag me to my target')]"));
		WebElement to = driver.findElement(By.xpath("//*[contains(text(),'Drop here')]"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(from, to).build().perform();
		
		Reporter.log("### Droppable done");
	}
}