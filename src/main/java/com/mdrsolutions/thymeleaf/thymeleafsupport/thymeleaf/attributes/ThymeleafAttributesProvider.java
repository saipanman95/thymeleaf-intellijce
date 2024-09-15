package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.impl.source.html.dtd.HtmlElementDescriptorImpl;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlAttributeDescriptor;
import com.intellij.xml.XmlAttributeDescriptorsProvider;
import org.jetbrains.annotations.Nullable;

public class ThymeleafAttributesProvider implements XmlAttributeDescriptorsProvider {
    private static final Logger logger = Logger.getInstance(ThymeleafAttributesProvider.class);

    @Override
    public XmlAttributeDescriptor[] getAttributeDescriptors(XmlTag context) {
        return new XmlAttributeDescriptor[0];
    }

    @Override
    public @Nullable XmlAttributeDescriptor getAttributeDescriptor(String attributeName, XmlTag context) {
        logger.debug("AttributesProvider.getAttributeDescriptor(...) - attributeName ={"+attributeName+"}, xmlTag={"+context+"}");

        if(!(context.getDescriptor() instanceof HtmlElementDescriptorImpl)) {
            return null;
        }
        ThymeleafAttributeInfo thymeleafAttributeInfo = new ThymeleafAttributeInfo(attributeName);

        if(thymeleafAttributeInfo.isThymeleaf()){
            logger.debug("this is a thymeleaf attribute");
            return new ThymeleafAttributeDescriptor(attributeName, context);
        }
        return null;
    }
}
