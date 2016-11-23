package com.cht.listview_2;

import java.util.LinkedList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	    private List<User> Data = null;
	    private Context context;
	    private MyAdapter Adapter = null;
	    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        listview = (ListView) findViewById(R.id.listView1);
        Data = new LinkedList<User>();
        Data.add(new User("关羽","过五关斩六将",R.drawable.ic_gy	));
        Data.add(new User("张飞","大战长坂坡",R.drawable.ic_zf));
        Data.add(new User("赵云","七进七出",R.drawable.ic_zy));
        Data.add(new User("马超","絶粮返境",R.drawable.ic_mc));
        Data.add(new User("黄忠","老当益壮",R.drawable.ic_hz));
        Adapter = new MyAdapter((LinkedList<User>) Data, context);
        listview.setAdapter(Adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

