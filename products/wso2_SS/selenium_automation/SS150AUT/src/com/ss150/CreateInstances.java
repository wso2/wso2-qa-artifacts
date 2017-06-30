package com.ss150;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateInstances {
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
  public void testCreateInstances() throws Exception {
    driver.get(baseUrl + "/carbon/rssmanager/databasePrivilegeTemplates.jsp?region=region1&item=privilege_groups_submenu&envName=DEFAULT");
    driver.findElement(By.linkText("RSS Instances")).click();
    driver.findElement(By.linkText("Add Server Instance")).click();
    driver.findElement(By.id("serverUrl")).clear();
    driver.findElement(By.id("serverUrl")).sendKeys("jdbc:h2:repository/database/WSO2_RSS_DB");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("wso2carbon");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("wso2carbon");
    driver.findElement(By.id("repassword")).clear();
    driver.findElement(By.id("repassword")).sendKeys("wso2carbon");
    new Select(driver.findElement(By.id("serverEnvironment"))).selectByVisibleText("DEFAULT");
    driver.findElement(By.id("rssInstanceName")).clear();
    driver.findElement(By.id("rssInstanceName")).sendKeys("H@");
    driver.findElement(By.id("rssInstanceName")).clear();
    driver.findElement(By.id("rssInstanceName")).sendKeys("H2Inst");
    driver.findElement(By.id("serverUrl")).clear();
    driver.findElement(By.id("serverUrl")).sendKeys("jdbc:h2:home/repository/database/WSO2_RSS_DB");
    driver.findElement(By.id("serverUrl")).clear();
    driver.findElement(By.id("serverUrl")).sendKeys("jdbc:h2:/home/chaminda/Documents/Testing/SS/mysql/wso2ss-1.5.0-SNAPSHOT23/repository/database/WSO2_RSS_DB");
    driver.findElement(By.xpath("//input[@value='Save']")).click();
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
