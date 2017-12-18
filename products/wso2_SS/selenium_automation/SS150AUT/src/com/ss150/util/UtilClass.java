package com.ss150.util;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UtilClass {

	private boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();

	public void readXMLProperties() {

	}
	/**
	 * Use to setup and return relevant driver to handle the browser
	 * @param browserCode
	 * @param driv
	 * @return
	 */
	public WebDriver setupDriver(String browserCode, WebDriver driv) {
		if (browserCode.equalsIgnoreCase("FF")) {
			driv = new FirefoxDriver();
			return driv;
		} else if (browserCode.equalsIgnoreCase("IE")) {
			driv = new InternetExplorerDriver();
			return driv;
		} else if (browserCode.equalsIgnoreCase("GC")) {
			driv = new ChromeDriver();
			return driv;
		}
		return null;
	}

	/**
	 * use to open a page
	 * 
	 * @param driv
	 * @param baseUrl
	 * @param pageUrl
	 */
	public void openPagebyUrl(WebDriver driv, String baseUrl, String pageUrl) {
		driv.get(baseUrl + pageUrl);
	}

	/**
	 * Use to verify page title.
	 * 
	 * @param driv
	 * @param expectedTitle
	 */
	public void verfiyPageTitle(WebDriver driv, String expectedTitle) {
		try {
			Assert.assertEquals(expectedTitle, driv.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	}

	/**
	 * Use to verify label, appeared in UI
	 * 
	 * @param driv
	 * @param elementID
	 * @param textLabel
	 */
	public void verifyTextPresent(WebDriver driv, String elementID,
			String textLabel) {
		Assert.assertEquals(driv.findElement(By.id(elementID)).getText(),
				textLabel);
	}

	/**
	 * @Discription use this to type on text-fields using element id
	 * @param driv
	 * @param elementID
	 * @param textToType
	 */
	public void typeTextBoxByID(WebDriver driv, String elementID,
			String textToType) {
		driv.findElement(By.id(elementID)).clear();
		driv.findElement(By.id(elementID)).sendKeys(textToType);
	}

	/**
	 * Use this to click button by value
	 * 
	 * @param driv
	 * @param value
	 */
	public void clickButtonByValue(WebDriver driv, String value) {
		driv.findElement(By.cssSelector("input[value='" + value + "']"))
				.click();
	}

	/**
	 * @Discription use this to click buttons by provided xpath
	 * @param driv
	 * @param xpath
	 */
	public void clickButtonByXpath(WebDriver driv, String xpath) {
		driv.findElement(By.xpath(xpath)).click();
	}

	/***
	 * @Discription Use this to click on links using link text
	 * @param driv
	 * @param linkText
	 */
	public void clickLinkByText(WebDriver driv, String linkText) {
		driv.findElement(By.linkText(linkText)).click();
	}

	/***
	 * 
	 * @Discription Use this to click on any element; Ex:- Buttons, Links,
	 *              Check-boxes, etc.
	 */
	public void clickElementsByID(WebDriver driv, String elementID) {
		driv.findElement(By.id(elementID)).click();
	}

	/**
	 * Use this to wait until text present.
	 * 
	 * @param waitForText
	 * @param cssSelector
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void waitForTextByCssSelector(String waitForText,
			String cssSelector, int timeout, WebDriver driv)
			throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= timeout)
				fail("timeout-couldn't find element: " + cssSelector);
			try {
				if (waitForText.equals(driv.findElement(
						By.cssSelector(cssSelector)).getText()))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	/**
	 * @Description Use to wait for alert/pop ups.
	 * @param idPopUp
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void waitForAlertOPopUp(WebDriver driv, String idPopUp, int timeout)
			throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= timeout)
				fail("Sory couldn't find alert, timeout after " + second + "s.");
			try {
				if (isElementPresent(By.id(idPopUp), driv))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

	}

	/**
	 * Use to select combo_box options
	 * 
	 * @param driv
	 * @param comboID
	 * @param selectOption
	 */
	public void selectComboItem(WebDriver driv, String comboID,
			String selectOption) {
		new Select(driv.findElement(By.id(comboID)))
				.selectByVisibleText(selectOption);
	}

	/**
	 * Use to verify single cell data in a table
	 * 
	 * @param driv
	 * @param tableID
	 * @param trValue
	 * @param tdValue
	 * @param expectedValue
	 */
	public void verifyTableData(WebDriver driv, String tableID, int trValue,
			int tdValue, String expectedValue) {
		try {
			Assert.assertEquals(
					expectedValue,
					driv.findElement(
							By.xpath("//table[@id='" + tableID + "']/tbody/tr["
									+ trValue + "]/td[" + tdValue + "]"))
							.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public boolean isElementPresent(By by, WebDriver driv) {
		try {
			driv.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent(WebDriver driv) {
		try {
			driv.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * Use to accept alerts and return it's text.
	 * @param driv
	 * @return
	 */
	public String closeAlertAndGetItsText(WebDriver driv) {
		try {
			Alert alert = driv.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}
