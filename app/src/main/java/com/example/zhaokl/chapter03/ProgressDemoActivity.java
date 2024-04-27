package com.example.zhaokl.chapter03;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressDemoActivity extends AppCompatActivity {
	// 滚动等待对话框
	Button progressCircleBtn;
	// 进度条对话框
	Button progressBarBtn;
	//存储进度条当前值，初始为 0
	int count = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress_demo);
		// 初始化组件
		progressCircleBtn = (Button) findViewById(R.id.progressCircleBtn);
		// 设置监听器对象
		progressCircleBtn.setOnClickListener(onClickListener);
		//
		progressBarBtn = (Button) findViewById(R.id.progressBarBtn);
		progressBarBtn.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
				case R.id.progressCircleBtn: {
					// 滚动等待对话框
					final ProgressDialog progressDialog = new ProgressDialog(
							ProgressDemoActivity.this);
					progressDialog.setIcon(R.mipmap.ic_launcher);
					progressDialog.setTitle("等待");
					progressDialog.setMessage("正在加载....");
					progressDialog.show();
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Thread.sleep(15000);
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								progressDialog.dismiss();
							}
						}
					}).start();

				}
				case R.id.progressBarBtn: {
					// 滚动等待对话框
					final ProgressDialog progressDialog = new ProgressDialog(
							ProgressDemoActivity.this);// 得到一个对象
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // 设置为矩形进度条
					progressDialog.setTitle("提示");
					progressDialog.setMessage("数据加载中，请稍后...");
					progressDialog.setIcon(R.mipmap.ic_launcher);
					// 设置进度条是否为不明确
					progressDialog.setIndeterminate(false);
					progressDialog.setCancelable(true);
					// 设置进度条的最大值
					progressDialog.setMax(200);
					// 设置当前默认进度为 0
					progressDialog.setProgress(0);
					// 设置第二条进度值为1000
					progressDialog.setSecondaryProgress(1000);
					// 显示进度条
					progressDialog.show();
					new Thread() {
						public void run() {
							while (count <= 200) {
								progressDialog.setProgress(count++);
								try {
									Thread.sleep(1000);  //暂停 0.1秒
								} catch (Exception e) {
								}
							}
						}
					}.start();
				}
				default:
					break;
			}

		}
	};

}

