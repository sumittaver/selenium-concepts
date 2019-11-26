package com.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class slider extends Base{
	@Test(groups= {"smoke"})
	public void slider_meeter() throws InterruptedException {
		driver.findElement(By.linkText("Slider")).click();
		WebElement slider= driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(300, 0).build().perform();
		//Thread.sleep(2000);
		String st1=slider.getCssValue("left");
		System.out.println("Slider is slided "+st1);
		org.testng.Assert.assertFalse(st1.contains("0"));
	}
}
