package com.example.myapplicationone.api;

import android.util.Log;

import com.example.myapplicationone.BaseActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api extends BaseActivity {
    private static String requestUrl;
    private static HashMap<String,Object> mParams;
    private static OkHttpClient client;
    public static Api api=new Api();

    public Api(){

    }
    public static Api config(String url, HashMap<String,Object> params){
//第一步创建 OkHttpClient
        client = new OkHttpClient.Builder().build();

        requestUrl= ApiConfig.BASE_URl+url;
        mParams=params;

        return api;
    }
    public void postRequest(final TtitCallback callback){

        JSONObject jsonObject=new JSONObject(mParams);
        String jsonStr=jsonObject.toString();
//创建 RequestBody
        RequestBody requestBodyJson =
                RequestBody.create(MediaType.parse("application/json;charset=utf-8"),jsonStr);
//第三步 创建Request
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("contentType","application/json;charset=UTF-8")
                .post(requestBodyJson)
                .build();
//第四步创建call回调对象
        final Call call=client.newCall(request);
//第五部 发起请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("onFailure",e.getMessage());
                callback.onFaliure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  final String result =response.body().string();
                  callback.onSuccess(result);
            }
        });

    }
}
