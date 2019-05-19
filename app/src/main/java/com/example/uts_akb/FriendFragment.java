package com.example.uts_akb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FriendFragment extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    EditText edit_nim,edit_nama,edit_kelas,edit_telepon,edit_email,edit_instagram;
    ImageButton btn_tambah,btn_edit,btn_hapus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_friend,container,false);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        models = new ArrayList<>();
        models.add(new Model("10116132","Rafli Ra","IF-3","08112004240",
                "rafli060395@gmail.com","rafli_rach"));
        models.add(new Model("10116132","Rafli Rac","IF-3","08112004240",
                "rafli060395@gmail.com","rafli_rach"));
        models.add(new Model("10116132","Rafli Rach","IF-3","08112004240",
                "rafli060395@gmail.com","rafli_rach"));


        viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        adapter = new Adapter(models,getContext());

        viewPager.setAdapter(adapter);
        viewPager.setPadding(20,0,50,0);
    }
    private void init() {
        //testnim = (EditText) findViewById(R.id.testNim);
        edit_nim = (EditText) getView().findViewById(R.id.nim);
        edit_nama = (EditText) getView().findViewById(R.id.nama);
        edit_telepon = (EditText) getView().findViewById(R.id.telepon);
        edit_kelas = (EditText) getView().findViewById(R.id.kelas);
        edit_email = (EditText) getView().findViewById(R.id.email);
        edit_instagram = (EditText) getView().findViewById(R.id.instagram);
        viewPager = getView().findViewById(R.id.viewPager);

        btn_tambah = getView().findViewById(R.id.btn_tambah);
        btn_edit = getView().findViewById(R.id.btn_edit);
        btn_hapus = getView().findViewById(R.id.btn_hapus);
        btn_tambah.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_edit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tambah:

                String nim = models.get(viewPager.getCurrentItem()).getNim();
                Toast.makeText(getActivity(), nim, Toast.LENGTH_SHORT).show();

                //String nama = edit_nama.getText().toString();
                //String kelas = edit_kelas.getText().toString();
                //String email = edit_email.getText().toString();
                //String instagram = edit_instagram.getText().toString();
                //String telepon = edit_telepon.getText().toString();
                Model temp = new Model(nim, "Agus", "if-4", "08374932432", "agus@gmail.com", "agus__");
                models.add(temp);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_hapus:
                //setNim(models.get(viewPager.getCurrentItem()).getNim());
                if(models.size()>0){
                    models.remove(viewPager.getCurrentItem());
                    Toast.makeText(getActivity(), "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    viewPager.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getActivity(), "Tidak ada data untuk dihapus", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_edit:
                //String test_nim = testnim.getText().toString();
                //models.get(viewPager.getCurrentItem()).setNim(test_nim);
                //viewPager.setAdapter(adapter);
                break;
        }
    }
}

