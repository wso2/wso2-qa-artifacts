package org.wso2.sample.secondClassMediator;

import org.apache.synapse.MessageContext;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.xml.namespace.QName;
import java.util.Map;
import java.util.logging.Logger;

public class SecondClassMediator extends AbstractMediator {

	public boolean mediate(MessageContext arg0) {
		arg0.setProperty("myProperty", "set through class mediator");
		
		return true;
	}

}
