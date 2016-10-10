package com.ct.s01e09work;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private CheckBox eatBox;
	private CheckBox sleepBox;
	private CheckBox dotaBox;
	private CheckBox allBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		eatBox = (CheckBox)findViewById(R.id.eatBox);
		sleepBox = (CheckBox)findViewById(R.id.sleepBox);
		dotaBox = (CheckBox)findViewById(R.id.dotaBox);
		allBox = (CheckBox)findViewById(R.id.allBox);
		
		AllListener listener = new  AllListener();
		allBox.setOnCheckedChangeListener(listener);
	}
	class AllListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			eatBox.setChecked(isChecked);
			sleepBox.setChecked(isChecked);
			dotaBox.setChecked(isChecked);
			
			
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
