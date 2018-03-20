package com.ffssabcloud.myblog.domain;

public class Article {
    /**
     * 文章id
     */
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章创建时间
     */
    private Integer createAt;
    /**
     * 文章修改时间
     */
    private Integer modifyAt;
    /**
     * 文章简述
     */
    private String description;
    /**
     * 文章主体
     */
    private String content;
    /**
     * 文章状态
     */
    private Boolean status;
    /**
     * 点击次数
     */
    private Integer clicks;
    /**
     * 标签列表
     */
    private String tags;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Integer getCreateAt() {
        return createAt;
    }
    
    public void setCreateAt(Integer createAt) {
        this.createAt = createAt;
    }
    
    public Integer getModifyAt() {
        return modifyAt;
    }
    
    public void setModifyAt(Integer modifyAt) {
        this.modifyAt = modifyAt;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
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
        this.tags = tags;
    }
    
}
