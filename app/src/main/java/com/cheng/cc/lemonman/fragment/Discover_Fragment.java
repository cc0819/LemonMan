package com.cheng.cc.lemonman.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Discover_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Discover_Fragment extends BaseFragment {

    @BindView(R.id.discover_bar_follow)
    TextView discoverBarFollow;
    @BindView(R.id.discover_bar_replace)
    TextView discoverBarReplace;
    @BindView(R.id.discover_bar_iv)
    ImageView discoverBarIv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        unbinder = ButterKnife.bind(this, view);
        FragmentTransaction fragTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.discover, new Discover_Hot_Fragment());
        fragTransaction.commit();
        return view;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.discover_bar_follow, R.id.discover_bar_replace, R.id.discover_bar_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.discover_bar_follow:
                FragmentTransaction fragTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragTransaction.replace(R.id.discover, new Discover_Hot_Fragment());
                fragTransaction.commit();
                break;
            case R.id.discover_bar_replace:
                FragmentTransaction fragTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                fragTransaction1.replace(R.id.discover, new Discover_Class_Fragment());
                fragTransaction1.commit();
                break;
            case R.id.discover_bar_iv:

                break;
        }
    }
}
