package com.cheng.cc.lemonman.bean;

public class classify_data {

    private int types;
    private String names;

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

    public classify_data(int types, String names) {
        super();
        this.types = types;
        this.names = names;
    }

    public classify_data() {
        super();
    }
}
