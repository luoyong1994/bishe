package com.ynet.fullview.model;

public class Resource {
    private String sourceId;

    private String sourceName;

    private String sourceUrl;

    private String sourceType;

    private String sourceParentid;

    private String sourceSort;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getSourceParentid() {
        return sourceParentid;
    }

    public void setSourceParentid(String sourceParentid) {
        this.sourceParentid = sourceParentid;
    }

    public String getSourceSort() {
        return sourceSort;
    }

    public void setSourceSort(String sourceSort) {
        this.sourceSort = sourceSort;
    }
}