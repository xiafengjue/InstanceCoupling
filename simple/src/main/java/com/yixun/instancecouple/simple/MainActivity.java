package com.yixun.instancecouple.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yixun.library.annotation.SaveField;
import com.yixun.library.tools.Couple;

/**
 * @author Zheng Yang on 2018/3/27 16:14
 */

public class MainActivity extends AppCompatActivity {
    @SaveField//给name属性添加一个注解
    public String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            savedInstanceState = new Bundle();
            savedInstanceState.putString("name", "This is test text");
        }
        //读取数据
        Couple.readInstance(this, savedInstanceState);
        TextView textView = findViewById(R.id.textview);
        textView.setText(name);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存数据
        Couple.saveInstance(this, outState);
    }
}
