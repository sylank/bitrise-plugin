package io.bitrise.plugins.service;

public class MockBuildLogService implements BuildLogService {
    @Override
    public String getBuildLogsByAppSlugAndBuildId(String appSlug, String buildId) {
        return "Log";
    }
}
