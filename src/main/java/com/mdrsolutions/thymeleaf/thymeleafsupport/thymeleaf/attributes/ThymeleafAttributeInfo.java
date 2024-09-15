package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes;

import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeInfo;

public class ThymeleafAttributeInfo extends BaseAttributeInfo {
    public ThymeleafAttributeInfo(String attributeName) {
        super(attributeName, true);
    }

    @Override
    public Boolean isAttribute(){
        return ThymeleafAttributeUtil.getInstance().getAttributes().contains(getAttribute());
    }

    @Override
    public String getDescription() {
        return ThymeleafAttributeUtil.getAttributeDescription(getAttribute());
    }

}
