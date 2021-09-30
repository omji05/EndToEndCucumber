package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.util.CommonMethods;
import com.qa.util.LocalDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	WebDriver driver;
	CommonMethods objCommonMethods;
	LoginPage objLoginPage;
	
	
	public LoginPageSteps() {
		driver=LocalDriverManager.getWebDriver();
		objCommonMethods=new CommonMethods(driver);
		objLoginPage=new LoginPage();
	}
	
	@Given("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
	    Assert.assertEquals(driver.getTitle(), "Login - My Store");
	}

	@When("user enters {string} in username field")
	public void user_enter_s_in_username_field(String username) {
	    objCommonMethods.enterTextInTextBox(objLoginPage.getEmail(), username);
	}

	@When("enters {string} in password field")
	public void enters_in_password_field(String password) {
		 objCommonMethods.enterTextInTextBox(objLoginPage.getPassword(), password);
	}

	@When("clicks on Sign in button")
	public void clicks_on_sign_in_button() {
	   objCommonMethods.clickElement(objLoginPage.getSubmitButton());
	}

	@Then("user is successfully signed in with name {string}")
	public void user_is_successfully_signed_in_iwth_name(String name) {
	   Boolean value = objCommonMethods.verifyIfTextIsPresent(objLoginPage.getLoggedInAccountName(), name);
	   Assert.assertTrue(value);
	}
	
	@When("user clicks on Women tab")
	public void user_clicks_on_women_tab() {
	   objCommonMethods.clickElement(objLoginPage.getWomenTabLink());
	}

}
