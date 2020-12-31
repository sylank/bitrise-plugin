package io.bitrise.plugins.ui.window.view.builds;

import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;

public abstract class Row extends JPanel implements PluginView {
    public abstract boolean isSelected();

    public abstract void setSelected(boolean selected);
}
