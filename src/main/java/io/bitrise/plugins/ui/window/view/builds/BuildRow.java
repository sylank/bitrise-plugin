package io.bitrise.plugins.ui.window.view.builds;

import com.intellij.ui.JBColor;
import io.bitrise.plugins.ui.model.Build;

import javax.swing.*;
import java.awt.*;

public class BuildRow extends Row {
    private Build build;
    private boolean selected;

    public BuildRow(Build build) {
        this.build = build;
    }

    @Override
    public void renderView() {
        this.removeAll();

        JLabel colorLabel = new JLabel();
        colorLabel.setIcon(new BuildNodeIcon(build.getStatusColor(), new Dimension(16, 54)));
        colorLabel.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 5));

        JPanel infoPanel = new JPanel(new BorderLayout());

        JPanel separator = new JPanel();
        separator.setBackground(JBColor.DARK_GRAY);
        separator.setPreferredSize(new Dimension(0, 2));

        infoPanel.add(separator, BorderLayout.CENTER);

        FlowLayout majorLayout = new FlowLayout();
        majorLayout.setAlignment(FlowLayout.LEFT);
        JPanel majorInfoPanel = new JPanel(majorLayout);

        JLabel statusLabel = new JLabel(build.getStatusText());
        statusLabel.setForeground(build.getStatusColor());
        Dimension d = statusLabel.getPreferredSize();
        d.width = 80;
        statusLabel.setPreferredSize(d);

        JPanel branchPanel = new JPanel(majorLayout);
        Dimension bdim = branchPanel.getPreferredSize();
        bdim.width = 250;
        bdim.height = 25;
        branchPanel.setPreferredSize(bdim);

        JLabel fromLabel = new JLabel(build.getFromBranch());
        fromLabel.setBackground(JBColor.CYAN);
        fromLabel.setOpaque(true);

        JLabel toLabel = new JLabel(build.getToBranch());
        toLabel.setBackground(JBColor.ORANGE);
        toLabel.setOpaque(true);

        branchPanel.add(fromLabel);

        JLabel arrow = new JLabel("->");
        if (build.isPr()) {
            branchPanel.add(arrow);
            branchPanel.add(toLabel);
        }

        JLabel commitMessage = new JLabel(build.getCommitMessage());
        Dimension dCommit = commitMessage.getPreferredSize();
        dCommit.width = 400;
        commitMessage.setPreferredSize(dCommit);

        JPanel minorInfoPanel = new JPanel(majorLayout);

        JLabel triggeredAtLabel = new JLabel(build.getTriggeredAt());
        Dimension dTriggeredAt = triggeredAtLabel.getPreferredSize();
        dTriggeredAt.width = 200;
        triggeredAtLabel.setPreferredSize(dTriggeredAt);

        JLabel runtimeLabel = new JLabel(build.getRunTime());
        Dimension dRuntime = runtimeLabel.getPreferredSize();
        dRuntime.width = 100;
        runtimeLabel.setPreferredSize(dRuntime);

        JLabel slugLabel = new JLabel("Slug: " + build.getBuildSlug());
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

        add(mainPanel, BorderLayout.CENTER);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Build getBuild() {
        return build;
    }

    class BuildNodeIcon implements Icon {
        private final Color color;
        private final Dimension dim;

        public BuildNodeIcon(Color color, Dimension dim) {
            this.color = color;
            this.dim = dim;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillRoundRect(x, y, dim.width, dim.height, 5, 5);
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
            return "BuildNodeIcon{" +
                    "color=" + color +
                    ", dim=" + dim +
                    '}';
        }
    }
}
