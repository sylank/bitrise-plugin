package io.bitrise.plugins.ui.window;

import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.ui.window.view.builds.AppDetailsView;
import io.bitrise.plugins.ui.window.view.builds.BuildDetailsView;

import javax.swing.*;
import java.awt.*;

public class BuildListWindow implements PluginWindow {
    private AppService appService;
    private BuildService buildService;

    public BuildListWindow(AppService appService, BuildService buildService) {
        this.appService = appService;
        this.buildService = buildService;
    }

    @Override
    public JComponent getContent() {
        JPanel myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());

        myToolWindowContent.add(createMainPanel(), BorderLayout.CENTER);

        return myToolWindowContent;
    }

    private JComponent createMainPanel() {
        BuildDetailsView buildDetailsView = new BuildDetailsView(buildService);
        AppDetailsView appDetailsView = new AppDetailsView(appService, buildDetailsView);

        buildDetailsView.renderView();
        appDetailsView.renderView();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, appDetailsView, buildDetailsView);
        splitPane.setResizeWeight(0.5);
        return splitPane;
    }
}
