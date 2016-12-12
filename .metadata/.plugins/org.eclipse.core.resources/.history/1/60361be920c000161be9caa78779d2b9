package com.example.chtgamework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	public static final String CREATE_USER="create table User(" +
			"id integer primary key autoincrement, " +
			"username varchar, " +
			"userpwd varchar)";
	
	private Context mContext;
	public DBHelper(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_USER);
		try{
			DBHelper DB = new DBHelper(LoginActivity.this,"User.db",null,1);
			User = DBhelp.getWritableDatabase();
			Cursor reader = User.query("User", new String[]{"username","userpsd"},"username = ? and userpsd = ?" ,
					new String[]{et_username.getText().toString(),et_password.getText().toString()},null,null,null);
			if(reader.getCount()>0)
			{
				showMsg("sss");
				Intent  intent =new Intent(LoginActivity.this,MainActivity.class);
				startActivity(intent);
			}else{
				showMsg("fff");
			}
		}catch(Exception e){
			showMsg(e.getMessage());
		}
	}

	@Override
	//当打开数据库时传入的版本号与当前的版本号不同时会调用该方法
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}



}


