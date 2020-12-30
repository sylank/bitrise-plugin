package io.bitrise.plugins.ui.model;

import com.intellij.ui.JBColor;

import java.awt.*;

public class Build {
    private BuildStatus status;
    private boolean pr;
    private String fromBranch;
    private String toBranch;
    private String triggeredAt;
    private String runTime;
    private String commitMessage;
    private String buildNumber;
    private String buildSlug;

    public Build(BuildStatus status, boolean pr, String fromBranch, String toBranch, String triggeredAt, String runTime, String commitMessage, String buildNumber, String buildSlug) {
        this.status = status;
        this.pr = pr;
        this.fromBranch = fromBranch;
        this.toBranch = toBranch;
        this.triggeredAt = triggeredAt;
        this.runTime = runTime;
        this.commitMessage = commitMessage;
        this.buildNumber = buildNumber;
        this.buildSlug = buildSlug;
    }

    public Build() {
    }

    public BuildStatus getStatus() {
        return status;
    }

    public void setStatus(BuildStatus status) {
        this.status = status;
    }

    public boolean isPr() {
        return pr;
    }

    public void setPr(boolean pr) {
        this.pr = pr;
    }

    public String getFromBranch() {
        return fromBranch;
    }

    public void setFromBranch(String fromBranch) {
        this.fromBranch = fromBranch;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public String getTriggeredAt() {
        return triggeredAt;
    }

    public void setTriggeredAt(String triggeredAt) {
        this.triggeredAt = triggeredAt;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getCommitMessage() {
        return commitMessage;
    }

    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getBuildSlug() {
        return buildSlug;
    }

    public void setBuildSlug(String buildSlug) {
        this.buildSlug = buildSlug;
    }

    public Color getStatusColor() {
        switch (status) {
            case FAILED:
                return JBColor.RED;
            case ABORTED:
                return JBColor.YELLOW;
            case SUCCESS:
                return JBColor.GREEN;
            case IN_PROGRESS:
                return JBColor.MAGENTA;

            default:
                return JBColor.CYAN;
        }
    }

    public String getStatusText() {
        switch (status) {
            case FAILED:
                return "Failed";
            case ABORTED:
                return "Aborted";
            case SUCCESS:
                return "Success";
            case IN_PROGRESS:
                return "In progress";

            default:
                return "Unknown status";
        }
    }
}
