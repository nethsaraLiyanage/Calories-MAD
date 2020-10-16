package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class activity_statistics extends AppCompatActivity {

    private Button fragButton2;
    private Button fragButton3;
    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;
    private ArrayList<Meal> mealList = new ArrayList<>();
    private ArrayList<Meal> selmealList = new ArrayList<>();
    private DatabaseReference databaseRef;
    private Meal meal;
    private Button calbutn;
    public static int[] calories = new int[7];
    private EditText weight,height;

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(yesterday());
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        fragButton2 = findViewById(R.id.fragButton2);
        fragButton3 = findViewById(R.id.fragButton3);

        weight = findViewById(R.id.statWeight);
        height = findViewById(R.id.statHeight);
        calbutn = findViewById(R.id.calbutn);

        ///calculateBMI



        calbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S1 = weight.getText().toString();
                String S2 = height.getText().toString();
                calculateBMI(S1,S2);
            }
        });

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_statistics.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });


        databaseRef = FirebaseDatabase.getInstance().getReference().child("meal");
        databaseRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //mealList.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    meal = snapshot1.getValue(Meal.class);
                    mealList.add(meal);
                }

                Toast.makeText(activity_statistics.this,mealList.get(0).getUid(),Toast.LENGTH_LONG).show();

                String logCus = "c0001";
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                String dateNow = dtf.format(now);
                String yest = getYesterdayDateString();

                for(int i = 0; i < mealList.size();i++){
                    if(mealList.get(i).getUid().equals(logCus)){
                        meal = mealList.get(i);
                        selmealList.add(meal);
                    }
                }

                for(int y = 0; y < selmealList.size();y++){
                    if(selmealList.get(y).getDate().equals(GetDate.dates.get(0))){
                        calories[0] = calories[0] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(1))){
                        calories[1] = calories[1] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(2))){
                        calories[2] = calories[2] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(3))){
                        calories[3] = calories[3] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(4))){
                        calories[4] = calories[4] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(5))){
                        calories[5] = calories[5] + selmealList.get(y).getCalories_();
                    }
                    else if(selmealList.get(y).getDate().equals(GetDate.dates.get(6))){
                        calories[6] = calories[6] + selmealList.get(y).getCalories_();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(activity_statistics.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

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
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.more:
                Intent intent = new Intent(activity_statistics.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(activity_statistics.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(activity_statistics.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(activity_statistics.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(activity_statistics.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(activity_statistics.this,AddWater.class);
                startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public float calculateBMI(String S1, String S2) {


        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;


        float bmi = weightValue / (heightValue * heightValue);
        //Toast.makeText(activity_statistics.this, (int) bmi,Toast.LENGTH_LONG).show();


        String sBMI = Float.toString(bmi);
        Intent intent = new Intent(activity_statistics.this, activity_calorieStatus.class);
        intent.putExtra("bmi", sBMI);
        intent.putExtra("weight", S1);
        intent.putExtra("height", S2);
        startActivity(intent);

        return bmi;

    }

}