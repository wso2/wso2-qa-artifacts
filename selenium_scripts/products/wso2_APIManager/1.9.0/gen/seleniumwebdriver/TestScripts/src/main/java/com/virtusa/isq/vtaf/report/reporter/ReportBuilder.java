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

package com.virtusa.isq.vtaf.report.reporter;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.virtusa.isq.vtaf.report.model.TestCase;
import com.virtusa.isq.vtaf.report.model.TestExecution;
import com.virtusa.isq.vtaf.report.model.TestStep;
import com.virtusa.isq.vtaf.report.model.TestSuite;

/**
 * The Class ReportBuilder.
 */
public class ReportBuilder {

    /** The test case. */
    private TestCase testCase = null;

    /** The test suite. */
    private TestSuite testSuite = null;

    /** The test execution. */
    private TestExecution testExecution = null;

    /** The report folder location. */
    private String reportFolderLocation;

    /** The rid. */
    private int rid;

    /** The unique test case id. */
    private int uniqueTestCaseId;

    /** The reported test cases. */
    private Set<Integer> reportedTestCases;

    /**
     * Instantiates a new report builder.
     * 
     * @param reportFolderLoc
     *            the report folder loc
     */
    public ReportBuilder(final String reportFolderLoc) {

        this.reportFolderLocation = reportFolderLoc;
        rid = 0;
        uniqueTestCaseId = 0;
        reportedTestCases = new LinkedHashSet<Integer>();
    }

    /**
     * Gets the report folder location.
     * 
     * @return the report folder location
     */
    public final String getReportFolderLocation() {
        return this.reportFolderLocation;
    }

    /**
     * Adds the new test case.
     * 
     * @param modulename
     *            the modulename
     * @param execDuration
     *            the exec duration
     */
    public final void addNewTestCase(final String modulename,
            final String execDuration) {

        String rId = getRid();
        testCase =
                new TestCase(modulename, execDuration, rId,
                        getUniqueTestCaseId());
        testSuite.getTestCases().add(testCase);
    }

    /**
     * Adds the new test suite.
     * 
     * @param testSuiteName
     *            the test suite name
     * @param duration
     *            the duration
     */
    public final void addNewTestSuite(final String testSuiteName,
            final String duration) {
        String iterationcount = "1";
        String maxchildren = "0";
        String type = "folder";
        String rId = getRid();

        testSuite =
                new TestSuite(testSuiteName, iterationcount, maxchildren,
                        duration, type, rId);

        testExecution.getTestSuites().add(testSuite);

    }

    /**
     * Adds the new test execution.
     */
    public final void addNewTestExecution() {

        String host = "UNKNOWN";
        String user = "UNKNOWN";
        String osversion = "UNKNOWN";
        String language = "EN-US";
        String screenresolution = "UNKNOWN";
        String timestamp = "UNKNOWN";
        String duration = "UNKNOWN";

        try {
            user = System.getProperty("user.name");
            host = InetAddress.getLoopbackAddress().getHostName();
            osversion = System.getProperty("os.version");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            screenresolution = screenSize.width + "X" + screenSize.height;

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
            timestamp = sdf.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }

        testExecution =
                new TestExecution(user, host, osversion, language,
                        screenresolution, timestamp, duration);

    }

    /**
     * Adds the new test step.
     * 
     * @param isPassed
     *            the is passed
     * @param category
     *            the category
     * @param message
     *            the message
     * @param loglvl
     *            the loglvl
     */
    public final void addNewTestStep(final boolean isPassed,
            final String category, final String message, final String loglvl) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss");
        String time = sdf.format(date);

        TestStep testStep =
                new TestStep(isPassed, time, category, message, loglvl);

        testCase.getTestSteps().add(testStep);

    }

    /**
     * Adds the new test step.
     * 
     * @param isPassed
     *            the is passed
     * @param category
     *            the category
     * @param errimg
     *            the errimg
     * @param errthumb
     *            the errthumb
     * @param message
     *            the message
     * @param stacktrace
     *            the stacktrace
     * @param loglvl
     *            the loglvl
     */
    public final void addNewTestStep(final boolean isPassed,
            final String category, final String errimg, final String errthumb,
            final String message, final String stacktrace, final String loglvl) {

        TestStep testStep =
                new TestStep(isPassed, category, errimg, errthumb, message,
                        stacktrace, loglvl);

        testCase.getTestSteps().add(testStep);

        if (!isPassed) {
            testCase.setResult("Failed");
            testSuite.setResult("Failed");
        }
    }

    /**
     * Sets the execution summary.
     */
    public final void setExecutionSummary() {

        for (TestSuite ts : testExecution.getTestSuites()) {
            for (TestCase tc : ts.getTestCases()) {
                int tcId = tc.getTestCaseId();
                if (!reportedTestCases.contains(tcId)) {
                    reportedTestCases.add(tcId);
                    if ("Failed".equals(tc.getResult())) {
                        testExecution.setTotalfailedcount(1);
                        testExecution.setTotalerrorcount(1);
                    } else if ("Success".equals(tc.getResult())) {
                        testExecution.setTotalsuccesscount(1);
                    }
                }
            }
        }

        System.out.println("Report created successfully to the folder "
                + getReportFolderLocation());
    }

    /**
     * Gets the test execution.
     * 
     * @return the test execution
     */
    public final TestExecution getTestExecution() {
        return testExecution;
    }

    /**
     * Gets the rid.
     * 
     * @return the rid
     */
    public final String getRid() {
        rid++;
        return String.valueOf(rid);
    }

    /**
     * Gets the unique test case id.
     * 
     * @return the unique test case id
     */
    public final int getUniqueTestCaseId() {
        return uniqueTestCaseId++;
    }

}
