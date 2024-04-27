package com.example.zhaokl.chapter03;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class KeyDownActivity extends AppCompatActivity {

	// 自定义的Button
	EditText showText;
	public void onCreate(Bundle savedInstanceState) { // 重写的onCreate方法
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keydown_btn);
		showText = (EditText) findViewById(R.id.showTxt);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 重写的键盘按下监听
		switch (keyCode) {
			case KeyEvent.KEYCODE_BACK:
				showText.setText("点击了【回退键】");
				break;
			case KeyEvent.KEYCODE_A:
				showText.setText("点击了【 A键】");
				break;
			case KeyEvent.KEYCODE_VOLUME_DOWN:
				showText.setText("点击了【 音量-】");
				break;
			case KeyEvent.KEYCODE_VOLUME_UP:
				showText.setText("点击了【 音量+】");
				break;
			default:
				break;
		}
		//
		return true;
		//return super.onKeyDown(keyCode, event);
	}
}
