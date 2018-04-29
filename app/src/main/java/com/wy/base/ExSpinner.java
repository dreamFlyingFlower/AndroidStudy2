package com.wy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.wy.R;

/**
 * spinner单选控件
 * 对选中的选项所事件处理,需要实现接口
 */
public class ExSpinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    // 数据适配器
    private ArrayAdapter<CharSequence> adapter;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_spinner);

        spinner = (Spinner) findViewById(R.id.spinner);

        adapter = ArrayAdapter.createFromResource(this, R.array.autocompletetext,
                android.R.layout.simple_list_item_1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 注册监听器
        spinner.setOnItemSelectedListener(this);
    }

    /**
     * 选中的时候触发事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = spinner.getItemAtPosition(position).toString();
        Toast.makeText(this,item,Toast.LENGTH_SHORT);
    }

    /**
     * 什么都没选的时候触发事件
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
