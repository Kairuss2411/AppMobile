package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateUserActivity extends AppCompatActivity {

    EditText ho, ten, email, sdt, chucvu, taikhoan, matkhau;
    Button btnCapnhat, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        // Lấy id editText
        ho = findViewById(R.id.edtxtHo);
        ten = findViewById(R.id.edtxtTen);
        email = findViewById(R.id.edtxtEmail);
        sdt = findViewById(R.id.edtxtSDT);
        chucvu = findViewById(R.id.edtxtChucvu);
        taikhoan = findViewById(R.id.edtxtTaikhoan);
        matkhau = findViewById(R.id.edtxtMatkhau);

        // Lấy id button
        btnCapnhat = findViewById(R.id.btnUpdate);
        btnHuy = findViewById(R.id.btnCancel);

        // Load thông tin người dùng ra
        loadUser();

        //Nút cập nhật
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                    if (intent.hasExtra(Intent.EXTRA_TEXT)){
                        String id = intent.getStringExtra(Intent.EXTRA_TEXT);
                        String Ho = ho.getText().toString();
                        String Ten = ten.getText().toString();
                        String Email = email.getText().toString();
                        String SDT = sdt.getText().toString();
                        String Chucvu = chucvu.getText().toString();
                        String Taikhoan = taikhoan.getText().toString();
                        String Matkhau = matkhau.getText().toString();

                        ConnectionDatabase con = new ConnectionDatabase();
                        con.UpdateUser(id,Ho, Ten, Email, SDT, Chucvu, Taikhoan, Matkhau);

                        Intent UpdateUser = new Intent(UpdateUserActivity.this, ListUserActivity.class);
                        startActivity(UpdateUser);
                }
            }
        });

        //Nút hủy
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUser();
            }
        });
    }

    //Nạp thông tin người dùng
    public void loadUser(){
        Intent intent = getIntent();
        String id = null;
        if (intent.hasExtra(Intent.EXTRA_TEXT)){
            id = intent.getStringExtra(Intent.EXTRA_TEXT);

            ConnectionDatabase con = new ConnectionDatabase();
            String StringUser = con.getUser(id);
            try {
                JSONObject JUser = new JSONObject(StringUser);
                JSONArray ArrayUser = new JSONArray(JUser.getString("user"));

                if(ArrayUser.length()>0) {
                    for (int i= 0; i<ArrayUser.length();i++) {
                        JSONObject user = ArrayUser.getJSONObject(i);
                        ho.setText(user.getString("ho"));
                        ten.setText(user.getString("ten"));
                        email.setText(user.getString("email"));
                        sdt.setText(user.getString("sdt"));
                        chucvu.setText(user.getString("chucvu"));
                        taikhoan.setText(user.getString("taikhoan"));
                        matkhau.setText(user.getString("matkhau"));
                    }
                }else{
                    Toast.makeText(UpdateUserActivity.this, "Tài khoản của bạn chưa chính xác", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e) {
                Toast.makeText(UpdateUserActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Thực hiện sự kiện trở về
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Nếu là nút trở về
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent(UpdateUserActivity.this, ListUserActivity.class);
            finish();
            startActivity(intent);
        }
        return true;
    }
}