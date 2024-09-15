package com.mdrsolutions.thymeleaf.thymeleafsupport.base;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AttributeUtil {

    protected final Set<String> attributes = new HashSet<>();

    public Set<String> getAttributes() {
        return attributes;
    }

    protected void addAttributes(String... attrs) {
        Collections.addAll(attributes, attrs);
    }
}
