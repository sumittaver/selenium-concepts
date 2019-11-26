package com.demoqa;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tabs extends Base{
	@Test(groups= {"smoke"})
	public void TabsClick() {
		driver.findElement(By.linkText("Tabs")).click();
		driver.findElement(By.id("ui-id-2")).click();
		String expect = "Morbi tincidunt, dui sit amet facilisis feugiat";
		SoftAssert softAssert = new SoftAssert();
		String actualText=driver.findElement(By.id("tabs-2")).getText();
		softAssert.assertTrue(actualText.contains(expect));
		softAssert.assertAll();
		Reporter.log("### Tab content verified");
	}
}
