package appHooks;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigReader;
import com.qa.util.LocalDriverFactory;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import stepdefinitions.CommonSteps;

public class ApplicationHooks {
	
	public ConfigReader configReader;
	public  Properties prop;
	private WebDriver driver;
	//CommonMethods objCommonMethods;
	CommonSteps objCommonSteps;
	
	static Logger logger= Logger.getLogger(LocalDriverFactory.class);
	
	
	@Before(order=0)
	public void readProperties() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}
	
	@Before(order=1)
	public void launchBrowser(Scenario scenario) {
		String browsername=prop.getProperty("browser");
//		int timeout=new Integer(prop.getProperty("timeout"));
//		Long timeout=Long.parseLong(prop.getProperty("timeout"));
		driver=LocalDriverFactory.createInstance(browsername, 30);
		objCommonSteps= new CommonSteps(driver,prop);
		//objCommonMethods=new CommonMethods(driver);
		logger.info("Browser opened for scenario "+ scenario.getName());
	}

}
