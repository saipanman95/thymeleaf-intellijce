package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.xml.XmlTokenType;

public class LayoutCompletionContributor extends CompletionContributor {

    private static final Logger logger = Logger.getInstance(LayoutCompletionContributor.class);
    public LayoutCompletionContributor() {
        logger.info("LayoutCompletionContributor loaded");
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement(XmlTokenType.XML_NAME)
                        .withParent(XmlPatterns.xmlAttribute()),
                new LayoutAttributeCompletionProvider()
        );
    }
}
