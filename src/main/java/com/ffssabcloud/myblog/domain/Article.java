package com.ffssabcloud.myblog.domain;

public class Article {
    private Integer id;

    private Integer authorid;

    private String categories;

    private String title;

    private Integer createat;

    private Integer modifyat;

    private String description;

    private String content;

    private Boolean status;

    private Integer clicks;

    private String tags;

    private Integer comments;

    private Boolean allowcomment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCreateat() {
        return createat;
    }

    public void setCreateat(Integer createat) {
        this.createat = createat;
    }

    public Integer getModifyat() {
        return modifyat;
    }

    public void setModifyat(Integer modifyat) {
        this.modifyat = modifyat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Boolean getAllowcomment() {
        return allowcomment;
    }

    public void setAllowcomment(Boolean allowcomment) {
        this.allowcomment = allowcomment;
    }
}