#The attached artifacts can be used to verify entitlement caching with the aid of response caching on API Manager.#

The WSO2 servers which these artifacts are based on are as follows.
*WSO2 API Manager 1.7.0
*WSO2 Identity Server 5.0.0


**The API invocation flow with XACML (Refer to api_invocation_flow_with_xacml.jpg):**
1  Request is received by the Gateway(APIM)
2. Token is validated by the Key Manager(APIM) and the validation results are sent back to the Gateway.
3. If the token is valid, the entitlement mediator will call the identity server for XACML policy evaluation.
4. If the result of the policy decision is 'permit' the actual back end endpoint will be invoked.

When you enable response caching for an API, the cache mediator will be engaged,before step 3 and 4 (before calling the Identity Server to get the XACML policy evaluated and the back end endpoint).
This will cache the response and the result of the XACML policy decision.

Follow the steps below for the verification.

**Pre-Requisites**

Start API-M with port offset 0 and IS with port offset 1.

**Steps**

1. Install the following features on API Manager and restart the server.
      `Features
         -XACML
         -XACML Mediation`
     
      Repository Location : http://dist.wso2.org/p2/carbon/releases/turing/

2. Create an API in the API Publisher and replace the content of the synapse configuration deployed with that of sampleFiles/APIs/admin--test_v1.0.0.xml'

3. In the above created API, the following sample APIs have been used as endpoints instead of external endpoints. 
   Therefore copy these files to <AM_HOME>/repository/deployment/server/synapse-configs/default/api folder.
      `sampleFiles/APIs/acceptResponse_api.xml
      sampleFiles/APIs/denyResponse_api.xml`

4.  Deploy the following sample xacml policy on the Identity server 
      `sampleFiles/sample_xacml_policy.xml` 

5. Enable debug logs for the package 'org.wso2.carbon.identity.entitlement' of the identity server.
   For this, add the following entry in the <IS_HOME>/repository/conf/log4j.properties file and restart the server.
      `log4j.logger.org.wso2.carbon.identity.entitlement=DEBUG`

6. Subscribe to the API created at step 1  API and invoke it.

   - This will print the debug logs pertaining to the package enabled at step 1 on the identity server console.
   - This implies the initial request made to the identity server for XACML policy evaluation.
   - The policy decision and the back end response is cached at the APIM end at this point.

7. Invoke the API again (without changing the request).
   - Since the request is identical to the request made at step 2, the response will be fetched from the response cache at APIM.
   - No requests will be made to the Identity server for policy evaluation or to the actual back end.
   - Therefore the debug logs observed on the Identity server console at step 2, will not be logged again.

8. Repeat step 6 with a different a request parameter. (Optional)
   - Since the request is different (due to the difference in request parameters) you will be able to observe the above mentioned debug log on the Identity Server for the first invocation.
   - But not for the second invocation as the response will be fetched from the cache.
