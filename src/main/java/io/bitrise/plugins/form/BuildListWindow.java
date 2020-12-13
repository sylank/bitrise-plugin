package io.bitrise.plugins.form;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class BuildListWindow {
    private JPanel myToolWindowContent;

//    private JButton hideToolWindowButton;

    public BuildListWindow(ToolWindow toolWindow) {
//        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
    }

    public JComponent getContent() {
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(null);

        JButton helloButton = new JButton("Hello button");
        helloButton.setBounds(10,10, 50,50);

        myToolWindowContent.add(helloButton);

        return myToolWindowContent;
    }
}
