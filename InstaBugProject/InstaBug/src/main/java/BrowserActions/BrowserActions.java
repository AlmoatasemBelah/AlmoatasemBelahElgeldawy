package BrowserActions;


import Drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserActions {
	public static String elementValue;


	public static void newDriver(String browserType){
		DriverSingleton.setDriver(browserType);
	}


	public static void closeDriver(){
		getDriver().close();
		getDriver().quit();
	}

	public static WebDriver getDriver() {
		return DriverSingleton.getDriver();
	}


	public static void navigate(String url) {
		System.out.println("in Navigate , trying to navigate to " + url);
		getDriver().get(url);
	}

	public static void refresh() {
		getDriver().navigate().refresh();
	}

	public static void click(String IdentifierType, String IdentifierValue) {
		WebElement Elementidentifier = elementCreator(IdentifierType, IdentifierValue);
		Elementidentifier.click();
	}

	public static void clear(String IdentifierType, String IdentifierValue) {
			WebElement Elementidentifier = elementCreator(IdentifierType, IdentifierValue);
			Elementidentifier.clear();
	}


	public static void setValue(String IdentifierType, String IdentifierValue, String Value){
		WebElement Elementidentifier = elementCreator(IdentifierType, IdentifierValue);
		Elementidentifier.clear();
		Elementidentifier.sendKeys(Value);
	}

	public static String getText(String value){
	return getDriver().findElement(By.xpath(value)).getText();
	}

	public static void wait(int waitValue) {
		getDriver().manage().timeouts().implicitlyWait(waitValue, TimeUnit.SECONDS);
	}

	public static void closeBrowser() {
		getDriver().close();
	}
	public static void quitBrowser() {
		getDriver().quit();
	}

	public static void maximize() {
		getDriver().manage().window().maximize();
	}

	public static Boolean elementPresent(String value){
		return getDriver().findElement(By.id(value)).isDisplayed();
		}

	public static String urlToBe(){
		return getDriver().getCurrentUrl();
	}

	public static boolean isElementPresent(String IdentifierType, String IdentifierValue) {
		// boolean displayed = false;
		try {
			WebElement Elementidentifier = elementCreator(IdentifierType, IdentifierValue);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static String getElementValue(String IdentifierType, String IdentifierValue) {
		WebElement Elementidentifier = elementCreator(IdentifierType, IdentifierValue);
		elementValue = Elementidentifier.getAttribute("value");
		return elementValue;
	}

	public static WebElement elementCreator(String IdentifierType, String IdentifierValue) {
		WebElement identifier = null;
		if (IdentifierType.equalsIgnoreCase("Id")) {
			identifier = getDriver().findElement(By.id(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("css")) {
			identifier = getDriver().findElement(By.cssSelector(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("xPath")) {
			identifier = getDriver().findElement(By.xpath(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("className")) {
			identifier = getDriver().findElement(By.className(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("linkText")) {
			identifier = getDriver().findElement(By.linkText(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("Name")) {
			identifier = getDriver().findElement(By.name(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("partialLinkText")) {
			identifier = getDriver().findElement(By.partialLinkText(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("tagName")) {
			identifier = getDriver().findElement(By.tagName(IdentifierValue));
		}
		return identifier;
	}

	public static List<WebElement> elementsListCreator(String IdentifierType, String IdentifierValue) {
		List<WebElement> identifier = null;
		if (IdentifierType.equalsIgnoreCase("Id")) {
			identifier = getDriver().findElements(By.id(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("css")) {
			identifier = getDriver().findElements(By.cssSelector(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("xPath")) {
			identifier = getDriver().findElements(By.xpath(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("className")) {
			identifier = getDriver().findElements(By.className(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("linkText")) {
			identifier = getDriver().findElements(By.linkText(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("Name")) {
			identifier = getDriver().findElements(By.name(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("partialLinkText")) {
			identifier = getDriver().findElements(By.partialLinkText(IdentifierValue));
		} else if (IdentifierType.equalsIgnoreCase("tagName")) {
			identifier = getDriver().findElements(By.tagName(IdentifierValue));
		}
		return identifier;
	}
}