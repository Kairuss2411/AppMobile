package com.example.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap;
    TextInputLayout edTxtuser;
    TextInputLayout edTxtpassword;
    // Dữ liệu lấy từ JSON
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set lưu trữ giá trị người dùng
        SharedPreferences user = getSharedPreferences("user", 0);
        SharedPreferences.Editor EUser = user.edit();

        EUser.clear().commit(); // Xóa data SharedPreferences

        edTxtuser = findViewById(R.id.edTxt_user); // Lấy tên đăng nhập
        edTxtpassword  = findViewById(R.id.edTxt_password); // Lấy mật khẩu


        edTxtuser.getEditText().setText("");// reset user
        edTxtpassword.getEditText().setText(""); // reset password

        // Nút đăng nhập
        btnDangNhap = (Button) findViewById(R.id.btnDangnhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu danh sách người dùng
                ConnectFileJSON data =  new ConnectFileJSON(MainActivity.this);
                try {
                    JSONObject listUser = new JSONObject(data.readUserData());
                    JSONArray jsonArray = new JSONArray(listUser.getString("user"));
                    TextView txt = findViewById(R.id.txtDontHaveAnAccount);
                    for (int i= 0; i<jsonArray.length();i++){
                        JSONObject user = jsonArray.getJSONObject(i);
                        // Kiểm tra tài khoản, mật khẩu
                        if((edTxtuser.getEditText().getText().toString().equals(user.getString("taikhoan")) &&
                                (edTxtpassword.getEditText().getText().toString().equals(user.getString("matkhau")))))
                        {
                            // Chạy tới class trang chủ
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);

                            // Lưu thông tin user ở Shared Preference
                            EUser.putString("username", user.getString("taikhoan"));
                            EUser.putString("password", user.getString("matkhau"));
                            EUser.putString("ho", user.getString("ho"));
                            EUser.putString("ten", user.getString("ten"));
                            EUser.putString("chucvu", user.getString("chucvu"));
                            EUser.commit();
                        }
                    }
                } catch (JSONException e) {
                    Log.d("Lỗi", e.toString());
                }
            }
        });


        //Tạo tài khoản
        TextView txtRegister = (TextView) findViewById(R.id.txtDontHaveAnAccount);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RegisterActvity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(RegisterActvity);
            }
        });
    }
}