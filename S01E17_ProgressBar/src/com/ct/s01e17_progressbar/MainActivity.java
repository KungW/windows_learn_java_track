package com.ct.s01e17_progressbar;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	private ProgressBar progressbar;
	private Button firstButton;
	private Button secondButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progressbar = (ProgressBar)findViewById(R.id.firstProgressBar);
		/*progressbar.setMax(100);
		progressbar.setProgress(20);
		progressbar.setSecondaryProgress(30);
		boolean flag = progressbar.isIndeterminate();*/
		firstButton = (Button)findViewById(R.id.firstbutton);
		secondButton = (Button)findViewById(R.id.secondbutton);
		
		progressbar.setMax(100);
		
		firstButton.setOnClickListener(new FirstListener());
		secondButton.setOnClickListener(new SecondListener());
	}
	class FirstListener implements android.view.View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressbar.incrementProgressBy(10);
		}
		
	}
	class SecondListener implements android.view.View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			progressbar.incrementSecondaryProgressBy(20);
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
