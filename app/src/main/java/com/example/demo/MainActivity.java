package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button btnDangNhap;
    TextInputLayout edTxtuser;
    TextInputLayout edTxtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences user = getSharedPreferences("user", 0);
        SharedPreferences.Editor EUser = user.edit();

        btnDangNhap = (Button) findViewById(R.id.btnDangnhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edTxtuser = findViewById(R.id.edTxt_user); // Lấy tên đăng nhập
                edTxtpassword  = findViewById(R.id.edTxt_password); // Lấy mật khẩu

                // Xác thực đăng nhập
                // Nếu tài khoản là admin thì được phép đăng nhập
                if(Objects.equals(edTxtuser.getEditText().getText().toString(),"admin") && Objects.equals(edTxtpassword.getEditText().getText().toString(),"admin123")){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);

                    // Lưu thông tin xác thực vào Session để phân quyền
                    EUser.putString("username", "admin");
                    EUser.putString("password", "admin123");
                    EUser.putString("ho","");
                    EUser.putString("ten","");
                    EUser.putString("chucvu", "Manager");
                    EUser.commit();
                } else
                {// Ngược lại sẽ xác thực theo danh sách người dùng (Bảng user trên dữ liệu)
                    ListUserActivity LUser = new ListUserActivity();

                    for(User user: LUser.ListUser()){
                        if (edTxtuser.getEditText().getText().toString().equals(user.taikhoan) && edTxtpassword.getEditText().getText().toString().equals(user.matkhau)){
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);

                            // Lưu thông tin xác thực vào Session để phân quyền
                            EUser.putString("username", user.taikhoan);
                            EUser.putString("password", user.matkhau);
                            EUser.putString("ho",user.ho);
                            EUser.putString("ten",user.ten);
                            EUser.putString("chucvu", user.chucvu);
                            EUser.commit();
                        }
                    }
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