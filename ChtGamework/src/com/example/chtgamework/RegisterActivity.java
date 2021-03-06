package com.example.chtgamework;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
public class RegisterActivity extends Activity{
	private Button btn_register;
	private EditText   et_username;
	private EditText   et_password;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		//加载View,并初始化
		initView();
		//设置监听
		System.out.println("系统提示");
		setListener();
	}
	private void initView() {
	
		et_username  = (EditText) findViewById(R.id.editText1);
		et_password  = (EditText) findViewById(R.id.editText2);
		btn_register = (Button) findViewById(R.id.button2);
		
	}
	public void showMsg(String value)
	{	
		AlertDialog.Builder dialog=new AlertDialog.Builder(this);
		dialog.setTitle("系统提示");
		dialog.setMessage(value);
		dialog.setPositiveButton("确定",null);
		dialog.show();
	}
	private void setListener() {
		btn_register.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try
				{
					DBHelper db = new DBHelper(RegisterActivity.this,"User.db",null, 1);
					SQLiteDatabase user = db.getWritableDatabase();
					System.out.print("succeed");
					ContentValues uservalues = new ContentValues();
					uservalues.put("username",et_username.getText().toString());
					uservalues.put("userpwd", et_password.getText().toString());
					long rowid = user.insert("User", null, uservalues);
					System.out.println(rowid);
					if(rowid>0){
						showMsg("注册成功！");
						Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
						startActivity(intent);
					}else
					{
						showMsg("失败:(");
					}
				}catch(Exception e){
					showMsg(e.getMessage());
				}
				
			}
			
		});
	}
}
