package com.qa.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriverFactory {
	
	static Logger logger= Logger.getLogger(LocalDriverFactory.class);
	
	public static WebDriver createInstance(String browsername,int i) {
		WebDriver driver=null;
		
		if (driver==null) {
			if (browsername.toLowerCase().equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chrome"+File.separator+"chromedriver.exe");
			}
			else if(browsername.toLowerCase().equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chrome"+File.separator+"geckodriver.exe");
			}
			else if(browsername.toLowerCase().equalsIgnoreCase("edge"))
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chrome"+File.separator+"edgedriver.exe");
		}
		
		switch(browsername) {
		case "chrome":
//			Copy drivers/chrome/chromedriver to /usr/local/bin/
			
//			 String downloadPath = System.getProperty("user.dir")+File.separator+"downloadFiles";
//			 ChromeOptions cc_options = new ChromeOptions();
//			 HashMap<String, Object> chromePref = new HashMap<>();
//			To Turns off multiple download warning
//			 chromePref.put("profile.default_content_settings.popups", 0);
//			 chromePref.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
//			 chromePref.put("download.default_directory", downloadPath);
//			 cc_options.setExperimentalOption("prefs", chromePref);
//			 driver = new ChromeDriver(cc_options);
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver= new FirefoxDriver();
			break;
		case "edge":
			driver= new EdgeDriver();
			break;
		
		default:
			logger.error("Invalid browser option");
		}
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LocalDriverManager.setWebDriver(driver);
		return driver;
	
	}
	
	public static void closeBrowser() {
		if(LocalDriverManager.getWebDriver()!=null){
//			try{
//				Thread.sleep(2000);
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
			LocalDriverManager.getWebDriver().quit();
		}
	}
	
}
