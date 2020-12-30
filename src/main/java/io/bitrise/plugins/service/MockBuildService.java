package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.Build;

import java.util.List;

public class MockBuildService implements BuildService {
    @Override
    public List<Build> getBuildsByApp(String appId, String buildSlug) {
        return null;
    }
}
