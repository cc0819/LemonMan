package com.cheng.cc.lemonman.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.bean.DiscoverClass_Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Discover_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Discover_Class_Fragment extends BaseFragment {

    private String[] names = {
            "新番", "短篇", "完结",
            "男性", "恋爱", "爆笑",
            "耽美", "恐怖", "剧情",
            "日常", "三次元", "治愈",
            "百合", "奇幻", "古风"};

    private int[] types = {
            R.mipmap.discover_type01,
            R.mipmap.discover_type02, R.mipmap.discover_type03,
            R.mipmap.discover_type04, R.mipmap.discover_type05,
            R.mipmap.discover_type06, R.mipmap.discover_type07,
            R.mipmap.discover_type08, R.mipmap.discover_type09,
            R.mipmap.discover_type10, R.mipmap.discover_type11,
            R.mipmap.discover_type12, R.mipmap.discover_type13,
            R.mipmap.discover_type14, R.mipmap.discover_type15};

    private List<DiscoverClass_Bean> data;
    @BindView(R.id.gridView)
    GridView gridView;
    Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_class, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();

        Log.e(TAG, "onCreateView: " + data.size());
        DiscoverHot_Adapter discoverHot_adapter = new DiscoverHot_Adapter(data);
        gridView.setAdapter(discoverHot_adapter);
        discoverHot_adapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        return view;
    }

    @Override
    protected void lazyLoad() {
    }

    private void initData() {

        data = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            DiscoverClass_Bean bean = new DiscoverClass_Bean();
            bean.setNames(names[i]);
            bean.setTypes(types[i]);
            data.add(bean);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class DiscoverHot_Adapter extends BaseAdapter {
        private List<DiscoverClass_Bean> dataTemp;

        public DiscoverHot_Adapter(List<DiscoverClass_Bean> dataTemp) {
            this.dataTemp = dataTemp;
        }

        @Override
        public int getCount() {
            return dataTemp.size();
        }

        @Override
        public Object getItem(int position) {
            return dataTemp.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.item_discoverclass, null);
                vHolder = new ViewHolder();
                vHolder.classText = (TextView) convertView.findViewById(R.id.class_text);
                vHolder.classType = (ImageView) convertView.findViewById(R.id.class_type);
                convertView.setTag(vHolder);
            } else {
                vHolder = (ViewHolder) convertView.getTag();
            }

            vHolder.classText.setText(dataTemp.get(position).getNames());
            vHolder.classType.setImageResource(dataTemp.get(position).getTypes());

            return convertView;
        }


        private class ViewHolder {
            ImageView classType;
            TextView classText;
        }
    }


}
