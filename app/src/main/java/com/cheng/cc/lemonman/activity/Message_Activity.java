package com.cheng.cc.lemonman.activity;

import android.os.Bundle;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.utils.AppActivityManager;

public class Message_Activity extends BaseActivity {

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_message);
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
