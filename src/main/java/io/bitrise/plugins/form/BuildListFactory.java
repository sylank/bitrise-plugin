package io.bitrise.plugins.form;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class BuildListFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        BuildListWindow myToolWindow = new BuildListWindow(toolWindow);
        testgui myToolWindow2 = new testgui(toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        Content content = contentFactory.createContent(myToolWindow.getContent(), "Build list", false);
        Content content2 = contentFactory.createContent(myToolWindow2.getContent(), "Local workflows", false);

        toolWindow.getContentManager().addContent(content);
        toolWindow.getContentManager().addContent(content2);
    }
}
