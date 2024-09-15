package com.mdrsolutions.thymeleaf.thymeleafsupport.base;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.html.HtmlTag;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.ProcessingContext;
import com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes.ThymeleafAttributeUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

public abstract class BaseAttributeCompletionProvider extends CompletionProvider<CompletionParameters> {

    protected abstract void addCompletionsForType(CompletionParameters parameters,
                                                  CompletionResultSet resultSet,
                                                  AttributeUtil attributeUtil);

    protected abstract String getAttributeStartingChars();
    protected abstract AttributeUtil getAttributeUtil();
    public abstract String getNamespaceAttr();
    public abstract String getNamespaceValue();
    public abstract Icon getIcon(); // Abstract method for icon
    protected abstract AutoCompleteSuggestionsBase<?> createSuggestions(HtmlTag tag, String partialAttribute);

    private static final Logger logger = Logger.getLogger(BaseAttributeCompletionProvider.class.getName());

    @Override
    protected void addCompletions(CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet result) {
        PsiElement position = parameters.getPosition();
        if (!(position.getParent() instanceof XmlAttribute attribute)) {
            return;
        }

        // Ensure parent element is HtmlTag
        if (!(attribute.getParent() instanceof HtmlTag xmlTag)) {
            return;
        }

        String partialAttribute = StringUtil.trimEnd(attribute.getName(), CompletionUtilCore.DUMMY_IDENTIFIER_TRIMMED);
        if (partialAttribute.isEmpty()) {
            return;
        }

        // Retrieve suggestions based on the specific AttributeUtil
        AutoCompleteSuggestionsBase<?> suggestions = createSuggestions(xmlTag, partialAttribute);

        CompletionResultSet filteredResult = result.withPrefixMatcher(partialAttribute);

        suggestions.getAttributes().forEach(it -> {
            String text = it.getAttribute();

                LookupElementBuilder elementBuilder = LookupElementBuilder.create(text)
                        .withCaseSensitivity(false)
                        .withIcon(getIcon())
                        .withTypeText(it.getDescription())
                        .withInsertHandler((insertionContext, item) -> {
                            PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(insertionContext.getProject());
                            psiDocumentManager.commitDocument(insertionContext.getDocument());

                            XmlAttributeInsertHandler.INSTANCE.handleInsert(insertionContext, item);
                            InitiateXMLNamespace.writeNamespace(text, insertionContext);
                        });
                filteredResult.addElement(elementBuilder);
        });

        // Add the attribute completions
        //addCompletionsForType(parameters, filteredResult, getAttributeUtil());
    }
}
