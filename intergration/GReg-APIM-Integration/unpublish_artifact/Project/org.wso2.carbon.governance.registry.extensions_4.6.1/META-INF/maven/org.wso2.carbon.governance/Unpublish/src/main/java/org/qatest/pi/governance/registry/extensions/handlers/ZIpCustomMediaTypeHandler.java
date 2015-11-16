//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.handlers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.extensions.utils.WSDLValidations;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.Handler;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class ZIpCustomMediaTypeHandler extends Handler {
    private static final Log LOG = LogFactory.getLog(ZIpCustomMediaTypeHandler.class);
    private static final String ARCHIVE_EXTENSION = ".gar";
    private static final String TEMP_FILE_PREFIX = "wsdl";
    private final Map<String, String[]> map = new HashMap();
    private final WSDLValidations wsdlValidations = new WSDLValidations();
    private boolean validateNP = false;
    private boolean isCamelCaseEnable = false;
    private final List<String> wsdlFiles = new ArrayList();
    private File tempDirectory;

    public ZIpCustomMediaTypeHandler() {
    }

    public void setNameSpaceValueString(String nameSpaceValueString) {
        if(!"".equalsIgnoreCase(nameSpaceValueString)) {
            String[] temp = nameSpaceValueString.split(",");
            this.map.put("namespacesvalues", temp);
            this.validateNP = true;
        }

        LOG.info("Namespace validation is " + this.validateNP);
    }

    public void setCamalCaseEnable(String camalCaseEnable) {
        this.isCamelCaseEnable = Boolean.parseBoolean(camalCaseEnable);
        LOG.info("Camel case validation is " + this.isCamelCaseEnable);
    }

    public void put(RequestContext requestContext) throws RegistryException {
        if(this.validateNP || this.isCamelCaseEnable) {
            ZipFile zipFile = null;
            String wsdlFile = "";
            Resource resource = requestContext.getResource();

            try {
                if(resource != null) {
                    Object e = resource.getContent();
                    ByteArrayInputStream in = new ByteArrayInputStream((byte[])((byte[])e));
                    File tempFile = File.createTempFile("wsdl", ".gar");
                    File tempDir = new File(tempFile.getAbsolutePath().substring(0, tempFile.getAbsolutePath().length() - ".gar".length()));
                    boolean isDictoryCreated = tempDir.mkdir();
                    if(LOG.isDebugEnabled()) {
                        LOG.debug("Temp directory created : " + isDictoryCreated);
                    }

                    this.tempDirectory = tempDir;
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tempFile));

                    try {
                        byte[] wsdlDefinition = new byte[1024];
                        int i$ = in.read(wsdlDefinition);

                        while(true) {
                            if(i$ <= 0) {
                                out.flush();
                                break;
                            }

                            out.write(wsdlDefinition, 0, i$);
                            i$ = in.read(wsdlDefinition);
                        }
                    } finally {
                        out.close();
                    }

                    zipFile = new ZipFile(tempFile.getPath());
                    Enumeration entries = zipFile.entries();

                    label596:
                    while(true) {
                        File wsdlPath;
                        ZipEntry wsdlDefinition1;
                        while(true) {
                            if(!entries.hasMoreElements()) {
                                zipFile.close();
                                this.wsdlFiles.clear();
                                this.listf(tempDir.getPath());
                                Iterator i$2 = this.wsdlFiles.iterator();

                                while(i$2.hasNext()) {
                                    String wsdlPath1 = (String)i$2.next();

                                    try {
                                        WSDLFactory e3 = WSDLFactory.newInstance();
                                        WSDLReader reader1 = e3.newWSDLReader();
                                        reader1.setFeature("javax.wsdl.importDocuments", true);
                                        reader1.setFeature("javax.wsdl.verbose", LOG.isDebugEnabled());
                                        Definition wsdlDefinition2 = reader1.readWSDL(wsdlPath1);
                                        if(wsdlDefinition2 == null) {
                                            throw new RegistryException("Cannot read the wsdl document in given link");
                                        }

                                        if(this.validateNP) {
                                            this.wsdlValidations.validate(wsdlDefinition2, this.map);
                                        }

                                        if(this.isCamelCaseEnable) {
                                            this.wsdlValidations.validateParameterCamalCase(wsdlDefinition2, wsdlFile);
                                        }
                                    } catch (Exception var73) {
                                        throw new RegistryException("Unable to load the wsdl file from url", var73);
                                    }
                                }
                                break label596;
                            }

                            wsdlDefinition1 = (ZipEntry)entries.nextElement();
                            String i$1 = wsdlDefinition1.getName();
                            wsdlPath = new File(tempDir.getPath() + File.separator + i$1);
                            if(!wsdlDefinition1.isDirectory()) {
                                break;
                            }

                            try {
                                boolean e1 = (new File(wsdlPath.getPath())).mkdir();
                                if(e1) {
                                    continue;
                                }
                                break;
                            } catch (SecurityException var76) {
                                throw new RegistryException("Cannot create directory", var76);
                            }
                        }

                        InputStream e2 = null;
                        FileOutputStream reader = null;
                        BufferedOutputStream outputStream = null;

                        try {
                            e2 = zipFile.getInputStream(wsdlDefinition1);
                            reader = new FileOutputStream(wsdlPath);
                            outputStream = new BufferedOutputStream(reader);
                            this.copyInputStream(e2, outputStream);
                        } catch (IOException var74) {
                            LOG.error("Error while processing the file stream content");
                        } finally {
                            try {
                                if(e2 != null) {
                                    e2.close();
                                }
                            } catch (IOException var72) {
                                LOG.error("Unable to release created resource streams");
                            }

                            try {
                                if(reader != null) {
                                    reader.close();
                                }
                            } catch (IOException var71) {
                                LOG.error("Unable to release created resource streams");
                            }

                            try {
                                if(outputStream != null) {
                                    outputStream.close();
                                }
                            } catch (IOException var70) {
                                LOG.error("Unable to release created resource streams");
                            }

                        }
                    }
                }
            } catch (IOException var78) {
                LOG.error("IO Error occurred while uploading the zipfile");
                throw new RegistryException("IO Error occurred while uploading the zipfile", var78);
            } finally {
                try {
                    if(zipFile != null) {
                        zipFile.close();
                    }

                    FileUtils.deleteDirectory(this.tempDirectory);
                } catch (IOException var69) {
                    LOG.error("Unable to delete the temporary file created");
                }

            }

        }
    }

    private void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];

        for(int len = in.read(buffer); len >= 0; len = in.read(buffer)) {
            out.write(buffer, 0, len);
        }

    }

    private List<File> listf(String directoryName) {
        File directory = new File(directoryName);
        ArrayList resultList = new ArrayList();
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        File[] arr$ = fList;
        int len$ = fList.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            File file = arr$[i$];
            if(file.isFile()) {
                if(file.getName().contains("wsdl")) {
                    this.wsdlFiles.add(file.getPath());
                }
            } else if(file.isDirectory()) {
                resultList.addAll(this.listf(file.getAbsolutePath()));
            }
        }

        return resultList;
    }
}
