package com.cheng.cc.lemonman.activity;

import android.os.Bundle;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.utils.AppActivityManager;

public class Attention_Activity extends BaseActivity {


    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_attention);
    }

    @Override
    public void initInstall() {
        AppActivityManager.getAppManager().addActivity(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void evenControl() {

    }
}
