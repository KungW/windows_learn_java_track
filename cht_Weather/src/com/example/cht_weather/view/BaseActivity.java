package com.example.cht_weather.view;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //���ز���
		initLayout();
		//���ؿؼ�
		initView();
		//��������
		initData();
		//���ü�����
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
