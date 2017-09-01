package com.cheng.cc.lemonman.bean;

public class Hot_rank_data {
    private int image;
    private String rank;
    private String name;
    private String author;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Hot_rank_data(int image, String rank, String name, String author) {
        super();
        this.image = image;
        this.rank = rank;
        this.name = name;
        this.author = author;
    }

    public Hot_rank_data() {
        super();
    }

}
