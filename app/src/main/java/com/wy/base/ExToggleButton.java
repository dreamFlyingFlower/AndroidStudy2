package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.wy.R;

/**
 * togglebutton和switch组件,相同的,只是样式不同
 */
public class ExToggleButton extends AppCompatActivity {

    private ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_toggle_button);

        tb = (ToggleButton)findViewById(R.id.toggle);

        // 是否被选中
        boolean flag = tb.isChecked();

        // 监听切换事件
        tb.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }else{

                }
            }
        });
    }
}
