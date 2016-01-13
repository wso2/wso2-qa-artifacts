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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.IResultListener;

/**
 * The Class ScreenshotListenerVir.
 */
public class ScreenshotListenerVir implements IResultListener {

    /** The output directory. */
    private File outputDirectory;

    /**
     * Gets the output directory.
     * 
     * @return the output directory
     */
    public final File getoutputDirectory() {
        return this.outputDirectory;
    }

    /**
     * Sets the output directory.
     * 
     * @param value
     *            the new output directory
     */
    public final void setoutputDirectory(final File value) {
        this.outputDirectory = value;
    }

    /** The driver. */
    private WebDriver driver;

    /**
     * Instantiates a new screenshot listener vir.
     * 
     * @return the driver
     */

    public final WebDriver getDriver() {
        return this.driver;
    }

    /**
     * Sets the driver.
     * 
     * @param value
     *            the new driver
     */
    public final void setDriver(final WebDriver value) {
        this.driver = value;
    }

    /**
     * Instantiates a new screenshot listener vir.
     * 
     * @param outputDirectoryFile
     *            the output directory File
     * @param webDriver
     *            the driver
     */
    public ScreenshotListenerVir(final File outputDirectoryFile,
            final WebDriver webDriver) {
        this.outputDirectory = outputDirectoryFile;
        // this.selenium = selenium;
        this.driver = webDriver;
    }

    /**
     * On test failure.
     * 
     * result the result
     * 
     * @param result
     *            the result
     * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
     */
    @Override
    public final void onTestFailure(final ITestResult result) {
        Reporter.setCurrentTestResult(result);

        try {

            if (outputDirectory.mkdirs()) {
                String fileloc = getProperties();
                File scrFile =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(fileloc + ".png"));
                Reporter.log("<a href='" + fileloc + ".png'>screenshot</a>");
            } else {
                System.err.println("Creation of directory failed "
                        + outputDirectory.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Couldn't create screenshot");
            Reporter.log(e.getMessage());
        }

        Reporter.setCurrentTestResult(null);
    }

    /**
     * Gets the properties.
     * 
     * @return the properties
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private static String getProperties() throws IOException {
        Properties props = new Properties();
        File file = new File("");
        String absPath = file.getAbsolutePath();
        if ((absPath.indexOf("grid") > -1)) {
            absPath =
                    absPath + File.separator + "grid" + File.separator
                            + "selenium-grid-1.0.6";
        }
        String fileName = "";
        FileInputStream fis = null;
        try {
            fis =
                    new FileInputStream(new File(absPath + File.separator
                            + "project.properties"));
            props.load(fis);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        fileName = props.getProperty("currentScreenShot");

        props.clear();

        return fileName;
    }

    /**
     * On configuration failure.
     * 
     * @param result
     *            the result
     * @see org.testng.IConfigurationListener#onConfigurationFailure(org.testng.ITestResult)
     */
    @Override
    public final void onConfigurationFailure(final ITestResult result) {
        onTestFailure(result);
    }

    /**
     * (non-Javadoc).
     * 
     * @param context
     *            the context
     * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
     */
    @Override
    public void onFinish(final ITestContext context) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param context
     *            the context
     * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
     */
    @Override
    public final void onStart(final ITestContext context) {
        outputDirectory = new File(context.getOutputDirectory());
    }

    /**
     * (non-Javadoc).
     * 
     * @param result
     *            the result
     * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param result
     *            the result
     * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
     */
    @Override
    public void onTestSkipped(final ITestResult result) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param result
     *            the result
     * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
     */
    @Override
    public void onTestStart(final ITestResult result) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param result
     *            the result
     * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
     */
    @Override
    public void onTestSuccess(final ITestResult result) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param itr
     *            the itr
     * @see org.testng.IConfigurationListener#onConfigurationSuccess(org.testng.ITestResult)
     */
    @Override
    public void onConfigurationSuccess(final ITestResult itr) {
    }

    /**
     * (non-Javadoc).
     * 
     * @param itr
     *            the itr
     * @see org.testng.IConfigurationListener#onConfigurationSkip(org.testng.ITestResult)
     */
    @Override
    public void onConfigurationSkip(final ITestResult itr) {
    }
}
