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
		
	}

	@Override
	//当打开数据库时传入的版本号与当前的版本号不同时会调用该方法
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}



}


