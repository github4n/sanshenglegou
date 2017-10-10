package com.linjun.model;

public class Article {
    private Long id;

    private String content;

    private String title;

    private Long looksum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getLooksum() {
        return looksum;
    }

    public void setLooksum(Long looksum) {
        this.looksum = looksum;
    }
}