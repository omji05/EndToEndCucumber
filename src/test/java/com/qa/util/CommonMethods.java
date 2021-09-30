package com.qa.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinitions.CommonSteps;

public class CommonMethods {
	WebDriver driver;
	static Logger logger = Logger.getLogger(CommonMethods.class);

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void waitFor(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error("Exception in Sleep method", e);
		}
	}

	public void clickElement(By locator) {
		WebElement ele = getElementWithWaitUntilClickable(locator);
		int i = 0;
		do {
			try {
				ele.click();
				break;
			} catch (ElementClickInterceptedException e) {
				waitFor(1);
				i++;
				if (i == CommonSteps.globalTimeout) {
					throw e;
				}
			} catch (ElementNotInteractableException e) {
				waitFor(1);
				i++;
				if (i == CommonSteps.globalTimeout) {
					throw e;
				}
			}
		} while (i < CommonSteps.globalTimeout);

	}
	
	public void clickElementWithRetry(By locator) {
		int i = 0;
		WebElement ele=getElementWithWait(locator);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		do {
			try {
				ele.click();
				break;
			}catch (ElementClickInterceptedException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}catch (ElementNotInteractableException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}catch (StaleElementReferenceException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}
		} while(i < CommonSteps.globalTimeout);
		driver.manage().timeouts().implicitlyWait(CommonSteps.globalTimeout, TimeUnit.SECONDS);

	}
	
	public void clickElementWithFocus(By locator) {
		scrollIntoView(locator);
		WebElement element=getElementWithWait(locator);
//		moveToElementToFocus(element);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String elementName=element.getText();
		if(element.isDisplayed()) {
			element.click();
			System.out.println("clicked");
		}
		else {
			System.out.println(elementName+" is not clickable");
		}
	}
	
	public WebElement getElementWithWait(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, CommonSteps.globalTimeout);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}
	
	public WebElement getElementWithoutWait(By locator) {
		WebElement element=null;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		element=driver.findElement(locator);
		driver.manage().timeouts().implicitlyWait(CommonSteps.globalTimeout, TimeUnit.SECONDS);
		return element;
		
	}

	public WebElement getElementWithWaitUntilClickable(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, CommonSteps.globalTimeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}

	public List<WebElement> getElementsWithWait(By locator) {
		List<WebElement> elements = null;
		WebDriverWait wait = new WebDriverWait(driver, CommonSteps.globalTimeout);
		elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return elements;
	}

	
	
	//entering text--internal method--used by entertextinTextbox
	public void enterKeysWithRetry(WebElement ele,String text) {
		int i = 0;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		do {
			try {
				switch (text) {
				case "ENTER_KEY":
					ele.sendKeys(Keys.ENTER);
					return;
				case "TAB_KEY":
					ele.sendKeys(Keys.TAB);
					return;
				}
				ele.sendKeys(text);
				break;
			}catch (ElementClickInterceptedException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}catch (ElementNotInteractableException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}catch (StaleElementReferenceException e) {
				waitFor(1);
				i++;
				if(i==CommonSteps.globalTimeout) {
					throw e;
				}
			}
		} while(i < CommonSteps.globalTimeout);
		driver.manage().timeouts().implicitlyWait(CommonSteps.globalTimeout, TimeUnit.SECONDS);
	}
	
	public void enterTextInTextBox(By locator, String text) {
		WebElement ele = getElementWithWait(locator);
		enterKeysWithRetry(ele,text);
	}
	
	public boolean verifyIfTextIsPresent(By locator, String textToMatch) {
		int i=0;
		Boolean isPresent=true;
		WebElement element = getElementWithWait(locator);
		String text= "abc";
		
		while(i<30 && (!text.equalsIgnoreCase(textToMatch))) {
			try {
				waitFor(1);
				element= getElementWithoutWait(locator);
				text= element.getText().trim();
				i++;
			}
			catch(Exception e) {
				logger.info(e.getMessage());
			}
		}
		if (i==30)
			isPresent=false;
		
		return isPresent;
	}
	
	public boolean verifyIfTextContains(By locator, String textToMatch) {
		int i=0;
		Boolean isPresent=true;
		WebElement element = getElementWithWait(locator);
		String text= "abc";
		
		while(i<30 && (!text.contains(textToMatch))) {
			try {
				waitFor(1);
				element= getElementWithoutWait(locator);
				text= element.getText().trim();
				i++;
			}
			catch(Exception e) {
				logger.info(e.getMessage());
			}
		}
		if (i==30)
			isPresent=false;
		
		return isPresent;
	}
	
	//used in clickElementWithFocus
	public void scrollIntoView(By locator) {
		WebElement element=getElementWithWait(locator);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void moveToElementToFocus(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		System.out.println("moved to element");
	}
	
	public void hoverElement(By locator) {
		WebElement element= getElementWithWait(locator);
		Actions actions=new Actions(driver);
		actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	

}
