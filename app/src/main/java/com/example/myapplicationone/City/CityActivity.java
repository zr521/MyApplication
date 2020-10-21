package com.example.myapplicationone.City;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.myapplicationone.activity.EightActivity;
import com.example.myapplicationone.activity.One_EnvironmentActivity;
import com.example.myapplicationone.Six_Goshoping.GoshopingActivity;
import com.example.myapplicationone.R;
import com.example.myapplicationone.activity.ThreeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityActivity extends Activity {
    private GridView ctgridView;
    private SimpleAdapter gridAdaper;

    private int[] imageid = {
            R.drawable.icon_weather,
            R.drawable.icon_shopping,
            R.drawable.icon_security,
            R.drawable.icon_agriculture};
    private int[] colorid = {
            R.color.colorhui,
            R.color.colortitle,
            R.color.colortitle,
            R.color.colorhui};
    private String[] stringid = {
            "环境气象",
            "智能超市",
            "预警信息",
            "智能农场"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ctgridView = findViewById(R.id.CTGridView);

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();//建立数据源
        for (int i = 0; i < stringid.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("imageid", imageid[i]);//put方法是向里面插入内容
            showitem.put("stringid", stringid[i]);
            listitem.add(showitem);
        }

        gridAdaper = new SimpleAdapter(
                CityActivity.this,
                listitem,
                R.layout.ctitems,
                new String[]{"imageid", "stringid"},
                new int[]{R.id.CtitemsImageView, R.id.CtitemsTextVIew1});
        // 数据源
        // layout：每个列表项显示的布局，
        //（context：一般指当前Activity对象，data：数据源变量，
        // new String[]{}：数据源中的“键”,
        // new int[]{}：显示数据源的控件ID)；
        ctgridView.setAdapter(gridAdaper);
        ctgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position + 1;
                switch (index) {
                    case 1:
                        Intent intent = new Intent();
                        intent.setClass(CityActivity.this, One_EnvironmentActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2 = new Intent();
                        intent2.setClass(CityActivity.this, GoshopingActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent();
                        intent3.setClass(CityActivity.this, ThreeActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(CityActivity.this, EightActivity.class);
                        startActivity(intent4);
                        break;
                }
            }
        });


    }

}