package com.pom;

import java.sql.Driver;

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
	@FindBy(how=How.XPATH, using = "//*[@id='wpcom-home']")WebElement loginLink;
	public void logInLink() {
		loginLink.click();
		System.out.println("Element clicked");
	}

}
