package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_calorieStatus extends AppCompatActivity {


    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;
    private String result1, result2;

    TextView newHeight, newWeight, newBMI, status01, status02;
    Button updbtn;
    UserProfile user;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_status);

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_calorieStatus.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });

        newHeight = findViewById(R.id.newHeight);
        newWeight = findViewById(R.id.newWeight);
        newBMI = findViewById(R.id.newBMI);
        updbtn = findViewById(R.id.updbtn);


        final Intent intent = getIntent();
        String BMI = "Your new BMI is  " + intent.getStringExtra("bmi");
        String height = "Your new height is  " + intent.getStringExtra("height") + " cm";
        String weight = "Your new weight is  " +intent.getStringExtra("weight") + " kg";

        newHeight.setText(height);
        newWeight.setText(weight);
        newBMI.setText(BMI);

        updbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Users");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChild("-MIGqe4jxNjLJTCAFpfS")){
                            try {
                                int pHeight = Integer.valueOf(intent.getStringExtra("height"));
                                int pWeight = Integer.valueOf(intent.getStringExtra("weight"));
                                user.setWeight(pWeight);
                                user.setHeight(pHeight);

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Users").child("-MIGqe4jxNjLJTCAFpfS");
                                dbRef.setValue(user);
                                Toast.makeText(getApplicationContext(),"Updation Successful",Toast.LENGTH_LONG).show();
                            }
                            catch (NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Invalid Amount",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext()," Nothing to update ",Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        double fBMI = Double.valueOf(intent.getStringExtra("bmi"));
        checkStatus(fBMI);

    }

    public String checkStatus(double fBMI) {

        status01 = findViewById(R.id.status01);
        status02 = findViewById(R.id.status02);

        if (fBMI < 18.5) {
             result1 = "OOPZ!!!";
             result2 = "You are on under weight! 🙁🙁";
        } else if (fBMI >= 18.5 && fBMI <= 24.9) {
            result1 = "CONGRATULATIONS!!!";
            result2 = "You are on normal Weight! 😍😎";
        } else if (fBMI >= 25) {
            result1 = "OOPZ!!!";
            result2 = "You are over weight! 😐😥";
        }

        status01.setText(result1);
        status02.setText(result2);

        return result2;

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
                Intent intent = new Intent(activity_calorieStatus.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(activity_calorieStatus.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(activity_calorieStatus.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(activity_calorieStatus.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(activity_calorieStatus.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(activity_calorieStatus.this,AddWater.class);
                startActivity(intent6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}