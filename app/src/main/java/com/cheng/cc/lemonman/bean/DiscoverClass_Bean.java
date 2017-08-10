package com.cheng.cc.lemonman.bean;

import java.io.Serializable;

/**
 * @author Created by cc on 17/8/10.
 * @fileName DiscoverClass_Bean
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class DiscoverClass_Bean implements Serializable {
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
}
