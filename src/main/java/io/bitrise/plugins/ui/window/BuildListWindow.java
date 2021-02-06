package io.bitrise.plugins.ui.window;

import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.BuildLogService;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.ui.window.view.builds.AppDetailsView;
import io.bitrise.plugins.ui.window.view.builds.BuildDetailsView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BuildListWindow implements PluginWindow {
    private AppService appService;
    private BuildService buildService;
    private BuildLogService buildLogService;

    public BuildListWindow(AppService appService, BuildService buildService, BuildLogService buildLogService) {
        this.appService = appService;
        this.buildService = buildService;
        this.buildLogService = buildLogService;
    }

    @Override
    public JComponent getContent() throws IOException {
        JPanel myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());

        myToolWindowContent.add(createMainPanel(), BorderLayout.CENTER);

        return myToolWindowContent;
    }

    private JComponent createMainPanel() throws IOException {
        BuildDetailsView buildDetailsView = new BuildDetailsView(buildLogService);
        AppDetailsView appDetailsView = new AppDetailsView(appService, buildService, buildDetailsView);

        buildDetailsView.renderView();
        appDetailsView.renderView();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, appDetailsView, buildDetailsView);
        splitPane.setResizeWeight(0.5);
        return splitPane;
    }
}
