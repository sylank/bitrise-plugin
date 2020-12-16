package io.bitrise.plugins.window.app.list;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;

public class BuildListWindow {
    private JPanel myToolWindowContent;

    public BuildListWindow(ToolWindow toolWindow) {

    }

    public JComponent getContent() {
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());

        myToolWindowContent.add(createMainPanel(), BorderLayout.CENTER);

        return myToolWindowContent;
    }

    private JComponent createMainPanel() {
        BuildListView buildListView = new BuildListView();
        BuildDetailsVew buildDetailsVew = new BuildDetailsVew();

        JSplitPane splitPane = new JSplitPane(SwingConstants.VERTICAL, buildListView, buildDetailsVew);
        splitPane.setResizeWeight(0.5);
        return splitPane;
    }
}
