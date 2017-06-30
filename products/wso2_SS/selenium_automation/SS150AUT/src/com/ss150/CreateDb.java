package com.ss150;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDb {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://10.100.5.66:9443/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateDb() throws Exception {
    driver.get(baseUrl + "/carbon/rssmanager/rssInstances.jsp?ordinal=1");
    driver.findElement(By.linkText("Databases")).click();
    driver.findElement(By.linkText("Add Database")).click();
    driver.findElement(By.id("databaseName")).clear();
    driver.findElement(By.id("databaseName")).sendKeys("testrssdb1");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("testrssdb1".equals(driver.findElement(By.cssSelector("#tr_SYSTEM_testrssdb1 > td")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
