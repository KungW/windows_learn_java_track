package com.ct.s01e11img;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {
	ImageView imView1;
	ImageView imView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imView1 = (ImageView)findViewById(R.id.imaId);
		imView2 = (ImageView)findViewById(R.id.imaId2);
		
		imView1.setScaleType(ScaleType.CENTER);
		imView2.setScaleType(ScaleType.FIT_CENTER);
		
		//imView1.setImageResource(R.drawable.timg);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
