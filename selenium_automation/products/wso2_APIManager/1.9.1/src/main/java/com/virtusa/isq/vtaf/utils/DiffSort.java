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

import java.util.Comparator;



/**
 * The Class DiffSort.
 */
public class DiffSort {

    /*
     * 2.0 (the "License"); you may not use this file except in compliance with the
     * License. You may obtain a copy of the License at
     * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
     * or agreed to in writing, software distributed under the License is
     * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * KIND, either express or implied. See the License for the specific language
     * governing permissions and limitations under the License.
     */
    // sort with comparator

    /** The diff natural order1 aa. */
    private  Comparator<String> diffNaturalOrder1Aa =
            new Comparator<String>() {
                private String order =
                        " !\"#$%&'()*+,-./0123456789:;<=>@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`"
                                + "abcdefghijklmnopqrstuvwxyz{|}~";

                @Override
                public int compare(final String v, final String w) {

                    return compareTwoValues(v, w, order);
                }

            };

    /** The diff natural order aa1. */
            private  Comparator<String> diffNaturalOrderAa1 =
            new Comparator<String>() {
                private String order =
                        " !\"#$%&'()*+,-./ABCDEFGHIJKLMNOPQRSTUVWXYZ:;<=>@abcdefghijklmnop"
                                + "qrstuvwxyz[\\]^_`0123456789{|}~";

                @Override
                public int compare(final String v, final String w) {

                    return compareTwoValues(v, w, order);
                }

            };

    /**
     * Compare two values.
     *
     * @param v the v
     * @param w the w
     * @param order the order
     * @return the int
     */
    private int compareTwoValues(final String v, final String w,
            final String order) {
        int diff = 0;
        Integer index1, index2;
        Integer len1 = v.length();
        Integer len2 = w.length();
        int len = Math.min(len1, len2); // lesser of 2 strings

        for (int i = 0; i < len; i++) {
            index1 = order.indexOf(v.charAt(i));
            index2 = order.indexOf(w.charAt(i));
            // if both chars are absent in order string, use natural ordering

            if (index1 == -1 && index2 == -1) {
                diff =
                        Character.valueOf(v.charAt(i)).compareTo(
                                Character.valueOf(w.charAt(i)));
            } else if (index1 == -1 && index2 > 0) {
                diff = 1;
            } else if (index1 > 0 && index2 == -1) {
                diff = -1;
            } else {
                diff = index1.compareTo(index2);
            }
            // break if we found mismatch
            if (diff != 0) {
                break;
            }

        }

        // return smaller string first in sort
        if (diff == 0) {
            diff = len1.compareTo(len2);
        }
        return diff;
    }

    /** The Constant diffNaturalOrderaA1. */
    public static final Comparator<String>  DIFFNATURALORDERA1 =
            new Comparator<String>() {
                private String order =
                        " !\"#$%&'()*+,-./abcdefghijklmnopqrstuvwxyz:;<=>@ABCDEFGHIJKLMNOPQRSTUVWXY"
                                + "Z[\\]^_`0123456789{|}~";

                @Override
                public int compare(final String v, final String w) {
                    int diff = 0;
                    Integer index1, index2;
                    Integer len1 = v.length();
                    Integer len2 = w.length();
                    int len = Math.min(len1, len2); // lesser of 2 strings

                    for (int i = 0; i < len; i++) {
                        index1 = order.indexOf(v.charAt(i));
                        index2 = order.indexOf(w.charAt(i));
                        // if both chars are absent in order string, use natural
                        // ordering

                        if (index1 == -1 && index2 == -1) {
                            diff =
                                    Character.valueOf(v.charAt(i)).compareTo(
                                            Character.valueOf(w.charAt(i)));
                        } else if (index1 == -1 && index2 > 0) {
                            diff = 1;
                        } else if (index1 > 0 && index2 == -1) {
                            diff = -1;
                        } else {
                            diff = index1.compareTo(index2);
                        }
                        // break if we found mismatch
                        if (diff != 0) {
                            break;
                        }

                    }

                    // return smaller string first in sort
                    if (diff == 0) {
                        diff = len1.compareTo(len2);
                    }
                    return diff;
                }

            };

    /**
     * Gets the diff natural order1 aa.
     *
     * @return the diff natural order1 aa
     */
    public final Comparator<String> getDiffNaturalOrder1Aa() {
        return diffNaturalOrder1Aa;
    }

    /**
     * Sets the diff natural order1 aa.
     *
     * @param diffNaturalOrder1Aa the new diff natural order1 aa
     */
   

    /**
     * Gets the diff natural order aa1.
     *
     * @return the diff natural order aa1
     */
    public final Comparator<String> getDiffNaturalOrderAa1() {
        return diffNaturalOrderAa1;
    }

    /**
     * Sets the diff natural order aa1.
     *
     * @param diffNaturalOrderAa1 the new diff natural order aa1
     */


   
}
