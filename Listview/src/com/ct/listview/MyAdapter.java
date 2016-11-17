package com.ct.listview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	private Activity   context;//上下文对象，指的就是activity
	private String[]   data;//指的是需要显示的数据
	private int        layout;//数据需要显示的样式
	//提供一种带参的构造方法，要求使用此Adapter，必须提供所需要的数据
	public MyAdapter(Activity context,String[] data,int layout){
			this.context=context;
			this.data=data;
			this.layout=layout;
	}
	//需要显示的条目有多少
	@Override
	public int getCount() {
		return data.length;
	}
	//每一个条目显示的内容
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data[position];
	}
	//获得Item的id
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	//每个item最终显示样式
	@Override
	public View getView(int position, 
			View convertView, 
			ViewGroup parent) {
		/*思考，每一个Item都是布局，那也是View。
		 * getView主要的作用在于决定最终显示的样子。是不是需要View？
		 * 想办法构建View对象。我们已知是布局layout，那么接下来的操作就是把
		 * layout加载到内存中，那么最终显示的View对象就有了
		*/
		/*
		 * 第一步，加载Layout进来
		 * 第二步，设置显示
		 * 第三步，得出最终的View
		 */
		//加载需要显示的布局
		View  view=View.inflate(context,layout,null);
		//设置显示的内容
		TextView  tv=(TextView) view.findViewById(R.id.textView1);
		tv.setText(data[position]);
		//到此为止。View操作完成，返回view
		return view;
	}

}

