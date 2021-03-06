package com.example.cht_weather.view;

import com.example.cht_weather.MainActivity;
import com.example.cht_weather.R;
import com.example.cht_weather.adapter.SplashVPAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends BaseActivity{
	private ViewPager vp;
	private Button    btn_start;
	private ImageView iv1;
	private ImageView iv2;
	private ImageView iv3;
	private TextView  tv_splash;
	private int[]  images;	
	SharedPreferences  sp;
	boolean        isFirstLogin=true;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp=getSharedPreferences("LOGIN_CONFIG", MODE_PRIVATE);
		isFirstLogin=sp.getBoolean("FIRST_OPEN", true);
		/*//1.构建对象
		SharedPreferences  sp=getSharedPreferences("SP", MODE_PRIVATE);
		//2.存储数据
		Editor             spe=sp.edit();
		//3.获取数据
		spe.putString("STR", "testStr");
		//4.数据提交
		spe.commit();
		Log.i("TAG", sp.getString("STR", "DEFAULT"));*/
		//除了在BaseActivity中定义的内容
		if(isFirstLogin){
			tv_splash.setVisibility(View.GONE);
			iv1.setVisibility(View.VISIBLE);
			iv2.setVisibility(View.VISIBLE);
			iv3.setVisibility(View.VISIBLE);
			SplashVPAdapter  adapter=new SplashVPAdapter(
					SplashActivity.this, images,
					R.layout.splash_vp_item);
			vp.setAdapter(adapter);
			Editor  spe=sp.edit();
			spe.putBoolean("FIRST_OPEN", false);
			spe.commit();
		}else{
			tv_splash.setVisibility(View.VISIBLE);
			iv1.setVisibility(View.GONE);
			iv2.setVisibility(View.GONE);
			iv3.setVisibility(View.GONE);
			//模拟过2s跳转主界面
			Thread thread=new Thread(new Runnable() {
				@Override
				public void run() {
					//系统时钟，可以根据系统时间去判断修正睡眠时间
					SystemClock.sleep(2000);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Intent  intent=new  Intent(SplashActivity.this,
									MainActivity.class);
							startActivity(intent);
							SplashActivity.this.finish();
						}
					});
					/*//错误
					Intent  intent=new  Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(intent);
					SplashActivity.this.finish();*/
				}
			});
			thread.start();
			
			
			
			
			/*Thread  thread=new Thread(new Runnable() {
				@Override
				public void run() {
					//等待两秒
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Intent  intent=new  Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(intent);
					SplashActivity.this.finish();
				}
			});
			thread.start();*/
			
			/*Handler  handler=new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent  intent=new  Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(intent);
					SplashActivity.this.finish();
				}
			}, 2000);*/
		}
	}
	@Override
	public void initLayout() {
		setContentView(R.layout.activity_splash);
		//ViewPager
	}
	@Override
	public void initView() {
		vp=(ViewPager) findViewById(R.id.splash_vp);
		iv1=(ImageView) findViewById(R.id.iv_splash_point1);
		iv2=(ImageView) findViewById(R.id.iv_splash_point2);
		iv3=(ImageView) findViewById(R.id.iv_splash_point3);
		btn_start=(Button) findViewById(R.id.btn_start);
		tv_splash=(TextView) findViewById(R.id.tv_splash);
	}
	@Override
	public void initData() {
		images=new int[]{R.drawable.welcome_1,
				R.drawable.welcome_2,
				R.drawable.welcome_3};
	}
	@Override
	public void initListener() {
		btn_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//跳转主界面
				Intent  intent=new Intent(SplashActivity.this,MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}
		});
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			@Override//当某个页面被选中的时候会执行的方法，arg0表示当前ViewPage的页面的id
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:
					iv1.setImageResource(R.drawable.point_checked);
					iv2.setImageResource(R.drawable.point_nocheked);
					iv3.setImageResource(R.drawable.point_nocheked);
					btn_start.setVisibility(View.INVISIBLE);
					break;
				case 1:
					iv1.setImageResource(R.drawable.point_nocheked);
					iv2.setImageResource(R.drawable.point_checked);
					iv3.setImageResource(R.drawable.point_nocheked);
					btn_start.setVisibility(View.INVISIBLE);
					break;
				case 2:
					iv1.setImageResource(R.drawable.point_nocheked);
					iv2.setImageResource(R.drawable.point_nocheked);
					iv3.setImageResource(R.drawable.point_checked);
					btn_start.setVisibility(View.VISIBLE);
					break;
				}
			}
			@Override//当页面滚动的时候会执行的方法
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override//当页面滚动状态发生变化的时候会执行的方法
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
	}
}
