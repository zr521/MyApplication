package com.example.myapplicationone.http;

import android.app.DownloadManager;
import android.util.Log;
import android.view.textclassifier.ConversationActions;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {
/*
* 异步get请求
*/
    private void get(){
        //第一步创建 OkHttpClient
        OkHttpClient client= new OkHttpClient.Builder().build();
        //第二部创建 Request
        Request request =new Request.Builder()
                .url("")
                .get()
                .build();
        //第三步 构建Call对象
        Call call=client.newCall(request);
        //第四步：异步get请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("ttit",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到子线程
                String result=response.body().string();
                Log.e("ttit",result);
                //控件变量.setText(result);
            }
        });
    }

    /*
    * 异步post请求
    * */
    private void post(){
        //第一步创建 OkHttpClient
        OkHttpClient client= new OkHttpClient.Builder().build();
        //创建 RequestBody （Form表达）
        RequestBody body=new FormBody.Builder()
                .add("moblie","")
                .add("","")
                .build();
        Map m = new HashMap();
        m.put("","");
        JSONObject jsonObject=new JSONObject(m);
        String jsonStr = jsonObject.toString();
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonStr);
        //第三步 创建Request
        Request request = new Request.Builder()
              .url("")
              .addHeader("","")
              .post(requestBodyJson)
              .build();
        //第四步创建call回调对象
        final Call call=client.newCall(request);
        //第五部 发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("onFailure",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    String result =response.body().string();
                //控件变量.setText(result);
            }
        });
    }
}
