package io.bitrise.plugins.window.app.list;


import io.bitrise.plugins.model.App;
import io.bitrise.plugins.model.Build;
import io.bitrise.plugins.model.BuildStatus;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

import static java.util.Arrays.asList;

public class BuildListView extends JPanel {
    public BuildListView() {
        setLayout(new BorderLayout());

        JPanel actionPanel = createActionPanel();

        Build build1 = new Build(
                BuildStatus.FAILED,
                true,
                "feature",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Initial commit",
                "1",
                "asdfg313");
        Build build2 = new Build(
                BuildStatus.SUCCESS,
                false,
                "another-feature",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Second commit",
                "2",
                "5fs35gs");

        Build build3 = new Build(
                BuildStatus.ABORTED,
                false,
                "bugfix",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "This is a long commit message",
                "2",
                "5fs35gs");

        Build build4 = new Build(
                BuildStatus.IN_PROGRESS,
                false,
                "implement_new_features",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Implementation details in the commit message",
                "2",
                "5fs35gs");

        App app = new App("Test app 1", asList(build1, build2,build3,build4));

        AppListView appListPanel = new AppListView(Collections.singletonList(app));
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
