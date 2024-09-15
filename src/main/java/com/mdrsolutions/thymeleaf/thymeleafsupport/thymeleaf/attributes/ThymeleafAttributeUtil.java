package com.mdrsolutions.thymeleaf.thymeleafsupport.thymeleaf.attributes;

import com.intellij.openapi.diagnostic.Logger;
import com.mdrsolutions.thymeleaf.thymeleafsupport.base.AttributeUtil;

import java.util.HashMap;
import java.util.Map;

public class ThymeleafAttributeUtil extends AttributeUtil {

    private static final Logger logger = Logger.getInstance(ThymeleafAttributeUtil.class);
    private static volatile ThymeleafAttributeUtil instance;
    private final static Map<String, String> attributeDescriptions = new HashMap<>();

    private ThymeleafAttributeUtil() {
        logger.info("ThymeleafAttributeUtil constructor called");
        addAttributeDescriptions();
        addDescriptions();
    }

    public static ThymeleafAttributeUtil getInstance() {
        if (instance == null) {
            synchronized (ThymeleafAttributeUtil.class) {
                if (instance == null) {
                    logger.info("ThymeleafAttributeUtil instance being created");
                    instance = new ThymeleafAttributeUtil();
                }
            }
        }
        logger.info("ThymeleafAttributeUtil instance returned");
        return instance;
    }

    private void addAttributeDescriptions() {
        addAttributes(
                "th:text", "th:each", "th:if", "th:unless", "th:href", "layout:fragment", "th:src",
                "th:action", "th:class", "th:attr", "th:abbr", "th:accept", "th:accept-charset",
                "th:accesskey", "th:align", "th:alt", "th:archive", "th:audio", "th:autocomplete",
                "th:axis", "th:background", "th:bgcolor", "th:border", "th:cellpadding", "th:cellspacing",
                "th:challenge", "th:charset", "th:cite", "th:classid", "th:codebase", "th:codetype",
                "th:cols", "th:colspan", "th:compact", "th:content", "th:contenteditable", "th:contextmenu",
                "th:data", "th:datetime", "th:dir", "th:draggable", "th:dropzone", "th:enctype",
                "th:for", "th:form", "th:formaction", "th:formenctype", "th:formmethod", "th:formtarget",
                "th:frame", "th:frameborder", "th:headers", "th:height", "th:high", "th:hreflang",
                "th:hspace", "th:http-equiv", "th:icon", "th:id", "th:keytype", "th:kind", "th:label",
                "th:lang", "th:list", "th:longdesc", "th:low", "th:manifest", "th:marginheight",
                "th:marginwidth", "th:max", "th:maxlength", "th:media", "th:method", "th:min",
                "th:name", "th:optimum", "th:pattern", "th:placeholder", "th:poster", "th:preload",
                "th:radiogroup", "th:rel", "th:rev", "th:rows", "th:rowspan", "th:rules", "th:sandbox",
                "th:scheme", "th:scope", "th:scrolling", "th:size", "th:sizes", "th:span", "th:spellcheck",
                "th:srclang", "th:standby", "th:start", "th:step", "th:style", "th:summary",
                "th:tabindex", "th:target", "th:title", "th:type", "th:usemap", "th:value",
                "th:valuetype", "th:vspace", "th:width", "th:wrap", "th:xmlbase", "th:xmllang",
                "th:xmlspace", "th:with", "th:fragment", "th:case", "th:switch", "th:object", "th:utext",
                "th:insert");
    }
    // New method to add descriptions for attributes
    private void addDescriptions() {
        attributeDescriptions.put("th:text", "Inserts the result of evaluating the expression into the element as text, escaping any HTML.");
        attributeDescriptions.put("th:each", "Iterates over a collection and repeats the element for each item in the collection.");
        attributeDescriptions.put("th:if", "Conditionally includes or excludes an element based on the result of the expression.");
        attributeDescriptions.put("th:unless", "Conditionally excludes an element if the expression evaluates to true.");
        attributeDescriptions.put("th:href", "Sets the href attribute of an anchor (<a>) or link element.");
        attributeDescriptions.put("th:src", "Sets the src attribute of an image or other media element.");
        attributeDescriptions.put("th:action", "Sets the action attribute for form submissions.");
        attributeDescriptions.put("th:class", "Dynamically sets the class attribute based on the evaluation of the expression.");
        attributeDescriptions.put("th:attr", "Allows setting multiple attributes dynamically in one go.");
        attributeDescriptions.put("th:abbr", "Sets the abbreviation for a table header (<th>) element.");
        attributeDescriptions.put("th:accept", "Sets the file types accepted by an input element with type 'file'.");
        attributeDescriptions.put("th:accept-charset", "Specifies the character encodings that are acceptable for a form submission.");
        attributeDescriptions.put("th:accesskey", "Sets a keyboard shortcut to activate or focus an element.");
        attributeDescriptions.put("th:align", "Specifies the horizontal alignment of an element.");
        attributeDescriptions.put("th:alt", "Sets the alt text for an image.");
        attributeDescriptions.put("th:archive", "Specifies the archive files required for a plugin or applet.");
        attributeDescriptions.put("th:audio", "Sets the source of an audio element.");
        attributeDescriptions.put("th:autocomplete", "Indicates whether a form input should have autocomplete enabled.");
        attributeDescriptions.put("th:axis", "Associates table headers with particular rows or columns.");
        attributeDescriptions.put("th:background", "Sets the background image for an element.");
        attributeDescriptions.put("th:bgcolor", "Specifies the background color of an element.");
        attributeDescriptions.put("th:border", "Sets the border size for an element, typically used in tables.");
        attributeDescriptions.put("th:cellpadding", "Specifies the padding inside table cells.");
        attributeDescriptions.put("th:cellspacing", "Defines the space between the borders of table cells.");
        attributeDescriptions.put("th:challenge", "Indicates that a request must be authenticated, typically used in HTTP requests.");
        attributeDescriptions.put("th:charset", "Sets the character encoding for a document.");
        attributeDescriptions.put("th:cite", "Defines the source of a quote or citation.");
        attributeDescriptions.put("th:classid", "Specifies the class identifier of an object element.");
        attributeDescriptions.put("th:codebase", "Specifies the base URL for an applet.");
        attributeDescriptions.put("th:codetype", "Defines the type of code used in an object element.");
        attributeDescriptions.put("th:cols", "Sets the number of columns in a textarea or table.");
        attributeDescriptions.put("th:colspan", "Defines how many columns a table cell should span.");
        attributeDescriptions.put("th:compact", "Indicates that a list should be rendered in a compact style.");
        attributeDescriptions.put("th:content", "Sets the content attribute of a meta element.");
        attributeDescriptions.put("th:contenteditable", "Indicates whether the element's content is editable.");
        attributeDescriptions.put("th:contextmenu", "Attaches a context menu to the element.");
        attributeDescriptions.put("th:data", "Sets custom data-* attributes on an element.");
        attributeDescriptions.put("th:datetime", "Sets the date and time value for elements like <time>.");
        attributeDescriptions.put("th:dir", "Specifies the text direction for an element.");
        attributeDescriptions.put("th:draggable", "Indicates whether an element can be dragged.");
        attributeDescriptions.put("th:dropzone", "Specifies where an element can be dropped during a drag-and-drop operation.");
        attributeDescriptions.put("th:enctype", "Defines the encoding type of a form when submitting data.");
        attributeDescriptions.put("th:for", "Links a label to a form input by its id.");
        attributeDescriptions.put("th:form", "Defines which form an element belongs to.");
        attributeDescriptions.put("th:formaction", "Specifies the action URL for a form element.");
        attributeDescriptions.put("th:formenctype", "Specifies the encoding type used for form data.");
        attributeDescriptions.put("th:formmethod", "Defines the HTTP method used to submit a form.");
        attributeDescriptions.put("th:formtarget", "Specifies where to display the response after submitting a form.");
        attributeDescriptions.put("th:frame", "Specifies the frameset layout for a document.");
        attributeDescriptions.put("th:frameborder", "Indicates whether a frame should have a border.");
        attributeDescriptions.put("th:headers", "Specifies the headers associated with a table cell.");
        attributeDescriptions.put("th:height", "Sets the height of an element.");
        attributeDescriptions.put("th:high", "Specifies the high value in a range input.");
        attributeDescriptions.put("th:hreflang", "Indicates the language of the linked resource.");
        attributeDescriptions.put("th:hspace", "Defines the horizontal space around an element.");
        attributeDescriptions.put("th:http-equiv", "Sets an HTTP header from within a meta tag.");
        attributeDescriptions.put("th:icon", "Defines an icon for an element, often used in a link.");
        attributeDescriptions.put("th:id", "Sets the unique identifier of an element.");
        attributeDescriptions.put("th:keytype", "Specifies the type of key used in a keygen element.");
        attributeDescriptions.put("th:kind", "Specifies the kind of track for media elements (subtitles, captions, etc.).");
        attributeDescriptions.put("th:label", "Associates a label with an input element.");
        attributeDescriptions.put("th:lang", "Specifies the language of the element's content.");
        attributeDescriptions.put("th:list", "Links an input field to a datalist element.");
        attributeDescriptions.put("th:longdesc", "Provides a long description of an image.");
        attributeDescriptions.put("th:low", "Indicates the low value in a range input.");
        attributeDescriptions.put("th:manifest", "Specifies the URL of the document's cache manifest.");
        attributeDescriptions.put("th:marginheight", "Sets the top and bottom margins of a frame.");
        attributeDescriptions.put("th:marginwidth", "Sets the left and right margins of a frame.");
        attributeDescriptions.put("th:max", "Defines the maximum value for a range or number input.");
        attributeDescriptions.put("th:maxlength", "Limits the number of characters an input field can accept.");
        attributeDescriptions.put("th:media", "Specifies the media type for a linked resource.");
        attributeDescriptions.put("th:method", "Defines the HTTP method used in form submission (GET or POST).");
        attributeDescriptions.put("th:min", "Defines the minimum value for a range or number input.");
        attributeDescriptions.put("th:name", "Specifies the name of a form control.");
        attributeDescriptions.put("th:optimum", "Specifies the optimal value in a range input.");
        attributeDescriptions.put("th:pattern", "Defines a regex pattern for form validation.");
        attributeDescriptions.put("th:placeholder", "Sets a placeholder text for an input field.");
        attributeDescriptions.put("th:poster", "Specifies an image to be shown while a video is downloading.");
        attributeDescriptions.put("th:preload", "Defines how the browser should preload a video or audio element.");
        attributeDescriptions.put("th:radiogroup", "Specifies the group of radio buttons an input belongs to.");
        attributeDescriptions.put("th:rel", "Defines the relationship between a linked resource and the document.");
        attributeDescriptions.put("th:rev", "Defines the reverse relationship between a linked resource and the document.");
        attributeDescriptions.put("th:rows", "Specifies the number of rows in a textarea or table.");
        attributeDescriptions.put("th:rowspan", "Specifies how many rows a cell in a table should span.");
        attributeDescriptions.put("th:rules", "Specifies the rules for rendering table borders.");
        attributeDescriptions.put("th:sandbox", "Applies extra restrictions to the content within an iframe.");
        attributeDescriptions.put("th:scheme", "Specifies a scheme for a URI.");
        attributeDescriptions.put("th:scope", "Defines the scope of a table header cell.");
        attributeDescriptions.put("th:scrolling", "Specifies whether scrolling is allowed in an iframe.");
        attributeDescriptions.put("th:size", "Specifies the size of an input field or the number of visible options in a select.");
        attributeDescriptions.put("th:sizes", "Defines the size of linked resources for different devices.");
        attributeDescriptions.put("th:span", "Specifies the number of columns a colgroup element should span.");
        attributeDescriptions.put("th:spellcheck", "Enables or disables spell checking for an element.");
        attributeDescriptions.put("th:srclang", "Specifies the language of a text track in a media element.");
        attributeDescriptions.put("th:standby", "Specifies a message to show while an object is loading.");
        attributeDescriptions.put("th:start", "Defines the starting value for an ordered list.");
        attributeDescriptions.put("th:step", "Specifies the step interval for a range or number input.");
        attributeDescriptions.put("th:style", "Sets inline CSS styles for an element.");
        attributeDescriptions.put("th:summary", "Defines a summary for a table's content.");
        attributeDescriptions.put("th:tabindex", "Specifies the tab order of an element.");
        attributeDescriptions.put("th:target", "Defines the target window or frame for a link or form submission.");
        attributeDescriptions.put("th:title", "Sets the title attribute of an element.");
        attributeDescriptions.put("th:type", "Specifies the type of an input element.");
        attributeDescriptions.put("th:usemap", "Associates an image with a client-side image map.");
        attributeDescriptions.put("th:value", "Sets the value of an input field.");
        attributeDescriptions.put("th:valuetype", "Specifies the type of value for an object element.");
        attributeDescriptions.put("th:vspace", "Defines vertical space around an element.");
        attributeDescriptions.put("th:width", "Sets the width of an element.");
        attributeDescriptions.put("th:wrap", "Specifies how text in a textarea should be wrapped.");
        attributeDescriptions.put("th:xmlbase", "Specifies the base URI for an XML document.");
        attributeDescriptions.put("th:xmllang", "Specifies the language of an XML document.");
        attributeDescriptions.put("th:xmlspace", "Defines the space handling rules for XML content.");
        attributeDescriptions.put("th:with", "Allows adding local variables to expressions.");
        attributeDescriptions.put("th:fragment", "Defines a reusable fragment of code for the template.");
        attributeDescriptions.put("th:case", "Represents a case within a switch statement.");
        attributeDescriptions.put("th:switch", "Evaluates an expression and applies the corresponding case block.");
        attributeDescriptions.put("th:object", "Represents a complex object and binds its properties.");
        attributeDescriptions.put("th:utext", "Inserts unescaped text from the evaluation of an expression.");
        attributeDescriptions.put("th:insert", "Inserts the content of a fragment or another template into the current template, similar to an include.");

    }

    // Method to get the description of a Thymeleaf attribute
    public static String getAttributeDescription(String attributeName) {
        return attributeDescriptions.getOrDefault(attributeName, "No description available");
    }

}
