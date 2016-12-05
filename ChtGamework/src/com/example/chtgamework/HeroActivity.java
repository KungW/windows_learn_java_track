package com.example.chtgamework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroActivity extends Activity implements OnClickListener{
	private EditText et1;
	private EditText et2;
	private EditText et3;
	private EditText et4;
	
	private Button   save;
	
	private ImageView iv_left;
	private ImageView iv_right;
	
	public static final  int ADD_HERO_RSSULT=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero);
		initView();
		//inntData();
		initListener();
		Intent intent=getIntent();
		Hero  hero=(Hero) //???
				intent.getSerializableExtra("HERO_DESCRIBE");
		//设置显示
		et1.setText(hero.getName());
		et2.setText(hero.getPrice());
		et3.setText(hero.getHero_sign());
		et4.setText(hero.getBlood()+"");
		//设置是否能得到焦点
		et1.setFocusable(false);
		//设置是否能通过触摸得到焦点
		et1.setFocusableInTouchMode(false);
		et2.setFocusable(false);et2.setFocusableInTouchMode(false);
		et3.setFocusable(false);et3.setFocusableInTouchMode(false);
		et4.setFocusable(false);et4.setFocusableInTouchMode(false);
	}
	private void initListener() {
		iv_left.setOnClickListener(this);
		iv_right.setOnClickListener(this);
		save.setOnClickListener(this);
	}
	private void initView() {
		et1=(EditText) findViewById(R.id.tv_herodes_name);
		et2=(EditText) findViewById(R.id.tv_herodes_price);
		et3=(EditText) findViewById(R.id.tv_herodes_sign);
		et4=(EditText) findViewById(R.id.tv_herodes_blood);
		
		save=(Button) findViewById(R.id.save);
		
		iv_left=(ImageView) findViewById(R.id.iv_left);
		iv_right=(ImageView) findViewById(R.id.iv_right);
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_left:
			this.finish();
			break;
		case R.id.iv_right:
			et1.setFocusable(true);et1.setFocusableInTouchMode(true);
			et2.setFocusable(true);et2.setFocusableInTouchMode(true);
			et3.setFocusable(true);et3.setFocusableInTouchMode(true);
			et4.setFocusable(true);et4.setFocusableInTouchMode(true);
			//请求的到焦点
			et1.requestFocus();
			et1.setText("");et1.setHint("请输入英雄名称");
			et2.setText("");et2.setHint("请输入英雄价格");
			et3.setText("");et3.setHint("请输入英雄分类");
			et4.setText("");et4.setHint("请输入英雄血量");
			save.setVisibility(View.VISIBLE);
			break;
		case R.id.save:
			String name=et1.getText().toString();
			Hero  hero=new Hero(R.drawable.ac,name,"","",1213);
			Intent intent=new Intent();
			intent.putExtra("ADD_HERO_OK", hero);
			setResult(ADD_HERO_RSSULT, intent);
			this.finish();
			break;
		}
	}
}

