package com.example.myapplicationone.CityMain;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplicationone.BaseActivity;
import com.example.myapplicationone.City.CityActivity;
import com.example.myapplicationone.MainActivity;
import com.example.myapplicationone.R;
import com.example.myapplicationone.api.Api;
import com.example.myapplicationone.api.ApiConfig;
import com.example.myapplicationone.api.TtitCallback;
import com.example.myapplicationone.util.StringUtils;

import java.util.HashMap;

public class FirstMianActivity extends BaseActivity {
private Button mFbt_Login,mFbt_register,mFBtback;
private EditText mFUser,mFPasswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_mian);
        mFbt_Login=findViewById(R.id.FmBt_Login);
        mFbt_register=findViewById(R.id.FmBt_Register);
        mFUser=findViewById(R.id.Fm_User);
        mFPasswd=findViewById(R.id.Fm_Passwd);
        mFBtback=findViewById(R.id.FmBtBack);

        show();
    }
   private void show(){
      Click click=new Click();
       mFbt_Login.setOnClickListener(click);
       mFbt_register.setOnClickListener(click);
       mFUser.setOnClickListener(click);
       mFPasswd.setOnClickListener(click);

       mFBtback.setOnClickListener(click);
    }
    public class  Click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.FmBt_Login:
                    String user=mFUser.getText().toString().trim();
                    String passwd=mFPasswd.getText().toString().trim();
                    login(user,passwd);
                   // loginDialog();//显示对话框
                    break;
                case R.id.FmBt_Register:
                    navigateTo(FirstMainZcActivity.class);
                    //show1();
                    break;
                case R.id.FmBtBack:
                   navigateTo(MainActivity.class);
                    break;

            }
        }


}

    private void loginDialog() {
        AlertDialog alertDialog=new AlertDialog.Builder(FirstMianActivity.this)
                .setTitle("智  慧  城  市")
                .setMessage("是  否  登  录")
                .setIcon(R.drawable.city)//设置图标
                .setNegativeButton("取 消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast("登陆失败");
                        navigateTo(FirstMianActivity.class);
                    }
                })
                .setPositiveButton("确 定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast("登录成功");
                        navigateTo( CityActivity.class);
                        //将数据存入Intent对象
                        Intent intent =new Intent();
                            intent.putExtra("user",mFUser.getText().toString().trim());
                            intent.putExtra("passwd",mFPasswd.getText().toString().trim());
                    }
                }).create();
        alertDialog.show();
    }

    private void login(String user, String passwd) {
        if(StringUtils.isEmpty(user)){
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(passwd)){
            showToast("请输入密码");
            return;
        }
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("users",user);
        params.put("password",passwd);
        Api.config(ApiConfig.LOGIN,params).postRequest(new TtitCallback() {
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

            }
        });
    }

    private void show1(){
        Dialog bottomDialog = new Dialog(FirstMianActivity.this,R.style.BottomDialog);
        View contenView = LayoutInflater.from(FirstMianActivity.this).inflate(R.layout.firstmainzu,null);

        bottomDialog.setContentView(contenView);

        ViewGroup.LayoutParams layoutParams = contenView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;

//        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) contenView.getLayoutParams();
//        params.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 16f);
//        params.bottomMargin = DensityUtil.dp2px(this, 8f);

        contenView.setLayoutParams( layoutParams);

        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);//弹窗位置
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);//进出动画
        //bottomDialog.setCancelable(true);// 不可以用“返回键”取消
        bottomDialog.show();

        bottomDialog.findViewById(R.id.tv_take_zhuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateTo(FirstMainZcActivity.class);
            }
        });
        bottomDialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               navigateTo(FirstMianActivity.class);
            }
        });
        bottomDialog.show();
    }
}
