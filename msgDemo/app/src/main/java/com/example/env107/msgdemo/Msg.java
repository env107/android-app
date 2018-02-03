package com.example.env107.msgdemo;

public class Msg {

    private String text = null;
    private int type = 1;

    public static final int MSG_SNED = 1;
    public static final int MSG_GET = 2;

    Msg(String text){
        this.text = text;
    }

    Msg(String text,int type){
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }


}
