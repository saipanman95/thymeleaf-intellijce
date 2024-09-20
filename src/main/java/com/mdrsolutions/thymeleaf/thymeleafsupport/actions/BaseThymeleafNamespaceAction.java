package com.mdrsolutions.thymeleaf.thymeleafsupport.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.PsiFile;
import com.mdrsolutions.thymeleaf.thymeleafsupport.namespace.ThymeleafNamespaceRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseThymeleafNamespaceAction extends AnAction {
    private static final Logger logger = Logger.getInstance(BaseThymeleafNamespaceAction.class);

    protected static final ThymeleafNamespaceRegistry.NamespaceAttribute THYMELEAF_SPRING_SECURITY_NAMESPACE = ThymeleafNamespaceRegistry.NamespaceAttribute.SPRING_SECURITY;
    protected static final String THYMELEAF_SPRING_SECURITY_NAMESPACE_URI =ThymeleafNamespaceRegistry.getNamespaces().get(THYMELEAF_SPRING_SECURITY_NAMESPACE);

    protected static final ThymeleafNamespaceRegistry.NamespaceAttribute THYMELEAF_LAYOUT_NAMESPACE = ThymeleafNamespaceRegistry.NamespaceAttribute.LAYOUT;
    protected static final String THYMELEAF_LAYOUT_NAMESPACE_URI =ThymeleafNamespaceRegistry.getNamespaces().get(THYMELEAF_LAYOUT_NAMESPACE);

    protected static final ThymeleafNamespaceRegistry.NamespaceAttribute THYMELEAF_NAMESPACE = ThymeleafNamespaceRegistry.NamespaceAttribute.THYMELEAF;
    protected static final String THYMELEAF_NAMESPACE_URI =ThymeleafNamespaceRegistry.getNamespaces().get(THYMELEAF_NAMESPACE);

    private final String groupId;

    public BaseThymeleafNamespaceAction(String groupId) {
        this.groupId = groupId;
    }
    protected String getGroupId() {
        return this.groupId;
    }

    @Override
    public void update(@NotNull AnActionEvent anActionEvent) {
        logger.info("AddThymeleafLayoutNamespace.update(...)");
        PsiFile selectedFile = getSelectedPropertiesFile(anActionEvent, false, getGroupId());
        anActionEvent.getPresentation().setEnabledAndVisible(selectedFile != null);
    }

    @Nullable
    protected PsiFile getSelectedPropertiesFile(@NotNull AnActionEvent anActionEvent, boolean showNotifications, String groupId) {
        logger.info("BaseThymeleafNamespaceAction.getSelectedPropertiesFile(...)");
        PsiFile selectedFile = anActionEvent.getData(LangDataKeys.PSI_FILE);
        if (selectedFile == null) {
            if (showNotifications) {
                Notifications.Bus.notify(new Notification(groupId, "No file selected", "Please select an HTML file first", NotificationType.ERROR));
            }
            return null;
        } else {
            LanguageFileType html = (LanguageFileType) FileTypeManager.getInstance().getStdFileType("HTML");
            if (!html.equals(selectedFile.getFileType())) {
                if (showNotifications) {
                    Notifications.Bus.notify(new Notification(groupId, "Incorrect file selected", "Please select an HTML file", NotificationType.ERROR));
                }
                return null;
            } else {
                return selectedFile;
            }
        }
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        logger.info("BaseThymeleafNamespaceAction.getActionUpdateThread(...)");
        return ActionUpdateThread.BGT;
    }
}
