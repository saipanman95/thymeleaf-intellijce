package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.html.HtmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.BaseAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;

import javax.swing.Icon;

public class ThymeleafAttributeCompletionProvider extends BaseAttributeCompletionProvider {

    private static final Logger logger = Logger.getInstance(ThymeleafAttributeCompletionProvider.class);

    @Override
    protected void addCompletionsForType(CompletionParameters parameters, CompletionResultSet resultSet, AttributeUtil attributeUtil) {
        ThymeleafAttributeUtil.getInstance().getAttributes().forEach(attribute -> {
            resultSet.addElement(buildLookupElement(attribute, ThymeleafAttributeUtil.getAttributeDescription(attribute)));
        });
    }

    @Override
    protected ThymeleafAutoCompleteSuggestions createSuggestions(HtmlTag tag, String partialAttribute) {
        return new ThymeleafAutoCompleteSuggestions(tag, partialAttribute);
    }

    // Define the buildLookupElement method that creates the lookup element
    private LookupElementBuilder buildLookupElement(String attribute, String typeText) {
        return LookupElementBuilder.create(attribute)
                .withCaseSensitivity(false)
                .withIcon(Thymeleaf.ICON) // Assuming Thymeleaf.ICON is already defined
                .withTypeText(typeText);
    }

    @Override
    protected AttributeUtil getAttributeUtil() {
        return ThymeleafAttributeUtil.getInstance();
    }

    @Override
    protected String getAttributeStartingChars() {
        return "th:";
    }

    @Override
    public String getNamespaceAttr() {
        return "xmlns:th";
    }

    @Override
    public String getNamespaceValue() {
        return "http://www.thymeleaf.org";
    }

    @Override
    public Icon getIcon() {
        return Thymeleaf.ICON;  // Assuming `Thymeleaf.ICON` is an Icon object
    }
}
