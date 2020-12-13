package io.bitrise.plugins.form;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;

import io.bitrise.plugins.component.PluginSettings;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Settings implements DocumentListener, Configurable, ChangeListener {
    private Project project;
    private JPasswordField tokenField = new JPasswordField();
    private JSpinner refreshSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 100,1));

    private boolean modified = false;

    public Settings(Project project) {
        this.project = project;
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Bitrise PlugIn - Settings";
    }

    @Override
    public @Nullable JComponent createComponent() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0,0, 450, 120);
        mainPanel.setLayout(null);

        JLabel lblUsername = new JLabel("Access token:");
        lblUsername.setBounds(30, 25, 200, 16);
        mainPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Refresh interval (sec.):");
        lblPassword.setBounds(30, 74, 200, 16);
        mainPanel.add(lblPassword);

        tokenField.setBounds(210, 20, 291, 26);
        mainPanel.add(tokenField);

        refreshSpinner.setBounds(210, 69, 80, 26);
        mainPanel.add(refreshSpinner);

        PluginSettings config = PluginSettings.getInstance(project);
        tokenField.setText(config.getAccessToken());
        refreshSpinner.setValue(config.getRefreshIntervalInSec());

        tokenField.getDocument().addDocumentListener(this);
        refreshSpinner.getModel().addChangeListener(this);

        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return this.modified;
    }

    @Override
    public void apply() {
        PluginSettings config = PluginSettings.getInstance(project);
        config.setAccessToken(tokenField.getText());
        config.setRefreshIntervalInSec((int)refreshSpinner.getValue());

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
