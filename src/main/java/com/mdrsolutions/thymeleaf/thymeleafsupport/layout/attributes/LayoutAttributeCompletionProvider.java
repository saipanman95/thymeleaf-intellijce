package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;

import javax.swing.*;

public class LayoutAttributeCompletionProvider extends BaseAttributeCompletionProvider {

    private static final Logger logger = Logger.getInstance(LayoutAttributeCompletionProvider.class);


    @Override
    protected void addCompletionsForType(CompletionParameters parameters, CompletionResultSet resultSet, AttributeUtil attributeUtil) {
        LayoutAttributeUtil.getInstance().getAttributes().forEach(attribute ->{
            resultSet.addElement(buildLookupElement(attribute, LayoutAttributeUtil.getAttributeDescription(attribute)));
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
        return "layout:";
    }

    @Override
    protected AttributeUtil getAttributeUtil() {
        return LayoutAttributeUtil.getInstance();
    }

    @Override
    public String getNamespaceAttr() {
        return "xmlns:layout";
    }

    @Override
    public String getNamespaceValue() {
        return "http://www.ultraq.net.nz/thymeleaf/layout";
    }

    @Override
    public Icon getIcon() {
        return Thymeleaf.ICON;
    }

    @Override
    protected LayoutAutoCompleteSuggestions createSuggestions(HtmlTag tag, String partialAttribute) {
        return new LayoutAutoCompleteSuggestions(tag, partialAttribute);
    }
}
