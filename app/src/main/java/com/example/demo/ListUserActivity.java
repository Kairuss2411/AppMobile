package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {

    ListView lsvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        lsvUser= findViewById(R.id.lsvUser);

        ArrayList<User> arr = new ArrayList<>();

        ConnectFileJSON data = new ConnectFileJSON(ListUserActivity.this);
        ConnectionDatabase con = new ConnectionDatabase();

//        try {
//            JSONObject listUser = new JSONObject(data.readUserData());
//            JSONArray jsonArray = new JSONArray(listUser.getString("user"));
//            for (int i= 0; i<jsonArray.length();i++){
//                JSONObject user = jsonArray.getJSONObject(i);
//
//                int userID = user.getInt("id");
//                String ho = user.getString("ho");
//                String ten = user.getString("ten");
//                String sdt = user.getString("sdt");
//                String email = user.getString("email");
//                String chucvu = user.getString("chucvu");
//                String taikhoan = user.getString("taikhoan");
//                String matkhau = user.getString("matkhau");
//
//                arr.add(new User(ho,ten,sdt,email,chucvu,taikhoan,userID, matkhau));
//
//            }
//        } catch (JSONException e ){
//            Log.d("Lỗi", e.toString());
//        }

        // SQL server
        try {
            JSONObject listUser = new JSONObject(con.getListUser());
            JSONArray jsonArray = new JSONArray(listUser.getString("user"));
            for (int i= 0; i<jsonArray.length();i++){
                JSONObject user = jsonArray.getJSONObject(i);

                int userID = user.getInt("userID");
                String ho = user.getString("ho");
                String ten = user.getString("ten");
                String sdt = user.getString("sdt");
                String email = user.getString("email");
                String chucvu = user.getString("chucvu");
                String taikhoan = user.getString("taikhoan");
                String matkhau = user.getString("matkhau");

                arr.add(new User(ho,ten,sdt,email,chucvu,taikhoan,userID, matkhau));

            }
        } catch (JSONException e ){
            Log.d("Lỗi", e.toString());
        }

        UserAdapter adapter = new UserAdapter(this, 0, arr);
        lsvUser.setAdapter(adapter);
    }

    // Thực hiện sự kiện trở về
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Nếu là nút trở về
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(ListUserActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
        }
        return true;
    }
}