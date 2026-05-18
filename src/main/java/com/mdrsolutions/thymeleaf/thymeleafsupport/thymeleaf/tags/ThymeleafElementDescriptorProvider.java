package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.tags;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.impl.source.xml.XmlElementDescriptorProvider;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlElementDescriptor;

public class ThymeleafElementDescriptorProvider implements XmlElementDescriptorProvider {

    private static final Logger logger = Logger.getInstance(ThymeleafElementDescriptorProvider.class);

    @Override
    public XmlElementDescriptor getDescriptor(XmlTag tag) {
        if ("th:block".equalsIgnoreCase(tag.getName())) {
            logger.info("return new ThymeleafBlockTagDescriptor");
            return new ThymeleafBlockTagDescriptor();
        }
        return null;
    }
}
