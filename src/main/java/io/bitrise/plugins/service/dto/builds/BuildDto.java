package io.bitrise.plugins.service.dto.builds;

import io.bitrise.plugins.service.dto.Paging;

import java.util.List;

public class BuildDto {
    private List<BuildDetails> data;
    private Paging paging;

    public BuildDto() {
    }

    public BuildDto(List<BuildDetails> data, Paging paging) {
        this.data = data;
        this.paging = paging;
    }

    public List<BuildDetails> getData() {
        return data;
    }

    public void setData(List<BuildDetails> data) {
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
        return "BuildDto{" +
                "data=" + data +
                ", paging=" + paging +
                '}';
    }
}
