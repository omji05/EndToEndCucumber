package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
//	not sure if we should use driver here
//	public LandingPage(WebDriver driver) {
//		
//	}

	By signInButton = By.xpath("//a[@class='login']");

	public By getSignInButton() {
		return signInButton;
	}

}
