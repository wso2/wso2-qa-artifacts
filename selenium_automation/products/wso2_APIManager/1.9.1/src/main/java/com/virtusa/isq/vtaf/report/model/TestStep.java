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

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The Class TestStep.
 */
public class TestStep {

    /** The time. */
    private String time;

    /** The category. */
    private String category;

    /** The errimg. */
    private String errimg;

    /** The errthumb. */
    private String errthumb;

    /** The message. */
    private String message;

    /** The stacktrace. */
    private String stacktrace;

    /** The codefile. */
    private String codefile;

    /** The codeline. */
    private String codeline;

    /** The loglvl. */
    private String loglvl;

    /** The is passed. */
    private boolean isPassed;
    
    /** The is screen shot. */
    private boolean isScreenShot;

    /**
     * Success Test Step.
     * 
     * @param ispassed
     *            the ispassed
     * @param execTime
     *            the exec time
     * @param stepCategory
     *            the step category
     * @param stepMessage
     *            the step message
     * @param loglevel
     *            the loglevel
     */
    public TestStep(final boolean ispassed, final String execTime,
            final String stepCategory, final String stepMessage,
            final String loglevel) {
        super();
        this.isPassed = ispassed;
        this.time = execTime;
        this.category = stepCategory;
        this.message = stepMessage;
        this.codefile = "UNKNOWN";
        this.codeline = "UNKNOWN";
        this.loglvl = loglevel;
    }

    /**
     * Failed Test Step.
     * 
     * @param ispassed
     *            the ispassed
     * @param stepCategory
     *            the step category
     * @param errImg
     *            the err img
     * @param errThumb
     *            the err thumb
     * @param stepMessage
     *            the step message
     * @param stackTrace
     *            the stack trace
     * @param loglevel
     *            the loglevel
     */
    public TestStep(final boolean ispassed, final String stepCategory,
            final String errImg, final String errThumb,
            final String stepMessage, final String stackTrace,
            final String loglevel) {
        super();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss");
        this.isPassed = ispassed;
        this.time = sdf.format(date);
        this.category = stepCategory;
        this.errimg = errImg;
        this.errthumb = errThumb;
        this.message = stepMessage;
        this.stacktrace = stackTrace;
        this.codefile = "UNKNOWN";
        this.codeline = "UNKNOWN";
        this.loglvl = loglevel;
    }

    /**
     * Checks if is passed.
     * 
     * @return true, if is passed
     */
    public final boolean isPassed() {
        return isPassed;
    }
    
    /**
     * Checks if is screen shot.
     *
     * @return true, if is screen shot
     */
    public final boolean isScreenShot() {
        if (!("SCREENSHOT ".equals(this.getCategory()))) {
            return isScreenShot;
        }
        isScreenShot = true;
        return isScreenShot;
    }

    /**
     * Gets the time.
     * 
     * @return the time
     */
    public final String getTime() {
        return time;
    }

    /**
     * Gets the category.
     * 
     * @return the category
     */
    public final String getCategory() {
        return category;
    }

    /**
     * Gets the errimg.
     * 
     * @return the errimg
     */
    public final String getErrimg() {
        return errimg;
    }

    /**
     * Gets the errthumb.
     * 
     * @return the errthumb
     */
    public final String getErrthumb() {
        return errthumb;
    }

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public final String getMessage() {
        return message;
    }

    /**
     * Gets the stacktrace.
     * 
     * @return the stacktrace
     */
    public final String getStacktrace() {
        return stacktrace;
    }

    /**
     * Gets the codefile.
     * 
     * @return the codefile
     */
    public final String getCodefile() {
        return codefile;
    }

    /**
     * Gets the codeline.
     * 
     * @return the codeline
     */
    public final String getCodeline() {
        return codeline;
    }

    /**
     * Gets the loglvl.
     * 
     * @return the loglvl
     */
    public final String getLoglvl() {
        return loglvl;
    }

}
