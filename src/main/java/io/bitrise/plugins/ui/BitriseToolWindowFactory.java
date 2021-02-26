package io.bitrise.plugins.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.BuildLogService;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.service.DefaultBuildLogService;
import io.bitrise.plugins.service.DefaultBuildService;
import io.bitrise.plugins.service.FocusedAppService;
import io.bitrise.plugins.ui.context.UiApplicationContext;
import io.bitrise.plugins.store.ApplicationStore;
import io.bitrise.plugins.store.DefaultApplicationStore;
import io.bitrise.plugins.ui.component.PluginSettings;
import io.bitrise.plugins.ui.window.BuildListWindow;
import io.bitrise.plugins.ui.window.WorkflowListWindow;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BitriseToolWindowFactory implements ToolWindowFactory {
    private UiApplicationContext uiApplicationContext;

    public BitriseToolWindowFactory() {
        PluginSettings settings = PluginSettings.getInstance();

        AppService appService = new FocusedAppService(settings);
        BuildService buildService = new DefaultBuildService(settings);
        BuildLogService buildLogService = new DefaultBuildLogService(settings);

        ApplicationStore store = new DefaultApplicationStore();

        uiApplicationContext = new UiApplicationContext(appService, buildService, buildLogService, store, settings);
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        BuildListWindow buildListWindow = new BuildListWindow(uiApplicationContext);
        WorkflowListWindow workflowListWindow = new WorkflowListWindow();

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        Content buildListContent = null;
        try {
            buildListContent = contentFactory.createContent(buildListWindow.getContent(), "Build list", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Content workflowListContent = contentFactory.createContent(workflowListWindow.getContent(), "Local workflow", false);

        toolWindow.getContentManager().addContent(buildListContent);
        toolWindow.getContentManager().addContent(workflowListContent);
    }
}
