package com.cheng.cc.lemonman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.cc.lemonman.R;
import com.cheng.cc.lemonman.bean.classify_new_data;

import java.util.List;


public class BaseAdapter_classify_new extends BaseAdapter {
	private Context context;
	private List<classify_new_data> data;
	public ImageView image, follow;
	public TextView name, author;

	public BaseAdapter_classify_new(Context context,
			List<classify_new_data> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = (LinearLayout) LayoutInflater.from(context).inflate(
				R.layout.classify_new_item, null);
		image = (ImageView) convertView.findViewById(R.id.image);
		name = (TextView) convertView.findViewById(R.id.name);
		author = (TextView) convertView.findViewById(R.id.author);
		follow = (ImageView) convertView.findViewById(R.id.follow);

		image.setImageResource(data.get(position).getImage());
		name.setText(data.get(position).getName());
		author.setText(data.get(position).getAuthor());
		follow.setImageResource(data.get(position).getFollow());
		return convertView;
	}
}
