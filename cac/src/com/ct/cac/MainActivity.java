package com.ct.cac;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
	//实现计算机的和
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private EditText first;
	private EditText second;
	private TextView textview;
	Button testbutton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		button5 = (Button)findViewById(R.id.button5);
		button6 = (Button)findViewById(R.id.button6);
		first = (EditText)findViewById(R.id.editText1);
		second = (EditText)findViewById(R.id.editText2);
		textview = (TextView)findViewById(R.id.textView1);
		
		
		ButtonListener listener = new ButtonListener();
		button1.setOnClickListener(listener);
		button2.setOnClickListener(listener);
		button3.setOnClickListener(listener);
		button4.setOnClickListener(listener);
		button5.setOnClickListener(listener);
		button6.setOnClickListener(listener);
	}
	
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String str=first.getText().toString();
			int number1=Integer.parseInt(str);
		    String str2=second.getText().toString();
		    int number2=Integer.parseInt(str2);
			if(v.getId() == R.id.button1){
				int num =number1+number2;
				textview.setText(number1+"+"+number2+"结果："+ num);
			}
			else if(v.getId() == R.id.button2){
				int num =number1-number2;
				textview.setText(number1+"-"+number2+"结果："+ num);
			}
			else if(v.getId() == R.id.button3){
				int num =number1*number2;
				textview.setText(number1+"*"+number2+"结果："+ num);
			}
			else if(v.getId() == R.id.button4){
				float num =number1/number2;
				textview.setText(number1 + "/" + number2+"结果："+ num);
			}
			else if(v.getId() == R.id.button5){
				double num1 =Math.sqrt(number1);
				double num2 =Math.sqrt(number2);
				textview.setText(number1 + "的开方："+ num1 + "," + number2+ "的开方："+ num2 +"。");
			}
			else if(v.getId() == R.id.button6){
				int num1 =number1*number1;
				int num2 =number2*number2;
				textview.setText(number1 + "的平方："+ num1 + "," + number2+ "的平方："+ num2 +"。");
			}
			
			
		}
		
	}


}
