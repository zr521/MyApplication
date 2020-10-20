package com.example.myapplicationone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplicationone.Six_Goshoping.GoshopingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    private SimpleAdapter  gridAdaper;
   private String []No={"201508281043","201508281044","201508281045"};
   private ListView  lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lv1=findViewById(R.id.three_LV);
        List<Map<String,  Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < No.length; i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("No",No[i]);
            listitem.add(map);
        }
        gridAdaper=new SimpleAdapter(
                Main3Activity.this,
                listitem,
                R.layout.view,
                new String[]{"No"},
                new int[]{ R.id.TV1});
        lv1.setAdapter(gridAdaper);

    }
}
