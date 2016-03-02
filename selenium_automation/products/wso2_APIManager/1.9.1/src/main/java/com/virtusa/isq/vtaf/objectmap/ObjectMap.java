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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * The Class ObjectMap.
 */
public class ObjectMap {

    /**
     * Gets the object search path.
     * 
     * @param objectName
     *            the object name
     * @param identifire
     *            the identifire
     * @return the object search path
     */
    public static String getObjectSearchPath(final String objectName,
            final String identifire) {
        String searchPath = "";

        try {

            Class< ? > clz =
                    Class.forName("com.virtusa.isq.vtaf.runtime.pages."
                            + objectName.split("\\.")[0]);
            /* Use method added in Java 1.5. */
            Object[] consts = clz.getEnumConstants();
            /* Enum constants are in order of declaration. */

            for (int i = 0; i < consts.length; i++) {

                if (consts[i].toString().equalsIgnoreCase(
                        objectName.split("\\.")[1])) {
                    Class< ? > sub = consts[i].getClass();
                    Method mth = sub.getDeclaredMethod("getSearchPath");
                    searchPath = (String) mth.invoke(consts[i]);
                    /* Prove it worked. */
                    // System.out.println(val);
                    break;

                }

            }
            if (!"".equals(identifire)) {
                return getResolvedSearchPath(searchPath, identifire);

            } else {
                return searchPath;
            }
        } catch (ClassNotFoundException e) {
            return "";
        } catch (NoSuchMethodException e) {
            return "";
        } catch (InvocationTargetException e) {
            return "";
        } catch (IllegalAccessException e) {
            return "";
        } catch (IllegalArgumentException e) {
            return "";
        }
    }

    /**
     * Gets the identifires.
     * 
     * @param objectSearchPath
     *            the object search path
     * @return the identifires
     */
    public final List<String> getIdentifires(final String objectSearchPath) {

        String str;
        List<String> identifires = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(objectSearchPath, "<");
        int idtfIndex = 0;
        while (st.hasMoreElements()) {
            str = st.nextElement().toString();
            if (str.contains(">")) {
                identifires.add(str.split(">")[idtfIndex]);
            }
        }
        return identifires;
    }

    /**
     * Gets the parameter values.
     * 
     * @param parameters
     *            the parameters
     * @return the parameter values
     */
    public static List<String> getParameterValues(final String parameters) {

        List<String> parameterValues = new ArrayList<String>();
        String[] st = parameters.split("_PARAM,");

        for (int i = 0; i < st.length; i++) {

            parameterValues.add(st[i]);

        }
        return parameterValues;

    }

    /**
     * Gets the resolved search path.
     * 
     * @param searchPath
     *            the search path
     * @param identifire
     *            the identifire
     * @return the resolved search path
     */
    public static String getResolvedSearchPath(final String searchPath,
            final String identifire) {
        String resolvedSearchPath = searchPath;
        List<String> parameterValues = getParameterValues(identifire);
        for (String param : parameterValues) {
            if (!"".equals(param)) {
                resolvedSearchPath =
                        resolvedSearchPath.replace("<"
                                + param.split("_PARAM:")[0] + ">",
                                param.split("_PARAM:")[1]);
            }
        }
        return resolvedSearchPath;
    }
}
