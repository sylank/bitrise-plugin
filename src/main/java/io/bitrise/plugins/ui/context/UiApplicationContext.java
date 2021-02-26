package io.bitrise.plugins.ui.context;

import io.bitrise.plugins.service.AppService;
import io.bitrise.plugins.service.BuildLogService;
import io.bitrise.plugins.service.BuildService;
import io.bitrise.plugins.store.ApplicationStore;
import io.bitrise.plugins.ui.component.PluginSettings;

public class UiApplicationContext {
    private AppService appService;
    private BuildService buildService;
    private BuildLogService buildLogService;

    private ApplicationStore store;

    private PluginSettings settings;

    public UiApplicationContext(AppService appService,
                                BuildService buildService,
                                BuildLogService buildLogService,
                                ApplicationStore store,
                                PluginSettings settings) {
        this.appService = appService;
        this.buildService = buildService;
        this.buildLogService = buildLogService;
        this.store = store;
        this.settings = settings;
    }

    public AppService getAppService() {
        return appService;
    }

    public BuildService getBuildService() {
        return buildService;
    }

    public BuildLogService getBuildLogService() {
        return buildLogService;
    }

    public ApplicationStore getStore() {
        return store;
    }

    public PluginSettings getSettings() {
        return settings;
    }
}
