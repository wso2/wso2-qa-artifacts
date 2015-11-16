//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.qatest.pi.governance.registry.executor;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.llom.OMAttributeImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.qatest.pi.governance.registry.executor.BaseEndpointExecutor;
import org.qatest.pi.governance.registry.extensions.utils.APIUtils;
import org.qatest.pi.governance.registry.extensions.utils.GovernanceExceptions;
import org.qatest.pi.governance.registry.extensions.utils.PropertyFileHelper;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.registry.app.RemoteRegistry;
import org.wso2.carbon.registry.core.ResourceImpl;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.internal.RegistryCoreServiceComponent;
import org.wso2.carbon.registry.core.jdbc.handlers.RequestContext;

public class EndpointPushExecutor extends BaseEndpointExecutor {
    private static final Log LOG = LogFactory.getLog(EndpointPushExecutor.class);
    private String name;
    private String version;
    private String endpointType;
    private String HTTPMethod;
    private int timeoutValue = 30000;
    private String format;
    private int retriesBefSusp;
    private int retryDelay;
    private String endpoint;
    private Map<String, String> endpointEnvMap = new HashMap();

    public EndpointPushExecutor() {
    }

    public boolean execute(RequestContext context, String currentState, String targetState) {
        this.setResource(context.getResource());
        this.setResourcePath(context.getResourcePath().getPath());
        ArrayList actions = new ArrayList();
        String user = CarbonContext.getThreadLocalCarbonContext().getUsername();

        try {
            this.setRegistry(RegistryCoreServiceComponent.getRegistryService().getGovernanceUserRegistry(user, CarbonContext.getThreadLocalCarbonContext().getTenantId()));
            this.parseForRxtInstanceDetails();
        } catch (RegistryException var14) {
            throw new GovernanceExceptions(var14.getMessage(), var14);
        }

        int selectedCount = this.populateActions(actions);
        if(selectedCount > 1) {
            throw new GovernanceExceptions("Please Select Only One Environment for Publish/Unpublish Operation");
        } else if(selectedCount <= 0) {
            throw new GovernanceExceptions("Please Select an Environment for Publish/Unpublish Operation");
        } else {
            Iterator i$ = actions.iterator();

            while(i$.hasNext()) {
                String action = (String)i$.next();
                String esbEnvironmentURL = PropertyFileHelper.getValue(action + "_ESB_ENVIRONMENT_URL", "https://dpesb.fmr.com");

                try {
                    this.pushEndpointToESB(esbEnvironmentURL, action);
                    this.getResource().setProperty("publisher_" + action, user);
                    this.getResource().setProperty("published_endpoint_" + action, this.endpoint);
                    Date ex = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
                    String dateAndTimeNow = sdf.format(ex);
                    this.getResource().setProperty("published_time_" + action, dateAndTimeNow);
                    APIUtils.updatePromotedProperty(action, this.getResource(), this.getRegistry());
                    LOG.info("User " + CarbonContext.getThreadLocalCarbonContext().getUsername() + " promoted the endpoint " + this.name + " to " + action + " ESB environment");
                } catch (RegistryException var13) {
                    throw new GovernanceExceptions(var13.getMessage(), var13);
                }
            }

            return true;
        }
    }

    private void pushEndpointToESB(String esbEnvironmentURL, String action) throws RegistryException {
        URL url;
        try {
            url = new URL(esbEnvironmentURL);
        } catch (MalformedURLException var10) {
            throw new RegistryException("The esb environment url is malformed", var10);
        }

        String regUserName;
        String regPwd;
        if(action.contains("PROD")) {
            regUserName = PropertyFileHelper.getValue("PROD_ESB_USERNAME", "admin");
            regPwd = PropertyFileHelper.getValue("PROD_ESB_PASSWORD", "admin");
        } else {
            regUserName = PropertyFileHelper.getValue("NONPROD_ESB_USERNAME", "admin");
            regPwd = PropertyFileHelper.getValue("NONPROD_ESB_PASSWORD", "admin");
        }

        RemoteRegistry remoteRegistry = new RemoteRegistry(url, regUserName, regPwd);
        ResourceImpl newEndpointResource = new ResourceImpl();
        String endpointContent = this.generateEndpointResourceContent(action);
        newEndpointResource.setContent(endpointContent);
        newEndpointResource.setMediaType("text/plain");
        String endpointPath = this.getEndpointResourcePath(this.name, this.version);
        if(endpointPath.startsWith("/_system/governance")) {
            remoteRegistry.put(endpointPath, newEndpointResource);
        } else {
            throw new RegistryException("Resource storage path is invalid : path should start with /_system/governance. Look in the lifecycle configuration");
        }
    }

    private String generateEndpointResourceContent(String action) throws RegistryException {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMElement root = factory.createOMElement(new QName("endpoint"));
        OMAttributeImpl attributeNamespace = new OMAttributeImpl("xmlns", (OMNamespace)null, "http://ws.apache.org/ns/synapse", factory);
        root.addAttribute(attributeNamespace);
        OMAttributeImpl nameAttribute = null;
        nameAttribute = new OMAttributeImpl("name", (OMNamespace)null, this.name + "_v" + this.version, factory);
        root.addAttribute(nameAttribute);
        OMElement firstChildElement = null;
        OMElement addressElement = factory.createOMElement(new QName("address"));
        OMElement httpElement = factory.createOMElement(new QName("http"));
        if(this.endpointType.equalsIgnoreCase("HTTP")) {
            firstChildElement = httpElement;
        } else if(this.endpointType.equalsIgnoreCase("Address")) {
            firstChildElement = addressElement;
        }

        this.endpoint = (String)this.endpointEnvMap.get(action.toLowerCase());
        if(this.endpoint != null) {
            OMAttributeImpl formatAttribute;
            if(this.endpointType.equalsIgnoreCase("HTTP")) {
                formatAttribute = new OMAttributeImpl("method", (OMNamespace)null, this.HTTPMethod, factory);
                firstChildElement.addAttribute(formatAttribute);
                OMAttributeImpl durationElement = new OMAttributeImpl("uri-template", (OMNamespace)null, this.endpoint, factory);
                firstChildElement.addAttribute(durationElement);
            } else if(this.endpointType.equalsIgnoreCase("Address")) {
                formatAttribute = new OMAttributeImpl("uri", (OMNamespace)null, this.endpoint, factory);
                firstChildElement.addAttribute(formatAttribute);
            }

            formatAttribute = null;
            String durationElement1 = this.format;
            byte responseActionElement = -1;
            switch(durationElement1.hashCode()) {
                case -814794496:
                    if(durationElement1.equals("Plain Old XML (POX)")) {
                        responseActionElement = 2;
                    }
                    break;
                case 2511828:
                    if(durationElement1.equals("REST")) {
                        responseActionElement = 3;
                    }
                    break;
                case 1953462175:
                    if(durationElement1.equals("SOAP 1.1")) {
                        responseActionElement = 0;
                    }
                    break;
                case 1953462176:
                    if(durationElement1.equals("SOAP 1.2")) {
                        responseActionElement = 1;
                    }
            }

            switch(responseActionElement) {
                case 0:
                    formatAttribute = new OMAttributeImpl("format", (OMNamespace)null, "soap11", factory);
                    break;
                case 1:
                    formatAttribute = new OMAttributeImpl("format", (OMNamespace)null, "soap12", factory);
                    break;
                case 2:
                    formatAttribute = new OMAttributeImpl("format", (OMNamespace)null, "pox", factory);
                    break;
                case 3:
                    formatAttribute = new OMAttributeImpl("format", (OMNamespace)null, "rest", factory);
            }

            if(formatAttribute != null) {
                firstChildElement.addAttribute(formatAttribute);
            }

            OMElement durationElement2 = factory.createOMElement(new QName("duration"));
            durationElement2.setText(Integer.toString(this.timeoutValue));
            OMElement responseActionElement1 = factory.createOMElement(new QName("responseAction"));
            responseActionElement1.setText("fault");
            OMElement timeoutElement = factory.createOMElement(new QName("timeout"));
            timeoutElement.addChild(durationElement2);
            timeoutElement.addChild(responseActionElement1);
            OMElement suspendOnFailureElement = factory.createOMElement(new QName("suspendOnFailure"));
            OMElement errorCodesElement = factory.createOMElement(new QName("errorCodes"));
            errorCodesElement.setText("-1");
            OMElement initialDurationElement = factory.createOMElement(new QName("initialDuration"));
            initialDurationElement.setText("0");
            OMElement progressionFactorElement = factory.createOMElement(new QName("progressionFactor"));
            progressionFactorElement.setText("1.0");
            OMElement maximumDurationElement = factory.createOMElement(new QName("maximumDuration"));
            maximumDurationElement.setText("0");
            suspendOnFailureElement.addChild(errorCodesElement);
            suspendOnFailureElement.addChild(initialDurationElement);
            suspendOnFailureElement.addChild(progressionFactorElement);
            suspendOnFailureElement.addChild(maximumDurationElement);
            OMElement markForSuspensionElement = factory.createOMElement(new QName("markForSuspension"));
            OMElement errorCodesInSuspensionElement = factory.createOMElement(new QName("errorCodes"));
            errorCodesInSuspensionElement.setText("-1");
            OMElement retriesBeforeSuspensionElement = factory.createOMElement(new QName("retriesBeforeSuspension"));
            retriesBeforeSuspensionElement.setText(Integer.valueOf(this.retriesBefSusp).toString());
            OMElement retryDelayElement = factory.createOMElement(new QName("retryDelay"));
            retryDelayElement.setText(Integer.valueOf(this.retryDelay).toString());
            markForSuspensionElement.addChild(errorCodesInSuspensionElement);
            markForSuspensionElement.addChild(retriesBeforeSuspensionElement);
            markForSuspensionElement.addChild(retryDelayElement);
            firstChildElement.addChild(timeoutElement);
            firstChildElement.addChild(suspendOnFailureElement);
            firstChildElement.addChild(markForSuspensionElement);
            root.addChild(firstChildElement);
            return root.toString();
        } else {
            throw new RegistryException("The endpoint is not specified for the environemt : " + action);
        }
    }

    private void parseForRxtInstanceDetails() throws RegistryException {
        OMElement docElement = this.getDocumentElement();
        this.name = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "name")).getText();
        this.version = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "version")).getText();
        String businessUnit = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "businessUnit")).getText();
        if(businessUnit.trim().length() < 1) {
            throw new RegistryException("Please Select a Business Unit");
        } else {
            this.endpointType = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "endpointType")).getText();
            if(this.endpointType.trim().length() < 1) {
                throw new RegistryException("Please Select an Endpoint Type");
            } else {
                this.HTTPMethod = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "httpMethod")).getText();
                if(this.endpointType.equalsIgnoreCase("HTTP") && this.HTTPMethod.trim().length() < 1) {
                    throw new RegistryException("Please Select a HTTP Method when HTTP is selected as Endpoint Type");
                } else {
                    this.format = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "format")).getText();
                    if(this.format.trim().length() < 1) {
                        throw new RegistryException("Please Select A Format for the Endpoint");
                    } else {
                        String timeoutStr = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "timeoutinseconds")).getText();
                        if(timeoutStr.trim().length() < 1) {
                            throw new RegistryException("Please Enter a Value for Timeout Field");
                        } else {
                            try {
                                this.timeoutValue = Integer.parseInt(timeoutStr) * 1000;
                            } catch (NumberFormatException var13) {
                                throw new RegistryException("Timeout value specified is not an Integer", var13);
                            }

                            String retriesStr = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "retriesBeforeSuspension")).getText();
                            if(retriesStr.trim().length() < 1) {
                                throw new RegistryException("Please Enter a Value for Retries Before Suspension Field");
                            } else {
                                try {
                                    this.retriesBefSusp = Integer.parseInt(retriesStr);
                                } catch (NumberFormatException var12) {
                                    throw new RegistryException("Retries Before Suspension value specified is not an Integer", var12);
                                }

                                String retryDelayStr = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "overview")).getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "retryDelayinseconds")).getText();
                                if(retryDelayStr.trim().length() < 1) {
                                    throw new RegistryException("Please Enter a Value for Retry Delay Field");
                                } else {
                                    try {
                                        this.retryDelay = Integer.parseInt(retryDelayStr) * 1000;
                                    } catch (NumberFormatException var11) {
                                        throw new RegistryException("Retry Delay value specified is not an Integer", var11);
                                    }

                                    Iterator iterator = docElement.getFirstChildWithName(new QName("http://www.wso2.org/governance/metadata", "endpoints")).getChildren();

                                    while(iterator.hasNext()) {
                                        OMElement element = (OMElement)iterator.next();
                                        String environmentURL = element.getText();
                                        String environment = environmentURL.substring(0, environmentURL.indexOf(58));
                                        String url = environmentURL.substring(environmentURL.indexOf(58) + 1);
                                        this.endpointEnvMap.put(environment.toLowerCase(), url);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
