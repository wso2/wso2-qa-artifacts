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

package com.virtusa.isq.vtaf.objectmap;

/**
 * The Class ObjectLocator.
 */
public class ObjectLocator {

    /** The logical name. */
    private String logicalName;

    /** The identifier. */
    private String identifier;

    /** The actual locator. */
    private String actualLocator;

    /**
     * Instantiates a new object locator.
     * 
     * @param logicalNameString
     *            the logical name
     * @param identifierString
     *            the identifier
     * @param actualLocatorString
     *            the actual locator
     */
    public ObjectLocator(final String logicalNameString,
            final String identifierString, final String actualLocatorString) {
        this.logicalName = logicalNameString;
        this.identifier = identifierString;
        this.actualLocator = actualLocatorString;
    }

    /**
     * Gets the logical name.
     * 
     * @return the logical name
     */
    public final String getLogicalName() {
        return logicalName;
    }

    /**
     * Gets the identifier.
     * 
     * @return the identifier
     */
    public final String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier.
     * 
     * @param identifierValue
     *            the new identifier
     */
    public final void setIdentifier(final String identifierValue) {
        this.identifier = identifierValue;
    }

    /**
     * Gets the actual locator.
     * 
     * @return the actual locator
     */
    public final String getActualLocator() {
        return actualLocator;
    }

    /**
     * Sets the actual locator.
     * 
     * @param actualLocatorString
     *            the new actual locator
     */
    public final void setActualLocator(final String actualLocatorString) {
        this.actualLocator = actualLocatorString;
    }

}
