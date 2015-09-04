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

package com.virtusa.isq.vtaf.report.reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

/**
 * Contains the generator routines that generates code based on the
 * StringTemplate files.
 * 
 */
public class Generator {

    /**
     * Generate report.
     * 
     * @param reportBuilder
     *            the report builder
     */
    public final void generateReport(final ReportBuilder reportBuilder) {
        // String templateFolderRoot = "";

        String targetHtmlDataFile =
                reportBuilder.getReportFolderLocation() + File.separator
                        + "report.html.data";
        try {
            createContent("report", reportBuilder,
                    getTemplateStringReader("ReportHtmlData.stg"),
                    targetHtmlDataFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Evaluates the Content() template function in the given template file and
     * saves to the file returned by the FileName() template function passing
     * the settings and the object passed.
     * 
     * @param varName
     *            the var name
     * @param objectToPass
     *            the object to pass
     * @param reader
     *            the reader
     * @param outputFileName
     *            the output file name
     * @throws Exception
     *             the exception
     */

    private void createContent(final String varName, final Object objectToPass,
            final StringReader reader, final String outputFileName)
            throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // map.put("settings", settings);
        map.put(varName, objectToPass);

        StringTemplateGroup group = new StringTemplateGroup(reader);
        StringTemplate contentTemplate = group.getInstanceOf("Content");
        contentTemplate.setAttributes(map);

        String outputContent = null;
        try {
            outputContent = contentTemplate.toString();
        } catch (IllegalArgumentException e) {
            String errorStr = e.getMessage();
            if ((errorStr).startsWith("Can't find template")) {
                String newmsg =
                        errorStr.substring(("Can't find template").length(),
                                errorStr.indexOf(".st;"));
                System.out.println(newmsg);
                throw new RuntimeException("Error writing file "
                        + outputFileName + ": Command '" + newmsg
                        + "' not supported!", e);
                // java.lang.IllegalArgumentException: Can't find template
                // Retrieve.st; context is [Content BusinessComponent
                // else_subtemplate TestCommand
                // if(testCommand.specialCommand)_subtemplate]; group hierarchy
                // is [Library]
            } else {
                throw new RuntimeException("Error writing file "
                        + outputFileName, e);
            }
        }

        String folderName =
                outputFileName.substring(0, outputFileName.lastIndexOf('.')); // strip
        // the
        // text
        folderName =
                folderName.substring(0, folderName.lastIndexOf(File.separator)); // strip
        // the
        // filename

        if (folderName != null) {
            File folder = new File(folderName);
            if (!folder.exists() && !folder.mkdirs()) {
                throw new RuntimeException(
                        "Cannot create new folder in location " + folderName);
            }
        }

        FileWriter out = null;
        try {
            out = new FileWriter(outputFileName);
            out.write(outputContent);

        } catch (Exception e) {
            // if (e != null && e.getMessage() != null) {
            // //logger.error(e.getMessage(), e);
            // // DialogManager.showErrorText("Cannnot write to file \n"
            // // + outputFileName);
            // } else {
            // // logger.error("Cannnot write to file \n" + outputFileName);
            // // DialogManager.showErrorText("Cannnot write to file \n"
            // // + outputFileName);
            // }
            throw new RuntimeException("Error writing file " + outputFileName,
                    e);
        } finally {
            try {
                if (out != null) {
                out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // here get the templates from the inside package and put them to input
    // stream and then put it to sting reader
    /**
     * Gets the template string reader.
     * 
     * @param filePath
     *            the file path
     * @return the template string reader
     */
    private StringReader getTemplateStringReader(final String filePath) {

        InputStream stream = null;
        StringBuilder out = new StringBuilder();
        final int byteSize = 4096;
        byte[] b = new byte[byteSize];
        try {
            File f =
                    new File("src" + File.separator + "main" + File.separator
                            + "resources" + File.separator + filePath);

            stream = new FileInputStream(f.getAbsolutePath());
            int n = stream.read(b);
            while (n != -1) {
                out.append(new String(b, 0, n));
                n = stream.read(b);
            }
        } catch (IOException e) {
            System.out.println("Error occured in templates");
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new StringReader(out.toString());
    }

}
