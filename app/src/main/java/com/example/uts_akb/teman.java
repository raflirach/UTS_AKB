package com.example.uts_akb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.uts_akb.model.Model;
import com.example.uts_akb.presenter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class teman extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    ImageButton btn_tambah, btn_hapus, btn_edit;
    EditText edit_nim, edit_nama, edit_kelas, edit_telepon, edit_email, edit_instagram;
    LinearLayout insta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar Teman");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        init();

        models = new ArrayList<>();
        models.add(new Model("10116132", "Rafli Rachmawandi", "IF-3", "08112004240",
                "rafli060395@gmail.com", "rafli_rach"));
        models.add(new Model("10116102", "M Rizki Ramadhan", "IF-3", "082295037972",
                "rizkirama46@gmail.com", "rizki.gg"));
        models.add(new Model("10116110", "M Ibnu Tri Yuono", "IF-3", "081312923780",
                "ibnutriyuono@gmail.com", "ibnutriyuono"));
        models.add(new Model("10116039", "Agus Setiawan", "IF-11", "081577212345",
                "setiawan_agus@gmail.com", "agus_setiawan"));
        models.add(new Model("10116231", "Agung Herdiawan", "IF-5", "089655644223",
                "agung_her@gmail.com", "herdiawan_a"));
        models.add(new Model("10116198", "M Udin", "IF-6", "085722543234",
                "mister_udin@gmail.com", "mr_udin"));
        Bundle ex = getIntent().getExtras();
        if(ex != null){
            String getNim = ex.getString("nim");
            String getNama = ex.getString("nama");
            String getKelas = ex.getString("kelas");
            String getTelepon = ex.getString("telepon");
            String getEmail = ex.getString("email");
            String getInstagram = ex.getString("instagram");
            int getKey = ex.getInt("key");
            //Toast.makeText(this,String.valueOf(getKey), Toast.LENGTH_SHORT).show();
            if(getKey>0 && getKey<models.size()){
                models.set(getKey,new Model(getNim, getNama, getKelas, getTelepon,
                        getEmail, getInstagram));
                Toast.makeText(this,"Data berhasil diedit", Toast.LENGTH_SHORT).show();
            }else {
                models.add(new Model(getNim, getNama, getKelas, getTelepon,
                        getEmail, getInstagram));
                Toast.makeText(this,"Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        }
        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(20, 0, 50, 0);

    }

    private void init() {
        edit_nim = (EditText) findViewById(R.id.nim);
        edit_nama = (EditText) findViewById(R.id.nama);
        edit_telepon = (EditText) findViewById(R.id.telepon);
        edit_kelas = (EditText) findViewById(R.id.kelas);
        edit_email = (EditText) findViewById(R.id.email);
        edit_instagram = (EditText) findViewById(R.id.instagram);
        viewPager = findViewById(R.id.viewPager);

        btn_tambah = findViewById(R.id.btn_tambah);
        btn_edit = findViewById(R.id.btn_edit);
        btn_hapus = findViewById(R.id.btn_hapus);
        btn_tambah.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_edit.setOnClickListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_profil:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_contact:

                break;
            case R.id.nav_friend:
                Intent intent3 = new Intent(this, teman.class);
                startActivity(intent3);
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tambah:
                Intent intent = new Intent(this,crud.class);
                intent.putExtra("judul","Tambah Data");
                startActivity(intent);
                finish();
                break;
            case R.id.btn_edit:
                if(models.size()>0){
                Intent intent2 = new Intent(this,crud.class);
                int key = viewPager.getCurrentItem();
                intent2.putExtra("key",key);
                intent2.putExtra("nim",models.get(viewPager.getCurrentItem()).getNim());
                intent2.putExtra("nama",models.get(viewPager.getCurrentItem()).getNama());
                intent2.putExtra("kelas",models.get(viewPager.getCurrentItem()).getKelas());
                intent2.putExtra("telepon",models.get(viewPager.getCurrentItem()).getTelepon());
                intent2.putExtra("email",models.get(viewPager.getCurrentItem()).getEmail());
                intent2.putExtra("instagram",models.get(viewPager.getCurrentItem()).getInstagram());
                intent2.putExtra("judul","Edit Data");
                startActivity(intent2);
                finish();
                }
                else {
                    Toast.makeText(this, "Tidak ada data untuk diedit", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_hapus:
                if(models.size()>0){
                    String nim = models.get(viewPager.getCurrentItem()).getNim();
                    models.remove(viewPager.getCurrentItem());
                    Toast.makeText(this, "Data Nim "+ nim +" berhasil dihapus", Toast.LENGTH_SHORT).show();
                    viewPager.setAdapter(adapter);
                }
                else {
                    Toast.makeText(this, "Tidak ada data untuk dihapus", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
