package com.example.demo;



import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.View;

import com.google.android.material.internal.ContextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConnectFileJSON {
    public static String AssetJSONFile(String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();
        return new String(formArray);
    }

    public void loadJSON (){
        ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
        Context context = null;
        try {
            String jsonLocation = AssetJSONFile("data.json", context);
            JSONObject formArray = (new JSONObject()).getJSONObject("data");
            String data = formArray.getString("data");
            String url = formArray.getString("url");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
