package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeInfo;

public class SpringSecurityAttributeInfo extends BaseAttributeInfo {

    // Constructor that initializes layout attributes
    public SpringSecurityAttributeInfo(String attributeName) {
        super(attributeName, false);  // false indicates this is not a Thymeleaf attribute but a Layout attribute
    }

    // Returns whether the given attribute is a layout attribute
    @Override
    public Boolean isAttribute() {
        return SpringSecurityAttributeUtil.getInstance().getAttributes().contains(getAttribute());
    }

    // Returns a description for the layout attribute, if available
    public String getDescription() {
        return SpringSecurityAttributeUtil.getAttributeDescription(getAttribute());
    }
}
