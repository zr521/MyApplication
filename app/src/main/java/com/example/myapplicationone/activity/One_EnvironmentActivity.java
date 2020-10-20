package com.example.myapplicationone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationone.R;

public class One_EnvironmentActivity extends AppCompatActivity {
EditText Temp1,Temp2,Humi,Light,Co;
Button Save,Clear,Read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_environment);
        initView();
        show();
    }
    private void  initView(){
        Temp1=(EditText)findViewById(R.id.edTemp1);
        Temp2=(EditText)findViewById(R.id.edTemp2);
        Humi=(EditText)findViewById(R.id.edHumi);
        Light=(EditText)findViewById(R.id.edLight);
        Co=(EditText)findViewById(R.id.edCo);

        Save=(Button)findViewById(R.id.btSave);
        Clear=(Button)findViewById(R.id.btClear);
        Read=(Button)findViewById(R.id.btRead);
    }
  private void show(){
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp1=Temp1.getText().toString();
                String temp2=Temp2.getText().toString();
                String humi=Humi.getText().toString();
                String light=Light.getText().toString();
                String co =Co.getText().toString();

                //实例化一个 sharepreferences对象存储文件名，访问类型：私有
                SharedPreferences mSharedPreferences=getSharedPreferences("zhcs", Context.MODE_PRIVATE);
               //获取编辑器
                SharedPreferences.Editor mEditor=mSharedPreferences.edit();
                mEditor.putString("最低温度",temp1);
                mEditor.putString("最高温度",temp2);
                mEditor.putString("湿度临界值",humi);
                mEditor.putString("光照临界值",light);
                mEditor.putString("CO临界值",co);
                mEditor.commit();//提交修改
                Toast.makeText(One_EnvironmentActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                 }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temp1.setText("");
                Temp2.setText("");
                Humi.setText("");
                Light.setText("");
                Co.setText("");
                Toast.makeText(One_EnvironmentActivity.this,"清空成功",Toast.LENGTH_SHORT).show();
            }
        });
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mSharedPreferences=getSharedPreferences("zhcs",Context.MODE_PRIVATE);
                String temp1=mSharedPreferences.getString("最低温度","");
                String temp2=mSharedPreferences.getString("最高温度","");
                String humi=mSharedPreferences.getString("湿度临界值","");
                String light=mSharedPreferences.getString("光照临界值","");
                String co=mSharedPreferences.getString("CO临界值","");
                //设置编辑框值
                Temp1.setText(temp1);
                Temp2.setText(temp2);
                Humi.setText(humi);
                Light.setText(light);
                Co.setText(co);
                Toast.makeText(One_EnvironmentActivity.this,"读取成功",Toast.LENGTH_SHORT).show();
            }
        });

  }

}
