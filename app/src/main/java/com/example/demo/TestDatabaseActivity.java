package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        try {
            ConnectionDatabase connectionDatabase = new ConnectionDatabase();
            connection = connectionDatabase.connectionClass();

            if(connection!=null){
                String query = "Select * from user";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                tx1.setText("sql not null");

                while (rs.next()){
                    tx1.setText(rs.getString(1));
                    tx2.setText(rs.getString(2));
                }
            }else{
                tx1.setText("Check Connection");
                ConnectionResult = "Check Connection";
            }
        } catch (SQLException e) {
            tx1.setText("Error");
        }
    }
}