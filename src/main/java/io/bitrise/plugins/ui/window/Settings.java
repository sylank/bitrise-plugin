package io.bitrise.plugins.ui.window;

import com.intellij.openapi.options.Configurable;
import io.bitrise.plugins.ui.component.PluginSettings;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Settings implements DocumentListener, Configurable, ChangeListener {

    private JPasswordField tokenField = new JPasswordField();
    private JTextField appSlugField = new JTextField();
    private JSpinner refreshSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 100, 1));
    JPanel mainPanel;

    private boolean modified = false;

    public Settings() {
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 450, 120);
        mainPanel.setLayout(null);

        JLabel lblUsername = new JLabel("Access token:");
        lblUsername.setBounds(30, 25, 200, 16);
        mainPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Refresh interval (sec.):");
        lblPassword.setBounds(30, 74, 200, 16);
        mainPanel.add(lblPassword);

        JLabel lblTargetSlug = new JLabel("Focus by app slug:");
        lblTargetSlug.setBounds(30, 99, 200, 16);
        mainPanel.add(lblTargetSlug);

        tokenField.setBounds(210, 20, 291, 26);
        mainPanel.add(tokenField);

        refreshSpinner.setBounds(210, 69, 80, 26);
        mainPanel.add(refreshSpinner);

        appSlugField.setBounds(210, 99, 291, 26);
        mainPanel.add(appSlugField);

        PluginSettings config = PluginSettings.getInstance();
        tokenField.setText(config.getAccessToken());
        refreshSpinner.setValue(config.getRefreshIntervalInSec());
        appSlugField.setText(config.getFocusedAppSlug());

        tokenField.getDocument().addDocumentListener(this);
        refreshSpinner.getModel().addChangeListener(this);
        appSlugField.getDocument().addDocumentListener(this);
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Bitrise PlugIn - Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return this.modified;
    }

    @Override
    public void apply() {
        PluginSettings config = PluginSettings.getInstance();
        config.setAccessToken(tokenField.getText());
        config.setFocusedAppSlug(appSlugField.getText());
        config.setRefreshIntervalInSec((int) refreshSpinner.getValue());

        modified = false;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        modified = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        modified = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        modified = true;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        modified = true;
    }
}
