/*
 * Copyright 2004 ThoughtWorks, Inc. Licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.thoughtworks.selenium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

/**
 * Provides a base class that implements some handy functionality for Selenium
 * testing (you are <i>not</i> required to extend this class).
 */
public class SeleneseTestBaseVir {

    /** The Constant THIS_IS_WINDOWS. */
    private static final boolean THIS_IS_WINDOWS = ";"
            .equals(File.pathSeparator);

    /** The capture screen shot on failure. */
    private boolean captureScreenShotOnFailure = false;

    /** Test case faliure status. */
    private static boolean testCaseFailStatus;

    /** The driver. */
    private WebDriver driver = null;

    /** The browser string. */
    private static String browserString;

    /** The web driver capabilities. */
    private static DesiredCapabilities webDriverCapabilities;

    /** The selenium instances. */
    private Map<String, WebDriver> seleniumInstances =
            new HashMap<String, WebDriver>();

    /** The selenium instance name. */
    private String seleniumInstanceName = "";

    /** The default profile. */
    private static FirefoxProfile defaultProfile;

    /** The log. */
    private static Logger log;

    /** The database instances. */
    private Map<String, Connection> databaseInstances =
            new HashMap<String, Connection>();
    
    /** The database instances. */
    private Map<String, ODatabaseDocumentTx> orientDatabaseInstances =
            new HashMap<String, ODatabaseDocumentTx>();

    /** The verification errors. */
    private StringBuffer verificationErrors = new StringBuffer();
    
    /** Stores the time taken to each command. */
    private static String logTimeCSVFileBuilder = "";

    /**
     * Initialize the logger.
     * */
    public final void initLogger() {
        PropertyConfigurator.configure("log4j.properties");
    }

    /**
     * Get the logger for each corresponding class.
     *
     * @param clz the clz
     *
     */
    public final void getLogger(final Class< ? > clz) {
        setLog(Logger.getLogger(clz));
    }

    /**
     * Runtime browser string.
     * 
     * @return the string
     */
    protected final String runtimeBrowserString() {
        String defaultBrowser = System.getProperty("selenium.defaultBrowser");
        if (defaultBrowser == null) {
            if (THIS_IS_WINDOWS) {
                defaultBrowser = "*iexplore";
            } else {
                defaultBrowser = "*firefox";
            }
        }
        return defaultBrowser;
    }

    /**
     * Creates a new DefaultSelenium object and starts it using the specified
     * baseUrl and browser string. The port is selected as follows: if the
     * server package's RemoteControlConfiguration class is on the classpath,
     * that class' default port is used. Otherwise, if the "server.port" system
     * property is specified, that is used - failing that, the default of 4444
     * is used.
     * 
     * @param url
     *            the baseUrl for your tests
     * @param browserName
     *            the browser to use, e.g. *firefox
     * @throws Exception
     *             the exception
     * @see #setUp(String, String, int)
     */
    public final void setUp(final String url, final String browserName)
            throws Exception {

        setUp(url, browserName, getDefaultPort());
    }

    /**
     * Gets the default port.
     * 
     * @return the default port
     */
    private int getDefaultPort() {
        final int num = 4444;
        try {
            Class< ? > c =
                    Class.forName("org.openqa.selenium.server.RemoteControlConfiguration");
            Method getDefaultPort = c.getMethod("getDefaultPort", new Class[0]);
            Integer portNumber =
                    (Integer) getDefaultPort.invoke(null, new Object[0]);
            return portNumber.intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return Integer.getInteger("selenium.port", num).intValue();
    }

    /**
     * Sets the up.
     * 
     * @param address
     *            the url
     * @param browserName
     *            the browser string
     * @param port
     *            the port
     */
    public final void setUp(final String address, final String browserName,
            final int port) {

        this.configWebDriver(browserName);
    }

    /**
     * Sets the up.
     * 
     * @param instanceName
     *            the instance name
     * @param browserName
     *            the browser string
     * @param serverConfig
     *            the server config
     */
    public final void setUp(final String instanceName,
            final String browserName, final String serverConfig) {

        this.configWebDriver(browserName);
        seleniumInstanceName = instanceName;

        if (!serverConfig.isEmpty()) {
            String[] commandSet = serverConfig.split(",");
            int commandIndex = 0;
            int inputIndex = 1;
            for (String fullCommand : commandSet) {
                try {
                    String command =
                            fullCommand.split("=")[commandIndex]
                                    .toLowerCase(Locale.getDefault());
                    String input = fullCommand.split("=")[inputIndex];

                    if ("firefoxprofile".equalsIgnoreCase(command)) {

                        try {
                            setDefaultProfile(new FirefoxProfile(
                                    new File(input)));
                        } catch (Exception e) {
                            log.error(
                                    "Cannot find the firefox profile. Switching to the default.",
                                    e);
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                    log.error("Unexpected error occured.", e);
                    throw new IllegalArgumentException(
                            "Cannot configure selenium with given server configuration : "
                                    + serverConfig, e);

                }
            }
        }
    }

    /**
     * Config web driver.
     * 
     * @param browserName
     *            the browser string
     */
    public final void configWebDriver(final String browserName) {
        if (browserName.contains("chrome") || browserName.contains("Chrome")) {

            setBrowserString(browserString);
            File chromedriver = getChromeDriverServerExecutables();
            System.setProperty("webdriver.chrome.driver",
                    chromedriver.getAbsolutePath());
            setWebDriverCapabilities(new DesiredCapabilities());
        } else if (browserName.contains("safari")) {

            setBrowserString(browserString);
            setWebDriverCapabilities(new DesiredCapabilities());
        } else if (browserName.contains("iexplore")) {

            setBrowserString(browserString);
            setWebDriverCapabilities(new DesiredCapabilities());
            File iedriver;
            if (isx64bit()) {
                iedriver =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "lib" + File.separator
                                + "IEDriverServer(x64).exe");
            } else {
                iedriver =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "lib" + File.separator
                                + "IEDriverServer(x86).exe");
            }
            System.setProperty("webdriver.ie.driver",
                    iedriver.getAbsolutePath());

        } else if (browserName.contains("firefox")) {

            setBrowserString(browserString);
            setWebDriverCapabilities(new DesiredCapabilities());
            setDefaultProfile(new FirefoxProfile());
        } else if (browserName.contains("opera")) {

            setBrowserString(browserString);
            setWebDriverCapabilities(new DesiredCapabilities());
        } else {
            throw new AssertionError("Unsupported Browser");
        }
    }

    /**
     * Checks the os architecture and returns the chrome driver file.
     * 
     * @return File of the chrome driver executable.
     */
    private  File getChromeDriverServerExecutables() {
        String os =
                System.getProperty("os.name").toLowerCase(Locale.getDefault());
        File file = null;
        if (os.contains("win")) {
            file =
                    new File("src" + File.separator + "main" + File.separator
                            + "resources" + File.separator + "lib"
                            + File.separator + "chromedriver_win.exe");
        } else if (os.contains("mac")) {
            try {

                Runtime.getRuntime().exec(
                        "chmod 777 chromedriver_mac",
                        null,
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "lib"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            file =
                    new File("src" + File.separator + "main" + File.separator
                            + "resources" + File.separator + "lib"
                            + File.separator + "chromedriver_mac");

        } else if (os.contains("nux")) {

            if (isx64bit()) {
                file =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "lib" + File.separator
                                + "chromedriver_linux(x64)");
            } else {
                file =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "lib" + File.separator
                                + "chromedriver_linux(x86)");
            }
        }

        return file;
    }

    /**
     * Get operating system.
     * 
     * @return operating system
     */

    protected final String getOperatingSystem() {

        return System.getProperty("os.name").toLowerCase(Locale.getDefault());
    }

    /**
     * Checks if is x64bit.
     * 
     * @return true, if is x64bit
     */
    protected final boolean isx64bit() {
        String architecture = System.getProperty("os.arch");
        return architecture.contains("64");

    }

    /**
     * Sets the browser string.
     * 
     * @param browser
     *            the new browser string
     */
    public static synchronized void setBrowserString(final String browser) {
        browserString = browser;
    }

    /**
     * Checks if is process running.
     * 
     * @param serviceName
     *            the service name
     * @return true, if is process running
     * @throws Exception
     *             the exception
     */
    public final boolean isProcessRunning(final String serviceName)
            throws Exception {
        String tasklist = "tasklist";
        Process p = Runtime.getRuntime().exec(tasklist);
        BufferedReader reader = null;
        try {
            reader =
                    new BufferedReader(
                            new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(serviceName)) {
                    return true;
                }
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * Kill process.
     * 
     * @param serviceName
     *            the service name
     * @throws Exception
     *             the exception
     */
    public final void killProcess(final String serviceName) throws Exception {

        String os = getOperatingSystem();
        Runtime runtime = Runtime.getRuntime();
        if (os.contains("win")) {
            runtime.exec("taskkill /F /IM " + serviceName);
        } else if (os.contains("mac") || os.contains("nux")) {
            runtime.exec("killall -9 " + serviceName);
        }
    }

    /**
     * Replace xml special characters.
     * 
     * @param text
     *            the text
     * @return the string
     */
    public final String replaceXMLSpecialCharacters(final String text) {
        String replaced = text;

        replaced = StringEscapeUtils.escapeXml(replaced);
        replaced = replaced.replaceAll("»", "&#187;");
        replaced = replaced.replaceAll("«", "&#171;");
        replaced = replaced.replaceAll("—", "&#8212;");
        replaced = replaced.replaceAll("–", "&#8211;");
        replaced = replaced.replaceAll("£", "&#163;");
        replaced = replaced.replaceAll("¥", "&#165;");
        return (replaced.replaceAll("€", "&#8364;"));

        // return replaced;
    }

    /**
     * Gets the source lines.
     * 
     * @param stackTrace
     *            the stack trace
     * @return the source lines
     */
    public final String getSourceLines(final StackTraceElement[] stackTrace) {
        StringBuilder stacktraceLines = new StringBuilder();
        final int stackTraceIndex = 1;
        for (int elementid = 0; elementid < stackTrace.length; elementid++) {

            if (stackTrace[elementid].toString().indexOf("invoke0") != -1) {

                stacktraceLines.append(stackTrace[elementid - stackTraceIndex])
                        .append("|");
                stacktraceLines.append(
                        stackTrace[elementid - (stackTraceIndex + 1)]).append(
                        "|");
                stacktraceLines.append(stackTrace[elementid
                        - (stackTraceIndex + 2)]);
            }

        }
        return stacktraceLines.toString();
    }

    /**
     * Failure.
     * 
     * @param message
     *            the message
     */
    public static void failure(final Object message) {
        throw new AssertionError(message.toString());
    }

    /**
     * Assert true.
     * 
     * @param message
     *            the message
     * @param condition
     *            the condition
     */
    public static void assertTrue(final String message, final boolean condition) {
        if (!condition) {
            setTestCaseFailedStatus(true);
            failure(message);
        }
    }

    /**
     * Sleeps for the specified number of milliseconds.
     * 
     * @param millisecs
     *            the millisecs
     */
    public final void sleep(final int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Asserts that there were no verification errors during the current test,
     * failing immediately if any are found.
     */
    public final void checkForVerificationErrors() {
        String verificationErrorString = verificationErrors.toString();
        clearVerificationErrors();
        if (!"".equals(verificationErrorString)) {
            failure(verificationErrorString);
        }
    }

    /** Clears out the list of verification errors. */
    public final void clearVerificationErrors() {
        verificationErrors = new StringBuffer();
    }

    /**
     * checks for verification errors and stops the browser.
     * 
     * @throws Exception
     *             the exception
     */
    public final void tearDown() throws Exception {
        try {
            checkForVerificationErrors();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if is capture screen shot on failure.
     * 
     * @return true, if is capture screen shot on failure
     */
    protected final boolean isCaptureScreenShotOnFailure() {
        return captureScreenShotOnFailure;
    }

    /**
     * Sets the capture screen shot on failure.
     * 
     * @param captureScreetShotOnFailure
     *            the new capture screen shot on failure
     */
    protected final void setCaptureScreenShotOnFailure(
            final boolean captureScreetShotOnFailure) {
        this.captureScreenShotOnFailure = captureScreetShotOnFailure;
    }

    /**
     * Gets the web driver capabilities.
     * 
     * @return the webDriverCapabilities
     */
    public static final DesiredCapabilities getWebDriverCapabilities() {
        return webDriverCapabilities;
    }

    /**
     * Sets the web driver capabilities.
     * 
     * @param capabilities
     *            the webDriverCapabilities to set
     */
    public static final void setWebDriverCapabilities(
            final DesiredCapabilities capabilities) {
        SeleneseTestBaseVir.webDriverCapabilities = capabilities;
    }

    /**
     * Gets the selenium instances.
     * 
     * @return the seleniumInstances
     */
    public final Map<String, WebDriver> getSeleniumInstances() {
        return seleniumInstances;
    }

    /**
     * Sets the selenium instances.
     * 
     * @param seleniumInstancesMap
     *            the seleniumInstances to set
     */
    public final void setSeleniumInstances(
            final Map<String, WebDriver> seleniumInstancesMap) {
        this.seleniumInstances = seleniumInstancesMap;
    }

    /**
     * Put selenium instances.
     * 
     * @param instanceName
     *            the instanceName to put
     * @param webDriver
     *            the webDriver to put
     */
    public final void putSeleniumInstances(final String instanceName,
            final WebDriver webDriver) {
        this.seleniumInstances.put(instanceName, webDriver);
    }

    /**
     * Gets the selenium instance name.
     * 
     * @return the seleniumInstanceName
     */
    public final String getSeleniumInstanceName() {
        return seleniumInstanceName;
    }

    /**
     * Sets the selenium instance name.
     * 
     * @param seleniumInstanceNameString
     *            the seleniumInstanceNameString to set
     */
    public final void setSeleniumInstanceName(
            final String seleniumInstanceNameString) {
        this.seleniumInstanceName = seleniumInstanceNameString;
    }

    /**
     * Gets the default profile.
     * 
     * @return the defaultProfile
     */
    public static final FirefoxProfile getDefaultProfile() {
        return defaultProfile;
    }

    /**
     * Sets the default profile.
     * 
     * @param defaultProfileFirefox
     *            the defaultProfile to set
     */
    public static final void setDefaultProfile(
            final FirefoxProfile defaultProfileFirefox) {
        SeleneseTestBaseVir.defaultProfile = defaultProfileFirefox;
    }

    /**
     * Gets the log.
     * 
     * @return the log
     */
    public static final Logger getLog() {
        return log;
    }

    /**
     * Sets the log.
     * 
     * @param logValue
     *            the log to set
     */
    public static final void setLog(final Logger logValue) {
        SeleneseTestBaseVir.log = logValue;
    }

    /**
     * Gets the database instances.
     * 
     * @return the databaseInstances
     */
    public final Map<String, Connection> getDatabaseInstances() {
        return databaseInstances;
    }

    /**
     * Sets the database instances.
     * 
     * @param databaseInstancesMap
     *            the databaseInstances to set
     */
    public final void setDatabaseInstances(
            final Map<String, Connection> databaseInstancesMap) {
        this.databaseInstances = databaseInstancesMap;
    }

    /**
     * Put database instances.
     * 
     * @param instanceName
     *            the instanceName to put
     * @param connection
     *            the connection to put
     */
    public final void putOrientDatabaseInstances(final String instanceName,
            final ODatabaseDocumentTx connection) {
        this.orientDatabaseInstances.put(instanceName, connection);
    }
    /**
     * Sets the database instances.
     * 
     * @param databaseInstancesMap
     *            the databaseInstances to set
     */
    public final void setOrientDatabaseInstances(
            final Map<String, ODatabaseDocumentTx> databaseInstancesMap) {
        this.orientDatabaseInstances = databaseInstancesMap;
    }

    /**
     * Put database instances.
     * 
     * @param instanceName
     *            the instanceName to put
     * @param connection
     *            the connection to put
     */
    public final void putDatabaseInstances(final String instanceName,
            final Connection connection) {
        this.databaseInstances.put(instanceName, connection);
    }

    /**
     * Gets the verification errors.
     * 
     * @return the verificationErrors
     */
    public final StringBuffer getVerificationErrors() {
        return verificationErrors;
    }

    /**
     * Sets the verification errors.
     * 
     * @param verificationErrorsString
     *            the verificationErrors to set
     */
    public final void setVerificationErrors(
            final StringBuffer verificationErrorsString) {
        this.verificationErrors = verificationErrorsString;
    }

    /**
     * Checks if is this is windows.
     * 
     * @return the thisIsWindows
     */
    public static final boolean isThisIsWindows() {
        return THIS_IS_WINDOWS;
    }

    /**
     * Gets the browser string.
     * 
     * @return the browserString
     */
    public static final String getBrowserString() {
        return browserString;
    }

    /**
     * Gets the driver.
     * 
     * @return the driver
     */
    public final WebDriver getDriver() {
        return driver;
    }

    /**
     * Sets the driver.
     * 
     * @param driverObj
     *            the driver to set
     */
    public final void setDriver(final WebDriver driverObj) {
        this.driver = driverObj;
    }

    /**
     * Sets the test case failed status.
     * 
     * @param isFailed
     *            the new test case failed status
     */
    public static void setTestCaseFailedStatus(final boolean isFailed) {
        testCaseFailStatus = isFailed;
    }

    /**
     * Gets the test case failed status.
     * 
     * @return the test case failed status
     */
    public static boolean getTestCaseFailedStatus() {
        return testCaseFailStatus;
    }
    /**
     * Generates the log time CSV file in the target/logs folder.
     * 
     */
    /**
     * Generates the log time CSV file in the target/logs folder.
     * 
     */
    public final void generateTimeLogCSV() {
        FileWriter writer = null;
        //Logger log = getLog();
        try {
            File logsDir = new File("target" + File.separator + "logs");
            if (!logsDir.exists()) {
                if (logsDir.mkdir()) {
                    // success message
                    log.info("mkdir successfully completed");
                } else {
                    // fail message
                    log.error("mkdir failed.");
                }
            }
            writer = new FileWriter("ExecutionTime.csv");
            writer.append(logTimeCSVFileBuilder);
            writer.flush();
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        } catch (Exception e) {
            log.error(e);
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets the log time csv file builder.
     *
     * @return the log time csv file builder
     */
    public static String getLogTimeCSVFileBuilder() {
        return logTimeCSVFileBuilder;
    }

    /**
     * Sets the log time csv file builder.
     *
     * @param logTimeCSVFileBuilderstring the new log time csv file builder
     */
    public static void setLogTimeCSVFileBuilder(final String logTimeCSVFileBuilderstring) {
        SeleneseTestBaseVir.logTimeCSVFileBuilder += logTimeCSVFileBuilderstring;
    }

    /**
     * Gets the orient database instances.
     *
     * @return the orient database instances
     */
    public final synchronized Map<String, ODatabaseDocumentTx> getOrientDatabaseInstances() {
    return orientDatabaseInstances;
    }
}
