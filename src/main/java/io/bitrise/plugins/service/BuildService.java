package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.Build;

import java.util.List;

public interface BuildService {
    List<Build> getBuildsByApp(String appId, String buildSlug);
}
