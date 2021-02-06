package io.bitrise.plugins.service.dto.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppDto {
    private AppDetails data;

    public AppDto() {
    }

    public AppDto(AppDetails data) {
        this.data = data;
    }

    public AppDetails getData() {
        return data;
    }

    public void setData(AppDetails data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppDto{" +
                "data=" + data +
                '}';
    }
}
