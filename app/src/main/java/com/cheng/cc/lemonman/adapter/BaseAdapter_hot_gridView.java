package com.cheng.cc.lemonman.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.bean.Hot_data;

import java.util.List;

public class BaseAdapter_hot_gridView extends BaseAdapter {
	private Context context;
	private List<Hot_data> data;
	public ImageView image;
	public TextView text;
	
	public BaseAdapter_hot_gridView(Context context, List<Hot_data> data) {
		super();
		this.context = context;
		this.data = data;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = LayoutInflater.from(context).inflate(
				R.layout.hot_popularity_item, null);
		image = (ImageView) convertView.findViewById(R.id.popularity_imageView);
		text = (TextView) convertView.findViewById(R.id.popularity_textView);
	
		image.setImageResource(data.get(position).getImage());
		text.setText(data.get(position).getText());
		
		return convertView;
	}

}
