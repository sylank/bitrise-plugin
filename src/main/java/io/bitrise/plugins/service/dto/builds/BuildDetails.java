package io.bitrise.plugins.service.dto.builds;

import java.util.Date;

public class BuildDetails {
    private Date triggered_at;
    private Date started_on_worker_at;
    private Date environment_prepare_finished_at;
    private Date finished_at;
    private String slug;
    private int status;
    private String status_text;
    private Object abort_reason;
    private boolean is_on_hold;
    private String branch;
    private int build_number;
    private String commit_hash;
    private String commit_message;
    private Object tag;
    private String triggered_workflow;
    private String triggered_by;
    private String machine_type_id;
    private String stack_identifier;
    private OriginalBuildParams original_build_params;
    private int pull_request_id;
    private String pull_request_target_branch;
    private String pull_request_view_url;
    private String commit_view_url;

    private String appSlug;

    public BuildDetails() {
    }

    public BuildDetails(Date triggered_at, Date started_on_worker_at, Date environment_prepare_finished_at, Date finished_at, String slug, int status, String status_text, Object abort_reason, boolean is_on_hold, String branch, int build_number, String commit_hash, String commit_message, Object tag, String triggered_workflow, String triggered_by, String machine_type_id, String stack_identifier, OriginalBuildParams original_build_params, int pull_request_id, String pull_request_target_branch, String pull_request_view_url, String commit_view_url, String appSlug) {
        this.triggered_at = triggered_at;
        this.started_on_worker_at = started_on_worker_at;
        this.environment_prepare_finished_at = environment_prepare_finished_at;
        this.finished_at = finished_at;
        this.slug = slug;
        this.status = status;
        this.status_text = status_text;
        this.abort_reason = abort_reason;
        this.is_on_hold = is_on_hold;
        this.branch = branch;
        this.build_number = build_number;
        this.commit_hash = commit_hash;
        this.commit_message = commit_message;
        this.tag = tag;
        this.triggered_workflow = triggered_workflow;
        this.triggered_by = triggered_by;
        this.machine_type_id = machine_type_id;
        this.stack_identifier = stack_identifier;
        this.original_build_params = original_build_params;
        this.pull_request_id = pull_request_id;
        this.pull_request_target_branch = pull_request_target_branch;
        this.pull_request_view_url = pull_request_view_url;
        this.commit_view_url = commit_view_url;
        this.appSlug = appSlug;
    }

    public Date getTriggeredAt() {
        return triggered_at;
    }

    public void setTriggeredAt(Date triggered_at) {
        this.triggered_at = triggered_at;
    }

    public Date getStartedOnWorkerAt() {
        return started_on_worker_at;
    }

    public void setStartedOnWorkerAt(Date started_on_worker_at) {
        this.started_on_worker_at = started_on_worker_at;
    }

    public Date getEnvironmentPrepareFinishedAt() {
        return environment_prepare_finished_at;
    }

    public void setEnvironmentPrepareFinishedAt(Date environment_prepare_finished_at) {
        this.environment_prepare_finished_at = environment_prepare_finished_at;
    }

    public Date getFinishedAt() {
        return finished_at;
    }

    public void setFinishedAt(Date finished_at) {
        this.finished_at = finished_at;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return status_text;
    }

    public void setStatusText(String status_text) {
        this.status_text = status_text;
    }

    public Object getAbortReason() {
        return abort_reason;
    }

    public void setAbortReason(Object abort_reason) {
        this.abort_reason = abort_reason;
    }

    public boolean isIsOnHold() {
        return is_on_hold;
    }

    public void setIsOnHold(boolean is_on_hold) {
        this.is_on_hold = is_on_hold;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getBuildNumber() {
        return build_number;
    }

    public void setBuildNumber(int build_number) {
        this.build_number = build_number;
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

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public String getTriggeredWorkflow() {
        return triggered_workflow;
    }

    public void setTriggeredWorkflow(String triggered_workflow) {
        this.triggered_workflow = triggered_workflow;
    }

    public String getTriggeredBy() {
        return triggered_by;
    }

    public void setTriggeredBy(String triggered_by) {
        this.triggered_by = triggered_by;
    }

    public String getMachineTypeId() {
        return machine_type_id;
    }

    public void setMachineTypeId(String machine_type_id) {
        this.machine_type_id = machine_type_id;
    }

    public String getStackIdentifier() {
        return stack_identifier;
    }

    public void setStackIdentifier(String stack_identifier) {
        this.stack_identifier = stack_identifier;
    }

    public OriginalBuildParams getOriginalBuildParams() {
        return original_build_params;
    }

    public void setOriginalBuildParams(OriginalBuildParams original_build_params) {
        this.original_build_params = original_build_params;
    }

    public int getPullRequestId() {
        return pull_request_id;
    }

    public void setPullRequestId(int pull_request_id) {
        this.pull_request_id = pull_request_id;
    }

    public String getPullRequestTargetBranch() {
        return pull_request_target_branch;
    }

    public void setPullRequestTargetBranch(String pull_request_target_branch) {
        this.pull_request_target_branch = pull_request_target_branch;
    }

    public String getPullRequestViewUrl() {
        return pull_request_view_url;
    }

    public void setPullRequestViewUrl(String pull_request_view_url) {
        this.pull_request_view_url = pull_request_view_url;
    }

    public String getCommitViewUrl() {
        return commit_view_url;
    }

    public void setCommitViewUrl(String commit_view_url) {
        this.commit_view_url = commit_view_url;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    @Override
    public String toString() {
        return "BuildDetails{" +
                "triggered_at=" + triggered_at +
                ", started_on_worker_at=" + started_on_worker_at +
                ", environment_prepare_finished_at=" + environment_prepare_finished_at +
                ", finished_at=" + finished_at +
                ", slug='" + slug + '\'' +
                ", status=" + status +
                ", status_text='" + status_text + '\'' +
                ", abort_reason=" + abort_reason +
                ", is_on_hold=" + is_on_hold +
                ", branch='" + branch + '\'' +
                ", build_number=" + build_number +
                ", commit_hash='" + commit_hash + '\'' +
                ", commit_message='" + commit_message + '\'' +
                ", tag=" + tag +
                ", triggered_workflow='" + triggered_workflow + '\'' +
                ", triggered_by='" + triggered_by + '\'' +
                ", machine_type_id='" + machine_type_id + '\'' +
                ", stack_identifier='" + stack_identifier + '\'' +
                ", original_build_params=" + original_build_params +
                ", pull_request_id=" + pull_request_id +
                ", pull_request_target_branch='" + pull_request_target_branch + '\'' +
                ", pull_request_view_url='" + pull_request_view_url + '\'' +
                ", commit_view_url='" + commit_view_url + '\'' +
                ", appSlug='" + appSlug + '\'' +
                '}';
    }
}
