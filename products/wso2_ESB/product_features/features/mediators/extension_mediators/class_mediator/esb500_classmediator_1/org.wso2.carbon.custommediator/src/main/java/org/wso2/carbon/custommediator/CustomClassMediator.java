package org.wso2.carbon.custommediator;

import org.apache.synapse.MessageContext;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.xml.namespace.QName;
import java.util.Map;
import java.util.logging.Logger;

public class CustomClassMediator extends AbstractMediator  {
	private String hostname;
    private String requestPath;
    private String protocol;
    private String hostnamewithport;
    Logger mylogger = Logger.getLogger(CustomClassMediator.class.getName());
    
    
    public CustomClassMediator(){}

    public boolean mediate(MessageContext mc) {


        mylogger.info("inside");
        System.out.println("inside the mediate");
		Map headers = (Map) ((Axis2MessageContext) mc).getAxis2MessageContext().
                getProperty(org.apache.axis2.context.MessageContext.TRANSPORT_HEADERS);
		System.out.println(mc);
        hostnamewithport  = (String) headers.get("Host");//  this will return  the  host with with port no eg:10.100.7.53:8243
        protocol= (String) mc.getProperty("TRANSPORT_IN_NAME"); //  this will return  the  protocol name either HTTPS or http
        requestPath=(String) mc.getProperty("REST_FULL_REQUEST_PATH");//this will return context, version, and resource.
        //theLogger.finer(hostnamewithport);
        //theLogger.finer(protocol);
        //theLogger.finer(requestPath);
        //mylogger.info(protocol);
        //mylogger.info(requestPath);
        //mylogger.info(hostnamewithport);
        System.out.println(protocol);
        System.out.println(requestPath);
        System.out.println(hostnamewithport);

        return true;
    }
    
    
    
    
}
