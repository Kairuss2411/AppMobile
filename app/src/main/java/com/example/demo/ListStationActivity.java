package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        ConnectFileJSON data = new ConnectFileJSON(ListStationActivity.this);
        try {
            JSONObject listStation = new JSONObject(data.readStationData());
            JSONArray stationArr = new JSONArray(listStation.getString("station"));

            JSONObject listWard = new JSONObject(data.readWardData());
            JSONArray wardArr = new JSONArray(listWard.getString("ward"));

            JSONObject listConstruction = new JSONObject(data.readConstructionData());
            JSONArray constructionArr = new JSONArray(listConstruction.getString("construction"));

            for(int i = 0; i<stationArr.length();i++){
                JSONObject station = stationArr.getJSONObject(i);
                String tentram = station.getString("tentram");
                String toado = station.getDouble("toadoX")+";"+station.getDouble("toadoY");

                String diagioi = null;
                String tencongtrinh = null;
                for(int j = 0; j<wardArr.length();j++) {
                    JSONObject ward = wardArr.getJSONObject(i);
                    if(station.getInt("wardID") == ward.getInt("id")){
                        diagioi = ward.getString("path_with_type");
                    }
                }

                for(int j = 0; j<constructionArr.length();j++){
                    JSONObject cons = constructionArr.getJSONObject(i);
                    if(station.getInt("wardID") == cons.getInt("id")){
                        tencongtrinh = cons.getString("tencongtrinh");
                    }
                }
                arr.add(new Station(tentram, toado, diagioi, tencongtrinh));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StationAdapter adapter = new StationAdapter(this, 0, arr);
        lsvStation.setAdapter(adapter);



        // Nút hiển thị bar menu
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