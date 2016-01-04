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

package com.virtusa.isq.vtaf.report.model;

import java.util.ArrayList;

/**
 * The Class TestSuite.
 */
public class TestSuite {

    /** The testsuitename. */
    private String testsuitename;

    /** The iterationcount. */
    private String iterationcount;

    /** The maxchildren. */
    private String maxchildren;

    /** The result. */
    private String result;

    /** The duration. */
    private String duration;

    /** The type. */
    private String type;

    /** The rid. */
    private String rid;

    /** The test cases. */
    private ArrayList<TestCase> testCases;

    /**
     * Instantiates a new test suite.
     * 
     * @param testCaseName
     *            the test case name
     * @param iterationCount
     *            the iteration count
     * @param maxChildren
     *            the max children
     * @param execDuration
     *            the exec duration
     * @param suiteType
     *            the suite type
     * @param rId
     *            the r id
     */
    public TestSuite(final String testCaseName, final String iterationCount,
            final String maxChildren, final String execDuration,
            final String suiteType, final String rId) {
        super();
        this.testsuitename = testCaseName;
        this.iterationcount = iterationCount;
        this.maxchildren = maxChildren;
        this.result = "Success";
        this.duration = execDuration;
        this.type = suiteType;
        this.rid = rId;

        testCases = new ArrayList<TestCase>();
    }

    /**
     * Gets the testsuitename.
     * 
     * @return the testsuitename
     */
    public final String getTestsuitename() {
        return testsuitename;
    }

    /**
     * Gets the iterationcount.
     * 
     * @return the iterationcount
     */
    public final String getIterationcount() {
        return iterationcount;
    }

    /**
     * Gets the maxchildren.
     * 
     * @return the maxchildren
     */
    public final String getMaxchildren() {
        return maxchildren;
    }

    /**
     * Gets the result.
     * 
     * @return the result
     */
    public final String getResult() {
        return result;
    }

    /**
     * Gets the duration.
     * 
     * @return the duration
     */
    public final String getDuration() {
        return duration;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * Gets the rid.
     * 
     * @return the rid
     */
    public final String getRid() {
        return rid;
    }

    /**
     * Gets the test cases.
     * 
     * @return the test cases
     */
    public final ArrayList<TestCase> getTestCases() {
        return testCases;
    }

    /**
     * Sets the result.
     * 
     * @param tsResult
     *            the new result
     */
    public final void setResult(final String tsResult) {
        this.result = tsResult;
    }

    /**
     * Sets the totaltime.
     * 
     * @param totalTime
     *            the new totaltime
     */
    public final void setTotaltime(final String totalTime) {
        this.duration = totalTime;
    }

}
