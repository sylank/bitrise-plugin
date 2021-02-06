package io.bitrise.plugins.ui.window.view.builds;

import com.intellij.ui.JBColor;
import io.bitrise.plugins.ui.model.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppRow extends Row {
    private App app;
    private boolean selected;

    public AppRow(App app) {
        this.app = app;
    }

    @Override
    public void renderView() {
        this.removeAll();

        Dimension appDim = new Dimension(16, 16);

        Color appStatusColor = JBColor.DARK_GRAY;
        if (app.getBuilds().size() > 0) {
            appStatusColor = app.getLatestBuild().getStatusColor();
        }

        JLabel label = new JLabel(app.getName());
        label.setIcon(new AppNodeIcon(appStatusColor, appDim));

        add(label, BorderLayout.WEST);
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    class AppNodeIcon implements Icon {
        private final Color color;
        private final Dimension dim;

        public AppNodeIcon(Color color, Dimension dim) {
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
            return "AppNodeIcon{" +
                    "color=" + color +
                    ", dim=" + dim +
                    '}';
        }
    }
}
