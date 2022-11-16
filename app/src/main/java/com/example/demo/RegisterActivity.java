package com.example.demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button btnDangky;
    Button btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Kết nối database
        ConnectionDatabase con = new ConnectionDatabase();

        // Nút đăng ký
        btnDangky = findViewById(R.id.btnRegister);
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ho, ten, email, sdt, chucvu, taikhoan, matkhau;
                ho = findViewById(R.id.edtxtHo);
                ten = findViewById(R.id.edtxtTen);
                email = findViewById(R.id.edtxtEmail);
                sdt = findViewById(R.id.edtxtSDT);
                chucvu = findViewById(R.id.edtxtChucvu);
                taikhoan = findViewById(R.id.edtxtTaikhoan);
                matkhau = findViewById(R.id.edtxtMatkhau);

                String result = con.addUser(ho.getText().toString(),ten.getText().toString(),
                        email.getText().toString(),sdt.getText().toString(),
                        chucvu.getText().toString(),taikhoan.getText().toString(),
                        matkhau.getText().toString());

                ho.setText("");
                ten.setText("");
                email.setText("");
                sdt.setText("");
                chucvu.setText("");
                taikhoan.setText("");
                matkhau.setText("");

                AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                alertDialog.setTitle("Thông báo");
                alertDialog.setMessage(result);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Đăng ký", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent mainactivity = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(mainactivity);
                    }
                });
                alertDialog.show();
            }
        });

        // Nút hủy
        btnHuy = findViewById(R.id.btnCancel);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainactivity = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(mainactivity);
            }
        });
    }
}