package com.mdrsolutions.thymeleaf.thymeleafsupport.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications.Bus;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.nio.charset.StandardCharsets;

public class AddThymeleafNamespace extends BaseThymeleafNamespaceAction {
    private static final Logger logger = Logger.getInstance(AddThymeleafNamespace.class);

    public AddThymeleafNamespace() {
        super("HtmlThymeleaf");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        logger.info("HtmlThymeleaf.actionPerformed(...)");
        PsiFile selectedFile = this.getSelectedPropertiesFile(anActionEvent, true, getGroupId());
        if (selectedFile != null) {
            Project project = anActionEvent.getProject();
            if (project != null) {
                // Run the write action in the proper context
                ApplicationManager.getApplication().runWriteAction(() -> {
                    try {
                        VirtualFile htmlFile = selectedFile.getVirtualFile();
                        String content = new String(htmlFile.contentsToByteArray(), StandardCharsets.UTF_8);

                        // Parse the HTML content using JSoup
                        Document document = Jsoup.parse(content);

                        // Get the root <html> element
                        Element htmlElement = document.selectFirst("html");
                        if (htmlElement != null && !htmlElement.hasAttr(THYMELEAF_NAMESPACE.getAttribute())) {
                            // Add the "xmlns:th" attribute if it's not already present
                            htmlElement.attr(
                                    THYMELEAF_NAMESPACE.getAttribute(),
                                    THYMELEAF_NAMESPACE_URI);
                        }

                        // Convert the modified document back to string
                        String newModifiedHtml = document.outerHtml();

                        // Update the file content
                        htmlFile.setBinaryContent(newModifiedHtml.getBytes(StandardCharsets.UTF_8));

                        Bus.notify(new Notification(getGroupId(), "File transformed", "Thymeleaf Namespace '"+THYMELEAF_NAMESPACE.getAttribute()+ "\""+THYMELEAF_NAMESPACE_URI+ "\"' added to html tag successfully.", NotificationType.INFORMATION));
                    } catch (Exception e) {
                        Bus.notify(new Notification(getGroupId(), "Cannot write file", e.getMessage(), NotificationType.ERROR));
                    }
                });
            }
        }
    }

}




