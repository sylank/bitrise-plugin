package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.App;
import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.model.BuildStatus;

import java.util.List;

import static java.util.Arrays.asList;

public class MockAppService implements AppService {
    private BuildService buildService;

    public MockAppService(BuildService buildService) {
        this.buildService = buildService;
    }

    @Override
    public List<App> getUserApps() {
        Build build1 = new Build(
                BuildStatus.FAILED,
                true,
                "feature",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Initial commit",
                "1",
                "asdfg313");
        Build build2 = new Build(
                BuildStatus.SUCCESS,
                false,
                "another-feature",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Second commit",
                "2",
                "5fs35gs");

        Build build3 = new Build(
                BuildStatus.ABORTED,
                false,
                "bugfix",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "This is a long commit message",
                "2",
                "5fs35gs");

        Build build4 = new Build(
                BuildStatus.IN_PROGRESS,
                false,
                "implement_new_features",
                "master",
                "2020-11-07 16:40",
                "10:39",
                "Implementation details in the commit message",
                "2",
                "5fs35gs");

        App app = new App("MyApp", asList(build1, build2, build3, build4));
        App app2 = new App("MyApp#2", asList(build2, build3, build4));
        App app3 = new App("App3333#2", asList(build2));

        return asList(app, app2, app3);
    }

    @Override
    public App getAppById(String appId) {
        return null;
    }
}
