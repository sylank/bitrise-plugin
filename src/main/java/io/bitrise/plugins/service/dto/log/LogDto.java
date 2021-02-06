package io.bitrise.plugins.service.dto.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogDto {
    private String expiring_raw_log_url;

    public LogDto() {
    }

    @JsonProperty("expiring_raw_log_url")
    public String getExpiringRawLogUrl() {
        return expiring_raw_log_url;
    }

    public void setExpiringRawLogUrl(String expiring_raw_log_url) {
        this.expiring_raw_log_url = expiring_raw_log_url;
    }

    @Override
    public String toString() {
        return "LogDto{" +
                "expiring_raw_log_url='" + expiring_raw_log_url + '\'' +
                '}';
    }
}
