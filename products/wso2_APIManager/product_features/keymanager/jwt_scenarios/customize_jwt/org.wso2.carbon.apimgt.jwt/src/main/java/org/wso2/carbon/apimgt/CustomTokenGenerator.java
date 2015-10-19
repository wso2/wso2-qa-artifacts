package org.wso2.carbon.apimgt;

import org.wso2.carbon.apimgt.impl.APIConstants;
import org.wso2.carbon.apimgt.impl.dto.APIKeyValidationInfoDTO;
import org.wso2.carbon.apimgt.impl.token.JWTGenerator;
import org.wso2.carbon.apimgt.api.*;

import java.util.HashMap;
import java.util.Map;
 
public class CustomTokenGenerator extends JWTGenerator {
 
    public Map populateStandardClaims(APIKeyValidationInfoDTO keyValidationInfoDTO, String apiContext, String version)
            throws APIManagementException {
        Map claims = super.populateStandardClaims(keyValidationInfoDTO, apiContext, version);
        boolean isApplicationToken =
                keyValidationInfoDTO.getUserType().equalsIgnoreCase(APIConstants.ACCESS_TOKEN_USER_TYPE_APPLICATION) ? true : false;
        String dialect = getDialectURI();
        if (claims.get(dialect + "/enduser") != null) {
            if (isApplicationToken) {
                claims.put(dialect + "/enduser", "null");
                claims.put(dialect + "/enduserTenantId", "null");
            } else {
                String enduser = (String) claims.get(dialect + "/enduser");
                if (enduser.endsWith("@carbon.super")) {
                    enduser = enduser.replace("@carbon.super", "");
                    claims.put(dialect + "/enduser", enduser);
                }
            }
        }
 
        return claims;
 
    }
 
    public Map populateCustomClaims(APIKeyValidationInfoDTO keyValidationInfoDTO, String apiContext, String version, String accessToken)
            throws APIManagementException {
        Long time = System.currentTimeMillis();
        String text = "This is custom JWT";
        Map map = new HashMap();
        map.put("current_timestamp", time.toString());
        map.put("messge" , text);
        return map;
    }
}