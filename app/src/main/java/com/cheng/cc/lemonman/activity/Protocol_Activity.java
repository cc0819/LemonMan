package com.cheng.cc.lemonman.activity;

import android.os.Bundle;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;

import butterknife.OnClick;

public class Protocol_Activity extends BaseActivity {

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.protocol);

    }

    @Override
    public void initInstall() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void evenControl() {

    }

    @OnClick(R.id.protocol)
    public void onViewClicked() {
        finish();
    }
}
