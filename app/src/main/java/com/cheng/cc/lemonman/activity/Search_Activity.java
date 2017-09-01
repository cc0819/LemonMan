package com.cheng.cc.lemonman.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;

import com.cheng.cc.lemonman.R;

public class Search_Activity extends Activity implements OnClickListener{
	
	private LinearLayout search_cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.search);
		
		initView();
	}

	private void initView() {
		search_cancel = (LinearLayout) findViewById(R.id.search_cancel);
		search_cancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_cancel:
			finish();
			overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
			break;
		}
	}
}
