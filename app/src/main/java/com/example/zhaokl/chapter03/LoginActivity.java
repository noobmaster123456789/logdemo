package com.example.zhaokl.chapter03;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 用于模拟登录的Activity
 */
public class LoginActivity extends AppCompatActivity {
	//用户名
	EditText userNameTxt;
	//密码
	EditText passwordTxt;
	//登录按钮
	Button loginBtn;
	//提示
	TextView tipsTv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//初始化各个组件
		userNameTxt =(EditText)findViewById(R.id.userNameTxt);
		passwordTxt = (EditText) findViewById(R.id.passwordTxt);
		tipsTv = (TextView) findViewById(R.id.tipsTxt);
		loginBtn = (Button)findViewById(R.id.loginBtn);
		//实现点击Button的业务逻辑
		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//获取用户名
				String userName = userNameTxt.getText().toString();
				//获取密码
				String password = passwordTxt.getText().toString();
				//判断
				//判断用户名
				if(!"admin".equals(userName)){
					tipsTv.setText("用户名不存在!");
					tipsTv.setVisibility(View.VISIBLE);
					return;
				}
				if(!"1".equals(password)){
					tipsTv.setText("密码不正确!");
					tipsTv.setVisibility(View.VISIBLE);
					return;
				}
				if("admin".equals(userName)&&"1".equals(password)){
					tipsTv.setText("登录成功!");
					tipsTv.setVisibility(View.VISIBLE);
				}
			}
		});
	}
}