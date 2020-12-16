package io.bitrise.plugins.window.local.workflow;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class LocalWorkflowsWindow {
    private JPanel panel1;
    private JButton button1;
    private JList list1;
    private JButton button2;
    private JButton button3;

    public LocalWorkflowsWindow(ToolWindow toolWindow) {

    }

    public JPanel getContent() {
        return panel1;
    }
}
