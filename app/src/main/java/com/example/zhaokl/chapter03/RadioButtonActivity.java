package com.example.zhaokl.chapter03;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * RadioButton和RadioGroup的使用
 *
 */
public class RadioButtonActivity extends AppCompatActivity {
    //显示选择的单选按钮文本
    private  TextView   chooseTxt;
    //按钮组
    private  RadioGroup  radioGroup;
    //多个单选按钮
    private  RadioButton  radioButton1;
    private  RadioButton   radioButton2;
    //清除按钮
    private  Button   radioClearBtn;
    //新增按钮
    private Button    radioAddBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.radiobutton_demo);
        //初始化按钮
        chooseTxt = (TextView)findViewById(R.id.chooseTxt);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        //清除选中状态
        radioClearBtn=(Button)findViewById(R.id.radio_clearBtn);
        radioClearBtn.setOnClickListener(onClickListener);
        //增加子选项
        radioAddBtn=(Button)findViewById(R.id.radio_addBtn);
        radioAddBtn.setOnClickListener(onClickListener);
    }
    /**
     * 定义按钮组的监听事件
     */
    private OnCheckedChangeListener  onCheckedChangeListener=new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {//获取当前选中的按钮的Id
                case R.id.radioButton1:
                    chooseTxt.setText("我选择的是:"+radioButton1.getText());
                    break;
                case R.id.radioButton2:
                    chooseTxt.setText("我选择的是:"+radioButton2.getText());
                    break;
                default:
                    chooseTxt.setText("我选择的是:新增");
                    break;
            }
        }
    };
    //定义清除状态按钮和新增按钮的点击事件
    private OnClickListener  onClickListener=new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.radio_clearBtn:
                    radioGroup.check(-1);//清除选项
                    chooseTxt.setText("我选择的是...?");
                    break;
                case R.id.radio_addBtn:
                    //新增子选项
                    RadioButton  newRadio =new RadioButton(RadioButtonActivity.this);
                    newRadio.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                    newRadio.setText("新增");
                    radioGroup.addView(newRadio,radioGroup.getChildCount());
                    break;
                //

                default:
                    break;
            }
        }
    };
} 