package com.cheng.cc.lemonman.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.adapter.MyAdapter;
import com.cheng.cc.lemonman.bean.Adapter_data;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_home_Sun extends BaseFragment {
    @BindView(R.id.home_ListView)
    ListView homeListView;
    Unbinder unbinder;
    private List<Adapter_data> listDate;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_one,
                container, false);

        unbinder = ButterKnife.bind(this, view);
        listDate = initListData();


        myAdapter = new MyAdapter(getActivity(), listDate);
        homeListView.setAdapter(myAdapter);
        homeListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        initIntent();
                        break;
                    case 1:
                        initIntent();
                        break;
                    case 2:
                        initIntent();
                        break;
                    case 3:
                        initIntent();
                        break;
                    case 4:
                        initIntent();
                        break;
                    case 5:
                        initIntent();
                        break;
                    case 6:
                        initIntent();
                        break;
                    case 7:
                        initIntent();
                        break;
                    case 8:
                        initIntent();
                        break;
                }
            }

            private void initIntent() {
//                Intent intent = new Intent(getActivity(), Content_home.class);
//                startActivity(intent);
            }
        });
        return view;
    }

    /**
     * 数据源：周日
     */
    private List<Adapter_data> initListData() {
        listDate = new ArrayList<Adapter_data>();

        int types[] = {R.mipmap.cartoon_type, R.mipmap.cartoon_type,
                R.mipmap.cartoon_type, R.mipmap.cartoon_type,
                R.mipmap.cartoon_type, R.mipmap.cartoon_type,
                R.mipmap.cartoon_type, R.mipmap.cartoon_type,
                R.mipmap.cartoon_type};
        String names[] = {"请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？",
                "请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？",
                "请问您今天要来点兔子吗？", "请问您今天要来点兔子吗？"};
        String authors[] = {"KOI", "KOI", "KOI", "KOI", "KOI", "KOI", "KOI",
                "KOI", "KOI"};
        String descs[] = {"13话", "14话", "15话", "13话", "14话", "15话", "13话",
                "14话", "15话"};
        int imageIds[] = {R.mipmap.hot_rank_02, R.mipmap.hot_rank_03,
                R.mipmap.hot_rank_01, R.mipmap.hot_rank_02,
                R.mipmap.hot_rank_03, R.mipmap.cartoon_02,
                R.mipmap.cartoon_03, R.mipmap.cartoon_04,
                R.mipmap.hot_rank_01};
        for (int i = 0; i < types.length; i++) {
            int type = types[i];
            String name = names[i];
            String author = authors[i];
            String desc = descs[i];
            int imageId = imageIds[i];
            Adapter_data item = new Adapter_data(type, name, author, desc,
                    imageId);
            listDate.add(item);
        }

        return listDate;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
