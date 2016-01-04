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
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The Class DataTablesParser.
 */
public class DataTablesParser extends DefaultHandler {

    /** The test data table. */
    private DataTable testDataTable;

    /** The column index. */
    private int columnIndex = -1;

    /** The row index. */
    private int rowIndex = -1;

    /** The is value. */
    private boolean isValue = false;

    /** The buffer. */
    private StringBuffer buffer;

    /** The tables. */
    private HashMap<String, DataTable> tables =
            new HashMap<String, DataTable>();

    /** Constructor for DataTablesParser class. */
    public DataTablesParser() {
        testDataTable = new DataTable();
    }

    /**
     * Parses the tables.
     * 
     * @param file
     *            the file
     * @return the hash map
     */
    public static HashMap<String, DataTable> parseTables(final File file) {
        DataTablesParser dtp = new DataTablesParser();

        try {
            SAXParserFactory saxfactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxfactory.newSAXParser();
            saxParser.parse(file, dtp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dtp.getTables();

    }

    /**
     * Gets the tables.
     * 
     * @return the tables
     */
    public final HashMap<String, DataTable> getTables() {
        return tables;
    }

    // private String page;
    /**
     * Start element.
     * 
     * @param uri
     *            the url
     * @param localName
     *            the local name
     * @param qName
     *            the q name
     * @param attributes
     *            the attributes
     * @throws SAXException
     *             the SAX exception
     * @see 
     *      org.xml.sax.helpers.DefaultHandler#startElement(.String,.String,.String
     *      , org.xml.sax.Attributes)
     * @Override startElement in DefaultHandler Object.
     */
    @Override
    public final void startElement(final String uri, final String localName,
            final String qName, final Attributes attributes)
            throws SAXException {

        if ("TABLE".equalsIgnoreCase(qName)) {
            testDataTable = new DataTable();
            tables.put(attributes.getValue("name"), testDataTable);
            rowIndex = -1;
        } else if ("COLUMN".equalsIgnoreCase(qName)) {
            testDataTable.addColumn(attributes.getValue("name"));
            testDataTable.addDataTypes(attributes.getValue("type"));
        } else if ("ROW".equalsIgnoreCase(qName)) {
            rowIndex++;
            columnIndex = -1;
        } else if ("VALUE".equalsIgnoreCase(qName)) {
            columnIndex++;
            isValue = true;
        }

    }

    /**
     * 
     * 
     * @param uri
     *            the uri
     * @param localName
     *            the local name
     * @param qName
     *            the q name
     * @throws SAXException
     *             the SAX exception
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     *      java.lang.String, java.lang.String)
     * @Override endElement in DefaultHandler Object.
     */
    @Override
    public final void endElement(final String uri, final String localName,
            final String qName) throws SAXException {
        if ("VALUE".equalsIgnoreCase(qName)) {
            isValue = false;
        }
        buffer = new StringBuffer();
    }

    /**
     * Characters of the data table.
     * 
     * @param ch
     *            the ch
     * @param start
     *            the start
     * @param length
     *            the length
     * @throws SAXException
     *             the SAX exception
     * @Override characters in DefaultHandler Object. endElement @see
     *           org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    @Override
    public final void characters(final char[] ch, final int start,
            final int length) throws SAXException {
        String value = new String(ch, start, length);
        value = StringEscapeUtils.unescapeJava(value);
        if (buffer == null) {
            buffer = new StringBuffer();
        }
        buffer.append(value);
        if (isValue) {
            testDataTable.setValue(rowIndex, columnIndex, buffer.toString()
                    .trim());
        }
    }

}
