package com.cht.listview_2;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

	public class MyAdapter extends BaseAdapter {

	    private LinkedList<User> Data;
	    private Context context;

	    public MyAdapter(LinkedList<User> Data, Context context) {
	        this.Data = Data;
	        this.context = context;
	    }

	    @Override
	    public int getCount() {
	        return Data.size();
	    }

	    @Override
	    public Object getItem(int position) {
	        return null;
	    }

	    @Override
	    public long getItemId(int position) {
	        return position;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
	        ImageView image = (ImageView) convertView.findViewById(R.id.imageView1);
	        TextView speak = (TextView) convertView.findViewById(R.id.textView1);
	        TextView name = (TextView) convertView.findViewById(R.id.textView2);
	        image.setBackgroundResource(Data.get(position).getImage());
	        speak.setText(Data.get(position).getSpeak());
	        name.setText(Data.get(position).getName());
	  
	        return convertView;
	    }
}
