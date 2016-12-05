package com.example.chtgamework;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroAdapter extends BaseAdapter{
	private Context  context;
	private ArrayList<Hero>  heros;
	private int     layout;
	public HeroAdapter(Context context, ArrayList<Hero>  heros, int layout) {
		super();
		this.context = context;
		this.heros = heros;
		this.layout = layout;
	}

	@Override
	public int getCount() {
		return heros.size();
	}
	@Override
	public Object getItem(int position) {
		return heros.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Hero  hero=heros.get(position);
		ViewHolder  viewHolder=null;
		if(convertView==null){
			//动态的加载一个布局View
			convertView=View.inflate(context, layout, null);
			viewHolder=new ViewHolder();
			//给ViewHolder绑定id
			viewHolder.iv_icon=(ImageView) convertView.findViewById(R.id.iv_hero);
			viewHolder.tv_name=(TextView) convertView.findViewById(R.id.tv_name);
			viewHolder.tv_price=(TextView) convertView.findViewById(R.id.tv_price);
			viewHolder.tv_sign=(TextView) convertView.findViewById(R.id.tv_sign);
			viewHolder.tv_blood=(TextView) convertView.findViewById(R.id.tv_blood);
			//把viewHolder和convertView绑定。
			//也可以理解为使用viewolder给convertView设置标记
			convertView.setTag(viewHolder);
		}
		//再这个位置，无论如何都有convertView对象存在
		//从convertView中拿出标记ViewHolder
		viewHolder=(ViewHolder) convertView.getTag();
		//设置对应的控件显示
		viewHolder.iv_icon.setImageResource(hero.getHero_icon());
		viewHolder.tv_name.setText(hero.getName());
		viewHolder.tv_price.setText(hero.getPrice());
		viewHolder.tv_sign.setText(hero.getHero_sign());
		viewHolder.tv_blood.setText(hero.getBlood()+"");
		
		//设置View的显示
		/*ImageView  iv_hero=(ImageView) convertView.findViewById(R.id.iv_hero);
		iv_hero.setImageResource(hero.getHero_icon());
		TextView  tv_name=(TextView) convertView.findViewById(R.id.tv_name);
		TextView  tv_price=(TextView) convertView.findViewById(R.id.tv_price);
		TextView  tv_sign=(TextView) convertView.findViewById(R.id.tv_sign);
		TextView  tv_blood=(TextView) convertView.findViewById(R.id.tv_blood);
		tv_name.setText(hero.getName());
		tv_price.setText(hero.getPrice());
		tv_sign.setText(hero.getHero_sign());
		tv_blood.setText(hero.getBlood());*/
		//返回最终要显示的View
		return convertView;
	}
	class ViewHolder{
		ImageView  iv_icon;
		TextView   tv_name;
		TextView   tv_price;
		TextView   tv_sign;
		TextView   tv_blood;
	}
}
