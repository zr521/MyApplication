package com.example.myapplicationone.Six_Goshoping;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Spinner;
        import android.widget.Toast;

        import androidx.annotation.Nullable;
        import com.example.myapplicationone.R;
        import com.example.myapplicationone.activity.TwoActivity;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class GoshopingActivity extends Activity {
    private ListView lv1;
    private SimpleAdapter gridAdaper;
    private String []GSNo={"201508281043","201508281044","201508281045"};
    private String []GSMoney={"113","89","78"};
    private String []GSStata={"已发货","已发货","已发货"};
    private String []GSTime={"2015-08028 10:39","2015-08029 10:00","2015-08030 8:30"};
    private String []GSOperate={"无","无","无"};

    private Spinner startSpinner;
    private Spinner endSpinner;
    ArrayAdapter<String>  startAdapter;
    ArrayAdapter<String> endAdapter;

    private String [] start={
            "2015-0801-10.30","2015-0802-10.30","2015-0803-10.30","2015-0804-10.30","2015-0805-10.30",
            "2015-0806-10.30","2015-0807-10.30","2015-0808-10.30","2015-0809-10.30","2015-0810-10.30"};
    private String [] end={
            "2015-0801-10.30","2015-0802-10.30","2015-0803-10.30","2015-0804-10.30","2015-0805-10.30",
            "2015-0806-10.30","2015-0807-10.30","2015-0808-10.30","2015-0809-10.30","2015-0810-10.30"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goshoping);

        lv1=findViewById(R.id.GSlistView1);
        List<Map<String,  Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < GSNo.length; i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("No",GSNo[i]);
            map.put("Money",GSMoney[i]);
            map.put("State",GSStata[i]);
            map.put("Time",GSTime[i]);
            map.put("Operate",GSOperate[i]);
            listitem.add(map);
        }
        gridAdaper=new SimpleAdapter(
                GoshopingActivity.this,
                listitem,
                R.layout.gsitems,
                new String[]{"No","Money","State","Time","Operate"},
                new int[]{ R.id.GSNO,R.id.GSMoney,R.id.GSState,R.id.GSTime,R.id.GSOperate});
        lv1.setAdapter(gridAdaper);
   //   lv1.setAdapter(new MyAdapter(GoshopingActivity.this));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GoshopingActivity.this, "订单"+position, Toast.LENGTH_SHORT).show();
                int index=position+1;// id是从0开始的，所以需要+1
                switch (index){
                    case 1:
                        Intent intent1=new Intent(GoshopingActivity.this, TwoActivity.class);
                        startActivity(intent1);
                }
            }
        });
        setSpinner();
    }

    private void setSpinner(){
        startSpinner = (Spinner)findViewById(R.id.GS_text_Start);
        endSpinner= (Spinner)findViewById(R.id.GS_text_End);

        startAdapter=new ArrayAdapter<String>(GoshopingActivity.this,android.R.layout.simple_spinner_dropdown_item,start);
        startSpinner.setAdapter(startAdapter);
        startSpinner.setSelection(1,true);

        endAdapter=new ArrayAdapter<String>(GoshopingActivity.this,android.R.layout.simple_spinner_dropdown_item,end);
        endSpinner.setAdapter(endAdapter);
        endSpinner.setSelection(1,true);



    }
}
