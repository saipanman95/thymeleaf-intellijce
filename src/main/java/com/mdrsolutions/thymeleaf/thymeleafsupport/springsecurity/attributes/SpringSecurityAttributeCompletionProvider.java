package com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes.LayoutAttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes.LayoutAutoCompleteSuggestions;

import javax.swing.*;

public class SpringSecurityAttributeCompletionProvider extends BaseAttributeCompletionProvider {

    private static final Logger logger = Logger.getInstance(SpringSecurityAttributeCompletionProvider.class);


    @Override
    protected void addCompletionsForType(CompletionParameters parameters, CompletionResultSet resultSet, AttributeUtil attributeUtil) {
        SpringSecurityAttributeUtil.getInstance().getAttributes().forEach(attribute ->{
            resultSet.addElement(buildLookupElement(attribute, SpringSecurityAttributeUtil.getAttributeDescription(attribute)));
        });
    }

    private LookupElementBuilder buildLookupElement(String attribute, String typeText) {
        return LookupElementBuilder.create(attribute)
                .withCaseSensitivity(false)
                .withIcon(Thymeleaf.ICON) // Assuming Thymeleaf.ICON is already defined
                .withTypeText(typeText);
    }

    @Override
    protected String getAttributeStartingChars() {
        return "sec:";
    }

    @Override
    protected AttributeUtil getAttributeUtil() {
        return SpringSecurityAttributeUtil.getInstance();
    }

    @Override
    public String getNamespaceAttr() {
        return "xmlns:sec";
    }

    @Override
    public String getNamespaceValue() {
        return "http://www.thymeleaf.org/thymeleaf-extras-springsecurity6";
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
