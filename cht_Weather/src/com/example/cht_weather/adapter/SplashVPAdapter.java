package com.example.cht_weather.adapter;

import com.example.cht_weather.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SplashVPAdapter extends PagerAdapter{
	private Context  context;
	private int[]      data;
	private int      layout;
	public SplashVPAdapter(Context context, int[] data, int layout) {
		this.context = context;
		this.data = data;
		this.layout = layout;
	}
	@Override//告诉ViewPager显示多少页面（条目）
	public int getCount() {
		return data.length;
	}
	@Override//
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	@Override//实例化item，类似于ListView中适配器的getView
	public Object instantiateItem(ViewGroup container, int position) {
		//动态的加载一个视图View
		View  view=View.inflate(context, layout, null);
		ImageView   iv=(ImageView) view.
				findViewById(
						R.id.iv_vp_item);
		iv.setImageResource(data[position]);
		container.addView(view);//将加载完成View添加到ViewGroup中
		return view;//返回最终显示的View
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//super.destroyItem(container, position, object);
		container.removeView((View)object);
	}

}
