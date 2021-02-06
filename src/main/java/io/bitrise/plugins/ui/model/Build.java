package io.bitrise.plugins.ui.model;

import com.intellij.ui.JBColor;
import io.bitrise.plugins.service.dto.builds.BuildDetails;

import java.awt.*;
import java.util.concurrent.TimeUnit;

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
    private String appSlug;

    public Build(BuildStatus status, boolean pr, String fromBranch, String toBranch, String triggeredAt, String runTime, String commitMessage, String buildNumber, String buildSlug, String appSlug) {
        this.status = status;
        this.pr = pr;
        this.fromBranch = fromBranch;
        this.toBranch = toBranch;
        this.triggeredAt = triggeredAt;
        this.runTime = runTime;
        this.commitMessage = commitMessage;
        this.buildNumber = buildNumber;
        this.buildSlug = buildSlug;
        this.appSlug = appSlug;
    }

    public Build() {
    }

    public Build(BuildDetails buildDetails) {
        switch (buildDetails.getStatus()) {
            case 0:
                this.status = BuildStatus.IN_PROGRESS;
                break;
            case 1:
                this.status = BuildStatus.SUCCESS;
                break;
            case 2:
                this.status = BuildStatus.FAILED;
                break;
            case 3:
            case 4:
                this.status = BuildStatus.ABORTED;
                break;
        }

        if (buildDetails.getPullRequestViewUrl() != null){
            this.pr = !buildDetails.getPullRequestViewUrl().equals("");
            this.toBranch = buildDetails.getPullRequestTargetBranch();
        }
        this.fromBranch = buildDetails.getBranch();
        this.triggeredAt = buildDetails.getTriggeredAt().toString();

        long diffInMilies = Math.abs(buildDetails.getFinishedAt().getTime() - buildDetails.getTriggeredAt().getTime());
        long diff = TimeUnit.MINUTES.convert(diffInMilies, TimeUnit.MILLISECONDS);
        this.runTime = Long.toString(diff);

        this.commitMessage = buildDetails.getCommitMessage();
        this.buildNumber = Integer.toString(buildDetails.getBuildNumber());
        this.buildSlug = buildDetails.getSlug();
        this.appSlug = buildDetails.getAppSlug();
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

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
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

    @Override
    public String toString() {
        return "Build{" +
                "status=" + status +
                ", pr=" + pr +
                ", fromBranch='" + fromBranch + '\'' +
                ", toBranch='" + toBranch + '\'' +
                ", triggeredAt='" + triggeredAt + '\'' +
                ", runTime='" + runTime + '\'' +
                ", commitMessage='" + commitMessage + '\'' +
                ", buildNumber='" + buildNumber + '\'' +
                ", buildSlug='" + buildSlug + '\'' +
                ", appSlug='" + appSlug + '\'' +
                '}';
    }
}
