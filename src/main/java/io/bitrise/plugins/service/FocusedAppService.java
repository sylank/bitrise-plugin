package io.bitrise.plugins.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bitrise.plugins.service.dto.app.AppDto;
import io.bitrise.plugins.ui.component.PluginSettings;
import io.bitrise.plugins.ui.model.App;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

public class FocusedAppService implements AppService {
    private static final String BASE_URL = "https://api.bitrise.io/v0.1";
    private static final String APPS_ENDPOINT = "/apps";

    private PluginSettings settings;

    public FocusedAppService(PluginSettings settings) {
        this.settings = settings;
    }

    @Override
    public List<App> getUserApps() throws IOException {
        String response =
                Request.Get(BASE_URL + APPS_ENDPOINT + "/" + settings.getFocusedAppSlug())
                        .addHeader("Authorization", settings.getAccessToken())
                        .execute().returnContent().asString();

        ObjectMapper objectMapper = new ObjectMapper();
        AppDto appDto = objectMapper.readValue(response, AppDto.class);

        return asList(new App(appDto.getData()));
    }
}
