package com.example.greenroast;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toast = new Toast(this);
		toast.setGravity(Gravity.TOP, 0,
				getWindowManager().getDefaultDisplay().getHeight()/8);
		toast.setView(LayoutInflater.from(this).inflate(R.layout.toast, null));
		toast.setDuration(Toast.LENGTH_SHORT);
		
	}
	private long firstTime;
	private Toast toast;
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		long secondTime;
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			secondTime = System.currentTimeMillis();
			if (secondTime - firstTime > 2000) {
				toast.show();
				firstTime = secondTime;
			}else {
				finish();
			}
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
}
