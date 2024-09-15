package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.intellij.psi.impl.source.html.dtd.HtmlElementDescriptorImpl;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlAttributeDescriptor;
import com.intellij.xml.XmlAttributeDescriptorsProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes.ThymeleafAttributeDescriptor;
import com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes.ThymeleafAttributeInfo;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LayoutAttributesProvider implements XmlAttributeDescriptorsProvider {
    private static final Logger logger = Logger.getInstance(LayoutAttributesProvider.class);

    @Override
    public XmlAttributeDescriptor[] getAttributeDescriptors(XmlTag context) {
       return new XmlAttributeDescriptor[0];
    }

    @Override
    public @Nullable XmlAttributeDescriptor getAttributeDescriptor(String attributeName, XmlTag context) {
        logger.debug("LayoutAttributesProvider.getAttributeDescriptors(...) - attributeName ={"+attributeName+"}, xmlTag={"+context+"}");

        if(!(context.getDescriptor() instanceof HtmlElementDescriptorImpl)) {
            return null;
        }
        LayoutAttributeInfo layoutAttributeInfo = new LayoutAttributeInfo(attributeName);

        if(layoutAttributeInfo.isThymeleaf()){
            logger.debug("this is a thymeleaf attribute");
            return new LayoutAttributeDescriptor(attributeName, context);
        }
        return null;
    }
}
