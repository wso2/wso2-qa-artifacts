package com.ss150;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class attachUser {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://10.100.5.66:9443/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAttachDbUser() throws Exception {
    driver.get(baseUrl + "/carbon/rssmanager/databaseUsers.jsp?region=region1&item=database_users_submenu&envName=DEFAULT");
    driver.findElement(By.linkText("Databases")).click();
    driver.findElement(By.linkText("Manage")).click();
    driver.findElement(By.linkText("Attach database user")).click();
    new Select(driver.findElement(By.id("databaseUsers"))).selectByVisibleText("testusr");
    new Select(driver.findElement(By.id("privilegeTemplates"))).selectByVisibleText("full");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
