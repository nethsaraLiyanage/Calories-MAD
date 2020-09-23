package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class activity_statistics extends AppCompatActivity {

    private Button fragButton2;
    private Button fragButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        fragButton2 = findViewById(R.id.fragButton2);
        fragButton3 = findViewById(R.id.fragButton3);

        fragButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(view);
            }
        });

        fragButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(view);
            }
        });

    }

    public void changeFragment(View view){
        Fragment fragment1;
        Fragment fragment2;

        if(view == findViewById(R.id.fragButton2)){
            fragment1 = new MonthlyChart();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fgmntDefault,fragment1);
            ft.commit();
        }

        if (view == findViewById(R.id.fragButton3)){
            fragment2 = new WeeklyChart();
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.fgmntDefault,fragment2);
            ft2.commit();
        }

    }


}