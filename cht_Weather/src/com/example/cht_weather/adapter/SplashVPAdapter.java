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
	@Override//����ViewPager��ʾ����ҳ�棨��Ŀ��
	public int getCount() {
		return data.length;
	}
	@Override//
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0==arg1;
	}
	@Override//ʵ����item��������ListView����������getView
	public Object instantiateItem(ViewGroup container, int position) {
		//��̬�ļ���һ����ͼView
		View  view=View.inflate(context, layout, null);
		ImageView   iv=(ImageView) view.
				findViewById(
						R.id.iv_vp_item);
		iv.setImageResource(data[position]);
		container.addView(view);//���������View��ӵ�ViewGroup��
		return view;//����������ʾ��View
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//super.destroyItem(container, position, object);
		container.removeView((View)object);
	}

}
