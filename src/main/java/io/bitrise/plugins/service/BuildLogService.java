package io.bitrise.plugins.service;

public interface BuildLogService {
    String getBuildLogsByAppSlugAndBuildId(String appSlug, String buildId);
}
