package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListForecastActivity extends AppCompatActivity {
    ListView lsvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_forecast);

//        // Nút thêm
        TextView btnAdd;
        btnAdd = (TextView) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListForecastActivity.this, AddConstructionActivity.class);
                startActivity(intent);
            }
        });

        lsvInfo= findViewById(R.id.lsvInfo);

        ArrayList<Info> arr = new ArrayList<>();

        arr.add(new Info("An Giang","2/11/2022","Nguyen Van A",1,2,3,4));
        arr.add(new Info("Vinh Long","2/11/2022","Nguyen Van B",1,2,3,4));
        arr.add(new Info("Tra Vinh","2/11/2022","Nguyen Van C",1,2,3,4));
        arr.add(new Info("Bac Lieu","2/11/2022","Nguyen Van D",1,2,3,4));
        arr.add(new Info("Can tho","2/11/2022","Nguyen Van E",1,2,3,4));

        InfoAdapter adapter = new InfoAdapter(this, 0, arr);
        lsvInfo.setAdapter(adapter);
    }
}