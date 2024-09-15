package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AutoCompleteSuggestionsBase;

public class LayoutAutoCompleteSuggestions extends AutoCompleteSuggestionsBase<LayoutAttributeInfo> {

    private static final Logger logger = Logger.getInstance(LayoutAutoCompleteSuggestions.class);

    private LayoutAttributeUtil layoutAttributeUtil;

    public LayoutAutoCompleteSuggestions(HtmlTag htmlTag,
                                         String partialAttribute ) {
        super(htmlTag, partialAttribute);
        this.layoutAttributeUtil = LayoutAttributeUtil.getInstance();
        addAttributes();
    }
    @Override
    protected void addAttributes() {
        if(layoutAttributeUtil == null){
            layoutAttributeUtil = LayoutAttributeUtil.getInstance();
        }
        logger.info("size of attributes added is " + layoutAttributeUtil.getAttributes().size());

        for (String attribute : layoutAttributeUtil.getAttributes()) {
            if (attribute.startsWith(partialAttribute)) {
                attributes.add(new LayoutAttributeInfo(attribute));
            }
        }
    }

}
