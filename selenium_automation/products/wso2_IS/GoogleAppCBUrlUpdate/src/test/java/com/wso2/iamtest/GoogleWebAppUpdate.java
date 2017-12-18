/**
 *
 * @Author: chaminda@wso2.com
 */
package com.wso2.iamtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class GoogleWebAppUpdate {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //System.setProperty("webdriver.gecko.driver", "/src/test/resources/geckodriver");
    //System.setProperty("webdriver.firefox.marionette","/src/test/resources/geckodriver");
    //set system property webdriver.chrome.driver for the browser's driver location.
    System.setProperty("webdriver.chrome.driver", "/Users/cjayawardena/Documents/Testing/workspace_idea/GoogleAppCBUrlUpdate/src/test/resources/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://console.developers.google.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Parameters({"username","password","callbackUrl", "clientAppName"})
  @Test
  public void testUpdateCallBackUrl(String username, String password, String callbackUrl, String clientAppName) throws Exception {
    driver.get(baseUrl+"/");
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(username);

    WebElement link = driver.findElement(By.id("identifierId"));
    Actions builder = new Actions(driver);
    builder.moveToElement(link).click().perform();
    builder.sendKeys(Keys.ENTER).perform();
    builder.release().perform();
    Thread.sleep(3000);
    //enter password
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    //click on Next button
    driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
    //go to credentials sections
    driver.findElement(By.xpath("//a[@id='p6ntest-vulcan-leftnav-credentials']/span")).click();
    Thread.sleep(3000);
    //click on existing client app
    driver.findElement(By.linkText(clientAppName)).click();
    //move to existing callback url field using tab key
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.TAB).perform();
    //delete existing url
    builder.sendKeys(Keys.DELETE).perform();
    //get the element locator of callback url
    WebElement elm = driver.switchTo().activeElement();
    //insert new callback url
    elm.sendKeys(callbackUrl);
    builder.sendKeys(Keys.ENTER).perform();
    //move to Save button and save.
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.ENTER).perform();
    Thread.sleep(3000);
    if(driver.findElement(By.xpath("//h3[text()='OAuth 2.0 client IDs']")).isDisplayed()){
      System.out.println("Update Done...");
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
