package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class  activity_home extends AppCompatActivity {


    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;


    TextView cabo1;
    ArrayList<Meal> meals = new ArrayList<Meal>();

    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cabo1 = (TextView)findViewById(R.id.cabo);

        String logCus = "897";

        dref = FirebaseDatabase.getInstance().getReference().child("meal");
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot child : snapshot.getChildren()){
//                    meals.add((Meal) child.getValue());
//                }
//                calculateCarbo();

                //cabo1.setText(cabo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        bottomAppBar = (BottomAppBar) findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = (FloatingActionButton) findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_home.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });

    }

    private void calculateCarbo() {
        Object[] objects = meals.toArray();

        for (int i=0; i<objects.length; i++)
        {
            //if()
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.more:
                Intent intent = new Intent(activity_home.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(activity_home.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(activity_home.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(activity_home.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(activity_home.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(activity_home.this,AddWater.class);
                startActivity(intent6);
                return true;
            case R.id.more8:
                Intent intent8 = new Intent(activity_home.this,Bmi.class);
                startActivity(intent8);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}