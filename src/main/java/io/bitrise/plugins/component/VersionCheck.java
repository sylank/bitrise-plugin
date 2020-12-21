package io.bitrise.plugins.component;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.util.xmlb.annotations.Attribute;

@State(name = "VersionCheck", storages = {@Storage(value = "versionCheck.xml")})
public class VersionCheck implements BaseComponent {

    @Attribute
    private String localVersion = "0.0";
    private String version;

    public void initComponent() {
        IdeaPluginDescriptor pluginDescriptor = PluginManager.getPlugin(
                PluginId.getId("bitrise.bitrise")
        );

        if (pluginDescriptor != null) {
            version = pluginDescriptor.getVersion();

            if (isANewVersion()) {
                updateLocalVersion();

                NotificationGroup noti = new NotificationGroup("", NotificationDisplayType.BALLOON, true);
                noti.createNotification("Plugin Updated", "See the changelog here: https://google.com", NotificationType.INFORMATION, null).notify(null);
            }
        }
    }

    private void updateLocalVersion() {
        localVersion = version;
    }

    private boolean isANewVersion() {
        String[] s1 = localVersion.split("-")[0].split("\\.");
        String[] s2 = version.split("-")[0].split("\\.");

        if (s1.length != s2.length) return false;
        int i = 0;

        do {
            if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) return true;
            i++;
        } while (i < s1.length);

        return false;
    }
}
