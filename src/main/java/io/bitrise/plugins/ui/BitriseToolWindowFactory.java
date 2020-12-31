package io.bitrise.plugins.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.MockAppService;
import io.bitrise.plugins.service.MockBuildService;
import io.bitrise.plugins.ui.window.BuildListWindow;
import io.bitrise.plugins.ui.window.WorkflowListWindow;
import org.jetbrains.annotations.NotNull;

public class BitriseToolWindowFactory implements ToolWindowFactory {
    private AppService appService;

    public BitriseToolWindowFactory() {
        appService = new MockAppService(new MockBuildService());
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        BuildListWindow buildListWindow = new BuildListWindow(appService);
        WorkflowListWindow workflowListWindow = new WorkflowListWindow();

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        Content buildListContent = contentFactory.createContent(buildListWindow.getContent(), "Build list", false);
        Content workflowListContent = contentFactory.createContent(workflowListWindow.getContent(), "Local workflow", false);

        toolWindow.getContentManager().addContent(buildListContent);
        toolWindow.getContentManager().addContent(workflowListContent);
    }
}
