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
import java.util.List;


/**
 * The Class TestExecution.
 */
public class TestExecution {

    /** The user. */
    private String user;

    /** The host. */
    private String host;

    /** The osversion. */
    private String osversion;

    /** The language. */
    private String language;

    /** The screenresolution. */
    private String screenresolution;

    /** The timestamp. */
    private String timestamp;

    /** The result. */
    private String result;

    /** The duration. */
    private String duration;

    /** The type. */
    private String type;

    /** The totalerrorcount. */
    private int totalerrorcount;

    /** The totalwarningcount. */
    private int totalwarningcount;

    /** The totalsuccesscount. */
    private int totalsuccesscount;

    /** The totalfailedcount. */
    private int totalfailedcount;

    /** The totalblockedcount. */
    private int totalblockedcount;

    /** The test suites. */
    private ArrayList<TestSuite> testSuites;

    /**
     * Constructs the TestExecution Object.
     * 
     * @param userName
     *            the user name
     * @param hostName
     *            the host name
     * @param osVersion
     *            the os version
     * @param execLanguage
     *            the exec language
     * @param screenResolution
     *            the screen resolution
     * @param timeStamp
     *            the time stamp
     * @param execDuration
     *            the exec duration
     */
    public TestExecution(final String userName, final String hostName,
            final String osVersion, final String execLanguage,
            final String screenResolution, final String timeStamp,
            final String execDuration) {
        super();
        this.user = userName;
        this.host = hostName;
        this.osversion = osVersion;
        this.language = execLanguage;
        this.screenresolution = screenResolution;
        this.timestamp = timeStamp;
        this.result = "Success";
        this.duration = execDuration;
        this.type = "root";
        this.totalerrorcount = 0;
        this.totalwarningcount = 0;
        this.totalsuccesscount = 0;
        this.totalfailedcount = 0;
        this.totalblockedcount = 0;

        testSuites = new ArrayList<TestSuite>();
    }

    /**
     * Gets the user.
     * 
     * @return the user
     */
    public final String getUser() {
        return user;
    }

    /**
     * Gets the host.
     * 
     * @return the host
     */
    public final String getHost() {
        return host;
    }

    /**
     * Gets the osversion.
     * 
     * @return the osversion
     */
    public final String getOsversion() {
        return osversion;
    }

    /**
     * Gets the language.
     * 
     * @return the language
     */
    public final String getLanguage() {
        return language;
    }

    /**
     * Gets the screenresolution.
     * 
     * @return the screenresolution
     */
    public final String getScreenresolution() {
        return screenresolution;
    }

    /**
     * Gets the timestamp.
     * 
     * @return the timestamp
     */
    public final String getTimestamp() {
        return timestamp;
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
     * Gets the totalerrorcount.
     * 
     * @return the totalerrorcount
     */
    public final int getTotalerrorcount() {
        return totalerrorcount;
    }

    /**
     * Gets the totalwarningcount.
     * 
     * @return the totalwarningcount
     */
    public final int getTotalwarningcount() {
        return totalwarningcount;
    }

    /**
     * Gets the totalsuccesscount.
     * 
     * @return the totalsuccesscount
     */
    public final int getTotalsuccesscount() {
        return totalsuccesscount;
    }

    /**
     * Gets the totalfailedcount.
     * 
     * @return the totalfailedcount
     */
    public final int getTotalfailedcount() {
        return totalfailedcount;
    }

    /**
     * Gets the totalblockedcount.
     * 
     * @return the totalblockedcount
     */
    public final int getTotalblockedcount() {
        return totalblockedcount;
    }

    /**
     * Gets the test suites.
     * 
     * @return the test suites
     */
    public final List<TestSuite> getTestSuites() {
        return testSuites;
    }

    /**
     * Sets the totalerrorcount.
     * 
     * @param totalErrorCount
     *            the new totalerrorcount
     */
    public final void setTotalerrorcount(final int totalErrorCount) {

        this.totalerrorcount += totalErrorCount;
    }

    /**
     * Sets the totalwarningcount.
     * 
     * @param totalWarningCount
     *            the new totalwarningcount
     */
    public final void setTotalwarningcount(final int totalWarningCount) {
        this.totalwarningcount += totalWarningCount;
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
    
    /**
     * Sets the totalsuccesscount.
     * 
     * @param totalSuccessCount
     *            the new totalsuccesscount
     */
    public final void setTotalsuccesscount(final int totalSuccessCount) {
        this.totalsuccesscount += totalSuccessCount;
    }

    /**
     * Sets the totalfailedcount.
     * 
     * @param totalFailedCount
     *            the new totalfailedcount
     */
    public final void setTotalfailedcount(final int totalFailedCount) {
        this.totalfailedcount += totalFailedCount;
    }

    /**
     * Sets the totalblockedcount.
     * 
     * @param totalBlockedCount
     *            the new totalblockedcount
     */
    public final void setTotalblockedcount(final int totalBlockedCount) {
        this.totalblockedcount += totalBlockedCount;
    }

}
