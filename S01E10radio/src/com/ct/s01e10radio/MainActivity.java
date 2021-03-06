package com.ct.s01e10radio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private RadioGroup radioGroup;
	private RadioButton femaleButton;
	private RadioButton maleButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		radioGroup = (RadioGroup)findViewById(R.id.radiogroupId);
		femaleButton = (RadioButton)findViewById(R.id.femaleButtonId);
		maleButton = (RadioButton)findViewById(R.id.maleButtonId);
		
		RadioGroupListener listener = new RadioGroupListener();
		radioGroup.setOnCheckedChangeListener(listener); 
		
		RadioButtonListener radiobuttonlistener = new RadioButtonListener();
		femaleButton.setOnCheckedChangeListener(radiobuttonlistener);
	}
	class RadioButtonListener implements android.widget.CompoundButton.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			// TODO Auto-generated method stub
			System.out.println("isCed:      "+ isChecked);
			
		}
		
	}
	class RadioGroupListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if(checkedId == femaleButton.getId()){
				System.out.println("female");
			}
			else if(checkedId == maleButton.getId()){
				System.out.println("male");
			}
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
