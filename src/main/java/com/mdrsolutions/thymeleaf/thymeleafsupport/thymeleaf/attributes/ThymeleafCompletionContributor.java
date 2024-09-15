package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.xml.XmlTokenType;

public class ThymeleafCompletionContributor extends CompletionContributor {
    private static final String[] PREFIXES = { "th:", "sec:", "layout:"};
    private static final Logger logger = Logger.getInstance(ThymeleafCompletionContributor.class);
    public ThymeleafCompletionContributor() {
        logger.info("ThymeleafCompletionContributor loaded");
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement(XmlTokenType.XML_NAME)
                        .withParent(XmlPatterns.xmlAttribute()),
                new ThymeleafAttributeCompletionProvider()
        );
    }
}
