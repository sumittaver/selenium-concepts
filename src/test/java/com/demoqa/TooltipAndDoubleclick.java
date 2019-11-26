package com.demoqa;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TooltipAndDoubleclick extends Base{
	@Test(groups= {"smoke"})
	public void TooltipAndDoubleclick() {
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.linkText("Tooltip and Double click")).click();
		
		Reporter.log("Redirecting to section Tooltip and Double click");
		
		WebElement button1 = driver.findElement(By.xpath("//*[contains(text(),'Hello, Double-click me')]"));
		WebElement button2 = driver.findElement(By.id("rightClickBtn"));
		Actions actions = new Actions(driver);
		actions.doubleClick(button1).build().perform();
		
		Reporter.log("Double Clicked the Button");
		
		String expectedPopupString="Hi,You are seeing this message as you have double cliked on the button";
		String popupString=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		softAssert.assertTrue(popupString.contains(expectedPopupString));
		System.out.println("### Popup string matched for double click");
		
		actions.contextClick(button2).build().perform();
		driver.findElement(By.xpath("//*[@class='contextMenuItem' and text()='Export']")).click();
		String textContextClick = driver.switchTo().alert().getText();
		String expectedTextContextClick="You have selected Export";
		driver.switchTo().alert().dismiss();
		softAssert.assertEquals(textContextClick, expectedTextContextClick);
		System.out.println("### Popup string matched for context click");
		
		WebElement tooltip=driver.findElement(By.id("tooltipDemo"));
		actions.moveToElement(tooltip).build().perform();
		String tooltiptext=driver.findElement(By.className("tooltiptext")).getText();
		softAssert.assertEquals(tooltiptext, "We ask for your age only for statistical purposes.");
		System.out.println("### Tooltip string matched");
		
		softAssert.assertAll();
		
	}
}
