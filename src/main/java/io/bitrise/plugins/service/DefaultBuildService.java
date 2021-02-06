package io.bitrise.plugins.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bitrise.plugins.service.dto.builds.BuildDto;
import io.bitrise.plugins.ui.component.PluginSettings;
import io.bitrise.plugins.ui.model.Build;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultBuildService implements BuildService {
    private static final String BASE_URL = "https://api.bitrise.io/v0.1/apps";
    private static final String BUILDS_ENDPOINT = "/builds";

    private PluginSettings settings;

    public DefaultBuildService(PluginSettings settings) {
        this.settings = settings;
    }

    @Override
    public List<Build> getBuildsByAppSlug(String appSlug) throws IOException {
        String response =
                Request.Get(BASE_URL + "/" + appSlug + BUILDS_ENDPOINT)
                        .addHeader("Authorization", settings.getAccessToken())
                        .execute().returnContent().asString();

        ObjectMapper objectMapper = new ObjectMapper();
        BuildDto buildDto = objectMapper.readValue(response, BuildDto.class);

        return buildDto.getData().parallelStream().map(Build::new).collect(Collectors.toList());
    }
}
