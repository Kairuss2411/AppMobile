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

public class StationAdapter extends ArrayAdapter<Station> {
    private Context ct;
    private ArrayList<Station> arr;
    public StationAdapter(@NonNull Context context, int resource, @NonNull List<Station> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater i = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.layout_item_station, null);
        }
        if(arr.size()>0){
            Station d = arr.get(position);

            TextView txt_ten_tram = convertView.findViewById(R.id.txt_ten_tram);
            TextView txt_toa_do = convertView.findViewById(R.id.txt_toa_do);
            TextView txt_dia_gioi = convertView.findViewById(R.id.txt_dia_gioi);
            TextView txt_ten_cong_trinh = convertView.findViewById(R.id.txt_ten_cong_trinh);

            txt_ten_tram.setText(d.tentram);
            txt_toa_do.setText(d.toado);
            txt_dia_gioi.setText(d.diagioi);
            txt_ten_cong_trinh.setText(d.tencongtrinh);
        }
        return convertView;
    }
}
