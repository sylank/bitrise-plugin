package io.bitrise.plugins.service.dto.app;

import io.bitrise.plugins.service.dto.Paging;

import java.util.List;

public class AppDto {
    private List<AppDetails> data;
    private Paging paging;

    public AppDto() {
    }

    public AppDto(List<AppDetails> data, Paging paging) {
        this.data = data;
        this.paging = paging;
    }

    public List<AppDetails> getData() {
        return data;
    }

    public void setData(List<AppDetails> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @Override
    public String toString() {
        return "AppDto{" +
                "data=" + data +
                ", paging=" + paging +
                '}';
    }
}
