package io.bitrise.plugins.ui.model;

import io.bitrise.plugins.service.dto.app.AppDetails;

import java.util.List;

public class App {
    private String name;
    private String slug;
    private List<Build> builds;

    public App(String name, String slug, List<Build> builds) {
        this.name = name;
        this.slug = slug;
        this.builds = builds;
    }

    public App() {
    }

    public App(AppDetails appDetails) {
        this.name = appDetails.getTitle();
        this.slug = appDetails.getSlug();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public Build getLatestBuild() {
        return builds.get(0);
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "AppDetails{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", builds=" + builds +
                '}';
    }
}
