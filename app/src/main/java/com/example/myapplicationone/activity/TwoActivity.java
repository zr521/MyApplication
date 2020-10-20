package com.example.myapplicationone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplicationone.R;


public class TwoActivity extends AppCompatActivity {
    private Spinner sp;
    private String [] way={"支付宝","微信","龙支付"};
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        sp= findViewById(R.id.spinner);
        //sp.setPrompt("请选择支付方式");
        arrayAdapter=new ArrayAdapter<String>(TwoActivity.this,android.R.layout.simple_spinner_dropdown_item,way);
        sp.setAdapter(arrayAdapter);







//        mbt=findViewById(R.id.twobutton);
//        mbt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String id="201508260645";
//                String name="李四";
//                String phone="13666666666";
//                String address="xx省xxshixx县";
//                String money="168";
//                int state=0;
//                ContentValues cv=new ContentValues();
//                cv.put("id",id);
//                cv.put("name",name);
//                cv.put("phone",phone);
//                cv.put("address",address);
//                cv.put("money",money);
//                cv.put("state",state);
//                myDb.insert("info","name",cv);
//                myDb.close();
//            }
//        });


    }
//    public  static class MyDb extends SQLiteOpenHelper{
//
//            private  static  int VERSION=1;
//            private  static String DB_NAME;
//            private static  MyDb busDB;
//
//            public MyDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//                super(context, name, factory, version);
//            }
//
//            public MyDb(Context context) {
//                super(context,DB_NAME,null,VERSION);
//            }
//
//        public MyDb() {
//            super();
//        }
//
//        public static MyDb getinstance(Context context){
//                if(busDB==null){
//                    busDB=new MyDb(context);
//                    return busDB;
//                }else{
//                    return busDB;
//                }
//            }
//            @Override
//            public void onCreate(SQLiteDatabase db) {
//                db.execSQL("CREATE TABLE info(_id INTEGER PRIMARY KEY AUTOINCREMENT,ID TEXT,name TEXT,phone TEXT,address TEXT,monet TEXT,state INTEGER)" );
//
//            }
//
//            @Override
//            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//                if(oldVersion==1&&newVersion==2){
//                    db.execSQL("ALTER TABLE register ADD phone TEXT");
//                }
//            }
//
//                public Cursor select(String where,String orderBy){
//                StringBuilder buf =new StringBuilder("SELECT * FROM "+"info");
//                if(where!=null){
//                    buf.append("WHERE");
//                    buf.append(where);
//                }
//                if(orderBy!=null){
//                    buf.append("ORDER BY");
//                    buf.append(orderBy);
//                }
//                    Log.e("buf",buf.toString());
//                        return (getWritableDatabase().rawQuery(buf.toString(),null));
//            }
//
//        }
//        public <getReadable> void insert(String id, String name, String phone, String address, String money, int state){
//        ContentValues cv =new ContentValues();
//            cv.put("id",id);
//            cv.put("name",name);
//            cv.put("phone",phone);
//            cv.put("address",address);
//            cv.put("money",money);
//            cv.put("state",state);
//            getReadableDatabase().insert("info","name",cv);
//        }
//
//        private SQLiteDatabase getReadableDatabase() {
//            return null;
//        }
//        public String getID(Cursor c){
//        return c.getString(1);
//        }
//        public String getName(Cursor c){
//            return c.getString(2);
//        }
//        public String getPhone(Cursor c){
//            return c.getString(3);
//        }
//        public String getAddress(Cursor c){
//            return c.getString(4);
//        }
//        public String getMoney(Cursor c){
//            return c.getString(5);
//        }
//        public String getState(Cursor c){
//            int state=c.getInt(6);
//            if(state==0){
//                return "未出货";
//            }
//            return "已出货";
//    }
}
