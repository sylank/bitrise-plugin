package io.bitrise.plugins.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bitrise.plugins.service.dto.log.LogDto;
import io.bitrise.plugins.ui.component.PluginSettings;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DefaultBuildLogService implements BuildLogService {
    private static final String BASE_URL = "https://api.bitrise.io/v0.1/apps";
    private static final String BUILDS_ENDPOINT = "/builds";
    private static final String LOGS_ENDPOINT = "/log";

    private PluginSettings settings;

    public DefaultBuildLogService(PluginSettings settings) {
        this.settings = settings;
    }

    @Override
    public String getBuildLogsByAppSlugAndBuildId(String appSlug, String buildSlug) throws IOException {
        String response =
                Request.Get(BASE_URL + "/" + appSlug + BUILDS_ENDPOINT + "/" + buildSlug + LOGS_ENDPOINT)
                        .addHeader("Authorization", settings.getAccessToken())
                        .execute().returnContent().asString();

        ObjectMapper objectMapper = new ObjectMapper();
        LogDto buildDto = objectMapper.readValue(response, LogDto.class);

        InputStream inputStream = new URL(buildDto.getExpiringRawLogUrl()).openStream();
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
    }
}
