package com.example.chtgamework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateHeroActivity extends Activity {
	private EditText   et1;
	private EditText   et2;
	private EditText   et3;
	private EditText   et4;
	private ImageView  iv;
	public static final   int UPDATER_HERO_RESULT=100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_hero);
		initView();
		Intent  intent=getIntent();
		Hero  hero=
				(Hero) intent.getSerializableExtra("UPDATE_HERO");
		et1.setText(hero.getName());
		et2.setText(hero.getHero_sign());
		et3.setText(hero.getPrice());
		et4.setText(hero.getBlood()+"");
		iv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name=et1.getText().toString();
				String hero_sign=et2.getText().toString();
				String price=et3.getText().toString();
				String blood=et4.getText().toString();
				Hero  hero=new Hero(R.drawable.aze, 
						name, price, hero_sign,
						Integer.parseInt(blood));
				Intent  intent=new Intent();
				intent.putExtra("UPDATER_HERO", hero);
				setResult(UPDATER_HERO_RESULT,intent);
				UpdateHeroActivity.this.finish();
			}
		});
	}
	private void initView() {
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		et4=(EditText) findViewById(R.id.editText4);
		iv=(ImageView) findViewById(R.id.iv_right);
	}

}

