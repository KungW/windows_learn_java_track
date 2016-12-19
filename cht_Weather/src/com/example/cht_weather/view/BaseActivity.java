package com.example.cht_weather.view;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //加载布局
		initLayout();
		//加载控件
		initView();
		//加载数据
		initData();
		//设置监听器
		initListener();
	}
	public void initLayout(){
	}
	public  void initListener() {
	}
	public void initData() {
	}
	public void initView() {
	}
}
