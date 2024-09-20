package com.mdrsolutions.thymeleaf.thymeleafsupport.base;

import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlTag;
import com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes.LayoutAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.springsecurity.attributes.SpringSecurityAttributeCompletionProvider;
import com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes.ThymeleafAttributeCompletionProvider;

public class InitiateXMLNamespace {

    private static final Logger logger = Logger.getInstance(InitiateXMLNamespace.class);
    private static final String HTML = "html";

    public static void writeNamespace(
            String text,
            InsertionContext insertionContext){

        PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(insertionContext.getProject());
        psiDocumentManager.commitAllDocuments();

        final BaseAttributeCompletionProvider thymeProvider = new ThymeleafAttributeCompletionProvider();
        final BaseAttributeCompletionProvider layoutProvider = new LayoutAttributeCompletionProvider();
        final BaseAttributeCompletionProvider secProvider = new SpringSecurityAttributeCompletionProvider();

        if (text.startsWith(thymeProvider.getAttributeStartingChars())) {
            // Handle Thymeleaf namespace

            ApplicationManager.getApplication().invokeLater(() -> WriteCommandAction.runWriteCommandAction(insertionContext.getProject(), () -> {
                PsiElement element = insertionContext.getFile().findElementAt(insertionContext.getStartOffset());
                if (element != null) {
                    XmlTag rootTag = findRootTag(element);
                    if (rootTag != null) {
                        checkAndInsertNamespace(
                                rootTag,
                                insertionContext.getFile(),
                                thymeProvider.getNamespaceAttr(),
                                thymeProvider.getNamespaceValue());
                    }
                }
            }));
        } else if (text.startsWith(layoutProvider.getAttributeStartingChars())) {
            // Handle Layout namespace
            ApplicationManager.getApplication().invokeLater(() -> WriteCommandAction.runWriteCommandAction(insertionContext.getProject(), () -> {
                PsiElement element = insertionContext.getFile().findElementAt(insertionContext.getStartOffset());
                if (element != null) {
                    XmlTag rootTag = findRootTag(element);
                    if (rootTag != null) {
                        checkAndInsertNamespace(
                                rootTag,
                                insertionContext.getFile(),
                                layoutProvider.getNamespaceAttr(),
                                layoutProvider.getNamespaceValue());
                    }
                }
            }));
        } else if (text.startsWith(secProvider.getAttributeStartingChars())){
            ApplicationManager.getApplication().invokeLater(() -> WriteCommandAction.runWriteCommandAction(insertionContext.getProject(), () -> {
                PsiElement element = insertionContext.getFile().findElementAt(insertionContext.getStartOffset());
                if (element != null) {
                    XmlTag rootTag = findRootTag(element);
                    if (rootTag != null) {
                        checkAndInsertNamespace(
                                rootTag,
                                insertionContext.getFile(),
                                secProvider.getNamespaceAttr(),
                                secProvider.getNamespaceValue());
                    }
                }
            }));
        }
    }

    // Helper method to check for namespace and insert if missing
    private static void checkAndInsertNamespace(XmlTag rootTag, PsiFile file, String namespaceAttr, String namespaceValue) {
        if (rootTag != null && rootTag.getAttribute(namespaceAttr) == null) {
            WriteCommandAction.runWriteCommandAction(file.getProject(), () -> {
                rootTag.setAttribute(namespaceAttr, namespaceValue);
            });
        }
    }

    // Updated findRootTag method to correctly walk up the PSI tree
    protected static XmlTag findRootTag(PsiElement currentElement) {
        PsiElement parentElement = currentElement;
        while (parentElement != null) {
            if (parentElement instanceof XmlTag xmlTag) {
                if (HTML.equalsIgnoreCase(xmlTag.getName())) {
                    return xmlTag;
                }
            }
            parentElement = parentElement.getParent();
        }
        return null;
    }

}
