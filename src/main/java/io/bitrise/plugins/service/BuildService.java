package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.Build;

import java.io.IOException;
import java.util.List;

public interface BuildService {
    List<Build> getBuildsByAppSlug(String appSlug) throws IOException;
}
