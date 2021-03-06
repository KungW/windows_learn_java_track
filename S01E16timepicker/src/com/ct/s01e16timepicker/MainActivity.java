package com.ct.s01e16timepicker;

import com.ct.s01e16timepicker.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
	private TimePicker firstTimePicker;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		firstTimePicker = (TimePicker)findViewById(R.id.firstTimepicker);
		button = (Button)findViewById(R.id.button);
		firstTimePicker.setIs24HourView(true);
		TimeListener timeListener= new TimeListener();
		firstTimePicker.setOnTimeChangedListener(timeListener);
		
		ButtonListener buttonListener = new ButtonListener();
		button.setOnClickListener(buttonListener);
	}
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int hour = firstTimePicker.getCurrentHour();
			int minute = firstTimePicker.getCurrentMinute();
			System.out.println("����h:" + hour+ ",minute:"+ minute);
			
		}
		
	}
	class TimeListener implements OnTimeChangedListener{

		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			System.out.println("Hour:" + hourOfDay + ",minute" + minute);
			
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
