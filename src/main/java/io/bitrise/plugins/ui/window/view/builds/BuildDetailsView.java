package io.bitrise.plugins.ui.window.view.builds;

import com.intellij.ui.components.JBTextArea;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.window.view.PluginView;
import io.bitrise.plugins.ui.window.view.builds.log.BitriseLogStyledDocument;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class BuildDetailsView extends JPanel implements TreeSelectionListener, PluginView {
    private BuildService buildService;
    private JBTextArea logArea;

    public BuildDetailsView(BuildService buildService) {
        this.buildService = buildService;
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

        JTextPane txt = new JTextPane(new BitriseLogStyledDocument());
        txt.setText("Demo text");
        txt.setEditable(false);
        txt.setDoubleBuffered(true);
        add(new JScrollPane(txt), BorderLayout.CENTER);
    }

    private void updateView(Build build) {

    }
}
