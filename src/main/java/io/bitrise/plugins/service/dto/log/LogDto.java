package io.bitrise.plugins.service.dto.log;

import java.util.List;

public class LogDto {
    private String expiring_raw_log_url;
    private int generated_log_chunks_num;
    private boolean is_archived;
    private List<Chunk> log_chunks;
    private Object timestamp;

    public LogDto() {
    }

    public LogDto(String expiring_raw_log_url, int generated_log_chunks_num, boolean is_archived, List<Chunk> log_chunks, Object timestamp) {
        this.expiring_raw_log_url = expiring_raw_log_url;
        this.generated_log_chunks_num = generated_log_chunks_num;
        this.is_archived = is_archived;
        this.log_chunks = log_chunks;
        this.timestamp = timestamp;
    }

    public String getExpiringRawLogUrl() {
        return expiring_raw_log_url;
    }

    public void setExpiringRawLogUrl(String expiring_raw_log_url) {
        this.expiring_raw_log_url = expiring_raw_log_url;
    }

    public int getGeneratedLogChunksNum() {
        return generated_log_chunks_num;
    }

    public void setGeneratedLogChunksNum(int generated_log_chunks_num) {
        this.generated_log_chunks_num = generated_log_chunks_num;
    }

    public boolean isIsArchived() {
        return is_archived;
    }

    public void setIsArchived(boolean is_archived) {
        this.is_archived = is_archived;
    }

    public List<Chunk> getLogChunks() {
        return log_chunks;
    }

    public void setLogChunks(List<Chunk> log_chunks) {
        this.log_chunks = log_chunks;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LogDto{" +
                "expiring_raw_log_url='" + expiring_raw_log_url + '\'' +
                ", generated_log_chunks_num=" + generated_log_chunks_num +
                ", is_archived=" + is_archived +
                ", log_chunks=" + log_chunks +
                ", timestamp=" + timestamp +
                '}';
    }
}
