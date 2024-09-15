package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;

import java.util.HashMap;
import java.util.Map;

public class LayoutAttributeUtil extends AttributeUtil {

    private static final Logger logger = Logger.getInstance(LayoutAttributeUtil.class);
    private static volatile LayoutAttributeUtil instance;
    private final static Map<String, String> layoutAttributes = new HashMap<>();

    public LayoutAttributeUtil() {
        logger.info("LayoutAttributeUtil constructor called");
        addAttributeDescriptions();
        addDescriptions();
    }

    public static LayoutAttributeUtil getInstance(){
        if(instance == null){
            synchronized (LayoutAttributeUtil.class) {
                if(instance == null){
                    logger.info("LayoutAttributeUtil instance being created");
                    instance = new LayoutAttributeUtil();
                }
            }
        }
        logger.info("LayoutAttributeUtil instance returned");
        return instance;
    }

    private void addAttributeDescriptions() {
        addAttributes(
                "layout:decorate", "layout:fragment", "layout:title-pattern", "layout:insert", "sec:authorize",
                "layout:replace", "sec:authorize", "sec:authentication"
                // Add more attributes here
        );
    }

    private void addDescriptions(){
            layoutAttributes.put("layout:decorate", "Specifies the layout template to decorate the current template.");
            layoutAttributes.put("layout:fragment", "Defines a fragment of a layout for reuse in other parts of the template.");
            layoutAttributes.put("layout:title-pattern","Allows for greater control of the resulting <title> element by specifying a pattern with some special tokens.");
            layoutAttributes.put("layout:insert","Similar to Thymeleaf’s th:insert, but allows the passing of entire template fragments to the target template. ");
            layoutAttributes.put("layout:replace","Similar to layout:insert in that you can pass HTML content to the template/fragments you’re replacing, but with the behaviour of Thymeleaf’s th:replace.");

            layoutAttributes.put("sec:authorize", "Used with methods like hasRole(), isAuthenticated(), etc.");
            layoutAttributes.put("sec:authentication", "Can be used for listing 'name' and 'principal.authorities'");
    }


    // Method to get the description of a Thymeleaf attribute
    public static String getAttributeDescription(String attributeName) {
        return layoutAttributes.getOrDefault(attributeName, "No description available");
    }
}