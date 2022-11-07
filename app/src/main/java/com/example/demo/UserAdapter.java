package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context ct;
    private ArrayList<User> arr;
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater i = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.layout_item_user, null);
        }
        if(arr.size()>0){
            User d = arr.get(position);

            TextView txt_ten_nguoi_dung = convertView.findViewById(R.id.txt_ten_nguoi_dung);
            TextView txt_ho = convertView.findViewById(R.id.txt_ho);
            TextView txt_email = convertView.findViewById(R.id.txt_email);
            TextView txt_sdt = convertView.findViewById(R.id.txt_sdt);
            TextView txt_chuc_vu = convertView.findViewById(R.id.txt_chuc_vu);
            TextView txt_user_id = convertView.findViewById(R.id.txt_user_id);
            TextView txt_tai_khoan = convertView.findViewById(R.id.txt_tai_khoan);

            txt_ten_nguoi_dung.setText(d.ten);
            txt_ho.setText(d.ho);
            txt_email.setText(d.email);
            txt_sdt.setText(String.valueOf(d.sdt));
            txt_chuc_vu.setText(String.valueOf(d.chucvu));
            txt_user_id.setText(String.valueOf(d.userID));
            txt_tai_khoan.setText(String.valueOf(d.taikhoan));
        }
        return convertView;
    }
}
