package com.example.cht_weather.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class HLVAdapter extends BaseAdapter{
	private Context  context;
	private int      data;
	private int      resource;
	public HLVAdapter(Context context, int data, int resource) {
		super();
		this.context = context;
		this.data = data;
		this.resource = resource;
	}
	@Override
	public int getCount() {
		return 5;
	}
	@Override
	public Object getItem(int position) {
		return position;
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View  view=View.inflate(context, resource, null);
		return view;
	}

}
