package com.ss150.test;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ss150.util.UtilClass;

/**
 * @Prerequisites Use fresh pack for smoke test since some of tests are not so
 *                smart to run with any setup; existing data on UI, may
 *                interrupt tests. Make sure necessary db driver lib(for mysql, mssql, etc) is there in ../repository/components/lib/
 * @category TestCase_01
 * @Description Use for a smoke test of WSO2 Storage Server 1.5.0
 * @author Chaminda Jayawardena
 * TODO add more UI validations on all method/test for a complete test coverage.
 */
public class SS_150_SmokeTest extends UtilClass {

	private WebDriver driver;
	private String baseUrl;

	@Parameters({ "baseUrl" , "browser_code"})
	@BeforeTest
	public void setUp(String base_Url, String browserCode) throws Exception {
		//driver = new FirefoxDriver();
		driver = setupDriver(browserCode, driver);
		baseUrl = base_Url;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameters({ "carbon_user", "carbon_pass" })
	@Test
	public void testLogin(String username, String password) throws Exception {
		openPagebyUrl(driver, baseUrl, "/carbon/admin/login.jsp");
		typeTextBoxByID(driver, "txtUserName", username);
		typeTextBoxByID(driver, "txtPassword", password);
		clickButtonByXpath(driver, "//input[@value='Sign-in']");
		verfiyPageTitle(driver, "WSO2 Management Console");
		verifyTextPresent(driver, "logged-user", "Signed-in as: " + username
				+ "@carbon.super");
		/*
		 * for (int second = 0;; second++) { if (second >= 60) fail("timeout");
		 * try { if
		 * ("Welcome to the WSO2 Storage Server Management Console".equals
		 * (driver.findElement(By.cssSelector("p")).getText())) break; } catch
		 * (Exception e) {} Thread.sleep(1000); }
		 */
	}

	@Parameters({ "tmplt_name_admin", "tmplt_name_user" })
	@Test(dependsOnMethods = { "testLogin" })
	public void testCreatePriviTemplate(String tmplt_name_admin,
			String tmplt_name_user) throws Exception {
		openPagebyUrl(
				driver,
				baseUrl,
				"/carbon/rssmanager/databasePrivilegeTemplates.jsp?region=region1&item=privilege_groups_submenu");
		clickLinkByText(driver, "Privilege Templates");
		clickLinkByText(driver, "Add Database Privilege Template");
		typeTextBoxByID(driver, "privilegeTemplateName", tmplt_name_admin);
		clickElementsByID(driver, "selectAll");
		clickButtonByValue(driver, "Save");
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");

		clickLinkByText(driver, "Add Database Privilege Template");
		typeTextBoxByID(driver, "privilegeTemplateName", tmplt_name_user);

		clickElementsByID(driver, "select_priv");
		clickElementsByID(driver, "insert_priv");
		clickElementsByID(driver, "update_priv");
		clickElementsByID(driver, "delete_priv");
		clickElementsByID(driver, "create_priv");
		clickElementsByID(driver, "execute_priv");
		clickButtonByValue(driver, "Save");
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");
		verifyTableData(driver, "privilegeTemplateTable", 1, 1, tmplt_name_admin);
	}

	@Parameters({"user_name","user_password"})
	@Test(dependsOnMethods = { "testCreatePriviTemplate" })
	public void testCreateUser(String username, String password) throws Exception {

		openPagebyUrl(
				driver,
				baseUrl,
				"/carbon/rssmanager/databaseUsers.jsp?region=region1&item=database_users_submenu");
		clickLinkByText(driver, "Database Users");
		clickLinkByText(driver, "Add Database User");
		typeTextBoxByID(driver, "username", username);
		typeTextBoxByID(driver, "password", password);
		typeTextBoxByID(driver, "repeatPassword", password);
		clickButtonByValue(driver, "Save");
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");
		verifyTableData(driver, "databaseUserTable", 1, 1, username);
	}

	@Parameters({"db_name"})
	@Test(dependsOnMethods = { "testCreateUser" })
	public void testCreateDbOnSysEnv(String dbname) throws Exception {
		openPagebyUrl(driver, baseUrl,
				"/carbon/rssmanager/rssInstances.jsp?ordinal=1");
		clickLinkByText(driver, "Databases");
		clickLinkByText(driver, "Add Database");
		typeTextBoxByID(driver, "databaseName", dbname);
		clickButtonByValue(driver, "Save");
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");
		verifyTableData(driver, "databaseUserTable", 1, 1, dbname);
	}

	@Parameters({"instance_name","instance_type","environment","server_url","driver_class","db_username","db_password"})
	@Test(dependsOnMethods = { "testCreateDbOnSysEnv" })
	public void testCreateInstances(String instName, String instType,String env, String svrUrl, String drivClass, String dbUser, String dbPass) throws Exception {
		openPagebyUrl(
				driver,
				baseUrl,
				"/carbon/rssmanager/databasePrivilegeTemplates.jsp?region=region1&item=privilege_groups_submenu&envName=DEFAULT");
		clickLinkByText(driver, "RSS Instances");
		clickLinkByText(driver, "Add Server Instance");
		typeTextBoxByID(driver, "rssInstanceName", instName);
		selectComboItem(driver, "serverEnvironment", env);
		selectComboItem(driver, "instancetype", instType);
		typeTextBoxByID(driver, "serverUrl", svrUrl);
		typeTextBoxByID(driver, "dataSourceClassName", drivClass);
		typeTextBoxByID(driver, "username", dbUser);
		typeTextBoxByID(driver, "password", dbPass);
		typeTextBoxByID(driver, "repassword", dbPass);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");
		verifyTableData(driver, "instanceTable", 2, 1, instName);
	}

	@Parameters({"user_name","instance_name", "tmplt_name_admin"})
	@Test(dependsOnMethods = { "testCreateInstances" })
	public void testAttachDbUser(String user, String instance) throws Exception {
		openPagebyUrl(
				driver,
				baseUrl,
				"/carbon/rssmanager/databaseUsers.jsp?region=region1&item=database_users_submenu&envName=DEFAULT");
		clickLinkByText(driver, "Databases");
		clickLinkByText(driver, "Manage");
		clickLinkByText(driver, "Attach database user");
		selectComboItem(driver, "databaseUsers", user);
		selectComboItem(driver, "privilegeTemplates", "Admin");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		waitForAlertOPopUp(driver, "ui-dialog-title-dialog", 40);
		clickButtonByXpath(driver, "//button[text()='OK']");
		verifyTableData(driver, "databaseUserTable", 2, 1, instance);
	}

	public void testDeleteUser(){
		//TODO implement delete user here.
	}
	
	public void testDeleteDatabase(){
		//TODO implement delete database here.
	}
	public void testDeleteInstance(){
		//TODO implement delete instance here.
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
