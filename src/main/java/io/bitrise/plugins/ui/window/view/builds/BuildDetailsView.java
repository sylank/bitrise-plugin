package io.bitrise.plugins.ui.window.view.builds;

import com.intellij.ui.JBColor;
import io.bitrise.plugins.service.BuildLogService;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.window.view.PluginView;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.IOException;

public class BuildDetailsView extends JPanel implements TreeSelectionListener, PluginView {
    private BuildLogService buildLogService;

    private JTextPane logTextPane;

    public BuildDetailsView(BuildLogService buildLogService) {
        this.buildLogService = buildLogService;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                e.getNewLeadSelectionPath().getLastPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (nodeInfo == null) return;

        if (nodeInfo instanceof BuildRow) {
            Build build = ((BuildRow) nodeInfo).getBuild();

            try {
                updateView(build);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void renderView() {
        setLayout(new BorderLayout());

        logTextPane = new JTextPane();
        logTextPane.setEditable(false);
        logTextPane.setDoubleBuffered(true);
        add(new JScrollPane(logTextPane), BorderLayout.CENTER);
    }

    private void updateView(Build build) throws IOException {
        String buildLog = buildLogService.getBuildLogsByAppSlugAndBuildId(build.getAppSlug(), build.getBuildSlug());

        logTextPane.setContentType("text/rtf");
        logTextPane.setEditorKit(new HTMLEditorKit());
        logTextPane.setText(formatBuildLogs(buildLog));
    }

    private String formatBuildLogs(String buildLog) {
        String black = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.black.getRed(), JBColor.black.getGreen(), JBColor.black.getBlue());
        String red = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.red.getRed(), JBColor.red.getGreen(), JBColor.red.getBlue());
        String green = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.green.getRed(), JBColor.green.getGreen(), JBColor.green.getBlue());
        String yellow = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.yellow.getRed(), JBColor.yellow.getGreen(), JBColor.yellow.getBlue());
        String blue = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.blue.getRed(), JBColor.blue.getGreen(), JBColor.blue.getBlue());
        String pink = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.pink.getRed(), JBColor.pink.getGreen(), JBColor.pink.getBlue());
        String cyan = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.cyan.getRed(), JBColor.cyan.getGreen(), JBColor.cyan.getBlue());
        String white = String.format("<span style=\"color: rgb(%d,%d,%d);\">", JBColor.white.getRed(), JBColor.white.getGreen(), JBColor.white.getBlue());

        buildLog = buildLog
                .replaceAll("\n", "<br>")
                .replaceAll("\t", "&#9;")
                .replaceAll("\\[30;1m", black)
                .replaceAll("\\[31;1m", red)
                .replaceAll("\\[32;1m", green)
                .replaceAll("\\[33;1m", yellow)
                .replaceAll("\\[34;1m", blue)
                .replaceAll("\\[35;1m", pink)
                .replaceAll("\\[36m", cyan)
                .replaceAll("\\[37;1m", white)
                .replaceAll("\\[0m", "</span>");

        StringBuilder buffer = new StringBuilder(buildLog);
        buffer.insert(0, "<html>");
        buffer.insert(buffer.length(), "</html>");

        return buffer.toString();
    }
}
