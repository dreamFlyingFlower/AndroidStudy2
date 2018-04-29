package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.wy.R;

/**
 * 自动完成输入字符串
 */
public class ExAutocompleteText extends AppCompatActivity {

    // 自动完成控件
    private AutoCompleteTextView act;
    // 数据适配器
    private ArrayAdapter<CharSequence> adapter;
    // 数据源,可以是资源文件中的数据,也可以是数据库中的数据
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_autocomplete_text);
        act = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        // 第2个参数是系统自带的显示数据的样式
        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, datas);
        // 获取资源文件中的数据
        adapter = ArrayAdapter.createFromResource(this,
                R.array.autocompletetext,android.R.layout.simple_list_item_1);
        act.setAdapter(adapter);
    }
}
