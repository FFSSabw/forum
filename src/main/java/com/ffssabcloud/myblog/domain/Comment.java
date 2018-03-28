package com.ffssabcloud.myblog.domain;

public class Comment {
    
    /**
     * 评论Id
     */
    private Integer id;
    
    /**
     * 评论作者Id
     */
    private Integer authorId;
    
    /**
     * 评论的文章Id
     */
    private Integer articleId;
    
    /**
     * 评论的内容的Id
     */
    private Integer ownerId;
    
    /**
     * 上级评论的Id
     */
    private Integer parentId;
    
    /**
     * 评论楼层
     */
    private Integer floor;
    
    /**
     * 评论类型
     */
    private String type;
    
    /**
     * 创建时间
     */
    private Integer createAt;
    
    /**
     * 内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Integer createAt) {
        this.createAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    
}
