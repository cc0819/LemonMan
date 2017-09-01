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
import com.cheng.cc.lemonman.bean.Hot_rank_data;

import java.util.List;

public class BaseAdapter_hot_rank extends BaseAdapter {
	private Context context;
	private List<Hot_rank_data> data;
	public ImageView image;
	public TextView rank,name,author;
	
	public BaseAdapter_hot_rank(Context context,List<Hot_rank_data> data){
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
		convertView = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.hot_rank_item, null);
		image = (ImageView) convertView.findViewById(R.id.rank_imageView);
		rank = (TextView) convertView.findViewById(R.id.rank_textView_rank);
		name = (TextView) convertView.findViewById(R.id.rank_textView_name);
		author = (TextView) convertView.findViewById(R.id.rank_textView_author);
		
		image.setImageResource(data.get(position).getImage());
		rank.setText(data.get(position).getRank());
		name.setText(data.get(position).getName());
		author.setText(data.get(position).getAuthor());
		
		return convertView;
	}

}
