package io.bitrise.plugins.ui.window.view.builds;

import com.intellij.ui.JBColor;
import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.IconUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.List;

public class AppListView extends JPanel implements PluginView {
    private List<App> apps;
    private TreeSelectionListener listener;

    public AppListView(List<App> apps, TreeSelectionListener listener) {
        this.apps = apps;
        this.listener = listener;
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        IconUIResource emptyIcon = new IconUIResource(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        });
        UIManager.put("Tree.expandedIcon", emptyIcon);
        UIManager.put("Tree.collapsedIcon", emptyIcon);
        UIManager.put("Tree.paintLines", Boolean.TRUE);
        UIManager.put("Tree.lineStyle", "Horizontal");


        JTree tree = new JTree(makeModel());
        tree.setCellRenderer(new TestTreeCellRenderer());
        tree.setRowHeight(0);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.putClientProperty("Nimbus.Overrides.InheritDefaults", false);
        tree.addTreeSelectionListener(this.listener);

        JScrollPane jScrollPane = new JScrollPane(tree);

        this.add(jScrollPane, BorderLayout.CENTER);
    }

    private TreeModel makeModel() {
        Dimension d64 = new Dimension(16, 16);
        Dimension d32 = new Dimension(16, 54);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        this.apps.forEach(app -> {
            Color appStatusColor = JBColor.DARK_GRAY;
            if (app.getBuilds().size() > 0) {
                appStatusColor = app.getBuilds().get(0).getStatusColor();
            }

            DefaultMutableTreeNode set1 = new DefaultMutableTreeNode(
                    new NodeIcon(app.getName(), appStatusColor, d64, false, null));

            app.getBuilds().forEach(build -> {
                set1.add(new DefaultMutableTreeNode(
                        new NodeIcon("", build.getStatusColor(), d32, true, build)));
            });

            root.add(set1);
        });

        return new DefaultTreeModel(root);
    }

    class TestTreeCellRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(
                JTree tree, Object value, boolean selected, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            JLabel l = (JLabel) super.getTreeCellRendererComponent(
                    tree, value, selected, expanded, leaf, row, hasFocus);

            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                Object uo = node.getUserObject();
                if (uo instanceof NodeIcon) {
                    NodeIcon i = (NodeIcon) uo;
                    l.setIcon(new NodeIcon(i.title, i.color, i.dim, leaf, expanded));

                    int indent = 0;
                    TreeNode parent = node.getParent();
                    while (parent instanceof DefaultMutableTreeNode) {
                        DefaultMutableTreeNode pn = (DefaultMutableTreeNode) parent;
                        if (pn.getUserObject() instanceof NodeIcon) {
                            NodeIcon pi = (NodeIcon) pn.getUserObject();
                            indent += pi.dim.width / 2;
                        }
                        parent = pn.getParent();
                    }
                    l.setBorder(BorderFactory.createEmptyBorder(2, indent, 2, 5));

                    if (i.build != null) {
                        JLabel colorLabel = new JLabel();
                        colorLabel.setIcon(new NodeIcon(i.title, i.color, i.dim, leaf, expanded));
                        colorLabel.setBorder(BorderFactory.createEmptyBorder(2, indent, 2, 5));

                        JPanel infoPanel = new JPanel(new BorderLayout());

                        JPanel separator = new JPanel();
                        separator.setBackground(JBColor.DARK_GRAY);
                        separator.setPreferredSize(new Dimension(0, 2));

                        infoPanel.add(separator, BorderLayout.CENTER);

                        FlowLayout majorLayout = new FlowLayout();
                        majorLayout.setAlignment(FlowLayout.LEFT);
                        JPanel majorInfoPanel = new JPanel(majorLayout);

                        JLabel statusLabel = new JLabel(i.build.getStatusText());
                        statusLabel.setForeground(i.build.getStatusColor());
                        Dimension d = statusLabel.getPreferredSize();
                        d.width = 80;
                        statusLabel.setPreferredSize(d);

                        JPanel branchPanel = new JPanel(majorLayout);
                        Dimension bdim = branchPanel.getPreferredSize();
                        bdim.width = 250;
                        bdim.height = 25;
                        branchPanel.setPreferredSize(bdim);

                        JLabel fromLabel = new JLabel(i.build.getFromBranch());
                        fromLabel.setBackground(JBColor.CYAN);
                        fromLabel.setOpaque(true);

                        JLabel arrow = new JLabel("->");
                        if (i.build.isPr()) {
                            arrow.setText("@");
                        }

                        JLabel toLabel = new JLabel(i.build.getToBranch());
                        toLabel.setBackground(JBColor.ORANGE);
                        toLabel.setOpaque(true);

                        branchPanel.add(fromLabel);
                        branchPanel.add(arrow);
                        branchPanel.add(toLabel);

                        JLabel commitMessage = new JLabel(i.build.getCommitMessage());
                        Dimension dCommit = commitMessage.getPreferredSize();
                        dCommit.width = 400;
                        commitMessage.setPreferredSize(dCommit);

                        JPanel minorInfoPanel = new JPanel(majorLayout);

                        JLabel triggeredAtLabel = new JLabel(i.build.getTriggeredAt());
                        Dimension dTriggeredAt = triggeredAtLabel.getPreferredSize();
                        dTriggeredAt.width = 200;
                        triggeredAtLabel.setPreferredSize(dTriggeredAt);

                        JLabel runtimeLabel = new JLabel(i.build.getRunTime());
                        Dimension dRuntime = runtimeLabel.getPreferredSize();
                        dRuntime.width = 100;
                        runtimeLabel.setPreferredSize(dRuntime);

                        JLabel slugLabel = new JLabel("#" + i.build.getBuildSlug());
                        Dimension dSlug = slugLabel.getPreferredSize();
                        dSlug.width = 200;
                        slugLabel.setPreferredSize(dSlug);

                        minorInfoPanel.add(triggeredAtLabel);
                        minorInfoPanel.add(runtimeLabel);
                        minorInfoPanel.add(slugLabel);

                        majorInfoPanel.add(statusLabel);
                        majorInfoPanel.add(branchPanel);
                        majorInfoPanel.add(commitMessage);
                        infoPanel.add(majorInfoPanel, BorderLayout.NORTH);
                        infoPanel.add(minorInfoPanel, BorderLayout.SOUTH);

                        JPanel mainPanel = new JPanel(new BorderLayout());
                        mainPanel.add(colorLabel, BorderLayout.WEST);
                        mainPanel.add(infoPanel, BorderLayout.CENTER);

                        majorInfoPanel.setOpaque(false);
                        mainPanel.setOpaque(false);
                        infoPanel.setOpaque(false);
                        minorInfoPanel.setOpaque(false);
                        branchPanel.setOpaque(false);

                        if (selected) {
                            arrow.setForeground(JBColor.white);
                            commitMessage.setForeground(JBColor.white);
                            triggeredAtLabel.setForeground(JBColor.white);
                            separator.setBackground(JBColor.white);
                            runtimeLabel.setForeground(JBColor.white);
                            slugLabel.setForeground(JBColor.white);
                        }

                        return mainPanel;
                    }
                }
            }
            return l;
        }


    }

    class NodeIcon implements Icon {
        private final String title;
        private final Color color;
        private final Dimension dim;
        private int GAP = 0;
        private Build build;

        public NodeIcon(String title, Color color, Dimension dim, boolean leaf, Build build) {
            this(title, color, dim, leaf, false);

            this.build = build;
        }

        public NodeIcon(String title, Color color, Dimension dim,
                        boolean leaf, boolean expanded) {
            this.title = title;
            this.color = color;
            this.dim = dim;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRoundRect(x + GAP, y + GAP, dim.width - GAP - GAP, dim.height - GAP - GAP, 5, 5);
        }

        @Override
        public int getIconWidth() {
            return dim.width;
        }

        @Override
        public int getIconHeight() {
            return dim.height;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
