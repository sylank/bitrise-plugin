package io.bitrise.plugins.service.dto.app;

public class AppDetails {
    private String slug;
    private String title;
    private String project_type;
    private String provider;
    private String repo_owner;
    private String repo_url;
    private String repo_slug;
    private boolean is_disabled;
    private int status;
    private boolean is_public;
    private Owner owner;
    private Object avatar_url;

    public AppDetails() {
    }

    public AppDetails(String slug, String title, String project_type, String provider, String repo_owner, String repo_url, String repo_slug, boolean is_disabled, int status, boolean is_public, Owner owner, Object avatar_url) {
        this.slug = slug;
        this.title = title;
        this.project_type = project_type;
        this.provider = provider;
        this.repo_owner = repo_owner;
        this.repo_url = repo_url;
        this.repo_slug = repo_slug;
        this.is_disabled = is_disabled;
        this.status = status;
        this.is_public = is_public;
        this.owner = owner;
        this.avatar_url = avatar_url;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectType() {
        return project_type;
    }

    public void setProjectType(String project_type) {
        this.project_type = project_type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRepoOwner() {
        return repo_owner;
    }

    public void setRepoOwner(String repo_owner) {
        this.repo_owner = repo_owner;
    }

    public String getRepoUrl() {
        return repo_url;
    }

    public void setRepoUrl(String repo_url) {
        this.repo_url = repo_url;
    }

    public String getRepoSlug() {
        return repo_slug;
    }

    public void setRepoSlug(String repo_slug) {
        this.repo_slug = repo_slug;
    }

    public boolean isIsDisabled() {
        return is_disabled;
    }

    public void setIsDisabled(boolean is_disabled) {
        this.is_disabled = is_disabled;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isIsPublic() {
        return is_public;
    }

    public void setIsPublic(boolean is_public) {
        this.is_public = is_public;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Object getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(Object avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "AppDetails{" +
                "slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", project_type='" + project_type + '\'' +
                ", provider='" + provider + '\'' +
                ", repo_owner='" + repo_owner + '\'' +
                ", repo_url='" + repo_url + '\'' +
                ", repo_slug='" + repo_slug + '\'' +
                ", is_disabled=" + is_disabled +
                ", status=" + status +
                ", is_public=" + is_public +
                ", owner=" + owner +
                ", avatar_url=" + avatar_url +
                '}';
    }
}
