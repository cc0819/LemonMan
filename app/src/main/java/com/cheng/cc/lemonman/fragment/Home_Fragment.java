package com.cheng.cc.lemonman.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.activity.Search_Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Home_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Home_Fragment extends BaseFragment {

    @BindView(R.id.home_img)
    ImageView homeImg;
    @BindView(R.id.one)
    RadioButton one;
    @BindView(R.id.two)
    RadioButton two;
    @BindView(R.id.three)
    RadioButton three;
    @BindView(R.id.four)
    RadioButton four;
    @BindView(R.id.five)
    RadioButton five;
    @BindView(R.id.six)
    RadioButton six;
    @BindView(R.id.seven)
    RadioButton seven;
    @BindView(R.id.tab)
    RadioGroup tab;
    @BindView(R.id.home_ViewPager)
    ViewPager homeViewPager;
    Unbinder unbinder;

    private List<Fragment> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        data.add(new Fragment_home_Mon());
        data.add(new Fragment_home_Tue());
        data.add(new Fragment_home_Wed());
        data.add(new Fragment_home_Thu());
        data.add(new Fragment_home_Fri());
        data.add(new Fragment_home_Sat());
        data.add(new Fragment_home_Sun());

        homeViewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager()));

        one.setChecked(true);
        homeViewPager.setCurrentItem(0, true);

        homeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        one.setChecked(true);
                        break;
                    case 1:
                        two.setChecked(true);
                        break;
                    case 2:
                        three.setChecked(true);
                        break;
                    case 3:
                        four.setChecked(true);
                        break;
                    case 4:
                        five.setChecked(true);
                        break;
                    case 5:
                        six.setChecked(true);
                        break;
                    case 6:
                        seven.setChecked(true);
                        break;

                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_img, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.tab, R.id.home_ViewPager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_img:
                Intent intent = new Intent(getActivity(),Search_Activity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.one:
                homeViewPager.setCurrentItem(0, false);
                break;
            case R.id.two:
                homeViewPager.setCurrentItem(1, false);
                break;
            case R.id.three:
                homeViewPager.setCurrentItem(2, false);
                break;
            case R.id.four:
                homeViewPager.setCurrentItem(3, false);
                break;
            case R.id.five:
                homeViewPager.setCurrentItem(4, false);
                break;
            case R.id.six:
                homeViewPager.setCurrentItem(5, false);
                break;
            case R.id.seven:
                homeViewPager.setCurrentItem(6, false);
                break;
            case R.id.tab:
                break;
            case R.id.home_ViewPager:
                break;
        }
    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }


}
