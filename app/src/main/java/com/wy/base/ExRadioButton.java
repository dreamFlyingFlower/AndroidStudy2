package com.wy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * 单选框例子RadioButton,
 * 多选checkbox
 */
@ContentView(R.layout.activity_radio_button)
public class ExRadioButton extends AppCompatActivity {


    @ViewInject(R.id.sex)
    private RadioGroup sex;
    @ViewInject(R.id.female)
    private RadioButton female;
    @ViewInject(R.id.male)
    private RadioButton male;
    @ViewInject(R.id.show)
    private TextView show;
    @ViewInject(R.id.checkBox1)
    private CheckBox checkBox1;
    @ViewInject(R.id.checkbox)
    private TextView checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //给单选框加上点击事件的两种方式,直接写一个匿名函数类
//        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(RadioGroup group,int checkedId){
//                if(checkedId == male.getId()){
//                    show.setText(male.getText().toString());
//                }
//            }
//        });
        //或调用一个实现了匿名函数的变量
        sex.setOnCheckedChangeListener(click);

        //给checkbox加事件,同单选框加事件
//        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
//                checkbox.setText(isChecked+"");
//            }
//        });
        checkBox1.setOnCheckedChangeListener(checkboxclick);
    }

    private RadioGroup.OnCheckedChangeListener click = new RadioGroup.OnCheckedChangeListener(){
        @Override
         public void onCheckedChanged(RadioGroup group,int id){
            if(id == female.getId()){
                show.setText(female.getText().toString());
            }else if(id==male.getId()){
                show.setText(male.getText().toString());
            }
        }
    };

    private CheckBox.OnCheckedChangeListener checkboxclick = new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            checkbox.setText(isChecked+"");
        }
    };

}
