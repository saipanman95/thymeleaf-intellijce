package com.mdrsolutions.thymeleaf.thymeleafsupport.listeners;

import com.intellij.javaee.ExternalResourceManagerEx;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileOpenedSyncListener;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.fileEditor.ex.FileEditorWithProvider;
import com.intellij.openapi.util.CheckedDisposable;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.vfs.VirtualFile;
import com.mdrsolutions.thymeleaf.thymeleafsupport.namespace.ThymeleafNamespaceRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.intellij.xml.util.HtmlUtil.isHtmlFile;

public final class UriIgnoreResourceFileOpenListener implements FileOpenedSyncListener {
    private static final Logger logger = Logger.getInstance(UriIgnoreResourceFileOpenListener.class);
    private static final String[] IGNORED_RESOURCES = ThymeleafNamespaceRegistry.getNamespaces().values().toArray( new String[0]);
    private static final String GROUP_ID = "UriIgnoreResource";

    @Override
    public void fileOpenedSync(@NotNull FileEditorManager source, @NotNull VirtualFile file, @NotNull List<FileEditorWithProvider> editorsWithProviders) {

        for (FileEditorWithProvider editorWrapper : editorsWithProviders) {
            var fileEditor = editorWrapper.getFileEditor();
            if (fileEditor instanceof TextEditor && isHtmlFile(file)) {
                initializeIgnoredResources();
            }
        }
    }

    public void initializeIgnoredResources() {
        logger.info("UriIgnoreResourceFileOpenListener.initializeIgnoredResources()");
        ApplicationManager.getApplication().invokeLater(() -> ApplicationManager.getApplication().runWriteAction(() -> {
            ExternalResourceManagerEx externalResourceManager = ExternalResourceManagerEx.getInstanceEx();
            if (externalResourceManager != null) {

                List<String> currentIgnoredResources = Arrays.asList(externalResourceManager.getIgnoredResources());
                List<String> resourcesToAdd = new ArrayList<>();

                // Check if each resource is already ignored
                for (String resource : IGNORED_RESOURCES) {
                    if (!currentIgnoredResources.contains(resource)) {
                        resourcesToAdd.add(resource);
                    }
                }

                if (!resourcesToAdd.isEmpty()) {
                    logger.info("Adding ignored resources: " + resourcesToAdd);
                    CheckedDisposable disposable = Disposer.newCheckedDisposable();
                    externalResourceManager.addIgnoredResources(resourcesToAdd, disposable);
                    logger.info("initializeIgnoredResources() - added: " + resourcesToAdd);
                    Notifications.Bus.notify(new Notification(GROUP_ID, "DTD and URI Resources", "Related Thymeleaf Layout Namespaces have been safely ignored.", NotificationType.INFORMATION));
                } else {
                    logger.info("All resources are already ignored. No action needed.");
                }
            } else {
                logger.info("externalResourceManager is null - operation skipped");
            }
        }));
    }
}