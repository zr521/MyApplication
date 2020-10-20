package com.example.myapplicationone.Six_Goshoping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.example.myapplicationone.R;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context){
        this.mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHoller{

        public TextView mtvGSNo, mtvGSmoney, mtvGSState, mtvGSTime, mtvGSOperate;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoller v;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.gsitems,null);
            v = new ViewHoller();
            v.mtvGSNo = convertView.findViewById(R.id.GSNO);
            v.mtvGSmoney = convertView.findViewById(R.id.GSMoney);
            v.mtvGSState = convertView.findViewById(R.id.GSState);
            v.mtvGSTime = convertView.findViewById(R.id.GSTime);
            v.mtvGSOperate = convertView.findViewById(R.id.GSOperate);
            convertView.setTag(v);
        }else{
            v=(ViewHoller)convertView.getTag();
        }
        v.mtvGSNo.setText("201508281043");
        v.mtvGSmoney.setText("128");
        v.mtvGSState.setText("已发货");
        v.mtvGSTime.setText("2015-08028 10:39");
        v.mtvGSOperate.setText("");

        return convertView;
    }
}
