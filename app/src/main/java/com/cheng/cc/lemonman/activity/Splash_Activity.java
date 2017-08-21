package com.cheng.cc.lemonman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.cc.lemonman.BaseActivity;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.utils.AppActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Splash_Activity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private TextView tv;

    private List<View> dataList;

    @Override
    public void initView(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

    }

    @Override
    public void initInstall() {
        AppActivityManager.getAppManager().addActivity(this);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        dataList = new ArrayList<>();
        dataList.add(getLayoutInflater().inflate(R.layout.splash1, null));
        dataList.add(getLayoutInflater().inflate(R.layout.splash2, null));
        View layout = getLayoutInflater().inflate(R.layout.splash3, null);
        dataList.add(layout);
        tv = (TextView) layout.findViewById(R.id.fun);
        PageAdapter myAdapter = new PageAdapter(dataList);
        viewpager.setAdapter(myAdapter);
    }

    @Override
    public void evenControl() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Splash_Activity.this,Main_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public class PageAdapter extends PagerAdapter {

        private List<View> pages;

        public PageAdapter(List<View> pages) {
            this.pages = pages;
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(pages.get(position), 0);
            return pages.get(position);
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(pages.get(position));
        }

    }


}
