package com.cheng.cc.lemonman.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheng.cc.lemonman.BaseFragment;
import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.activity.Attention_Activity;
import com.cheng.cc.lemonman.activity.Collecttion_Activity;
import com.cheng.cc.lemonman.activity.Message_Activity;
import com.cheng.cc.lemonman.activity.Setting_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Created by cc on 17/8/9.
 * @fileName Me_Fragment
 * @githublink https://github.com/cc0819
 * @csdnlink http://blog.csdn.net/qq_25404567
 */

public class Me_Fragment extends BaseFragment {

    @BindView(R.id.personal_head)
    ImageView personalHead;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.me_message)
    RelativeLayout meMessage;
    @BindView(R.id.me_attention)
    RelativeLayout meAttention;
    @BindView(R.id.me_collect)
    RelativeLayout meCollect;
    @BindView(R.id.me_setting)
    RelativeLayout meSetting;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        unbinder = ButterKnife.bind(this, view);
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

    @OnClick({R.id.personal_head, R.id.userName, R.id.me_message, R.id.me_attention, R.id.me_collect, R.id.me_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_head:

                break;
            case R.id.userName:

                break;
            case R.id.me_message:
                Intent intentMessage= new Intent(getActivity(), Message_Activity.class);
                startActivity(intentMessage);
                break;
            case R.id.me_attention:
                Intent intentAttention = new Intent(getActivity(), Attention_Activity.class);
                startActivity(intentAttention);
                break;
            case R.id.me_collect:
                Intent intentCollent = new Intent(getActivity(), Collecttion_Activity.class);
                startActivity(intentCollent);
                break;
            case R.id.me_setting:
                Intent intentSet = new Intent(getActivity(), Setting_Activity.class);
                startActivity(intentSet);
                break;
        }
    }
}
