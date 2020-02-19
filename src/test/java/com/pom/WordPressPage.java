package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WordPressPage {
	WebDriver driver;
	WordPressPage(WebDriver driver){
		this.driver=driver;
		System.out.println("Constructor created");
	}
//	@FindBy(how=How.XPATH, using = "//*[@id='wpcom-home']")WebElement loginLink;
//	public void logInLink() {
//		loginLink.click();
//		System.out.println("Element clicked");
//	}
	By myElement=By.linkText("Log In");
	public void check() {
		driver.findElement(myElement).click();
	}
}
