package com.pages;

import org.openqa.selenium.By;

public class CartSummaryPage {
	
	By pageHeading = By.xpath("//h1[@id='cart_title']");
	By InCartProductName = By.xpath("//td[@class='cart_description']//p[@class='product-name']/a");
	By proceedToCheckoutButton = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
	
	
	public By getPageHeading() {
		return pageHeading;
	}
	public By getInCartProductName() {
		return InCartProductName;
	}
	public By getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}
	
	
	

}
