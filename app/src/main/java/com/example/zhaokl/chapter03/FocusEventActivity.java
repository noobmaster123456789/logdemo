package com.example.zhaokl.chapter03;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class FocusEventActivity extends AppCompatActivity {
	//定义4个button
	FocusButton focusButton1;
	FocusButton focusButton2;
	FocusButton focusButton3;
	FocusButton focusButton4;

	// 声明myButton04的引用
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//创建4个FocusButton对象
		focusButton1 = new FocusButton(this);
		focusButton2 = new FocusButton(this);
		focusButton3 = new FocusButton(this);
		focusButton4 = new FocusButton(this);
		//设置focusButton1上的文字
		focusButton1.setText("focusButton1");
		// 设置focusButton2上的文字
		focusButton2.setText("focusButton2");
		// 设置focusButton3上的文字
		focusButton3.setText("focusButton3");
		// 设置focusButton4上的文字
		focusButton4.setText("focusButton4");
		// 创建一个线性布局
		LinearLayout linearLayout = new LinearLayout(this);
		// 设置其布局方式为垂直
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		// 将focusButton1添加到布局中
		linearLayout.addView(focusButton1);
		// 将focusButton2添加到布局中
		linearLayout.addView(focusButton2);
		// 将focusButton3添加到布局中
		linearLayout.addView(focusButton3);
		// 将focusButton4添加到布局中
		linearLayout.addView(focusButton4);
		// 设置当前的用户界面
			setContentView(linearLayout);

	}
	class FocusButton extends Button {
		// 自定义Button
		public FocusButton(Context context) {
			// 构造器

			super(context);
		}

		protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
			String suffix = "(选中)";
			String text = getText().toString();
			// 重写的焦点变化方法

			if(focused){
				//获取焦点时，添加(选中)文字
				if(!text.contains(suffix)){
					this.setText(text+suffix);
//					Log.d("点击事件","true");
//					Toast.makeText(getContext(), "获取焦点", Toast.LENGTH_SHORT).show();
				}
			}else{
				//去掉(选中)文字
				if(text.contains(suffix)){
					text = text.substring(0,text.length()-suffix.length());
					this.setText(text);
				}
			}
			super.onFocusChanged(focused, direction, previouslyFocusedRect);
		}
	}
}
