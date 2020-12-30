package io.bitrise.plugins.ui.window.view.builds;

import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class BuildDetailsView extends JPanel implements TreeSelectionListener, PluginView {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                e.getNewLeadSelectionPath().getLastPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        System.out.println(nodeInfo);
    }

    @Override
    public void renderView() {

    }
}
