package io.bitrise.plugins.ui.window.view.builds;


import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.util.List;

public class BuildListView extends JPanel implements PluginView {
    private List<App> apps;
    private TreeSelectionListener treeSelectionListener;

    public BuildListView(List<App> apps, TreeSelectionListener treeSelectionListener) {
        this.apps = apps;
        this.treeSelectionListener = treeSelectionListener;
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        AppListView appListPanel = new AppListView(this.apps, treeSelectionListener);
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
}
