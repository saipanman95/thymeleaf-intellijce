package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeInfo;

import java.util.HashMap;
import java.util.Map;

public class LayoutAttributeInfo extends BaseAttributeInfo {

    // Map to store layout-specific attributes with descriptions
    private final Map<String, String> layoutAttributes = new HashMap<>();

    // Constructor that initializes layout attributes
    public LayoutAttributeInfo(String attributeName) {
        super(attributeName, false);  // false indicates this is not a Thymeleaf attribute but a Layout attribute
    }

    // Returns whether the given attribute is a layout attribute
    @Override
    public Boolean isAttribute() {
        return layoutAttributes.containsKey(getAttribute());
    }

    // Returns a description for the layout attribute, if available
    public String getDescription() {
        return layoutAttributes.getOrDefault(getAttribute(), "No description available");
    }
}
