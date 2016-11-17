package com.ct.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listview;
	private String[]data={"关羽","张飞","赵云","马超","黄忠"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得listview对象
        listview=(ListView) findViewById(R.id.listView1);
        //构件适配器对象
        MyAdapter  adapter=new MyAdapter(this,
        		data,
        		R.layout.listview_item);
        
        //设置适配器
        listview.setAdapter(adapter);
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

