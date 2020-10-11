package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView pName;
    TextView uName;
    TextView pEmail;
    TextView pAge;
    TextView pWeight;
    TextView pHeight;
    TextView pBmi;

    UserProfile user;
    DatabaseReference dbRef;


    private Button update;

    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });

        pName = findViewById(R.id.textView17);
        uName = findViewById(R.id.textView18);
        pEmail = findViewById(R.id.textView19);
        pAge = findViewById(R.id.textView20);
        pHeight = findViewById(R.id.textView21);
        pWeight = findViewById(R.id.textView22);

        Toast.makeText(MainActivity.this,"FIREBASE CONNECTED",Toast.LENGTH_LONG).show();


        pName = findViewById(R.id.ProfName);
        uName = findViewById(R.id.ProfUname);
        pEmail = findViewById(R.id.ProfEmail);
        pAge = findViewById(R.id.ProfAge);
        pWeight = findViewById(R.id.ProfWeight);
        pHeight = findViewById(R.id.ProfHeight);
        pBmi = findViewById(R.id.ProfBMI);



        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Users").child("-MIGqe4jxNjLJTCAFpfS");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()){
                    pName.setText(snapshot.child("name").getValue().toString());
                    uName.setText(snapshot.child("username").getValue().toString());
                    pEmail.setText(snapshot.child("email").getValue().toString());
                    pAge.setText(snapshot.child("age").getValue().toString());
                    pWeight.setText(snapshot.child("weight").getValue().toString());
                    pHeight.setText(snapshot.child("height").getValue().toString());

                    pBmi.setText(snapshot.child("bmi").getValue().toString());

                }
                else
                    Toast.makeText(getApplicationContext(),"Nothing to Display",Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        Button btnUpdate = (Button)findViewById(R.id.btn_save);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue = pName.getText().toString();
                String unameValue = uName.getText().toString();
                String emailValue = pEmail.getText().toString();
                String ageValue = pAge.getText().toString();
                String weightValue = pWeight.getText().toString();
                String heightValue = pHeight.getText().toString();
                Intent i = new Intent(MainActivity.this,UpdateActivity.class);
                i.putExtra("wName",nameValue);
                i.putExtra("wUname",unameValue);
                i.putExtra("wEmail",emailValue);
                i.putExtra("wAge",ageValue);
                i.putExtra("wWeight",weightValue);
                i.putExtra("wHeight",heightValue);
                startActivity(i);

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
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.more:
                Intent intent = new Intent(MainActivity.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(MainActivity.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(MainActivity.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(MainActivity.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(MainActivity.this,AddWater.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
