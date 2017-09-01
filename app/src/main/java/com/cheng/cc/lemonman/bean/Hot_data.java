package com.cheng.cc.lemonman.bean;

public class Hot_data {
    private int image;
    private String text;

    public Hot_data(int image, String text) {
        super();
        this.image = image;
        this.text = text;
    }

    public Hot_data() {
        super();
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
