package com.tian.model;

public class Student {
    private Integer lineId;
    private String name;
    private Integer qq;
    private String type;
    private String estimatedTime;
    private String graduateFrom;
    private String logUrl;
    private String will;
    private String senior;
    private String knowFrom;
    private Integer id;
    private Long createdAt;
    private Long updatedAt;

    public Student() {

    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getGraduateFrom() {
        return graduateFrom;
    }

    public void setGraduateFrom(String graduateFrom) {
        this.graduateFrom = graduateFrom;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getWill() {
        return will;
    }

    public void setWill(String will) {
        this.will = will;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    //    public String toString() {
//        return "{线上学号：" + this.lineId + "/姓名：" + this.name + "/qq：" + this.qq + "/修真类型：" + this.type + "/预计入学时间：" + this.estimatedTime + "/毕业院校：" + this.graduateFrom + "/日报链接：" + this.logUrl + "/师兄：" + this.senior + "/入学宣言：" + this.will + "/从哪里知道修真院：" + this.knowFrom + "/创建时间：" + this.knowFrom + "/更新时间：" + this.updatedAt + "}";
//    }


    @Override
    public String toString() {
        return "Student{" + "lineId=" + lineId + ", name='" + name + '\'' + ", qq=" + qq + ", type='" + type + '\'' + ", estimatedTime=" + estimatedTime + ", graduateFrom='" + graduateFrom + '\'' + ", logUrl='" + logUrl + '\'' + ", will='" + will + '\'' + ", senior='" + senior + '\'' + ", knowFrom='" + knowFrom + '\'' + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}