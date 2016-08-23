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

package com.virtusa.isq.vtaf.runtime;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;


/**
 * The listener interface for receiving VTAFTest events. The class that is
 * interested in processing a VTAFTest event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addVTAFTestListener</code> method. When the VTAFTest event
 * occurs, that object's appropriate method is invoked.
 * 
 * @see VTAFTestEvent
 */
public class VTAFTestListener implements IInvokedMethodListener {



    /** The browser. */
    private static String browser = "";

    /** The data iteration. */
    private int dataIteration = 0;

    /** The tables. */
    private HashMap<String, DataTable> tables = null;

    /** The table headers. */
    private List<String> tableHeaders = new ArrayList<String>();

    /** The prev data provider. */
    private String prevDataProvider = "";

    // @Override
    /**
     * On test failure.
     * 
     * @param tr
     *            the tr
     */
    public final void onTestFailure(final ITestResult tr) {

        endTestReporting("skipped");

    }

    // @Override

    /**
     * On test skipped.
     * 
     * @param tr
     *            the tr
     */
    public final void onTestSkipped(final ITestResult tr) {

        endTestReporting("failed");

    }

    // @Override
    /**
     * On test success.
     * 
     * @param tr
     *            the tr
     */
    public final void onTestSuccess(final ITestResult tr) {

        endTestReporting("passed");

    }

    /**
     * End test reporting.
     * 
     * @param testFailed
     *            the test failed
     */
    public void endTestReporting(final String testFailed) {

        // reporter.endResultReporting(testFailed);

    }

    /**
     * After invocation.
     * 
     * @param method
     *            the method
     * @param result
     *            the result
     * @see org.testng.IInvokedMethodListener#afterInvocation(org.testng.IInvokedMethod,
     *      org.testng.ITestResult)
     */
    @Override
    public final void afterInvocation(final IInvokedMethod method,
            final ITestResult result) {
        if (method.isTestMethod()) {
            if (result.getStatus() == ITestResult.SKIP) {
                endTestReporting("skipped");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                endTestReporting("failed");
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                endTestReporting("passed");
            }

        }

    }

    /**
     * Before invocation.
     * 
     * @param methodtest
     *            the methodtest
     * @param result
     *            the result
     * @see org.testng.IInvokedMethodListener#beforeInvocation(org.testng.IInvokedMethod,
     *      org.testng.ITestResult)
     */
    @Override
    public final void beforeInvocation(final IInvokedMethod methodtest,
            final ITestResult result) {

        if (methodtest.isTestMethod()) {

            String dataProvider = "";

            Method method =
                    methodtest.getTestMethod().getConstructorOrMethod()
                            .getMethod();
            Annotation[] testAnnot = method.getAnnotations();
            for (Annotation annot : testAnnot) {

                if (annot instanceof Test) {

                    Test tAnnot = (Test) annot;
                    dataProvider = tAnnot.dataProvider();
                    if ("".equalsIgnoreCase(prevDataProvider)
                            || !(prevDataProvider
                                    .equalsIgnoreCase(dataProvider))) {
                        dataIteration = 0;
                        prevDataProvider = dataProvider;

                    }

                }

            }

            dataIteration++;

        }

    }

    /**
     * Gets the data tabale.
     * 
     * @param tableName
     *            the table name
     * @return the data tabale
     */
    public final Object[][] getDataTabale(final String tableName) {
        DataTable table = getTable(tableName);

        return this.getTableArray(table);
    }

    /**
     * Gets the data tabale meta.
     * 
     * @param tableName
     *            the table name
     * @return the data tabale meta
     */
    public final Object[][] getDataTabaleMeta(final String tableName) {
        DataTable table = getTableMeta(tableName);
        tableHeaders = table.getColumns();
        return this.getTableArray(table);
    }

    /**
     * Retrieve the data table for the parameterized execution.
     * 
     * @param name
     *            the name
     * @return the table
     */
    public final DataTable getTable(final String name) {
        File file;
        if (tables == null) {
            File tempFile = new File("tempFile");
            if (tempFile.getAbsolutePath().contains("grid")) {
                file =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "data" + File.separator + "DataTables.xml");
            } else {
                file =
                        new File("grid" + File.separator
                                + "selenium-grid-1.0.6" + File.separator
                                + "data" + File.separator + "DataTables.xml");
            }
            tables = DataTablesParser.parseTables(file);
        }
        return tables.get(name);
    }

    /**
     * Retrieve the data table for the parameterized execution.
     * 
     * @param name
     *            the name
     * @return the table meta
     */
    public final DataTable getTableMeta(final String name) {
        File file;
        if (tables == null) {
            File tempFile = new File("tempFile");
            if (tempFile.getAbsolutePath().contains("grid")) {

                file =
                        new File("grid" + File.separator
                                + "selenium-grid-1.0.6" + File.separator
                                + "data" + File.separator + "DataTables.xml");
            } else {

                file =
                        new File("src" + File.separator + "main"
                                + File.separator + "resources" + File.separator
                                + "data" + File.separator + "DataTables.xml");
            }
            tables = MetaDataTablesParser.parseTables(file);
        }
        return tables.get(name);
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
                tabArray[row][col] = table.get(row, col);
            }
        }

        return tabArray;

    }

    
    /**
     * @return the browser
     */
    public static final String getBrowser() {
        return browser;
    }

    /**
     * @param browserString
     *            the browser to set
     */
    public static final void setBrowser(final String browserString) {
        VTAFTestListener.browser = browserString;
    }

    /**
     * @return the dataIteration
     */
    public final int getDataIteration() {
        return dataIteration;
    }

    /**
     * @param dataIterationNumber
     *            the dataIteration to set
     */
    public final void setDataIteration(final int dataIterationNumber) {
        this.dataIteration = dataIterationNumber;
    }

    /**
     * @return the tables
     */
    public final HashMap<String, DataTable> getTables() {
        return tables;
    }

    /**
     * @param tablesMap
     *            the tables to set
     */
    public final void setTables(final HashMap<String, DataTable> tablesMap) {
        this.tables = tablesMap;
    }

    /**
     * @return the tableHeaders
     */
    public final List<String> getTableHeaders() {
        return tableHeaders;
    }

    /**
     * @param tableHeadersList
     *            the tableHeaders to set
     */
    public final void setTableHeaders(final List<String> tableHeadersList) {
        this.tableHeaders = tableHeadersList;
    }

    /**
     * @return the prevDataProvider
     */
    public final String getPrevDataProvider() {
        return prevDataProvider;
    }

    /**
     * @param prevDataProviderString
     *            the prevDataProvider to set
     */
    public final void setPrevDataProvider(final String prevDataProviderString) {
        this.prevDataProvider = prevDataProviderString;
    }

}
