package com.example.myapplicationone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationone.City.CityActivity;
import com.example.myapplicationone.CityMain.FirstMianActivity;
import com.example.myapplicationone.Six_Goshoping.GoshopingActivity;

public class MainActivity extends AppCompatActivity {
    private Button  mainb2,mainb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainb2 = findViewById(R.id.mainButton2);
        mainb5 = findViewById(R.id.mainButton5);
        show();
    }

    private void show() {
        Click click = new Click();
        mainb2.setOnClickListener(click);
        mainb5.setOnClickListener(click);
    }

    public class Click implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.mainButton2:
                    intent = new Intent(MainActivity.this, Main3Activity.class);
                    break;

                case R.id.mainButton5:
                    intent= new Intent(MainActivity.this, FirstMianActivity.class);
                    break;
            }
            startActivity(intent);
        }

    }
}


