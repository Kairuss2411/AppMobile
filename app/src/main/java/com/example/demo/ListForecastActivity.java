package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListForecastActivity extends AppCompatActivity {
    ListView lsvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_forecast);

        // Nút thêm
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

        ConnectFileJSON data = new ConnectFileJSON(ListForecastActivity.this);

        try {
            JSONObject listForecast = new JSONObject(data.readForecastData());
            JSONArray jsonArray = new JSONArray(listForecast.getString("forecast"));

            JSONObject listUser = new JSONObject(data.readUserData());
            JSONArray jsonArrayU = new JSONArray(listUser.getString("user"));

            JSONObject listStation = new JSONObject(data.readStationData());
            JSONArray jsonArrayS = new JSONArray(listStation.getString("station"));

            for (int i = 0; i<jsonArray.length();i++){

                JSONObject forecast = jsonArray.getJSONObject(i);
                //info
                int stationID = forecast.getInt("stationID");
                int userID = forecast.getInt("userID");
                String thoigian = forecast.getString("thoigian");
                int luongmua = forecast.getInt("luongmua");
                int doph = forecast.getInt("doph");
                int mucnuoc = forecast.getInt("mucnuoc");
                int doman = forecast.getInt("doman");
                String tennguoidung = null;
                String vitri = null;

                //user
                for (int u= 0; u<jsonArrayU.length();u++){
                    JSONObject user = jsonArrayU.getJSONObject(u);
                    int id = user.getInt("id");
                    if(id == stationID){
                        tennguoidung = user.getString("ho") +" "+ user.getString("ten");
                    }
                }

                //station
                for (int s= 0; s<jsonArrayS.length();s++){
                    JSONObject station = jsonArrayS.getJSONObject(s);
                    int id = station.getInt("id");
                    if(id == userID){
                        vitri = station.getString("tentram");
                    }
                }
                arr.add(new Info(vitri,thoigian,tennguoidung,luongmua,doph, mucnuoc, doman));
            }
        } catch (JSONException e ){
            Log.d("Lỗi",e.toString());
        }

        InfoAdapter adapter = new InfoAdapter(this, 0, arr);
        lsvInfo.setAdapter(adapter);
    }
}