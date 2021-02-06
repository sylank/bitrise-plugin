package io.bitrise.plugins.service.dto.builds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitPath {
    private List<Object> added;
    private List<Object> removed;
    private List<String> modified;

    public CommitPath() {
    }

    public CommitPath(List<Object> added, List<Object> removed, List<String> modified) {
        this.added = added;
        this.removed = removed;
        this.modified = modified;
    }

    public List<Object> getAdded() {
        return added;
    }

    public void setAdded(List<Object> added) {
        this.added = added;
    }

    public List<Object> getRemoved() {
        return removed;
    }

    public void setRemoved(List<Object> removed) {
        this.removed = removed;
    }

    public List<String> getModified() {
        return modified;
    }

    public void setModified(List<String> modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "CommitPath{" +
                "added=" + added +
                ", removed=" + removed +
                ", modified=" + modified +
                '}';
    }
}
