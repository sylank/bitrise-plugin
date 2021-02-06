package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.App;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class MockAppService implements AppService {

    @Override
    public List<App> getUserApps() {
        App app = new App("MyApp", "1", Collections.emptyList());
        App app2 = new App("MyApp#2", "2", Collections.emptyList());
        App app3 = new App("App3333#2", "3", Collections.emptyList());

        return asList(app, app2, app3);
    }
}
