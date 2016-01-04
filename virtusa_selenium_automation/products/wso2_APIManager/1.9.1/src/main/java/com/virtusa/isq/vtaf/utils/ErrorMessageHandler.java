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

package com.virtusa.isq.vtaf.utils;

/*
 * 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ErrorMessageHandler.
 */
public class ErrorMessageHandler {

    /** The error message pool. */
    private Map<String, String> errorMessagePool;

    /**
     * Instantiates a new error message handler.
     */
    public ErrorMessageHandler() {
        init();
    }

    /**
     * Inits the object.
     */
    private void init() {
        initErrorMessages();
    }

    /**
     * Inits the error messages.
     */
    private void initErrorMessages() {
        errorMessagePool = new HashMap<String, String>();

        errorMessagePool.put("Select Option",
                "SELECT command  :Element (<locator>) [<objectID>]: "
                        + "Selected Option <inputValue> not present");
        errorMessagePool
                .put("Select Element",
                        "SELECT command  :Element (<locator>) [<objectID>] not present");
        errorMessagePool
                .put("Select No_Item",
                        "SELECT User item mismatch ( List Items:<actualOptions>, Input:<inputValue>) ");
        errorMessagePool
                .put("Select Index Out of bound",
                        "SELECT :<locator> SELECT User input index is out of bound "
                                + "( List Items: <actualOptions>, Input index: <inputValue>) ");

    }

    /**
     * Gets the select command error messages.
     * 
     * @param category
     *            the category
     * @return the select command error messages
     */
    public final String getSelectCommandErrorMessages(final String category) {

        if (category.startsWith("Option")) {
            return errorMessagePool.get("Select Option");
        } else if (category.startsWith("Element")) {
            return errorMessagePool.get("Select Element");
        } else if (category.startsWith("No_Item")) {
            return errorMessagePool.get("Select No_Item");
        } else if (category.startsWith("Index Out of bound")) {
            return errorMessagePool.get("Select Index Out of bound");
        }
        return null;
    }

}
