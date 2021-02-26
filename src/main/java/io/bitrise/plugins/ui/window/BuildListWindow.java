package io.bitrise.plugins.ui.window;

import io.bitrise.plugins.ui.context.UiApplicationContext;
import io.bitrise.plugins.ui.window.view.builds.AppDetailsView;
import io.bitrise.plugins.ui.window.view.builds.BuildDetailsView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BuildListWindow implements PluginWindow {
    private UiApplicationContext uiApplicationContext;

    public BuildListWindow(UiApplicationContext uiApplicationContext) {
        this.uiApplicationContext = uiApplicationContext;
    }

    @Override
    public JComponent getContent() throws IOException {
        JPanel myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());

        myToolWindowContent.add(createMainPanel(), BorderLayout.CENTER);

        return myToolWindowContent;
    }

    private JComponent createMainPanel() throws IOException {
        BuildDetailsView buildDetailsView = new BuildDetailsView(uiApplicationContext);
        AppDetailsView appDetailsView = new AppDetailsView(uiApplicationContext, buildDetailsView);

        buildDetailsView.renderView();
        appDetailsView.renderView();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, appDetailsView, buildDetailsView);
        splitPane.setResizeWeight(0.5);
        return splitPane;
    }
}
