package io.bitrise.plugins.component;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "PluginSettings", storages = { @Storage(value = "pluginConfiguration.xml") } )
public class PluginSettings implements PersistentStateComponent<PluginSettings> {

    private String accessToken = "";
    private int refreshIntervalInSec = 10;

    @Nullable
    @Override
    public PluginSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull PluginSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static PluginSettings getInstance(Project project) {
        return project.getComponent(PluginSettings.class);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getRefreshIntervalInSec() {
        return refreshIntervalInSec;
    }

    public void setRefreshIntervalInSec(int refreshIntervalInSec) {
        this.refreshIntervalInSec = refreshIntervalInSec;
    }
}
