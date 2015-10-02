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
 * The Class TestCase.
 */
public class TestCase {

    /** The modulename. */
    private String modulename;

    /** The moduletype. */
    private String moduletype;

    /** The result. */
    private String result;

    /** The duration. */
    private String duration;

    /** The type. */
    private String type;

    /** The rid. */
    private String rid;

    /** The test case id. */
    private int testCaseId;

    /** The test steps. */
    private ArrayList<TestStep> testSteps;

    /**
     * Instantiates a new test case.
     * 
     * @param moduleName
     *            the modulename
     * @param timeDuration
     *            the time duration
     * @param ridNo
     *            the rid no
     * @param testCaseid
     *            the test caseid
     */
    public TestCase(final String moduleName, final String timeDuration,
            final String ridNo, final int testCaseid) {
        super();
        this.modulename = moduleName;
        this.moduletype = "UserCode";
        this.result = "Success";
        this.duration = timeDuration;
        this.type = "test module";
        this.rid = ridNo;
        this.testCaseId = testCaseid;
        testSteps = new ArrayList<TestStep>();
    }

    /**
     * Gets the modulename.
     * 
     * @return the modulename
     */
    public final String getModulename() {
        return modulename;
    }

    /**
     * Gets the moduletype.
     * 
     * @return the moduletype
     */
    public final String getModuletype() {
        return moduletype;
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
     * Sets the result.
     * 
     * @param tcResult
     *            the new result
     */
    public final void setResult(final String tcResult) {
        this.result = tcResult;
    }

    /**
     * Gets the test case id.
     * 
     * @return the test case id
     */
    public final int getTestCaseId() {
        return testCaseId;
    }

    /**
     * Gets the testSteps.
     * 
     * @return the testSteps
     */
    public final ArrayList<TestStep> getTestSteps() {
        return this.testSteps;
    }
}
