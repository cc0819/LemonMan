package com.cheng.cc.lemonman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.utils.AppActivityManager;

public class Welcome_Activity extends BaseActivity {

    @Override
    public void initView(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

    }

    @Override
    public void initInstall() {
        AppActivityManager.getAppManager().addActivity(this);
        showAc();
    }

    private void showAc() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
//                            if (!SharedPreferencesUtils.getInstance(Welcome_Activity.this).getBoolean(Constants.ISFIRST)){
//                                SharedPreferencesUtils.getInstance(Welcome_Activity.this).putBoolean(Constants.ISFIRST,true);
                                Intent intent = new Intent(Welcome_Activity.this, Splash_Activity.class);
                                startActivity(intent);
//                            }else {
//                                Intent intent = new Intent(Welcome_Activity.this, Main_Activity.class);
//                                startActivity(intent);
//                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }


    @Override
    public void initData() {

    }

    @Override
    public void evenControl() {

    }
}
