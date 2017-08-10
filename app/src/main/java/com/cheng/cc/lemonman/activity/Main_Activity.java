package com.cheng.cc.lemonman.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.fragment.Discover_Fragment;
import com.cheng.cc.lemonman.fragment.Home_Fragment;
import com.cheng.cc.lemonman.fragment.Me_Fragment;
import com.cheng.cc.lemonman.utils.AppActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Main_Activity extends BaseActivity {


    @BindView(R.id.fragment_home)
    RelativeLayout fragmentHome;
    @BindView(R.id.main_home)
    ImageView mainHome;
    @BindView(R.id.main_discover)
    ImageView mainDiscover;
    @BindView(R.id.main_me)
    ImageView mainMe;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

    }

    @Override
    public void initInstall() {
        AppActivityManager.getAppManager().addActivity(this);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.fragment_home, new Home_Fragment());
        fragTransaction.commit();
        mainHome.setEnabled(false);
    }

    @Override
    public void evenControl() {

    }

    @OnClick({R.id.main_home, R.id.main_discover, R.id.main_me})
    public void onViewClicked(View view) {
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.main_home:
                mainHome.setEnabled(false);
                mainDiscover.setEnabled(true);
                mainMe.setEnabled(true);
                fragTransaction.replace(R.id.fragment_home, new Home_Fragment());
                break;
            case R.id.main_discover:
                mainHome.setEnabled(true);
                mainDiscover.setEnabled(false);
                mainMe.setEnabled(true);
                fragTransaction.replace(R.id.fragment_home, new Discover_Fragment());
                break;
            case R.id.main_me:
                mainHome.setEnabled(true);
                mainDiscover.setEnabled(true);
                mainMe.setEnabled(false);
                fragTransaction.replace(R.id.fragment_home, new Me_Fragment());
                break;
        }
        fragTransaction.commit();
    }


    private long startTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        开始点击的时间, 全局变量
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-startTime>2000){
                Toast.makeText(Main_Activity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                startTime=System.currentTimeMillis();
            }else{
                AppActivityManager.getAppManager().finishAllActivity();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
