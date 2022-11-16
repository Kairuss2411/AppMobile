package com.example.demo;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConnectFileJSON {

    private Context mContext;

    public ConnectFileJSON(Context context) {
        this.mContext = context;
    }

    // Đọc dữ liệu data User
    public String readUserData() {
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("user.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ liệu thông tin dự báo
    public String readForecastData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("forecast.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ liệu thông tin trạm
    public String readStationData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("station.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ thông tin công trình
    public String readConstructionData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("construction.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ liệu thông tin tỉnh
    public String readProvinceData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("province.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ liệu thông tin huyện
    public String readDistrictData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("district.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Đọc dữ liệu thông tin phường xã
    public String readWardData(){
        String result = null;
        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open("ward.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = reader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }
            is.close();
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Setup JSONObject Of user
    public JSONObject makeJsonUser (String title, String desc) {

        JSONObject obj = new JSONObject() ;

        try {
            obj.put("title", title);
            obj.put("desc", desc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Setup JSONObject Of forecast
    public JSONObject makeJsonForecast (int id, int userID, int stationID, String thoigian, int luongmua, int mucnuoc, int doman, int doph) {

        JSONObject obj = new JSONObject() ;

        try {
            obj.put("id", id);
            obj.put("userID", userID);
            obj.put("stationID", stationID);
            obj.put("thoigian", thoigian);
            obj.put("luongmua", luongmua);
            obj.put("mucnuoc", mucnuoc);
            obj.put("doman", doman);
            obj.put("doph", doph);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Đẩy dữ liệu thông tin dự báo về lại JSON

}
