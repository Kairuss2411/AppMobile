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

public class InfoAdapter extends ArrayAdapter<Info> {
    private Context ct;
    private ArrayList<Info> arr;
    public InfoAdapter(@NonNull Context context, int resource, @NonNull List<Info> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater i = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.layout_item_list, null);
        }
        if(arr.size()>0){
            Info d = arr.get(position);

            TextView txt_vi_tri = convertView.findViewById(R.id.txt_vi_tri);
            TextView txt_time = convertView.findViewById(R.id.txt_time);
            TextView txt_user = convertView.findViewById(R.id.txt_user);
            TextView txt_amount_water = convertView.findViewById(R.id.txt_amount_water);
            TextView txt_do_PH = convertView.findViewById(R.id.txt_do_PH);
            TextView txt_muc_nuoc = convertView.findViewById(R.id.txt_muc_nuoc);
            TextView txt_do_man = convertView.findViewById(R.id.txt_do_man);

            txt_vi_tri.setText(d.vitri);
            txt_time.setText(d.thoigian);
            txt_user.setText(d.tennguoidung);
            txt_amount_water.setText(String.valueOf(d.luongnuoc));
            txt_do_PH.setText(String.valueOf(d.doPh));
            txt_muc_nuoc.setText(String.valueOf(d.mucnuoc));
            txt_do_man.setText(String.valueOf(d.dophen));
        }
        return convertView;
    }
}
