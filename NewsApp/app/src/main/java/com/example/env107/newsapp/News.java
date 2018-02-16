package com.example.env107.newsapp;

/**
 * Created by Administrator on 2018/2/15.
 */

class News {

    private String title = null;
    private String content = null;

    News(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


