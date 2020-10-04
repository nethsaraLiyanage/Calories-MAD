package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class exercise extends AppCompatActivity {

    private CardView cardId1;
    private CardView cardId2;
    private CardView cardId3;
    private CardView cardId4;
    private CardView cardId5;
    private CardView cardId6;

    private BottomAppBar bottomAppBar;
    private FloatingActionButton floatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        cardId1 = findViewById(R.id.ex001);
        cardId2 = findViewById(R.id.ex002);
        cardId3 = findViewById(R.id.ex003);
        cardId4 = findViewById(R.id.ex004);
        cardId5 = findViewById(R.id.ex005);
        cardId6 = findViewById(R.id.ex006);

        cardId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex001");
            }
        });
        cardId2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex002");
            }
        });
        cardId3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex003");
            }
        });
        cardId4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex004");
            }
        });
        cardId5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex005");
            }
        });
        cardId6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCard("ex006");
            }
        });

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatBtn = findViewById(R.id.addMeal);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(exercise.this,Add_Meal_2.class);
                startActivity(intent);

            }
        });

    }

    private void openCard(String cardId) {
        Intent intent = new Intent(exercise.this,exercise_display.class);
        intent.putExtra("cardId",cardId);
        startActivity(intent);
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
                Intent intent = new Intent(exercise.this,activity_home.class);
                startActivity(intent);
                return true;
            case R.id.profile1:
            case R.id.more5:
                Intent intentprof = new Intent(exercise.this,MainActivity.class);
                startActivity(intentprof);
                return true;
            case R.id.more2:
                Intent intent2 = new Intent(exercise.this,activity_statistics.class);
                startActivity(intent2);
                return true;
            case R.id.more3:
                Intent intent3 = new Intent(exercise.this,Add_Meal_2.class);
                startActivity(intent3);
                return true;
            case R.id.more4:
                Intent intent4 = new Intent(exercise.this,exercise.class);
                startActivity(intent4);
                return true;
            case R.id.more6:
                Intent intent6 = new Intent(exercise.this,AddWater.class);
                startActivity(intent6);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}