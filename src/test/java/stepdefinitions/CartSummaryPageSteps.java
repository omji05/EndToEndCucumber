package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pages.CartSummaryPage;
import com.qa.util.CommonMethods;
import com.qa.util.LocalDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSummaryPageSteps {
	
	WebDriver driver;
	CommonMethods objCommonMethods;
	CartSummaryPage objCartSummaryPage;
	
	public CartSummaryPageSteps() {
		driver= LocalDriverManager.getWebDriver();
		objCommonMethods= new CommonMethods(driver);
		objCartSummaryPage= new CartSummaryPage();
	}
	
	
	@Then("user is navigated to {string} page")
	public void user_is_navigated_to_page(String pageName) {
		//Assert.assertTrue(objCommonMethods.verifyIfTextIsPresent(objCartSummaryPage.getPageHeading(), pageName));
	    
	}

	@Then("product {string} is shown in the cart")
	public void product_is_shown_in_the_cart(String productName) {
		Assert.assertTrue(objCommonMethods.verifyIfTextContains(objCartSummaryPage.getInCartProductName(), productName));
	}

	@When("user clicks on Proceed to checkout button on summary page")
	public void user_clicks_on_proceed_to_checkout_button_on_summary_page() {
	    objCommonMethods.clickElementWithFocus(objCartSummaryPage.getProceedToCheckoutButton());
//	    SoftAssert softAssert=new SoftAssert();
//	    softAssert.
	    
	}
	
	

}
