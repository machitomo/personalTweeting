package com.tom.toy.personalTweeting.service;

public class PostTemplate {
    protected String word;
    private String url;

    public void setWord(String word) {
        this.word = word;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getWord() {
        return word;
    }
    public String getUrl() {
        return url;
    }
}
