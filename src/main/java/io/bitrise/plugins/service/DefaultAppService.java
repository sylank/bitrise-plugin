package io.bitrise.plugins.service;

import io.bitrise.plugins.service.dto.app.AppDto;
import io.bitrise.plugins.ui.model.App;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultAppService implements AppService {
    private static final String BASE_URL = "https://api.bitrise.io/v0.1";
    private static final String APPS_ENDPOINT = "/apps";

    private Client client;

    public DefaultAppService(Client client) {
        this.client = client;
    }

    @Override
    public List<App> getUserApps() {
        AppDto appDto = client
                .target(BASE_URL + APPS_ENDPOINT)
                .request(MediaType.APPLICATION_JSON)
                .get(AppDto.class);

        return appDto.getData().parallelStream().map(App::new).collect(Collectors.toList());
    }

    @Override
    public App getAppById(String appId) {
        return null;
    }
}
