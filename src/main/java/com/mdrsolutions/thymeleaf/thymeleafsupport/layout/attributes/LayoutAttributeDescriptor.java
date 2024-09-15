package com.mdrsolutions.thymeleaf.thymeleafsupport.layout.attributes;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.meta.PsiPresentableMetaData;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.ArrayUtil;
import com.intellij.xml.impl.BasicXmlAttributeDescriptor;
import com.mdrsolutions.thymeleaf.thymeleafsupport.Thymeleaf;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LayoutAttributeDescriptor extends BasicXmlAttributeDescriptor implements PsiPresentableMetaData {
    public LayoutAttributeDescriptor(String attributeName, XmlTag context) {
        info = new LayoutAttributeInfo(attributeName);
        icon = Thymeleaf.ICON;
        name = attributeName;
        xmlTag = context;
    }

    private final String name;
    private final XmlTag xmlTag;
    private final LayoutAttributeInfo info;
    private final Icon icon;

    @Override
    public @Nullable @Nls String getTypeName() {
        return info.getTypeText();
    }

    @Override
    public @Nullable Icon getIcon() {
        return icon;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public boolean hasIdType() {
        return name.equalsIgnoreCase("id");
    }

    @Override
    public boolean hasIdRefType() {
        return false;
    }

    @Override
    public boolean isEnumerated() {
        return !info.hasValue();
    }

    @Override
    public PsiElement getDeclaration() {
        return xmlTag;
    }

    @Override
    public @NlsSafe String getName() {
        return name;
    }

    @Override
    public void init(PsiElement element) {

    }

    @Override
    public boolean isFixed() {
        return false;
    }

    @Override
    public String getDefaultValue() {
        return "";
    }

    @Override
    public String[] getEnumeratedValues() {
        return ArrayUtil.EMPTY_STRING_ARRAY;
    }
}
