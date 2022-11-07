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

public class ConstructionAdapter extends ArrayAdapter<Construction> {
    private Context ct;
    private ArrayList<Construction> arr;

    public ConstructionAdapter(@NonNull Context context, int resource, @NonNull List<Construction> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.layout_item_construction, null);
        }
        if (arr.size() > 0) {
            Construction d = arr.get(position);

            TextView txt_ten_cong_trinh = convertView.findViewById(R.id.txt_ten_cong_trinh);
            TextView txt_kich_thuoc = convertView.findViewById(R.id.txt_kich_thuoc);
            TextView txt_cq_quan_ly = convertView.findViewById(R.id.txt_CQ_quan_ly);

            txt_ten_cong_trinh.setText(d.tencongtrinh);
            txt_kich_thuoc.setText(d.kichthuoc);
            txt_cq_quan_ly.setText(d.cqquanly);
        }
        return convertView;
    }
}