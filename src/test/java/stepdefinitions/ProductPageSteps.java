package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.ProductPage;
import com.qa.util.CommonMethods;
import com.qa.util.LocalDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {
	
	WebDriver driver;
	CommonMethods objCommonMethods;
	ProductPage objProductPage;
	
	public ProductPageSteps() {
		driver=LocalDriverManager.getWebDriver();
		objCommonMethods= new CommonMethods(driver);
		objProductPage = new ProductPage();
		
	}
	
	
	
	@Then("User is navigated to {string} products page")
	public void user_is_navigated_to_products_page(String category) {
		Boolean isPresent = objCommonMethods.verifyIfTextIsPresent(objProductPage.getCategoryName(), category);
	    Assert.assertTrue(isPresent);
	}

	@When("user adds {string} product to cart")
	public void user_adds_product_to_cart(String product) {
		objCommonMethods.hoverElement(objProductPage.getSelectProductName());
		objCommonMethods.hoverElement(objProductPage.getSelectProductAddToCartButton());
	    objCommonMethods.clickElement(objProductPage.getSelectProductAddToCartButton());
	}

	@Then("product {string} is added with message {string}")
	public void product_is_added_with_message(String productName, String successMessage) {
		Assert.assertTrue(objCommonMethods.verifyIfTextIsPresent(objProductPage.getAddedProductName(), productName));
		Assert.assertTrue(objCommonMethods.verifyIfTextIsPresent(objProductPage.getAddSuccessfulMessage(), successMessage));
	}

	@When("user clicks on Proceed to Checkout button")
	public void user_clicks_on_proceed_to_checkout_button() {
	    objCommonMethods.clickElement(objProductPage.getProceedToCheckoutButtton());
	}

}
