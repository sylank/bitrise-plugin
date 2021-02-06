package io.bitrise.plugins.service.dto.builds;

import java.util.List;

public class OriginalBuildParams {
    private String commit_hash;
    private String commit_message;
    private String branch;
    private String diff_url;
    private List<CommitPath> commit_paths;

    public OriginalBuildParams() {
    }

    public OriginalBuildParams(String commit_hash, String commit_message, String branch, String diff_url, List<CommitPath> commit_paths) {
        this.commit_hash = commit_hash;
        this.commit_message = commit_message;
        this.branch = branch;
        this.diff_url = diff_url;
        this.commit_paths = commit_paths;
    }

    public String getCommitHash() {
        return commit_hash;
    }

    public void setCommitHash(String commit_hash) {
        this.commit_hash = commit_hash;
    }

    public String getCommitMessage() {
        return commit_message;
    }

    public void setCommitMessage(String commit_message) {
        this.commit_message = commit_message;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDiffUrl() {
        return diff_url;
    }

    public void setDiffUrl(String diff_url) {
        this.diff_url = diff_url;
    }

    public List<CommitPath> getCommitPaths() {
        return commit_paths;
    }

    public void setCommitPaths(List<CommitPath> commit_paths) {
        this.commit_paths = commit_paths;
    }

    @Override
    public String toString() {
        return "OriginalBuildParams{" +
                "commit_hash='" + commit_hash + '\'' +
                ", commit_message='" + commit_message + '\'' +
                ", branch='" + branch + '\'' +
                ", diff_url='" + diff_url + '\'' +
                ", commit_paths=" + commit_paths +
                '}';
    }
}
