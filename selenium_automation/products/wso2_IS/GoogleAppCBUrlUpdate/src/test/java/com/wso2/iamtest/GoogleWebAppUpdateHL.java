/**
 * @Author: chaminda@wso2.com
 * @Status: In-progress
 */
package com.wso2.iamtest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleWebAppUpdateHL {
  private WebDriver driver;
  //private HtmlUnitDriver driver;
  private String baseUrl;
  //PhantomJSDriver driver1;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    //driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER, true);
    baseUrl = "https://console.developers.google.com";
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setJavascriptEnabled(true);
      caps.setCapability("takesScreenshot", true);
      caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
              "/Users/cjayawardena/Documents/Testing/workspace_idea/GoogleAppCBUrlUpdate/src/test/resources/phantomjs");
      driver = new  PhantomJSDriver(caps);
      driver.manage().window().maximize();
    //driver.setJavascriptEnabled(true);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Parameters({"username","password","callbackUrl", "clientAppName"})
  @Test
  public void testUntitledTestCase(String username, String password, String callbackUrl, String clientAppName) throws Exception {
      /*WebClient client = new WebClient(BrowserVersion.INTERNET_EXPLORER);
      HtmlPage page = client.getPage(baseUrl+"/");
      page.getHtmlElementById("identifierId").type(username)*/;
      driver.get(baseUrl+"/");
      WebDriverWait wait = new WebDriverWait(driver,20);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
      driver.findElement(By.id("identifierId")).clear();
      driver.findElement(By.id("identifierId")).sendKeys(password);
      System.out.println(driver.switchTo().activeElement().getTagName()+"=============");
      //driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
      //driver.findElement(By.xpath("//div[@id='identifierNext']/content")).click();
    //page.getHtmlElementById("identifierNext").click();
    Actions builder = new Actions(driver);
      WebElement link = driver.findElement(By.xpath("//div[@id='identifierNext']"));
      if(link.isDisplayed()){
          System.out.println("VISBLE-========");
      }


    //driver.switchTo().activeElement().sendKeys(Keys.ENTER);
      System.out.println(driver.switchTo().activeElement().getTagName()+"=============");
      //driver.switchTo().activeElement().submit();

      //builder.moveToElement(link).click().perform();
      builder.moveToElement(link).contextClick().build().perform();
      builder.sendKeys(Keys.ENTER).click().perform();
      builder.release().perform();
      //link.sendKeys(Keys.ENTER);
      Thread.sleep(2000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='headingText']")));
      System.out.println(driver.switchTo().activeElement().getTagName()+"=============");

    //Robot rbt = new Robot();
    //rbt.keyPress(KeyEvent.VK_ENTER);
    //rbt.keyRelease(KeyEvent.VK_ENTER);

    //((JavascriptExecutor)driver).executeScript("document.getElementById('identifierNext').click()");

    //((JavascriptExecutor)driver).executeScript(mouseOverScript, link);
    //((JavascriptExecutor)driver).executeScript(onClickScript, link);
    //JavascriptExecutor executor = (JavascriptExecutor)driver;
    //executor.executeScript("arguments[0].click();", link);
    //executor.executeScript("window.document.getElementById('identifierNext').click()");
    //executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", link);

      //Thread.sleep(3000);
      if(driver.findElement(By.xpath("//h1[@id='headingText']")).getText().equalsIgnoreCase("Welcome")){
          System.out.println("Welcome displayed=====");
          if(driver.findElement(By.xpath("//div[@id='profileIdentifier']")).getText().equalsIgnoreCase(username)){
                System.out.println("email exist========");
          }
      }
    //System.out.print("URL :" + driver.getPageSource().toString());
    PrintWriter out = new PrintWriter("filename.txt");

    //driver.findElement(By.xpath("//span[text()='Next']")).click();
    out.println(driver.getPageSource().toString());
    out.close();
      // out.println(driver.getPageSource().toString());

    //page.getElementByName("password").setTextContent(password);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
     // page.getHtmlElementById("passwordNext").click();
    driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
    driver.findElement(By.xpath("//a[@id='p6ntest-vulcan-leftnav-credentials']/span")).click();
    driver.findElement(By.linkText("Web client 2")).click();
    Thread.sleep(3000);
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.DELETE).perform();
    WebElement elm = driver.switchTo().activeElement();
    elm.sendKeys("http://localhost:8080/selenium");
    builder.sendKeys(Keys.ENTER).perform();
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.ENTER).perform();
    //if(driver.findElement(By.xpath("span[text()='http://localhost:8080/new']")).isDisplayed()){
    // System.out.println("TestValsu===");
    //}
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).click();
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).clear();
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).sendKeys("http://localhost:8080/selenium");
    Thread.sleep(5000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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
