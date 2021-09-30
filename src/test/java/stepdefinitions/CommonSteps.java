package stepdefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.util.CommonMethods;
import com.qa.util.ConfigReader;
import com.qa.util.LocalDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps {
	
	WebDriver driver;
	CommonMethods objcommonMethods;
	private Properties prop;
	public ConfigReader configReader;
	
	public static int globalTimeout=30;
	
	static Logger logger = Logger.getLogger(CommonMethods.class);
	
	public CommonSteps() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		objcommonMethods=new CommonMethods(driver);
		driver=LocalDriverManager.getWebDriver();
	}
	
	public CommonSteps(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		objcommonMethods=new CommonMethods(driver);
	}
	
	@Given("user navigates to the your logo website")
	public void user_navigates_to_the_your_logo_website() {
		driver.get(prop.getProperty("url"));
		logger.info("User is navigated to the website");
			    
	}
	
	@Then("user in on the your logo landing page")
	public void user_in_on_the_your_logo_landing_page() {
	   Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php");
	   
	}

}
