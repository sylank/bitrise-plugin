package io.bitrise.plugins.ui.window.view.builds;

import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.util.List;

public class BuildListView extends JPanel implements PluginView {
    private List<App> apps;
    private TreeSelectionListener listener;

    public BuildListView(List<App> apps, TreeSelectionListener listener) {
        this.apps = apps;
        this.listener = listener;
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        JTree tree = new JTree(makeModel());
        tree.setCellRenderer(new TreeCellRenderer());
        tree.setRowHeight(0);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.addTreeSelectionListener(this.listener);

        JScrollPane jScrollPane = new JScrollPane(tree);

        this.add(jScrollPane, BorderLayout.CENTER);
    }

    private TreeModel makeModel() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        this.apps.forEach(app -> {
            DefaultMutableTreeNode appNode = new DefaultMutableTreeNode(new AppRow(app));

            app.getBuilds().forEach(
                    build -> appNode.add(new DefaultMutableTreeNode(new BuildRow(build)))
            );

            root.add(appNode);
        });

        return new DefaultTreeModel(root);
    }

    class TreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {

            JLabel defaultLabel = (JLabel) super.getTreeCellRendererComponent(
                    tree, value, selected, expanded, leaf, row, hasFocus);

            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

                if (node.getUserObject() instanceof Row) {
                    Row rowView = (Row) node.getUserObject();
                    rowView.setSelected(selected);

                    rowView.renderView();

                    return rowView;
                }
            }

            return defaultLabel;
        }
    }
}
