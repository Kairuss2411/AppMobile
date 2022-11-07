package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ImageView btnforecast, btnstation, btnconstruction, btnuser, btntestdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Lấy thông tin từ đăng nhập ở Main Activity
        SharedPreferences user = getSharedPreferences("user", 0);
        String username = user.getString("username","");
        String password = user.getString("password","");
        String ho = user.getString("ho","");
        String ten = user.getString("ten","");
        String chucvu  = user.getString("chucvu","user");
        String TenVaChucvu = ho+" "+ten+" - "+chucvu;

        TextView txtTenNguoiDung = findViewById(R.id.txtTenNguoiDung);
        txtTenNguoiDung.setText(TenVaChucvu);

        // Nút dự báo
        btnforecast = (ImageView) findViewById(R.id.btnForecast);
        btnforecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forecast = new Intent( HomeActivity.this, ListForecastActivity.class);
                startActivity(forecast);
            }
        });

        // Nếu chức vụ là quản lý hoặc người vận hành thì mới được vào được module Trạm và công trình
        if(chucvu.equals("Manager") || chucvu.equals("Operator")){

            // Hiển thị layout Trạm
            ConstraintLayout lStaion= (ConstraintLayout)this.findViewById(R.id.LlStation);
            lStaion.setVisibility(ConstraintLayout.VISIBLE);

            // Hiển thị layout Công trình
            ConstraintLayout lConstruction= (ConstraintLayout)this.findViewById(R.id.LlConstruction);
            lConstruction.setVisibility(ConstraintLayout.VISIBLE);

            // Nút trạm
            btnstation = (ImageView) findViewById(R.id.btnStation);
            btnstation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent station = new Intent(HomeActivity.this, ListStationActivity.class);
                    startActivity(station);
                }
            });

            // Nút công trình
            btnconstruction = (ImageView) findViewById(R.id.btnConstruction);
            btnconstruction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent construction = new Intent(HomeActivity.this, ListConstructionActivity.class);
                    startActivity(construction);
                }
            });

            // Nếu chức vụ là quản lý thì vào được module người dùng
            if(chucvu.equals("Manager")){
                //Hiển thị layout User
                ConstraintLayout lUser= (ConstraintLayout)this.findViewById(R.id.LlUser);
                lUser.setVisibility(ConstraintLayout.VISIBLE);
                // Nút người dùng
                btnuser = (ImageView) findViewById(R.id.btnUser);
                btnuser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent user = new Intent(HomeActivity.this, ListUserActivity.class);
                        startActivity(user);
                    }
                });

                // Test
                if(username.equals("khoa123")&&password.equals("0913668886")){
                    //Hiển thị layout Test
                    ConstraintLayout lTest= (ConstraintLayout)this.findViewById(R.id.LlTest);
                    lTest.setVisibility(ConstraintLayout.VISIBLE);
                    // Nút test data
                    btntestdata = (ImageView) findViewById(R.id.btnTestD);
                    btntestdata.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent data = new Intent(HomeActivity.this, TestDatabaseActivity.class);
                            startActivity(data);
                        }
                    });
                }
            }
        }
    }
}