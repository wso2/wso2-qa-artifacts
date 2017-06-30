package com.ss150;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateUser {
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
  public void testCreateUser() throws Exception {
    driver.get(baseUrl + "/carbon/rssmanager/databaseUsers.jsp?region=region1&item=database_users_submenu");
    driver.findElement(By.linkText("Database Users")).click();
    driver.findElement(By.linkText("Add Database User")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("testusr");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("test");
    driver.findElement(By.id("repeatPassword")).clear();
    driver.findElement(By.id("repeatPassword")).sendKeys("test");
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.cssSelector("button[type=\"button\"]")).click();
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
