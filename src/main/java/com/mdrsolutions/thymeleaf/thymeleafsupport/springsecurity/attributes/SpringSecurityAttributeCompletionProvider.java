package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.namespace.ThymeleafNamespaceRegistry;

import javax.swing.*;

public class SpringSecurityAttributeCompletionProvider extends BaseAttributeCompletionProvider {

    private static final Logger logger = Logger.getInstance(SpringSecurityAttributeCompletionProvider.class);


    @Override
    protected void addCompletionsForType(CompletionParameters parameters, CompletionResultSet resultSet, AttributeUtil attributeUtil) {
        SpringSecurityAttributeUtil.getInstance().getAttributes().forEach(attribute -> resultSet.addElement(buildLookupElement(attribute, SpringSecurityAttributeUtil.getAttributeDescription(attribute))));
    }

    private LookupElementBuilder buildLookupElement(String attribute, String typeText) {
        return LookupElementBuilder.create(attribute)
                .withCaseSensitivity(false)
                .withIcon(Thymeleaf.ICON)
                .withTypeText(typeText);
    }

    @Override
    protected String getAttributeStartingChars() {
        return SPRING_SECURITY_ATTRIBUTE;
    }

    @Override
    protected AttributeUtil getAttributeUtil() {
        return SpringSecurityAttributeUtil.getInstance();
    }

    @Override
    public String getNamespaceAttr() {
        return ThymeleafNamespaceRegistry.NamespaceAttribute.SPRING_SECURITY.getAttribute();
    }

    @Override
    public String getNamespaceValue() {
        return ThymeleafNamespaceRegistry.getNamespaceValue(ThymeleafNamespaceRegistry.NamespaceAttribute.SPRING_SECURITY);
    }

    @Override
    public Icon getIcon() {
        return Thymeleaf.ICON;
    }

    @Override
    protected SpringSecurityAutoCompleteSuggestions createSuggestions(HtmlTag tag, String partialAttribute) {
        return new SpringSecurityAutoCompleteSuggestions(tag, partialAttribute);
    }
}
