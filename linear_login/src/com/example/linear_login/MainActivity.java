package com.example.linear_login;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private EditText usertext;
	private EditText pwdtext;
	private TextView result;
	private Button okButton;
	private Button cancelButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usertext = (EditText)findViewById(R.id.usernameText);
		pwdtext = (EditText)findViewById(R.id.passwordText);
		result = (TextView)findViewById(R.id.resview);
		okButton = (Button)findViewById(R.id.okButton);
		cancelButton = (Button)findViewById(R.id.cancelButton);
		okbuttonlistener oklistener = new okbuttonlistener();
		okButton.setOnClickListener(oklistener);
		cancelbuttonlistener cancellistener = new cancelbuttonlistener();
		cancelButton.setOnClickListener(cancellistener);
		
		
		
		
		
	}
	class cancelbuttonlistener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			usertext.setText("");
			pwdtext.setText("");
			result.setText("");
		}
		
	}
	class okbuttonlistener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String str=usertext.getText().toString();
			int userint=Integer.parseInt(str);
			    String str2=pwdtext.getText().toString();
			    int pwdint =Integer.parseInt(str2);
			    
				if(userint==1&&pwdint==2){
					System.out.println("111");
					result.setText("登陆成功");
				}
				else
				{
					System.out.println("222");
					result.setText("登陆失败");
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