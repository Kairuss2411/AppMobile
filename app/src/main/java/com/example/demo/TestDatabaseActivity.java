package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;

public class TestDatabaseActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult="";
    Button btnTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetTextFromSQL();
            }
        });
    }

    public void GetTextFromSQL()
    {
        TextView tx1 = (TextView) findViewById(R.id.txtTestData);
        TextView tx2 = (TextView) findViewById(R.id.txtTestData1);
        tx1.setText("abc");
    }
}