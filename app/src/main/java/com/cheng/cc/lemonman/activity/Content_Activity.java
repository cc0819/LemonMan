package com.cheng.cc.lemonman.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.adapter.BaseAdapter_classify_new;
import com.cheng.cc.lemonman.bean.classify_new_data;

import java.util.ArrayList;
import java.util.List;

public class Content_Activity extends Activity {
	private ListView lv;
	private ImageView iv;
	private TextView tv;
	private LinearLayout invis;
	private List<classify_new_data> list;

	private String[] strs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.content);

		initHide();
		initTitle();
		initBack();

	}

	private void initHide() {
		lv = (ListView) findViewById(R.id.lv);
		invis = (LinearLayout) findViewById(R.id.invis);

		list = initListDataRank();
		lv.setAdapter(new BaseAdapter_classify_new(Content_Activity.this, list));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:

					break;
				case 1:

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				}
			}
		});

		View header = View.inflate(this, R.layout.content_header, null);// 头部内容
		lv.addHeaderView(header);// 添加头部
		lv.addHeaderView(View.inflate(this, R.layout.content_action, null));// ListView条目中的悬浮部分
																			// //

		lv.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem >= 1) {
					invis.setVisibility(View.VISIBLE);
				} else {

					invis.setVisibility(View.GONE);
				}
			}
		});

	}

	/** 数据源 */
	private List<classify_new_data> initListDataRank() {
		list = new ArrayList<classify_new_data>();
		int[] images = new int[] { R.mipmap.hot_rank_01,
				R.mipmap.hot_rank_02, R.mipmap.hot_rank_03,
				R.mipmap.hot_rank_01, R.mipmap.hot_rank_02,
				R.mipmap.hot_rank_03, R.mipmap.hot_rank_01,
				R.mipmap.hot_rank_02, R.mipmap.hot_rank_03 };

		String[] names = new String[] { "今天你点兔了么", "渡灵Guarding", "轻音少女",
				"今天你点兔了么", "渡灵Guarding", "轻音少女", "今天你点兔了么", "渡灵Guarding",
				"轻音少女" };
		String[] authors = new String[] { "KIO", "Buddy+（凌一凡）", "kakifly",
				"KIO", "Buddy+（凌一凡）", "kakifly", "KIO", "Buddy+（凌一凡）",
				"kakifly" };
		int[] follows = new int[] { R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal,
				R.mipmap.ic_album_nav_follow_normal };

		for (int i = 0; i < follows.length; i++) {
			int image = images[i];
			String name = names[i];
			String author = authors[i];
			int follow = follows[i];

			classify_new_data data = new classify_new_data(image, name, author,
					follow);
			list.add(data);
		}
		return list;
	}

	private void initTitle() {
		tv = (TextView) findViewById(R.id.tv_content);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String title = bundle.getString("title");
		tv.setText(title);
	}

	private void initBack() {
		iv = (ImageView) findViewById(R.id.content_backspace);

		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
