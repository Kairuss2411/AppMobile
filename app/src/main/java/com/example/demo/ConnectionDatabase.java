package com.example.demo;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
    Connection con;
    String uname, pass, ip, port, database;

    @SuppressLint("New")
    public Connection connectionClass()
    {
//        ip = "localhost";
        ip = "172.1.2.0";
        database = "AppMobile";
        uname = "khoa123";
        pass = "12345";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            ConnectionURL = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database+";encrypt=fasle;user="+uname+";password="+pass+";instance=SQLEXPRESS;";
            connection = DriverManager.getConnection(ConnectionURL);

        }catch (Exception ex)
        {
           Log.e("Error", ex.getMessage());
        }
        return connection;
    }
}
