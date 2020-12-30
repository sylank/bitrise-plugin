package io.bitrise.plugins.ui.window;

import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.window.view.builds.BuildDetailsView;
import io.bitrise.plugins.ui.window.view.builds.BuildListView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BuildListWindow implements PluginWindow {
    private JPanel myToolWindowContent;
    private AppService appService;

    public BuildListWindow(AppService appService) {
        this.appService = appService;
    }

    @Override
    public JComponent getContent() {
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());

        myToolWindowContent.add(createMainPanel(), BorderLayout.CENTER);

        return myToolWindowContent;
    }

    private JComponent createMainPanel() {
        BuildDetailsView buildDetailsView = new BuildDetailsView();
        BuildListView buildListView = new BuildListView(getAppsAndBuilds(), buildDetailsView);

        buildDetailsView.renderView();
        buildListView.renderView();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buildListView, buildDetailsView);
        splitPane.setResizeWeight(0.5);
        return splitPane;
    }

    private List<App> getAppsAndBuilds() {
        return this.appService.getUserApps();
    }
}
