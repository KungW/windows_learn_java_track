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
			//��̬�ļ���һ������View
			convertView=View.inflate(context, layout, null);
			viewHolder=new ViewHolder();
			//��ViewHolder��id
			viewHolder.iv_icon=(ImageView) convertView.findViewById(R.id.iv_hero);
			viewHolder.tv_name=(TextView) convertView.findViewById(R.id.tv_name);
			viewHolder.tv_price=(TextView) convertView.findViewById(R.id.tv_price);
			viewHolder.tv_sign=(TextView) convertView.findViewById(R.id.tv_sign);
			viewHolder.tv_blood=(TextView) convertView.findViewById(R.id.tv_blood);
			//��viewHolder��convertView�󶨡�
			//Ҳ�������Ϊʹ��viewolder��convertView���ñ��
			convertView.setTag(viewHolder);
		}
		//�����λ�ã�������ζ���convertView�������
		//��convertView���ó����ViewHolder
		viewHolder=(ViewHolder) convertView.getTag();
		//���ö�Ӧ�Ŀؼ���ʾ
		viewHolder.iv_icon.setImageResource(hero.getHero_icon());
		viewHolder.tv_name.setText(hero.getName());
		viewHolder.tv_price.setText(hero.getPrice());
		viewHolder.tv_sign.setText(hero.getHero_sign());
		viewHolder.tv_blood.setText(hero.getBlood()+"");
		
		//����View����ʾ
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
		//��������Ҫ��ʾ��View
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
