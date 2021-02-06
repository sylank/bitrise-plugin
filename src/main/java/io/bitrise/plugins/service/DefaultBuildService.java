package io.bitrise.plugins.service;

import io.bitrise.plugins.service.dto.builds.BuildDto;
import io.bitrise.plugins.ui.model.Build;


import java.util.List;
import java.util.stream.Collectors;

public class DefaultBuildService implements BuildService {
    private static final String BASE_URL = "https://api.bitrise.io/v0.1";
    private static final String BUILDS_ENDPOINT = "/builds";

    public DefaultBuildService() {

    }

    @Override
    public List<Build> getBuildsByAppSlug(String appSlug) {
//        BuildDto buildDto = client
//                .target(BASE_URL + "/" + appSlug + BUILDS_ENDPOINT)
//                .request(MediaType.APPLICATION_JSON)
//                .get(BuildDto.class);

//        return buildDto.getData().parallelStream().map(Build::new).collect(Collectors.toList());
        return null;
    }
}
