package com.ynet.fullview.model;

public class resource {
    private Integer sourceId;

    private String sourceName;

    private String sourceUrl;

    private String sourceType;

    private Integer sourceParentid;

    private Integer sourceSort;

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
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

    public Integer getSourceParentid() {
        return sourceParentid;
    }

    public void setSourceParentid(Integer sourceParentid) {
        this.sourceParentid = sourceParentid;
    }

    public Integer getSourceSort() {
        return sourceSort;
    }

    public void setSourceSort(Integer sourceSort) {
        this.sourceSort = sourceSort;
    }
}