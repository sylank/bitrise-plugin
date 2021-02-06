package io.bitrise.plugins.service;

import java.io.IOException;

public interface BuildLogService {
    String getBuildLogsByAppSlugAndBuildId(String appSlug, String buildId) throws IOException;
}
