package com.mdrsolutions.thymeleaf.thymeleafsupport.namespace;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThymeleafNamespaceRegistry {

    // Enum for namespace attributes
    public enum NamespaceAttribute {
        LAYOUT("xmlns:layout"),
        THYMELEAF("xmlns:th"),
        SPRING_SECURITY("xmlns:sec");

        private final String attribute;

        NamespaceAttribute(String attribute) {
            this.attribute = attribute;
        }

        public String getAttribute() {
            return attribute;
        }

        @Override
        public String toString() {
            return attribute;
        }

        // Method to retrieve enum from attribute value
        public static NamespaceAttribute fromAttribute(String attribute) {
            for (NamespaceAttribute nsAttribute : NamespaceAttribute.values()) {
                if (nsAttribute.getAttribute().equals(attribute)) {
                    return nsAttribute;
                }
            }
            throw new IllegalArgumentException("No constant with attribute " + attribute + " found");
        }
    }

    // Map to hold namespace attributes and their corresponding values
    private static final Map<NamespaceAttribute, String> namespaceMap = new HashMap<>();

    static {
        namespaceMap.put(NamespaceAttribute.LAYOUT, "http://www.ultraq.net.nz/thymeleaf/layout");
        namespaceMap.put(NamespaceAttribute.THYMELEAF, "http://www.thymeleaf.org");
        namespaceMap.put(NamespaceAttribute.SPRING_SECURITY, "http://www.thymeleaf.org/thymeleaf-extras-springsecurity6");
    }

    // Method to get all namespaces as an unmodifiable map
    public static Map<NamespaceAttribute, String> getNamespaces() {
        return Collections.unmodifiableMap(namespaceMap);
    }

    // Method to get the value of a specific namespace attribute
    public static String getNamespaceValue(NamespaceAttribute attribute) {
        return namespaceMap.get(attribute);
    }

    // Method to get the attribute for a specific value
    public static NamespaceAttribute getAttributeForValue(String value) {
        for (Map.Entry<NamespaceAttribute, String> entry : namespaceMap.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("No attribute found for value: " + value);
    }

}
