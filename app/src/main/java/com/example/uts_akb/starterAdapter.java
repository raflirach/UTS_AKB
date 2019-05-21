//  Tanggal Pengerjaan : 21 Mei 2019
//  Nim                : 10116132
//  Nama               : Rafli Rachmawandi
//  Kelas              : IF-3

package com.example.uts_akb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class starterAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public starterAdapter(Context context) {
        this.context = context;
    }

    public int[] starterImage = {
            R.drawable.ic_profil,
            R.drawable.ic_contact,
            R.drawable.ic_friend
    };

    public String[] starterHeader = {
            "PROFIL",
            "KONTAK",
            "DAFTAR TEMAN"
    };

    public String[] starterDesc = {
            "Menampilkan informasi tentang pengguna berupa Foto diri, nim, nama dan deskripsi diri",
            "Menampilkan informasi tentang kontak pengguna berupa social media pribadi pengguna",
            "Menampilkan informasi list teman dengan list dan ditampilkan pada viewPager dengan " +
                    "CardView. Data teman dapat ditambah, dimodifikasi dan dihapus"
    };

    @Override
    public int getCount() {
        return starterHeader.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.starter_layout,container,false);

        ImageView slidePicture = view.findViewById(R.id.starter_picture);
        TextView slideHeader = view.findViewById(R.id.starter_header);
        TextView slideDesc = view.findViewById(R.id.starter_desc);

        slidePicture.setImageResource(starterImage[position]);
        slideHeader.setText(starterHeader[position]);
        slideDesc.setText(starterDesc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
