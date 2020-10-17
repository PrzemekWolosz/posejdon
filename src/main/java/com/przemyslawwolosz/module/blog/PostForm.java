package com.przemyslawwolosz.module.blog;

public class PostForm {

    private String title;
    private String text;

    public String getTitle() {
        return title;
    }

    public PostForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public PostForm setText(String text) {
        this.text = text;
        return this;
    }
}
