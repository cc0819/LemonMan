package com.cheng.cc.lemonman.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Discover_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Discover_Hot_Fragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_hot,container,false);

        return view;
    }

    @Override
    protected void lazyLoad() {

    }
}
