/**
 * Copyright 2004 ThoughtWorks, Inc. Licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package com.virtusa.isq.vtaf.runtime;

import java.net.*;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.base.Function;
import com.thoughtworks.selenium.SeleneseTestBaseVir;
import com.thoughtworks.selenium.SeleneseTestNgHelperVir;
import com.virtusa.isq.vtaf.objectmap.ObjectLocator;
import com.virtusa.isq.vtaf.objectmap.ObjectMap;
import com.virtusa.isq.vtaf.utils.DiffSort;
import com.virtusa.isq.vtaf.utils.ErrorMessageHandler;
import com.virtusa.isq.vtaf.utils.KeyCodes;
import com.virtusa.isq.vtaf.utils.PropertyHandler;





import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

// import com.virtusa.kbb.excel.reader.Main;

/**
 * The Class SeleniumTestBase.
 */
public class SeleniumTestBase extends SeleneseTestNgHelperVir {

    /** The clip board. */
    private Clipboard clipboard = null;

    /** The Constant RETRY_INTERVAL. */
    private static final int RETRY_INTERVAL = 1000;

    //
    /**
     * The Enum TableValidationType.
     */
    public static enum TableValidationType {

        /** The colcount. */
        COLCOUNT,
        /** The rowcount. */
        ROWCOUNT,
        /** The tabledata. */
        TABLEDATA,
        /** The relative. */
        RELATIVE,
        /** The tablecell. */
        TABLECELL
    };

    /**
     * The Enum WindowValidationType.
     */
    public static enum WindowValidationType {

        /** The windowpresent. */
        WINDOWPRESENT,
        /** The checktitle. */
        CHECKTITLE
    }

    /** The retry interval. */
    private int retryInterval;

    /** The tables. */
    private HashMap<String, DataTable> tables = null;

    /** The identifire. */
    private String locatorIdentifire = "";

    /** The identifire. */
    // private static String identifire = "";

    /**
     * The Constructor.
     */
    public SeleniumTestBase() {
        super();
        PropertyHandler propHandler = new PropertyHandler("runtime.properties");
        retryInterval =
                Integer.parseInt(propHandler
                        .getRuntimeProperty("RETRY_INTERVAL"));

    }
    public final void reportTestLinkResult(String bcName, String status) throws TestLinkAPIException {

        TestLinkAPI api;
        PropertyHandler propHandler = new PropertyHandler("testLinkRuntime.properties");
        String URL = propHandler.getRuntimeProperty("tetLink_URL");
        String DEVKEY = propHandler.getRuntimeProperty("tetLink_DEVKEY");
        String testSuitName = propHandler.getRuntimeProperty("tetLink_TS_NAME");
        String testPlanName = propHandler.getRuntimeProperty("tetLink_TP_NAME");
        String testProjName = propHandler.getRuntimeProperty("tetLink_PROJ_NAME");
        String buildName = propHandler.getRuntimeProperty("tetLink_BUILD_NAME");
        try {
            api = new TestLinkAPI(new java.net.URL(URL), DEVKEY);
            api.getProjects();
            Integer tcId = api.getTestCaseIDByName(bcName, testSuitName, testProjName, "");
            Integer testPlanID = api.getTestPlanByName(testPlanName, testProjName).getId();

            Map<String, String> customFields = null;
            if ("PASSED".equals(status)) {
                api.setTestCaseExecutionResult(tcId, null, testPlanID, ExecutionStatus.PASSED, null, buildName,
                        "", true, "", null, "", customFields, true);
            } else if ("FAIELD".equals(status)) {
                api.setTestCaseExecutionResult(tcId, null, testPlanID, ExecutionStatus.FAILED, null, buildName,
                        "", true, "", null, "", customFields, true);
            } else {
                api.setTestCaseExecutionResult(tcId, null, testPlanID, ExecutionStatus.NOT_RUN, null, buildName,
                        "", true, "", null, "", customFields, true);
            }

            // api.getTestSuitesForTestPlan(testPlanID);

            // api.getProjectTestPlans(projectId)
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build,
        // Notes, Result);

    }
    /**
     * Opens an URL in the test frame. This accepts both relative and absolute
     * URLs. The "open" command <br>
     * waits for the page to load before proceeding, ie. the "AndWait" suffix is
     * implicit. Note: The URL <br>
     * must be on the same domain as the runner HTML due to security
     * restrictions in the browser <br>
     * (Same Origin Policy). If you need to open an URL on another domain, use
     * the Selenium Server <br>
     * to start a new browser session on that domain.
     * 
     * @param objectName
     *            : Logical name of the object
     * @param marginObj
     *            the margin obj
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkSameXAxis(final String objectName,
            final Object marginObj, final boolean stopOnFailure,
            final Object... customError) {
        List<String> objects = Arrays.asList(objectName.split(","));

        String margin = checkNullObject(marginObj, "CHECKSAMEXAXIS");

        String identifier = "";

        List<ObjectLocator> objectLocators = new ArrayList();

        for (int i = 0; i < objects.size(); ++i) {
            String actualLocator =
                    ObjectMap.getObjectSearchPath(objects.get(i), identifier);
            ObjectLocator locator =
                    new ObjectLocator(objects.get(i), identifier, actualLocator);

            objectLocators.add(locator);

        }

        doCheckSameXAxix(objectLocators, margin, stopOnFailure, customError);
    }

    /**
     * Do check same x axix.
     * 
     * @param objectLocators
     *            the object locators
     * @param margin
     *            the margin
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckSameXAxix(final List<ObjectLocator> objectLocators,
            final String margin, final boolean stopOnFailure,
            final Object[] customError) {
        String logName = "";
        String locName = "";
        HashMap<String, String> nameMap = null;
        HashMap<String, Integer> valueMap = null;
        HashMap[] failedMap;
        ArrayList<Map[]> failedLog = new ArrayList();
        try {
            int base = 0;
            int comparable = 0;
            boolean isFailed = false;
            ObjectLocator obLocator = objectLocators.get(0);
            WebElement element1 =
                    checkElementPresence(obLocator.getActualLocator());
            base = element1.getLocation().getX();
            ArrayList<String> elements = new ArrayList();
            StringBuilder passedLog = new StringBuilder();
            passedLog.append("Base Object : [" + obLocator.getLogicalName()
                    + " with locator " + obLocator.getActualLocator() + "] \n");

            // store logical name, x difference wrt base
            // print logical name, xdifference wrt base, base name, base x

            for (int j = 1; j < objectLocators.size(); j++) {
                logName = objectLocators.get(j).getLogicalName();
                locName = objectLocators.get(j).getActualLocator();

                WebElement element2 =
                        checkElementPresence(objectLocators.get(j)
                                .getActualLocator());

                comparable = element2.getLocation().getX();

                if (!(Math.abs(base - comparable) <= Integer.parseInt(margin))) {
                    isFailed = true;
                    failedMap = new HashMap[2];
                    nameMap = new HashMap<String, String>();
                    valueMap = new HashMap<String, Integer>();

                    nameMap.put("name", logName);
                    valueMap.put("value", (base - comparable));

                    failedMap[0] = nameMap;
                    failedMap[1] = valueMap;
                    failedLog.add(failedMap);

                } else {
                    passedLog.append("[" + logName + " with locator " + locName
                            + "] ,\n ");
                }
            }

            if (isFailed) {

                // create the faild message,
                // required x value : a amount
                // logname's x value deviates z amount to right/left with
                // respect to the base element(element name)

                String name;

                int value;
                String direction;
                String baseName = objectLocators.get(0).getLogicalName();
                String failedMessageTemplate = null;
                String failedMessage = null;
                elements.add(baseName);
                int zero = 0;
                int one = 1;
                for (int i = 0; i < failedLog.size(); ++i) {
                    name = failedLog.get(i)[zero].get("name").toString();
                    elements.add(name);
                    value =
                            Integer.parseInt(failedLog.get(i)[one].get("value")
                                    .toString());
                    if (value < 0) {
                        direction = "right";
                    } else {
                        direction = "left";
                    }

                    System.out.println("Name: " + name);
                    System.out.println("Value " + value);

                    failedMessageTemplate =
                            "Element(" + name + ")" + "'s x value deviates "
                                    + Math.abs(value) + " pixels to "
                                    + direction
                                    + "  with respect to the base element("
                                    + baseName + ")";

                    if (failedMessage == null) {
                        failedMessage = failedMessageTemplate;
                    } else {
                        failedMessage =
                                failedMessage + ",\n" + failedMessageTemplate;
                    }

                }

                reportresult(
                        true,
                        "CHECK SAME X AXIS :",
                        "FAILED",
                        generateCustomError(customError)
                                + " System generated Error : check same x axix : "
                                + elements + "" + failedMessage);

                // stopOnFailure
                checkTrue(false, stopOnFailure, failedMessage);
            } else {
                reportresult(true, "CHECK SAME X AXIS :" + elements + "",
                        "PASSED", "Elements  : \n " + passedLog
                                + " - x values are within the margin ( "
                                + margin + " )");
            }

        } catch (Exception e) {
            reportresult(true, "CHECK SAME X AXIS :", "FAILED",
                    generateCustomError(customError)
                            + " System generated Error : check same x axis :"
                            + "Can not detect UI elements (" + logName + ")");
            e.printStackTrace();
        }

    }

    /*
     * check same y axis
     */

    /**
     * Check same y axis.
     * 
     * @param objectName
     *            the object name
     * @param marginObj
     *            the margin obj
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkSameYAxis(final String objectName,
            final Object marginObj, final boolean stopOnFailure,
            final Object... customError) {
        List<String> objects = Arrays.asList(objectName.split(","));

        String margin = checkNullObject(marginObj, "CHECKSAMEYAXIS");

        String identifier = "";

        List<ObjectLocator> objectLocators = new ArrayList();

        for (int i = 0; i < objects.size(); ++i) {
            String actualLocator =
                    ObjectMap.getObjectSearchPath(objects.get(i), identifier);
            ObjectLocator locator =
                    new ObjectLocator(objects.get(i), identifier, actualLocator);

            objectLocators.add(locator);

        }

        doCheckSameYAxix(objectLocators, margin, stopOnFailure, customError);
    }

    /**
     * Do check same y axix.
     * 
     * @param objectLocators
     *            the object locators
     * @param margin
     *            the margin
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckSameYAxix(final List<ObjectLocator> objectLocators,
            final String margin, final boolean stopOnFailure,
            final Object[] customError) {
        String logName = "";
        String locName = "";
        HashMap<String, String> nameMap = null;
        HashMap<String, Integer> valueMap = null;
        HashMap[] failedMap;
        ArrayList<Map[]> failedLog = new ArrayList();

        try {
            int base = 0;
            int comparable = 0;
            boolean isFailed = false;
            ObjectLocator obLocator = objectLocators.get(0);
            WebElement element1 =
                    checkElementPresence(obLocator.getActualLocator());
            base = element1.getLocation().getY();
            ArrayList<String> elements = new ArrayList();
            StringBuilder passedLog = new StringBuilder();
            // passedLog.append(obLocator.getLogicalName());
            passedLog.append("Base Object : [" + obLocator.getLogicalName()
                    + " with locator " + obLocator.getActualLocator() + "] \n");

            // store logical name, y difference wrt base
            // print logical name, ydifference wrt base, base name, base y

            for (int j = 1; j < objectLocators.size(); j++) {
                logName = objectLocators.get(j).getLogicalName();
                locName = objectLocators.get(j).getActualLocator();

                WebElement element2 =
                        checkElementPresence(objectLocators.get(j)
                                .getActualLocator());

                comparable = element2.getLocation().getY();

                if (!(Math.abs(base - comparable) <= Integer.parseInt(margin))) {
                    isFailed = true;
                    failedMap = new HashMap[2];
                    nameMap = new HashMap<String, String>();
                    valueMap = new HashMap<String, Integer>();

                    nameMap.put("name", logName);
                    valueMap.put("value", (base - comparable));

                    failedMap[0] = nameMap;
                    failedMap[1] = valueMap;
                    failedLog.add(failedMap);

                } else {
                    passedLog.append(", [" + logName + " with locator "
                            + locName + "] \n ");
                }
            }

            if (isFailed) {

                // create the faild message,
                // required y value : a amount
                // logname's y value deviates z amount top/bottom along y axis
                // with respect to the base element(element name)

                String name;

                int value;
                String direction;
                String baseName = objectLocators.get(0).getLogicalName();
                String failedMessageTemplate = null;
                String failedMessage = null;
                elements.add(baseName);
                int zero = 0;
                int one = 1;
                for (int i = 0; i < failedLog.size(); ++i) {
                    name = failedLog.get(i)[zero].get("name").toString();
                    elements.add(name);
                    value =
                            Integer.parseInt(failedLog.get(i)[one].get("value")
                                    .toString());
                    if (value < 0) {
                        direction = "bottom";
                    } else {
                        direction = "top";
                    }

                    System.out.println("Name: " + name);
                    System.out.println("Value " + value);

                    failedMessageTemplate =
                            "Element(" + name + ")" + "'s y value deviates "
                                    + Math.abs(value) + " pixels to "
                                    + direction
                                    + "  with respect to the base element("
                                    + baseName + ")";

                    if (failedMessage == null) {
                        failedMessage = failedMessageTemplate;
                    } else {
                        failedMessage =
                                failedMessage + ",\n" + failedMessageTemplate;
                    }

                }

                reportresult(
                        true,
                        "CHECK SAME Y AXIS :",
                        "FAILED",
                        generateCustomError(customError)
                                + " System generated Error :- check same y axix : "
                                + elements + " :" + failedMessage);

                // stopOnFailure
                checkTrue(false, stopOnFailure, failedMessage);
            } else {
                /* reportresult(true, "CHECK SAME Y AXIS :" + elements + "",
                         "PASSED", "y values are within the margin ( " + margin
                                 + " )");*/
                reportresult(true, "CHECK SAME Y AXIS :" + elements + "",
                        "PASSED", "Elements  : \n " + passedLog
                                + " - y values are within the margin ( "
                                + margin + " )");
            }

        } catch (Exception e) {
            reportresult(true, "CHECK SAME Y AXIS :", "FAILED",
                    generateCustomError(customError)
                            + " System generated Error :- check same y axis :"
                            + "Can not detect UI elements (" + logName + ")");
            e.printStackTrace();
        }

    }

    /**
     * checks whether the given objects have the same width.
     * 
     * @param objectName
     *            the object name
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkSameWidth(final String objectName,
            final boolean stopOnFailure, final Object... customError) {
        List<String> objects = Arrays.asList(objectName.split(","));

        String identifier = "";

        List<ObjectLocator> objectLocators = new ArrayList();

        for (int i = 0; i < objects.size(); ++i) {
            String actualLocator =
                    ObjectMap.getObjectSearchPath(objects.get(i), identifier);
            ObjectLocator locator =
                    new ObjectLocator(objects.get(i), identifier, actualLocator);

            objectLocators.add(locator);

        }

        doCheckSameWidth(objectLocators, stopOnFailure, customError);
    }

    /**
     * Do check same width.
     * 
     * @param objectLocators
     *            the object locators
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckSameWidth(final List<ObjectLocator> objectLocators,
            final boolean stopOnFailure, final Object[] customError) {

        String logName = "";
        String locName = "";
        HashMap<String, String> nameMap = null;
        HashMap<String, Integer> valueMap = null;
        HashMap[] failedMap;
        ArrayList<Map[]> failedLog = new ArrayList();

        try {
            int base = 0;
            int comparable = 0;
            ObjectLocator obLocator = objectLocators.get(0);
            boolean isFailed = false;
            WebElement element1 =
                    checkElementPresence(obLocator.getActualLocator());
            base = element1.getSize().getWidth();
            ArrayList<String> elements = new ArrayList();
            StringBuilder passedLog = new StringBuilder();
            // passedLog.append(obLocator.getLogicalName());
            passedLog.append("Base Object : [" + obLocator.getLogicalName()
                    + " with locator " + obLocator.getActualLocator() + "] \n");

            // store logical name, y difference wrt base
            // print logical name, ydifference wrt base, base name, base y

            for (int j = 1; j < objectLocators.size(); j++) {
                logName = objectLocators.get(j).getLogicalName();
                locName = objectLocators.get(j).getActualLocator();

                WebElement element2 =
                        checkElementPresence(objectLocators.get(j)
                                .getActualLocator());

                comparable = element2.getSize().getWidth();

                if (base != comparable) {
                    isFailed = true;
                    nameMap = new HashMap<String, String>();
                    valueMap = new HashMap<String, Integer>();
                    failedMap = new HashMap[2];
                    nameMap.put("name", logName);
                    valueMap.put("value", (base - comparable));
                    failedLog.add(failedMap);
                    failedMap[0] = nameMap;
                    failedMap[1] = valueMap;
                } else {

                    passedLog.append("[" + logName + " with locator " + locName
                            + "] ,\n ");
                }
            }
            if (isFailed) {

                String name;
                int value;

                String baseName = objectLocators.get(0).getLogicalName();
                String failedMessageTemplate = null;
                String failedMessage = null;
                elements.add(baseName);
                String object1;
                String object2;
                int zero = 0;
                int one = 1;
                for (int i = 0; i < failedLog.size(); ++i) {
                    name = failedLog.get(i)[zero].get("name").toString();
                    elements.add(name);
                    value =
                            Integer.parseInt(failedLog.get(i)[one].get("value")
                                    .toString());
                    if (value < 0) {
                        object1 = name;
                        object2 = baseName;
                    } else {
                        object1 = baseName;
                        object2 = name;
                    }
                    System.out.println("Name: " + name);
                    System.out.println("Value " + value);
                    failedMessageTemplate =
                            "Element(" + object1 + ")"
                                    + " is wider than Element(" + object2
                                    + ") by " + Math.abs(value) + " pixels";

                    if (failedMessage == null) {
                        failedMessage = failedMessageTemplate;
                    } else {
                        failedMessage =
                                failedMessage + ",\n" + failedMessageTemplate;
                    }

                }

                reportresult(
                        true,
                        "CHECK SAME WIDTH :",
                        "FAILED",
                        generateCustomError(customError)
                                + " System generated Error :- check same width : "
                                + elements + " :" + failedMessage);

                // stopOnFailure
                checkTrue(false, stopOnFailure, failedMessage);
            } else {
                /*reportresult(true, "CHECK SAME WIDTH :" + elements + "",
                        "PASSED", "widths of the elements are the same");*/
                reportresult(true, "CHECK SAME WIDTH :" + elements + "",
                        "PASSED", " Widths of the elements :" + passedLog
                                + " are the same.");
            }

        } catch (Exception e) {
            reportresult(true, "CHECK SAME WIDTH :", "FAILED",
                    generateCustomError(customError)
                            + " System generated Error :- check same width :"
                            + "Can not detect UI elements (" + logName + ")");
            e.printStackTrace();
        }

    }

    /**
     * checks whether the given objects have the same height.
     * 
     * @param objectName
     *            the object name
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkSameHeight(final String objectName,
            final boolean stopOnFailure, final Object... customError) {
        List<String> objects = Arrays.asList(objectName.split(","));

        String identifier = "";

        List<ObjectLocator> objectLocators = new ArrayList();

        for (int i = 0; i < objects.size(); ++i) {
            String actualLocator =
                    ObjectMap.getObjectSearchPath(objects.get(i), identifier);
            ObjectLocator locator =
                    new ObjectLocator(objects.get(i), identifier, actualLocator);

            objectLocators.add(locator);

        }

        doCheckSameHeight(objectLocators, stopOnFailure, customError);
    }

    /**
     * Do check same height.
     * 
     * @param objectLocators
     *            the object locators
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckSameHeight(final List<ObjectLocator> objectLocators,
            final boolean stopOnFailure, final Object[] customError) {

        String logName = "";
        String locName = "";
        HashMap<String, String> nameMap = null;
        HashMap<String, Integer> valueMap = null;
        HashMap[] failedMap;
        ArrayList<Map[]> failedLog = new ArrayList();

        try {
            ObjectLocator obLocator = objectLocators.get(0);
            int base = 0;
            int comparable = 0;
            boolean isFailed = false;
            WebElement element1 =
                    checkElementPresence(obLocator.getActualLocator());
            base = element1.getSize().getHeight();
            ArrayList<String> elements = new ArrayList();
            StringBuilder passedLog = new StringBuilder();

            passedLog.append(obLocator.getLogicalName());

            // store logical name, y difference wrt base
            // print logical name, ydifference wrt base, base name, base y

            for (int j = 1; j < objectLocators.size(); j++) {
                logName = objectLocators.get(j).getLogicalName();
                locName = objectLocators.get(j).getActualLocator();

                WebElement element2 =
                        checkElementPresence(objectLocators.get(j)
                                .getActualLocator());

                comparable = element2.getSize().getHeight();

                if (base != comparable) {
                    isFailed = true;
                    failedMap = new HashMap[2];
                    nameMap = new HashMap<String, String>();
                    valueMap = new HashMap<String, Integer>();

                    nameMap.put("name", logName);
                    valueMap.put("value", (base - comparable));

                    failedMap[0] = nameMap;
                    failedMap[1] = valueMap;
                    failedLog.add(failedMap);

                } else {
                    passedLog.append("[" + logName + " with locator " + locName
                            + "] ,\n ");
                }
            }

            if (isFailed) {

                // create the faild message,
                // required y value : a amount
                // element1 is wider than element2 by (amount) pixels

                String name;

                int value;

                String baseName = objectLocators.get(0).getLogicalName();
                String failedMessageTemplate = null;
                String failedMessage = null;
                elements.add(baseName);
                String object1;
                String object2;
                int zero = 0;
                int one = 1;
                for (int i = 0; i < failedLog.size(); ++i) {
                    name = failedLog.get(i)[zero].get("name").toString();
                    elements.add(name);
                    value =
                            Integer.parseInt(failedLog.get(i)[one].get("value")
                                    .toString());
                    if (value < 0) {

                        object2 = baseName;
                        object1 = name;
                    } else {

                        object2 = name;
                        object1 = baseName;
                    }

                    System.out.println("Name: " + name);
                    System.out.println("Value " + value);

                    failedMessageTemplate =
                            "Element(" + object1 + ")"
                                    + " is taller than Element(" + object2
                                    + ") by " + Math.abs(value) + " pixels";

                    if (failedMessage == null) {
                        failedMessage = failedMessageTemplate;
                    } else {
                        failedMessage =
                                failedMessage + ",\n" + failedMessageTemplate;
                    }

                }

                reportresult(
                        true,
                        "CHECK SAME HIGHT :",
                        "FAILED",
                        generateCustomError(customError)
                                + " System generated Error :- check same height : "
                                + elements + "" + failedMessage);

                // stopOnFailure
                checkTrue(false, stopOnFailure, failedMessage);
            } else {
                /*reportresult(true, "CHECK SAME HIGHT :" + elements + "",
                        "PASSED", "heights of the elements are the same");*/
                reportresult(true, "CHECK SAME HIGHT :" + elements + "",
                        "PASSED", " Heights of the elements :" + passedLog
                                + " are the same.");
            }

        } catch (Exception e) {
            reportresult(true, "CHECK SAME HIGHT :", "FAILED",
                    generateCustomError(customError)
                            + " System generated Error :- check same height :"
                            + "Can not detect UI elements (" + logName + ")");
            e.printStackTrace();
        }

    }

    /**
     * checks whether the given objects reside in the given box.
     * 
     * @param objectName
     *            the object name
     * @param topObj
     *            the top obj
     * @param bottomObj
     *            the bottom obj
     * @param leftObj
     *            the left obj
     * @param rightObj
     *            the right obj
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkSameBox(final String objectName,
            final Object topObj, final Object bottomObj, final Object leftObj,
            final Object rightObj, final boolean stopOnFailure,
            final Object... customError) {
        String top = checkNullObject(topObj, "CHECKSAMEBOX");
        String bottom = checkNullObject(bottomObj, "CHECKSAMEBOX");
        String left = checkNullObject(leftObj, "CHECKSAMEBOX");
        String right = checkNullObject(rightObj, "CHECKSAMEBOX");
        List<String> objects = Arrays.asList(objectName.split(","));

        String identifier = "";

        List<ObjectLocator> objectLocators = new ArrayList();

        for (int i = 0; i < objects.size(); ++i) {
            String actualLocator =
                    ObjectMap.getObjectSearchPath(objects.get(i), identifier);
            ObjectLocator locator =
                    new ObjectLocator(objects.get(i), identifier, actualLocator);

            objectLocators.add(locator);

        }

        doCheckSameBox(objectLocators, Float.parseFloat(top),
                Float.parseFloat(bottom), Float.parseFloat(left),
                Float.parseFloat(right), stopOnFailure, customError);
    }

    /**
     * Do check same box.
     * 
     * @param objectLocators
     *            the object locators
     * @param top
     *            the top
     * @param bottom
     *            the bottom
     * @param left
     *            the left
     * @param right
     *            the right
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckSameBox(final List<ObjectLocator> objectLocators,
            final float top, final float bottom, final float left,
            final float right, final boolean stopOnFailure,
            final Object[] customError) {
        float absTop;
        float absBottom;
        float absLeft;
        float absRight;

        org.openqa.selenium.Dimension d =
                getDriver().manage().window().getSize();
        int height = d.getHeight();
        int width = d.getWidth();

        final int valueHundred = 100;
        absTop = (height * top) / valueHundred;
        absBottom = height - (height * bottom) / valueHundred;

        absLeft = (width * left) / valueHundred;
        absRight = width - (width * right) / valueHundred;

        int eleHeight;
        int eleWidth;
        boolean isFailed = false;
        StringBuilder failedLog = new StringBuilder();
        StringBuilder passedLog = new StringBuilder();
        String logName = "";
        String locName = "";
        String failedMessage = null;
        try {
            for (int i = 0; i < objectLocators.size(); ++i) {

                logName = objectLocators.get(i).getLogicalName();
                locName = objectLocators.get(i).getActualLocator();
                WebElement element1 =
                        checkElementPresence(objectLocators.get(i)
                                .getActualLocator());
                String failedMessageTemplate = null;
                Point elePoint = element1.getLocation();
                org.openqa.selenium.Dimension diamnsion = element1.getSize();
                int y = elePoint.getY(); // Double.valueOf((String)
                                         // comparableObjects.get(i).get("y"));
                int x = elePoint.getX(); // Double.valueOf((String)
                                         // comparableObjects.get(i).get("x"));

                eleHeight = diamnsion.getHeight(); // Double.valueOf((String)
                                                   // comparableObjects.get(i).get("Height"));
                eleWidth = diamnsion.getWidth(); // Double.valueOf((String)
                                                 // comparableObjects.get(i).get("Width"));

                if (y >= absTop && x >= absLeft && (y + eleHeight) <= absBottom
                        && (x + eleWidth) <= absRight) {
                    // passedLog
                    if (passedLog.length() == 0) {
                        passedLog.append(logName);
                    } else {

                        passedLog.append("[" + logName + " with locator "
                                + locName + "] ,\n ");
                    }

                } else {

                    float actualTop = (float) y * valueHundred / height;
                    float actualBottom =
                            (float) (height - y - eleHeight) * valueHundred
                                    / height;
                    float actualLeft = (float) x * valueHundred / width;
                    float actualRight =
                            (float) (width - x) * valueHundred / width;

                    isFailed = true;
                    if (failedLog.length() == 0) {
                        failedLog.append(logName);
                    } else {

                        failedLog.append(", " + logName);

                    }
                    failedMessageTemplate =
                            "Element("
                                    + logName
                                    + ") is not in the defined box\nActual Location:[Top : "
                                    + String.format("%.2f", actualTop)
                                    + "%, Bottom : "
                                    + String.format("%.2f", actualBottom)
                                    + "%, Left : "
                                    + String.format("%.2f", actualLeft)
                                    + "%, Right: "
                                    + String.format("%.2f", actualRight) + "%]";
                    if (failedMessage == null) {
                        failedMessage = failedMessageTemplate;
                    } else {
                        failedMessage =
                                failedMessage + ", \n" + failedMessageTemplate;
                    }

                }

            }

            if (isFailed) {

                // actual location

                reportresult(
                        true,
                        "CHECK SAME BOX :",
                        "FAILED",
                        generateCustomError(customError)
                                + " System generated Error :- Check Same Box : "
                                + failedLog + "" + failedMessage);
                // stopOnFailure
                checkTrue(false, stopOnFailure, failedMessage);
            } else {
                reportresult(true, "CHECK SAME BOX : " + passedLog + "",
                        "PASSED", "Elements " + passedLog
                                + "are in the defined area");
            }
        } catch (Exception e) {
            reportresult(true, "CHECK SAME BOX :", "FAILED",
                    generateCustomError(customError)
                            + " System generated Error :- Check Same Box :"
                            + "Can not detect UI elements" + "(" + logName
                            + ")");
            e.printStackTrace();
        }

    }

    /**
     * Open.
     * 
     * @param objectName
     *            the object name
     * @param waitTime
     *            the wait time
     */
    public final void open(final String objectName, final String waitTime) {
        open(objectName, "", waitTime);
    }

    /**
     * Open.
     * 
     * @param objectName
     *            the object name
     * @param identifier
     *            the identifier
     * @param waitTime
     *            the wait time
     */
    public final void open(final String objectName, final String identifier,
            final String waitTime) {

        String url = ObjectMap.getResolvedSearchPath(objectName, identifier);
        ObjectLocator locator = new ObjectLocator(url, identifier, url);
        doOpen(locator, waitTime);
    }

    /**
     * Opens an URL in the test frame. This accepts both relative and absolute
     * URLs. The "open" command <br>
     * waits for the page to load before proceeding, ie. the "AndWait" suffix is
     * implicit. Note: The URL <br>
     * must be on the same domain as the runner HTML due to security
     * restrictions in the browser <br>
     * (Same Origin Policy). If you need to open an URL on another domain, use
     * the Selenium Server <br>
     * to start a new browser session on that domain.
     * 
     * @param locator
     *            : url of the openning page
     * @param waitTime
     *            : time to wait till the page is loaded.
     * 
     * */
    private void doOpen(final ObjectLocator locator, final String waitTime) {
        String url = "";
        WebDriver driver = getDriver();
        try {
            url = locator.getActualLocator();
            if ("default".equalsIgnoreCase(url)) {
                PropertyHandler propertyHandler =
                        new PropertyHandler("runtime.properties");
                url = propertyHandler.getRuntimeProperty("DEFAULT_URL");
                if ("".equals(url)) {
                    throw new WebDriverException("Empty URL : " + url);
                }
            }
            setCommandStartTime(getCurrentTime());
            driver.get(url);

            try {
                driver.manage()
                
                        .timeouts()
                        .implicitlyWait(Integer.parseInt(waitTime),
                                TimeUnit.MILLISECONDS);
            } catch (NumberFormatException e) {
                reportresult(true, "OPEN :", "FAILED",
                        "Invalid argument passed for wait time.");
                checkTrue(false, true, "Invalid argument passed for wait time.");
            } catch (Exception e) {
                e.printStackTrace();
            }

            reportresult(true, "OPEN : " + url + "", "PASSED", "Open url ["
                    + url + "]");
        } catch (WebDriverException e) {

            String errorString = e.getMessage();
            reportresult(true, "OPEN : " + url + "", "FAILED",
                    "Cannot access the empty URL. URL : " + url
                            + ". Actual Error : " + errorString);
            checkTrue(false, true, "Cannot access the empty URL. URL : " + url
                    + ". Actual Error : " + errorString);
        } catch (Exception e) {
            String errorString = e.getMessage();
            reportresult(true, "OPEN : " + url + "", "FAILED",
                    "Cannot access the URL. URL : " + url + ". Actual Error : "
                            + errorString);
            checkTrue(false, true, "Cannot access the URL. URL : " + url
                    + ". Actual Error : " + errorString);
        }

    }

    /**
     * Check null object.
     * 
     * @param obj
     *            the obj
     * @param command
     *            the command
     * @return the string
     */
    private String checkNullObject(final Object obj, final String command) {
        String value = null;
        try {
            value = obj.toString();
        } catch (NullPointerException e) {
            reportresult(true, command + " command:", "FAILED", command
                    + " command: Invalid input. cannot use null as input");
            checkTrue(false, true, command
                    + " command: Invalid input. cannot use null as input");
        }
        return value;
    }

    /**
     * Opens an URL in a new test frame. This accepts both relative and absolute
     * URLs. The "open" command <br>
     * waits for the page to load before proceeding, ie. the "AndWait" suffix is
     * implicit. Note: The URL <br>
     * must be on the same domain as the runner HTML due to security
     * restrictions in the browser <br>
     * (Same Origin Policy). If you need to open an URL on another domain, use
     * the Selenium Server <br>
     * to start a new browser session on that domain.
     * 
     * @param url
     *            : Logical name of the object
     * @param identifier
     *            the identifier
     * @param waitTime
     *            the wait time
     */

    public final void navigateToURL(final String url, final String identifier,
            final String waitTime) {

        String actualURL = ObjectMap.getResolvedSearchPath(url, identifier);
        ObjectLocator locator =
                new ObjectLocator(actualURL, identifier, actualURL);
        doNavigateToURL(locator, waitTime);
    }

    /**
     * Navigate to url.
     * 
     * @param url
     *            the url
     * @param waitTime
     *            the wait time
     */
    public final void navigateToURL(final String url, final String waitTime) {

        navigateToURL(url, "", waitTime);
    }

    /**
     * Opens an URL in a new test frame. This accepts both relative and absolute
     * URLs. The "open" command <br>
     * waits for the page to load before proceeding, ie. the "AndWait" suffix is
     * implicit. Note: The URL <br>
     * must be on the same domain as the runner HTML due to security
     * restrictions in the browser <br>
     * (Same Origin Policy). If you need to open an URL on another domain, use
     * the Selenium Server <br>
     * to start a new browser session on that domain.
     * 
     * @param locator
     *            the locator
     * @param waitTime
     *            the wait time
     */
    private void doNavigateToURL(final ObjectLocator locator,
            final String waitTime) {
        String url = "";
        WebDriver driver = getDriver();
        try {

            url = locator.getActualLocator();
            setCommandStartTime(getCurrentTime());
            if (url.toLowerCase(Locale.getDefault()).startsWith("openwindow=")) {

                Set<String> oldWindowHandles = getAllWindows();
                String actualUrl =
                        url.substring(url.indexOf('=') + 1, url.length());

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.open('" + actualUrl
                        + "', '_newWindow');");
                super.sleep(Integer.parseInt(waitTime));

                Set<String> newWindowHandles = getAllWindows();
                newWindowHandles.removeAll(oldWindowHandles);
                Object[] newWindowArr = newWindowHandles.toArray();
                driver.switchTo().window(newWindowArr[0].toString());

            } else {
                driver.get(url);
                super.sleep(Integer.parseInt(waitTime));
            }
            reportresult(true, "NAVIGATE TO URL Command :" + url + "",
                    "PASSED", "Navigate to url [" + url + "]");
        } catch (Exception e) {
            String errorString = e.getMessage();
            reportresult(true, "NAVIGATE TO URL :" + url + "", "FAILED",
                    "NAVIGATE TO URL command : URL " + url
                            + " failed. Actual Error : " + errorString);
            checkTrue(false, true, "NAVIGATE TO URL command : URL " + url
                    + " failed. Actual Error : " + errorString);
        }

    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad. <br>
     * ClickAt is capable of perform clicking on a relative location to the
     * specified element. use locator to specify the respective X,Y coordinates
     * to click
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifier
     *            the identifier
     * @param coordinateString
     *            the coordinate string
     */

    public final void clickAt(final String objectName, final String identifier,
            final String coordinateString) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doClickAt(locator, coordinateString);
    }

    /**
     * Click at.
     * 
     * @param objectName
     *            the object name
     * @param coordinateString
     *            the coordinate string
     */
    public final void clickAt(final String objectName,
            final String coordinateString) {
        clickAt(objectName, "", coordinateString);
    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad. <br>
     * ClickAt is capable of perform clicking on a relative location to the
     * specified element. use locator to specify the respective X,Y coordinates
     * to click
     * 
     * @param locator
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param coordinateString
     *            the coordinate string
     */

    private void doClickAt(final ObjectLocator locator,
            final String coordinateString) {
        String objectID = "";
        int counter = getRetryCount();
        int xOffset = 0;
        int yOffset = 0;
        WebDriver driver = getDriver();
        String objectName = locator.getLogicalName();
        try {
            // Retrieve the correct object locator from the object map
            objectID = locator.getActualLocator();

            // first verify whether the element is present in the current web
            // page
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            try {
                xOffset =
                        Integer.parseInt((coordinateString.split(",")[0])
                                .trim());
                yOffset =
                        Integer.parseInt((coordinateString.split(",")[1])
                                .trim());
            } catch (Exception e) {

                e.printStackTrace();
                reportresult(true, "CLICKAT :" + objectName + "", "FAILED",
                        "CLICKAT coordinate string (" + coordinateString
                                + ") for :Element [" + objectName
                                + "] with Locator : " + objectID
                                + " is invalid");

                checkTrue(false, true, "CLICKAT coordinate string ("
                        + coordinateString + ") " + "for :Element ["
                        + objectName + "] with Locator : " + objectID
                        + " is invalid");
            }
            /*
             * START DESCRIPTION following while loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;
                    // call for real selenium command
                    /* selenium.clickAt(objectID, coordinateString); */

                    Actions clickAt = new Actions(driver);
                    clickAt.moveToElement(element, xOffset, yOffset).click();
                    clickAt.build().perform();
                    // if not exception is called consider and report the result
                    // as passed
                    reportresult(true, "CLICKAT :" + objectName + "", "PASSED",
                            "Clicked at [" + coordinateString
                                    + "] on Element [" + objectName
                                    + "] with Locator : " + objectID);
                    // if the testcase passed move out from the loop
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {

                    sleep(retryInterval);
                    if (!(counter > 0)) {

                        e.printStackTrace();
                        reportresult(true, "CLICKAT :" + objectName + "",
                                "FAILED",
                                "CLICKAT command cannot access Element ["
                                        + locator + "] with Locator : "
                                        + objectID);
                        checkTrue(false, true,
                                "CLICKAT command cannot access Element ["
                                        + objectName + "] with Locator : "
                                        + objectID);
                    }
                }
            }
            /*
             * END DESCRIPTION
             */

        } catch (Exception e) {

            e.printStackTrace();
            /*
             * VTAF result reporter call
             */
            reportresult(true, "CLICKAT :" + objectName + "", "FAILED",
                    "CLICKAT command   :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");

            /*
             * VTAF specific validation framework reporting
             */
            checkTrue(false, true, "CLICKAT command   :Element [ " + objectName
                    + " ] with Locator : " + objectID + " not present");
        }

    }

    ///////////////////////////////////
    
    
    public final void waitForElement(final String objectName,
            final String identifier, final String waitTime) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doWaitForElement(locator, waitTime);
    }

    public final void waitForElement(final String objectName, final String waitTime) {
        waitForElement(objectName, "", waitTime);
    }

    private void doWaitForElement(final ObjectLocator locator, final String waitTime) {
        String objectID = "";
        String locatorLogiName = "";

        try {

            objectID = locator.getActualLocator();
            locatorLogiName = locator.getLogicalName();

            checkForNewWindowPopups();
            checkElementPresenceWait(objectID,waitTime);
            
            reportresult(true, "WaitForElement :" + locator.getLogicalName() + "",
                    "PASSED", "Element is Enable [" + locator.getLogicalName()
                            + "] with Locator : " + locator.getActualLocator());
           

        } catch (Exception e) {

            e.printStackTrace();
            String objectName = locator.getLogicalName();
         
            reportresult(true, "waitForElement :" + objectName + "", "FAILED",
                    "WaitForElementEnable command  :Element [" + objectName
                            + "] with Locator : " + objectID+ "WaitTime :" + waitTime);
          
            checkTrue(false, true, "waitForElement command  :Element [" + objectName
                    + "] with Locator : " +objectID+ "WaitTime :" + waitTime);
        }

    }

    
    
    
    
    
    
    
    
    //////////////////////////////
    
    public final void waitForElementEnable(final String objectName,
            final String identifier) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doWaitForElementEnable(locator);
    }

    public final void waitForElementEnable(final String objectName) {
        waitForElementEnable(objectName, "");
    }

    private void doWaitForElementEnable(final ObjectLocator locator) {
        String objectID = "";
        String locatorLogiName = "";
        int counter = getRetryCount();
        final Long retryMillis = 1000L;
        try {

            objectID = locator.getActualLocator();
            locatorLogiName = locator.getLogicalName();

            checkForNewWindowPopups();
            final WebElement element = checkElementPresence(objectID);

            Wait<WebElement> wait =
                    new FluentWait<WebElement>(element)
                            .withTimeout((counter * retryMillis), TimeUnit.MILLISECONDS)
                            .pollingEvery(retryInterval, TimeUnit.MILLISECONDS)
                            .ignoring(InvalidOperationException.class);

            boolean foo = wait.until(new Function<WebElement, Boolean>() {
                public Boolean apply(WebElement
                        element) {
                    if (element.isEnabled()) {
                        reportresult(true, "WaitForElementEnable :" + locator.getLogicalName() + "",
                                "PASSED", "Element is Enable [" + locator.getLogicalName()
                                        + "] with Locator : " + locator.getActualLocator());
                        return true;
                        
                    } else {
                        throw new InvalidOperationException("");
                    }
                }
            });

        } catch (Exception e) {

            e.printStackTrace();
            String objectName = locator.getLogicalName();
         
            reportresult(true, "WaitForElementEnable :" + objectName + "", "FAILED",
                    "WaitForElementEnable command  :Element [" + objectName
                            + "] with Locator : " + objectID);
          
            checkTrue(false, true, "WaitForElementEnable command  :Element [" + objectName
                    + "] with Locator : " + objectID);
        }

    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad. <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifier
     *            the identifier
     */

    public final void click(final String objectName, final String identifier) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doClick(locator);
    }

    /**
     * Click.
     * 
     * @param objectName
     *            the object name
     */
    public final void click(final String objectName) {
        click(objectName, "");
    }

    /**
     * Clicks on a link, button, checkbox or radio button. If the click action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad. <br>
     * 
     * @param locator
     *            the locator
     */

    private void doClick(final ObjectLocator locator) {
        String objectID = "";
        String locatorLogiName = "";
        int counter = getRetryCount();
        WebDriver driver = getDriver();
        try {
            // Retrieve the correct object locator from the object map
            objectID = locator.getActualLocator();
            locatorLogiName = locator.getLogicalName();
            // first verify whether the element is present in the current web
            // page
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following while loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times untill command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exitted from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;
                    // call for real selenium command
                    /* selenium.click(objectID); */

                    element.click();
                    // if not exception is called consider and report the result
                    // as passed
                    reportresult(true, "CLICK :" + locatorLogiName + "",
                            "PASSED", "Clicked on Element [" + locatorLogiName
                                    + "] with Locator : " + objectID);
                    // if the test case passed move out from the loop
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (ElementNotVisibleException ex) {
                    try {
                        JavascriptExecutor jsExecutor =
                                (JavascriptExecutor) driver;
                        jsExecutor.executeScript("arguments[0].click();",
                                element);
                        reportresult(true, "CLICK :" + locatorLogiName + "",
                                "PASSED", "Clicked on Element [ "
                                        + locatorLogiName + "] with Locator : "
                                        + objectID);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }

                } catch (Exception e) {

                    sleep(retryInterval);
                    String objectName = locator.getLogicalName();
                    if (!(counter > 0)) {

                        e.printStackTrace();
                        reportresult(true, "CLICK :" + objectName + "",
                                "FAILED",
                                "CLICK command cannot access Element ["
                                        + objectName + "] with Locator : "
                                        + objectID);
                        checkTrue(false, true,
                                "CLICK command cannot access Element ["
                                        + objectName + "] with Locator : "
                                        + objectID);
                    }
                }
            }
            /*
             * END DESCRIPTION
             */

        } catch (Exception e) {

            e.printStackTrace();
            String objectName = locator.getLogicalName();
            /*
             * VTAF result reporter call
             */
            reportresult(true, "CLICK :" + objectName + "", "FAILED",
                    "CLICK command  :Element [" + objectName
                            + "] with Locator : " + objectID);
            /*
             * VTAF specific validation framework reporting
             */
            checkTrue(false, true, "CLICK command  :Element [" + objectName
                    + "] with Locator : " + objectID);
        }

    }

    /**
     * Stores a value in a given element property and return it as a double
     * value.
     * 
     * @param objectName
     *            logical name of the object
     * @param identifier
     *            the identifier
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an element TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return the integer property
     */

    public final double getDoubleProperty(final String objectName,
            final String identifier, final String component) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        return doGetDoubleProperty(locator, component);
    }

    /**
     * Gets the double property.
     * 
     * @param objectName
     *            the object name
     * @param component
     *            the component
     * @return the integer property
     */
    public final double getDoubleProperty(final String objectName,
            final String component) {
        return getDoubleProperty(objectName, "", component);
    }

    /**
     * Stores a value in a given element property and return it as a double
     * value.
     * 
     * @param locator
     *            logical name of the object
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/>.
     * @return the int
     */

    private double doGetDoubleProperty(final ObjectLocator locator,
            final String component) {
        String returnValue = "";
        // retrieve the actual object ID from object repository
        String objectID = locator.getActualLocator();

        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            if (component.startsWith("TEXT:")) {

                returnValue =
                        getVarPropertyTextValue(locator, element, component);

            } else if (component.startsWith("VALUE:")) {

                returnValue = element.getAttribute("value");
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "",
                        "PASSED", "Set Variable with Value [" + returnValue
                                + "] of Element [" + locator.getLogicalName()
                                + "] with Locator : " + objectID);
            } else if (component.startsWith("ATTR:")) {

                returnValue =
                        getVarPropertyAttributeValue(locator, element,
                                component);
            }

        } catch (Exception e) {
            /*
             * after the retry amout, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */
            if (e.getMessage().startsWith("Attribute")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty() :Atrribute (" + component
                                + ")of  [" + locator + "] not present");
                checkTrue(false, true, " command setVarProperty() :Atrribute ("
                        + component + ")of  [" + locator + "] not present");
            } else if (e.getMessage().startsWith("Element")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty()  :Element (" + locator
                                + ") [" + objectID + "] not present");
                checkTrue(false, true, " command setVarProperty()  :Element ("
                        + locator + ") [" + objectID + "] not present");
            }
        }
        double returnval = -1;
        try {
            returnval = Double.parseDouble(returnValue);
        } catch (Exception e) {
            reportresult(true, "SET VARIABLE PROPERTY :" + locator, "FAILED",
                    " command setVarProperty() :input value mismatch with double , "
                            + "user input:" + returnValue);

            checkTrue(false, true,
                    " command setVarProperty() :input value mismatch with double ("
                            + "[" + objectID + "user input:" + returnValue);
        }

        return returnval;
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param objectName
     *            logical name of the object
     * @param identifier
     *            the identifier
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return the string property
     */

    public final String getStringProperty(final String objectName,
            final String identifier, final String component) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        return doGetStringProperty(locator, component);
    }

    /**
     * Gets the string property.
     * 
     * @param objectName
     *            the object name
     * @param component
     *            the component
     * @return the string property
     */
    public final String getStringProperty(final String objectName,
            final String component) {
        return getStringProperty(objectName, "", component);
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param locator
     *            logical name of the object
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return the string
     */

    private String doGetStringProperty(final ObjectLocator locator,
            final String component) {

        String returnValue = "";
        // retrieve the actual object ID from object repository
        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();

        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            if (component.startsWith("TEXT:")) {

                returnValue =
                        getVarPropertyTextValue(locator, element, component);

            } else if (component.startsWith("VALUE:")) {

                returnValue = element.getAttribute("value");

                reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "",
                        "PASSED", "Set Variable with Value [" + returnValue
                                + "] of Element [" + objectName
                                + "] with Locator : " + objectID);
            } else if (component.startsWith("ATTR:")) {

                returnValue =
                        getVarPropertyAttributeValue(locator, element,
                                component);
            } else {
                returnValue = validateObjectProperty(element, component);
                reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "."
                        + component, "PASSED", "Set Variable with Value ["
                        + returnValue + "] of Element [" + objectName
                        + "] with Locator : " + objectID);
            }

        } catch (Exception e) {
            /*
             * after the retry amount, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */

            if (e.getMessage().startsWith("Attribute")) {
                String locatorName = locator.getLogicalName();
                reportresult(true, "SET VARIABLE PROPERTY :" + locatorName
                        + "." + component, "FAILED",
                        " command setvarProperty()  :Atrribute (" + component
                                + ") of  [" + locatorName
                                + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, true,
                        " command setvarProperty()  :Atrribute (" + component
                                + ") of  [" + locatorName
                                + " ] with Locator : " + objectID
                                + " not present");
            } else if (e.getMessage().startsWith("Element")) {
                String locatorName = locator.getLogicalName();
                reportresult(true, "SET VARIABLE PROPERTY :" + locatorName
                        + "." + component, "FAILED",
                        " command setvarProperty()   :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, true,
                        " command setvarProperty()   :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " not present");
            }
        }
        return returnValue;
    }

    /**
     * Gets the var property attribute value.
     * 
     * @param locator
     *            the locator
     * @param webElement
     *            the web element
     * @param component
     *            the component
     * @return the var property attribute value
     * @throws Exception
     *             the exception
     */
    private String getVarPropertyAttributeValue(final ObjectLocator locator,
            final WebElement webElement, final String component)
            throws Exception {
        int counter = getRetryCount();
        WebElement element = webElement;
        String returnValue = null;
        final int compSubstrIndex = 5;
        /*
         * START DESCRIPTION following for loop was added to make the command
         * more consistent try the command for give amount of time (can be
         * configured through class variable RETRY) command will be tried for
         * "RETRY" amount of times or until command works. any exception thrown
         * within the tries will be handled internally.
         * 
         * can be exited from the loop under 2 conditions 1. if the command
         * succeeded 2. if the RETRY count is exceeded
         */
        String objectName = locator.getLogicalName();
        String objectID = locator.getActualLocator();
        while (counter > 0) {
            try {
                counter--;

                returnValue =
                        validateObjectProperty(element,
                                component.substring(compSubstrIndex));
                reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "."
                        + component.substring(compSubstrIndex), "PASSED",
                        "Set Variable with Value [" + returnValue
                                + "] of Element [" + objectName
                                + "] with Locator : " + objectID);
                break;
            } catch (StaleElementReferenceException staleElementException) {

                element = checkElementPresence(locator.getActualLocator());
            } catch (Exception e) {
                sleep(retryInterval);
                /*
                 * after the retry amout, if still the object is not found,
                 * report the failure error will be based on the exception
                 * message, if e contains attribute report attribute failure
                 * else if e contains element, report object not found
                 */
                if (!(counter > 0)) {
                    if (e.getMessage().startsWith("Attribute")) {
                        reportresult(true, "SET VARIABLE PROPERTY :" + locator
                                + "." + component.substring(compSubstrIndex),
                                "FAILED",
                                " command setvarProperty()  :Atrribute ("
                                        + component.substring(compSubstrIndex)
                                        + ")of  [" + locator.getLogicalName()
                                        + "] with Locator : " + objectID
                                        + " not present");
                        checkTrue(false, true,
                                " command setvarProperty()  :Atrribute ("
                                        + component.substring(compSubstrIndex)
                                        + ")of  [" + locator
                                        + "] with Locator : " + objectID
                                        + " not present");
                    }

                } else if (e.getMessage().startsWith("Element")) {
                    String logicalName = locator.getLogicalName();
                    String actualLocator = locator.getActualLocator();
                    reportresult(true, "SET VARIABLE PROPERTY :" + logicalName
                            + "." + component.substring(compSubstrIndex),
                            "FAILED", " command setvarProperty()  :Element ["
                                    + logicalName + "] with Locator :"
                                    + actualLocator + " not present");
                    checkTrue(false, true,
                            " command setvarProperty()  :Element ["
                                    + logicalName + "] with Locator :"
                                    + actualLocator + " not present");
                }
            }
        }
        /*
         * END DESCRIPTION
         */
        return returnValue;
    }

    /**
     * Gets the var property text value.
     * 
     * @param locator
     *            the locator
     * @param element
     *            the element
     * @param component
     *            the component
     * @return the var property text value
     */
    private String getVarPropertyTextValue(final ObjectLocator locator,
            final WebElement element, final String component) {
        String returnValue;
        String objectName = locator.getLogicalName();
        String objectID = locator.getActualLocator();
        final int componentAttributes = 3;
        if (component.split(":").length == componentAttributes) {
            returnValue = element.getText();
            if (component.split(":")[1].contains("-")) {
                returnValue =
                        returnValue.substring(Integer.parseInt(component
                                .split(":")[1].split("-")[0]),
                                Integer.parseInt(component.split(":")[1]
                                        .split("-")[1]));
                reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "",
                        "PASSED", "Set Variable with Value [" + returnValue
                                + "] of Element [" + objectName
                                + "] with Locator : " + objectID);
            } else {

                returnValue =
                        returnValue.substring(Integer.parseInt(component
                                .split(":")[1]));
                reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "",
                        "PASSED", "Set Variable with Value [" + returnValue
                                + "] of Element [" + objectName
                                + "] with Locator : " + objectID);
            }
        } else {
            returnValue = element.getText();

            reportresult(true, "SET VARIABLE PROPERTY :" + objectName + "",
                    "PASSED", "Set Variable with Value [" + returnValue
                            + "] of Element [" + objectName
                            + "] with Locator : " + objectID);
        }
        return returnValue;
    }

    /**
     * Fail.
     * 
     * @param message
     *            the message
     */
    public final void fail(final Object message) {
        reportresult(true, "FAIL Command : ", "FAILED", " Failure Massege : ["
                + message + "]");
        SeleneseTestBaseVir.failure(message);
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param objectName
     *            logical name of the object
     * @param identifier
     *            the identifier
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an element TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return the integer property
     */

    public final int getIntegerProperty(final String objectName,
            final String identifier, final String component) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        return doGetIntegerProperty(locator, component);
    }

    /**
     * Gets the integer property.
     * 
     * @param objectName
     *            the object name
     * @param component
     *            the component
     * @return the integer property
     */
    public final int getIntegerProperty(final String objectName,
            final String component) {
        return getIntegerProperty(objectName, "", component);
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param locator
     *            logical name of the object
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/>.
     * @return the int
     */

    private int doGetIntegerProperty(final ObjectLocator locator,
            final String component) {
        String returnValue = "";
        // retrieve the actual object ID from object repository
        String objectID = locator.getActualLocator();

        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            if (component.startsWith("TEXT:")) {

                returnValue =
                        getVarPropertyTextValue(locator, element, component);

            } else if (component.startsWith("VALUE:")) {

                returnValue = element.getAttribute("value");
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "",
                        "PASSED", "Object value = " + returnValue);
            } else if (component.startsWith("ATTR:")) {

                returnValue =
                        getVarPropertyAttributeValue(locator, element,
                                component);
            }

        } catch (Exception e) {
            /*
             * after the retry amout, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */
            if (e.getMessage().startsWith("Attribute")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty() :Atrribute (" + component
                                + ")of  [" + locator + "] not present");
                checkTrue(false, true, " command setVarProperty() :Atrribute ("
                        + component + ")of  [" + locator + "] not present");
            } else if (e.getMessage().startsWith("Element")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty()  :Element (" + locator
                                + ") [" + objectID + "] not present");
                checkTrue(false, true, " command setVarProperty()  :Element ("
                        + locator + ") [" + objectID + "] not present");
            }
        }
        int returnval = 0;
        try {
            returnval = Integer.parseInt(returnValue);
        } catch (Exception e) {
            reportresult(true, "SET VARIABLE PROPERTY :" + locator, "FAILED",
                    " command setVarProperty() :input value mismatch with int, "
                            + "user input:" + returnValue);

            checkTrue(false, true,
                    " command setVarProperty() :input value mismatch with int ("
                            + "[" + objectID + "user input:" + returnValue);
        }

        return returnval;
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param objectName
     *            logical name of the object
     * @param identifier
     *            the identifier
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return the boolean property
     */

    public final boolean getBooleanProperty(final String objectName,
            final String identifier, final String component) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        return doGetBooleanProperty(locator, component);
    }

    /**
     * Gets the boolean property.
     * 
     * @param objectName
     *            the object name
     * @param component
     *            the component
     * @return the boolean property
     */
    public final boolean getBooleanProperty(final String objectName,
            final String component) {
        return getBooleanProperty(objectName, "", component);
    }

    /**
     * Stores a value in a given element property and return it as a string
     * value.
     * 
     * @param locator
     *            logical name of the object
     * @param component
     *            Component specification string <br>
     *            Following is the way user needs to use this parameter<br>
     *            to store a text of an elemt TEXT: to verify a value of an
     *            element VALUE: to get a value of an attribute ATTR:<name of
     *            the attribute/> *
     * @return true, if do get boolean property
     */

    private boolean doGetBooleanProperty(final ObjectLocator locator,
            final String component) {
        String returnValue = "";
        // retrieve the actual object ID from object repository
        String objectID = locator.getActualLocator();

        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            if (component.startsWith("TEXT:")) {

                returnValue =
                        getVarPropertyTextValue(locator, element, component);

            } else if (component.startsWith("VALUE:")) {
                returnValue = element.getAttribute("value");

            } else if (component.startsWith("ATTR:")) {

                returnValue =
                        getVarPropertyAttributeValue(locator, element,
                                component);
            }

        } catch (Exception e) {
            /*
             * after the retry amout, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */

            if (e.getMessage().startsWith("Attribute")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty() :Atrribute (" + component
                                + ")of  [" + locator + "] not present");
                checkTrue(false, true, " command setVarProperty() :Atrribute ("
                        + component + ")of  [" + locator + "] not present");

            } else if (e.getMessage().startsWith("Element")) {
                reportresult(true, "SET VARIABLE PROPERTY :" + locator + "."
                        + component, "FAILED",
                        " command setVarProperty() :Element (" + locator
                                + ") [" + objectID + "] not present");
                checkTrue(false, true, " command setVarProperty() :Element ("
                        + locator + ") [" + objectID + "] not present");
            }
        }

        if ("true".equalsIgnoreCase(returnValue)
                || "false".equalsIgnoreCase(returnValue)) {
            reportresult(true, "SET VARIABLE PROPERTY :" + locator + "",
                    "PASSED", "Object value = " + returnValue);

        } else {
            reportresult(true, "CHECK VARIABLE PROPERTY :" + locator, "FAILED",
                    " command setVarProperty() :input value mismatch with boolean, "
                            + "user input:" + returnValue);

            checkTrue(false, true,
                    " command setVarProperty() :input value mismatch with boolean ("
                            + "[" + objectID + "user input:" + returnValue);
        }
        return Boolean.parseBoolean(returnValue);
    }

    /**
     * Arguments: <br>
     * <br>
     * 
     * windowID - the JavaScript window ID of the window to select<br>
     * 
     * Selects a popup window using a window locator; once a popup window has
     * been selected, all commands go to that window. To select the main window
     * again, use null as the target.<br>
     * <br>
     * 
     * Window locators provide different ways of specifying the window object:
     * by title, by internal JavaScript "name," or by JavaScript variable.<br>
     * <br>
     * 
     * title=My Special Window: Finds the window using the text that appears in
     * the title bar. Be careful; two windows can share the same title. If that
     * happens, this locator will just pick one.<br>
     * name=myWindow: Finds the window using its internal JavaScript "name"
     * property. This is the second parameter "windowName" passed to the
     * JavaScript method window.open(url, windowName, windowFeatures,
     * replaceFlag) (which Selenium intercepts).<br>
     * var=variableName: Some pop-up windows are unnamed (anonymous), but are
     * associated with a JavaScript variable name in the current application
     * window, e.g. "window.foo = window.open(url);". In those cases, you can
     * open the window using "var=foo".<br>
     * <br>
     * 
     * If no window locator prefix is provided, we'll try to guess what you mean
     * like this:<br>
     * <br>
     * 
     * 1.) if windowID is null, (or the string "null") then it is assumed the
     * user is referring to the original window instantiated by the browser).<br>
     * <br>
     * 
     * 2.) if the value of the "windowID" parameter is a JavaScript variable
     * name in the current application window, then it is assumed that this
     * variable contains the return value from a call to the JavaScript
     * window.open() method.<br>
     * <br>
     * 
     * 3.) Otherwise, selenium looks in a hash it maintains that maps string
     * names to window "names".<br>
     * <br>
     * 
     * 4.) If that fails, we'll try looping over all of the known windows to try
     * to find the appropriate "title". Since "title" is not necessarily unique,
     * this may have unexpected behavior.<br>
     * <br>
     * 
     * If you're having trouble figuring out the name of a window that you want
     * to manipulate, look at the Selenium log messages which identify the names
     * of windows created via window.open (and therefore intercepted by
     * Selenium). You will see messages like the following for each window as it
     * is opened:<br>
     * <br>
     * 
     * debug: window.open call intercepted; window ID (which you can use with
     * selectWindow()) is "myNewWindow"<br>
     * <br>
     * 
     * In some cases, Selenium will be unable to intercept a call to window.open
     * (if the call occurs during or before the "onLoad" event, for example).
     * (This is bug SEL-339.) In those cases, you can force Selenium to notice
     * the open window's name by using the Selenium openWindow command, using an
     * empty (blank) url, like this: openWindow("", "myFunnyWindow").<br>
     * <br>
     * 
     * @param windowName
     *            : Logical name of the window assigned by the test scriptor
     * @param identifier
     *            the identifier
     */

    public final void selectWindow(final String windowName,
            final String identifier) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(windowName, identifier);
        ObjectLocator locator =
                new ObjectLocator(windowName, identifier, actualLocator);
        doSelectWindow(locator);
    }

    /**
     * Select window.
     * 
     * @param windowName
     *            the window name
     */
    public final void selectWindow(final String windowName) {
        selectWindow(windowName, "");
    }

    /**
     * Arguments: <br>
     * <br>
     * 
     * windowID - the JavaScript window ID of the window to select<br>
     * 
     * Selects a popup window using a window locator; once a popup window has
     * been selected, all commands go to that window. To select the main window
     * again, use null as the target.<br>
     * <br>
     * 
     * Window locators provide different ways of specifying the window object:
     * by title, by internal JavaScript "name," or by JavaScript variable.<br>
     * <br>
     * 
     * title=My Special Window: Finds the window using the text that appears in
     * the title bar. Be careful; two windows can share the same title. If that
     * happens, this locator will just pick one.<br>
     * name=myWindow: Finds the window using its internal JavaScript "name"
     * property. This is the second parameter "windowName" passed to the
     * JavaScript method window.open(url, windowName, windowFeatures,
     * replaceFlag) (which Selenium intercepts).<br>
     * var=variableName: Some pop-up windows are unnamed (anonymous), but are
     * associated with a JavaScript variable name in the current application
     * window, e.g. "window.foo = window.open(url);". In those cases, you can
     * open the window using "var=foo".<br>
     * <br>
     * 
     * If no window locator prefix is provided, we'll try to guess what you mean
     * like this:<br>
     * <br>
     * 
     * 1.) if windowID is null, (or the string "null") then it is assumed the
     * user is referring to the original window instantiated by the browser).<br>
     * <br>
     * 
     * 2.) if the value of the "windowID" parameter is a JavaScript variable
     * name in the current application window, then it is assumed that this
     * variable contains the return value from a call to the JavaScript
     * window.open() method.<br>
     * <br>
     * 
     * 3.) Otherwise, selenium looks in a hash it maintains that maps string
     * names to window "names".<br>
     * <br>
     * 
     * 4.) If that fails, we'll try looping over all of the known windows to try
     * to find the appropriate "title". Since "title" is not necessarily unique,
     * this may have unexpected behavior.<br>
     * <br>
     * 
     * If you're having trouble figuring out the name of a window that you want
     * to manipulate, look at the Selenium log messages which identify the names
     * of windows created via window.open (and therefore intercepted by
     * Selenium). You will see messages like the following for each window as it
     * is opened:<br>
     * <br>
     * 
     * debug: window.open call intercepted; window ID (which you can use with
     * selectWindow()) is "myNewWindow"<br>
     * <br>
     * 
     * In some cases, Selenium will be unable to intercept a call to window.open
     * (if the call occurs during or before the "onLoad" event, for example).
     * (This is bug SEL-339.) In those cases, you can force Selenium to notice
     * the open window's name by using the Selenium openWindow command, using an
     * empty (blank) url, like this: openWindow("", "myFunnyWindow").<br>
     * <br>
     * 
     * @param locator
     *            : Logical name of the window assigned by the test scriptor
     * 
     * 
     * */
    private void doSelectWindow(final ObjectLocator locator) {
        int counter = getRetryCount();
        String targetWindow = null;
        WebDriver driver = getDriver();

        // Getting the actual object identification from the object map
        String window = locator.getActualLocator();
        try {
            checkForNewWindowPopups();

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or untill command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;

                    targetWindow =
                            getMatchingWindowFromCurrentWindowHandles(driver,
                                    window);

                    if (targetWindow != null) {

                        driver.switchTo().window(targetWindow);

                        driver.manage().window().maximize();
                        focusToCurrentWindow(driver);
                        reportresult(true,
                                "SELECT WINDOW :" + locator.getLogicalName()
                                        + "", "PASSED", "Select Window ["
                                        + window + "]");
                        break;
                    } else {
                        throw new WebDriverException("Window Not Found"
                                + window);
                    }
                } catch (WebDriverException ex) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        String errorString = ex.getMessage();
                        String objectName = locator.getLogicalName();
                        reportresult(
                                true,
                                "SELECT WINDOW :" + objectName + "",
                                "FAILED",
                                "selectWindow command  :Element ("
                                        + objectName
                                        + ") ["
                                        + window
                                        + "] is not accessible. Actual Error : "
                                        + errorString);
                        checkTrue(
                                false,
                                true,
                                "selectWindow command  :Element ("
                                        + objectName
                                        + ") ["
                                        + window
                                        + "] is not accessible. Actual Error : "
                                        + errorString);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            String objectName = locator.getLogicalName();
            // if any exception is raised, report failure
            reportresult(true, "SELECT WINDOW :" + objectName + "", "FAILED",
                    "selectWindow command  :Element (" + objectName + ") ["
                            + window + "] not present");
            checkTrue(false, true, "selectWindow command  :Element ("
                    + objectName + ") [" + window + "] not present");

        }

    }

    /**
     * Focus to current window.
     * 
     * @param driver
     *            the driver
     */
    private void focusToCurrentWindow(final WebDriver driver) {

        try {

            if (driver.getPageSource().toLowerCase(Locale.getDefault())
                    .contains("<html")) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("window.focus();");
            }
        } catch (Exception e) {
            getLog().error(e);

        }
    }

    /**
     * Gets the matching window from current window handles.
     * 
     * @param driver
     *            the driver
     * @param inputWindowName
     *            the input window name
     * @return the matching window from current window handles
     * @throws Exception
     *             the exception
     */
    private String getMatchingWindowFromCurrentWindowHandles(
            final WebDriver driver, final String inputWindowName)
            throws Exception {
        String targetWindow = null;
        Set<String> windowarr = getAllWindows();
        if (inputWindowName.startsWith("index=")) {
            int winIndex =
                    Integer.parseInt(inputWindowName.substring(
                            inputWindowName.indexOf('=') + 1,
                            inputWindowName.length()));
            targetWindow = getOpenWindowHandleIndex().get(winIndex);

        } else {
            boolean objectFound = false;
            for (String windowname : windowarr) {

                if (inputWindowName.startsWith("regexp:")
                        || inputWindowName.startsWith("glob:")) {

                    objectFound =
                            isMatchingPattern(inputWindowName.substring(
                                    inputWindowName.indexOf(':') + 1,
                                    inputWindowName.length()), driver
                                    .switchTo().window(windowname).getTitle());

                } else if (driver.switchTo().window(windowname).getTitle()
                        .equals(inputWindowName)) {
                    objectFound = true;
                }
                if (objectFound) {
                    targetWindow = windowname;
                    break;
                }
            }
        }
        return targetWindow;
    }

    /**
     * Checks if is matching pattern.
     * 
     * @param patternString
     *            the pattern string
     * @param matcherString
     *            the matcher string
     * @return true, if checks if is matching pattern
     */
    private boolean isMatchingPattern(final String patternString,
            final String matcherString) {

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(matcherString);
        return matcher.matches();
    }

    /**
     * Checks if is matching regex.
     *
     * @param patternString
     *            the pattern string
     * @param matcherString
     *            the matcher string
     * @return true, if checks if is matching regex
     */
    private boolean isMatchingRegex(final String patternString,
            final String matcherString) {
        Pattern rgx = Pattern.compile(patternString);
        Matcher mtch = rgx.matcher(matcherString);
        return mtch.find();
    }

    /**
     * Sets the value of an input field, as though you typed it in.<br>
     * Can also be used to set the value of comboboxes, check boxes, etc. In
     * these cases, value should be the value of the option selected, not the
     * visible text.<br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifier
     *            the identifier
     * @param value
     *            : value to be typed in the object
     */

    public final void type(final String objectName, final String identifier,
            final Object value) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doType(locator, value);
    }

    /**
     * Type.
     * 
     * @param objectName
     *            the object name
     * @param value
     *            the value
     */
    public final void type(final String objectName, final Object value) {
        type(objectName, "", value);
    }

    /**
     * Sets the value of an input field, as though you typed it in.<br>
     * Can also be used to set the value of comboboxes, check boxes, etc. In
     * these cases, value should be the value of the option selected, not the
     * visible text.<br>
     * <br>
     * 
     * @param locator
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param objValue
     *            the obj value
     */
    public final void doType(final ObjectLocator locator, final Object objValue) {
        String value = checkNullObject(objValue, "TYPE");

        int counter = getRetryCount();

        // Getting the actual object identification from the object map

        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            try {
                element.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }

            while (counter > 0) {
                try {
                    counter--;
                    // Calling the actual command

                    element.sendKeys(value);

                    reportresult(true, "TYPE :" + objectName + "", "PASSED",
                            " Typed value [" + value + "] on Element ["
                                    + objectName + "] with Locator : "
                                    + objectID);
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        e.printStackTrace();

                        reportresult(true, "TYPE :" + objectName + "",
                                "FAILED",
                                "TYPE command cannot access :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "]" + " [Input value = "
                                        + value + "]");
                        checkTrue(false, true,
                                "TYPE command cannot access :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "]" + " [Input value = "
                                        + value + "]");
                    }
                }

            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            e.printStackTrace();

            reportresult(true, "TYPE :" + objectName + "", "FAILED",
                    "TYPE command  :Element (" + objectName
                            + ") with Locator : [" + objectID
                            + "] [Input value = " + value + "] not present");
            checkTrue(false, true, "TYPE command  :Element (" + objectName
                    + ") with Locator : [" + objectID + "] [Input value = "
                    + value + "] not present");

        }

    }

    /**
     * Select an option\options from a drop-down using an option locator. <br>
     * 
     * Option locators provide different ways of specifying options of an HTML
     * Select element (e.g. for selecting a specific option, or for asserting
     * that the selected option satisfies a specification). There are several
     * forms of Select Option Locator.<br>
     * <br>
     * 
     * <b>label=labelPattern:</b> matches options based on their labels, i.e.
     * the visible text. (This is the default.) label=regexp:^[Oo]ther<br>
     * <b>value=valuePattern:</b> matches options based on their values.
     * value=other<br>
     * <b>id=id:</b> matches options based on their ids. id=option1<br>
     * <b>index=index:</b> matches an option based on its index (offset from
     * zero). index=2<br>
     * <br>
     * 
     * If no option locator prefix is provided, the default behaviour is to
     * match on label. <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter <br>
     * <br>
     * @param identifier
     *            the identifier
     * @param objValue
     *            the obj value
     */

    public final void select(final String objectName, final String identifier,
            final Object objValue) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doSelect(locator, objValue);
    }

    /**
     * Select.
     * 
     * @param objectName
     *            the object name
     * @param objValue
     *            the obj value
     */
    public final void select(final String objectName, final Object objValue) {
        select(objectName, "", objValue);
    }

    /**
     * Select an option\options from a drop-down using an option locator. <br>
     * 
     * Option locators provide different ways of specifying options of an HTML
     * Select element (e.g. for selecting a specific option, or for asserting
     * that the selected option satisfies a specification). There are several
     * forms of Select Option Locator.<br>
     * <br>
     * 
     * <b>label=labelPattern:</b> matches options based on their labels, i.e.
     * the visible text. (This is the default.) label=regexp:^[Oo]ther<br>
     * <b>value=valuePattern:</b> matches options based on their values.
     * value=other<br>
     * <b>id=id:</b> matches options based on their ids. id=option1<br>
     * <b>index=index:</b> matches an option based on its index (offset from
     * zero). index=2<br>
     * <br>
     * 
     * If no option locator prefix is provided, the default behaviour is to
     * match on label. <br>
     * <br>
     * 
     * @param locator
     *            : Logical name of the web element assigned by the automation
     *            scripter <br>
     * <br>
     * @param objValue
     *            the obj value
     */
    private void doSelect(final ObjectLocator locator, final Object objValue) {

        String value = checkNullObject(objValue, "SELECT");
        int counter = getRetryCount();
        String[] actualOptions = {};
        boolean multiSelect = false;
        String objectName = locator.getLogicalName();

        String objectID = locator.getActualLocator();
        try {
            // Checking whether the list box is available
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            // Checking whether the list option is available
            Select selectElement = new Select(element);

            List<WebElement> actualElementOptions = selectElement.getOptions();

            actualOptions = new String[actualElementOptions.size()];
            for (int i = 0; i < actualElementOptions.size(); i++) {
                actualOptions[i] = actualElementOptions.get(i).getText();
            }
            multiSelect = checkSelectOptions(value, actualOptions);

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;

                    if (!multiSelect) {

                        selectSingleOptionFromActualDropdown(selectElement,
                                actualOptions, value);

                        /*
                         * if (!checkSelectedOptionValue(objectID, value)) {
                         * continue; }
                         */

                        reportresult(true, "SELECT :" + objectName + "",
                                "PASSED", "Select Value [" + value
                                        + "] from Element [" + objectName
                                        + "] with Locator : " + objectID);
                        break;
                    } else {

                        selectMultipleOptionFromActualDropDown(selectElement,
                                value);
                        reportresult(true, "SELECT :" + objectName + "",
                                "PASSED", "Select Value [" + value
                                        + "] from Element [" + objectName
                                        + "] with Locator : " + objectID);
                    }

                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                    selectElement = new Select(element);
                } catch (Exception ex) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        ex.printStackTrace();

                        reportresult(true, "SELECT :" + objectName + "",
                                "FAILED",
                                "SELECT command cannot access :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                        checkTrue(false, true,
                                "SELECT command cannot access  :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            // waiting for the maximum amount of waiting time before failing the
            // test case
            // Several checks were introduced to narrow down to the failure to
            // the exact cause.
            ErrorMessageHandler messages = new ErrorMessageHandler();
            String error =
                    messages.getSelectCommandErrorMessages(e.getMessage());
            String formattedError =
                    error.replaceAll("<locator>", objectName)
                            .replaceAll("<objectID>", objectID)
                            .replaceAll("<inputValue>", objValue.toString())
                            .replaceAll("<actualOptions>",
                                    Arrays.asList(actualOptions).toString());

            e.printStackTrace();
            reportresult(true, "SELECT :" + objectName + "", "FAILED",
                    formattedError);
            checkTrue(false, true, formattedError);
        }
    }

    /**
     * Check selected option value.
     * 
     * @param objectID
     *            the object id
     * @param expectedSelectedValue
     *            the expected selected value
     * @return true, if check selected option value
     */
    /*    private boolean checkSelectedOptionValue(final String objectID,
                final String expectedSelectedValue) {

            try {
                WebElement element = checkElementPresence(objectID);
                Select selectElement = new Select(element);
                String selectedValue =
                        selectElement.getFirstSelectedOption().getText();

                if (expectedSelectedValue.startsWith("regexp:")) {

                    Pattern pattern =
                            Pattern.compile(expectedSelectedValue.substring(
                                    expectedSelectedValue.indexOf(':') + 1,
                                    expectedSelectedValue.length()));
                    Matcher matcher = pattern.matcher(selectedValue);
                    return matcher.matches();

                } else if (expectedSelectedValue.startsWith("index=")) {

                    int indexNo =
                            Integer.parseInt(expectedSelectedValue.replace(
                                    "index=", ""));
                    List<WebElement> actualOptions = selectElement.getOptions();
                    List<String> stringOptions = new ArrayList<String>();
                    for (WebElement actualOption : actualOptions) {
                        stringOptions.add(actualOption.getText());
                    }
                    return selectedValue.equals(stringOptions.get(indexNo));

                } else {

                    return selectedValue.equals(expectedSelectedValue);
                }

            } catch (WebDriverException e) {
                return true;
            } catch (Exception e) {
                return true;
            }
        }*/

    /**
     * Select multiple option from actual drop down.
     * 
     * @param selectElement
     *            the select element
     * @param value
     *            the value
     */
    private void selectMultipleOptionFromActualDropDown(
            final Select selectElement, final String value) {

        String[] options = value.split("#");
        for (String option : options) {
            if (option.startsWith("index=")) {

                int indexNo = Integer.parseInt(option.replace("index=", ""));
                selectElement.selectByIndex(indexNo);

            } else {
                selectElement.selectByVisibleText(option);
            }
            break;
        }
    }

    /**
     * Select single option from actual dropdown.
     * 
     * @param selectElement
     *            the select element
     * @param actualOptions
     *            the actual options
     * @param value
     *            the value
     * @return the string
     */
    private String selectSingleOptionFromActualDropdown(
            final Select selectElement, final String[] actualOptions,
            final String value) {
        String selectedValue = "";
        if (value.startsWith("regexp:")) {

            Pattern pattern =
                    Pattern.compile(value.substring(value.indexOf(':') + 1,
                            value.length()));
            for (String actualOption : actualOptions) {
                Matcher matcher = pattern.matcher(actualOption);
                if (matcher.matches()) {
                    selectedValue = actualOption;
                    selectElement.selectByVisibleText(actualOption);
                    break;
                }
            }

        } else if (value.startsWith("index=")) {

            int indexNo = Integer.parseInt(value.replace("index=", ""));

            selectElement.selectByIndex(indexNo);

        } else {
            selectedValue = value;
            selectElement.selectByVisibleText(value);
        }
        return selectedValue;
    }

    /**
     * Sleeps for the specified number of milliseconds.
     * 
     * @param waitingTime
     *            the waiting time
     */
    public final void pause(final String waitingTime) {
        try {
            int waitingMilliSeconds = Integer.parseInt(waitingTime);
            super.sleep(waitingMilliSeconds);
            reportresult(true, "PAUSE Command: (" + waitingMilliSeconds
                    + " ms)", "PASSED", "Paused [" + waitingTime
                    + "] milliseconds");
        } catch (NumberFormatException e) {
            reportresult(true, "PAUSE Command: (" + waitingTime + " ms)",
                    "FAILED", "Invalid arugment passed for wait time.");
            checkTrue(false, true,
                    "PAUSE command : Invalid arugment passed for wait time.");
        }

    }

    /**
     * Double clicks on a link, button, checkbox or radio button. If the double
     * click action causes a new page to load <br>
     * (like a link usually does), call waitForPageToLoad. <br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the object to be doubleclicked.
     * @param identifier
     *            the identifier
     */

    public final void doubleClick(final String objectName,
            final String identifier) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doDoubleClick(locator);
    }

    /**
     * Double click.
     * 
     * @param objectName
     *            the object name
     */
    public final void doubleClick(final String objectName) {
        doubleClick(objectName, "");
    }

    /**
     * Double clicks on a link, button, checkbox or radio button. If the double
     * click action causes a new page to load <br>
     * (like a link usually does), call waitForPageToLoad. <br>
     * <br>
     * 
     * @param locator
     *            the locator
     */

    private void doDoubleClick(final ObjectLocator locator) {
        // Retrieve the actual object name from the object repository

        int counter = getRetryCount();
        WebDriver driver = getDriver();
        String objectName = locator.getLogicalName();
        String objectID = locator.getActualLocator();
        try {
            // First chacking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;
                    element.click();
                    Actions dClick = new Actions(driver);
                    dClick.moveToElement(element).doubleClick();
                    dClick.build().perform();
                    /* selenium.doubleClick(objectID); */
                    reportresult(true, "DOUBLE CLICK :" + objectName + "",
                            "PASSED", "Double Clicked on Element ["
                                    + objectName + "] with Locator : "
                                    + objectID);
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {

                    sleep(retryInterval);
                    if (!(counter > 0)) {

                        e.printStackTrace();
                        reportresult(true, "DOUBLE CLICK :" + objectName + "",
                                "FAILED",
                                "DOUBLE CLICK command cannot access Element ["
                                        + objectName + "] with Locator : "
                                        + objectID);
                        checkTrue(false, true,
                                "DOUBLE CLICK command cannot access Element ["
                                        + objectName + "] with Locator : "
                                        + objectID);
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            // if object not found exception is raised fail the test cases
            e.printStackTrace();
            reportresult(true, "DOUBLE CLICK :" + objectName + "", "FAILED",
                    "DOUBLE CLICK command  :Element [" + objectName
                            + "] with Locator : " + objectID + " not present");
            checkTrue(false, true, "DOUBLE CLICK command  :Element ["
                    + objectName + "] with Locator : " + objectID
                    + " not present");
        }

    }

    /**
     * check(locator) <br>
     * Arguments:<br>
     * locator - an element locator<br>
     * Check a toggle-button (checkbox/radio)<br>
     * <br>
     * .
     * 
     * @param objectName
     *            : logical name of the object assigned by the user
     * @param identifire
     *            :
     * 
     *            Identifier is us to increase the reusablity of the locator.
     *            The usage can be defined using the following examble <br>
     * <br>
     *            assume the following locator is assigned the following logical
     *            object name at the object map <br>
     * <br>
     *            <b>locator :</b> //a[@href='http://www.virtusa.com/']<br>
     *            <b>Name :</b> virtusaLink<br>
     * <br>
     * 
     *            If the user thinks that the locator can be made generalized,
     *            it can be parameterized like the following <br>
     * <br>
     *            //a[@href='http://&LTp1&GT/']<br>
     * <br>
     *            once the method is used, pass the <b>identifier</b> as follows<br>
     *            p1: www.virtusa.com<br>
     * <br>
     *            The absolute xpath will be dynamically generated
     * @param isSelect
     *            : specify whether to check or uncheck the button
     */
    public final void check(final String objectName, final String identifire,
            final boolean isSelect) {
        this.locatorIdentifire = identifire;
        check(objectName, isSelect);
        this.locatorIdentifire = "";
    }

    /**
     * check(locator) <br>
     * Arguments:<br>
     * locator - an element locator<br>
     * Check a toggle-button (checkbox/radio)<br>
     * <br>
     * .
     * 
     * @param objectName
     *            : logical name of the object assigned by the user
     * @param isSelect
     *            : specify whether to check or uncheck the button
     */
    public final void check(final String objectName, final boolean isSelect) {
        int counter = getRetryCount();
        String option = "";
        // Getting the actual object identification from the object map
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;
                    if (isSelect) {
                        option = "Select";
                        // Calling the actual command
                        if (!element.isSelected()) {
                            element.click();
                        }
                        /* selenium.check(objectID); */
                        reportresult(true,
                                "CHECK (Select) :" + objectName + "", "PASSED",
                                "");
                    } else {
                        option = "DeSelect";
                        if (element.isSelected()) {
                            element.click();
                        }
                        /* selenium.uncheck(objectID); */
                        reportresult(true, "CHECK (DeSelect) :" + objectName
                                + "", "PASSED", "");
                    }

                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "CHECK : (" + option + ")"
                                + objectName + "", "FAILED",
                                "CHECK command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");
                        checkTrue(false, true,
                                "CHECK command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");
                    }
                }

            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            e.printStackTrace();
            reportresult(true, "CHECK (" + option + "):" + objectName + "",
                    "FAILED", "CHECK (" + option + ") :Element [" + objectName
                            + "]" + objectID + " not present");
            checkTrue(false, true, "CHECK (" + option + ") :Element  ["
                    + objectName + "]" + objectID + " not present");

        }

    }

    /**
     * Doubleclicks on a link, button, checkbox or radio button. If the action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad.<br>
     * The main differentiator of <b> DoubleClickAt </b> is, user can make the
     * script click on a relative location to the element <br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the object provided by the user
     * @param identifier
     *            the identifier
     * @param coordinateString
     *            the coordinate string
     */

    public final void doubleClickAt(final String objectName,
            final String identifier, final String coordinateString) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doDoubleClickAt(locator, coordinateString);
    }

    /**
     * Double click at.
     * 
     * @param objectName
     *            the object name
     * @param coordinateString
     *            the coordinate string
     */
    public final void doubleClickAt(final String objectName,
            final String coordinateString) {
        doubleClickAt(objectName, "", coordinateString);
    }

    /**
     * Doubleclicks on a link, button, checkbox or radio button. If the action
     * causes a new page to load (like a link usually does), call
     * waitForPageToLoad.<br>
     * The main differentiator of <b> DoubleClickAt </b> is, user can make the
     * script click on a relative location to the element <br>
     * <br>
     * 
     * @param locator
     *            : the coordination string to be click which is relative to the
     *            element <br>
     *            this should be specified using relative X and Y coordinates,
     *            in the following format "X,Y"
     * @param coordinateString
     *            the coordinate string
     */

    private void doDoubleClickAt(final ObjectLocator locator,
            final String coordinateString) {
        int counter = getRetryCount();
        int xOffset = 0;
        int yOffset = 0;
        WebDriver driver = getDriver();
        // Retrieve the actual object identification from the OR
        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        try {

            // Precheck done to check whether the element is available if
            // element is not
            // present, code will move to the catch block and report an error
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            try {
                xOffset =
                        Integer.parseInt((coordinateString.split(",")[0])
                                .trim());
                yOffset =
                        Integer.parseInt((coordinateString.split(",")[1])
                                .trim());
            } catch (Exception e) {

                e.printStackTrace();

                reportresult(true, "DOUBLE CLICK AT :" + objectName + "",
                        "FAILED", "DOUBLE CLICK AT coordinate string ("
                                + coordinateString + ") for :Element ("
                                + objectName + ") with Locator : [" + objectID
                                + "] is invalid");

                checkTrue(false, true, "DOUBLE CLICK AT coordinate string ("
                        + coordinateString + ") " + "for :Element ("
                        + objectName + ") with Locator : [" + objectID
                        + "] is invalid");
            }

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                counter--;
                try {

                    Actions doubleClickAt = new Actions(driver);
                    doubleClickAt.moveToElement(element, xOffset, yOffset)
                            .doubleClick();
                    doubleClickAt.build().perform();

                    reportresult(
                            true,
                            "DOUBLE CLICK AT :" + objectName + "",
                            "PASSED",
                            "Double Clicked at [" + coordinateString
                                    + "] on Element ["
                                    + locator.getLogicalName()
                                    + "] with Locator : " + objectID);
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    // The main possibility of throwing exception at this point
                    // should be due to the element was not
                    // fully loaded, in this catch block handle the exception
                    // untill retry amount of attempts
                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "DOUBLE CLICK AT :" + objectName
                                + "", "FAILED",
                                "DOUBLE CLICK AT command  :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] not present");
                        checkTrue(false, true,
                                "DOUBLE CLICK AT command  :Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] not present");
                    }
                }
            }

            /*
             * END DESCRIPTION
             */

        } catch (Exception e) {
            // if any exception was raised report report an error and fail the
            // test case
            e.printStackTrace();
            reportresult(true, "DOUBLE CLICK AT :" + objectName + "", "FAILED",
                    "DOUBLE CLICK AT command  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
            checkTrue(false, true, "DOUBLE CLICK AT command  :Element [ "
                    + objectName + " ] with Locator : " + objectID
                    + " not present");
        }

    }

    /**
     * checks whether the object referred by the logical id exists.<br>
     * if the object is not exists, further continuation of the script execution
     * will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * 
     * @param objectName
     *            : logical name of the object provided by the user
     * @param identifier
     *            the identifier
     * @param stopExecution
     *            : if <b> true </b> : stop the execution after the failure <br>
     *            if <b> false </b>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */

    public final void checkElementPresent(final String objectName,
            final String identifier, final boolean stopExecution,
            final Object... customError) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doCheckElementPresent(locator, stopExecution, customError);
    }

    /**
     * Check element present.
     * 
     * @param objectName
     *            the object name
     * @param stopExecution
     *            the stop execution
     * @param customError
     *            the custom error
     */
    public final void checkElementPresent(final String objectName,
            final boolean stopExecution, final Object... customError) {
        checkElementPresent(objectName, "", stopExecution, customError);
    }

    /**
     * checks whether the object referred by the logical id exists.<br>
     * if the object is not exists, further continuation of the script execution
     * will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * 
     * @param locator
     *            the locator
     * @param stopExecution
     *            : if <b> true </b> : stop the execution after the failure <br>
     *            if <b> false </b>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */
    private void doCheckElementPresent(final ObjectLocator locator,
            final boolean stopExecution, final Object[] customError) {
        // Retrieve the actual object id from the OR
        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        try {
            // Check whether the element is present, the validation
            checkForNewWindowPopups();
            checkElementPresence(objectID);

            // if reached this point, test case should be passed
            reportresult(
                    true,
                    "CHECK ELEMENT PRESENT :" + objectName + "",
                    "PASSED",
                    "Check Element Present on Element ["
                            + locator.getLogicalName() + "] with Locator : "
                            + objectID);
        } catch (Exception e) {
            // if any exception was thrown the faliure should be reported
            // but the continuation will be decided by stpoExecution
            e.printStackTrace();

            reportresult(
                    stopExecution,
                    "CHECK ELEMENT PRESENT :" + objectName + "",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : command checkElementPresent()  :Element ["
                            + objectName + " ] with Locator : " + objectID
                            + " not present");
            checkTrue(
                    false,
                    stopExecution,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : command checkElementPresent()  :Element [ "
                            + objectName + " ] with Locator : " + objectID
                            + " not present");

        }
    }

    /**
     * checks whether the object referred by the logical id exists.<br>
     * Returs true or false based on the availability of the element. <br>
     * 
     * @param objectName
     *            : logical name of the object provided by the user
     * @return true, if check element present
     */

    public final boolean checkElementPresent(final String objectName) {
        // Retrieve the actual object id from the OR
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        if (objectID.isEmpty()) {
            objectID = objectName;
        }
        boolean isElementPresent = false;
        try {
            // Check whether the element is present, the validation
            objectLocator(objectID);
            return true;

        } catch (Exception e) {
            return isElementPresent;
        }
    }

    /**
     * checks whether the Text referred by the logical id exists.<br>
     * if the text does not exists, further continuation of the script execution
     * will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * 
     * @param objSearchText
     *            the obj search text
     * @param stopOnFailure
     *            : if <b> true </b> : stop the execution after the failure <br>
     *            if <b> false </b>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */
    public final void checkTextPresent(final Object objSearchText,
            final boolean stopOnFailure, final Object... customError) {

        String searchText =
                checkNullObject(objSearchText, "CHECK TEXT PRESENT");
        int counter = getRetryCount();
        // retrieves the objectid from the object repository
        String objectID =
                ObjectMap.getObjectSearchPath(searchText, locatorIdentifire);

        // if, in case, the user has given the search text itself instead of
        // objectid this
        // code segment acts as a contingency

        if ("".equalsIgnoreCase(objectID)) {
            objectID = searchText;
        }
        /*
         * START DESCRIPTION following for loop was added to make the command
         * more consistent try the command for give amount of time (can be
         * configured through class variable RETRY) command will be tried for
         * "RETRY" amount of times or until command works. any exception thrown
         * within the tries will be handled internally.
         * 
         * can be exited from the loop under 2 conditions 1. if the command
         * succeeded 2. if the RETRY count is exceeded
         */
        while (counter > 0) {

            boolean objectFound = false;
            try {
                counter--;

                objectFound = getDriver().getPageSource().contains(objectID);
                if (objectFound) {
                    reportresult(true,
                            "CHECK TEXT PRESENT :" + searchText + "", "PASSED",
                            "Check  Text Present [" + objectID + "]");
                    break;
                }
                sleep(retryInterval);

                if ((!(counter > 0)) && !objectFound) {
                    // if the retry count has exceeded and still the text is not
                    // present,
                    // report a test failure

                    reportresult(
                            stopOnFailure,
                            "CHECK TEXT PRESENT :" + searchText + "",
                            "FAILED",
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error : command checkTextPresent()  :Text ("
                                    + searchText + ") [" + objectID
                                    + "] not present");
                    checkTrue(
                            false,
                            stopOnFailure,
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error : command checkTextPresent()  :Text ("
                                    + searchText + ") [" + objectID
                                    + "] not present");
                    break;

                }
                /*
                 * END DESCRIPTION
                 */
            } catch (Exception e) {

                if (!(counter > 0)) {
                    // if the retry count has exceeded and still the text is not
                    // present,
                    // report a test failure
                    e.printStackTrace();

                    reportresult(
                            stopOnFailure,
                            "CHECK TEXT PRESENT :" + searchText + "",
                            "FAILED",
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error : command checkTextPresent()  :Text ("
                                    + searchText + ") [" + objectID
                                    + "] not present");
                    checkTrue(
                            false,
                            stopOnFailure,
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error : command checkTextPresent()  :Text ("
                                    + searchText + ") [" + objectID
                                    + "] not present");

                }
            }
        }

    }

    /**
     * Checks whether the Object property given by the property name is exists
     * if the property does not exists, further continuation of the script
     * execution will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * in the web page.
     * 
     * @param objectName
     *            : object name alias given by the user.
     * @param identifire
     *            the identifire
     * @param propertyname
     *            : Name of the object property
     * @param expectedvale
     *            : value expected for the given property
     * @param stopOnFailure
     *            :if <I> true </I> : stop the execution after the failure <br>
     *            if <I> false </I>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */
    public final void checkObjectProperty(final String objectName,
            final String identifire, final String propertyname,
            final Object expectedvale, final boolean stopOnFailure,
            final Object... customError) {
        this.locatorIdentifire = identifire;
        checkObjectProperty(objectName, propertyname, expectedvale,
                stopOnFailure, customError);
        this.locatorIdentifire = "";
    }

    /**
     * The Enum ObjectValidationType.
     */
    public static enum ObjectValidationType {

        /** The alloptions. */
        ALLOPTIONS,
        /** The selectedoption. */
        SELECTEDOPTION,
        /** The missingoption. */
        MISSINGOPTION,
        /** The elementpresent. */
        ELEMENTPRESENT,
        /** The propertypresent. */
        PROPERTYPRESENT,
        /** The propertypresent. */
        DISPLAY
    };

    /**
     * Checks whether the Object property given by the property name is exists
     * if the property does not exists, further continuation of the script
     * execution will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * in the web page.
     * 
     * @param objectName
     *            : object name alias given by the user.
     * @param propertyname
     *            : Name of the object property
     * @param objExpectedvale
     *            the obj expectedvale
     * @param stopOnFailure
     *            :if <I> true </I> : stop the execution after the failure <br>
     *            if <I> false </I>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */

    public final void checkObjectProperty(final String objectName,
            final String propertyname, final Object objExpectedvale,
            final boolean stopOnFailure, final Object... customError) {

        String expectedvale =
                checkNullObject(objExpectedvale, "CHECK OBJECT PROPERTY");

        // Call the relavant internal method based on the
        // TableValidationType provided by the user
        if (propertyname.equals(ObjectValidationType.ALLOPTIONS.toString())) {

            checkAllSelectOptions(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);
        } else if (propertyname.equals(ObjectValidationType.SELECTEDOPTION
                .toString())) {

            checkSelectedOption(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);
        } else if (propertyname.equals(ObjectValidationType.MISSINGOPTION
                .toString())) {

            checkMissingOption(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);

        } else if (propertyname.equals(ObjectValidationType.ELEMENTPRESENT
                .toString())) {

            checkElementNotPresent(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);
        } else if (propertyname.equals(ObjectValidationType.PROPERTYPRESENT
                .toString())) {

            checkPropertyPresent(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);
        } else if (propertyname.equals(ObjectValidationType.DISPLAY.toString())) {

            checkElementDisplay(objectName, expectedvale, stopOnFailure,
                    customError);
        } else {

            checkObjectOtherProperty(objectName, propertyname, expectedvale,
                    stopOnFailure, customError);
        }
    }

    /**
     * Check if a property value is present or not in an element.
     * 
     * @param objectName
     *            the object name
     * @param property
     *            the property
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void checkPropertyPresent(final String objectName,
            final String property, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {

        int counter = getRetryCount();
        // retrieve the actual object ID from object repository
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);

        String propertyName = "";
        String condition = "";

        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            try {
                String[] commandSet = expectedvale.split("\\|");
                propertyName = commandSet[0];
                condition = commandSet[1];

            } catch (Exception ex) {

                reportresult(
                        stopOnFailure,
                        "CHECK OBJECT PROPERTY :" + objectName + "." + property,
                        "FAILED",
                        " "
                                + generateCustomError(customError)
                                + " System generated Error :  command checkObjectProperty : User inputs ["
                                + expectedvale
                                + "] are not in the correct format. Correct format: attributeName|condition");
                checkTrue(
                        false,
                        stopOnFailure,
                        " "
                                + generateCustomError(customError)
                                + " System generated Error :  command checkObjectProperty : User inputs ["
                                + expectedvale
                                + "] are not in the correct format. Correct format: attributeName|condition");
                return;

            }
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;
                    boolean isAttributePresent =
                            checkAttributePresent(element, propertyName);
                    if (String.valueOf(isAttributePresent).equalsIgnoreCase(
                            condition.trim())) {
                        reportresult(true, "CHECK OBJECT PROPERTY PRESENT :"
                                + objectName + "." + property, "PASSED",
                                "PROPERTY PRESENT of Element [" + objectName
                                        + "] with Locator : " + objectID
                                        + " | Expected [" + condition
                                        + "] of Property [" + propertyName
                                        + "]");

                        break;
                    } else {
                        reportresult(
                                stopOnFailure,
                                "CHECK OBJECT PROPERTY :" + objectName + "."
                                        + property,
                                "FAILED",
                                " command checkObjectProperty : "
                                        + objectName
                                        + " ] with Locator : "
                                        + objectID
                                        + " OBJECT PROPERTY PRESENT : ["
                                        + property
                                        + "] condition is different from the expected. Actual : "
                                        + isAttributePresent
                                        + " Expected condition : " + condition
                                        + "");
                        checkTrue(
                                false,
                                stopOnFailure,
                                " command checkObjectProperty : "
                                        + objectName
                                        + " ] with Locator : "
                                        + objectID
                                        + " OBJECT PROPERTY PRESENT : ["
                                        + property
                                        + "] condition is different from the expected. Actual : "
                                        + isAttributePresent
                                        + " Expected condition : " + condition
                                        + "");
                        break;
                    }

                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :"
                                + objectName + "." + property, "FAILED",
                                " command checkObjectProperty :Element : ["
                                        + objectName + " ] with Locator : "
                                        + objectID + " is not accessible");
                        checkTrue(false, stopOnFailure,
                                " command checkObjectProperty :Element : ["
                                        + property + " ] with Locator : "
                                        + objectID + " is not accessible");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :" + objectName
                    + "." + property, "FAILED",
                    " command checkObjectProperty :Element : [" + objectName
                            + " ] with Locator : " + objectID
                            + " is not present");
            checkTrue(false, stopOnFailure,
                    " command checkObjectProperty :Element : [" + objectName
                            + " ] with Locator : " + objectID
                            + " is not present");
        }
    }

    /**
     * Check element display.
     * 
     * @param objectName
     *            the object name
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void checkElementDisplay(final String objectName,
            final String expectedvale, final boolean stopOnFailure,
            final Object[] customError) {
        int counter = getRetryCount();
        // retrieve the actual object ID from object repository
        /*
         * String objectID = ObjectMap.getObjectSearchPath(objectName,
         * locatorIdentifire);
         */

        String isObjectDisplay = "false";
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);

        /*
         * START DESCRIPTION following for loop was added to make the command
         * more consistent try the command for give amount of time (can be
         * configured through class variable RETRY) command will be tried for
         * "RETRY" amount of times or until command works. any exception thrown
         * within the tries will be handled internally.
         * 
         * can be exited from the loop under 2 conditions 1. if the command
         * succeeded 2. if the RETRY count is exceeded
         */

        while (counter > 0) {
            try {
                WebElement element = checkElementPresence(objectID);
                counter--;
                isObjectDisplay = String.valueOf(element.isDisplayed());
                if (isObjectDisplay.equalsIgnoreCase(expectedvale)) {
                    reportresult(true, "CHECK OBJECT PROPERTY :" + objectName
                            + ".ELEMENTPRESENT", "PASSED",
                            "DISPLAY of Element [" + objectName
                                    + " ] with Locator : " + objectID
                                    + " | Expected [" + expectedvale + "]");
                    break;
                } else {
                    if (counter < 1) {
                        throw new Exception("Element " + objectName);
                    }
                }

            } catch (Exception e) {
                sleep(retryInterval);

                if (e.getMessage().startsWith("Element")) {

                    reportresult(
                            stopOnFailure,
                            "CHECK OBJECT PROPERTY: " + objectName + ".DISPLAY",
                            "FAILED",
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error :  command checkObjectProperty :Element : ["
                                    + objectName
                                    + " ] with Locator : "
                                    + objectID
                                    + " [DISPLAY] condition is different from actual. Expected :"
                                    + expectedvale + " Actual : "
                                    + isObjectDisplay + "");
                    checkTrue(
                            false,
                            stopOnFailure,
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error :  command checkObjectProperty :Element : ["
                                    + objectName
                                    + " ] with Locator : "
                                    + objectID
                                    + " [DISPLAY] condition is different from actual. Expected :"
                                    + expectedvale + " Actual : "
                                    + isObjectDisplay + "");
                    break;

                } else {
                    reportresult(true, "CHECK OBJECT PROPERTY : " + objectName
                            + ".DISPLAY", "FAILED",
                            " command checkObjectProperty :Element : ["
                                    + objectName + " ] with Locator : "
                                    + objectID + " [DISPLAY] is not accessible");
                    checkTrue(false, stopOnFailure,
                            " command checkObjectProperty :Element : ["
                                    + objectName + " ] with Locator : "
                                    + objectID + " [DISPLAY] is not accessible");
                    break;
                }

            }
        }

    }

    /**
     * Check attribute present.
     * 
     * @param element
     *            the element
     * @param propertyName
     *            the property name
     * @return true, if check attribute present
     */
    private boolean checkAttributePresent(final WebElement element,
            final String propertyName) {

        boolean isAttributePresent;
        if ("textContent".equalsIgnoreCase(propertyName)) {
            String textValue = element.getText();
            if ("".equals(textValue) || textValue == null) {
                isAttributePresent = false;
            } else {
                isAttributePresent = true;
            }
        } else {
            if (element.getAttribute(propertyName.toUpperCase(Locale
                    .getDefault())) != null) {
                isAttributePresent = true;
            } else {
                isAttributePresent = false;
            }
        }
        return isAttributePresent;
    }

    /**
     * Check if a option is not displaying in the webpage.
     * 
     * @param objectName
     *            the object name
     * @param propertyname
     *            the propertyname
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void checkMissingOption(final String objectName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {

        // Object constObj = customError[0];

        int counter = getRetryCount();
        // retrieve the actual object ID from object repository
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            Select selectElement = new Select(element);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;

                    /*
                     * String[] selectOptions = selenium
                     * .getSelectOptions(objectID);
                     */
                    List<WebElement> elementOptions =
                            selectElement.getOptions();
                    String[] selectOptions = new String[elementOptions.size()];
                    for (int i = 0; i < elementOptions.size(); i++) {
                        selectOptions[i] = elementOptions.get(i).getText();
                    }
                    for (String option : selectOptions) {

                        if (option.equals(expectedvale)) {

                            reportresult(
                                    stopOnFailure,
                                    "CHECK OBJECT PROPERTY :" + objectName
                                            + "." + propertyname,
                                    "FAILED",
                                    ""
                                            + generateCustomError(customError)
                                            + " System generated Error :  command checkObjectProperty "
                                            + propertyname + ": OPTION :"
                                            + expectedvale + "  : of object ["
                                            + objectName + " ] with Locator : "
                                            + objectID + " is present");
                            checkTrue(
                                    false,
                                    stopOnFailure,
                                    ""
                                            + generateCustomError(customError)
                                            + " System generated Error :  command checkObjectProperty "
                                            + propertyname + ": OPTION :"
                                            + expectedvale + "  : of object ["
                                            + objectName + " ] with Locator : "
                                            + objectID + " is present");
                            break;

                        }
                    }
                    reportresult(true, "CHECK OBJECT PROPERTY :" + objectName
                            + "." + propertyname, "PASSED",
                            "MISSING OPTION of Element [" + objectName
                                    + "] with Locator : " + objectID
                                    + " | Expected Missing [" + expectedvale
                                    + "]");
                    break;
                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                    selectElement = new Select(element);
                } catch (WebDriverException e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {

                        reportresult(
                                stopOnFailure,
                                "CHECK OBJECT PROPERTY :" + objectName + "."
                                        + propertyname,
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  command checkObjectProperty :Element : ["
                                        + objectName + "] with Locator : "
                                        + objectID + " is not accessible");
                        checkTrue(
                                false,
                                stopOnFailure,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  command checkObjectProperty :Element : ["
                                        + objectName + "] with Locator : "
                                        + objectID + " is not accessible");

                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :" + objectName
                    + "." + propertyname, "FAILED",
                    " command checkObjectProperty :Element : [" + objectName
                            + "] with Locator : " + objectID
                            + " is not present");
            checkTrue(false, stopOnFailure,
                    " command checkObjectProperty :Element : [" + objectName
                            + "] with Locator : " + objectID
                            + " is not present");
        }
    }

    /**
     * Check if a element is displaying or not in the webpage.
     * 
     * @param objectName
     *            the object name
     * @param propertyname
     *            the propertyname
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkElementNotPresent(final String objectName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object... customError) {

        int counter = getRetryCount();
        // retrieve the actual object ID from object repository

        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);

        String isObjectFound = "false";
        /*
         * START DESCRIPTION following for loop was added to make the command
         * more consistent try the command for give amount of time (can be
         * configured through class variable RETRY) command will be tried for
         * "RETRY" amount of times or until command works. any exception thrown
         * within the tries will be handled internally.
         * 
         * can be exited from the loop under 2 conditions 1. if the command
         * succeeded 2. if the RETRY count is exceeded
         */
        while (counter > 0) {
            try {
                counter--;
                isObjectFound = String.valueOf(checkElementPresent(objectName));
                if (isObjectFound.equalsIgnoreCase(expectedvale)) {
                    reportresult(true, "CHECK OBJECT PROPERTY :" + objectName
                            + ".ELEMENTPRESENT", "PASSED",
                            "ELEMENT PRESENET of Element [" + objectName
                                    + "] with Locator : " + objectID
                                    + " | Expected [" + expectedvale + "]");
                    break;
                } else {
                    if (counter < 1) {
                        throw new Exception("Element " + objectName);
                    }
                }

            } catch (Exception e) {
                sleep(retryInterval);

                if (e.getMessage().startsWith("Element")) {

                    reportresult(
                            stopOnFailure,
                            "CHECK OBJECT PROPERTY: " + objectName
                                    + ".ELEMENTPRESENT",
                            "FAILED",
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error :  command checkObjectProperty :Element : ["
                                    + objectName
                                    + "] with Locator : "
                                    + objectID
                                    + " [ELEMENTPRESENT] condition is different from actual. Expected :"
                                    + expectedvale + " Actual : "
                                    + isObjectFound + "");
                    checkTrue(
                            false,
                            stopOnFailure,
                            ""
                                    + generateCustomError(customError)
                                    + " System generated Error :  command checkObjectProperty :Element : ["
                                    + objectName
                                    + "] with Locator : "
                                    + objectID
                                    + " [ELEMENTPRESENT] condition is different from actual. Expected :"
                                    + expectedvale + " Actual : "
                                    + isObjectFound + "");
                    break;

                } else {
                    reportresult(true, "CHECK OBJECT PROPERTY : " + objectName
                            + ".ELEMENTPRESENT", "FAILED",
                            " command checkObjectProperty :Element : ["
                                    + objectName + "] with Locator : "
                                    + objectID
                                    + " [ELEMENTPRESENT] is not accessible");
                    checkTrue(false, stopOnFailure,
                            " command checkObjectProperty :Element : ["
                                    + objectName + "] with Locator : "
                                    + objectID
                                    + " [ELEMENTPRESENT] is not accessible");
                    break;
                }

            }
        }

    }

    /**
     * Checks all the options in a select element. <br>
     * The option value count must be same in actual and expected.
     * 
     * @param objectName
     *            the object name
     * @param propertyname
     *            the propertyname
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void checkAllSelectOptions(final String objectName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {

        int counter = getRetryCount();
        String verificationErrors = "";
        // retrieve the actual object ID from object repository
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            Select selectElement = new Select(element);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            String[] expectedSelectOptions = expectedvale.split(",");
            String[] actualSelectOptions;

            while (counter > 0) {
                try {
                    counter--;

                    actualSelectOptions =
                            getActualOptStringArray(objectName, selectElement,
                                    propertyname, expectedSelectOptions,
                                    stopOnFailure, customError);

                    StringBuilder verificationErrorBuilder =
                            compareActualOptionValuesWithExpected(
                                    actualSelectOptions, expectedSelectOptions);
                    verificationErrors = verificationErrorBuilder.toString();
                    // If there is a mismatch
                    if (!verificationErrors.isEmpty()) {

                        reportresult(
                                stopOnFailure,
                                "CHECK OBJECT PROPERTY :" + objectName + "."
                                        + propertyname,
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : CHECK OBJECT PROPERTY :Element ["
                                        + objectName + "] with Locator : "
                                        + objectID + " Error Str:"
                                        + verificationErrors);

                        // VTAF specific validation framework reporting
                        checkTrue(
                                false,
                                stopOnFailure,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : CHECK OBJECT PROPERTY :Element ("
                                        + objectName + "] with Locator : "
                                        + objectID + " Error Str:"
                                        + verificationErrors);
                        break;

                    } else {
                        reportresult(true, "CHECK OBJECT PROPERTY :"
                                + objectName + "." + propertyname, "PASSED",
                                "ALL OPTIONS in Element [" + objectName
                                        + "] with Locator : " + objectID
                                        + " | Expected [" + expectedvale + "]");
                        break;
                    }

                    // If the length of the input does not match with the
                    // actual option count

                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                    selectElement = new Select(element);
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(stopOnFailure,
                                "CHECK ALL SELECT OPTIONS :" + objectName + "."
                                        + propertyname, "FAILED",
                                " command checkObjectProperty()   :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");
                        checkTrue(false, stopOnFailure,
                                " command checkObjectProperty()   :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            /*
             * after the retry amount, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */
            e.printStackTrace();
            reportresult(stopOnFailure, "CHECK ALL SELECT OPTIONS :"
                    + objectName + "." + propertyname, "FAILED",
                    " command checkObjectProperty()   :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
            checkTrue(false, stopOnFailure,
                    " command checkObjectProperty()   :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
        }
    }

    /**
     * Gets the actual opt string array.
     * 
     * @param objectName
     *            the object name
     * @param selectElement
     *            the select element
     * @param propertyname
     *            the propertyname
     * @param expectedSelectOptions
     *            the expected select options
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     * @return the actual opt string array
     */
    private String[] getActualOptStringArray(final String objectName,
            final Select selectElement, final String propertyname,
            final String[] expectedSelectOptions, final boolean stopOnFailure,
            final Object[] customError) {

        List<WebElement> elementOptions = selectElement.getOptions();
        String[] actualSelectOptions = new String[elementOptions.size()];
        for (int i = 0; i < elementOptions.size(); i++) {
            actualSelectOptions[i] = elementOptions.get(i).getText();
        }
        // Check if the input option count is different from the
        // actual option count
        if (actualSelectOptions.length != expectedSelectOptions.length) {

            reportresult(
                    stopOnFailure,
                    "CHECK OBJECT PROPERTY :" + objectName + "." + propertyname,
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : command checkObjectProperty()  "
                            + ":Expected options count :"
                            + expectedSelectOptions.length + ""
                            + " is diffrernt from the Actual options count : "
                            + actualSelectOptions.length + " of [" + objectName
                            + "] Expected : "
                            + Arrays.toString(expectedSelectOptions)
                            + " Actual : " + ""
                            + Arrays.toString(actualSelectOptions) + "");
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : command checkObjectProperty()  "
                            + ":Expected options count :"
                            + expectedSelectOptions.length + ""
                            + " is diffrernt from the Actual options count : "
                            + actualSelectOptions.length + " of [" + objectName
                            + "] Expected : "
                            + Arrays.toString(expectedSelectOptions)
                            + " Actual : " + ""
                            + Arrays.toString(actualSelectOptions) + "");

            // break;

        }
        return actualSelectOptions;
    }

    /**
     * Compare actual option values with expected.
     * 
     * @param actualSelectOptions
     *            the actual select options
     * @param expectedSelectOptions
     *            the expected select options
     * @return the string builder
     */
    private StringBuilder compareActualOptionValuesWithExpected(
            final String[] actualSelectOptions,
            final String[] expectedSelectOptions) {

        StringBuilder verificationErrorBuilder = new StringBuilder();
        for (int optionIndex = 0; optionIndex < actualSelectOptions.length; optionIndex++) {

            if (!Arrays.asList(actualSelectOptions).contains(
                    expectedSelectOptions[optionIndex])) {

                verificationErrorBuilder
                        .append("\n Option :"
                                + optionIndex
                                + " : "
                                + expectedSelectOptions[optionIndex]
                                + " Option is not available in the actual element. Actual ["
                                + Arrays.toString(actualSelectOptions) + "]");
            }
        }
        return verificationErrorBuilder;
    }

    /**
     * Check the current selected option value in a select element.
     * 
     * @param objectName
     *            the object name
     * @param propertyname
     *            the propertyname
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void checkSelectedOption(final String objectName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {

        int counter = getRetryCount();
        // retrieve the actual object ID from object repository
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            Select selectElement = new Select(element);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;

                    /*
                     * String selectedOptionLabel = selenium
                     * .getSelectedLabel(objectID);
                     */
                    String selectedOptionLabel =
                            selectElement.getFirstSelectedOption().getText();

                    if (selectedOptionLabel.equals(expectedvale)) {

                        reportresult(true, "CHECK OBJECT PROPERTY :"
                                + objectName + "." + propertyname, "PASSED",
                                "SELECTED OPTION of Element [" + objectName
                                        + "] with Locator : " + objectID
                                        + " | Expected Selected ["
                                        + expectedvale + "]");
                        break;
                    } else {

                        reportresult(
                                stopOnFailure,
                                "CHECK OBJECT PROPERTY : " + objectName + "."
                                        + propertyname,
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  object property match Expected:"
                                        + expectedvale + " Actual:"
                                        + selectedOptionLabel);
                        checkTrue(
                                false,
                                stopOnFailure,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  object property match Expected:"
                                        + expectedvale + " Actual:"
                                        + selectedOptionLabel);
                        break;

                    }

                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                    selectElement = new Select(element);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :"
                                + objectName + "." + propertyname, "FAILED",
                                " command checkObjectProperty()  :Element ("
                                        + "[" + objectName
                                        + "] with Locator : " + objectID
                                        + " cannot access element");
                        checkTrue(false, stopOnFailure,
                                " command checkObjectProperty()  :Element ("
                                        + "[" + objectName
                                        + "] with Locator : " + objectID
                                        + " cannot access element");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :" + objectName
                    + "." + propertyname, "FAILED",
                    " command checkObjectProperty()  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
            checkTrue(false, stopOnFailure,
                    " command checkObjectProperty()  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
        }
    }

    /**
     * Check user defined attribute value in the specific element.
     * 
     * @param objectName
     *            the object name
     * @param propertyname
     *            the propertyname
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    private void checkObjectOtherProperty(final String objectName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {
        int counter = getRetryCount();
        // retrieve the actual object ID from object repository
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Checking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;
                    String attributeValue =
                            validateObjectProperty(element, propertyname);
                    if (attributeValue.trim().equals(expectedvale.trim())) {
                        reportresult(true, "CHECK OBJECT PROPERTY :"
                                + objectName + "." + propertyname, "PASSED",
                                "[" + propertyname + "] of Element ["
                                        + objectName + "] with Locator : "
                                        + objectID + " | Expected ["
                                        + expectedvale + "]");
                        break;
                    } else {

                        reportresult(
                                true,
                                "CHECK OBJECT PROPERTY :" + objectName + "."
                                        + propertyname,
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  "
                                        + "object property value match expected. Expected value : "
                                        + expectedvale
                                        + " is not equal to the Actual value : "
                                        + attributeValue);
                        checkTrue(
                                false,
                                stopOnFailure,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error :  "
                                        + "object property value match expected. Expected value : "
                                        + expectedvale
                                        + " is not equal to the Actual value : "
                                        + attributeValue);
                        break;

                    }

                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    /*
                     * after the retry amout, if still the object is not found,
                     * report the failure error will be based on the exception
                     * message, if e contains attribute report attribute failure
                     * else if e contains element, report object not found
                     */
                    if (!(counter > 0)) {
                        if (e.getMessage().startsWith("Attribute")) {
                            reportresult(stopOnFailure,
                                    "CHECK OBJECT PROPERTY :" + objectName
                                            + "." + propertyname, "FAILED",
                                    " command checkObjectProperty() :Atrribute ("
                                            + propertyname + ")of ["
                                            + objectName + " ] with Locator : "
                                            + objectID + " not present");
                            checkTrue(false, stopOnFailure,
                                    " command checkObjectProperty() :Atrribute ("
                                            + propertyname + ")of ["
                                            + objectName + " ] with Locator : "
                                            + objectID + " not present");
                        } else if (e.getMessage().startsWith("Element")) {
                            reportresult(stopOnFailure,
                                    "CHECK OBJECT PROPERTY :" + objectName
                                            + "." + propertyname, "FAILED",
                                    " command checkObjectProperty()  :Element [ "
                                            + objectName + " ] with Locator : "
                                            + objectID + " not present");
                            checkTrue(false, stopOnFailure,
                                    " command checkObjectProperty()  :Element [ "
                                            + objectName + " ] with Locator : "
                                            + objectID + " not present");
                        }
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            /*
             * after the retry amout, if still the object is not found, report
             * the failure error will be based on the exception message, if e
             * contains attribute report attribute failure else if e contains
             * element, report object not found
             */
            reportresult(stopOnFailure, "CHECK OBJECT PROPERTY :" + objectName
                    + "." + propertyname, "FAILED",
                    " command checkObjectProperty()  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
            checkTrue(false, stopOnFailure,
                    " command checkObjectProperty()  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
        }
    }

    /**
     * This is a multipurpose function which performes various validations in a
     * web table. This is the only function provided with the VTAF which does
     * many types of validations in table. Function provides the following
     * validations
     * 
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>Option</th>
     * <th>Description</th>
     * <th>Option specifier</th>
     * <th>Expected data examples</th>
     * <th>expected result</th>
     * <tbody >
     * <tr>
     * <td>
     * Validate Row Count</td>
     * <td>
     * Checks whether the table contains the expected row count.</td>
     * <td>
     * TableValidationType.ROWCOUNT</td>
     * <td>
     * and integer value specifying the row conut <br>
     * E.g. 10.</td>
     * <td>
     * Pass if the table contains the expectd row count</td>
     * </tr>
     * <tr>
     * <td>Validate Table Cell Value</td>
     * <td>Validating whether the expected data is contained in the cell
     * specified by row and column indexes</td>
     * <td>TableValidationType.CELL</td>
     * <td>
     * see the bellow example table
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>id</th>
     * <th>firstname</th>
     * <th>lastname</th>
     * <th>age</th>
     * <tr>
     * <td>1</td>
     * <td>Nadee</td>
     * <td>Navaratne</td>
     * <td>29</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Kanchana</td>
     * <td>Wickramasingha</td>
     * <td>28</td>
     * </tr>
     * <tbody > </tbody>
     * </table>
     * <br>
     * To validate whether data 'Navaratne' exists in cell given by (1,2) <br>
     * where 1 is the row and column is 2, <br>
     * passing data should be given as, <br>
     * 1,2,Navaratne <br>
     * <br>
     * Note that the index numbering for rows and columns starts from 0 <br>
     * inclusive table header</td>
     * 
     * <td>Pass if the expected data exists in the specified cell</td>
     * </tr>
     * <tr>
     * <td>
     * Validate Column Count</td>
     * <td>
     * Checks whether the column count is maching the expected column count</td>
     * <td>
     * TableValidationType.COLCOUNT</td>
     * <td>
     * and integer value specifying the column conut <br>
     * E.g. 2.</td>
     * <td>
     * Pass if the table contains the expectd column count</td>
     * </tr>
     * 
     * 
     * <tr>
     * <td>
     * validating table data</td>
     * <td>
     * Validating whether the expected data is contained in the table</td>
     * <td>
     * TableValidationType.TABLEDATA</td>
     * <td>
     * A comma seperated list of data specifying the values to be tested <br>
     * E.g. Nadee,Navaratne,29</td>
     * <td>
     * Pass if the table contains the data set</td>
     * </tr>
     * 
     * <tr>
     * <td>
     * Relative data validation</td>
     * <td>
     * Validating data in a cell, which is n numbers of cells away from the cell
     * <br>
     * which has the base data</td>
     * <td>
     * TableValidationType.RELATIVE</td>
     * <td>
     * see the bellow example table
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>id</th>
     * <th>first name</th>
     * <th>sur name</th>
     * <th>age</th>
     * <tr>
     * <td>1</td>
     * <td>Nadee</td>
     * <td>Navaratne</td>
     * <td>29</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Kanchana</td>
     * <td>Wickramasingha</td>
     * <td>28</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td>Damith</td>
     * <td>Chandana</td>
     * <td>26</td>
     * </tr>
     * 
     * <tbody > </tbody>
     * </table>
     * E.g. 1 <br>
     * suppose if user wants to check the age of Nadee,So the value should be <br>
     * #Nadee,2,29<br>
     * The above data says, cell which is 2 cells away from Nadee should contain
     * 29<br>
     * <br>
     * 
     * E.g. 2<br>
     * suppose if we need to validate the ages of all three users <br>
     * the passing data shlould be<br>
     * #Nadee,2,29#Kanchana,2,28#Damith,2,26 <br>
     * <br>
     * 
     * E.g. 3 <br>
     * suppose the data we know is different,<br>
     * we know<br>
     * first name of the first user<br>
     * sur name of the second user<br>
     * id of the third user<br>
     * <br>
     * 
     * the string to validate age should be <br>
     * #Nadee,2,29#Wickramasingha,1,28#3,3,26 W *</td>
     * <td>
     * Pass if the table contains the data set</td>
     * </tr>
     * 
     * </tbody>
     * </table>
     * 
     * @param objectName
     *            Logical name of the object
     * @param identifire
     *            identifier is us to increase the reusability of the locator.
     *            The usage can be defined using the following example <br>
     * <br>
     *            assume the following locator is assigned the following logical
     *            object name at the object map <br>
     * <br>
     *            <b>locator :</b> //a[@href='http://www.virtusa.com/']<br>
     *            <b>Logical Name :</b> virtusaLink<br>
     * <br>
     * 
     *            If the user thinks that the locator can be made generalized,
     *            it can be parameterized like the following <br>
     * <br>
     *            //a[@href='http://&LTp1&GT/']<br>
     * <br>
     *            once the method is used, pass the <b>identifier</b> as follows<br>
     *            p1: www.virtusa.com<br>
     * <br>
     *            The absolute xpath will be dynamically generated
     * @param validationType
     *            validation type code please refer the above table for detailed
     *            information
     * @param expectedvale
     *            value\value string which will be provided by the user to
     *            specify the expected result
     * @param stopOnFaliure
     *            specify the continuation of the test script if the validation
     *            fails
     * @param customError
     *            the custom error
     */

    public final void checkTable(final String objectName,
            final String identifire, final String validationType,
            final Object expectedvale, final boolean stopOnFaliure,
            final Object... customError) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifire);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifire, actualLocator);
        doCheckTable(locator, validationType, expectedvale, stopOnFaliure,
                customError);

    }

    /**
     * Check table.
     * 
     * @param objectName
     *            the object name
     * @param validationType
     *            the validation type
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    public final void checkTable(final String objectName,
            final String validationType, final Object expectedvale,
            final boolean stopOnFaliure, final Object... customError) {
        checkTable(objectName, "", validationType, expectedvale, stopOnFaliure,
                customError);
    }

    /**
     * This is a multipurpose function which performes various validations in a
     * web table. This is the only function provided with the VTAF which does
     * many types of validations in table. Function provides the following
     * validations
     * 
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>Option</th>
     * <th>Description</th>
     * <th>Option specifier</th>
     * <th>Expected data examples</th>
     * <th>expected result</th>
     * <tbody >
     * <tr>
     * <td>
     * Validate Row Count</td>
     * <td>
     * Checks whether the table contains the expected row count.</td>
     * <td>
     * TableValidationType.ROWCOUNT</td>
     * <td>
     * and integer value specifying the row conut <br>
     * E.g. 10.</td>
     * <td>
     * Pass if the table contains the expectd row count</td>
     * </tr>
     * <tr>
     * <td>Validate Table Cell Value</td>
     * <td>Validating whether the expected data is contained in the cell
     * specified by row and column indexes</td>
     * <td>TableValidationType.CELL</td>
     * <td>
     * see the bellow example table
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>id</th>
     * <th>firstname</th>
     * <th>lastname</th>
     * <th>age</th>
     * <tr>
     * <td>1</td>
     * <td>Nadee</td>
     * <td>Navaratne</td>
     * <td>29</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Kanchana</td>
     * <td>Wickramasingha</td>
     * <td>28</td>
     * </tr>
     * <tbody > </tbody>
     * </table>
     * <br>
     * To validate whether data 'Navaratne' exists in cell given by (1,2) <br>
     * where 1 is the row and column is 2, <br>
     * passing data should be given as, <br>
     * 1,2,Navaratne <br>
     * <br>
     * Note that the index numbering for rows and columns starts from 0 <br>
     * inclusive table header</td>
     * 
     * <td>Pass if the expected data exists in the specified cell</td>
     * </tr>
     * <tr>
     * <td>
     * Validate Column Count</td>
     * <td>
     * Checks whether the column count is maching the expected column count</td>
     * <td>
     * TableValidationType.COLCOUNT</td>
     * <td>
     * and integer value specifying the column conut <br>
     * E.g. 2.</td>
     * <td>
     * Pass if the table contains the expectd column count</td>
     * </tr>
     * 
     * 
     * <tr>
     * <td>
     * validating table data</td>
     * <td>
     * Validating whether the expected data is contained in the table</td>
     * <td>
     * TableValidationType.TABLEDATA</td>
     * <td>
     * A comma seperated list of data specifying the values to be tested <br>
     * E.g. Nadee,Navaratne,29</td>
     * <td>
     * Pass if the table contains the data set</td>
     * </tr>
     * 
     * <tr>
     * <td>
     * Relative data validation</td>
     * <td>
     * Validating data in a cell, which is n numbers of cells away from the cell
     * <br>
     * which has the base data</td>
     * <td>
     * TableValidationType.RELATIVE</td>
     * <td>
     * see the bellow example table
     * <table TABLE BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
     * <th>id</th>
     * <th>first name</th>
     * <th>sur name</th>
     * <th>age</th>
     * <tr>
     * <td>1</td>
     * <td>Nadee</td>
     * <td>Navaratne</td>
     * <td>29</td>
     * </tr>
     * <tr>
     * <td>2</td>
     * <td>Kanchana</td>
     * <td>Wickramasingha</td>
     * <td>28</td>
     * </tr>
     * <tr>
     * <td>3</td>
     * <td>Damith</td>
     * <td>Chandana</td>
     * <td>26</td>
     * </tr>
     * 
     * <tbody > </tbody>
     * </table>
     * E.g. 1 <br>
     * suppose if user wants to check the age of Nadee,So the value should be <br>
     * #Nadee,2,29<br>
     * The above data says, cell which is 2 cells away from Nadee should contain
     * 29<br>
     * <br>
     * 
     * E.g. 2<br>
     * suppose if we need to validate the ages of all three users <br>
     * the passing data shlould be<br>
     * #Nadee,2,29#Kanchana,2,28#Damith,2,26 <br>
     * <br>
     * 
     * E.g. 3 <br>
     * suppose the data we know is different,<br>
     * we know<br>
     * first name of the first user<br>
     * sur name of the second user<br>
     * id of the third user<br>
     * <br>
     * 
     * the string to validate age should be <br>
     * #Nadee,2,29#Wickramasingha,1,28#3,3,26 W *</td>
     * <td>
     * Pass if the table contains the data set</td>
     * </tr>
     * 
     * </tbody>
     * </table>
     * 
     * @param locator
     *            the locator
     * @param validationTypeS
     *            the validation type s
     * @param objExpectedvale
     *            the obj expectedvale
     * @param stopOnFaliure
     *            specify the continuation of the test script if the validation
     *            fails
     * @param customError
     *            the custom error
     */
    private void doCheckTable(final ObjectLocator locator,
            final String validationTypeS, final Object objExpectedvale,
            final boolean stopOnFaliure, final Object[] customError) {

        /*
         * TableValidationType validationType =
         * TableValidationType.valueOf(validationTypeS);
         */
        String validationType = validationTypeS;

        String expectedvale = checkNullObject(objExpectedvale, "CHECK TABLE");

        String objectName = locator.getLogicalName();
        String objectID = locator.getActualLocator();

        // load the actual object id from the OR
        // objectID = ObjectMap.getObjectSearchPath(objectName,
        // locatorIdentifire);
        try {
            // checks the element presence
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            // Call the relavant internal method based on the
            // TableValidationType provided by the user
            try {
                if (TableValidationType.ROWCOUNT.toString().equals(
                        validationType)) {

                    validateTableRowCount(element, objectID, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.COLCOUNT.toString().equals(
                        validationType)) {

                    validateTableColCount(element, objectID, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.TABLEDATA.toString().equals(
                        validationType)) {

                    compareTableData(element, objectID, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.RELATIVE.toString().equals(
                        validationType)) {

                    validateTableOffset(element, objectID, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.TABLECELL.toString().equals(
                        validationType)) {

                    validateCellValue(element, objectID, expectedvale,
                            stopOnFaliure, customError);
                } else {
                    reportresult(
                            true,
                            "CHECK TABLE :" + validationType + " :",
                            "FAILED",
                            "Unknown validation type passed :"
                                    + " "
                                    + validationTypeS
                                    + ". Accepted validation types : "
                                    + "ROWCOUNT , COLCOUNT , TABLEDATA , RELATIVE , TABLECELL");
                    checkTrue(
                            false,
                            stopOnFaliure,
                            "Unknown validation type passed :"
                                    + " "
                                    + validationTypeS
                                    + ". Accepted validation types : "
                                    + "ROWCOUNT , COLCOUNT , TABLEDATA , RELATIVE , TABLECELL ");
                }

            } catch (Exception e) {
                // waiting for the maximum amount of waiting time before
                // failing the test case
                // Several checks were introduced to narrow down to the
                // failure to the exact cause.

                reportresult(true, "CHECK TABLE :" + validationType + " :"
                        + objectName + "", "FAILED",
                        "command checkTable()  :Element [" + objectName
                                + " ] with Locator : " + objectID
                                + " is not accessible");
                checkTrue(false, stopOnFaliure,
                        " command checkTable()  :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " is not accessible");

            }
        } catch (Exception e) {
            // if object is not present catch the exception and repor the
            // error
            e.printStackTrace();
            reportresult(true, "CHECK TABLE :" + validationType + " :"
                    + objectName + "", "FAILED", " :Element [ " + objectName
                    + " ] with Locator : " + objectID + " not present");
            checkTrue(false, stopOnFaliure,
                    " command checkTable()  ] with Locator :Element [ "
                            + objectName + " ] with Locator : " + objectID
                            + " not present");
        }

    }

    /**
     * Gets the object count.
     * 
     * @param objectName
     *            the object name
     * @param identifire
     *            the identifire
     * @return the object count
     */
    public final int getObjectCount(final String objectName,
            final String identifire) {
        this.locatorIdentifire = identifire;
        int objCount = getObjectCount(objectName);
        this.locatorIdentifire = "";
        return objCount;
    }

    /**
     * Select an option\options from a drop-down using an option locator. <br>
     * 
     * Option locators provide different ways of specifying options of an HTML
     * Select element (e.g. for selecting a specific option, or for asserting
     * that the selected option satisfies a specification). There are several
     * forms of Select Option Locator.<br>
     * <br>
     * 
     * <b>label=labelPattern:</b> matches options based on their labels, i.e.
     * the visible text. (This is the default.) label=regexp:^[Oo]ther<br>
     * <b>value=valuePattern:</b> matches options based on their values.
     * value=other<br>
     * <b>id=id:</b> matches options based on their ids. id=option1<br>
     * <b>index=index:</b> matches an option based on its index (offset from
     * zero). index=2<br>
     * <br>
     * 
     * If no option locator prefix is provided, the default behaviour is to
     * match on label. <br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter <br>
     * <br>
     * @return the object count
     */
    public final int getObjectCount(final String objectName) {
        int counter = getRetryCount();
        int objectCount = 0;
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        WebDriver driver = getDriver();
        try {

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;

                    List<WebElement> elements =
                            driver.findElements(getLocatorType(objectID));
                    objectCount = elements.size();
                    reportresult(true, "GET OBJECT COUNT :" + objectName + "",
                            "PASSED", "Get Object Count on :Element [ "
                                    + objectName + " ] with Locator : "
                                    + objectID + " " + " | Count : ["
                                    + objectCount + "]");
                    break;
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "GET OBJECT COUNT :" + objectName
                                + "", "FAILED",
                                "getObjectCount command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID);
                        checkTrue(false, true,
                                "getObjectCount command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID);
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            // waiting for the maximum amount of waiting time before failing the
            // test case
            // Several checks were introduced to narrow down to the failure to
            // the exact cause.
            if (!(counter > 0)) {
                e.printStackTrace();
                reportresult(true, "SELECT :" + objectName + "", "FAILED",
                        "GET OBJECT COUNT command  :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, true, "GET OBJECT COUNT command  :Element [ "
                        + objectName + " ] with Locator : " + objectID
                        + " not present");
            } else if ("Element".equalsIgnoreCase(e.getMessage())) {
                e.printStackTrace();
                reportresult(true, "GET OBJECT COUNT :" + objectName + "",
                        "FAILED", "GET OBJECT COUNT command  :Element [ "
                                + objectName + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, true, "GET OBJECT COUNT command  :Element [ "
                        + objectName + " ] with Locator : " + objectID
                        + " not present");

            }

        }
        return objectCount;
    }

    /**
     * Validate table cell value function.
     * 
     * @param element
     *            the element
     * @param objectName
     *            the object name
     * @param expectedvalue
     *            the expectedvalue
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @throws Exception
     *             the exception
     */
    private void validateCellValue(final WebElement element,
            final String objectName, final String expectedvalue,
            final boolean fail, final Object[] customError) throws Exception {

        ArrayList<String> inputStringArray;
        boolean failedOnce = false;
        int row = -1;
        int col = -1;
        String cellText = "";
        String result = "";
        ArrayList<String> htmlTable = new ArrayList<String>();
        final int inputStringItems = 3;

        inputStringArray =
                new ArrayList<String>(Arrays.asList(expectedvalue.split(
                        "(?<!\\\\),", Integer.MAX_VALUE)));

        ArrayList<String> tempInputTable = new ArrayList<String>();
        for (String inputVal : inputStringArray) {
            String formattedValue = inputVal.replaceAll("\\\\,", ",");
            tempInputTable.add(formattedValue);
        }
        inputStringArray = tempInputTable;

        if (inputStringArray.size() < inputStringItems) {
            failedOnce = true;

            result = " verification data not provided correctly";
            reportresult(true, "CHECK TABLE :TABLE CELL", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + objectName
                    + "'s  CELL validation " + " is not as expected  " + result);
            checkTrue(false, fail, objectName + ""
                    + generateCustomError(customError)
                    + " System generated Error : " + objectName
                    + "'s  CELL validation " + " is not as expected  " + result);
            return;

        }
        row = Integer.parseInt(inputStringArray.get(0));
        col = Integer.parseInt(inputStringArray.get(1));

        cellText =
                StringUtils.join(
                        inputStringArray.subList(2, inputStringArray.size())
                                .toArray(), ",");

        try {
            htmlTable = getAppTableRow(element, row);
        } catch (Exception ex) {
            failedOnce = true;
            result =
                    result + "|Expected Row : " + row
                            + " cannot be found in the actual table \n";
        }

        int verifyIndex = col; // get the sequential index of the value to be
                               // verified

        String verifyValue = "";

        try {
            verifyValue = htmlTable.get(verifyIndex).trim();

            if (!cellText.equals(verifyValue)) {
                failedOnce = true;
                result =
                        result + "|Expected : " + cellText + " Actual :"
                                + htmlTable.get(verifyIndex) + "\n";

            }

        } catch (IndexOutOfBoundsException ex) {
            failedOnce = true;
            result =
                    result + "|Expected Column : " + verifyIndex
                            + " cannot be found in the actual table \n";
        }

        if (failedOnce) {
            reportresult(true, "CHECK TABLE :TABLE CELL", "FAILED", objectName
                    + "'s  TABLECELL validation " + " is not as expected  "
                    + result);
            checkTrue(false, fail, objectName + "'s  TABLECELL validation "
                    + " is not as expected  " + result);

        } else {

            reportresult(true, "CHECK TABLE :TABLE CELL", "PASSED",
                    "CHECK TABLE :TABLE CELL (" + objectName + ") | Expected ["
                            + expectedvalue + "]");
        }

    }

    /**
     * Validate table offset function.
     * 
     * @param element
     *            the element
     * @param objectName
     *            the object name
     * @param expectedvalue
     *            the expectedvalue
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @throws Exception
     *             the exception
     */
    private void validateTableOffset(final WebElement element,
            final String objectName, final String expectedvalue,
            final boolean fail, final Object[] customError) throws Exception {

        ArrayList<String> inputStringArray;
        String parentText = "";
        Integer offset;
        String cellText = "";
        String inputStringCurrStr = "";
        String result = "";
        ArrayList<String> htmlTable;

        htmlTable = getAppTable(element);
        StringBuilder resultBuilder = new StringBuilder();

        ArrayList<String> inputStringCurrArray;
        inputStringArray =
                new ArrayList<String>(Arrays.asList(expectedvalue.split("#")));

        for (int i = 0; i < inputStringArray.size(); i++) {

            // Split the string to parts and entered to an array NAMED
            // inputTable

            // Getting the values out
            inputStringCurrStr = inputStringArray.get(i);

            inputStringCurrArray =
                    new ArrayList<String>(Arrays.asList(inputStringCurrStr
                            .split("(?<!\\\\),", Integer.MAX_VALUE)));

            ArrayList<String> tempInputTable = new ArrayList<String>();
            for (String inputVal : inputStringCurrArray) {
                String formattedValue = inputVal.replaceAll("\\\\,", ",");
                tempInputTable.add(formattedValue);
            }
            inputStringCurrArray = tempInputTable;

            parentText = inputStringCurrArray.get(0);
            offset = Integer.valueOf(inputStringCurrArray.get(1));
            cellText = inputStringCurrArray.get(2);
            resultBuilder
                    .append(checkIfTheTableContainsTheExpectedRelativeValue(
                            htmlTable, parentText, offset, cellText));
        }

        result = resultBuilder.toString();
        if (!result.isEmpty()) {

            reportresult(fail, "CHECK TABLE :RELATIVE", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + objectName
                    + "'s  RELATIVE validation " + " is not as expected  "
                    + result);
            checkTrue(false, fail, objectName + ""
                    + generateCustomError(customError)
                    + " System generated Error : " + objectName
                    + "'s  RELATIVE validation " + " is not as expected  "
                    + result);

        } else {

            reportresult(true, "CHECK TABLE :RELATIVE", "PASSED",
                    "CHECK TABLE :RELATIVE (" + objectName + ") | Expected ["
                            + expectedvalue + "]");
        }

    }

    /**
     * Check if the table contains the expected relative value.
     * 
     * @param htmlTable
     *            the html table
     * @param parentText
     *            the parent text
     * @param offset
     *            the offset
     * @param cellText
     *            the cell text
     * @return the string
     */
    private String checkIfTheTableContainsTheExpectedRelativeValue(
            final List<String> htmlTable, final String parentText,
            final int offset, final String cellText) {
        int indexParent;
        StringBuilder resultBuilder = new StringBuilder();
        if (htmlTable.contains(parentText)) {

            ArrayList<Integer> parentTextIndexList = new ArrayList<Integer>();
            for (int k = 0; k < htmlTable.size(); k++) {
                if (htmlTable.get(k).equals(parentText)) {
                    parentTextIndexList.add(k);
                }
            }
            for (int j = 0; j < parentTextIndexList.size(); j++) {

                // indexParent = htmlTable.indexOf(parentText);
                indexParent = parentTextIndexList.get(j);
                String actualText = "";
                try {
                    actualText = htmlTable.get((indexParent + offset));
                    if (!cellText.equals(actualText)) {
                        // failedOnce = true;
                        resultBuilder.append("|Expected : " + cellText
                                + " Actual :" + actualText + " Base value : "
                                + parentText + "\n");
                    } else {
                        break;
                    }

                } catch (IndexOutOfBoundsException ex) {
                    resultBuilder
                            .append("|Expected value : " + cellText
                                    + " cannot be found in the field: "
                                    + (indexParent + offset)
                                    + " in the actual table\n");
                }
            }
        } else {
            resultBuilder.append("|Expected RELATIVE text: " + parentText
                    + " is not present in the actual table \n");
        }
        return resultBuilder.toString();
    }

    /**
     * Validate table row count function.
     * 
     * @param element
     *            the element
     * @param tableName
     *            the Table name
     * @param expectedValue
     *            the expected value
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @return the int
     */
    private int validateTableRowCount(final WebElement element,
            final String tableName, final String expectedValue,
            final boolean fail, final Object[] customError) {
        /* TableName = TableName.replace("\"", "\\\""); */
        int rowCount = 0;
        try {
            /*
             * JS = "this.browserbot.findElement(\"" + TableName + "\")" +
             * ".rows.length.toString()";
             */
            rowCount = element.findElements(By.tagName("tr")).size();
            /* rowCount = selenium.getEval(JS); */

            if (rowCount == Integer.parseInt(expectedValue)) {
                reportresult(true, "CHECK TABLE :ROW COUNT", "PASSED",
                        "CHECK TABLE :ROW COUNT (" + tableName
                                + ") | Expected [" + expectedValue + "]");

            } else {

                reportresult(true, "CHECK TABLE :ROW COUNT", "FAILED", ""
                        + generateCustomError(customError)
                        + " System generated Error : CHECK TABLE :ROW COUNT"
                        + tableName + "| Expected :" + expectedValue
                        + " |Actual : " + rowCount);
                checkTrue(false, fail, "" + generateCustomError(customError)
                        + " System generated Error : CHECK TABLE :ROW COUNT"
                        + tableName + "| Expected :" + expectedValue
                        + " |Actual : " + rowCount);

            }

        } catch (Exception e) {
            e.printStackTrace();

            reportresult(fail, "CHECK TABLE :ROW COUNT :", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + e.getMessage());
            checkTrue(false, fail, "" + generateCustomError(customError)
                    + " System generated Error : " + e.getMessage());

        }
        return rowCount;
    }

    /**
     * validate Table Column count function.
     * 
     * @param element
     *            the element
     * @param tableName
     *            the Table name
     * @param expectedValue
     *            the expected value
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @return the int
     */
    private int validateTableColCount(final WebElement element,
            final String tableName, final String expectedValue,
            final boolean fail, final Object[] customError) {

        List<WebElement> rowElements = null;
        int actualdValue = 0;
        /* TableName = TableName.replace("\"", "\\\""); */
        try {
            /*
             * JS = "this.browserbot.findElement(\"" + TableName + "\")" +
             * ".rows[0].cells.length.toString()";
             */
            // String colCount = selenium.getEval(JS);
            rowElements = element.findElements(By.tagName("tr"));
            actualdValue =
                    rowElements.get(1).findElements(By.tagName("td")).size();

            // actualdValue = selenium.getEval(JS);

            if (actualdValue == Integer.parseInt(expectedValue)) {
                reportresult(true, "CHECK TABLE :COLUMN COUNT ", "PASSED",
                        " CHECK TABLE :COLUMN COUNT (" + tableName
                                + ") | Expected [" + expectedValue + "]");

            } else {

                reportresult(fail, "CHECK TABLE :COLUMN COUNT", "FAILED", ""
                        + generateCustomError(customError) + "Table :("
                        + tableName + ") System generated Error : Expected :"
                        + expectedValue + " |Actual : " + actualdValue);
                checkTrue(false, fail, "" + generateCustomError(customError)
                        + "Table :(" + tableName
                        + ") System generated Error : Expected :"
                        + expectedValue + " |Actual : " + actualdValue);

            }

        } catch (Exception e) {
            e.printStackTrace();
            reportresult(fail, "CHECK TABLE :COLUMN COUNT", "FAILED",
                    e.getMessage());
            checkTrue(false, fail, e.getMessage());
        }
        return actualdValue;

    }

    /**
     * Reads the online table and load the contents to an arraylist.
     * 
     * @param element
     *            the element
     * @return the app table
     * @throws Exception
     *             the exception
     */
    private ArrayList<String> getAppTable(final WebElement element)
            throws Exception {

        WebElement rowElement;
        List<WebElement> columnElements;
        List<WebElement> rowElements;

        ArrayList<String> htmlTable = new ArrayList<String>();

        /* locator = locator.replace("\"", "\\\""); */

        /*
         * JS = "this.browserbot.findElement(\"" + locator +
         * "\") .rows.length.toString()";
         * 
         * Integer rowNum = Integer.parseInt(selenium.getEval(JS));
         */

        rowElements = element.findElements(By.tagName("tr"));
        int rowNum = rowElements.size();

        if (rowNum > 0) {
            /*
             * JS = "this.browserbot.findElement(\"" + locator + "\")" +
             * ".rows[0].cells.length.toString()";
             * 
             * Integer colNum = Integer.parseInt(selenium.getEval(JS));
             */
            /* locator = locator.replace("\\\"", "\""); */
            String value = "";
            for (int i = 0; i < rowNum; i++) {

                rowElement = rowElements.get(i);

                columnElements = rowElement.findElements(By.tagName("td"));
                if (columnElements.isEmpty()) {
                    columnElements = rowElement.findElements(By.tagName("th"));
                }

                int colNum = columnElements.size();

                for (int j = 0; j < colNum; j++) {

                    value = columnElements.get(j).getText();
                    // value = selenium.getTable(locator + "." + i + "." + j);

                    if (value != null) {
                        htmlTable.add(value);
                    } else {
                        htmlTable.add("");
                    }
                }
            }
        } else {
            throw new Exception();

        }
        return htmlTable;
    }

    /**
     * Reads the online table and load the contents to an arraylist.
     * 
     * @param element
     *            the element
     * @param row
     *            the row
     * @return the app table row
     * @throws Exception
     *             the exception
     */
    private ArrayList<String> getAppTableRow(final WebElement element,
            final int row) throws Exception {

        List<WebElement> rowElements;
        List<WebElement> colElements;
        WebElement rowElement;

        ArrayList<String> htmlTable = new ArrayList<String>();

        /* locator = locator.replace("\"", "\\\""); */

        /*
         * JS = "this.browserbot.findElement(\"" + locator + "\")" + ".rows[" +
         * row + "].cells.length.toString()"; Integer colNum =
         * Integer.parseInt(selenium.getEval(JS));
         */

        rowElements = element.findElements(By.tagName("tr"));
        rowElement = rowElements.get(row);
        colElements = rowElement.findElements(By.tagName("th"));
        colElements.addAll(rowElement.findElements(By.tagName("td")));
        int colNum = colElements.size();

        /* locator = locator.replace("\\\"", "\""); */
        String value = "";
        for (int j = 0; j < colNum; j++) {

            value = colElements.get(j).getText();
            /* value = selenium.getTable(locator + "." + row + "." + j); */

            if (value != null) {
                htmlTable.add(value);
            } else {
                htmlTable.add("");
            }
        }

        return htmlTable;
    }

    /**
     * Checks in a table whether the given table is in.
     * 
     * @param element
     *            the element
     * @param objectName
     *            the object name
     * @param expectedvale
     *            the expectedvale
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     */
    private void compareTableData(final WebElement element,
            final String objectName, final String expectedvale,
            final boolean fail, final Object[] customError) {

        ArrayList<String> htmlTable;
        ArrayList<String> inputTable;
        try {
            htmlTable = getAppTable(element);

            inputTable =
                    new ArrayList<String>(Arrays.asList(expectedvale
                            .split("(?<!\\\\),")));
            ArrayList<String> tempInputTable = new ArrayList<String>();
            for (String inputVal : inputTable) {
                String formattedValue = inputVal.replaceAll("\\\\,", ",");
                tempInputTable.add(formattedValue);
            }
            inputTable = tempInputTable;

            String inputTableStr = StringUtils.join(inputTable, "|");
            String actualTableStr = StringUtils.join(htmlTable, "|");

            if (actualTableStr.contains(inputTableStr)) {

                reportresult(true, "CHECK TABLE :TABLE DATA ", "PASSED",
                        "CHECK TABLE :TABLE DATA (" + objectName
                                + ") | Expected [" + expectedvale + "]");

            } else {
                String inputTableString = inputTable.toString();
                String htmlTableString = htmlTable.toString();

                reportresult(fail, "CHECK TABLE :TABLE DATA ", "FAILED", ""
                        + generateCustomError(customError)
                        + " System generated Error : " + objectName
                        + "'s  TABLEDATA is not as expected  "
                        + inputTableString + ": Actual :" + htmlTableString);
                checkTrue(false, fail, objectName + ""
                        + generateCustomError(customError)
                        + " System generated Error : " + objectName
                        + "'s  TABLEDATA is not as expected  "
                        + inputTableString + ": Actual :" + htmlTableString);

            }

        } catch (Exception e) {
            String errorString = e.getMessage();
            reportresult(fail, "CHECK TABLE :TABLE DATA", "FAILED", errorString);
            checkTrue(false, fail, errorString);
        }
    }

    /**
     * The Enum LocatorType.
     */
    public enum LocatorType {

        /** The classname. */
        CLASSNAME,
        /** The css. */
        CSS,
        /** The id. */
        ID,
        /** The link. */
        LINK,
        /** The name. */
        NAME,
        /** The tagname. */
        TAGNAME,
        /** The xpath. */
        XPATH;
    }

    /**
     * Gets the locator type.
     * 
     * @param objectID
     *            the object id
     * @return the locator type
     * @throws Exception
     *             the exception
     */
    public final By getLocatorType(final String objectID) throws Exception {

        String typeString = "";
        String ref = "";
        String objectIDinLowerCase = objectID.toLowerCase(Locale.getDefault());
        boolean isObjectTypeisXpath = objectIDinLowerCase.startsWith("/");
        if (!isObjectTypeisXpath) {
            try {
                typeString =
                        objectIDinLowerCase.substring(0, objectID.indexOf('='));
                ref =
                        objectID.substring(objectID.indexOf('=') + 1,
                                objectID.length());
            } catch (Exception e) {
                throw new Exception("Invalid Locator Passed " + objectID, e);
            }
        }
        // String objectIDType = typeString.toLowerCase(Locale.getDefault());
        if (isObjectTypeisXpath) {

            return selectorTypes("xpath", objectID);
        } else {

            return selectorTypes(typeString, ref);
        }

    }

    /**
     * Selector types.
     * 
     * @param typeString
     *            the type string
     * @param ref
     *            the ref
     * @return the by
     * @throws Exception
     *             the exception
     */
    private By selectorTypes(final String typeString, final String ref)
            throws Exception {

        if (typeString.contains("xpath")) {

            return By.xpath(ref);
        } else if (typeString.contains("css")) {

            return By.cssSelector(ref);
        } else if (typeString.contains("id")) {

            return By.id(ref);
        } else if (typeString.contains("link")) {

            return By.linkText(ref);
        } else if (typeString.contains("tagname")) {

            return By.tagName(ref);
        } else if (typeString.contains("name")) {

            return By.name(ref);
        } else if (typeString.contains("classname")) {

            return By.className(ref);
        }

        throw new Exception("Invalid Locator Type Passed " + ref);

    }

    /**
     * Object locator.
     * 
     * @param objectID
     *            the object id
     * @return the web element
     * @throws Exception
     *             the exception
     */
    public final WebElement objectLocator(final String objectID)
            throws Exception {

        Logger log = getLog();
        log.info("INFO : Finding Element [ " + objectID + " ]");
        WebDriver driver = getDriver();
        By by = getLocatorType(objectID);
        return driver.findElement(by);
    }

    /**
     * internal method which actually checks whether the given element is
     * exists.
     * 
     * @param searchPath
     *            the search path
     * @return the web element
     * @throws Exception
     *             the exception
     */
    
    private WebElement checkElementPresenceWait(final String searchPath,final String waitTime)
            throws Exception {
        WebDriver driver = getDriver();
        WebElement webElement = null;
        String locator = searchPath;
        final Logger log = getLog();
       
        setCommandStartTime(getCurrentTime());
        final By searchBy = getLocatorType(locator);
      

        try {

            Function<WebDriver, WebElement> findElementFunction =
                    new FindElementFunction<WebDriver, WebElement>(searchBy);

            Wait<WebDriver> wait =
                    new FluentWait<WebDriver>(driver)
                            .withTimeout(Integer.parseInt(waitTime),
                                    TimeUnit.MILLISECONDS)
                            .pollingEvery(1, TimeUnit.SECONDS)
                            .ignoring(NoSuchElementException.class);

            webElement = wait.until(findElementFunction);
          

        } catch (Exception e) {
            log.error("Element [ " + searchPath + " ] Not Found", e);
        }

        if (webElement != null) {
            try {
                log.info("Element [ " + searchBy.toString() + " ] Found");
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(false);",
                        webElement);
            } catch (Exception ex) {
                log.error("Exception occured while scrolling to the element.",
                        ex);
            }
        } else {
            throw new Exception("Element " + searchPath);
        }

        return webElement;
    }
    
    
    private WebElement checkElementPresence(final String searchPath)
            throws Exception {
        WebDriver driver = getDriver();
        WebElement webElement = null;
        String locator = searchPath;
        final Logger log = getLog();
        int count = getRetryCount();
        setCommandStartTime(getCurrentTime());
        final By searchBy = getLocatorType(locator);
        final Long retryMillis = 1000L;

        try {

            Function<WebDriver, WebElement> findElementFunction =
                    new FindElementFunction<WebDriver, WebElement>(searchBy);

            Wait<WebDriver> wait =
                    new FluentWait<WebDriver>(driver)
                            .withTimeout((count * retryMillis),
                                    TimeUnit.MILLISECONDS)
                            .pollingEvery(retryInterval, TimeUnit.MILLISECONDS)
                            .ignoring(NoSuchElementException.class)
                            .ignoring(WebDriverException.class);

            webElement = wait.until(findElementFunction);

        } catch (Exception e) {
            log.error("Element [ " + searchPath + " ] Not Found", e);
        }

        if (webElement != null) {
            try {
                log.info("Element [ " + searchBy.toString() + " ] Found");
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(false);",
                        webElement);
            } catch (Exception ex) {
                log.error("Exception occured while scrolling to the element.",
                        ex);
            }
        } else {
            throw new Exception("Element " + searchPath);
        }

        return webElement;
    }

    /**
     * The FindElementFunction inner class.
     * 
     * @param <T>
     *            the generic type
     * @param <K>
     *            the key type
     */
    public static class FindElementFunction < T, K > implements
            Function<WebDriver, WebElement> {
        /** The search by locator. */
        private By searchByLocator;

        /**
         * The constructor for inner class.
         * 
         * @param by
         *            The by locator
         * */
        public FindElementFunction(final By by) {
            searchByLocator = by;
        }

        /**
         * The apply method which returns a web element.
         * 
         * @param driver
         *            the webdriver
         * @return The web element found
         * */
        @Override
        public final WebElement apply(final WebDriver driver) {
            getLog().info(
                    "Finding Element [ " + searchByLocator.toString() + " ]");
            return driver.findElement(searchByLocator);
        }
    }

    /**
     * Internal method which checks whether the option is available in the
     * select box.
     * 
     * @param valuetoBeSelect
     *            the valueto be select
     * @param actualOptions
     *            the actual options
     * @return true, if check select options
     * @throws Exception
     *             the exception
     */
    private boolean checkSelectOptions(final String valuetoBeSelect,
            final String[] actualOptions) throws Exception {

        String[] optionList = valuetoBeSelect.split("#");
        boolean optionPresent = false;
        boolean multiSelect = false;
        int notFoundCount = 0;
        StringBuilder notFoundItems = new StringBuilder();

        multiSelect = valuetoBeSelect.contains("#");

        for (String option : optionList) {
            optionPresent = false;
            if (option.startsWith("regexp:")) {
                for (String actualOption : actualOptions) {
                    optionPresent =
                            isMatchingPattern(option.substring(
                                    option.indexOf(':') + 1, option.length()),
                                    actualOption);
                    if (optionPresent) {
                        break;
                    }
                }
                if (!optionPresent) {
                    notFoundCount++;
                    notFoundItems.append(option).append(",");
                }

            } else if (option.startsWith("index=")) {
                int indexNo = Integer.parseInt(option.replace("index=", ""));
                if (actualOptions.length <= indexNo) {
                    notFoundCount++;
                    notFoundItems.append(option).append(",");
                }
            } else {
                optionPresent = Arrays.asList(actualOptions).contains(option);
                if (!optionPresent) {
                    notFoundCount++;
                    notFoundItems.append(option).append(",");
                }
            }
        }
        if (notFoundCount > 0) {
            setErrorMessages(getErrorMessages() + " Options cannot be found |"
                    + notFoundItems.toString());

            throw new Exception("No_Item " + notFoundItems);
        }

        return multiSelect;

    }

    /**
     * Validating the value of the given property of the object, further
     * continuation of the script execution will be decided <br>
     * besed on value of the <b> stopExecution </b> parameter provided by the
     * user <br>
     * <br>
     * in the web page.
     * 
     * @param element
     *            the element
     * @param propertyname
     *            : Name of the object property to be validated
     * @return the string
     * @throws Exception
     *             the exception
     */
    private String validateObjectProperty(final WebElement element,
            final String propertyname) throws Exception {
        String attributeValue = "";
        if ("textContent".equals(propertyname)) {
            try {
                attributeValue = element.getText();

            } catch (Exception ex) {
                throw new Exception("Attribute " + propertyname, ex);
            }
        } else if ("checked".equals(propertyname)) {
            try {
                if (element.isSelected()) {
                    attributeValue = "true";
                } else {
                    attributeValue = "false";
                }
            } catch (Exception ex) {
                throw new Exception("Attribute " + propertyname, ex);
            }
        } else {
            try {
                attributeValue = element.getAttribute(propertyname);

                if (attributeValue == null) {
                    throw new Exception("Attribute " + propertyname);
                }
            } catch (Exception e1) {

                throw new Exception("Attribute " + propertyname, e1);
            }
        }
        return attributeValue;
    }

    /**
     * evaluate the given logical condition and report the result Further
     * execution or termination of test will be decided by the value of isAssert
     * variable.
     * 
     * @param checkingCondition
     *            the checking condition
     * @param isAssert
     *            the is assert
     * @param failedMessage
     *            the failed message
     */
    private void checkTrue(final boolean checkingCondition,
            final boolean isAssert, final String failedMessage) {
        String errorMessage = getErrorMessages();
        String callingClassName = getCallingClassName();
        String currentMethod = getCurrentMethod();
        int lineNumber = getLineNumber();
        if (isAssert) {

            // endTestReporting(isAssert);
            assertTrue("Failed " + failedMessage + "\n" + errorMessage
                    + " [At : " + callingClassName + "." + currentMethod
                    + "(Line:" + lineNumber + ")]" + "\n", checkingCondition);
        } else {
            try {
                ITestResult reult;
                setErrorMessages(errorMessage + "\n" + failedMessage
                        + " [At : " + callingClassName + "." + currentMethod
                        + "(Line:" + lineNumber + ")]" + "\n");
                reult = Reporter.getCurrentTestResult();
                reult.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
                reult.setThrowable(new Exception(getErrorMessages()));
                Reporter.setCurrentTestResult(reult);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieve the data table for the parameterized executin.
     * 
     * @param name
     *            the name
     * @return the table
     */
    public final DataTable getTable(final String name) {
        File file;
        if (tables == null) {
            File tempFile = new File("tempFile");
            System.out.println("running location :"
                    + tempFile.getAbsolutePath());
            if (tempFile.getAbsolutePath().contains("grid")) {
                file =
                        new File("grid" + File.separator
                                + "selenium-grid-1.0.6" + File.separator
                                + "data" + File.separator + "DataTables.xml");
                System.out.println("Location of data file is :"
                        + file.getAbsolutePath());
            } else {
                file =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "data" + File.separator + "DataTables.xml");
                System.out.println("Location of data file is :"
                        + file.getAbsolutePath());
            }
            tables = DataTablesParser.parseTables(file);
        }
        return tables.get(name);
    }

    /**
     * read the Multiple DataTable store All data in one Virtual Data Table.
     * 
     * @param tableNames
     *            the table names
     * @return the virtual data table
     */
    public final DataTable getVirtualDataTable(final String[] tableNames) {

        DataTable virtualDataTable = new DataTable();

        for (int i = 0; i < tableNames.length; i++) {
            int columnIndex = 0;
            DataTable table = getTable(tableNames[i]);
            for (String col : table.getColumns()) {
                String colNew = tableNames[i] + "_" + col;
                virtualDataTable.addColumn(colNew);
                virtualDataTable.addDataTypes(table.getDataType(columnIndex));

                for (int row = 0; row < table.getRowCount(); row++) {
                    virtualDataTable.setValue(row, colNew, table.get(row, col));
                }
                columnIndex++;
            }
        }

        return virtualDataTable;
    }

    /**
     * read the DataTable and convert it to a two dimentional array.
     * 
     * @param table
     *            the table
     * @return the table array
     */
    public final Object[][] getTableArray(final DataTable table) {

        Integer rowcount = table.getRowCount();
        Integer colcount = table.getcolCount();

        Object[][] tabArray = new Object[rowcount][colcount];

        for (int row = 0; row < rowcount; row++) {
            for (int col = 0; col < colcount; col++) {
                if ("Int".equals(table.getDataType(col))) {
                    tabArray[row][col] = table.intValue(row, col);
                } else if ("Boolean".equals(table.getDataType(col))) {
                    tabArray[row][col] = table.booleanValue(row, col);
                } else if ("String".equals(table.getDataType(col))) {
                    tabArray[row][col] = table.get(row, col);
                } else if ("Double".equals(table.getDataType(col))) {
                    tabArray[row][col] = table.doubleValue(row, col);

                }
            }

        }

        return tabArray;

    }

    /**
     * Gets the data table iterator.
     * 
     * @param tableNames
     *            the table names
     * @param associatedRows
     *            the associated rows
     * @return the data table iterator
     */
    public final List<HashMap<String, String>> getDataTableIterator(
            final String tableNames, final String associatedRows) {

        List<HashMap<String, String>> iteratorList =
                new ArrayList<HashMap<String, String>>();
        List<DataTable> tableList = new ArrayList<DataTable>();
        List<int[]> rowList = new ArrayList<int[]>();
        String[] rowsPerTableArray = associatedRows.split("\\|");
        String[] tableNamesArray = tableNames.split("\\|");
        int rowsPerTableCounts = rowsPerTableArray.length;
        int tableNamesCount = tableNamesArray.length;
        if (rowsPerTableCounts == tableNamesCount) {
            try {
                for (int i = 0; i < tableNamesCount; i++) {
                    DataTable table = getTable(tableNamesArray[i]);
                    tableList.add(table);
                    rowList.add(getAssociatedRowNumbers(table,
                            rowsPerTableArray[i]));
                }

                for (int i = 0; i < tableNamesCount; i++) {
                    int currentInsertRow = 0;
                    DataTable dataTable = tableList.get(i);
                    int[] reqRows = rowList.get(i);
                    String tableName = tableNamesArray[i];
                    for (int row : reqRows) {
                        if (iteratorList.size() <= currentInsertRow) {
                            iteratorList.add(new HashMap<String, String>());
                        }
                        HashMap<String, String> currRow =
                                iteratorList.get(currentInsertRow);
                        List<String> columnHeaders = dataTable.getColumns();

                        for (String column : columnHeaders) {
                            currRow.put(tableName.concat("_").concat(column),
                                    dataTable.get(row, column));
                        }

                        currentInsertRow++;
                    }
                }

            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                String errString = e.getMessage();
                reportresult(true, "DATA TABLE ITERATION :", "FAILED",
                        "Cannot iterate over the data table. Cannot find the row numbers : "
                                + associatedRows + " in data table. "
                                + "Actual Error : " + errString);
                checkTrue(false, true,
                        "Cannot iterate over the data table. Actual Error : "
                                + errString);
            } catch (Exception e) {
                e.printStackTrace();
                String errString = e.getMessage();
                reportresult(true, "DATA TABLE ITERATION :", "FAILED",
                        "Cannot iterate over the data table. Actual Error : "
                                + errString);
                checkTrue(false, true,
                        "Cannot iterate over the data table. Actual Error : "
                                + errString);
            }

        } else {
            reportresult(
                    true,
                    "DATA TABLE ITERATION :",
                    "FAILED",
                    "Cannot iterate over the data table. Invalid input data. Actual error : Number of tables passed : "
                            + tableNamesCount
                            + " does not match the associated data rows count : "
                            + rowsPerTableCounts);
            checkTrue(
                    false,
                    true,
                    "Cannot iterate over the data table. Invalid input data. Actual error : Number of tables passed : "
                            + tableNamesCount
                            + " does not match the associated data rows count : "
                            + rowsPerTableCounts);
        }
        return iteratorList;

    }

    /**
     * Gets the associated row numbers.
     * 
     * @param table
     *            the table
     * @param rowList
     *            the row list
     * @return the associated row numbers
     */
    private int[] getAssociatedRowNumbers(final DataTable table,
            final String rowList) {
        int[] rowNumbers = null;
        try {
            if ("ALL".equalsIgnoreCase(rowList)) {
                int rowCount = table.getRowCount();
                rowNumbers = new int[rowCount];
                for (int i = 0; i < rowCount; i++) {
                    rowNumbers[i] = i;
                }
            } else if (rowList.contains("-")) {
                String[] range = rowList.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                rowNumbers = new int[((end - start)) + 1];
                int rowNumberIndex = 0;
                for (int i = start; i <= end; i++) {
                    rowNumbers[rowNumberIndex] = i;
                    rowNumberIndex++;
                }
            } else if (rowList.contains(",")) {
                String[] range = rowList.split(",");
                rowNumbers = new int[range.length];
                for (int i = 0; i < range.length; i++) {
                    rowNumbers[i] = Integer.parseInt(range[i]);
                }
            } else {
                rowNumbers = new int[] {Integer.parseInt(rowList)};
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String errString = e.getMessage();
            reportresult(true, "DATA TABLE ITERATION :", "FAILED",
                    "Cannot iterate over the data table. Cannot parse the row numbers : "
                            + rowList + ". Actual Error : " + errString);
            checkTrue(false, true,
                    "Cannot iterate over the data table. Cannot parse the row numbers : "
                            + rowList + ". Actual Error : " + errString);
        } catch (IndexOutOfBoundsException e) {
            String errString = e.getMessage();
            reportresult(true, "DATA TABLE ITERATION :", "FAILED",
                    "Cannot iterate over the data table. Actual Error : "
                            + errString);
            checkTrue(false, true,
                    "Cannot iterate over the data table. Actual Error : "
                            + errString);
        }

        return rowNumbers;
    }

    /**
     * Retrieving all the browser titles opened.
     * 
     * @return the all windows
     * @throws Exception
     *             the exception
     */
    public final Set<String> getAllWindows() throws Exception {

        WebDriver driver = getDriver();
        try {
            // allData = new String[ (availableWindows.size() )];
            return driver.getWindowHandles();

        } catch (Exception e) {
            throw new Exception("cannot access the windows ", e);
        }
    }

    /**
     * Simulates the back button click event of the browser. <br>
     * 
     * The goBack command waits for the page to load after the navigation
     * 
     * @param waitTime
     *            : Time to wait for goBack command to complete
     * 
     * */
    public final void goBack(final String waitTime) {
        WebDriver driver = getDriver();
        try {
            String oldUrl = driver.getCurrentUrl();
            driver.navigate().back();
            super.sleep(Integer.parseInt(waitTime));
            reportresult(true, "GO BACK :", "PASSED", "Go Back from url ["
                    + oldUrl + "] to url : [" + driver.getCurrentUrl() + "]");
        } catch (Exception e) {
            String errorString = e.getMessage();
            reportresult(true, "GO BACK  :", "FAILED", errorString);
            checkTrue(false, true, "BROWSER BACK :" + "FAILED" + errorString);

        }
    }

    /**
     * Retrieves a String value previously stored.
     * 
     * @param key
     *            : key for the value to be retrieved
     * @return String value stored for the given <b>key</b>
     */
    public final String retrieveString(final String key) {
        return retrieve(key, "String");
    }

    /**
     * Retrieve the value of a given key previously stored <br>
     * <br>
     * <b>Fails</b> if, <li>the given key is not stored previously</li> <li>
     * stored value type mismatches the type expected</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be retrieved
     * @param type
     *            : type of the previously stored value
     * @return value for the particular <b>key</b>
     */
    public final String retrieve(final String key, final String type) {

        String value = null;
        String projectPropertiesLocation = "project_data.properties";
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(projectPropertiesLocation);
            try {
                prop.load(fis);
            } catch (IOException e) {
                String errorString = e.getMessage();
                reportresult(true, "RETRIEVE Value : " + type + " " + key
                        + " :", "FAILED", errorString);
                checkTrue(false, true, "RETRIEVE Value : " + type + " " + key
                        + " :" + "FAILED " + errorString);
            }

            value = prop.getProperty(key + "_Val");
            if (value != null) {
                String type2 = prop.getProperty(key + "_Type");
                if (!type2.equalsIgnoreCase(type)) {
                    // compare against stored type
                    reportresult(true, "RETRIEVE Value : " + type + " " + key
                            + " :", "FAILED", "Trying to retrieve " + type
                            + ", found" + type2);
                    checkTrue(false, true, "RETRIEVE Value : " + type + " "
                            + key + " :" + "FAILED " + "Trying to retrieve "
                            + type + ", found" + type2);
                }
            }

            reportresult(true, "RETRIEVE Value : " + type + " " + key + " :",
                    "PASSED", "Retrieved value [" + value + "] from key ["
                            + key + "]");

        } catch (FileNotFoundException e) {

            reportresult(true, "RETRIEVE Value : " + type + " " + key + " :",
                    "PASSED", "RETRIEVE Value : " + type + " " + key + " :");
            return null;

        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * Retrieves an int value previously stored <br>
     * <br>
     * <b>Fails</b> if, <li>the stored value is not parsable to int</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be retrieved
     * @return int value stored for the given <b>key</b> , default is -1
     */
    public final int retrieveInt(final String key) {
        String value = retrieve(key, "Int");
        try {
            if (value != null) {
                return Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            String errorString = e.getMessage();
            reportresult(true, "RETRIEVE Value : Int" + " " + key + " : ",
                    "FAILED", errorString);
            checkTrue(false, true, "RETRIEVE Value : Int " + " " + key + " : "
                    + "FAILED " + errorString);
        }
        return -1;
    }

    /**
     * Retrieves an double value previously stored <br>
     * <br>
     * <b>Fails</b> if, <li>the stored value is not parsable to int</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be retrieved
     * @return int value stored for the given <b>key</b> , default is -1
     */
    public final double retrieveDouble(final String key) {
        String value = retrieve(key, "Double");
        try {
            if (value != null) {
                return Double.parseDouble(value);
            }
        } catch (NumberFormatException e) {
            String errorString = e.getMessage();
            reportresult(true, "RETRIEVE Value : Double" + " " + key + " : ",
                    "FAILED", errorString);
            checkTrue(false, true, "RETRIEVE Value : Double " + " " + key
                    + " : " + "FAILED " + errorString);
        }
        return -1;
    }

    /**
     * Retrieves a float value previously stored <br>
     * <br>
     * <b>Fails</b> if, <li>the stored value is not parsable to float</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be retrieved
     * @return float value stored for the given <b>key</b> , default is -1
     */
    public final float retrieveFloat(final String key) {
        String value = retrieve(key, "Float");
        try {
            if (value != null) {
                return Float.parseFloat(value);
            }
        } catch (NumberFormatException e) {
            String errorString = e.getMessage();
            reportresult(true, "RETRIEVE FLOAT: " + " " + key + " : ",
                    "FAILED", errorString);
            checkTrue(false, true, "RETRIEVE FLOAT: " + " " + key + " : "
                    + "FAILED " + errorString);
        }
        return -1;
    }

    /**
     * Retrieves a boolean value previously stored <br>
     * <br>
     * <b>Fails</b> if, <li>the stored value is not parsable to boolean</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be retrieved
     * @return boolean value stored for the given <b>key</b> , default is false
     */
    public final boolean retrieveBoolean(final String key) {
        String value = retrieve(key, "Boolean");
        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            return Boolean.parseBoolean(value);
        } else {
            reportresult(true, "RETRIEVE BOOLEAN: " + " " + key + " : ",
                    "FAILED", "Cannot parse value to boolean");
            checkTrue(false, true, "RETRIEVE BOOLEAN: " + " " + key + " : "
                    + "FAILED " + "Cannot parse value to boolean");
            return false;
        }
    }

    /**
     * Stores a given key-value pair of given type <br>
     * Overwrites any existing value of same key <br>
     * <br>
     * <b>Fails</b> if, <li>data store file cannot be created</li> <li>data
     * cannot be written to file</li> <li>type of the value to be stored
     * mismatches the type specified</li> <br>
     * <br>
     * .
     * 
     * @param key
     *            : key for the value to be stored
     * @param type
     *            : type of value to be stored
     * @param objValue
     *            the obj value
     */
    public final void store(final String key, final String type,
            final Object objValue) {
        String value = checkNullObject(objValue, "STORE");
        String projectPropertiesLocation = "project_data.properties";
        Properties prop = new Properties();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File file = new File(projectPropertiesLocation);
        try {
            if (!file.exists() && !file.createNewFile()) {

                getLog().error(
                        "Cannot create a new file in the intended location. "
                                + "" + file.getAbsolutePath());
            }
            fis = new FileInputStream(file.getAbsoluteFile());
            prop.load(fis);
            prop.setProperty(key + "_Val", value);
            prop.setProperty(key + "_Type", type);

            checkStoreValueType(type, value);

            fos = new FileOutputStream(projectPropertiesLocation);
            prop.store(fos, "project settings");
            reportresult(true, "STORE Value : " + value + " " + type + " "
                    + key + " :", "PASSED", "Stored value [" + value
                    + "] to key [" + key + "]");

        } catch (IOException e) {
            String errorString = e.getMessage();
            reportresult(true, "STORE :" + value + " : " + type + " : " + key
                    + " :", "FAILED", errorString);
            checkTrue(false, true, "STORE value " + value + " : " + type
                    + " : " + key + " :" + "FAILED " + errorString);
        } catch (NumberFormatException e) {
            String errorString = e.getMessage();
            reportresult(true, "STORE value : " + value + " Int" + " " + key
                    + " :", "FAILED", errorString);
            checkTrue(false, true, "STORE value " + value + " Int " + " " + key
                    + " :" + "FAILED " + errorString);
        } catch (IllegalArgumentException e) {
            String errorString = e.getMessage();
            reportresult(true, "STORE Value type : " + type + " " + key + " :",
                    "FAILED",
                    "Cannot parse value to the expected format. Error : "
                            + errorString);
            checkTrue(false, true, "STORE value type " + type + " " + key
                    + " :" + "FAILED "
                    + "Cannot parse value to the expected format. Error : "
                    + errorString);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Check store value type.
     * 
     * @param type
     *            the type
     * @param value
     *            the value
     */
    private void checkStoreValueType(final String type, final String value) {
        try {
            if ("Int".equalsIgnoreCase(type)) {
                Integer.parseInt(value);
            } else if ("Boolean".equalsIgnoreCase(type)) {
                if ("true".equalsIgnoreCase(value)
                        || "false".equalsIgnoreCase(value)) {
                    Boolean.parseBoolean(value);
                } else {
                    throw new IllegalArgumentException(
                            "Cannot convert to boolean value " + value);
                }
            } else if ("Float".equalsIgnoreCase(type)) {
                Float.parseFloat(value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    // private boolean isPopupHandled;

    /**
     * Handle popup.
     * 
     * @param actionFlow
     *            the action flow
     * @param waitTime
     *            the wait time
     * @throws Exception
     *             the exception
     */
    public final void handlePopup(final String actionFlow, final String waitTime)
            throws Exception {
        initRobot();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        this.inputStringp = actionFlow;
        this.waitTimep = waitTime;

        Thread newThread = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    sleep(Integer.parseInt(waitTimep));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (inputStringp.startsWith("FORCE%")) {

                    try {
                        forceHandlePopup(getRobot(), inputStringp.split("%")[1]);
                        reportresult(true,
                                "HANDLE POPUP :" + inputStringp + "", "PASSED",
                                "Handle PopUp [" + inputStringp + "]");
                    } catch (Exception e) {
                        e.printStackTrace();
                        reportresult(true, "HANDLE POPUP :", "FAILED",
                                e.getMessage());
                        checkTrue(
                                false,
                                true,
                                "HANDLE POPUP command: Error :- "
                                        + e.getMessage());
                    }

                } else {
                    /*
                     * If the popup is not a forcrfully handled it will be
                     * handled in the normal way
                     */
                    String verificationErrors = "";
                    String actualAlertText = "";
                    WebDriver driver = getDriver();
                    String[] commands = inputStringp.split("\\|");
                    try {
                        actualAlertText = driver.switchTo().alert().getText();
                    } catch (NoAlertPresentException e) {

                        reportresult(true,
                                "HANDLE POPUP : failed. No Alert Present",
                                "FAILED", "");
                        checkTrue(false, true,
                                "HANDLE POPUP : failed. No Alert Present");
                    }

                    verificationErrors =
                            executeHandlePopupCommands(driver, commands,
                                    actualAlertText);
                    if (verificationErrors.isEmpty()) {
                        reportresult(true, "HANDLE POPUP :" + actualAlertText
                                + "", "PASSED", "Handle PopUp [" + inputStringp
                                + "]");
                    } else {
                        reportresult(true, "HANDLE POPUP : failed", "FAILED",
                                "Errors : " + verificationErrors + "");
                        checkTrue(false, false,
                                "HANDLE POPUP : failed. Errors : "
                                        + verificationErrors + "");
                    }
                }

            }
        }

        );

        newThread.start();

    }

    /**
     * Execute handle popup commands.
     * 
     * @param driver
     *            the driver
     * @param commands
     *            the commands
     * @param actualAlertText
     *            the actual alert text
     * @return the string
     */
    private String executeHandlePopupCommands(final WebDriver driver,
            final String[] commands, final String actualAlertText) {

        StringBuilder verificationErrorBuilder = new StringBuilder();
        boolean isPopupHandled = false;
        for (String command : commands) {
            String commandString = command.toLowerCase(Locale.getDefault());
            if (commandString.startsWith("type=")) {
                String typeStr =
                        command.substring(command.indexOf('=') + 1,
                                command.length());
                driver.switchTo().alert().sendKeys(typeStr);

            } else if (commandString.startsWith("verify=")) {
                String verifyStr =
                        command.substring(command.indexOf('=') + 1,
                                command.length());
                if (!verifyStr.equals(actualAlertText)) {
                    verificationErrorBuilder
                            .append("VERIFY TEXT failed. Actual : " + ""
                                    + actualAlertText + " Expected : "
                                    + verifyStr + " ");
                }
            } else if (commandString.startsWith("action=")) {
                String actionStr =
                        command.substring(command.indexOf('=') + 1,
                                command.length());
                if ("ok".equalsIgnoreCase(actionStr)) {
                    driver.switchTo().alert().accept();
                    isPopupHandled = true;
                } else if ("cancel".equalsIgnoreCase(actionStr)) {
                    driver.switchTo().alert().dismiss();
                    isPopupHandled = true;
                }
            } else {
                verificationErrorBuilder
                        .append("Handle Popup command failed. Given input command ("
                                + command
                                + ")is not recognized. Supported commands : type, verify, action.");
            }
        }
        if (!isPopupHandled) {
            driver.switchTo().alert().accept();
            isPopupHandled = true;
        }
        return verificationErrorBuilder.toString();
    }

    /**
     * Insert new window handlesinto index.
     * 
     * @param currentWinHandles
     *            the current win handles
     */
    private void insertNewWindowHandlesintoIndex(
            final Set<String> currentWinHandles) {
        List<String> tempWindowHandleIndex = getOpenWindowHandleIndex();
        for (int i = 0; i < tempWindowHandleIndex.size(); i++) {
            String oldWinHandle = tempWindowHandleIndex.get(i);
            if (!currentWinHandles.contains(oldWinHandle)) {
                try {
                    tempWindowHandleIndex.remove(oldWinHandle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        setOpenWindowHandleIndex(tempWindowHandleIndex);
    }

    /**
     * Merge current windows with new window index.
     * 
     * @param currentWinHandles
     *            the current win handles
     */
    private void mergeCurrentWindowsWithNewWindowIndex(
            final Set<String> currentWinHandles) {

        List<String> tempOpenWindowHandles = getOpenWindowHandleIndex();
        for (String newWinHandle : currentWinHandles) {
            if (!tempOpenWindowHandles.contains(newWinHandle)) {
                try {
                    tempOpenWindowHandles.add(newWinHandle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < tempOpenWindowHandles.size(); i++) {
            String openWinHandle = tempOpenWindowHandles.get(i);
            if (!currentWinHandles.contains(openWinHandle)) {
                try {
                    tempOpenWindowHandles.remove(openWinHandle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        setOpenWindowHandleIndex(tempOpenWindowHandles);
    }

    /**
     * Removes the closed window handles from index.
     * 
     * @param currentWinHandles
     *            the current win handles
     */
    private void removeClosedWindowHandlesFromIndex(
            final Set<String> currentWinHandles) {

        List<String> tempAllWinHandles = getOpenWindowHandleIndex();
        currentWinHandles.removeAll(tempAllWinHandles);

        if (currentWinHandles.size() > 0) {
            for (String newWinHandle : currentWinHandles) {
                try {
                    tempAllWinHandles.add(newWinHandle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            setOpenWindowHandleIndex(tempAllWinHandles);
        }
    }

    /**
     * Check for new window popups.
     * 
     * @throws Exception
     *             the exception
     */
    private void checkForNewWindowPopups() throws Exception {

        Set<String> currentWinHandles = getAllWindows();
        int currentWinHandleCount = currentWinHandles.size();
        int openWindowHandleCount = getOpenWindowHandleIndex().size();
        if (currentWinHandleCount < openWindowHandleCount) {

            insertNewWindowHandlesintoIndex(currentWinHandles);

        } else if (currentWinHandleCount == openWindowHandleCount) {

            mergeCurrentWindowsWithNewWindowIndex(currentWinHandles);

        } else if (currentWinHandleCount > openWindowHandleCount) {

            removeClosedWindowHandlesFromIndex(currentWinHandles);
        }
    }

    /**
     * Force handle popup.
     * 
     * @param robot
     *            the robot
     * @param inputString
     *            the input string
     * @throws Exception
     *             the exception
     */
    public final void forceHandlePopup(final Robot robot,
            final String inputString) throws Exception {

        fireKeyEvent(robot, inputString);

    }

    /** The input stringp. */
    private String inputStringp;

    /** The wait timep. */
    private String waitTimep;

    /**
     * Type.
     * 
     * @param character
     *            the character
     */
    public final void type(final String[] character) {

        KeyCodes keys = new KeyCodes();
        int[] keycodes = new int[character.length];
        if (character.length > 1) {
            int number = 0;
            for (int i = 0; i < character.length; i++) {
                keycodes[i] = keys.getKeyCodes(character[i])[number];
            }

        } else {
            keycodes = keys.getKeyCodes(character[0]);

        }
        doType(keycodes);
    }

    /**
     * Do type.
     * 
     * @param keyCodes
     *            the key codes
     */
    private void doType(final int... keyCodes) {
        doTypeKeys(keyCodes, 0, keyCodes.length);
    }

    /**
     * Do type.
     * 
     * @param keyCodes
     *            the key codes
     * @param offset
     *            the offset
     * @param length
     *            the length
     */
    private void doTypeKeys(final int[] keyCodes, final int offset,
            final int length) {
        if (length == 0) {
            return;
        }
        Robot robot = getRobot();
        try {
            robot.keyPress(keyCodes[offset]);
            doTypeKeys(keyCodes, offset + 1, length - 1);
            robot.keyRelease(keyCodes[offset]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Simulates a keypress in to an input field as though you typed it key by
     * key from the keyboard.<br>
     * The keys should be seperated form a | charater to be typed correctly.<br>
     * <br>
     * 
     * Example: A|B|C|ctrl|\n|\t|1|2|3 <br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifire
     *            :
     * 
     *            Identifier is us to increase the reusablity of the locator.
     *            The usage can be defined using the following examble <br>
     * <br>
     *            assume the following locator is assigned the following logical
     *            object name at the object map <br>
     * <br>
     *            <b>locator :</b> //a[@href='http://www.virtusa.com/']<br>
     *            <b>Name :</b> virtusaLink<br>
     * <br>
     * 
     *            If the user thinks that the locator can be made generalized,
     *            it can be parameterized like the following <br>
     * <br>
     *            //a[@href='http://&LTp1&GT/']<br>
     * <br>
     *            once the method is used, pass the <b>identifier</b> as follows<br>
     *            p1: www.virtusa.com<br>
     * <br>
     *            The absolute xpath will be dynamically generated
     * @param value
     *            : value to be typed in the object
     */
    public final void typekey(final String objectName, final String identifire,
            final Object value) {
        this.locatorIdentifire = identifire;
        typeKey(objectName, value);
        this.locatorIdentifire = "";
    }

    /**
     * Type key.
     * 
     * @param objectName
     *            the object name
     * @param objValue
     *            the obj value
     */
    public final void typeKey(final String objectName, final Object objValue) {

        String value = checkNullObject(objValue, "TYPEKEY");
        WebDriver driver = getDriver();
        int counter = getRetryCount();

        String[] valueStringsArr = value.split("(?!^)");

        // Getting the actual object identification from the object map
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            try {
                element.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
            while (counter > 0) {
                try {
                    counter--;

                    // Calling the actual command
                    element.sendKeys("");
                    Actions getFocus = new Actions(driver);
                    getFocus.moveToElement(element).build().perform();

                    for (int strLocation = 0; strLocation < valueStringsArr.length; strLocation++) {
                        if (!valueStringsArr[strLocation].isEmpty()) {
                            super.sleep(Integer.parseInt("500"));
                            String[] charArr =
                                    valueStringsArr[strLocation]
                                            .split("(?<!\\\\)\\+");
                            type(charArr);
                        }
                    }

                    reportresult(true, "TYPEKEY :" + objectName + "", "PASSED",
                            "Type Key on Element [ " + objectName
                                    + " ] with Locator : " + objectID
                                    + " | Input Value [" + value + "]");
                    break;
                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "TYPEKEY :" + objectName + "",
                                "FAILED",
                                "TYPEKEY command cannot access  :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " [Input Value = " + value
                                        + "]");
                        checkTrue(false, true,
                                "TYPEKEY command cannot access  :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " [Input Value = " + value
                                        + "]");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            e.printStackTrace();
            reportresult(true, "TYPEKEY :" + objectName + "", "FAILED",
                    "TYPEKEY command  :Element [ " + objectName
                            + " ] with Locator : " + objectID + " not present");
            checkTrue(false, true, "TYPEKEY command  :Element [ " + objectName
                    + " ] with Locator : " + objectID + " not present");
        }
    }

    /**
     * Key press.
     * 
     * @param objectName
     *            the object name
     * @param identifire
     *            the identifire
     * @param value
     *            the value
     */
    public final void keyPress(final String objectName,
            final String identifire, final Object value) {
        this.locatorIdentifire = identifire;
        keyPress(objectName, value);
        this.locatorIdentifire = "";
    }

    /**
     * Simulates a keypress in to an input field as though you typed it key by
     * key from the keyboard.<br>
     * The keys should be seperated form a | charater to be typed correctly.<br>
     * <br>
     * 
     * Example: A|B|C|ctrl|\n|\t|1|2|3 <br>
     * <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param objValue
     *            the obj value
     */

    public final void keyPress(final String objectName, final Object objValue) {

        String value = checkNullObject(objValue, "KEYPRESS");
        WebDriver driver = getDriver();
        int counter = getRetryCount();

        String[] valueStringsArr = value.split("\\|");

        // Getting the actual object identification from the object map
        String objectID =
                ObjectMap.getObjectSearchPath(objectName, locatorIdentifire);
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;

                    // Calling the actual command
                    element.sendKeys("");
                    Actions getFocus = new Actions(driver);
                    getFocus.moveToElement(element).build().perform();

                    for (int strLocation = 0; strLocation < valueStringsArr.length; strLocation++) {
                        if (!valueStringsArr[strLocation].isEmpty()) {
                            super.sleep(Integer.parseInt("1000"));
                            String[] charArr =
                                    valueStringsArr[strLocation]
                                            .split("(?<!\\\\)\\+");
                            type(charArr);
                        }
                    }

                    reportresult(true, "KEYPRESS :" + objectName + "",
                            "PASSED", "Key Press on Element [ " + objectName
                                    + " ] with Locator : " + objectID
                                    + " | Input Value [" + value + "]");
                    break;
                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "KEYPRESS :" + objectName + "",
                                "FAILED",
                                "KEYPRESS command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + "  [Input Value = "
                                        + value + "]");
                        checkTrue(false, true,
                                "KEYPRESS command cannot access:Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + "  [Input Value = "
                                        + value + "]");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            e.printStackTrace();
            reportresult(true, "KEYPRESS :" + objectName + "", "FAILED",
                    "KEYPRESS command  :Element [" + objectName
                            + "] with Locator : " + objectID
                            + " [Input Value = " + value + "] not present");
            checkTrue(false, true, "KEYPRESS command  :Element [" + objectName
                    + "] with Locator : " + objectID + " [Input Value = "
                    + value + "] not present");
        }
    }

    /**
     * Checks if a text in an element is according to a given pattern <br/>
     * . Can be used to check the value of labels, spans, inputs, etc.(Any
     * element which is containing inner text.)<br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifier
     *            the identifier
     * @param pattern
     * <br>
     *            For the pattern following format shouls be used.<br>
     * <br>
     *            For a uppercase string format should be <b>S</b><br>
     *            For a lowercase string format should be <b>s</b><br>
     *            For a digit format should be <b>d</b><br>
     *            For a special character the character should be entered as it
     *            is.<br>
     * <br>
     *            Ex 1:<br>
     *            For verifying a string like : abc-123#ABC <br>
     *            the pattern should be : sss-ddd#SSS <br>
     * <br>
     * 
     *            Ex 2:<br>
     *            For verifying a date : 12/March/2013 <br>
     *            the pattern should be : dd/Ssss/dddd <br>
     * <br>
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkPattern(final String objectName,
            final String identifier, final String pattern,
            final boolean stopOnFailure, final Object... customError) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doCheckPattern(locator, pattern, customError);
    }

    /**
     * Check pattern.
     * 
     * @param objectName
     *            the object name
     * @param pattern
     *            the pattern
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkPattern(final String objectName,
            final String pattern, final boolean stopOnFailure,
            final Object... customError) {
        checkPattern(objectName, "", pattern, stopOnFailure, customError);
    }

    /*
     * public void checkPattern(final String objectName, final String
     * identifire, final String pattern) { this.identifire = identifire;
     * checkPattern(objectName, pattern); this.identifire = ""; }
     */

    /**
     * Checks if a text in an element is according to a given pattern <br/>
     * . Can be used to check the value of labels, spans, inputs, etc.(Any
     * element which is containing inner text.)<br>
     * 
     * @param locator
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param pattern
     * <br>
     * <br>
     *            <b>(Simplified Use)</b><br>
     * <br>
     *            For the pattern following format shouls be used.<br>
     * <br>
     *            For a uppercase string format should be <b>S</b><br>
     *            For a lowercase string format should be <b>s</b><br>
     *            For a digit format should be <b>d</b><br>
     *            For a special character the character should be entered as it
     *            is.<br>
     * <br>
     *            Ex 1:<br>
     *            For verifying a string like : abc-123#ABC <br>
     *            the pattern should be : sss-ddd#SSS <br>
     * <br>
     * 
     *            Ex 2:<br>
     *            For verifying a date : 12/March/2013 <br>
     *            the pattern should be : dd/Ssss/dddd <br>
     * <br>
     * 
     *            <b>(Advanced Use)</b><br>
     * <br>
     *            For advanced use the pure java regex pattern can be passed for
     *            the pattern. The regex pattern should have a prefix of
     *            'regex='<br>
     * <br>
     * 
     *            Ex 1:<br>
     *            For verifying a string like : abc-123#ABC <br>
     *            An example pattern will be :
     *            regex=[a-z][a-z][a-z]-\d\d\d#[A-Z][A-Z][A-Z]
     * 
     * <br>
     * <br>
     * @param customError
     *            the custom error
     */

    private void doCheckPattern(final ObjectLocator locator,
            final String pattern, final Object[] customError) {

        int counter = getRetryCount();
        String returnValue = "";

        String regex = getRegexPattern(pattern);

        // Getting the actual object identification from the object map
        String objectID = locator.getActualLocator();
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;

                    // Calling the actual command
                    returnValue = element.getText().trim();
                    if (returnValue.matches(regex)) {
                        reportresult(true,
                                "CHECKPATTERN :" + locator.getLogicalName()
                                        + "Input Value = " + pattern, "PASSED",
                                "Check Pattern [" + pattern + "] on Element ["
                                        + objectID + "]");
                        break;
                    } else {

                        reportresult(
                                true,
                                "CHECKPATTERN :" + locator.getLogicalName()
                                        + "",
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : Checked regex pattern ["
                                        + pattern
                                        + "] is different from the actual value : ("
                                        + returnValue + ")");
                        checkTrue(
                                false,
                                true,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : Checked regex pattern ["
                                        + pattern
                                        + "] is different from the actual value : ("
                                        + returnValue + ")");
                        break;

                    }

                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        e.printStackTrace();
                        String objectLogicalName = locator.getLogicalName();

                        reportresult(
                                true,
                                "CHECKPATTERN :" + objectLogicalName + "",
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : CHECKPATTERN command cannot access :Element ("
                                        + objectLogicalName
                                        + ") with Locator : [" + objectID
                                        + "] pattern = [" + pattern + "]");
                        checkTrue(
                                false,
                                true,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : CHECKPATTERN command cannot access :Element ("
                                        + objectLogicalName
                                        + ") with Locator : [" + objectID
                                        + "] pattern = [" + pattern + "]");

                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            String objectLogicalName = locator.getLogicalName();
            e.printStackTrace();

            reportresult(true, "CHECKPATTERN :" + objectLogicalName + "",
                    "FAILED", "CHECKPATTERN command  :Element ("
                            + objectLogicalName + ") with Locator : ["
                            + objectID + "] pattern = [" + pattern
                            + "] not present");
            checkTrue(false, true, "CHECKPATTERN command  :Element ("
                    + objectLogicalName + ") with Locator : [" + objectID
                    + "] pattern = [" + pattern + "] not present");

        }
    }

    /**
     * Gets the regex pattern.
     * 
     * @param patternString
     *            the pattern string
     * @return the regex pattern
     */
    private String getRegexPattern(final String patternString) {

        String regex = "";
        String pattern = patternString;
        String patternInLower = patternString.toLowerCase(Locale.getDefault());
        if (patternInLower.startsWith("regex=")) {
            pattern =
                    pattern.substring(pattern.indexOf('=') + 1,
                            pattern.length());
            regex = pattern;
        } else if (patternInLower.startsWith("regexp:")) {
            pattern = pattern.replaceAll("regexp:", "");
            regex = pattern;
        } else {
            char[] patternChars = pattern.toCharArray();
            StringBuilder regexBuilder = new StringBuilder();
            for (int strIndex = 0; strIndex < patternChars.length; strIndex++) {

                if (patternChars[strIndex] == 'S') {
                    regexBuilder.append("[A-Z]");
                } else if (patternChars[strIndex] == 's') {
                    regexBuilder.append("[a-z]");
                } else if (patternChars[strIndex] == 'd') {
                    regexBuilder.append("\\d");
                } else {
                    regexBuilder.append(patternChars[strIndex]);
                }
            }
            regex = regexBuilder.toString();
        }
        return regex;
    }

    /**
     * Adds a new comment line to the VTAF test manager report.<br>
     * Functions only with the VTAF test manager report<br>
     * <br>
     * 
     * @param objMessage
     *            the obj message
     */

    public final void writeToReport(final Object objMessage) {
        String message = checkNullObject(objMessage, "WRITE TO REPORT");

        FileOutputStream fos = null;
        try {
            Properties prop = getProp();
            fos = new FileOutputStream(getPropertiesLocation());
            prop.setProperty("tcComment", "\n" + message);
            prop.store(fos, null);
            reportresult(true, "WRITE TO REPORT : ", "PASSED",
                    " Report Message :[" + message + "]");
        } catch (FileNotFoundException e) {
            reportresult(true, "WRITE TO REPORT : ", "FAILED", " [" + message
                    + "]");
            e.printStackTrace();
        } catch (IOException e) {
            reportresult(true, "WRITE TO REPORT : ", "FAILED", " [" + message
                    + "]");
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Simulates a user hovering a mouse over the specified element. <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * 
     * @param identifire
     *            :
     * 
     *            Identifier is us to increase the reusablity of the locator.
     *            The usage can be defined using the following examble <br>
     * <br>
     *            assume the following locator is assigned the following logical
     *            object name at the object map <br>
     * <br>
     *            <b>locator :</b> //a[@href='http://www.virtusa.com/']<br>
     *            <b>Name :</b> virtusaLink<br>
     * <br>
     * 
     *            If the user thinks that the locator can be made generalized,
     *            it can be parameterized like the following <br>
     * <br>
     *            //a[@href='http://&LTp1&GT/']<br>
     * <br>
     *            once the method is used, pass the <b>identifier</b> as follows<br>
     *            p1: www.virtusa.com<br>
     * <br>
     *            The absolute xpath will be dynamically generated
     * */
    public final void mouseOver(final String objectName, final String identifire) {

        this.locatorIdentifire = identifire;
        mouseOver(objectName);
        this.locatorIdentifire = "";
    }

    /**
     * Simulates a user hovering a mouse over the specified element. <br>
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * 
     * */

    public final void mouseOver(final String objectName) {
        String objectID = "";
        int counter = getRetryCount();
        WebDriver driver = getDriver();
        try {
            // Retrieve the correct object locator from the object map
            objectID =
                    ObjectMap
                            .getObjectSearchPath(objectName, locatorIdentifire);
            // first verify whether the element is present in the current web
            // pagge
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following while loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times untill command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exitted from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;

                    Actions builder = new Actions(driver);
                    // call for selenium web driver command
                    builder.moveToElement(element).build().perform();
                    // if not exception is called consider and report the result
                    // as passed
                    reportresult(true, "MOUSE OVER :" + objectName + "",
                            "PASSED", "Mouse Over Element [" + objectName
                                    + "] with Locator : [" + objectID + "] ");
                    // if the testcase passed move out from the loop
                    break;
                } catch (StaleElementReferenceException staleElementException) {
                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {

                        e.printStackTrace();
                        reportresult(true, "MOUSE OVER :" + objectName + "",
                                "FAILED",
                                "MOUSE OVER command cannot access Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                        checkTrue(false, true,
                                "MOUSE OVER command cannot access Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */

        } catch (Exception e) {

            e.printStackTrace();
            /*
             * VTAF result reporter call
             */
            reportresult(true, "MOUSE OVER :" + objectName + "", "FAILED",
                    "MOUSE OVER command  :Element (" + objectName
                            + ") with Locator : [" + objectID + "] not present");

            /*
             * VTAF specific validation framework reporting
             */
            checkTrue(false, true, "MOUSE OVER command  :Element ("
                    + objectName + ") with Locator : [" + objectID
                    + "] not present");
        }

    }

    /**
     * Selects a frame within the current window. <br>
     * (You may invoke this command multiple times to select nested frames.) <br>
     * To select the parent frame, use "relative=parent" as a locator; to select
     * the top frame, use "relative=top". You can also select a frame by its
     * 0-based index number; select the first frame with "index=0", or the third
     * frame with "index=2". You may also use a DOM expression to identify the
     * frame you want directly, like this: dom=frames["main"].frames["subframe"]<br>
     * <br>
     * 
     * @param frameName
     *            the frame name
     * @param identifier
     *            the identifier
     */

    public final void selectFrame(final String frameName,
            final String identifier) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(frameName, identifier);
        ObjectLocator locator =
                new ObjectLocator(frameName, identifier, actualLocator);
        doSelectFrame(locator);
    }

    /**
     * Select frame.
     * 
     * @param objectName
     *            the object name
     */
    public final void selectFrame(final String objectName) {
        selectFrame(objectName, "");
    }

    /**
     * Selects a frame within the current window. <br>
     * (You may invoke this command multiple times to select nested frames.) <br>
     * To select the parent frame, use "relative=parent" as a locator; to select
     * the top frame, use "relative=top". You can also select a frame by its
     * 0-based index number; select the first frame with "index=0", or the third
     * frame with "index=2". You may also use a DOM expression to identify the
     * frame you want directly, like this: dom=frames["main"].frames["subframe"]
     * 
     * @param locator
     *            the locator
     */

    private void doSelectFrame(final ObjectLocator locator) {
        int counter = getRetryCount();
        int frameIndex = -1;
        WebElement element = null;

        // Getting the actual object identification from the object map
        String objectID = locator.getActualLocator();
        String objectIDValue = objectID.toLowerCase(Locale.getDefault()).trim();
        try {
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {

                    counter--;
                    // Calling the actual command
                    TargetLocator target;
                    if (objectIDValue.startsWith("index=")) {
                        frameIndex =
                                Integer.parseInt(objectID.substring(
                                        objectID.indexOf('=') + 1,
                                        objectID.length()).trim());
                        target = getDriver().switchTo();
                        target.defaultContent();
                        target.frame(frameIndex);

                    } else if ("parent".equals(objectIDValue)
                            || "null".equals(objectIDValue)) {

                        target = getDriver().switchTo();
                        target.defaultContent();
                    } else {
                        checkForNewWindowPopups();
                        element = checkElementPresence(objectID);
                        target = getDriver().switchTo();
                        target.frame(element);
                    }

                    reportresult(true, "SELECT FRAME :" + locator + "",
                            "PASSED",
                            "Select Frame [ " + locator.getLogicalName()
                                    + " ] with Locator : " + objectID);
                    break;
                } catch (Exception e) {

                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();
                        reportresult(true, "SELECT FRAME :" + locator + "",
                                "FAILED",
                                "SELECT FRAME command cannot access :Frame ("
                                        + locator + ") with Locator : ["
                                        + objectID + "]");
                        checkTrue(false, true,
                                "SELECT FRAME command cannot access :Frame ("
                                        + locator + ") with Locator : ["
                                        + objectID + "]");
                    }
                }

            }
        } catch (Exception ex) {

            ex.printStackTrace();
            reportresult(true, "SELECT FRAME :" + locator + "", "FAILED",
                    "SELECT FRAME command  :Frame (" + locator
                            + ") with Locator : [" + objectID + "] not present");
            checkTrue(false, true, "SELECT FRAME command  :Frame (" + locator
                    + ") with Locator : [" + objectID + "] not present");

        }
        /*
         * END DESCRIPTION
         */
    }

    /**
     * Performs a Java robot click on the specific coordinates. <br>
     * 
     * @param resolution
     *            the resolution
     * @param coordinates
     *            the coordinates
     * @param waitTime
     *            the wait time
     * @throws Exception
     *             the exception
     */

    public final void mouseMoveAndClick(final String resolution,
            final String coordinates, final String waitTime) throws Exception {

        String res = resolution;
        final int f11KeyCode = KeyEvent.VK_F11;
        final int optimumPauseBetweenkeyCombs = 10;
        if (res.startsWith("prop=")) {

            String resolutionFromProp =
                    getExecProps().getProperty((res.split("prop=")[1]));
            if (resolutionFromProp != null) {
                res = resolutionFromProp;
            } else {
                reportresult(true, "MOUSE MOVE AND CLICK:", "FAILED",
                        "MOUSE MOVE AND CLICK command: Invalid property key value passed : "
                                + res);
                checkTrue(false, true,
                        "MOUSE MOVE AND CLICK command: Invalid property key value passed : "
                                + res);
            }
        }

        float screenWidht = 0;
        float screeHigt = 0;
        try {
            String[] resArr = res.split(",");
            screenWidht = Float.parseFloat(resArr[0]);
            screeHigt = Float.parseFloat(resArr[1]);
        } catch (Exception e) {

            getLog().error(e);
            reportresult(true, "MOUSE MOVE AND CLICK:", "FAILED",
                    "MOUSE MOVE AND CLICK command: Invalid input value passed for resolution : "
                            + res);
            checkTrue(false, true,
                    "MOUSE MOVE AND CLICK command: Invalid input value passed for resolution : "
                            + res);
        }

        String[] coordinatesArr = coordinates.split(",");
        float xCordinate = 0;
        float yCordinate = 0;
        try {
            xCordinate = Float.parseFloat(coordinatesArr[0]);
            yCordinate = Float.parseFloat(coordinatesArr[1]);
        } catch (Exception e) {

            getLog().error(e);
            reportresult(true, "MOUSE MOVE AND CLICK:", "FAILED",
                    "MOUSE MOVE AND CLICK command: Invalid input value passed for coordinates : "
                            + coordinates);
            checkTrue(false, true,
                    "MOUSE MOVE AND CLICK command: Invalid input value passed for coordinates : "
                            + coordinates);
        }
        String command = "";

        if (coordinatesArr.length > 2) {

            command = coordinatesArr[2];
        }

        Robot robot = new Robot();

        super.sleep(Integer.parseInt(waitTime));

        int xCordinateAutual = (int) calWidth(screenWidht, xCordinate);
        int yCordinateAutual = (int) calHight(screeHigt, yCordinate);

        robot.keyPress(f11KeyCode);
        robot.delay(optimumPauseBetweenkeyCombs);
        robot.keyRelease(f11KeyCode);
        sleep(retryInterval);

        // Mouse Move
        robot.mouseMove(xCordinateAutual, yCordinateAutual);

        // Click
        if ("".equals(command)) {

            robot.mousePress(InputEvent.BUTTON1_MASK);
            sleep(retryInterval);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            reportresult(true, "MOUSE MOVE AND CLICK : ", "PASSED",
                    "Mouse Move and Click at Coordinate [" + xCordinateAutual
                            + "," + yCordinateAutual
                            + "] on Screen Resolution [" + res + "]");

        } else if ("dclick".equals(command.toLowerCase(Locale.getDefault()))) {

            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            final int optimumPauseBetweenDclick = 500;
            robot.delay(optimumPauseBetweenDclick);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            reportresult(true, "MOUSE MOVE AND DOUBLE CLICK : ", "PASSED",
                    "MOUSE MOVE AND DOUBLE CLICK command: Resolution: " + res);
            checkTrue(false, true, "MOUSE MOVE AND CLICK command: Resolution: "
                    + res);

        }

        robot.keyPress(f11KeyCode);
        robot.delay(optimumPauseBetweenkeyCombs);
        robot.keyRelease(f11KeyCode);
    }

    /**
     * Support method for mouseMoveAndClick Calculate the width of the test
     * runner PC.
     * 
     * @param oldSystemWidth
     *            the old system width
     * @param oldSystemX
     *            the old system x
     * @return the double
     */

    public static double calWidth(final double oldSystemWidth,
            final double oldSystemX) {
        double newSystemWidth = resizeScreen().width;
        return (oldSystemX / oldSystemWidth) * newSystemWidth;

    }

    /**
     * Support method for mouseMoveAndClick <br>
     * Calculate the height of the test runner PC.
     * 
     * @param oldSystemHigh
     *            the old system high
     * @param oldSystemY
     *            the old system y
     * @return the double
     */
    // High of the test runner PC
    public static double calHight(final double oldSystemHigh,
            final double oldSystemY) {
        double newSystemHigh = resizeScreen().height;
        return (oldSystemY / oldSystemHigh) * newSystemHigh;
    }

    /**
     * Support method for mouseMoveAndClick <br>
     * Resize the screen.
     * 
     * @return the dimension
     */
    private static Dimension resizeScreen() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return toolkit.getScreenSize();
    }

    /**
     * Fires a native robot event into the webpage. <br>
     * 
     * @param event
     *            : Specicy the event which should be performed<br>
     *            1. If a keyboard event event should be started with KEY%<br>
     * <br>
     *            Ex: KEY%\n|\t<br>
     * <br>
     *            2. If it is a mouse event event should be started with MOUSE%<br>
     * <br>
     *            Ex: MOUSE%CLICK|RCLICK <br>
     * <br>
     * @param waittime
     *            : Wait time before the events.
     * */
    public final void fireEvent(final String event, final String waittime) {

        /*
         * START DESCRIPTION following for loop was added to make the command
         * more consistent try the command for give amount of time (can be
         * configured through class variable RETRY) command will be tried for
         * "RETRY" amount of times or until command works. any exception thrown
         * within the tries will be handled internally.
         * 
         * can be exited from the loop under 2 conditions 1. if the command
         * succeeded 2. if the RETRY count is exceeded
         */
        try {
            super.sleep(Integer.parseInt(waittime));
            setRobot(new Robot());
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            if (event.startsWith("KEY%")) {

                fireKeyEvent(getRobot(), event.split("%")[1]);
            } else if (event.startsWith("MOUSE%")) {

                fireMouseEvent(event.split("%")[1]);
            } else if (event.startsWith("VERIFY%")) {

                fireEventVerifyValue(event.split("%")[1]);
            } else {
                reportresult(true, "FIRE EVENT :", "FAILED",
                        "Invalid event type passed :" + event);
                checkTrue(false, true, "Invalid event type passed :" + event);
            }

            reportresult(true, "FIRE EVENT Command : ", "PASSED",
                    "Input Events = " + event);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            reportresult(true, "FIRE EVENT Command:", "FAILED",
                    "Invalid argument passed for wait time.");
            checkTrue(false, true, "Invalid argument passed for wait time.");

        } catch (Exception e) {

            if (e.getMessage().startsWith("Command")) {
                e.printStackTrace();
                reportresult(true, "FIRE EVENT :", "FAILED",
                        "FIRE EVENT passed command is invalid (" + event + ")");
                checkTrue(false, true, "FIRE EVENT passed command is invalid ("
                        + event + ") ");
            } else {
                e.printStackTrace();
                reportresult(true, "FIRE EVENT Command:", "FAILED",
                        "FIRE EVENT command cannot perform the event (" + event
                                + ")");
                checkTrue(false, true,
                        "FIRE EVENT command cannot cannot perform the event ("
                                + event + ") ");

            }
        }
    }

    /**
     * Get the selected text in webpage to the clipboard and compare the value
     * with the given input.
     * 
     * @param value
     *            the value
     * @throws Exception
     *             the exception
     */

    private void fireEventVerifyValue(final String value) throws Exception {

        String clipBoardText = "";
        Robot robot = getRobot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        sleep(retryInterval);
        Transferable trans =
                Toolkit.getDefaultToolkit().getSystemClipboard()
                        .getContents(null);

        try {
            if (trans != null) {
                clipBoardText =
                        (String) trans.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (clipBoardText.equals(value)) {

            reportresult(true, "FIRE EVENT : VERIFY VALUE " + value + "",
                    "PASSED", "");
        } else {

            reportresult(true, "FIRE EVENT : VERIFY VALUE " + value + "",
                    "FAILED",
                    "FIRE EVENT : VERIFY VALUE : value match expected. Actual : "
                            + clipBoardText + " Expected : " + value + "");
            checkTrue(false, true,
                    "FIRE EVENT : VERIFY VALUE : value match expected. Actual : "
                            + clipBoardText + " Expected : " + value + "");
        }
    }

    /**
     * Fires a set of java robot key events into the webpage.
     * 
     * @param robot
     *            the robot
     * @param commands
     *            the commands
     * @throws Exception
     *             the exception
     */

    private void fireKeyEvent(final Robot robot, final String commands)
            throws Exception {

        String[] commandSet = commands.split("\\|");

        for (String fullCommand : commandSet) {
            sleep(retryInterval);
            // int commandIndex = 0;
            int inputIndex = fullCommand.indexOf('=');
            String command = fullCommand.substring(0, inputIndex);
            String input =
                    fullCommand.substring(inputIndex + 1, fullCommand.length());

            String[] charArr = input.split("(?<!\\\\)\\+");

            if ("type".equalsIgnoreCase(command)) {

                StringSelection stringSelection = new StringSelection(input);
                clipboard.setContents(stringSelection, null);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

            } else if ("Key".equalsIgnoreCase(command)) {

                type(charArr);

            } else if ("wait".equalsIgnoreCase(command)) {

                super.sleep(Integer.parseInt(input));
            }

        }
    }

    /**
     * Fires a set of java robot mouse events into the webpage.
     * 
     * @param commands
     *            the commands
     * @throws Exception
     *             the exception
     */

    private void fireMouseEvent(final String commands) throws Exception {

        String[] commandSet = commands.split("\\|");
        Robot robot = getRobot();
        final int optimumPauseBetweenKeyCombs = 10;
        final int f11KeyCode = KeyEvent.VK_F11;
        for (String fullCommand : commandSet) {
            sleep(retryInterval);
            int commandIndex = 0;
            int inputIndex = 1;
            String command = fullCommand.split("=")[commandIndex];
            String input = fullCommand.split("=")[inputIndex];

            if ("MOVE".equalsIgnoreCase(command)) {

                String[] coords = input.split(",");
                int resolutionWidth = Integer.parseInt(coords[0]);
                int resolutionHeight = Integer.parseInt(coords[inputIndex]);
                int x = Integer.parseInt(coords[inputIndex + 1]);
                int y = Integer.parseInt(coords[inputIndex + 2]);

                int xCordinateAutual = (int) calWidth(resolutionWidth, x);
                int yCordinateAutual = (int) calHight(resolutionHeight, y);

                robot.keyPress(f11KeyCode);
                robot.delay(optimumPauseBetweenKeyCombs);
                robot.keyRelease(f11KeyCode);
                sleep(retryInterval);

                // Mouse Move
                robot.mouseMove(xCordinateAutual, yCordinateAutual);

                robot.keyPress(f11KeyCode);
                sleep(optimumPauseBetweenKeyCombs);
                robot.keyRelease(f11KeyCode);

            } else if ("SCROLL".equalsIgnoreCase(command)) {

                robot.mouseWheel(Integer.parseInt(input));

            } else if ("wait".equalsIgnoreCase(command)) {

                super.sleep(Integer.parseInt(input));
            } else {
                throw new Exception("Command " + command);
            }
        }
    }

    /**
     * Switch between diffent users by user name.
     * 
     * @param instanceName
     *            the instance name
     */
    public final void switchUser(final String instanceName) {

        boolean isNewInstance;
        if (getSeleniumInstances().containsKey(instanceName)) {
            isNewInstance = false;
        } else {
            isNewInstance = true;
        }
        if (!isNewInstance) {
            setDriver(getSeleniumInstances().get(instanceName));
            reportresult(true, "SWITCH USER :" + instanceName + "", "PASSED",
                    "SWITCH USER command :Current user changed to New User("
                            + instanceName + ")");
        } else {
            reportresult(true, "SWITCH USER :" + instanceName + "", "FAILED",
                    "SWITCH USER command : User (" + instanceName
                            + ") is not created. ");
            checkTrue(false, true, "SWITCH USER command : User ("
                    + instanceName + ") is not created. ");
        }

    }

    /**
     * Creates a new user profile and launches a seperate browser session for
     * the user.
     * 
     * @param instanceName
     *            the instance name
     * @param browser
     *            the browser
     * @param serverConfig
     *            the server config
     */

    public final void createUser(final String instanceName,
            final String browser, final String serverConfig) {

        boolean isNewInstance;
        if (getSeleniumInstances().containsKey(instanceName)) {
            isNewInstance = false;
        } else {
            isNewInstance = true;
        }

        if (isNewInstance) {

            try {
                setUp(instanceName, browser, serverConfig);
                startBrowserSession(browser);
                startOfTestCase();
                reportresult(true, "CREATE USER :" + instanceName + "",
                        "PASSED", "CREATE USER command : User (" + instanceName
                                + ") is Created. ");
            } catch (IllegalArgumentException e) {

                String errorString = e.getMessage();

                reportresult(
                        true,
                        "CREATE USER :" + instanceName + "",

                        "FAILED",

                        "CREATE USER command : "
                                + "Error occured while confuguring selenium with given configuration. Error : "

                                + errorString);

                checkTrue(
                        false,
                        true,

                        "CREATE USER command : "
                                + "Error occured while confuguring selenium with given configuration. Error : "

                                + errorString);

            } catch (Exception e) {
                String errorString = e.getMessage();
                reportresult(
                        true,
                        "CREATE USER :" + instanceName + "",
                        "FAILED",
                        "CREATE USER command : "
                                + "Error occured while invoking the new user. Error : "
                                + errorString);
                checkTrue(false, true, "CREATE USER command : "
                        + "Error occured while invoking the new user. Error : "
                        + errorString);
            }

        } else {
            reportresult(true, "CREATE USER :" + instanceName + "", "FAILED",
                    "CREATE USER command : User (" + instanceName
                            + ") is already available. ");
            checkTrue(false, true, "CREATE USER command : User ("
                    + instanceName + ") is already available. ");
        }

    }

    /**
     * Checks the properties of an browser property given by the property name
     * is exists if the property does not exists, further continuation of the
     * script execution will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br>
     * <br>
     * in the web page.
     * 
     * Property name : WINDOWPRESENT <br>
     * Check if the window is present
     * 
     * @param windowName
     *            : object name alias given by the user.
     * @param identifier
     *            the identifier
     * @param propertyname
     *            : Name of the object property
     * @param objExpectedvale
     *            : value expected for the given property
     * @param stopOnFailure
     *            :if <I> true </I> : stop the execution after the failure <br>
     *            if <I> false </I>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */
    public final void checkWindowProperty(final String windowName,
            final String identifier, final String propertyname,
            final Object objExpectedvale, final boolean stopOnFailure,
            final Object... customError) {

        this.locatorIdentifire = identifier;
        checkWindowProperty(windowName, propertyname, objExpectedvale,
                stopOnFailure, customError);
        this.locatorIdentifire = "";
    }

    /**
     * Checks the properties of an browser property given by the property name
     * is exists if the property does not exists, further continuation of the
     * script execution will be decided <br>
     * besed on value of the <b> continueExecution </b> parameter provided by
     * the user <br/>
     * <br>
     * in the web page.
     * 
     * Property name : WINDOWPRESENT <br>
     * Check if the window is present
     * 
     * @param windowName
     *            : object name alias given by the user.
     * @param propertyname
     *            : Name of the object property
     * @param objExpectedvale
     *            : value expected for the given property
     * @param stopOnFailure
     *            :if <I> true </I> : stop the execution after the failure <br>
     *            if <I> false </I>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */

    public final void checkWindowProperty(final String windowName,
            final String propertyname, final Object objExpectedvale,
            final boolean stopOnFailure, final Object... customError) {

        if (propertyname.equals(WindowValidationType.WINDOWPRESENT.toString())) {

            String expectedvale =
                    checkNullObject(objExpectedvale, "CHECK OBJECT PROPERTY");
            checkWindowPresent(windowName, propertyname, expectedvale,
                    stopOnFailure, customError);
        }

    }

    /**
     * Check if the window is present in the context.
     * 
     * @param windowName
     *            : object name alias given by the user.
     * @param propertyname
     *            : Name of the object property
     * @param expectedvale
     *            : value expected for the given property
     * @param stopOnFailure
     *            :if <I> true </I> : stop the execution after the failure <br>
     *            if <I> false </I>: Continue the execution after the failure
     * @param customError
     *            the custom error
     */

    private void checkWindowPresent(final String windowName,
            final String propertyname, final String expectedvale,
            final boolean stopOnFailure, final Object[] customError) {

        int counter = getRetryCount();
        boolean objectFound = false;
        WebDriver driver = getDriver();
        // String windowiden = "";

        // Getting the actual object identification from the object map
        String window =
                ObjectMap.getObjectSearchPath(windowName, locatorIdentifire);
        try {
            checkForNewWindowPopups();

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or untill command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */
            while (counter > 0) {
                try {
                    counter--;
                    String currentWinHandle = driver.getWindowHandle();
                    String targetWindow =
                            getMatchingWindowFromCurrentWindowHandles(driver,
                                    window);
                    driver.switchTo().window(currentWinHandle);
                    if (expectedvale.equalsIgnoreCase(String
                            .valueOf(targetWindow != null))) {

                        reportresult(true, "CHECK WINDOW PROPERTY:"
                                + propertyname + "", "PASSED", "Window ["
                                + windowName + "] [" + window + "]");
                    } else {

                        /*
                         * String customErrorMessage = ""; if(customError !=null
                         * &&
                         * !(customError[0].equals("null")||customError[0].equals
                         * ("")) ) {
                         * 
                         * for (int i=0;i<customError.length;i++){
                         * customErrorMessage =
                         * customErrorMessage+customError[i].toString(); }
                         * System.out.println(customErrorMessage); }
                         */

                        reportresult(
                                true,
                                "CHECK WINDOW PROPERTY:" + propertyname + "",
                                "FAILED",
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : Expected Property : "
                                        + propertyname + " expected value [ "
                                        + expectedvale
                                        + " ]does not match the actual ["
                                        + objectFound + "] for the window ["
                                        + windowName + "] [" + window + "]");
                        checkTrue(
                                false,
                                stopOnFailure,
                                ""
                                        + generateCustomError(customError)
                                        + " System generated Error : Expected Property : "
                                        + propertyname + " expected value [ "
                                        + expectedvale
                                        + " ]does not match the actual ["
                                        + objectFound + "] for the window ["
                                        + windowName + "] [" + window + "]");

                    }
                    break;
                } catch (WebDriverException ex) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        reportresult(true, "CHECK WINDOW PROPERTY:"
                                + propertyname + "", "FAILED",
                                "CHECK WINDOW PROPERTY  :Window (" + windowName
                                        + ") [" + window
                                        + "] is not accessible");
                        checkTrue(false, stopOnFailure,
                                "CHECK WINDOW PROPERTY  :Window (" + windowName
                                        + ") [" + window
                                        + "] is not accessible");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // if any exception is raised, report failure
            reportresult(true, "CHECK WINDOW PROPERTY:" + propertyname + "",
                    "FAILED", "CHECK WINDOW PROPERTY  :Window (" + windowName
                            + ") [" + window + "] is not accessible");
            checkTrue(false, stopOnFailure, "CHECK WINDOW PROPERTY  :Window ("
                    + windowName + ") [" + window + "] is not accessible");

        }

    }

    /** The Constant sql. */
    private static final String SQL = "?";

    /**
     * Gets the db table.
     * 
     * @param instanceName
     *            the instance name
     * @param query
     *            the query
     * @return the DB table
     * @throws Exception
     *             the exception
     */
    private ArrayList<Object> getDBTable(final String instanceName,
            final String query) throws Exception { // private

        ArrayList<Object> arrList = new ArrayList<Object>();
        ResultSet result = null;
        Connection con = null;
        PreparedStatement preparedStmt = null;
        con = getDatabaseInstances().get(instanceName);
        if (con == null) {

            throw new Exception("Connection instance unavaliable "
                    + instanceName);
        }
        try {
            preparedStmt = con.prepareStatement(SQL);
            preparedStmt.setString(1, query);
            result = preparedStmt.executeQuery(query);
            ResultSetMetaData md = result.getMetaData();
            int count = md.getColumnCount();

            while (result.next()) {

                for (int i = 1; i <= count; i++) {
                    arrList.add(result.getObject(i));
                }
            }
            if (arrList.isEmpty()) {
                throw new NullPointerException(
                        "Empty Result set for the query :- " + query);
            }
        } finally {
            if (preparedStmt != null) {
                preparedStmt.close();
            }
        }
        return arrList;

    }

    /**
     * Check db results.
     * 
     * @param instanceName
     *            the instance name
     * @param query
     *            the query
     * @param expectedValue
     *            the expected value
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    public final void checkDBResults(final String instanceName,
            final String query, final String expectedValue,
            final boolean stopOnFaliure, final Object... customError) {

        ArrayList<Object> objArrList;
        ArrayList<String> inputTable;
        ArrayList<String> strArrList = new ArrayList<String>();
        try {
            objArrList = getDBTable(instanceName, query);

            inputTable =
                    new ArrayList<String>(Arrays.asList(expectedValue
                            .split("(?<!\\\\),")));
            ArrayList<String> tempInputTable = new ArrayList<String>();
            for (String inputVal : inputTable) {
                String formattedValue = inputVal.replaceAll("\\\\,", ",");
                tempInputTable.add(formattedValue);
            }
            inputTable = tempInputTable;
            for (Object obj : objArrList) {
                strArrList.add(obj.toString());
            }
            String inputTableStr = StringUtils.join(inputTable, "|");
            String actualTableStr = StringUtils.join(strArrList, "|");
            if (actualTableStr.contains(inputTableStr)) {

                reportresult(true, "CHECK DB RESULTS : ", "PASSED",
                        "For Query = " + query + " :EXPECTED Value = "
                                + expectedValue);

            } else {

                reportresult(stopOnFaliure, "CHECK DB RESULTS :", "FAILED",
                        generateCustomError(customError)
                                + "Values mismatched for Query = " + query
                                + " :EXPECTED Value = " + expectedValue
                                + "Actual Value : " + actualTableStr);
                checkTrue(false, stopOnFaliure,
                        generateCustomError(customError)
                                + "Values mismatched for Query = " + query
                                + " :EXPECTED Value = " + expectedValue
                                + "Actual Value : " + actualTableStr);

            }

        } catch (SQLException e) {
            String errorMsg = e.getMessage();
            reportresult(stopOnFaliure, "CHECK DB RESULTS :", "FAILED",
                    "SQL Error occured" + errorMsg);
            checkTrue(false, stopOnFaliure, "SQL Error occured" + errorMsg);

        } catch (NullPointerException e) {
            String errorMsg = e.getMessage();

            reportresult(stopOnFaliure, "CHECK DB RESULTS :", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error :" + errorMsg);
            checkTrue(false, stopOnFaliure, ""
                    + generateCustomError(customError)
                    + " System generated Error :" + errorMsg);

        } catch (Exception e) {
            if (e.getMessage().startsWith("Connection instance unavaliable")) {
                reportresult(
                        true,
                        "CHECK DB RESULTS :" + instanceName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK DB RESULTS command : connection ("
                                + instanceName + ") is not created. ");
                checkTrue(
                        false,
                        true,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK DB RESULTS command : connection ("
                                + instanceName + ") is not created. ");

            } else {
                String errorMsg = e.getMessage();
                reportresult(stopOnFaliure, "CHECK DB RESULTS :", "FAILED",
                        errorMsg);
                checkTrue(false, stopOnFaliure, errorMsg);
            }
        }

    }

    /**
     * Gets the string db result.
     * 
     * @param instanceName
     *            the instance name
     * @param query
     *            the query
     * @return the string db result
     */
    public final String getStringDBResult(final String instanceName,
            final String query) {

        ArrayList<Object> arrList;
        String value = null;
        try {
            arrList = getDBTable(instanceName, query);
            value = arrList.get(0).toString();
            if (arrList.size() >= 2) {
                reportresult(
                        true,
                        "SET DB RESULTS : ",
                        "PASSED",
                        "For Query = "
                                + query
                                + " Actual result contains more than one value. Actual Values :- "
                                + arrList + " Return Value :- " + value);
            }
            reportresult(true, "SET DB RESULTS : ", "PASSED", "For Query = "
                    + query);
        } catch (SQLException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED",
                    "SQL Error occured" + errorString);
            checkTrue(false, true, "SQL Error occured" + errorString);
        } catch (NullPointerException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
            checkTrue(false, false, errorString);
        } catch (Exception e) {
            if (e.getMessage().startsWith("Connection instance unavaliable")) {
                reportresult(true, "SET DB RESULTS :" + instanceName + "",
                        "FAILED", "SET DB RESULTS command : connection ("
                                + instanceName + ") is not created. ");
                checkTrue(false, true, "SET DB RESULTS command : connection ("
                        + instanceName + ") is not created. ");
            } else {
                String errorString = e.getMessage();
                reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
                checkTrue(false, false, errorString);
            }
        }
        return value;
    }

    /**
     * Gets the int db result.
     * 
     * @param instanceName
     *            the instance name
     * @param query
     *            the query
     * @return the int db result
     */
    public final Integer getIntDBResult(final String instanceName,
            final String query) {

        ArrayList<Object> arrList;
        Integer value = null;
        try {
            arrList = getDBTable(instanceName, query);
            if (!(arrList.get(0) instanceof Integer)) {
                throw new NumberFormatException("The value trying to retrive ("
                        + arrList.get(0).toString()
                        + ") is not stored as an interger in the database.");
            }
            value = (Integer) arrList.get(0);
            reportresult(true, "SET DB RESULTS : ", "PASSED", "For Query = "
                    + query);
        } catch (SQLException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED",
                    "SQL Error occured" + errorString);
            checkTrue(false, true, "SQL Error occured" + errorString);
        } catch (NullPointerException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
            checkTrue(false, false, errorString);
        } catch (Exception e) {
            if (e.getMessage().startsWith("Connection instance unavaliable")) {
                reportresult(true, "SET DB RESULTS :" + instanceName + "",
                        "FAILED", "SET DB RESULTS command : connection ("
                                + instanceName + ") is not created. ");
                checkTrue(false, true, "SET DB RESULTS command : connection ("
                        + instanceName + ") is not created. ");
            } else {
                String errorString = e.getMessage();
                reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
                checkTrue(false, false, errorString);
            }
        }
        return value;
    }

    /**
     * Gets the boolean db result.
     * 
     * @param instanceName
     *            the instance name
     * @param query
     *            the query
     * @return the boolean db result
     */
    public final Boolean getBooleanDBResult(final String instanceName,
            final String query) {

        ArrayList<Object> arrList;
        Boolean value = null;
        try {
            arrList = getDBTable(instanceName, query);
            if (!(arrList.get(0) instanceof Boolean)) {
                throw new Exception("The value trying to retrive ("
                        + arrList.get(0).toString()
                        + ") is not stored as a boolean in the database.");
            }

            value = (Boolean) arrList.get(0);
            reportresult(true, "SET DB RESULTS : ", "PASSED", "For Query = "
                    + query);
        } catch (SQLException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED",
                    "SQL Error occured" + errorString);
            checkTrue(false, true, "SQL Error occured" + errorString);
        } catch (NullPointerException e) {
            String errorString = e.getMessage();
            reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
            checkTrue(false, false, errorString);
        } catch (Exception e) {
            if (e.getMessage().startsWith("Connection instance unavaliable")) {
                reportresult(true, "SET DB RESULTS :" + instanceName + "",
                        "FAILED", "SET DB RESULTS command : connection ("
                                + instanceName + ") is not created. ");
                checkTrue(false, true, "SET DB RESULTS command : connection ("
                        + instanceName + ") is not created. ");
            } else {
                String errorString = e.getMessage();
                reportresult(true, "SET DB RESULTS :", "FAILED", errorString);
                checkTrue(false, false, errorString);
            }
        }
        return value;
    }

    /**
     * Creates the db connection.
     * 
     * @param databaseType
     *            the database type
     * @param instanceName
     *            the instance name
     * @param url
     *            the url
     * @param username
     *            the username
     * @param password
     *            the password
     */
    public final void createDBConnection(final String databaseType,
            final String instanceName, final String url, final String username,
            final String password) {
        Connection con = null;
        boolean isNewInstance;

        if (getDatabaseInstances().containsKey(instanceName)) {
            isNewInstance = false;
        } else {
            isNewInstance = true;
        }

        if (isNewInstance) {

            try {
                if ("mysql".equalsIgnoreCase(databaseType)) {
                    String dbClass = "com.mysql.jdbc.Driver";
                    Class.forName(dbClass).newInstance();
                    con = DriverManager.getConnection(url, username, password);
                } else if ("oracle".equalsIgnoreCase(databaseType)) {
                    DriverManager
                            .registerDriver(new oracle.jdbc.driver.OracleDriver());
                    con = DriverManager.getConnection(url, username, password);
                } else if ("mssql".equalsIgnoreCase(databaseType)) {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection(url, username, password);
                } else if (databaseType.isEmpty()) {
                    reportresult(true, "CREATE DB CONNECTION :", "FAILED",
                            "Database type not selected");
                    checkTrue(false, true,
                            "CREATE DB CONNECTION command: Error :- No database type selected.");
                }
                putDatabaseInstances(instanceName, con);
                reportresult(true, "CREATE DB CONNECTION :", "PASSED",
                        "Instance name : " + instanceName + " DB URL : " + url
                                + "");
            } catch (SQLException e) {

                e.printStackTrace();
                reportresult(true, "CREATE DB CONNECTION :", "FAILED",
                        e.getMessage());
                checkTrue(
                        false,
                        true,
                        "CREATE DB CONNECTION command: Error :- "
                                + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                reportresult(true, "CREATE DB CONNECTION :", "FAILED",
                        e.getMessage());
                checkTrue(
                        false,
                        true,
                        "CREATE DB CONNECTION command: Error :- "
                                + e.getMessage());
            }

        }

    }

    /**
     * Checks if is image present.
     * 
     * @param path
     *            the path
     * @param isRotatable
     *            the is rotatable
     * @return the screen region
     * @throws FileNotFoundException
     *             throws if file is not avaliable
     */
    private ScreenRegion isImagePresent(final String path,
            final boolean isRotatable) throws FileNotFoundException {

        PropertyHandler propHandler = new PropertyHandler("runtime.properties");
        double maxRecQuality =
                Double.parseDouble(propHandler
                        .getRuntimeProperty("MAX_REG_QUALITY"));

        int rotationDegree =
                Integer.parseInt(propHandler
                        .getRuntimeProperty("ROTATION_DEGREE"));

        int retry = getRetryCount();
        double regQuality = maxRecQuality;
        Target target;
        File file =
                new File("src" + File.separator + "main" + File.separator
                        + "resources" + File.separator + "Images"
                        + File.separator + path);
        String entirePath = file.getAbsolutePath();
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        javaxt.io.Image img = new javaxt.io.Image(entirePath);
        ScreenRegion targetRegion = null;
        while (retry > 0) {
            retry--;
            ScreenRegion s = new DesktopScreenRegion();
            target = new ImageTarget(img.getBufferedImage());
            target.setMinScore(regQuality);
            targetRegion = s.find(target);
            if (targetRegion == null) {
                sleep(retryInterval);
                if (isRotatable) {
                    img.rotate(rotationDegree);
                }
            } else {
                break;
            }
        }

        return targetRegion;
    }

    /**
     * Handle image popup.
     * 
     * @param imagePath
     *            the image path
     * @param actionFlow
     *            the action flow
     * @param waitTime
     *            the wait time
     * @throws Exception
     *             the exception
     */
    public final void handleImagePopup(final String imagePath,
            final String actionFlow, final String waitTime) throws Exception {
        initRobot();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        this.inputStringp = actionFlow;
        this.waitTimep = waitTime;

        Thread newThread = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    sleep(Integer.parseInt(waitTimep));

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    ScreenRegion targetImage = isImagePresent(imagePath, false);
                    if (targetImage != null) {
                        forceHandlePopup(getRobot(), inputStringp);
                        reportresult(true, "HANDLE IMAGE POPUP :", "PASSED",
                                "Handle Image PopUp");
                    }
                } catch (FileNotFoundException f) {

                    reportresult(true, "HANDLE IMAGE POPUP :", "FAILED",
                            "File not found in the given location.");
                    checkTrue(true, true,
                            "HANDLE IMAGE POPUP command: Error :- File not found in the given location.");
                } catch (Exception e) {
                    e.printStackTrace();
                    reportresult(true, "HANDLE IMAGE POPUP :", "FAILED",
                            e.getMessage());
                    checkTrue(
                            false,
                            true,
                            "HANDLE IMAGE POPUP command: Error :- "
                                    + e.getMessage());
                }

            }
        }

        );

        newThread.start();

    }

    /**
     * Check image present.
     * 
     * @param path
     *            the path
     * @param isRotatable
     *            the is rotatable
     * @return true, if check image present
     */
    public final boolean checkImagePresent(final String path,
            final boolean isRotatable) {

        try {

            return isImagePresent(path, isRotatable) != null;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {

            return false;
        }

    }

    /**
     * Check image present.
     * 
     * @param dolocator
     *            the path
     * @param isRotatable
     *            the is rotatable
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckImagePresent(final ObjectLocator dolocator,
            final boolean isRotatable, final boolean stopOnFailure,
            final Object[] customError) {

        String path = "";
        // load the actual object id from the OR
        path = dolocator.getActualLocator();
        boolean isElementPresent = false;
        try {

            isElementPresent = isImagePresent(path, isRotatable) != null;
            if (isElementPresent) {
                reportresult(true, "CHECK IMAGE PRESENT:", "PASSED",
                        "Check Image Present with [" + path + "]");

            } else {

                reportresult(
                        true,
                        "CHECK IMAGE PRESENT:",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK IMAGE PRESENT command cannot find the image :- "
                                + path + " in current screen.");
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK IMAGE PRESENT command cannot find the image :- "
                                + path + " in current screen.");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            reportresult(true, "CHECK IMAGE PRESENT :", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : Given location is invalid :- "
                    + path + "");
            checkTrue(false, stopOnFailure, ""
                    + generateCustomError(customError)
                    + " System generated Error : Given location is invalid :- "
                    + path + "");

        } catch (Exception e) {
            e.printStackTrace();

            reportresult(
                    true,
                    "CHECK IMAGE PRESENT :",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : Trying to access Invalid Image :- "
                            + path + "");
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : Trying to access Invalid Image :- "
                            + path + "");

        }

    }

    /**
     * Check image present.
     * 
     * @param objectName
     *            : Logical name of the web element assigned by the automation
     *            scripter
     * @param identifier
     *            the identifier
     * @param isRotatable
     *            : image rotate or not
     * @param stopOnFailure
     *            : true or false
     * @param customError
     *            the custom error
     */

    public final void checkImagePresent(final String objectName,
            final String identifier, final boolean isRotatable,
            final boolean stopOnFailure, final Object... customError) {

        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doCheckImagePresent(locator, isRotatable, stopOnFailure, customError);
    }

    /**
     * checkImagePresent.
     * 
     * @param objectName
     *            the object name
     * @param isRotatable
     *            : image rotate or not
     * @param stopOnFailure
     *            : true or false
     * @param customError
     *            the custom error
     */
    public final void checkImagePresent(final String objectName,
            final boolean isRotatable, final boolean stopOnFailure,
            final Object... customError) {
        checkImagePresent(objectName, "", isRotatable, stopOnFailure,
                customError);
    }

    /**
     * Screenshot.
     * 
     * @param imageName
     *            the image name
     */
    public final void screenshot(final String imageName) {

        File screenShotFolder = new File("Screenshots");
        WebDriver driver = getDriver();
        try {
            if (!screenShotFolder.exists() && !screenShotFolder.mkdir()) {
                getLog().error(
                        "Cannot create a new file in the intended location. "
                                + "" + screenShotFolder.getAbsolutePath());
            }
            File scrFile =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath =
                    screenShotFolder.getAbsolutePath() + File.separator
                            + imageName + ".png";
            FileUtils.copyFile(scrFile, new File(filePath));
            reportresult(true, "SCREENSHOT :", "PASSED",
                    "Screenshot saved at :" + filePath);

            
        } catch (Exception e) {

            reportresult(
                    true,
                    "SCREENSHOT :",
                    "FAILED",
                    "Screenshot command: Screen shot capturing failed"
                            + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Pdf verify.
     * 
     * @param filePath
     *            the file path
     * @param pageNumberRange
     *            the page number range
     * @param verifyType
     *            the verify type
     * @param inputString
     *            the input string
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    private void pdfVerify(final String filePath, final String pageNumberRange,
            final String verifyType, final String inputString,
            final boolean stopOnFaliure, final Object[] customError) {

        boolean isPresent = false;
        try {
            if ("RELATIVE".equalsIgnoreCase(verifyType)) {

                isPresent = relativePdf(filePath, pageNumberRange, inputString);
            } else if ("EXISTS".equalsIgnoreCase(verifyType)) {

                isPresent = existsPdf(filePath, pageNumberRange, inputString);
            } else {

                reportresult(true, "CHECK DOCUMENT - PDF [" + verifyType
                        + "] :", "FAILED", "Unknown verify type passed :" + " "
                        + verifyType + ". Accepted verify types : "
                        + "EXIST, RELATIVE");
                checkTrue(false, stopOnFaliure, "Unknown verify type passed :"
                        + " " + verifyType + ". Accepted verify types : "
                        + "EXISTS , RELATIVE");
            }

            if (isPresent) {
                reportresult(true, "CHECK DOCUMENT - PDF [" + verifyType
                        + "] :", "PASSED",
                        "CheckDocument command: Verified text as expected. Expected Value : "
                                + inputString);
            } else {

                reportresult(
                        true,
                        "CHECK DOCUMENT - PDF [" + verifyType + "] :",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : "
                                + "CheckDocument command: Verified text as not expected. Expected Value : "
                                + inputString);
                checkTrue(
                        false,
                        stopOnFaliure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : "
                                + "CheckDocument command: Verified text as not expected. Expected Value : "
                                + inputString);

            }
        } catch (FileNotFoundException e) {

            reportresult(
                    true,
                    "CHECK DOCUMENT - PDF [" + verifyType + "] :",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : "
                            + "CheckDocument command: File not found in the given location. "
                            + inputString);
            checkTrue(
                    false,
                    stopOnFaliure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : "
                            + "CheckDocument command: File not found in the given location. "
                            + inputString + e.getMessage());

        } catch (NumberFormatException e) {

            reportresult(true, "CHECK DOCUMENT - PDF [" + verifyType + "] :",
                    "FAILED",
                    "CheckDocument command: Invalid argument for page range : "
                            + pageNumberRange);
            checkTrue(false, stopOnFaliure,
                    " CheckDocument command: Invalid argument for page range : "
                            + pageNumberRange + e.getMessage());

        } catch (Exception e) {

            reportresult(
                    true,
                    "CHECK DOCUMENT - PDF [" + verifyType + "] :",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : "
                            + "CheckDocument command: Text Verification failed: "
                            + inputString);
            checkTrue(false, stopOnFaliure, ""
                    + generateCustomError(customError)
                    + " System generated Error : "
                    + "CheckDocument command: Text Verification failed: "
                    + inputString + e.getMessage());

        }
    }

    /**
     * Read pdf.
     * 
     * @param filePath
     *            the file path
     * @param pageNumberRange
     *            the page number range
     * @return the string builder
     * @throws Exception
     *             the exception
     */
    private StringBuilder readPdf(final String filePath,
            final String pageNumberRange) throws Exception {

        String pageText;

        String[] pageSeperate = pageNumberRange.split("\\-");
        int startPage = Integer.parseInt(pageSeperate[0]);
        int endPage = Integer.parseInt(pageSeperate[1]);

        File file = new File(filePath);
        PDDocument pdfDoc = PDDocument.load(file);

        PDFTextStripper reader = new PDFTextStripper();
        reader.setStartPage(startPage);
        reader.setEndPage(endPage);
        reader.setSuppressDuplicateOverlappingText(false);
        pageText = reader.getText(pdfDoc);

        BufferedReader br = new BufferedReader(new StringReader(pageText));

        String tmp = "";
        StringBuilder entireString = new StringBuilder();
        while ((tmp = br.readLine()) != null) {
            entireString.append(tmp.trim() + "\n");
        }
        return entireString;

    }

    /**
     * Relative pdf.
     * 
     * @param filePath
     *            the file path
     * @param pageNumberRange
     *            the page number range
     * @param inputString
     *            the input string
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    private boolean relativePdf(final String filePath,
            final String pageNumberRange, final String inputString)
            throws Exception {

        boolean isPresent = false;
        String[] inputStringSeperate = inputString.split("\\|");
        String key = inputStringSeperate[0];
        String value = inputStringSeperate[1];
        String tmp = "";
        StringBuilder entireString = readPdf(filePath, pageNumberRange);
        BufferedReader br =
                new BufferedReader(new StringReader(entireString.toString()));
        while ((tmp = br.readLine()) != null) {

            if (tmp.equals(key)) {
                String val = br.readLine();
                if (val != null && val.equals(value)) {
                    isPresent = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        if (entireString.toString().contains(key)) {

            int index = entireString.indexOf(key);
            String subEntire = entireString.toString().substring(index);
            String newString = subEntire.replace(key, "");
            if (newString.trim().startsWith(value)) {
                isPresent = true;
            }

        }

        return isPresent;

    }

    /**
     * Exists pdf.
     * 
     * @param filePath
     *            the file path
     * @param pageNumberRange
     *            the page number range
     * @param inputString
     *            the input string
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    private boolean existsPdf(final String filePath,
            final String pageNumberRange, final String inputString)
            throws Exception {

        StringBuilder entireString = readPdf(filePath, pageNumberRange);
        return entireString.toString().contains(inputString);

    }

    /**
     * Check document.
     * 
     * @param docType
     *            the doc type
     * @param filePath
     *            the file path
     * @param pageNumberRange
     *            the page number range
     * @param verifyType
     *            the verify type
     * @param inputString
     *            the input string
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    public final void checkDocument(final String docType,
            final String filePath, final String pageNumberRange,
            final String verifyType, final String inputString,
            final boolean stopOnFaliure, final Object... customError) {

        String path = parentMethod(filePath);

        if ("pdf".equalsIgnoreCase(docType)) {
            pdfVerify(path, pageNumberRange, verifyType, inputString,
                    stopOnFaliure, customError);
        } else if ("excel".equalsIgnoreCase(docType)) {
            verifyExcel(path, pageNumberRange, verifyType, inputString,
                    stopOnFaliure, customError);

        } else if ("xml".equalsIgnoreCase(docType)) {

            xmlVerify(path, verifyType, inputString, stopOnFaliure);
        } else if ("text".equalsIgnoreCase(docType)) {

            textFileVerify(path, verifyType, inputString, stopOnFaliure);
        } else if ("doc".equalsIgnoreCase(docType)) {

            docFileVerify(path, verifyType, inputString, stopOnFaliure);
        } else {
            reportresult(true, "CHECK DOCUMENT :" + docType + " :", "FAILED",
                    "Unknown doc type passed :" + " " + docType
                            + ". Accepted doc types : "
                            + "pdf, excel, xml, text");
            checkTrue(false, stopOnFaliure, "Unknown doc type passed :" + " "
                    + docType + ". Accepted doc types : " + "pdf");
        }

    }

    /**
     * Doc file verify.
     *
     * @param filePath
     *            the file path
     * @param verifyType
     *            the verify type
     * @param inputString
     *            the input string
     * @param stopOnFaliure
     *            the stop on faliure
     */
    private void docFileVerify(final String filePath, final String verifyType,
            final String inputString, final boolean stopOnFaliure) {

        if ("EXISTS".equalsIgnoreCase(verifyType)) {
            String docContentToValidate =
                    readDocFile(filePath).toLowerCase(Locale.ENGLISH);
            // boolean objectFound = false;
            String[] inputStringSeperate = inputString.split("\\|");
            String expectedValue = inputStringSeperate[0];

            if (inputString.startsWith("regexp:")) {
                boolean objectFound =
                        isMatchingRegex(
                                (inputString.substring(
                                        inputString.indexOf(':') + 1,
                                        inputString.length()))
                                        .toLowerCase(Locale.ENGLISH),
                                docContentToValidate);
                if (objectFound) {
                    reportresult(true, "CHECK DOCUMENT :", "PASSED",
                            "CheckDocument command TEXT : MS DOC : Verified value as expected. "
                                    + "Expected regex value : " + expectedValue);
                } else {
                    reportresult(
                            true,
                            "CHECK DOCUMENT :",
                            "FAILED",
                            "CheckDocument command TEXTCONTENT : Excpected value cannot be found in the file. "
                                    + "Expected regex value : " + expectedValue);
                    checkTrue(
                            false,
                            stopOnFaliure,
                            "CheckDocument command TEXTCONTENT : Excpected value cannot be found in the file. "
                                    + "Expected regex value : " + expectedValue);
                }

            } else {

                try {

                    if (docContentToValidate.contains(expectedValue
                            .toLowerCase(Locale.ENGLISH))) {
                        reportresult(true, "CHECK DOCUMENT :", "PASSED",
                                "CheckDocument command TEXT : MS DOC : Verified value as expected. "
                                        + "Expected value : " + expectedValue);
                    } else {
                        reportresult(
                                true,
                                "CHECK DOCUMENT :",
                                "FAILED",
                                "CheckDocument command TEXTCONTENT : Excpected value cannot be found in the file. "
                                        + "Expected value : " + expectedValue);
                        checkTrue(
                                false,
                                stopOnFaliure,
                                "CheckDocument command TEXTCONTENT : Excpected value cannot be found in the file. "
                                        + "Expected value : " + expectedValue);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    reportresult(true, "CHECK DOCUMENT :", "FAILED",
                            "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                    + e.getMessage());
                    checkTrue(false, stopOnFaliure,
                            "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                    + e.getMessage());
                }
            }

        }
    }

    /**
     * Read doc file.
     *
     * @param fileName
     *            the file name
     * @return the string
     */
    public final String readDocFile(final String fileName) {
        String docContent = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor we = new WordExtractor(doc);

            docContent = we.getText();
            System.out.println("MS Word(.doc) Document Red, Content:"
                    + docContent);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            reportresult(true, "CHECK DOCUMENT :", "FAILED",
                    "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                            + e.getMessage());
            checkTrue(false, false,
                    "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                            + e.getMessage());
        }
        return docContent;

    }

    /**
     * Parent method.
     *
     * @param fullPath
     *            the full path
     * @return the string
     */
    private String parentMethod(final String fullPath) {

        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] splittedFileName = fullPath.split(pattern);
        String path = splittedFileName[0];
        String fileName = "";
        for (int i = 1; i < splittedFileName.length; i++) {
            if (i == splittedFileName.length - 1) {
                fileName = splittedFileName[i];
                if (fileName.startsWith("regexp:")) {
                    path = fileNameCreater(path, fileName);
                } else {
                    path = path + File.separator + fileName;
                }
            } else if (splittedFileName[i].startsWith("regexp:")) {
                path =
                        path + File.separator
                                + pathCreater(path, splittedFileName[i]);
            } else {
                path = path + File.separator + splittedFileName[i];
            }

        }
        System.out.println(path);
        return path;

    }

    /**
     * Path creater.
     *
     * @param parentPath
     *            the parent path
     * @param nextpath
     *            the nextpath
     * @return the string
     */
    private String pathCreater(final String parentPath, final String nextpath) {
        File checkFile = new File(parentPath + File.separator + nextpath);
        String returnPath = checkFile.getPath();
        File folder = new File(parentPath + File.separator);

        boolean objectFound = false;
        File[] listOfFiles = folder.listFiles();

        if (nextpath.startsWith("regexp:")) {
            for (File actualOption : listOfFiles) {
                /*if (actualOption.isFile()) {
                    // System.out.println("File " + actualOption.getName());

                    objectFound =
                            isMatchingPattern(nextpath.substring(
                                    nextpath.indexOf(':') + 1,
                                    nextpath.length()), actualOption.getName());
                } else*/
                if (actualOption.isDirectory()) {
                    System.out.println("Directory " + actualOption.getName());
                    objectFound =
                            isMatchingPattern(nextpath.substring(
                                    nextpath.indexOf(':') + 1,
                                    nextpath.length()), actualOption.getName());
                }
                if (objectFound) {
                    // targetWindow = windowname;
                    returnPath = actualOption.getName();
                    break;
                }
            }
        }

        return returnPath;
    }

    /**
     * File name creater.
     *
     * @param parentPath
     *            the parent path
     * @param nextpath
     *            the nextpath
     * @return the string
     */
    private String fileNameCreater(final String parentPath,
            final String nextpath) {
        File checkFile = new File(parentPath + File.separator + nextpath);
        String returnPath = checkFile.getPath();
        File folder = new File(parentPath);

        boolean objectFound = false;
        File[] listOfFiles = folder.listFiles();

        if (nextpath.startsWith("regexp:")) {
            for (File actualOption : listOfFiles) {
                if (actualOption.isFile()) {

                    objectFound =
                            isMatchingPattern(nextpath.substring(
                                    nextpath.indexOf(':') + 1,
                                    nextpath.length()), actualOption.getName());
                }
                if (objectFound) {
                    returnPath = actualOption.getAbsolutePath();
                    break;
                }
            }
        }

        return returnPath;
    }

    /**
     * Check element present.
     * 
     * @param objectName
     *            the object name
     * @param identifire
     *            the identifire
     * @return true, if successful
     */
    public final boolean checkElementPresent(final String objectName,
            final String identifire) {

        locatorIdentifire = identifire;

        return checkElementPresent(objectName);

    }

    /** The Constant CHAR_LIST. */
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";

    /**
     * This method generates random string.
     * 
     * @param length
     *            set to length
     * @return String
     * 
     */
    private String generateRandomString(final int length) {

        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // int number = getRandomNumber();
            Random randomGenerator = new Random(System.nanoTime());
            int number = randomGenerator.nextInt(CHAR_LIST.length());
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * This method generates random numbers.
     * 
     * @return int
     */
    private long getRandomNumber() {
        long randomInt;
        // int range = (int)System.nanoTime();
        // Random randomGenerator = new Random(System.nanoTime());

        randomInt = System.nanoTime();
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    /**
     * Gets the date.
     * 
     * @param format
     *            the format
     * @param skipWeekend
     *            the skip weekend
     * @param day
     *            the day
     * @return the date
     */
    private String getDate(final String format, final boolean skipWeekend,
            final int day) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;

        if (skipWeekend) {
            final int five = 5;
            final int two = 2;
            final int seven = 7;
            int days = day;
            days = ((days / five) * two) + days;
            date = DateUtils.addDays(Calendar.getInstance().getTime(), days);
            Calendar myCal = new GregorianCalendar();
            myCal.setTime(date);
            if (myCal.get(Calendar.DAY_OF_WEEK) == seven) {
                date = DateUtils.addDays(date, 2);
            } else if (myCal.get(Calendar.DAY_OF_WEEK) == 1) {
                date = DateUtils.addDays(date, 1);
            }
        } else {
            date = DateUtils.addDays(Calendar.getInstance().getTime(), day);
        }
        return dateFormat.format(date);

    }

    /**
     * This method generates random string.
     * 
     * @param dataType
     *            set to dataType
     * @param reqLength
     *            set to length
     * @return String
     * 
     */

    public final String generateData(final String dataType, final int reqLength) {

        String random = "";
        String split = "";

        if ("String".equalsIgnoreCase(dataType)) {
            random = this.generateRandomString(reqLength);
        } else if ("int".equalsIgnoreCase(dataType)) {
            if (reqLength <= 0) {
                throw new IllegalArgumentException(
                        "Can not use minus values as length. Current: "
                                + reqLength);
            }
            split = String.valueOf(this.getRandomNumber());
            int splitLength = split.length();
            random = split.substring(splitLength - reqLength, splitLength);
        } else if ("Alphanumeric".equalsIgnoreCase(dataType)) {
            if (reqLength <= 0) {
                throw new IllegalArgumentException(
                        "Can not use minus values as length. Current: "
                                + reqLength);
            }
            split = String.valueOf(this.getRandomNumber());
            int splitLength = split.length();
            random =
                    this.generateRandomString(reqLength - 1)
                            + split.substring(splitLength - 1, splitLength);
        } else if (dataType.toLowerCase(Locale.getDefault()).startsWith("date")) {
            String format = "yyyy/MM/dd";
            boolean skipWeekend = false;
            String[] params = dataType.split("\\|");
            if (params.length > 2) {
                format = dataType.split("\\|")[1];
                skipWeekend = Boolean.parseBoolean(dataType.split("\\|")[2]);

            } else if (params.length > 1) {
                format = dataType.split("\\|")[1];
            }

            random = getDate(format, skipWeekend, reqLength);

        }
        return random;
    }

    /**
     * Right clicks on an web element.
     * 
     * @param objectName
     *            : Logical name of the object to be doubleclicked.
     */

    public final void rightClick(final String objectName) {
        rightClick(objectName, "");
    }

    /**
     * Right click.
     * 
     * @param objectName
     *            the object name
     * @param identifier
     *            the identifier
     */
    public final void rightClick(final String objectName,
            final String identifier) {
        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doRightClick(locator);
    }

    /**
     * Right clicks on an web element.
     * 
     * @param locator
     *            the locator
     */

    public final void doRightClick(final ObjectLocator locator) {
        // Retrieve the actual object name from the object repository
        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        int counter = getRetryCount();
        try {
            // First chacking whether the element is present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);

            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    counter--;

                    Actions rClick = new Actions(getDriver());
                    rClick.moveToElement(element).contextClick(element);
                    rClick.build().perform();
                    /* selenium.doubleClick(objectID); */
                    reportresult(true, "RIGHT CLICK :" + objectName + "",
                            "PASSED", "Right Clicked on Element [" + objectName
                                    + "] with Locator : [" + objectID + "] ");
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    if (!(counter > 0)) {

                        e.printStackTrace();
                        reportresult(true, "RIGHT CLICK :" + objectName + "",
                                "FAILED",
                                "RIGHT CLICK command cannot access Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                        checkTrue(false, true,
                                "RIGHT CLICK command cannot access Element ("
                                        + objectName + ") with Locator : ["
                                        + objectID + "] ");
                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            // if object not found exception is raised fail the test cases
            e.printStackTrace();
            reportresult(true, "RIGHT CLICK :" + objectName + "", "FAILED",
                    "RIGHT CLICK command  :Element (" + objectName
                            + ") with Locator : [" + objectID + "] not present");
            checkTrue(false, true, "RIGHT CLICK command  :Element ("
                    + objectName + ") with Locator : [" + objectID
                    + "] not present");
        }

    }

    /**
     * Check file info.
     * 
     * @param fileName
     *            the file name
     * @param verificationType
     *            the verification type
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkFileInfo(final String fileName,
            final String verificationType, final boolean stopOnFailure,
            final Object... customError) {
        // String customErrorMessage = "";

        try {
            String root;
            String filenameInfo;

            String fileNameOne = fileName;

            if (fileName.contains("/")) {
                fileNameOne = fileNameOne.replace("/", "\\");
                // System.out.println(fileName);
                filenameInfo =
                        fileNameOne.substring(
                                fileNameOne.lastIndexOf(File.separator) + 1,
                                fileNameOne.length());
                root =
                        fileNameOne.substring(0,
                                fileNameOne.lastIndexOf(File.separator));
            } else {
                filenameInfo =
                        fileNameOne.substring(
                                fileNameOne.lastIndexOf(File.separator) + 1,
                                fileNameOne.length());
                root =
                        fileNameOne.substring(0,
                                fileNameOne.lastIndexOf(File.separator));
            }

            File fileRoot = new File(root);

            if (fileRoot.isDirectory()) {

                if ("EXIST".equals(verificationType)) {
                    byExist(filenameInfo, stopOnFailure, root, customError); // root,
                    // fileName
                    // with
                    // extension,root
                } else {

                    reportresult(true, "CHECK FILE INFORMATION :"
                            + verificationType + " :", "FAILED",
                            "Unknown validation type passed :" + " "
                                    + verificationType
                                    + ". Accepted validation types : "
                                    + "EXIST");
                    checkTrue(false, stopOnFailure,
                            "Unknown validation type passed :" + " "
                                    + verificationType
                                    + ". Accepted validation types : "
                                    + "EXIST");
                }

            } else {
                System.out.println("File root path does not exist");

                reportresult(true, "CHECK FILE INFORMATION :" + root + "",
                        "FAILED", "" + generateCustomError(customError)
                                + " System generated Error : File root path :"
                                + root + " does not exist");
                checkTrue(false, stopOnFailure, ""
                        + generateCustomError(customError)
                        + " System generated Error : File root path :" + root
                        + " does not exist");

            }
        } catch (IndexOutOfBoundsException iob) {
            iob.printStackTrace();
            reportresult(true, "CHECK FILE INFORMATION : EXIST", "FAILED",
                    "File root path does not exist");
            checkTrue(false, stopOnFailure, "File root path does not exist");

        } catch (Exception e) {
            e.printStackTrace();

            reportresult(true, "CHECK FILE INFORMATION : EXIST", "FAILED",
                    "File root path does not exist");
            checkTrue(false, stopOnFailure, "File root path does not exist");
        }

    }

    /**
     * By exist.
     * 
     * @param filename
     *            the filename
     * @param stopOnFailure
     *            the stop on failure
     * @param root
     *            the root
     * @param customError
     *            the custom error
     */
    private void byExist(final String filename, final boolean stopOnFailure,
            final String root, final Object[] customError) {

        /*
         * String checkFextn = filename.substring(filename.lastIndexOf('.') + 1,
         * filename.length()); String checkFName = filename.substring(0,
         * filename.lastIndexOf('.'));
         */

        try {
            List<String> fileNameListWithEx = new ArrayList<String>();

            File[] files = new File(root).listFiles();
            if (files != null) {
                for (File file : files) {

                    if (file.isFile()) {
                        fileNameListWithEx.add(file.getName());
                    }
                } // end add file in to list
            }

            StringBuilder errors = new StringBuilder();
            boolean isConditionMatched = false;

            for (int i = 0; i < fileNameListWithEx.size(); i++) {
                String fname = fileNameListWithEx.get(i);

                Pattern pattern =
                        Pattern.compile(filename, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(fname);

                // Pattern pattern = Pattern.compile(filename);

                if (matcher.matches()) {
                    // System.out.println("Exist");
                    // System.out.println(fname);
                    isConditionMatched = true;

                    reportresult(true, "CHECK FILE INFORMATION : EXIST",
                            "PASSED",
                            "CHECK FILE INFORMATION command : Passed. " + fname
                                    + " is exists.");
                    break;

                } else {

                    isConditionMatched = false;

                }
            }
            // end for loop for read list

            if (!isConditionMatched) {

                String errorsMessages = errors.toString();
                System.out.println(errorsMessages + " does not exist.");

                reportresult(true, "CHECK FILE INFORMATION : EXIST ", "FAILED",
                        "" + generateCustomError(customError)
                                + " System generated Error : File " + filename
                                + " does not exist.");
                checkTrue(false, stopOnFailure, ""
                        + generateCustomError(customError)
                        + " System generated Error : File " + filename
                        + " does not exist.");

            }

        } catch (PatternSyntaxException e) {
            e.printStackTrace();
            reportresult(true, "CHECK FILE INFORMATION : EXIST", "FAILED",
                    "Pattern syntax is incorrect.\n" + e.getMessage());
            checkTrue(false, stopOnFailure, "Pattern syntax is incorrect.\n "
                    + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            reportresult(true, "CHECK FILE INFORMATION : EXIST", "FAILED",
                    "File " + filename + " in " + root + "  cannot access.\n"
                            + e.getMessage());
            checkTrue(false, stopOnFailure, "File " + filename + " in " + root
                    + " cannot access.\n " + e.getMessage());

        }
    } // end byExist

    /**
     * Generate custom error.
     * 
     * @param customError
     *            the custom error
     * @return the string
     */
    private String generateCustomError(final Object[] customError) {
        String customErrorMessage = "";

        if (customError != null
                && !(customError[0].equals("null") || customError[0].equals(""))) {

            /* if (customError != null && customError.length > 0) { */

            /*
             * for (int i = 0; i < customError.length; i++) { customErrorMessage
             * = customErrorMessage + customError[i].toString() + ". "; }
             */
            customErrorMessage =
                    " Custom Error : " + customError[0].toString() + ". ";
        }
        return customErrorMessage;
    }

    /**
     * checkSorting command.
     * 
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkSorting(final String objectName, final String type,
            final String pattern, final String order,
            final boolean stopOnFailure, final Object... customError) {
        checkSorting(objectName, "", type, pattern, order, stopOnFailure,
                customError);
    }

    /**
     * Check sorting.
     * 
     * @param objectName
     *            the object name
     * @param identifier
     *            the identifier
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkSorting(final String objectName,
            final String identifier, final String type, final String pattern,
            final String order, final boolean stopOnFailure,
            final Object... customError) {
        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        doCheckSorting(locator, type, pattern, order, stopOnFailure,
                customError);
    }

    /**
     * Do check sorting.
     * 
     * @param locator
     *            the locator
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     * @return the int
     */
    private int doCheckSorting(final ObjectLocator locator, final String type,
            final String pattern, final String order,
            final boolean stopOnFailure, final Object[] customError) {
        int counter = getRetryCount();
        int objectCount = 0;
        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        WebDriver driver = getDriver();

        ArrayList<String> list = new ArrayList<String>();
        try {

            while (counter > 0) {
                try {
                    counter--;

                    List<WebElement> elements =
                            driver.findElements(getLocatorType(objectID));
                    objectCount = elements.size();

                    for (int i = 0; i < elements.size(); i++) {
                        list.add(i, elements.get(i).getText());
                        // System.out.println(list.get(i));
                        // System.out.println(list.size());
                    }

                    sort(list, objectName, type, pattern, order, stopOnFailure,
                            customError);

                    break;
                } catch (Exception e) {
                    sleep(retryInterval);

                    if (!(counter > 0)) {
                        e.printStackTrace();

                        reportresult(true, "CHECK SORTING :" + objectName + "",
                                "FAILED",
                                "CHECK SORTING command cannot access   :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");
                        checkTrue(false, stopOnFailure,
                                "CHECK SORTING command cannot access   :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID + " not present");

                    }
                }
            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {
            // waiting for the maximum amount of waiting time before failing the
            // test case
            // Several checks were introduced to narrow down to the failure to
            // the exact cause.
            if (!(counter > 0)) {
                e.printStackTrace();

                reportresult(true, "CHECK SORTING :" + objectName + "",
                        "FAILED", "CHECK SORTING command   :Element [ "
                                + objectName + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, stopOnFailure,
                        "CHECK SORTING command   :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " not present");

            } else if ("Element".equalsIgnoreCase(e.getMessage())) {
                e.printStackTrace();

                reportresult(true, "CHECK SORTING :" + objectName + "",
                        "FAILED", "CHECK SORTING command   :Element [ "
                                + objectName + " ] with Locator : " + objectID
                                + " not present");
                checkTrue(false, stopOnFailure,
                        "CHECK SORTING command   :Element [ " + objectName
                                + " ] with Locator : " + objectID
                                + " not present");

            }

        }
        return objectCount;
    }

    // sort string alphabetically
    /**
     * Sort string alphabetically.
     * 
     * @param l
     *            the l
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortStringAlphabetically(final ArrayList<String> l,
            final String objectName, final String type, final String pattern,
            final String order, final boolean stopOnFailure,
            final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            // System.out.println(l.get(i));
            listOrg.add(l.get(i));
        }

        if ("ascending".equals(order)) {
            Collections.sort(l, String.CASE_INSENSITIVE_ORDER);
            // System.out.println("Ordered list"+l);

            if (l.equals(listOrg)) {
                // System.out.println("In ascending Order alphabetically" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command : Element " + objectName
                                + " sorted in Type : " + type + ", Pattern : "
                                + pattern + ", Order : " + order);

            } else {
                // System.out.println("Not in ascending Order alphabetically"

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else if ("descending".equals(order)) {

            // Collections.sort(l, ALPHA_ORDER);
            Collections.sort(l, String.CASE_INSENSITIVE_ORDER);

            // System.out.println("Ordered list"+l);
            List<String> listDes = new ArrayList<String>();
            for (int i = l.size() - 1; i >= 0; i--) {
                // System.out.println(l.get(i).toString());
                // String s = (String) l.get( i ) ;
                listDes.add(l.get(i));
            }

            // System.out.println("Ordered list"+listDes);
            if (listDes.equals(listOrg)) {
                // System.out.println("In descending Order alphabetically"
                // );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command : Element " + objectName
                                + " sorted in Type : " + type + ", Pattern : "
                                + pattern + ", Order : " + order);

            } else {
                // System.out.println("Not in descending Order alphabetically"

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
        }

    }

    // sort String 1Aa

    /**
     * Sort string1 aa.
     * 
     * @param l
     *            the l
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortString1Aa(final List<String> l, final String objectName,
            final String type, final String pattern, final String order,
            final boolean stopOnFailure, final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            // System.out.println(l.get(i));
            listOrg.add(l.get(i));
        }

        if ("ascending".equals(order)) {
            DiffSort diffSort = new DiffSort();
            Collections.sort(l, diffSort.getDiffNaturalOrder1Aa());
            // Collections.sort(l);

            // System.out.println("Ordered list"+l);
            if (l.equals(listOrg)) {
                // System.out.println("In Ascending Order 1Aa" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command : Element " + objectName
                                + " sorted in Type : " + type + ", Pattern : "
                                + pattern + ", Order : " + order);

            } else {
                // System.out.println("Not in Ascending Order 1Aa" );

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else if ("descending".equals(order)) {
            DiffSort diffSort = new DiffSort();
            Collections.sort(l, diffSort.getDiffNaturalOrder1Aa());

            List<String> listDes = new ArrayList<String>();
            for (int i = l.size() - 1; i >= 0; i--) {

                listDes.add(l.get(i));
            }

            if (listDes.equals(listOrg)) {

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command order descending : Element "
                                + objectName + " sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            } else {

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command order descending : Element ("
                            + order + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command order descending : Element ("
                            + order + ") not match");
        }

    }

    // ////////////////////////////////////////////

    /**
     * Sort string aa1.
     * 
     * @param l
     *            the l
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortStringAa1(final List<String> l, final String objectName,
            final String type, final String pattern, final String order,
            final boolean stopOnFailure, final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < l.size(); i++) {
            // System.out.println(l.get(i));
            listOrg.add(l.get(i));
        }

        if ("ascending".equals(order)) {
            DiffSort diffSort = new DiffSort();
            Collections.sort(l, diffSort.getDiffNaturalOrderAa1());

            // System.out.println("Ordered list"+l);
            if (l.equals(listOrg)) {
                // System.out.println("In Ascending Order Aa1" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command : Element " + objectName
                                + " sorted in Type : " + type + ", Pattern : "
                                + pattern + ", Order : " + order);

            } else {
                // System.out.println("Not in Ascending Order Aa1" );

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else if ("descending".equals(order)) {
            DiffSort diffSort = new DiffSort();
            Collections.sort(l, diffSort.getDiffNaturalOrderAa1());

            List<String> listDes = new ArrayList<String>();
            for (int i = l.size() - 1; i >= 0; i--) {
                // System.out.println(l.get(i).toString());
                // String s = (String) l.get( i ) ;
                listDes.add(l.get(i));
            }

            // System.out.println("Ordered list"+listDes);
            if (listDes.equals(listOrg)) {
                // System.out.println("In Descending Order Aa1" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command order descending : Element "
                                + objectName + " sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            } else {
                // System.out.println("Not in Descending Order Aa1" );

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command order descending  : Element ("
                            + order + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command order descending : Element ("
                            + order + ") not match");
        }

    }

    // //////////////////////////////////////

    /**
     * Sort stringa a1.
     * 
     * @param l
     *            the l
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortStringaA1(final ArrayList<String> l,
            final String objectName, final String type, final String pattern,
            final String order, final boolean stopOnFailure,
            final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        // diffSort = new DiffSort();
        for (int i = 0; i < l.size(); i++) {
            // System.out.println(l.get(i));
            listOrg.add(l.get(i));
        }

        if ("ascending".equals(order)) {

            Collections.sort(l, DiffSort.DIFFNATURALORDERA1);

            // System.out.println("Ordered list"+l);
            if (l.equals(listOrg)) {
                // System.out.println("In Ascending Order aA1" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command : Element " + objectName
                                + " sorted in Type : " + type + ", Pattern : "
                                + pattern + ", Order : " + order);

            } else {
                // System.out.println("Not in Ascending Order aA1" );

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }

        } else if ("descending".equals(order)) {
            // DiffSort diffSort = new DiffSort();
            Collections.sort(l, DiffSort.DIFFNATURALORDERA1);

            List<String> listDes = new ArrayList<String>();
            for (int i = l.size() - 1; i >= 0; i--) {
                // System.out.println(l.get(i).toString());
                // String s = (String) l.get( i ) ;
                listDes.add(l.get(i));
            }

            // System.out.println("Ordered list"+listDes);
            if (listDes.equals(listOrg)) {
                // System.out.println("In Descending Order aA1" );

                reportresult(true, "CHECK SORTING :", "PASSED",
                        "Check sorting command order descending: Element "
                                + objectName + " sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            } else {
                // System.out.println("Not in Descending Order aA1" );

                reportresult(
                        true,
                        "CHECK SORTING :" + objectName + "",
                        "FAILED",
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);
                checkTrue(
                        false,
                        stopOnFailure,
                        ""
                                + generateCustomError(customError)
                                + " System generated Error : CHECK SORTING command order descending  : Element ("
                                + objectName + ") not sorted in Type : " + type
                                + ", Pattern : " + pattern + ", Order : "
                                + order);

            }
        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  order descending : Element ("
                            + order + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  order descending: Element ("
                            + order + ") not match");
        }

    }

    /**
     * Sort string.
     * 
     * @param sortList
     *            the sort List
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortString(final ArrayList<String> sortList,
            final String objectName, final String type, final String pattern,
            final String order, final boolean stopOnFailure,
            final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < sortList.size(); i++) {
            // System.out.println(l.get(i));

            if ("".equals(sortList.get(i))) {
                sortList.set(i, " ");
            }
            listOrg.add(sortList.get(i));
        }

        if ("alphabetically".equals(pattern)) {
            sortStringAlphabetically(sortList, objectName, type, pattern,
                    order, stopOnFailure, customError);
        } else if ("1Aa".equals(pattern)) {
            sortString1Aa(sortList, objectName, type, pattern, order,
                    stopOnFailure, customError);
        } else if ("Aa1".equals(pattern)) {
            sortStringAa1(sortList, objectName, type, pattern, order,
                    stopOnFailure, customError);
        } else if ("aA1".equals(pattern)) {
            sortStringaA1(sortList, objectName, type, pattern, order,
                    stopOnFailure, customError);
        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Element (" + pattern
                            + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Element (" + pattern
                            + ") not match");
        }

    }

    /**
     * Sort numeric.
     * 
     * @param nuberList
     *            the nuber list
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortNumeric(final List<String> nuberList,
            final String objectName, final String type, final String order,
            final boolean stopOnFailure, final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < nuberList.size(); i++) {
            // System.out.println(l.get(i));

            if (" ".equals(nuberList.get(i))) {
                nuberList.set(i, "-999999999999999999999999999999");
            }
            listOrg.add(nuberList.get(i));
        }

        List<Double> doubleListOrg = new ArrayList<Double>();
        List<Double> doubleListTemp = new ArrayList<Double>();
        try {
            for (int i = 0; i < nuberList.size(); i++) {
                String temp = nuberList.get(i).replace(",", "");
                temp = temp.replace("Rs", "");
                temp = temp.replace("$", "");

                double value = Double.parseDouble(temp);
                doubleListOrg.add(value);
                doubleListTemp.add(value);

            }
        } catch (NumberFormatException e) {
            // e.printStackTrace();
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Cannot convert " + type
                            + " to a number.");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Cannot convert " + type
                            + " to a number.");
        } catch (Exception e) {
            // e.printStackTrace();
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Element (" + type + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Element (" + type + ") not match");
        }

        // System.out.println(DoublelistOrg);

        if ("ascending".equals(order)) {
            Collections.sort(doubleListTemp);

            sortNumericAscending(doubleListTemp, doubleListOrg, objectName,
                    type, order, stopOnFailure, customError);

        } else if ("descending".equals(order)) {
            Collections.sort(doubleListTemp);
            Collections.reverse(doubleListTemp);

            sortNumericDescending(doubleListTemp, doubleListOrg, objectName,
                    type, order, stopOnFailure, customError);

        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
        }

    }

    /**
     * Sort numeric ascending.
     * 
     * @param doubleListTemp
     *            the doublelist temp
     * @param doubleListOrg
     *            the doublelist org
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortNumericAscending(final List<Double> doubleListTemp,
            final List<Double> doubleListOrg, final String objectName,
            final String type, final String order, final boolean stopOnFailure,
            final Object[] customError) {

        if (doubleListTemp.equals(doubleListOrg)) {
            // System.out.println("ascending");
            reportresult(true, "CHECK SORTING :", "PASSED",
                    "Check sorting command : Element " + objectName
                            + " sorted in Type : " + type + ", Order : "
                            + order);
        } else {
            // System.out.println("Not ascending");

            reportresult(
                    true,
                    "CHECK SORTING :" + objectName + "",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);

        }

    }

    /**
     * Sort numeric descending.
     * 
     * @param doubleListTemp
     *            the doublelist temp
     * @param doubleListOrg
     *            the doublelist org
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortNumericDescending(final List<Double> doubleListTemp,
            final List<Double> doubleListOrg, final String objectName,
            final String type, final String order, final boolean stopOnFailure,
            final Object[] customError) {
        if (doubleListTemp.equals(doubleListOrg)) {
            // System.out.println("descending");
            reportresult(true, "CHECK SORTING :", "PASSED",
                    "Check sorting command : Element " + objectName
                            + " sorted in Type : " + type + ", Order : "
                            + order);
        } else {
            // System.out.println("Not descending");

            reportresult(
                    true,
                    "CHECK SORTING :" + objectName + "",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);

        }
    }

    /**
     * Sort date.
     * 
     * @param sortList
     *            the sort List
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortDate(final List<String> sortList, final String objectName,
            final String type, final String pattern, final String order,
            final boolean stopOnFailure, final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < sortList.size(); i++) {
            // System.out.println(l.get(i));

            if (" ".equals(sortList.get(i))) {
                sortList.set(i, "00/00/0000");
            }
            listOrg.add(sortList.get(i));

        }

        List<Date> datelistOrg = new ArrayList<Date>();
        List<Date> datelistTemp = new ArrayList<Date>();

        for (int i = 0; i < sortList.size(); i++) {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            String tempDate = sortList.get(i);
            // System.out.println(l.get(i));
            try {
                Date date = formatter.parse(tempDate);
                datelistOrg.add(date);
                datelistTemp.add(date);
            } catch (Exception e) {
                // e.printStackTrace();
                reportresult(true, "CHECK SORTING :" + objectName + "",
                        "FAILED", "CHECK SORTING command  : Element (" + type
                                + ") not match");
                checkTrue(false, stopOnFailure,
                        "CHECK SORTING command  : Element (" + type
                                + ") not match");
            } // System.out.println(date);
              // System.out.println(formatter.format(date));

        }

        // System.out.println( datelistOrg);

        if ("ascending".equals(order)) {
            Collections.sort(datelistTemp);
            sortDateAscending(datelistTemp, datelistOrg, objectName, type,
                    order, stopOnFailure, customError);

        } else if ("descending".equals(order)) {
            Collections.sort(datelistTemp);
            Collections.reverse(datelistTemp);
            sortDateDescending(datelistTemp, datelistOrg, objectName, type,
                    order, stopOnFailure, customError);

        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
            checkTrue(false, stopOnFailure,
                    "CHECK SORTING command  : Element (" + order
                            + ") not match");
        }

    }

    /**
     * Sort date descending.
     * 
     * @param datelistTemp
     *            the datelist temp
     * @param datelistOrg
     *            the datelist org
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortDateDescending(final List<Date> datelistTemp,
            final List<Date> datelistOrg, final String objectName,
            final String type, final String order, final boolean stopOnFailure,
            final Object[] customError) {

        if (datelistTemp.equals(datelistOrg)) {
            // System.out.println("descending");
            reportresult(true, "CHECK SORTING :", "PASSED",
                    "Check sorting command : Element " + objectName
                            + " sorted in Type : " + type + ", Order : "
                            + order);
        } else {
            // System.out.println("Not descending");

            reportresult(
                    true,
                    "CHECK SORTING :" + objectName + "",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);

        }
    }

    /**
     * Sort date ascending.
     * 
     * @param datelistTemp
     *            the datelist temp
     * @param datelistOrg
     *            the datelist org
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sortDateAscending(final List<Date> datelistTemp,
            final List<Date> datelistOrg, final String objectName,
            final String type, final String order, final boolean stopOnFailure,
            final Object[] customError) {
        if (datelistTemp.equals(datelistOrg)) {
            // System.out.println("ascending");
            reportresult(true, "CHECK SORTING :", "PASSED",
                    "Check sorting command : Element " + objectName
                            + " sorted in Type : " + type + ", Order : "
                            + order);
        } else {
            // System.out.println("Not ascending");

            reportresult(
                    true,
                    "CHECK SORTING :" + objectName + "",
                    "FAILED",
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);
            checkTrue(
                    false,
                    stopOnFailure,
                    ""
                            + generateCustomError(customError)
                            + " System generated Error : CHECK SORTING command  : Element ("
                            + objectName + ") not sorted in Type : " + type
                            + ", Order : " + order);

        }

    }

    /**
     * Sort.
     * 
     * @param sortList
     *            the Sort List
     * @param objectName
     *            the object name
     * @param type
     *            the type
     * @param pattern
     *            the pattern
     * @param order
     *            the order
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void sort(final ArrayList<String> sortList,
            final String objectName, final String type, final String pattern,
            final String order, final boolean stopOnFailure,
            final Object[] customError) {
        List<String> listOrg = new ArrayList<String>();
        for (int i = 0; i < sortList.size(); i++) {
            // System.out.println(l.get(i));

            if ("".equals(sortList.get(i))) {
                sortList.set(i, " ");
            }
            listOrg.add(sortList.get(i));

        }

        System.out.println("Unsorted ArrayList in Java : " + sortList);
        System.out.println("Order :" + order);
        System.out.println("Pattern :" + pattern);
        System.out.println("Type :" + type);

        // ////////////////////////////////////////////////////////////////////////

        if ("string".equals(type)) {
            sortString(sortList, objectName, type, pattern, order,
                    stopOnFailure, customError);

            // ///////////////////////////////////////////////////////////////////////////////////////
        } else if ("numeric".equals(type)) {
            sortNumeric(sortList, objectName, type, order, stopOnFailure,
                    customError);

        } else if ("date".equals(type)) {
            sortDate(sortList, objectName, type, pattern, order, stopOnFailure,
                    customError);

        } else {
            reportresult(true, "CHECK SORTING :" + objectName + "", "FAILED",
                    "CHECK SORTING command  : Type (" + type + ") not match");
            checkTrue(false, stopOnFailure, "CHECK SORTING command  : Type ("
                    + type + ") not match");
        }
    }

    /**
     * Insight custom command. Checks insight charts content values.
     * 
     * @param chartName
     *            the chart name
     * @param identifire
     *            the identifire
     * @param vendor
     *            the vendor
     * @param type
     *            the type
     * @param lData
     *            the l data
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */

    public final void checkChartContent(final String chartName,
            final String identifire, final String vendor, final String type,
            final String lData, final boolean stopOnFailure,
            final Object... customError) {
        String actualLocator =
                ObjectMap.getObjectSearchPath(chartName, identifire);
        ObjectLocator locator =
                new ObjectLocator(chartName, identifire, actualLocator);
        doCheckChartContent(locator, vendor, type, lData, stopOnFailure,
                customError);

    }

    /**
     * Check chart content.
     * 
     * @param chartName
     *            the chart name
     * @param vendor
     *            the vendor
     * @param type
     *            the type
     * @param lData
     *            the l data
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    public final void checkChartContent(final String chartName,
            final String vendor, final String type, final String lData,
            final boolean stopOnFailure, final Object... customError) {

        checkChartContent(chartName, "", vendor, type, lData, stopOnFailure,
                customError);

    }

    /**
     * Check chart content.
     * 
     * @param locator
     *            the locator
     * @param vendor
     *            the vendor
     * @param type
     *            the type
     * @param lData
     *            the l data
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     */
    private void doCheckChartContent(final ObjectLocator locator,
            final String vendor, final String type, final String lData,
            final boolean stopOnFailure, final Object[] customError) {

        // String objectID = locator.getActualLocator();

        try {

            if ("Google".equals(vendor)) {
                String checkType = "(\\|([^#|]*#[^#|]*)\\|)";

                if (!lData.matches(checkType) && "PIE".equals(type)) {

                    checkPieChartContent(locator, lData, stopOnFailure,
                            customError);
                } else if (!lData.matches(checkType) && "BAR".equals(type)) {

                    checkBarChartContent(locator, lData, stopOnFailure,
                            customError);
                } else {

                    if ("PIE".equals(type) || "BAR".equals(type)) {
                        reportresult(true, "CHART VALIDATION :", "FAILED",
                                "CHART VALIDATION command : Given chart type : "
                                        + type + " is incorrect.");

                        checkTrue(false, stopOnFailure,
                                "CHART VALIDATION  command  : Given chart type : "
                                        + type + " is incorrect.");
                    } else {

                        reportresult(true, "CHART VALIDATION :", "FAILED",
                                "CHART VALIDATION command : Given chart type : "
                                        + type + " for the vendor " + vendor
                                        + " is invalid.");

                        checkTrue(false, stopOnFailure,
                                "CHART VALIDATION  command  : Given chart type : "
                                        + type + " for the vendor " + vendor
                                        + " is invalid.");
                    }
                }
            } else {
                reportresult(true, "CHART VALIDATION :", "FAILED",
                        "CHART VALIDATION command : Given vendor " + vendor
                                + " is invalid.");

                checkTrue(false, stopOnFailure,
                        "CHART VALIDATION command : Given vendor " + vendor
                                + " is invalid.");
            }

        } catch (RowsExceededException e) {

            e.printStackTrace();
        } catch (WriteException e) {

            e.printStackTrace();
        } catch (BiffException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * Check pie chart content.
     * 
     * @param locator
     *            the locator
     * @param lData
     *            the l data
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     * @throws InterruptedException
     *             the interrupted exception
     * @throws WriteException
     *             the write exception
     * @throws BiffException
     *             the biff exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void checkPieChartContent(final ObjectLocator locator,
            final String lData, final boolean stopOnFailure,
            final Object[] customError) throws InterruptedException,
            WriteException, BiffException, IOException {

        boolean isElementFound = false;
        String inputstring = "";

        ArrayList<String> inputStringArray;
        // variables for each pie chart element
        ArrayList<String> chartnames = new ArrayList<String>();
        ArrayList<String> chartvalues = new ArrayList<String>();
        StringBuilder errorstr;
        boolean isEqual = false;

        String objectName = locator.getLogicalName();
        String chartLocator = locator.getActualLocator();

        inputstring = lData;
        WebElement chartWebElement = null;

        try {
            chartWebElement = checkElementPresence(chartLocator);
            isElementFound = true;

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (isElementFound) {

            String inputStringCurrStr = "";
            ArrayList<String> inputStringCurrArray;

            inputStringArray =
                    new ArrayList<String>(Arrays.asList(inputstring.split("#")));

            for (int i = 0; i < inputStringArray.size(); i++) {

                // Split the string to parts and entered to an array NAMED
                // inputTable
                try {

                    // Getting the values out
                    inputStringCurrStr = inputStringArray.get(i);
                    inputStringCurrArray =
                            new ArrayList<String>(
                                    Arrays.asList(inputStringCurrStr
                                            .split("\\|")));

                    // Putting them to arrays to be used in pie chart check
                    chartnames.add(inputStringCurrArray.get(0));
                    chartvalues.add(inputStringCurrArray.get(1));
                } catch (IndexOutOfBoundsException e) {

                    reportresult(true, "CHECK CHART CONTENT :" + objectName
                            + "", "FAILED",
                            "PIECHART VALIDATION  command  : Given input is invalid.");

                    checkTrue(false, stopOnFailure,
                            "PIECHART VALIDATION  command  : Given input is invalid. ");

                }

            }

            // Check the Pie chart
            errorstr =
                    insightPieChartContentCheck(chartWebElement, chartnames,
                            chartvalues);
            if ((errorstr == null || errorstr.length() == 0)) {
                isEqual = true;
            } else {
                isEqual = false;
            }

            // Pass or fail the test case
            if (isEqual) {
                reportresult(true, "CHECK CHART CONTENT :" + chartLocator + "",
                        "PASSED", "");
            } else {

                // VTAF result reporter call

                reportresult(true, "CHECK CHART CONTENT :" + objectName + "",
                        "FAILED", generateCustomError(customError)
                                + "PIECHART VALIDATION  command  :Element ("
                                + chartLocator + ") Error Str:" + errorstr);

                // VTAF specific validation framework reporting

                checkTrue(false, stopOnFailure,
                        generateCustomError(customError)
                                + "PIECHART VALIDATION  command  :Element ("
                                + chartLocator + ")  Error Str:" + errorstr);
            }

        } else { // if element is not present

            // VTAF result reporter call

            reportresult(true, "CHECK CHART CONTENT :" + objectName + "",
                    "FAILED", generateCustomError(customError)
                            + "PIECHART VALIDATION  command  :Element ("
                            + chartLocator + ") not present");

            // VTAF specific validation framework reporting

            checkTrue(false, stopOnFailure, generateCustomError(customError)
                    + "PIECHART VALIDATION  command  :Element (" + chartLocator
                    + ")  not present");
        }

    }

    /**
     * Insight pie chart content check.
     * 
     * @param chartWebElement
     *            the chart web element
     * @param chartnames
     *            the chartnames
     * @param chartvalues
     *            the chartvalues
     * @return the string buffer
     */
    private StringBuilder insightPieChartContentCheck(
            final WebElement chartWebElement,
            final ArrayList<String> chartnames,
            final ArrayList<String> chartvalues) {

        // Portlet content variables

        WebDriver driver = getDriver();

        ArrayList<String> chartelementnamesAct = new ArrayList<String>();
        ArrayList<String> chartelementvaluesAct = new ArrayList<String>();

        int startingElement = 0;
        int countMouseOver = 0;
        int counElementName = 0;
        int countElementValue = 0;
        final int retryDevide = 10;
        Logger logs = getLog();
        StringBuilder verificationErrors = new StringBuilder();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        try {

            WebElement chartBase = chartWebElement; // driver.findElement(By.xpath(chartLocator));

            List<WebElement> locateElements =
                    chartBase.findElements(By.xpath("child::*[name()='g']"));
            int countA = locateElements.size();

            List<WebElement> locatePathElements =
                    chartBase
                            .findElements(By
                                    .xpath("child::*[name()='g']/child::*[name()='path'and position()=1]"));
            int categories = locatePathElements.size();

            startingElement = elementStart(locateElements);

            WebElement element;
            List<WebElement> subTextElements;

            for (int j = startingElement; j < categories + startingElement; j++) {

                // System.out.println(locateElements.get(j));

                try {
                    locateElements =
                            chartBase.findElements(By
                                    .xpath("child::*[name()='g']"));
                    element = locateElements.get(j);
                    subTextElements = element.findElements(By.tagName("text"));

                    /*
                     * fire Mouseover action to web elements
                     */
                    if (!subTextElements.isEmpty()) {
                        jsExecutor
                                .executeScript(
                                        "var evObj = document.createEvent('MouseEvents');"
                                                + "evObj.initMouseEvent(\"mouseover\",true,"
                                                + " false, window, 0, 0, 0, 0, 0,"
                                                + " false, false, false, false, 0, null);"
                                                + "arguments[0].dispatchEvent(evObj);",
                                        subTextElements.get(0));

                    } else {

                        jsExecutor
                                .executeScript(
                                        "var evObj = document.createEvent('MouseEvents');"
                                                + "evObj.initMouseEvent(\"mouseover\",true,"
                                                + " false, window, 0, 0, 0, 0, 0, "
                                                + "false, false, false, false, 0, null);"
                                                + "arguments[0].dispatchEvent(evObj);",
                                        element);
                    }
                } catch (IndexOutOfBoundsException e1) {
                    countMouseOver++;
                    if (countMouseOver == 1) {
                        verificationErrors
                                .append(" Can't find actualWebElement ");
                    }
                }

                sleep(RETRY_INTERVAL / retryDevide);

                try {
                    WebElement elementName =
                            locateElements
                                    .get(countA - 1)
                                    .findElement(
                                            By.xpath("child::*[position()=1]/child::*[position()=4]"));

                    chartelementnamesAct.add(elementName.getText());
                    // System.out.println("chartelementnamesAct : "
                    // + chartelementnamesAct);

                } catch (WebDriverException e1) {
                    counElementName++;
                    if (counElementName == 1) {

                        String notPresentEror =
                                "Not Present actualWebElementValue";
                        logs.error(notPresentEror);
                        // verificationErrors
                        // .append(" Not Present actualWebElementName ");
                    }
                }

                try {

                    WebElement elementValue =
                            locateElements
                                    .get(countA - 1)
                                    .findElement(
                                            By.xpath("child::*[position()=1]/child::*[position()=5]"));

                    chartelementvaluesAct.add(elementValue.getText());

                    // System.out.println("chartelementvaluesAct:"
                    // + chartelementvaluesAct);

                } catch (WebDriverException e1) {
                    countElementValue++;

                    String notPresentErorr =
                            "Not Present actualWebElementValue";
                    if (countElementValue == 1) {
                        logs.error(notPresentErorr);
                        // verificationErrors
                        // .append(" Not Present actualWebElementValue ");

                    }
                }

            }

            /*
             * Do the validation with expected and actual values
             */

            verificationErrors.append(sendVerificationError(chartnames,
                    chartvalues, chartelementnamesAct, chartelementvaluesAct));

        } catch (WebDriverException e) {
            verificationErrors.append("\n" + e.toString());

        }

        return verificationErrors;

    }

    /**
     * Element start.
     * 
     * @param locateElements
     *            the locate elements
     * @return the int
     */
    private int elementStart(final List<WebElement> locateElements) {
        int startElement = 0;
        int countA = locateElements.size();

        for (int x = 0; x < countA; x++) {

            try {
                locateElements.get(x).findElement(
                        By.xpath("child::*[name()='path']"));
                break;

            } catch (Exception e) {
                // verificationErrors.append(" path element no found ");
                startElement += 1;
                continue;
            }
        }
        return startElement;

    }

    /**
     * Send verification error.
     * 
     * @param chartnames
     *            the chartnames
     * @param chartvalues
     *            the chartvalues
     * @param chartelementnamesAct
     *            the chartelementnames act
     * @param chartelementvaluesAct
     *            the chartelementvalues act
     * @return the string builder
     */
    private StringBuilder sendVerificationError(
            final ArrayList<String> chartnames,
            final ArrayList<String> chartvalues,
            final ArrayList<String> chartelementnamesAct,
            final ArrayList<String> chartelementvaluesAct) {

        StringBuilder verificationErrors = new StringBuilder();

        ArrayList<String> chartelementnames = chartnames;
        ArrayList<String> chartelementvalues = chartvalues;

        for (int i = 0; i < chartelementnames.size(); i++) {

            String expectedname = "" + chartelementnames.get(i) + "";
            String expectedPers = "" + chartelementvalues.get(i) + "";

            if (!chartelementnamesAct.contains(expectedname)) {

                verificationErrors.append(
                        "\n Chart comparison mismatch : category name "
                                + expectedname + " Not present in : ").append(
                        chartelementnamesAct);
            }

            if (!chartelementvaluesAct.contains(expectedPers)) {

                verificationErrors.append(
                        "\n Chart comparison mismatch : " + expectedPers
                                + " Not present for actual Values in : ")
                        .append(chartelementvaluesAct);
            }
        }

        return verificationErrors;

    }

    /**
     * Check bar chart content.
     * 
     * @param locator
     *            the locator
     * @param lData
     *            the l data
     * @param stopOnFailure
     *            the stop on failure
     * @param customError
     *            the custom error
     * @throws InterruptedException
     *             the interrupted exception
     * @throws WriteException
     *             the write exception
     * @throws BiffException
     *             the biff exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void checkBarChartContent(final ObjectLocator locator,
            final String lData, final boolean stopOnFailure,
            final Object[] customError) throws InterruptedException,
            WriteException, BiffException, IOException {

        boolean isElementFound = false;
        String inputstring = "";
        ArrayList<String> chartBarTextNames;
        StringBuffer errorstr;
        boolean isEqual = false;
        int checkingColCount = 0;
        String chartLocator = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        inputstring = lData;
        WebElement chartWebElement = null;
        try {
            chartWebElement = checkElementPresence(chartLocator);
            isElementFound = true;

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (isElementFound) {
            String inputStringCurrStr = "";
            ArrayList<ArrayList<String>> userColumnNameValues =
                    new ArrayList<ArrayList<String>>();
            ArrayList<String> inputStringCurrArray;

            chartBarTextNames =
                    new ArrayList<String>(Arrays.asList(inputstring.split("#")));
            checkingColCount = chartBarTextNames.size();

            for (int i = 0; i < checkingColCount; i++) {

                try {
                    // Getting the values out
                    inputStringCurrStr = chartBarTextNames.get(i);
                    inputStringCurrArray =
                            new ArrayList<String>(
                                    Arrays.asList(inputStringCurrStr
                                            .split("\\|")));

                    userColumnNameValues.add(inputStringCurrArray);

                } catch (IndexOutOfBoundsException e) {

                    reportresult(true, "CHECK CHART CONTENT :" + objectName
                            + "", "FAILED",
                            "BARCHART VALIDATION  command  : Given input is invalid.");

                    checkTrue(false, stopOnFailure,
                            "BARCHART VALIDATION  command  : Given input is invalid. ");
                }

            }

            System.out.println(userColumnNameValues);
            errorstr =
                    insightBarChartContentCheck(chartWebElement,
                            userColumnNameValues);
            if ((errorstr == null || errorstr.length() == 0)) {
                isEqual = true;
            } else {
                isEqual = false;
            }

            // Pass or fail the test case
            if (isEqual) {
                reportresult(true, "CHECK CHART CONTENT :" + chartLocator + "",
                        "PASSED", "");
            } else {

                /*
                 * VTAF result reporter call
                 */
                reportresult(true, "CHECK CHART CONTENT :" + chartLocator + "",
                        "FAILED", generateCustomError(customError)
                                + "BARCHART VALIDATION  command  :Element ("
                                + chartLocator + ") Error Str:" + errorstr);

                /*
                 * VTAF specific validation framework reporting
                 */
                checkTrue(false, stopOnFailure,
                        generateCustomError(customError)
                                + "BARCHART VALIDATION  command  :Element ("
                                + chartLocator + ") Error Str:" + errorstr);

            }

        } else { // if element is not present

            /*
             * VTAF result reporter call
             */
            reportresult(true, "CHECK CHART CONTENT :" + chartLocator + "",
                    "FAILED", generateCustomError(customError)
                            + "BARCHART VALIDATION  command  :Element ("
                            + chartLocator + ")  not present");

            /*
             * VTAF specific validation framework reporting
             */
            checkTrue(false, stopOnFailure, generateCustomError(customError)
                    + "BARCHART VALIDATION  command  :Element (" + chartLocator
                    + ")  not present");
        }

    }

    /**
     * Insight bar chart content check.
     * 
     * @param chartWebElement
     *            the chart web element
     * @param chartBarTextNames
     *            the chart bar text names
     * @return the string buffer
     */
    private StringBuffer insightBarChartContentCheck(
            final WebElement chartWebElement,
            final List<ArrayList<String>> chartBarTextNames) {

        // Portlet content variables
        List<ArrayList<String>> chartElementNames = chartBarTextNames;
        WebDriver driver = getDriver();
        int categoryIndex = 0;
        int startingelement = 0;
        final int retryDevide = 10;

        StringBuffer verificationErrors = new StringBuffer();
        int actCategoryCount = 0;

        ArrayList<String> htmlElementNames = new ArrayList<String>();
        ArrayList<String> htmlShortNames = new ArrayList<String>();
        ArrayList<Integer> groupNames = new ArrayList<Integer>();
        Map<Integer, List<String>> yCorWithNames =
                new HashMap<Integer, List<String>>();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement barChartBase = chartWebElement; // driver.findElement(By.xpath(chartLocator));

        List<WebElement> locateTagElements =
                barChartBase.findElements(By.xpath("child::*[name()='g']"));
        int countB = locateTagElements.size();

        categoryIndex = categoryIndex(locateTagElements);

        List<WebElement> locateCategoryElements =
                locateTagElements
                        .get(categoryIndex)
                        .findElements(
                                By.xpath("child::*[position()=2]/child::*[position()=2]/child::*[name()='rect']"));

        actCategoryCount = locateCategoryElements.size();

        for (int i = startingelement; i < actCategoryCount; i++) {

            try {
                groupNames.add(locateCategoryElements.get(i).getLocation().y);

                try {

                    WebElement elementTwo = locateCategoryElements.get(i);

                    sleep(RETRY_INTERVAL / retryDevide);

                    /*
                     * fire Mouseover action to web elements
                     */
                    jsExecutor
                            .executeScript(
                                    "var evObj = document.createEvent('MouseEvents');"
                                            + "evObj.initMouseEvent(\"mouseover\",true, false,"
                                            + " window, 0, 0, 0, 0, 0, false, false, "
                                            + "false, false, 0, null);"
                                            + "arguments[0].dispatchEvent(evObj);",
                                    elementTwo);

                    sleep(RETRY_INTERVAL / retryDevide);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {

                    List<WebElement> barElementText =
                            locateTagElements.get(countB - 1).findElements(
                                    By.tagName("text"));
                    int countBarElementText = barElementText.size();
                    htmlShortNames.clear();

                    for (int z = 0; z < countBarElementText; z++) {
                        htmlShortNames.add(barElementText.get(z).getText());
                    }

                    System.out.println(StringUtils.join(htmlShortNames, " "));
                    htmlElementNames.add(StringUtils.join(htmlShortNames, " "));

                    /*
                     * if(){ continue; }
                     * 
                     * else{
                     * htmlElementNames.add(StringUtils.join(htmlShortNames,
                     * " "));
                     */

                    try {
                        if (!yCorWithNames.containsKey(groupNames.get(i))) {
                            yCorWithNames.put(groupNames.get(i),
                                    new ArrayList<String>());
                            yCorWithNames.get(groupNames.get(i)).add(
                                    htmlElementNames.get(i));
                        } else if (yCorWithNames.containsKey(groupNames.get(i))) {
                            yCorWithNames.get(groupNames.get(i)).add(
                                    htmlElementNames.get(i));
                        }
                    } catch (IndexOutOfBoundsException e) {
                        verificationErrors
                                .append("Error with adding (KEY,VALUE) pairs");
                    }
                    // }
                } catch (Exception e) {
                    verificationErrors.append("\n" + e.toString());
                }

            } catch (IndexOutOfBoundsException e) {
                continue;
                /*
                 * verificationErrors.append("\n Can't locate Text Tags\n" +
                 * e.toString());
                 */

            }
        }

        System.out.println(yCorWithNames.toString());
        System.out.println(yCorWithNames.values().toString());

        /*
         * Do the validation with expected and actual values
         */
        verificationErrors.append(updateVerficationString(chartElementNames,
                yCorWithNames));

        return verificationErrors;
    }

    /**
     * Update verfication string.
     * 
     * @param chartElementNames
     *            the chart element names
     * @param yCorWithNames
     *            the y cor with names
     * @return the string builder
     */
    private StringBuilder updateVerficationString(
            final List<ArrayList<String>> chartElementNames,
            final Map<Integer, List<String>> yCorWithNames) {

        StringBuilder verificationErrors = new StringBuilder();
        for (int z = 0; z < chartElementNames.size(); z++) {

            if (!yCorWithNames.values().contains(chartElementNames.get(z))) {
                verificationErrors.append("\n Element :" + z
                        + " Expected element name = "
                        + chartElementNames.get(z) + " is different from the "
                        + "actual values in : "
                        + yCorWithNames.values().toString());
            }

        }

        return verificationErrors;

    }

    /**
     * Category index.
     * 
     * @param locateTagElements
     *            the locate tag elements
     * @return the int
     */
    private int categoryIndex(final List<WebElement> locateTagElements) {

        int categoryIndex = 0;

        int countB = locateTagElements.size();

        for (int y = 0; y < countB; y++) {
            try {
                locateTagElements.get(y).findElement(
                        By.xpath("*[contains(@clip-path,'url')]"));
                categoryIndex = y;
                break;

            } catch (Exception e2) {
                continue;
            }
        }
        return categoryIndex;

    }

    /**
     * Element chart element present.
     * 
     * @param xPath
     *            the x path
     * @return true, if successful
     */
    public final boolean elementChartElementPresent(final String xPath) {

        try {
            WebDriver driver = getDriver();
            driver.findElement(By.xpath(xPath));

            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    /**
     * The Enum for manage browser.
     */
    public static enum resizeApplicationType {

        /** The maximize. */
        MAXIMIZE, /** The resize. */
        RESIZE,

    };

    /**
     * Resize application.
     * 
     * @param action
     *            the action
     * @param screenSize
     *            the screen size
     */
    public final void resizeApplication(final Object action,
            final String screenSize) {
        doResizeApplication(action, screenSize);
    }

    /**
     * Do resize application.
     * 
     * @param action
     *            the action
     * @param screenSize
     *            the screen size
     */
    private void doResizeApplication(final Object action,
            final String screenSize) {

        try {

            if (resizeApplicationType.MAXIMIZE.toString().equals(action)) {
                WebDriver driver = getDriver();
                if (driver != null) {
                    driver.manage().window().maximize();
                    reportresult(true, "MANAGE BROWSER : ", "PASSED", "["
                            + action + "] Application");
                }
            } else if (resizeApplicationType.RESIZE.toString().equals(action)) {
                int width = Integer.parseInt(screenSize.split("\\,")[0]);
                int height = Integer.parseInt(screenSize.split("\\,")[1]);
                WebDriver driver = getDriver();
                checkNullObject(width + height, "ManageBrowser");
                if (driver != null) {
                    driver.manage()
                            .window()
                            .setSize(
                                    new org.openqa.selenium.Dimension(width,
                                            height));
                    reportresult(true, "MANAGE BROWSER : ", "PASSED", "["
                            + action + "] Application to [" + screenSize + "]");
                }
            } else {
                reportresult(true, "MANAGE BROWSER :" + action + "", "FAILED",
                        "Invalid argument given for action in ManageBrowser command.");
                checkTrue(false, true,
                        "Invalid argument given for action in ManageBrowser command.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            reportresult(
                    true,
                    "MANAGE BROWSER :" + action + "",
                    "FAILED",
                    "ManageBrowser command cannot perform :Action ("
                            + action
                            + ") , Both Height and Width are needed. Actual Error : "
                            + e.getMessage());
            checkTrue(
                    false,
                    true,
                    "MANAGE BROWSER command cannot perform :Action ("
                            + action
                            + ") , Both Height and Width are needed. Actual Error : "
                            + e.getMessage());
        }
    }

    /**
     * get Element Infomation.
     * 
     * @param objectName
     *            the object name
     * @param identifier
     *            the identifier
     * @return true, if successful
     */

    public final int[] getElementInfo(final String objectName,
            final String identifier) {
        String actualLocator =
                ObjectMap.getObjectSearchPath(objectName, identifier);
        ObjectLocator locator =
                new ObjectLocator(objectName, identifier, actualLocator);
        return doGetElementInfo(locator);
    }

    /**
     * Gets the element info.
     * 
     * @param objectName
     *            the object name
     * @return the element info
     */
    public final int[] getElementInfo(final String objectName) {
        return getElementInfo(objectName, "");
    }

    /**
     * Do get element info.
     * 
     * @param locator
     *            the locator
     * @return the int[]
     */
    private int[] doGetElementInfo(final ObjectLocator locator) {

        final int four = 4;
        int[] objVal = new int[four];

        int counter = getRetryCount();

        // Getting the actual object identification from the object map

        String objectID = locator.getActualLocator();
        String objectName = locator.getLogicalName();
        try {
            // Check whether the element present
            checkForNewWindowPopups();
            WebElement element = checkElementPresence(objectID);
            /*
             * START DESCRIPTION following for loop was added to make the
             * command more consistent try the command for give amount of time
             * (can be configured through class variable RETRY) command will be
             * tried for "RETRY" amount of times or until command works. any
             * exception thrown within the tries will be handled internally.
             * 
             * can be exited from the loop under 2 conditions 1. if the command
             * succeeded 2. if the RETRY count is exceeded
             */

            while (counter > 0) {
                try {
                    int zero = 0;
                    int one = 1;
                    int two = 2;
                    // final int threee = 3;
                    final int three = 3;
                    Point eleGetLocation = element.getLocation();
                    org.openqa.selenium.Dimension eleGetSize =
                            element.getSize();
                    objVal[0] = eleGetSize.height;

                    objVal[1] = eleGetSize.width;

                    objVal[2] = eleGetLocation.x;

                    objVal[three] = eleGetLocation.y;

                    counter--;
                    // Calling the actual command
                    reportresult(true, "GET ELEMENT INFO :" + objectName + "",
                            "PASSED", " Element Info of Element [" + objectName
                                    + "] with Locator : " + objectID
                                    + " Height [" + objVal[zero] + "] Width ["
                                    + objVal[one] + "] Xcordinate ["
                                    + objVal[two] + "] Ycordinate ["
                                    + objVal[one + two] + "]");
                    break;
                } catch (StaleElementReferenceException staleElementException) {

                    element = checkElementPresence(objectID);
                } catch (Exception e) {
                    sleep(retryInterval);
                    if (!(counter > 0)) {
                        e.printStackTrace();

                        reportresult(true, "GET ELEMENT INFO :" + objectName
                                + "", "FAILED",
                                "GET ELEMENT INFO command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID);
                        checkTrue(false, true,
                                "GETELEMENTINFO command cannot access :Element [ "
                                        + objectName + " ] with Locator : "
                                        + objectID);
                    }
                }

            }
            /*
             * END DESCRIPTION
             */
        } catch (Exception e) {

            // if any exception was raised, report a test failure
            e.printStackTrace();

            reportresult(true, "GET ELEMENT INFO :" + objectName + "",
                    "FAILED", "GETELEMENTINFO command  :Element [ "
                            + objectName + " ] with Locator : " + objectID
                            + " not present");
            checkTrue(false, true, "GET ELEMENT INFO command  :Element [ "
                    + objectName + " ] with Locator : " + objectID
                    + " not present");

        }
        return objVal;

    }

    /**
     * Adds the values from excel.
     * 
     * @param path
     *            the path
     * @param index
     *            the index
     * @return the string[][]
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InvalidFormatException
     *             the invalid format exception
     */
    public final String[][] addValuesFromExcel(final String path,
            final String index) throws IOException, InvalidFormatException {

        String cellStringValue = null;
        double cellDoubleValue = 0;
        Boolean cellBooleanValue;
        byte cellErrorValue = 0;
        String[][] arrExcelContent;
        FileInputStream file = null;
        Workbook workbook = null;

        Sheet sheet = null;
        try {
            file = new FileInputStream(new File(path));
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheetAt(Integer.parseInt(index));
            Iterator<Row> rowIterator = sheet.iterator();
            arrExcelContent = new String[sheet.getPhysicalNumberOfRows()][];
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                int rowNumber = row.getRowNum();
                Iterator<Cell> cellIterator = row.cellIterator();
                arrExcelContent[rowNumber] =
                        new String[sheet.getRow(rowNumber)
                                .getPhysicalNumberOfCells()];
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int cellNumber = cell.getColumnIndex();
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        cellStringValue = cell.getStringCellValue();
                        arrExcelContent[rowNumber][cellNumber] =
                                cellStringValue;
                    } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                        cellBooleanValue = cell.getBooleanCellValue();
                        arrExcelContent[rowNumber][cellNumber] =
                                cellBooleanValue.toString();
                    } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                        cellErrorValue = cell.getErrorCellValue();
                        arrExcelContent[rowNumber][cellNumber] =
                                Byte.toString(cellErrorValue);
                    } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                        cellStringValue = cell.getCellFormula();
                        arrExcelContent[rowNumber][cellNumber] =
                                cellStringValue;

                    } else {

                        cellDoubleValue = cell.getNumericCellValue();
                        arrExcelContent[rowNumber][cellNumber] =
                                Double.toString(cellDoubleValue);
                    }
                }

            }
        } finally {
            if (((InputStream) workbook) != null) {
                ((InputStream) workbook).close();
            }
        }
        return arrExcelContent;
    }

    /**
     * Verify excel.
     * 
     * @param path
     *            the path
     * @param index
     *            the index
     * @param validationType
     *            the validation type
     * @param expectedvale
     *            the expectedvale
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    public final void verifyExcel(final String path, final String index,
            final String validationType, final Object expectedvale,
            final boolean stopOnFaliure, final Object[] customError) {
        String[][] arrExcelContent = null;
        try {
            arrExcelContent = addValuesFromExcel(path, index);

        } catch (IOException e) {
            e.printStackTrace();
            reportresult(true, "CHECK DOCUMENT :", validationType,
                    "The Excel Sheet is not Found in the given path");
            checkTrue(false, stopOnFaliure,
                    " command checkDocument  :Element (" + path
                            + ") is not accessible");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            reportresult(true, "CHECK DOCUMENT :", validationType,
                    "The Index of the Excel Sheet Can not be accessed");
            checkTrue(false, stopOnFaliure,
                    " command checkDocument  :Element (" + index
                            + ") is not accessible");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            reportresult(true, "CHECK DOCUMENT :", validationType,
                    "The Excel Sheet is not in the correct format");
            checkTrue(false, stopOnFaliure,
                    " The Excel Sheet is not in the correct format");
        }
        doverifyExcel(arrExcelContent, validationType, expectedvale,
                stopOnFaliure, customError);

    }

    /**
     * Doverify excel.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param validationTypeS
     *            the validation type s
     * @param objExpectedvale
     *            the obj expectedvale
     * @param stopOnFaliure
     *            the stop on faliure
     * @param customError
     *            the custom error
     */
    private void doverifyExcel(final String[][] arrExcelContent,
            final String validationTypeS, final Object objExpectedvale,
            final boolean stopOnFaliure, final Object[] customError) {
        String validationType = validationTypeS;
        String expectedvale =
                checkNullObject(objExpectedvale, "CHECK DOCUMENT");
        try {
            try {
                if (TableValidationType.ROWCOUNT.toString().equals(
                        validationType)) {
                    validateExcelRowCount(arrExcelContent, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.COLCOUNT.toString().equals(
                        validationType)) {
                    validateExcelColCount(arrExcelContent, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.TABLEDATA.toString().equals(
                        validationType)) {
                    compareExcelData(arrExcelContent, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.RELATIVE.toString().equals(
                        validationType)) {
                    validateExcelOffset(arrExcelContent, expectedvale,
                            stopOnFaliure, customError);
                } else if (TableValidationType.TABLECELL.toString().equals(
                        validationType)) {
                    validateExcelCellValue(arrExcelContent, expectedvale,
                            stopOnFaliure, customError);
                } else {
                    reportresult(
                            true,
                            "CHECK DOCUMENT :" + validationType + " :",
                            "FAILED",
                            "Unknown validation type passed :"
                                    + " "
                                    + validationTypeS
                                    + ". Accepted validation types : "
                                    + "ROWCOUNT , COLCOUNT , TABLEDATA , RELATIVE , TABLECELL");
                    checkTrue(
                            false,
                            stopOnFaliure,
                            "Unknown validation type passed :"
                                    + " "
                                    + validationTypeS
                                    + ". Accepted validation types : "
                                    + "ROWCOUNT , COLCOUNT , TABLEDATA , RELATIVE , TABLECELL ");
                }

            } catch (Exception e) {
                reportresult(true, "CHECK DOCUMENT :" + validationType + " :"
                        + "objectName" + "", "FAILED", "objectName"
                        + " is not accessible");
                checkTrue(false, stopOnFaliure,
                        " command checkTable()  :Element (" + "objectName"
                                + ") [" + "objectID" + "] is not accessible");

            }
        } catch (Exception e) {
            e.printStackTrace();
            reportresult(true, "CHECK DOCUMENT :" + validationType + " :"
                    + "objectName" + "", "FAILED", "objectName"
                    + " not present");
            checkTrue(false, stopOnFaliure, " command checkTable()  :Element ("
                    + "objectName" + ") [" + "objectID" + "] not present");
        }

    }

    /**
     * Validate excel row count.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param expectedValue
     *            the expected value
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @return the int
     */
    private int validateExcelRowCount(final String[][] arrExcelContent,
            final String expectedValue, final boolean fail,
            final Object[] customError) {
        int rowCount = 0;
        try {
            rowCount = arrExcelContent.length;
            if (rowCount == Integer.parseInt(expectedValue)) {
                reportresult(true, "CHECK DOCUMENT :ROW COUNT", "PASSED",
                        "CHECK TABLE :ROW COUNT" + "| Input Value = "
                                + expectedValue);
            } else {
                reportresult(true, "CHECK DOCUMENT :ROW COUNT", "FAILED", ""
                        + generateCustomError(customError)
                        + " System generated Error : CHECK DOCUMENT :ROW COUNT"
                        + "| Expected :" + expectedValue + " |Actual : "
                        + rowCount);
                checkTrue(false, fail, "" + generateCustomError(customError)
                        + " System generated Error : CHECK DOCUMENT :ROW COUNT"
                        + "| Expected :" + expectedValue + " |Actual : "
                        + rowCount);
            }
        } catch (Exception e) {
            e.printStackTrace();

            reportresult(fail, "CHECK DOCUMENT :ROW COUNT :", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + e.getMessage());
            checkTrue(false, fail, "" + generateCustomError(customError)
                    + " System generated Error : " + e.getMessage());
            e.printStackTrace();

        }
        return rowCount;
    }

    /**
     * Validate excel col count.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param expectedValue
     *            the expected value
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @return the int
     */
    private int validateExcelColCount(final String[][] arrExcelContent,
            final String expectedValue, final boolean fail,
            final Object[] customError) {

        String inputStringSingleCommand = "";
        String inputStringRowCell = "";
        String inputStringRow = "";
        int actualdValue = 0;
        ArrayList<String> inputStringSingleCommandsArray = null;
        ArrayList<String> inputStringRowCellArray = null;
        ArrayList<String> inputStringRowArray = null;

        boolean flag = false;
        try {
            inputStringSingleCommandsArray =
                    new ArrayList<String>(Arrays.asList(expectedValue
                            .split("#")));
            for (int i = 0; i < inputStringSingleCommandsArray.size(); i++) {
                inputStringSingleCommand =
                        inputStringSingleCommandsArray.get(i);
                inputStringRowCellArray =
                        new ArrayList<String>(
                                Arrays.asList(inputStringSingleCommand.split(
                                        "(?<!\\\\),", Integer.MAX_VALUE)));
                inputStringRowCell = inputStringRowCellArray.get(0);
                inputStringRowArray =
                        new ArrayList<String>(Arrays.asList(inputStringRowCell
                                .split("=")));
                inputStringRow = inputStringRowArray.get(1);
                actualdValue =
                        arrExcelContent[Integer.parseInt(inputStringRow)].length;
                if (actualdValue == Integer.parseInt(inputStringRowCellArray
                        .get(1))) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                reportresult(true, "CHECK DOCUMENT :COLUMN COUNT ", "PASSED",
                        " CHECK TABLE COLUMN COUNT" + " Input Value = "
                                + expectedValue);
            } else {
                reportresult(fail, "CHECK DOCUMENT :COLUMN COUNT", "FAILED", ""
                        + generateCustomError(customError)
                        + " System generated Error for : Expected :"
                        + inputStringRowCellArray.get(1) + " |Actual : "
                        + actualdValue);
                checkTrue(false, fail, "" + generateCustomError(customError)
                        + " System generated Error : Expected :"
                        + inputStringRowCellArray.get(1) + " |Actual : "
                        + actualdValue);

            }

        } catch (NullPointerException noe) {
            noe.printStackTrace();
            reportresult(fail, "CHECK DOCUMENT :COLUMN COUNT", "FAILED",
                    noe.getMessage());
            checkTrue(false, fail, noe.getMessage());

        } catch (Exception e) {

            e.printStackTrace();
            reportresult(fail, "CHECK DOCUMENT :COLUMN COUNT", "FAILED",
                    e.getMessage());
            checkTrue(false, fail, e.getMessage());
        }
        return actualdValue;

    }

    /**
     * Gets the document data table.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @return the document data table
     * @throws Exception
     *             the exception
     */
    private ArrayList<String> getDocumentDataTable(
            final String[][] arrExcelContent) throws Exception {
        String value = "";
        ArrayList<String> htmlTable = new ArrayList<String>();
        for (int i = 0; i < arrExcelContent.length; i++) {
            for (int j = 0; j < arrExcelContent[i].length; j++) {
                value = arrExcelContent[i][j];
                if (value != null) {
                    htmlTable.add(value);
                } else {
                    htmlTable.add("");
                }
            }
        }

        return htmlTable;

    }

    /**
     * Compare excel data.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param expectedvale
     *            the expectedvale
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     */
    private void compareExcelData(final String[][] arrExcelContent,
            final String expectedvale, final boolean fail,
            final Object[] customError) {
        ArrayList<String> htmlTable;
        ArrayList<String> inputTable;
        try {
            htmlTable = getDocumentDataTable(arrExcelContent);
            inputTable =
                    new ArrayList<String>(Arrays.asList(expectedvale
                            .split("(?<!\\\\),")));
            ArrayList<String> tempInputTable = new ArrayList<String>();
            for (String inputVal : inputTable) {
                String formattedValue = inputVal.replaceAll("\\\\,", ",");
                tempInputTable.add(formattedValue);
            }
            inputTable = tempInputTable;
            String inputTableStr = StringUtils.join(inputTable, "|");
            String actualTableStr = StringUtils.join(htmlTable, "|");
            if (actualTableStr.contains(inputTableStr)) {

                reportresult(true, "CHECK DOCUMENT :TABLE DATA ", "PASSED",
                        " :Input Value = " + expectedvale);

            } else {
                String inputTableString = inputTable.toString();
                String htmlTableString = htmlTable.toString();

                reportresult(fail, "CHECK DOCUMENT :TABLE DATA ", "FAILED", ""
                        + generateCustomError(customError)
                        + " System generated Error : "
                        + "'s  TABLEDATA is not as expected  "
                        + inputTableString + ": Actual :" + htmlTableString);
                checkTrue(false, fail, " System generated Error : "
                        + "'s  TABLEDATA is not as expected  "
                        + inputTableString + ": Actual :" + htmlTableString);

            }

        } catch (Exception e) {
            String errorString = e.getMessage();
            reportresult(fail, "CHECK DOCUMENT :TABLE DATA", "FAILED",
                    errorString);
            checkTrue(false, fail, errorString);
        }
    }

    /**
     * Validate excel offset.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param expectedvalue
     *            the expectedvalue
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @throws Exception
     *             the exception
     */
    private void validateExcelOffset(final String[][] arrExcelContent,
            final String expectedvalue, final boolean fail,
            final Object[] customError) throws Exception {
        ArrayList<String> inputStringArray = null;
        String parentText = "";
        Integer offset;
        String cellText = "";
        String inputStringCurrStr = "";
        String result = "";
        ArrayList<String> htmlTable;
        htmlTable = getDocumentDataTable(arrExcelContent);
        StringBuilder resultBuilder = new StringBuilder();
        ArrayList<String> inputStringCurrArray = null;
        inputStringArray =
                new ArrayList<String>(Arrays.asList(expectedvalue.split("#")));
        for (int i = 0; i < inputStringArray.size(); i++) {
            inputStringCurrStr = inputStringArray.get(i);

            inputStringCurrArray =
                    new ArrayList<String>(Arrays.asList(inputStringCurrStr
                            .split("(?<!\\\\),", Integer.MAX_VALUE)));

            ArrayList<String> tempInputTable = new ArrayList<String>();
            for (String inputVal : inputStringCurrArray) {
                String formattedValue = inputVal.replaceAll("\\\\,", ",");
                tempInputTable.add(formattedValue);
            }
            inputStringCurrArray = tempInputTable;

            parentText = inputStringCurrArray.get(0);
            offset = Integer.valueOf(inputStringCurrArray.get(1));
            cellText = inputStringCurrArray.get(2);
            resultBuilder
                    .append(checkIfTheTableContainsTheExpectedRelativeValue(
                            htmlTable, parentText, offset, cellText));
        }
        result = resultBuilder.toString();
        if (!result.isEmpty()) {

            reportresult(fail, "CHECK DOCUMENT :RELATIVE", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + "'s  RELATIVE validation "
                    + " is not as expected  " + result);
            checkTrue(false, fail, "" + "" + generateCustomError(customError)
                    + " System generated Error : " + ""
                    + "'s  RELATIVE validation "
                    + " is not as expected. Expected :  " + result);

        } else {

            reportresult(true, "CHECK DOCUMENT :RELATIVE", "PASSED", ""
                    + " . Input Value = " + expectedvalue);
        }

    }

    /**
     * Gets the document table row.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param row
     *            the row
     * @return the document table row
     * @throws Exception
     *             the exception
     */
    private ArrayList<String> getDocumentTableRow(
            final String[][] arrExcelContent, final int row) throws Exception {
        String value = "";
        ArrayList<String> htmlTable = new ArrayList<String>();
        for (int j = 0; j < arrExcelContent[row].length; j++) {
            value = arrExcelContent[row][j];
            if (value != null) {
                htmlTable.add(value);
            } else {
                htmlTable.add("");
            }
        }
        return htmlTable;

    }

    /**
     * Validate excel cell value.
     * 
     * @param arrExcelContent
     *            the arr excel content
     * @param expectedvalue
     *            the expectedvalue
     * @param fail
     *            the fail
     * @param customError
     *            the custom error
     * @throws Exception
     *             the exception
     */
    private void validateExcelCellValue(final String[][] arrExcelContent,
            final String expectedvalue, final boolean fail,
            final Object[] customError) throws Exception {

        ArrayList<String> inputStringArray;
        boolean failedOnce = false;
        int row = -1;
        int col = -1;
        String cellText = "";
        String result = "";
        String currentString = "";
        String verifyValue = "";
        ArrayList<String> htmlTable = new ArrayList<String>();
        final int inputStringItems = 3;
        inputStringArray =
                new ArrayList<String>(Arrays.asList(expectedvalue.split("#",
                        Integer.MAX_VALUE)));

        for (int i = 0; i < inputStringArray.size(); i++) {
            ArrayList<String> curStringArray;
            currentString = inputStringArray.get(i);
            curStringArray =
                    new ArrayList<String>(Arrays.asList(currentString.split(
                            "(?<!\\\\),", Integer.MAX_VALUE)));
            if (curStringArray.size() < inputStringItems) {
                failedOnce = true;
                break;
            } else {
                failedOnce = false;
            }
            row = Integer.parseInt(curStringArray.get(0));
            col = Integer.parseInt(curStringArray.get(1));
            cellText = curStringArray.get(2);

            try {
                htmlTable = getDocumentTableRow(arrExcelContent, row);
            } catch (Exception ex) {
                failedOnce = true;
                result =
                        result + "|Expected Row : " + row
                                + " cannot be found in the actual table \n";
            }

            int verifyIndex = col;

            try {
                verifyValue = htmlTable.get(verifyIndex).trim();
                if (!cellText.equals(verifyValue)) {
                    failedOnce = true;
                    result =
                            result + "|Expected : " + cellText + " Actual :"
                                    + htmlTable.get(verifyIndex) + "\n";
                    break;

                }

            } catch (IndexOutOfBoundsException ex) {
                failedOnce = true;
                StringBuilder buf = new StringBuilder();
                buf.append(result + "|Expected Column : " + verifyIndex);
                result =
                        buf.append(" cannot be found in the actual table \n")
                                .toString();
            }
        }
        if (failedOnce) {
            result = " verification data not provided correctly";
            reportresult(true, "CHECK DOCUMENT :TABLE CELL", "FAILED", ""
                    + generateCustomError(customError)
                    + " System generated Error : " + " CELL validation "
                    + " is not as expected. Actual: " + verifyValue
                    + " Expected: " + cellText + " " + result);
            checkTrue(false, fail, "" + "" + generateCustomError(customError)
                    + " System generated Error : " + "CELL validation "
                    + " is not as expected. Actual: " + verifyValue
                    + " Expected " + cellText);
            return;

        }

    }

    /**
     * Xml verify.
     * 
     * @param filePath
     *            the file path
     * @param verifyType
     *            the verify type
     * @param inputString
     *            the input string
     * @param stopOnFaliure
     *            the stop on faliure
     */
    private void xmlVerify(final String filePath, final String verifyType,
            final String inputString, final boolean stopOnFaliure) {
        String verifyCategory = verifyType;
        String verifySubCategory = "";
        if (verifyType.contains("|")) {
            String[] verifyTypeSeperate = verifyType.split("\\|");
            verifyCategory = verifyTypeSeperate[0];
            verifySubCategory = verifyTypeSeperate[1];
        }
        DocumentBuilderFactory docFactory =
                DocumentBuilderFactory.newInstance();
        if ("NODECOUNT".equalsIgnoreCase(verifyCategory)) {
            try {
                String[] inputStringSeperate = inputString.split("\\|");
                String nodeName = inputStringSeperate[0];
                String nodeCount = inputStringSeperate[1];
                String filepath = filePath;
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);
                NodeList list = doc.getElementsByTagName(nodeName);
                int numOfNodes = Integer.parseInt(nodeCount);
                int listLength = list.getLength();
                if (listLength == Integer.parseInt(nodeCount)) {
                    reportresult(true, "CHECK DOCUMENT - XML ["
                            + verifyCategory + "] :", "PASSED",
                            "CheckDocument command: Verified count as expected. Expected Count : "
                                    + numOfNodes);
                } else {
                    reportresult(true, "CHECK DOCUMENT - XML ["
                            + verifyCategory + "] :", "FAILED",
                            "CheckDocument command NODECOUNT : Node count for the node "
                                    + nodeName
                                    + " is incorrect. Expected count : "
                                    + numOfNodes + " Actual count : "
                                    + listLength);
                    checkTrue(false, stopOnFaliure,
                            "CheckDocument command NODECOUNT : Node count for the node "
                                    + nodeName
                                    + " is incorrect. Expected count : "
                                    + numOfNodes + " Actual count : "
                                    + listLength);
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
            } catch (SAXException e) {
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                reportresult(true, "CHECK DOCUMENT - XML [" + verifyCategory
                        + "] :", "FAILED",
                        "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                + e.getMessage());
                checkTrue(false, stopOnFaliure,
                        "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                + e.getMessage());
            }
        } else if ("NODEVALUE".equalsIgnoreCase(verifyCategory)) {
            try {
                String[] inputStringSeperate = inputString.split("\\|");
                String retriveXpath = inputStringSeperate[0];
                String expectedValue = inputStringSeperate[1]; // Setup the
                                                               // parser
                /*DocumentBuilderFactory builderFactory =
                        DocumentBuilderFactory.newInstance();*/
                DocumentBuilder builder = docFactory.newDocumentBuilder();
                // Read the XML file
                File inputFile = new File(filePath);
                InputStream inputStream = new FileInputStream(inputFile);
                // Parse the XML file
                Document doc = builder.parse(inputStream); // Create an XPath
                                                           // instance
                XPath xPath = XPathFactory.newInstance().newXPath(); // Evaluate
                                                                     // simple
                                                                     // expressions
                if ("EXACTNODE".equalsIgnoreCase(verifySubCategory)) {
                    String expression1 = retriveXpath;
                    String actualValue = xPath.evaluate(expression1, doc);
                    if (actualValue.equalsIgnoreCase(expectedValue)) {
                        reportresult(
                                true,
                                "CHECK DOCUMENT - XML [" + verifyCategory
                                        + "] :",
                                "PASSED",
                                "CheckDocument command NODEVALUE|EXACTNODE : "
                                        + "Verified value as expected. Expected value : "
                                        + expectedValue);
                    } else {
                        reportresult(
                                true,
                                "CHECK DOCUMENT - XML [" + verifyCategory
                                        + "] :",
                                "FAILED",
                                "CheckDocument command NODEVALUE|EXACTNODE : "
                                        + "Excpected value does not match the actual. "
                                        + "Expected value : " + expectedValue
                                        + " Actual Value : " + actualValue);
                        checkTrue(
                                false,
                                stopOnFaliure,
                                "CheckDocument command NODEVALUE|EXACTNODE : "
                                        + "Excpected value does not match the actual. "
                                        + "Expected value : " + expectedValue
                                        + " Actual Value : " + actualValue);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
            } catch (XPathExpressionException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot evaluate the given xpath. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot evaluate the given xpath. Actual error : "
                                + e.getMessage());
            } catch (SAXException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot read the given xml file. Actual error : "
                                + e.getMessage());
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - XML [" + verifyCategory + "] :",
                        "FAILED",
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT : Cannot parse the given xml file. Actual error : "
                                + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                reportresult(true, "CHECK DOCUMENT - XML [" + verifyCategory
                        + "] :", "FAILED",
                        "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                + e.getMessage());
                checkTrue(false, stopOnFaliure,
                        "CheckDocument command NODECOUNT : Execption occured. Actual error : "
                                + e.getMessage());
            }
        }
    }

    /**
     * Text file verify.
     * 
     * @param filePath
     *            the file path
     * @param verifyType
     *            the verify type
     * @param inputString
     *            the input string
     * @param stopOnFaliure
     *            the stop on faliure
     */
    private void textFileVerify(final String filePath, final String verifyType,
            final String inputString, final boolean stopOnFaliure) {

        if ("EXISTS".equalsIgnoreCase(verifyType)) {

            String[] inputStringSeperate = inputString.split("\\|");
            String expectedValue = inputStringSeperate[0];

            try {
                List<String> lines = readTextFile(filePath);
                if (lines.toString().contains(expectedValue)) {
                    reportresult(
                            true,
                            "CHECK DOCUMENT - TEXT [" + verifyType + "] :",
                            "PASSED",
                            "CheckDocument command TEXT : TEXTCONTENT : "
                                    + "Verified value as expected. Expected value : "
                                    + expectedValue);
                } else {
                    reportresult(
                            true,
                            "CHECK DOCUMENT - TEXT [" + verifyType + "] :",
                            "FAILED",
                            "CheckDocument command TEXTCONTENT : "
                                    + "Excpected value cannot be found in the file. "
                                    + "Expected value : " + expectedValue);
                    checkTrue(
                            false,
                            stopOnFaliure,
                            "CheckDocument command TEXTCONTENT : "
                                    + "Excpected value cannot be found in the file. "
                                    + "Expected value : " + expectedValue);
                }
            } catch (IOException e) {
                e.printStackTrace();
                reportresult(
                        true,
                        "CHECK DOCUMENT - TEXT [" + verifyType + "] :",
                        "FAILED",
                        "CheckDocument command TEXTCONTENT : "
                                + "Cannot read the given xml file. Actual error : "
                                + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command TEXTCONTENT : "
                                + "Cannot read the given xml file. Actual error : "
                                + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                reportresult(true, "CHECK DOCUMENT - TEXT [" + verifyType
                        + "] :", "FAILED", "CheckDocument command NODECOUNT : "
                        + "Execption occured. Actual error : " + e.getMessage());
                checkTrue(
                        false,
                        stopOnFaliure,
                        "CheckDocument command NODECOUNT :"
                                + " Execption occured. Actual error : "
                                + e.getMessage());
            }
        }
    }

    /**
     * Read text file.
     * 
     * @param filePath
     *            the file path
     * @return the list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private List<String> readTextFile(final String filePath) throws IOException {

        BufferedReader br = null;
        List<String> lines = new ArrayList<String>();
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(filePath));

            while ((sCurrentLine = br.readLine()) != null) {
                lines.add(sCurrentLine);
            }

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lines;
    }

    public void sendEmail(final String to, final String cc,
            final String subject, final String text) {

        String toAddress = checkNullObject(to, "SEND EMAIL");
        String msgText = checkNullObject(text, "SEND EMAIL");
        String ccText = checkNullObject(cc, "SEND EMAIL");
        sendEmailMessage(toAddress, ccText, subject, msgText);

    }

    private void sendEmailMessage(String to, String cc, String subject,
            String text) {

        PropertyHandler propHandler = new PropertyHandler("runtime.properties");
        String host = propHandler.getRuntimeProperty("SMTP_HOST");
        String port = propHandler.getRuntimeProperty("SMTP_PORT");
        final String username = propHandler.getRuntimeProperty("SMTP_USER");
        final String password = propHandler.getRuntimeProperty("SMTP_PASSWORD");
        String ssl = propHandler.getRuntimeProperty("SMTP_SSL");

        host = checkNullObject(host, "SEND EMAIL");
        port = checkNullObject(port, "SEND EMAIL");
        final String checkedUsername = checkNullObject(username, "SEND EMAIL");
        final String checkedpassword = checkNullObject(password, "SEND EMAIL");
        ssl = checkNullObject(ssl, "SEND EMAIL");

        Properties props = new Properties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", port);

        if (ssl.equals("true")) {
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
        }

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        Session session =
                Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(
                                        checkedUsername, checkedpassword);
                            }
                        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(checkedUsername));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    to));
            if (!cc.isEmpty()) {
                message.addRecipient(Message.RecipientType.CC,
                        new InternetAddress(cc));
            }
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (MessagingException e) {
            getLog().error(e);
            e.printStackTrace();

            reportresult(true, "SEND EMAIL :" + subject + "", "FAILED",
                    "SEND EMAIL command failed with the following error. Actrual Error : "
                            + e.getMessage());
            checkTrue(false, false,
                    "SEND EMAIL command failed with the following error. Actrual Error : "
                            + e.getMessage());
        }

    }
    public final void closeWindow() {

        try {
            WebDriver driver = getDriver();
            driver.close();
            reportresult(true, "CLOSE WINDOW :",
                    "PASSED", "Closed current Window");
        } catch (Exception e) {
            e.printStackTrace();
            reportresult(true, "CLOSE WINDOW :", "FAILED",
                    "Faild to Close current Window");

            checkTrue(false, true, "Faild to Close current Window");
            
        }
    }


}
