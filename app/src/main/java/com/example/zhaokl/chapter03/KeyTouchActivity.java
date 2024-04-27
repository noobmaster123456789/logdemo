package com.example.zhaokl.chapter03;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 该类用于演示OnTouchEvent的使用
 *
 */
public class KeyTouchActivity extends AppCompatActivity {
	TouchView touchView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化自定义的View
		touchView = new TouchView(this);
		// 设置当前显示的用户界面
		setContentView(touchView);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) { // 重写的onTouchEvent回调方法
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN://手指按下
				// 改变x坐标
				touchView.x = (int) event.getX();
				// 改变y坐标
				touchView.y = (int) event.getY() - 52;

				touchView.postInvalidate();
				// 重绘
				break;
			case MotionEvent.ACTION_MOVE: //手指移动
				// 改变x坐标
				touchView.x = (int) event.getX();
				// 改变y坐标
				touchView.y = (int) event.getY() - 52;
				touchView.postInvalidate();
				// 重绘
				break;
			case MotionEvent.ACTION_UP://手指抬起
				// 改变x坐标
				touchView.x = -100;
				// 改变y坐标
				touchView.y = -100;
				// 重绘
				touchView.postInvalidate();
				break;
		}
		return super.onTouchEvent(event);
	}

	class TouchView extends View {
		// 画笔
		Paint paint;
		// x坐标
		int x =300;
		// y坐标
		int y = 300;
		// 矩形的宽度
		int width = 100;
		public TouchView(Context context) {
			super(context);
			// 初始化画笔
			paint = new Paint();

		}
		@Override
		protected void onDraw(Canvas canvas) {
			// 绘制方法
			canvas.drawColor(Color.LTGRAY);
			// 绘制背景色
			canvas.drawRect(x, y, x + width, y + width, paint);
			// 绘制矩形
			super.onDraw(canvas);
		}
	}
}
