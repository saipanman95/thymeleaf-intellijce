package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.impl.source.html.dtd.HtmlElementDescriptorImpl;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlAttributeDescriptor;
import com.intellij.xml.XmlAttributeDescriptorsProvider;
import org.jetbrains.annotations.Nullable;

public class SpringSecurityAttributesProvider implements XmlAttributeDescriptorsProvider {
    private static final Logger logger = Logger.getInstance(SpringSecurityAttributesProvider.class);

    @Override
    public XmlAttributeDescriptor[] getAttributeDescriptors(XmlTag context) {
       return new XmlAttributeDescriptor[0];
    }

    @Override
    public @Nullable XmlAttributeDescriptor getAttributeDescriptor(String attributeName, XmlTag context) {
        logger.debug("SpringSecurityAttributesProvider.getAttributeDescriptors(...) - attributeName ={"+attributeName+"}, xmlTag={"+context+"}");

        if(!(context.getDescriptor() instanceof HtmlElementDescriptorImpl)) {
            return null;
        }
        SpringSecurityAttributeInfo springSecurityAttributeInfo = new SpringSecurityAttributeInfo(attributeName);

        if(springSecurityAttributeInfo.isThymeleaf()){
            logger.debug("this is a thymeleaf attribute");
            return new SpringSecurityAttributeDescriptor(attributeName, context);
        }
        return null;
    }
}
