package com.example.myapplicationone.CityMain;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationone.BaseActivity;
import com.example.myapplicationone.R;
import com.example.myapplicationone.api.Api;
import com.example.myapplicationone.api.ApiConfig;
import com.example.myapplicationone.api.TtitCallback;
import com.example.myapplicationone.util.StringUtils;

import java.util.HashMap;


public class FirstMainZcActivity extends BaseActivity {

    private Dialog dialog;
    private Button fmzcbt1;
    private EditText mFz_user,mFz_pwd,mFz_pwda;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_main_zc);
        fmzcbt1=findViewById(R.id.FmZcBt1);
        mFz_user=findViewById(R.id.FmZc_User);
        mFz_pwd=findViewById(R.id.FmZc_Passwd);
        mFz_pwda=findViewById(R.id.FmZc_Passwdagain);
        fmzcbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=mFz_user.getText().toString().trim();
                String pwd=mFz_pwd.getText().toString().trim();
                String pwda=mFz_pwda.getText().toString().trim();
                register(user,pwd,pwda);
            }
        });

      // show1();
    }
    private void register(String user, String passwd,String passwda) {
        if(StringUtils.isEmpty(user)){
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(passwd)){
            showToast("请输入密码");
            return;
        }
        if(StringUtils.isEmpty(passwda)){
            showToast("请确认密码");
            return;
        }
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("users",user);
        params.put("password",passwd);
        params.put("passwordagain",passwda);
        Api.config(ApiConfig.REGISTER,params).postRequest(new TtitCallback() {
            @Override
            public void onSuccess(final  String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFaliure(Exception e) {
                Log.e("onFaliure",e.toString());

            }
        });
    }

    private void show1(){
        Dialog bottomDialog=new Dialog(FirstMainZcActivity.this,R.style.BottomDialog);//1、使用Dialog、设置style
        View contenView = LayoutInflater.from(FirstMainZcActivity.this).inflate(R.layout.firstmainzu,null);//2、设置布局
        bottomDialog.setContentView(contenView);

        ViewGroup.LayoutParams layoutParams = contenView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contenView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);//设置对话框所在Window的gravity属性为bottom
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);//进出动画
        bottomDialog.show();
    }


}

