package com.example.env107.listview;


public class User {

    private String img = null;
    private String title = null;

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    User(String title,String img){
        setImg(img);
        setTitle(title);
    }

    User(String title){
        setTitle(title);
    }
}
