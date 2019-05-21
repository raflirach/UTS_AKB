//  Tanggal Pengerjaan : 21 Mei 2019
//  Nim                : 10116132
//  Nama               : Rafli Rachmawandi
//  Kelas              : IF-3

package com.example.uts_akb;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class getstarted extends AppCompatActivity {

    private ViewPager starterViewPager;
    private LinearLayout dotsLayout;
    private starterAdapter starterAdapter;

    private TextView[] dots;
    private Button btnPrev;
    private Button btnNext;
    private Button btnStart;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);

        starterViewPager = findViewById(R.id.starter_slide);
        dotsLayout = findViewById(R.id.dotsLayout);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        btnStart = findViewById(R.id.btnStart);

        starterAdapter = new starterAdapter(this);

        starterViewPager.setAdapter(starterAdapter);

        addDotsIndicator(0);

        starterViewPager.addOnPageChangeListener(viewListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starterViewPager.setCurrentItem(currentPage + 1);

            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starterViewPager.setCurrentItem(currentPage - 1);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    public void addDotsIndicator(int position) {
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparant));

            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            currentPage = i;

            if (i == 0) {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.INVISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("");
            } else if (i == dots.length - 1) {
                btnNext.setEnabled(false);
                btnPrev.setEnabled(true);
                btnNext.setVisibility(View.VISIBLE);

                btnStart.setVisibility(View.VISIBLE);
                btnNext.setText("Finish");
                btnPrev.setText("Prep");

            } else {
                btnNext.setEnabled(true);
                btnPrev.setEnabled(false);
                btnPrev.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnPrev.setText("Prep");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
