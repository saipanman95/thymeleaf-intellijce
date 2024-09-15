package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AutoCompleteSuggestionsBase;
import com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes.LayoutAttributeInfo;
import com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes.LayoutAttributeUtil;

public class SpringSecurityAutoCompleteSuggestions extends AutoCompleteSuggestionsBase<LayoutAttributeInfo> {

    private static final Logger logger = Logger.getInstance(SpringSecurityAutoCompleteSuggestions.class);

    private SpringSecurityAttributeUtil springSecurityAttributeUtil;

    public SpringSecurityAutoCompleteSuggestions(HtmlTag htmlTag,
                                                 String partialAttribute ) {
        super(htmlTag, partialAttribute);
        this.springSecurityAttributeUtil = SpringSecurityAttributeUtil.getInstance();
        addAttributes();
    }
    @Override
    protected void addAttributes() {
        if(springSecurityAttributeUtil == null){
            springSecurityAttributeUtil = SpringSecurityAttributeUtil.getInstance();
        }
        logger.info("size of attributes added is " + springSecurityAttributeUtil.getAttributes().size());

        for (String attribute : springSecurityAttributeUtil.getAttributes()) {
            if (attribute.startsWith(partialAttribute)) {
                attributes.add(new LayoutAttributeInfo(attribute));
            }
        }
    }

}
