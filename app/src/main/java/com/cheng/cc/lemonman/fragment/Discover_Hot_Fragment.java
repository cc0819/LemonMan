package com.cheng.cc.lemonman.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.activity.Content_Activity;
import com.cheng.cc.lemonman.activity.Contribute_Activity;
import com.cheng.cc.lemonman.activity.Rank_One_Activity;
import com.cheng.cc.lemonman.adapter.BaseAdapter_hot_gridView;
import com.cheng.cc.lemonman.adapter.BaseAdapter_hot_rank;
import com.cheng.cc.lemonman.adapter.MyPagerAdapter;
import com.cheng.cc.lemonman.bean.Hot_data;
import com.cheng.cc.lemonman.bean.Hot_rank_data;
import com.cheng.cc.lemonman.views.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.cheng.cc.lemonman.R.id.listView_rank;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Discover_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Discover_Hot_Fragment extends BaseFragment {

    @BindView(R.id.viewPager_dis_carousel)
    ViewPager viewPagerDisCarousel;
    @BindView(R.id.iv_dot1)
    ImageView ivDot1;
    @BindView(R.id.iv_dot2)
    ImageView ivDot2;
    @BindView(R.id.iv_dot3)
    ImageView ivDot3;
    @BindView(R.id.iv_dot4)
    ImageView ivDot4;
    @BindView(R.id.gridView_hot_popularity)
    GridView gridViewHotPopularity;
    @BindView(listView_rank)
    ListView listViewRank;
    @BindView(R.id.hot_news_01)
    ImageView hotNews01;
    @BindView(R.id.hot_news_02)
    ImageView hotNews02;
    @BindView(R.id.gridView_hot_groom)
    MyGridView gridViewHotGroom;
    @BindView(R.id.bt_contribute)
    ImageView btContribute;
    @BindView(R.id.fragment_search_layout)
    LinearLayout fragmentSearchLayout;
    Unbinder unbinder;


//    private View view;
    /**
     * list1:人气飙升;list2:主编力推 数据源
     */
    private List<Hot_data> list, list2;
    /**
     * 每周排行榜数据源
     */
    private List<Hot_rank_data> rankList;
    /**
     * 人气飙升及主编力推适配器
     */
    private BaseAdapter_hot_gridView adapter_hot_gridView;
    /**
     * 每周排行榜适配器
     */
    private BaseAdapter_hot_rank adapter_hot_rank;

    private ImageView[] imageViews;

    private int index = 0;// 图片下标

    //小圆点
    private List<ImageView> listImage;

    private String title;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_hot, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initOnclick();
        initCarousel();
        return view;
    }

    private void initView() {
        /** 每周排行榜适配器及监听 */
        rankList = initListDataRank();
        adapter_hot_rank = new BaseAdapter_hot_rank(getActivity(), rankList);
        listViewRank.setAdapter(adapter_hot_rank);

        listViewRank.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        title = rankList.get(position).getName().toString();
                        Intent it = new Intent(getActivity(), Rank_One_Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("title", title);
                        it.putExtras(bundle);
                        startActivity(it);
                        break;
                    case 1:
                        title = rankList.get(position).getName().toString();
                        initIntent(title);
                        break;
                    case 2:
                        title = rankList.get(position).getName().toString();
                        initIntent(title);
                        break;

                }

            }
        });

        /** 主编力推适配器及监听事件 */
        list2 = initListDataGroom();
        //主编力推适配器
        adapter_hot_gridView = new BaseAdapter_hot_gridView(getActivity(),
                list2);
        gridViewHotGroom.setAdapter(adapter_hot_gridView);
        // 主编力推事件监听
        gridViewHotGroom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        title = list2.get(0).getText().toString();
                        initIntent(title);
                        break;
                    case 1:
                        title = list2.get(1).getText().toString();
                        initIntent(title);
                        break;
                    case 2:
                        title = list2.get(2).getText().toString();
                        initIntent(title);
                        break;
                    case 3:
                        title = list2.get(3).getText().toString();
                        initIntent(title);
                        break;
                    case 4:
                        title = list2.get(4).getText().toString();
                        initIntent(title);
                        break;
                    case 5:
                        title = list2.get(5).getText().toString();
                        initIntent(title);
                        break;
                }
            }
        });

        /** 人气飙升适配器及监听 */
        list = initListData();
        // 人气飙升数据源
        adapter_hot_gridView = new BaseAdapter_hot_gridView(getActivity(),
                list);
        gridViewHotPopularity.setAdapter(adapter_hot_gridView);
        // 人气飙升事件监听
        gridViewHotPopularity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        title = list.get(position).getText().toString();
                        initIntent(title);
                        break;
                    case 1:
                        title = list.get(position).getText().toString();
                        initIntent(title);
                        break;
                    case 2:
                        title = list.get(position).getText().toString();
                        initIntent(title);
                        break;
                }

            }
        });

    }

    private void initIntent(String title) {
        Intent intent = new Intent(getActivity(), Content_Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        intent.putExtras(bundle);
        startActivity(intent);
    }



    /**
     * 主编力推
     */
    private List<Hot_data> initListDataGroom() {
        list2 = new ArrayList<Hot_data>();

        int[] images = new int[]{R.mipmap.hot_groom_01,
                R.mipmap.hot_groom_02, R.mipmap.hot_groom_03,
                R.mipmap.hot_groom_04, R.mipmap.hot_groom_05,
                R.mipmap.hot_groom_06};
        String[] texts = new String[]{"今天你点兔了么", "谷雨", "芒种", "仲夏", "仲秋", "冬至"};

        for (int i = 0; i < texts.length; i++) {
            int image = images[i];
            String text = texts[i];
            Hot_data data = new Hot_data(image, text);
            list2.add(data);
        }
        return list2;


    }

    /**
     * 设置人气飙升的数据源
     */
    private List<Hot_data> initListData() {
        list = new ArrayList<Hot_data>();

        int[] images = new int[]{R.mipmap.hot_popularity01,
                R.mipmap.hot_popularity02, R.mipmap.hot_popularity03};
        String[] texts = new String[]{"千夜", "心爱", "智乃"};

        for (int i = 0; i < texts.length; i++) {
            int image = images[i];
            String text = texts[i];
            Hot_data data = new Hot_data(image, text);
            list.add(data);
        }
        return list;
    }

    /**
     * 设置每周排行榜的数据源
     */
    private List<Hot_rank_data> initListDataRank() {
        rankList = new ArrayList<Hot_rank_data>();
        int[] images = new int[]{R.mipmap.hot_rank_01,
                R.mipmap.hot_rank_02, R.mipmap.hot_rank_03};
        String[] ranks = new String[]{"1", "2", "3"};
        String[] names = new String[]{"今天你点兔了么", "渡灵Guarding", "轻音少女"};
        String[] authors = new String[]{"KOI", "Buddy+（凌一凡）", "kakifly"};

        for (int i = 0; i < authors.length; i++) {
            int image = images[i];
            String rank = ranks[i];
            String name = names[i];
            String author = authors[i];

            Hot_rank_data data = new Hot_rank_data(image, rank, name, author);

            rankList.add(data);
        }

        return rankList;
    }


    private void initOnclick() {


        
    }

    private void initCarousel() {
        imageViews = new ImageView[4];
        imageViews[0] = ivDot4;
        imageViews[1] = ivDot3;
        imageViews[2] = ivDot2;
        imageViews[3] = ivDot1;
        bindDataByAdapter();
    }

    private void bindDataByAdapter() {
        initListImageView();
        MyPagerAdapter mPagerAdapter = new MyPagerAdapter(listImage);
        viewPagerDisCarousel.setAdapter(mPagerAdapter);
        viewPagerDisCarousel.setCurrentItem(index);
        viewPagerDisCarousel.setOnPageChangeListener(onPageChangeListener);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessageDelayed(11, 0);
            }
        }).start();
    }

    private void initListImageView() {
        listImage = new ArrayList<ImageView>();
        int[] res = new int[]{R.mipmap.hot_news_01, R.mipmap.hot_news_02,
                R.mipmap.hot_rank_03, R.mipmap.hot_rank_02};

        ImageView[] images = new ImageView[4];

        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageView(getActivity());
            images[i].setImageResource(res[i]);
            // images[i].setLayoutParams(params);
//            images[i].setOnClickListener();
            images[i].setScaleType(ImageView.ScaleType.FIT_XY);
            listImage.add(images[i]);
        }

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_dot1, R.id.iv_dot2, R.id.iv_dot3, R.id.iv_dot4,
            R.id.hot_news_01, R.id.hot_news_02,  R.id.bt_contribute, R.id.fragment_search_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_dot1:
                break;
            case R.id.iv_dot2:
                break;
            case R.id.iv_dot3:
                break;
            case R.id.iv_dot4:
                break;
            case R.id.hot_news_01:
                initIntent("响+智乃");
                break;
            case R.id.hot_news_02:
                initIntent("K-ON");
                break;
            case R.id.bt_contribute:
                Intent intent = new Intent(getActivity(), Contribute_Activity.class);
                startActivity(intent);
                break;
            case R.id.fragment_search_layout:
                break;
        }
    }


    int current = 0;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (current >= listImage.size())
                current = 0;
            viewPagerDisCarousel.setCurrentItem(current);
            for (int i = 0; i < listImage.size(); i++) {
                if (i == current)
                    imageViews[i]
                            .setImageResource(R.drawable.abc_switch_track_mtrl_alpha);
                else
                    imageViews[i]
                            .setImageResource(R.drawable.abc_scrubber_control_off_mtrl_alpha);

            }
            current++;
            handler.sendEmptyMessageDelayed(22, 3000);
        }

        ;
    };

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            for (int i = 0; i < imageViews.length; i++) {
                if (i == position)
                    imageViews[i]
                            .setImageResource(R.drawable.abc_switch_track_mtrl_alpha);
                else
                    imageViews[i]
                            .setImageResource(R.drawable.abc_scrubber_control_off_mtrl_alpha);
            }

        }

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };



}
