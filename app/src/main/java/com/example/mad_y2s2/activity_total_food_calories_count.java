package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class activity_total_food_calories_count extends AppCompatActivity {

    Meal meal;
    ArrayList<Meal> mealList = new ArrayList<Meal>();
    EditText date_meal;
    String date;
    Button button_search;
    TextView total;
    int calary = 0;
    ListView lv;
    DatabaseReference rootRef, demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_food_count);
        initViews();
        meal = new Meal();

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = date_meal.getText().toString().trim();
                TotalCal();
            }
        });


    }

    private void initViews() {
        date_meal = findViewById(R.id.date_Meals);
        button_search = findViewById(R.id.search_date);
        total = findViewById(R.id.calorie_tot);
    }


    public void TotalCal() {
        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        // Database reference pointing to demo node
        demoRef = rootRef.child("meal");
        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    System.out.println(snapshot.toString());
                    long calary=0;
                    HashMap<String,Object> dataMap= (HashMap<String, Object>) snapshot.getValue();
                    for (String key : dataMap.keySet()){
                        Object data = dataMap.get(key);
                        try{
                            HashMap<String, Object> userData = (HashMap<String, Object>) data;
                            if(userData.get("date").toString().equalsIgnoreCase(date)){
                                long cal= ((Number) userData.get("calories_")).longValue();
                                System.out.println(cal);
                                calary=calary+cal;
                            }

                        }catch (ClassCastException cce) {
                            System.out.println(cce.getMessage());
                        }
                    }
                    total.setText(calary+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

