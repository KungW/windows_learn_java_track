package com.example.firstandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void doClick(View view){
		//第一个文本框数据获得
		EditText edittext=(EditText)findViewById(R.id.editText1);
		String str=edittext.getText().toString();
		int number1=Integer.parseInt(str);
		//获得第二个文本框输入的数据、
		EditText editText2=(EditText) findViewById(R.id.editText2);
	    String str2=editText2.getText().toString();
	    int number2=Integer.parseInt(str2);
	    
	    int he=number1+number2;
	    
	    TextView textView=(TextView)findViewById(R.id.textView1);
	    textView.setText("和为："+he);
	   /* 
		Toast.makeText(
				MainActivity.this, 
				"点我干啥？",
				1).show();*/
	}
}
