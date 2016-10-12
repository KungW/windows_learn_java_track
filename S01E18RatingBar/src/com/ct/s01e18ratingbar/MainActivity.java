package com.ct.s01e18ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends Activity {
	private RatingBar ratingBar;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ratingBar = (RatingBar)findViewById(R.id.firstRatingbar);
		button =(Button)findViewById(R.id.button);
		
		RatingBarListener listener = new RatingBarListener();
		ratingBar.setOnRatingBarChangeListener(listener);
		
		ButtonListener buttonListener = new ButtonListener();
		button.setOnClickListener(buttonListener);
	}
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ratingBar.setRating(ratingBar.getRating() + 1.0f);
		}
		
	}
	class RatingBarListener implements OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			// TODO Auto-generated method stub
			System.out.println("rating:"+ rating + "fromuser:" + fromUser);
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
