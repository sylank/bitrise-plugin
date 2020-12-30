package io.bitrise.plugins.ui.window.view.builds;


import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.util.List;

public class AppDetailsView extends JPanel implements PluginView {
    private AppService appService;
    private TreeSelectionListener treeSelectionListener;

    public AppDetailsView(AppService appService, TreeSelectionListener treeSelectionListener) {
        this.appService = appService;
        this.treeSelectionListener = treeSelectionListener;
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        BuildListView appListPanel = new BuildListView(getAppsAndBuilds(), treeSelectionListener);
        appListPanel.renderView();

        add(actionPanel, BorderLayout.NORTH);
        add(appListPanel, BorderLayout.CENTER);
    }

    private JPanel createActionPanel() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(layout);

        JTextField searchField = new JTextField();
        searchField.setToolTipText("Search for application");
        searchField.setPreferredSize(new Dimension(200, 25));

        JButton allButton = new JButton("All");
        JButton favouritesButton = new JButton("Favourites");

        actionPanel.add(searchField);
        actionPanel.add(allButton);
        actionPanel.add(favouritesButton);

        return actionPanel;
    }

    private List<App> getAppsAndBuilds() {
        return this.appService.getUserApps();
    }
}
