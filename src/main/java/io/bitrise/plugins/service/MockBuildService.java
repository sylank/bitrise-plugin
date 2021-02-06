package io.bitrise.plugins.service;

import io.bitrise.plugins.ui.model.Build;
import io.bitrise.plugins.ui.model.BuildStatus;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class MockBuildService implements BuildService {

    @Override
    public List<Build> getBuildsByAppSlug(String appSlug) {
        if (appSlug.equals("1")) {
            Build build1 = new Build(
                    BuildStatus.FAILED,
                    true,
                    "feature",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Initial commit",
                    "1",
                    "asdfg313",
                    appSlug);
            Build build2 = new Build(
                    BuildStatus.SUCCESS,
                    false,
                    "another-feature",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Second commit",
                    "2",
                    "5fs35gs",
                    appSlug);

            Build build3 = new Build(
                    BuildStatus.ABORTED,
                    false,
                    "bugfix",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "This is a long commit message",
                    "2",
                    "5fs35gs",
                    appSlug);

            Build build4 = new Build(
                    BuildStatus.IN_PROGRESS,
                    false,
                    "implement_new_features",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Implementation details in the commit message",
                    "2",
                    "5fs35gs",
                    appSlug);

            return asList(build1, build2, build3, build4);
        }

        if (appSlug.equals("2")) {
            Build build2 = new Build(
                    BuildStatus.SUCCESS,
                    false,
                    "another-feature",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Second commit",
                    "2",
                    "5fs35gs",
                    appSlug);

            Build build3 = new Build(
                    BuildStatus.ABORTED,
                    false,
                    "bugfix",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "This is a long commit message",
                    "2",
                    "5fs35gs",
                    appSlug);

            Build build4 = new Build(
                    BuildStatus.IN_PROGRESS,
                    false,
                    "implement_new_features",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Implementation details in the commit message",
                    "2",
                    "5fs35gs",
                    appSlug);

            return asList(build2, build3, build4);
        }

        if (appSlug.equals("3")) {
            Build build2 = new Build(
                    BuildStatus.SUCCESS,
                    false,
                    "another-feature",
                    "master",
                    "2020-11-07 16:40",
                    "10:39",
                    "Second commit",
                    "2",
                    "5fs35gs",
                    appSlug);

            return asList(build2);
        }

        return Collections.emptyList();
    }
}
