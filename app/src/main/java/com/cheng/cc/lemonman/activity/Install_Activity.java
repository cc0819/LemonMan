package com.cheng.cc.lemonman.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cheng.cc.lemonman.R;

public class Install_Activity extends Activity {
	private Button install_btn;
	private ImageView iv, image_btn;
	private RelativeLayout install_Feedback, install_about, install_memorys,
			install_update, image_btn1, install_opinion, install_protocol;
	private LinearLayout wwwll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.install);
		/**
		 * 跳转Feedback页面
		 */
		install_Feedback = (RelativeLayout) findViewById(R.id.install_Feedback);
		install_Feedback.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Install_Activity.this, Feedback_Activity.class);
				startActivity(intent);
			}
		});
		wwwll = (LinearLayout) findViewById(R.id.www_ll);
		wwwll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("http://liwushuo-data.qiniudn.com/apk/150427/rd3zvvgwq.apk");
				Intent it = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(it);

			}
		});
		/**
		 * 跳转About页面
		 */
		install_about = (RelativeLayout) findViewById(R.id.install_about);
		install_about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Install_Activity.this, About_Activity.class);
				startActivity(intent);
			}
		});

		install_protocol = (RelativeLayout) findViewById(R.id.install_protocol);
		install_protocol.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Install_Activity.this, Protocol.class);
				startActivity(intent);
			}
		});

		install_opinion = (RelativeLayout) findViewById(R.id.install_opinion);
		install_opinion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Install_Activity.this, Opinion.class);
				startActivity(intent);
			}
		});
		/**
		 * 点击提示清理
		 */
		install_memorys = (RelativeLayout) findViewById(R.id.install_memorys);
		install_memorys.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast tst = Toast.makeText(Install_Activity.this, "清理成功",
						Toast.LENGTH_SHORT);
				tst.show();
			}
		});
		/**
		 * 点击提示清理
		 */
		install_update = (RelativeLayout) findViewById(R.id.install_update);
		install_update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast tst = Toast.makeText(Install_Activity.this, "超赞！您的版本已是最新版本",
						Toast.LENGTH_SHORT);
				tst.show();
			}
		});
		image_btn1 = (RelativeLayout) findViewById(R.id.image_btn1);
		image_btn = (ImageView) findViewById(R.id.image_btn);
		image_btn1.setOnClickListener(new OnClickListener() {
			boolean flag = false;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag) {
					image_btn.setImageResource(R.drawable.ic_push_switch_close);
					flag = false;
				} else {
					image_btn.setImageResource(R.drawable.ic_push_switch_open);
					flag = true;
				}
			}
		});

		install_btn = (Button) findViewById(R.id.install_btn);
		install_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				SharedPreferences sp = getSharedPreferences("sharedInfo",
						MODE_PRIVATE);
				Editor edit = sp.edit();
				edit.putString("userName", "登录");
				edit.commit();

				Intent data = new Intent();
				setResult(4, data);

				finish();

			}
		});

		iv = (ImageView) findViewById(R.id.install_backspace);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}
}
