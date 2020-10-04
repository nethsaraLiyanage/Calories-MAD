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

import org.w3c.dom.Text;

public class exercise_display extends AppCompatActivity {

    TextView eName, eTime, eStep, bCal, desc;
    DatabaseReference dref;

    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_display);

        Intent intent = getIntent();
        String exID = intent.getStringExtra("cardId");

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercise_display.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });


        eName = (TextView)findViewById(R.id.exerciseName);
        eTime = (TextView)findViewById(R.id.exptime);
        eStep = (TextView)findViewById(R.id.expstep);
        bCal = (TextView)findViewById(R.id.burncal);
        desc = (TextView)findViewById(R.id.description);

        dref = FirebaseDatabase.getInstance().getReference().child("Exercise").child(String.valueOf(exID));
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("eName").getValue().toString();
                String time = snapshot.child("eTime").getValue().toString();
                String step = snapshot.child("eSteps").getValue().toString();
                String cal = snapshot.child("bCal").getValue().toString();
                String des = snapshot.child("description").getValue().toString();

                eName.setText(name);
                eTime.setText(time);
                eStep.setText(step);
                bCal.setText(cal);
                desc.setText(des);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
                Intent intent = new Intent(exercise_display.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(exercise_display.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(exercise_display.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(exercise_display.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(exercise_display.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(exercise_display.this,AddWater.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}