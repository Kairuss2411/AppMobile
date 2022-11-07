package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListConstructionActivity extends AppCompatActivity {

    ListView lsvConstruction;
    ImageView btnBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_construction);

        lsvConstruction= findViewById(R.id.lsvConstruction);

        ArrayList<Construction> arr = new ArrayList<>();

        arr.add(new Construction("Công trình xử nước","100x100","Cơ quan quản lý A"));
        arr.add(new Construction("Công trình ngăn mặn","200x200","Cơ quan quản lý B"));
        arr.add(new Construction("Công trình ngăn lũ","300x300","Cơ quan quản lý C"));

        ConstructionAdapter adapter = new ConstructionAdapter(this, 0, arr);
        lsvConstruction.setAdapter(adapter);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayoutConstruction);
        btnBar = findViewById(R.id.btnBarConstruction);

        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}