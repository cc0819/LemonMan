package com.cheng.cc.lemonman.bean;

public class Adapter_data {
    private int types;
    private String names;
    private String authors;
    private String descs;
    private int imageIds;

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public int getImageIds() {
        return imageIds;
    }

    public void setImageIds(int imageIds) {
        this.imageIds = imageIds;
    }

    public Adapter_data(int types, String names, String authors, String descs,
                        int imageIds) {
        super();
        this.types = types;
        this.names = names;
        this.authors = authors;
        this.descs = descs;
        this.imageIds = imageIds;
    }

    public Adapter_data(int image01, int image02) {
        super();
        this.imageIds = image01;
        this.types = image02;
    }

    public Adapter_data() {
        super();
    }
}
