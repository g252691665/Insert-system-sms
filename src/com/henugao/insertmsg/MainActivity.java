package com.henugao.insertmsg;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void insert(View v){
		Thread thread = new Thread(){
			@Override
			public void run() {
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				ContentResolver cr = getContentResolver();
				ContentValues cv = new ContentValues();
				cv.put("date",System.currentTimeMillis());
				cv.put("body","你好，你的尾号6537的银行卡里面进账1000000元现金");
				cv.put("address", "95588");
				cv.put("type", 1);
				cr.insert(Uri.parse("content://sms"), cv);
			}
		};
		thread.start();
	}

}
