package com.example.actionbar.customactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        CustomActionBar actionBar0 = (CustomActionBar) findViewById(R.id.actionbar_0);
        CustomActionBar actionBar1 = (CustomActionBar) findViewById(R.id.actionbar_1);
        CustomActionBar actionBar2 = (CustomActionBar) findViewById(R.id.actionbar_2);
        CustomActionBar actionBar3 = (CustomActionBar) findViewById(R.id.actionbar_3);
        CustomActionBar actionBar4 = (CustomActionBar) findViewById(R.id.actionbar_4);
        CustomActionBar actionBar5 = (CustomActionBar) findViewById(R.id.actionbar_5);
        CustomActionBar actionBar6 = (CustomActionBar) findViewById(R.id.actionbar_6);

        //actionbar0默认只有返回键

        //只有标题
        actionBar1.setStyleNoBack("标题");

        //只有菜单
        actionBar2.setStyle("菜单", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击菜单",Toast.LENGTH_SHORT).show();
            }
        });

        //返回键 + 标题
        actionBar3.setStyle("标题");

        //返回键 + 标题 + 菜单
        actionBar4.setStyle("标题", "菜单", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击菜单",Toast.LENGTH_SHORT).show();
            }
        });

        //返回键 + 标题 + 菜单图标
        actionBar5.setStyle("标题", R.mipmap.more_white, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击菜单",Toast.LENGTH_SHORT).show();
            }
        });

        //搜索框模式
        actionBar6.setStyle(true);
    }
}
