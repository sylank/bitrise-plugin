package io.bitrise.plugins.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paging {
    private int totalItemCount;
    private int pageItemLimit;
    private String next;

    public Paging() {
    }

    public Paging(int totalItemCount, int pageItemLimit, String next) {
        this.totalItemCount = totalItemCount;
        this.pageItemLimit = pageItemLimit;
        this.next = next;
    }

    @JsonProperty("total_item_count")
    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    @JsonProperty("page_item_limit")
    public int getPageItemLimit() {
        return pageItemLimit;
    }

    public void setPageItemLimit(int pageItemLimit) {
        this.pageItemLimit = pageItemLimit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "totalItemCount=" + totalItemCount +
                ", pageItemLimit=" + pageItemLimit +
                ", next='" + next + '\'' +
                '}';
    }
}
