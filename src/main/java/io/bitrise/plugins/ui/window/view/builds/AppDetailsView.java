package io.bitrise.plugins.ui.window.view.builds;


import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.service.DefaultAppService;
import io.bitrise.plugins.service.DefaultBuildService;
import io.bitrise.plugins.ui.component.PluginSettings;
import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AppDetailsView extends JPanel implements PluginView {
    private AppService appService;
    private BuildService buildService;
    private TreeSelectionListener treeSelectionListener;

    public AppDetailsView(AppService appService, BuildService buildService, TreeSelectionListener treeSelectionListener) {
        this.appService = appService;
        this.buildService = buildService;
        this.treeSelectionListener = treeSelectionListener;
    }

    @Override
    public void renderView() throws IOException {
        setLayout(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        BuildListView appListPanel = new BuildListView(retrieveUserAppsAndBuilds(), treeSelectionListener);
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
        allButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PluginSettings instance = PluginSettings.getInstance();
                DefaultBuildService defaultBuildService = new DefaultBuildService(instance);
                try {
                    List<Build> asd = defaultBuildService.getBuildsByAppSlug("d28fdbc7a7604f73");

                    System.out.println(asd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        JButton favouritesButton = new JButton("Favourites");

        actionPanel.add(searchField);
        actionPanel.add(allButton);
        actionPanel.add(favouritesButton);

        return actionPanel;
    }

    private List<App> retrieveUserAppsAndBuilds() throws IOException {
        List<App> apps = this.appService.getUserApps();

        apps.forEach(app -> {
            List<Build> buildsByAppSlug = null;
            try {
                buildsByAppSlug = buildService.getBuildsByAppSlug(app.getSlug());
            } catch (IOException e) {
                e.printStackTrace();
            }
            app.setBuilds(buildsByAppSlug);
        });

        return apps;
    }
}
