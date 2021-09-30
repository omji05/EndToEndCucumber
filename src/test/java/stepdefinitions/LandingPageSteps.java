package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.LandingPage;
import com.qa.util.CommonMethods;
import com.qa.util.LocalDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageSteps {
	WebDriver driver;
	CommonMethods objCommonMethods;
	LandingPage objLandingPage;
	
	public LandingPageSteps() {
		driver=LocalDriverManager.getWebDriver();
		objCommonMethods= new CommonMethods(driver);
		objLandingPage=new LandingPage();
	}
	
	
	@Given("user click on the Sign in button")
	public void user_click_on_the_sign_in_button() {
	    objCommonMethods.clickElementWithRetry(objLandingPage.getSignInButton());
	}
	
	

	
	

}
