package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.myapplication.R.id;
import com.example.myapplication.ui.tabs.SectionsPagerAdapter;
import com.example.myapplication.ui.tabs.TabTakenLijst;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Overview extends AppCompatActivity {
    private TextView dodDay, dodHour, dodMinute, dodSecond;
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        TabTakenLijst takenLijst = new TabTakenLijst();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id.placeholder,takenLijst);
        fragmentTransaction.commit();

        dodDay = findViewById(id.dodDay);
        dodHour = findViewById(id.dodHour);
        dodMinute = findViewById(id.dodMinute);
        dodSecond = findViewById(id.dodSecond);

        countDownStart();
    }
    private void countDownStart(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date futureDate = dateFormat.parse("2019-5-30");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        dodDay.setText("" + String.format("%02d", days) + ":");
                        dodHour.setText("" + String.format("%02d", hours) + ":");
                        dodMinute.setText("" + String.format("%02d", minutes) + ":");
                        dodSecond.setText("" + String.format("%02d", seconds));
                    } else {
                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1*1000);
    }
}