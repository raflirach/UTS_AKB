package com.example.uts_akb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uts_akb.presenter.MainActivityPresenter;
import com.example.uts_akb.view.MainView;

import java.util.List;

public class crud extends AppCompatActivity implements MainView {

    private MainActivityPresenter presenter;
    private TextView myTextView;
    List<Model> models;
    String getNim,getNama;
    EditText nim,nama,kelas,telepon,email,instagram;
    int key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        presenter = new MainActivityPresenter((MainView) this);
        //myTextView = findViewById(R.id.myTextView);
        nim = findViewById(R.id.tNim);
        nama = findViewById(R.id.tNama);
        kelas = findViewById(R.id.tKelas);
        telepon = findViewById(R.id.tTelepon);
        email = findViewById(R.id.tEmail);
        instagram = findViewById(R.id.tInstagram);
        Bundle ex = getIntent().getExtras();
        if(ex != null) {
            key = ex.getInt("key");
            nim.setText(ex.getString("nim"));
            nama.setText(ex.getString("nama"));
            kelas.setText(ex.getString("kelas"));
            telepon.setText(ex.getString("telepon"));
            email.setText(ex.getString("email"));
            instagram.setText(ex.getString("instagram"));
        }

        nim.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateNimUser(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateNamaUser(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void updateUserInfoTextView(String info) {
        //myTextView.setText(info);
    }
    public void sendvalue(View view) {
        Bundle ex = getIntent().getExtras();
        if(ex == null) {
            Intent i = new Intent(this, teman.class);
            String tnim = nim.getText().toString();
            String tnama = nama.getText().toString();
            String tkelas = kelas.getText().toString();
            String ttelepon = telepon.getText().toString();
            String temail = email.getText().toString();
            String tinstagram = instagram.getText().toString();
            i.putExtra("nim", tnim);
            i.putExtra("nama", tnama);
            i.putExtra("kelas", tkelas);
            i.putExtra("telepon", ttelepon);
            i.putExtra("email", temail);
            i.putExtra("instagram", tinstagram);
            startActivity(i);
        }else {
            key = ex.getInt("key");
            Intent i = new Intent(this, teman.class);
            String tnim = nim.getText().toString();
            String tnama = nama.getText().toString();
            String tkelas = kelas.getText().toString();
            String ttelepon = telepon.getText().toString();
            String temail = email.getText().toString();
            String tinstagram = instagram.getText().toString();
            i.putExtra("nim", tnim);
            i.putExtra("nama", tnama);
            i.putExtra("kelas", tkelas);
            i.putExtra("telepon", ttelepon);
            i.putExtra("email", temail);
            i.putExtra("instagram", tinstagram);
            i.putExtra("key",key);
            startActivity(i);
        }
        finish();
    }

}