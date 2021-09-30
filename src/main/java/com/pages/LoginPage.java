package com.pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	By alreadySignIn = By.xpath("//form[@id='login_form']//h3[text()='Already registered?']");
	By email = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='passwd']");
	By submitButton = By.xpath("//button[@id='SubmitLogin']");
	By womenTabLink= By.xpath("//a[text()='Women']");
	By loggedInAccountName= By.xpath("//a[@class='account']");
	

	public By getLoggedInAccountName() {
		return loggedInAccountName;
	}

	public By getAlreadySignInField() {
		return alreadySignIn;
	}

	public By getEmail() {
		return email;
	}

	public By getPassword() {
		return password;
	}

	public By getSubmitButton() {
		return submitButton;
	}
	
	public By getWomenTabLink() {
		return womenTabLink;
	}

}
