package io.bitrise.plugins.window.app.list;


import javax.swing.*;
import java.awt.*;

public class BuildListView extends JPanel {
    public BuildListView() {
        setLayout(new BorderLayout());

        JPanel actionPanel = createActionPanel();
        AppListView appListPanel = new AppListView();

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
