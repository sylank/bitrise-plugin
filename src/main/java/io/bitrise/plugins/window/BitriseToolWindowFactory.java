package io.bitrise.plugins.window;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import io.bitrise.plugins.window.build.list.BuildListWindow;
import io.bitrise.plugins.window.local.workflow.LocalWorkflowsWindow;
import org.jetbrains.annotations.NotNull;

public class BitriseToolWindowFactory implements com.intellij.openapi.wm.ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        BuildListWindow myToolWindow = new BuildListWindow(toolWindow);
        LocalWorkflowsWindow myToolWindow2 = new LocalWorkflowsWindow(toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        Content content = contentFactory.createContent(myToolWindow.getContent(), "Build list", false);
        Content content2 = contentFactory.createContent(myToolWindow2.getContent(), "Local workflows", false);

        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().addContent(content2);
    }
}
