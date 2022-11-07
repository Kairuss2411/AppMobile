package com.example.demo;

public class User {
    public String ho, ten, sdt, email, chucvu, taikhoan, matkhau;
    public int userID;

    public User(String ho, String ten, String sdt, String email, String chucvu, String taikhoan, int userID, String matkhau) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.chucvu = chucvu;
        this.taikhoan = taikhoan;
        this.userID = userID;
        this.matkhau = matkhau;
    }
}
