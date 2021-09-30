package com.pages;

import org.openqa.selenium.By;

public class ProductPage {
	
	By categoryName = By.xpath("//span[@class='cat-name']");
	By productList = By.xpath("//ul[contains(@class,'product_list')]/li");
	By selectProductName =By.xpath("//a[@title='Printed Dress']");
	By selectProductAddToCartButton =By.xpath("//a[@class='product-name' and @title='Printed Dress']/../following-sibling::div[@class='button-container']/a[@title='Add to cart']");
	By addSuccessfulMessage = By.xpath("//span[@title='Close window']/following-sibling::h2");
	By proceedToCheckoutButtton = By.xpath("//a[@title='Proceed to checkout']");
	By addedProductName = By.xpath("//span[@id='layer_cart_product_title']");

	public By getCategoryName() {
		return categoryName;
	}

	public By getProductList() {
		return productList;
	}

	public By getProceedToCheckoutButtton() {
		return proceedToCheckoutButtton;
	}

	public By getAddSuccessfulMessage() {
		return addSuccessfulMessage;
	}

	public By getSelectProductAddToCartButton() {
		return selectProductAddToCartButton;
	}
	
	public By getAddedProductName() {
		return addedProductName;
	}

	public By getSelectProductName() {
		return selectProductName;
	}
	
	

}
