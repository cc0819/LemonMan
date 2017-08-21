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
import com.cheng.cc.lemonman.bean.Adapter_data;

import java.util.List;


public class MyAdapter extends BaseAdapter{
	private Context context;
	private List<Adapter_data> data;

	// private LayoutInflater mInflater;

	public MyAdapter(Context context,List<Adapter_data> data) {
		this.context = context;
		this.data = data;
	}


	static class ViewHolder {
		public ImageView types;
		public TextView names;
		public TextView authors;
		public TextView descs;
		public ImageView imageIds;
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
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = (LinearLayout) LayoutInflater.from(context).inflate(
					R.layout.adapter_item, null);

			holder.types= (ImageView) convertView.findViewById(R.id.type);
			holder.names = (TextView) convertView.findViewById(R.id.name);
			holder.authors =  (TextView) convertView.findViewById(R.id.author);
			holder.descs =  (TextView) convertView.findViewById(R.id.desc);
			holder.imageIds =  (ImageView) convertView.findViewById(R.id.imageId);
			
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.types.setImageResource(data.get(position).getTypes());
		holder.names.setText(data.get(position).getNames());
		holder.authors.setText(data.get(position).getAuthors());
		holder.descs.setText(data.get(position).getDescs());
		holder.imageIds.setImageResource(data.get(position).getImageIds());
			

		return convertView;
	}

}
