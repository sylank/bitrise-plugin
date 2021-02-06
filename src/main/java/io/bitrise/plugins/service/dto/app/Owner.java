package io.bitrise.plugins.service.dto.app;

public class Owner {
    private String account_type;
    private String name;
    private String slug;

    public Owner() {
    }

    public Owner(String account_type, String name, String slug) {
        this.account_type = account_type;
        this.name = name;
        this.slug = slug;
    }

    public String getAccountType() {
        return account_type;
    }

    public void setAccountType(String account_type) {
        this.account_type = account_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "account_type='" + account_type + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
