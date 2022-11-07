package com.example.demo;

import android.content.Context;
import android.content.res.AssetManager;

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
}
