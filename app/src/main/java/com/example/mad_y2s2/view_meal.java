package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class view_meal extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meal);

        lv = (ListView) findViewById(R.id.listmeal);

        Query query = FirebaseDatabase.getInstance().getReference().child("meal");
        FirebaseListOptions<Meal> options = new FirebaseListOptions.Builder<Meal>()
                .setLayout(R.layout.meal_)
                .setQuery(query,Meal.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView dateM,typeM, foodName, gramF, calorieF, uid, cabo_, prot_, fat_;

                uid=(TextView) v.findViewById(R.id.user_iD);
                dateM=(TextView) v.findViewById(R.id.date);
                typeM = (TextView) v.findViewById(R.id.type);
                foodName = (TextView) v.findViewById(R.id.name);
                gramF = (TextView) v.findViewById(R.id.grmcount);
                calorieF = (TextView) v.findViewById(R.id.caloriecount);
                cabo_ = (TextView) v.findViewById(R.id.cabo);
                prot_ = (TextView) v.findViewById(R.id.protine1);
                fat_ = (TextView) v.findViewById(R.id.fat);


                Meal pro = (Meal) model;

                uid.setText(String.valueOf(pro.getUid()));
                dateM.setText(String.valueOf(pro.getDate()));
                typeM.setText(String.valueOf(pro.getMeal_type()));
                foodName.setText(String.valueOf(pro.getFood_name()));
                gramF.setText(String.valueOf(pro.getGram_()));
                calorieF.setText(String.valueOf(pro.getCalories_()));
                cabo_.setText(String.valueOf(pro.getCabohydrate()));
                prot_.setText(String.valueOf(pro.getProtine()));
                fat_.setText(String.valueOf(pro.getFat()));


                Button bt1 = findViewById(R.id.add);
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view_meal.this, Add_Meal_2.class);
                        startActivity(intent);
                    }

                });

                Button bt2 = findViewById(R.id.save);
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view_meal.this, activity_total_food_calories_count.class);
                        startActivity(intent);
                    }

                });

            }
        };

        lv.setAdapter(adapter);




    }


    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }


    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}