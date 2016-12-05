package com.example.chtgamework;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {
	private  ImageView iv_left;
	private  TextView  tv_title;
	private  ImageView iv_right;
	private  ListView  lv_hero;
	
	private  EditText   et_search;
	private  Button     btn_search;
	
	
	ArrayList<Hero>  heroList;
	ArrayList<Hero>  heroListSave;
	HeroAdapter  adapter;
	int  position=-1;
	
	
	public static final int ADD_HERO=0;
	public static final int UPDATE_HERO=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent=getIntent();
		String name=intent.getStringExtra("NAME");
		//���ز���ʼ���ؼ�
		initView();
		//���ü���
		setListener();
		//Ϊlistviewע��һ�������Ĳ˵�ContextMenu
		registerForContextMenu(lv_hero);
		tv_title.setText(name);
	    //�ṩ����
		int icons[]={R.drawable.ac,
				R.drawable.aze,
				R.drawable.bd,
				R.drawable.klst,
				R.drawable.lks,
				R.drawable.ne,
				R.drawable.tm};
		String names[]={"����","��¡","�׿���","����","��¡","��¡","��¡","��¡"};
		//heros=new Hero[7];
		heroList=new ArrayList<Hero>();
		heroListSave=new ArrayList<Hero>();
		for(int i=0;i<7;i++){
			heroList.add(new Hero(icons[i], 
					names[i], "7800", "̹��", 768));
		}
		heroListSave.addAll(heroList);
		adapter=new HeroAdapter(this, heroList, R.layout.hero_item);
		lv_hero.setAdapter(adapter);
		
	}
	private void setListener() {
		btn_search.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ArrayList<Hero>  newHeros=new ArrayList<Hero>();
				String name=et_search.getText().toString();
				if(name!=null&&!"".equals(name)){
					for(int i=0;i<heroListSave.size();i++){
						if(heroListSave.get(i).getName().contains(name)){
							newHeros.add(heroListSave.get(i));
						}
					}
				}
				if(newHeros.size()==0){
					heroList.clear();
					heroList.addAll(heroListSave);
					adapter.notifyDataSetChanged();
				}else{
					heroList.clear();
					heroList.addAll(newHeros);
					adapter.notifyDataSetChanged();
				}
			}
		});
		
		//��ListView Item���ü���
		lv_hero.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//��ת������ʾ��ϸ��hero��Ϣ
				Intent intent=new Intent(MainActivity.this,
						HeroActivity.class);
				Hero  hero=heroList.get(position);
				//Serializable  ���л��ӿ�
				intent.putExtra("HERO_DESCRIBE", hero);
				//startActivity(intent);
				startActivityForResult(intent, ADD_HERO);
			}
		});
		/*lv_hero.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				return false;
			}
		});*/
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//Ҫ����δ���ش�������
		if(requestCode==ADD_HERO&&resultCode==HeroActivity.ADD_HERO_RSSULT){
			Hero hero=(Hero) data.getSerializableExtra("ADD_HERO_OK");
			heroList.add(hero);
			adapter.notifyDataSetChanged();
		}else if(requestCode==UPDATE_HERO&&
				resultCode==UpdateHeroActivity.UPDATER_HERO_RESULT){
			//�����޸�Ӣ�����ݺ�Ľ��
			Hero hero=
					(Hero) data.getSerializableExtra("UPDATER_HERO");
			Log.i("TAG", hero.getName());//��ͨ��־��Ϣ����ɫ����ɫ
			Log.d("TAG", hero.getName());//�ĵ���־��debug����ɫ��ɫ
			Log.w("TAG", hero.getName());//������Ϣ����ɫ��ɫ
			Log.e("TAG", hero.getName());//������Ϣ����ɫ��ɫ
			heroList.get(position).setName(hero.getName());
			heroList.get(position).setHero_sign(hero.getHero_sign());
			heroList.get(position).setPrice(hero.getPrice());;
			heroList.get(position).setBlood(hero.getBlood());;
			adapter.notifyDataSetChanged();
		}
	}
	private void initView() {
		iv_left=(ImageView) findViewById(R.id.iv_left);
		tv_title=(TextView) findViewById(R.id.tv_title);
		iv_right=(ImageView) findViewById(R.id.iv_right);
		iv_left.setVisibility(View.GONE);
		
		lv_hero=(ListView) findViewById(R.id.lv_hero);
		et_search=(EditText) findViewById(R.id.et_search);
		btn_search= (Button) findViewById(R.id.btn_search);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(0, 1, 0, "�޸�");
		menu.add(0, 2, 0, "ɾ��");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo acmi=
				(AdapterContextMenuInfo) item.getMenuInfo();
		position=acmi.position;
		switch (item.getItemId()) {
		case 1:
			//��ת���棬�������ݣ����ղ�����ش�������
			Intent  intent=new  Intent(MainActivity.this,UpdateHeroActivity.class);
			intent.putExtra("UPDATE_HERO", heroList.get(position));
			startActivityForResult(intent, UPDATE_HERO);
			Toast.makeText(getApplicationContext(), "�޸ı�ѡ����", 0).show();
			break;
		case 2:
			heroList.remove(position);
		    adapter.notifyDataSetChanged();
			Toast.makeText(getApplicationContext(), "ɾ����ѡ����", 0).show();
			break;
		}
		return super.onContextItemSelected(item);
	}
}
