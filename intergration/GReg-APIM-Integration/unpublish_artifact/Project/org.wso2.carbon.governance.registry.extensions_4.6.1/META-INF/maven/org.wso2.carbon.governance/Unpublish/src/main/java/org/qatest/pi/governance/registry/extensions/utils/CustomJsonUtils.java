//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.extensions.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.registry.core.exceptions.RegistryException;

public class CustomJsonUtils {
    private static final Log LOG = LogFactory.getLog(CustomJsonUtils.class);

    private CustomJsonUtils() {
    }

    public static void closeInputStream(InputStream inputStream) {
        if(inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException var2) {
                LOG.error("Error occurred when closing the input stream", var2);
            }
        }

    }

    public static void closeOutputStream(OutputStream outputStream) {
        if(outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException var2) {
                LOG.error("Error occurred when closing the output stream", var2);
            }
        }

    }

    public static ByteArrayOutputStream readSourceContent(InputStream inputStream) throws RegistryException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            int nextChar;
            while((nextChar = inputStream.read()) != -1) {
                outputStream.write(nextChar);
            }

            outputStream.flush();
            return outputStream;
        } catch (IOException var4) {
            throw new RegistryException("Exception occurred while reading json content", var4);
        }
    }
}
