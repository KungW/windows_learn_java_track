package com.example.chtgamework;

import java.util.Hashtable;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity 
        implements OnClickListener{
	//首先定义或者申明出需要使用的控件
	private EditText   et_username;
	private EditText   et_password;
	private Button     btn_login;
	private Button     btn_register;
	public static  Hashtable members;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//加载View,并初始化
		initView();
		/*LoginActivity.this   this
		 * LoginActivity.this指的是在LoginActivity中他的对象
		 * this调用当前方法的对象
		 */
		//设置监听
		setListener();
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
		btn_login.setOnClickListener(LoginActivity.this);
		btn_register.setOnClickListener(this);
	}
	private void initView() {
		et_username  = (EditText) findViewById(R.id.editText1);
		et_password  = (EditText) findViewById(R.id.editText2);
		btn_login    = (Button) findViewById(R.id.button1);
		btn_register = (Button) findViewById(R.id.button2);
		btn_login.setText("登录");
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			String username=et_username.getText().toString();
			String password=et_password.getText().toString();
			try{
				
				DBHelper db = new DBHelper(LoginActivity.this,"User.db",null,1);
				SQLiteDatabase User = db.getWritableDatabase();
				Cursor reader = User.query("User", new String[]{"username","userpwd"},"username = ? and userpwd = ?" ,
						new String[]{et_username.getText().toString(),et_password.getText().toString()},null,null,null);
				if(reader.getCount()>0)
				{
					showMsg("sss");
					Intent  intent =new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(
							getApplicationContext(),
							"用户名或密码输入有误", 0).show();
				}
			}catch(Exception e){
				showMsg(e.getMessage());
			}

			
			break;
        case R.id.button2:
        	/*members = new Hashtable();
        	String newusername=et_username.getText().toString();
			String newpassword=et_password.getText().toString();
        	members.put(newusername, newpassword);
        	Intent  intent =new Intent(LoginActivity.this,
					MainActivity.class);
        	startActivity(intent);*/
        	System.out.println("用户名或密码输入有误");
        	Intent  intent =new Intent(LoginActivity.this,
        			RegisterActivity.class);
        	startActivity(intent);
			break;
		}
	}
	/*public boolean  login(String username,String password){
		
		String n = (String) members.get(username);
		System.out.println(n);
		System.out.println("111111");
		if(null!=username&&!"".equals(username)
				&&null!=password&&!"".equals(password)){
			if(username.equals(username)&&password.equals(n)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	}*/

		
	
		
		

}

