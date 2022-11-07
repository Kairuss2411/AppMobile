package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ListStationActivity extends AppCompatActivity {

    ListView lsvStation;
    ImageView btnBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_station);

        lsvStation = findViewById(R.id.lsvStation);

        ArrayList<Station> arr = new ArrayList<>();

        arr.add(new Station("Trạm Long Xuyên", "10,08989123; 0,4329849234", "Thành phố Long Xuyên, Tỉnh An Giang","Công trình ngăn mặn"));
        arr.add(new Station("Trạm Sa Đéc", "10,08989123; 0,4329849234", "Thành phố Sa Đéc, Tỉnh Đồng Tháp","Công trình ngăn mặn"));
        arr.add(new Station("Trạm Mỹ Tho", "10,08989123; 0,4329849234", "Thành phố Mỹ Tho, Tỉnh Tiền Giang","Công trình ngăn mặn"));

        StationAdapter adapter = new StationAdapter(this, 0, arr);
        lsvStation.setAdapter(adapter);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        btnBar = findViewById(R.id.btnBarStation);

        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
}