package com.mdrsolutions.thymeleaf.thymeleafsupport.base;

public abstract class BaseAttributeInfo {

    private final String name;
    private final boolean isThymeleaf;

    public BaseAttributeInfo(String name, boolean isThymeleaf) {
        this.name = name;
        this.isThymeleaf = isThymeleaf;
    }

    public String getAttribute() {
        return name;
    }

    public abstract Boolean isAttribute();  // Abstract method to be implemented in subclasses

    public abstract String getDescription();

    public boolean hasValue() {
        return name.contains(":");
    }

    public String getTypeText() {
        return buildTypeText();
    }

    public boolean isThymeleaf() {
        return this.isThymeleaf;
    }

    protected String buildTypeText() {
        return this.isThymeleaf ? "Thymeleaf Attribute" : "Layout Attribute";
    }

}
