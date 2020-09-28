package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bottom_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.more) {
            Intent ProfileIntent = new Intent(this, MainActivity.class);
            startActivity(ProfileIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        if(view == findViewById(R.id.fragButton3)){
            fragment2 = new WeeklyChart();
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.fgmntDefault,fragment2);
            ft2.commit();
        }

    }


}