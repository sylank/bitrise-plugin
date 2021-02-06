package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.App;

import java.io.IOException;
import java.util.List;

public interface AppService {
    List<App> getUserApps() throws IOException;

    App getAppById(String appId);
}
