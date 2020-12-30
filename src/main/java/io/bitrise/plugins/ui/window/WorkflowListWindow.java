package io.bitrise.plugins.ui.window;

import com.intellij.ui.JBColor;

import javax.swing.*;

public class WorkflowListWindow implements PluginWindow {

    @Override
    public JPanel getContent() {
        JPanel dummy = new JPanel();
        dummy.setBackground(JBColor.RED);

        return dummy;
    }
}
