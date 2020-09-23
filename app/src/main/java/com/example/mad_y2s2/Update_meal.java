package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Update_meal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_meal);

        Button bt1 = findViewById(R.id.btn_tot_cal);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Update_meal.this, activity_total_food_calories_count.class);
                startActivity(intent);
            }

        });
    }
}