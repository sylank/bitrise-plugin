package io.bitrise.plugins.ui.window;

import javax.swing.*;
import java.io.IOException;

public interface PluginWindow {
    JComponent getContent() throws IOException;
}
