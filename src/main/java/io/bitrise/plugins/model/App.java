package io.bitrise.plugins.model;

import java.util.List;

public class App {
    private String name;
    private List<Build> builds;

    public App(String name, List<Build> builds) {
        this.name = name;
        this.builds = builds;
    }

    public App() {
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

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }
}
