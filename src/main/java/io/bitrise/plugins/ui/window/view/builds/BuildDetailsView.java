package io.bitrise.plugins.ui.window.view.builds;

import io.bitrise.plugins.service.BuildLogService;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.window.view.PluginView;
import io.bitrise.plugins.ui.window.view.builds.log.BitriseLogStyledDocument;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class BuildDetailsView extends JPanel implements TreeSelectionListener, PluginView {
    private BuildLogService buildLogService;

    private JTextPane logTextPane;

    public BuildDetailsView(BuildLogService buildLogService) {
        this.buildLogService = buildLogService;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                e.getNewLeadSelectionPath().getLastPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (nodeInfo == null) return;

        if (nodeInfo instanceof BuildRow) {
            Build build = ((BuildRow) nodeInfo).getBuild();

            updateView(build);
        }
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        logTextPane = new JTextPane(new BitriseLogStyledDocument());
        logTextPane.setEditable(false);
        logTextPane.setDoubleBuffered(true);
        add(new JScrollPane(logTextPane), BorderLayout.CENTER);
    }

    private void updateView(Build build) {
        String buildLog = buildLogService.getBuildLogsByAppSlugAndBuildId(build.getAppSlug(), build.getBuildSlug());

        logTextPane.setText(buildLog);
    }
}
