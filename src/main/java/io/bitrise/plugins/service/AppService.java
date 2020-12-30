package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.App;

import java.util.List;

public interface AppService {
    List<App> getUserApps();

    App getAppById(String appId);
}
