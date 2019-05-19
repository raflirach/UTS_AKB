package com.example.uts_akb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        EditText nim,nama,kelas,telepon,instagram,email;

        nim = view.findViewById(R.id.nim);
        nama = view.findViewById(R.id.nama);
        kelas = view.findViewById(R.id.kelas);
        telepon = view.findViewById(R.id.telepon);
        email = view.findViewById(R.id.email);
        instagram = view.findViewById(R.id.instagram);

        nim.setText(models.get(position).getNim());
        nama.setText(models.get(position).getNama());
        kelas.setText(models.get(position).getKelas());
        telepon.setText(models.get(position).getTelepon());
        email.setText(models.get(position).getEmail());
        instagram.setText(models.get(position).getInstagram());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
