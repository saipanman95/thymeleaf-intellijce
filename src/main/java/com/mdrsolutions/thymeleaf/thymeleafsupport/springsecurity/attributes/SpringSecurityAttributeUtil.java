package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;

import java.util.HashMap;
import java.util.Map;

public class SpringSecurityAttributeUtil extends AttributeUtil {

    private static final Logger logger = Logger.getInstance(SpringSecurityAttributeUtil.class);
    private static volatile SpringSecurityAttributeUtil instance;
    private final static Map<String, String> layoutAttributes = new HashMap<>();

    public SpringSecurityAttributeUtil() {
        logger.info("SpringSecurityAttributeUtil constructor called");
        addAttributeDescriptions();
        addDescriptions();
    }

    public static SpringSecurityAttributeUtil getInstance(){
        if(instance == null){
            synchronized (SpringSecurityAttributeUtil.class) {
                if(instance == null){
                    logger.info("SpringSecurityAttributeUtil instance being created");
                    instance = new SpringSecurityAttributeUtil();
                }
            }
        }
        logger.info("LayoutAttributeUtil instance returned");
        return instance;
    }

    private void addAttributeDescriptions() {
        addAttributes(
                "sec:authorize", "sec:csrf", "sec:authentication"
                // Add more attributes here
        );
    }

    private void addDescriptions(){
            layoutAttributes.put("sec:authorize", "Used with methods like hasRole(), isAuthenticated(), etc.");
            layoutAttributes.put("sec:authentication", "Can be used for listing 'name' and 'principal.authorities'");
            layoutAttributes.put("sec:csrf","Used or generating CSRF protection tokens in forms.");
    }

    // Method to get the description of a Thymeleaf attribute
    public static String getAttributeDescription(String attributeName) {
        return layoutAttributes.getOrDefault(attributeName, "No description available");
    }
}