package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Add_Meal_2 extends AppCompatActivity {

    EditText dateM, mealtype, foodName, grm, cal, userid, cabohy, protine, fat;
    Button save;
    DatabaseReference dbref1;
    Meal meal1;
    private Meal meal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__meal_2);

        userid=(EditText)findViewById(R.id.user);
        dateM=(EditText)findViewById(R.id.date);
        mealtype=(EditText)findViewById(R.id.mealtype);
        foodName=(EditText)findViewById(R.id.foodname);
        grm=(EditText)findViewById(R.id.gram);
        cal=(EditText)findViewById(R.id.calorie);
        cabohy=(EditText)findViewById(R.id.caboh);
        protine=(EditText)findViewById(R.id.protine1);
        fat=(EditText)findViewById(R.id.fat1);

        save=(Button)findViewById(R.id.save);

        dbref1= FirebaseDatabase.getInstance().getReference().child("meal");

         meal = new Meal();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int grm_=Integer.parseInt(grm.getText().toString().trim());
                int calo=Integer.parseInt(cal.getText().toString().trim());
                int cabo=Integer.parseInt(cabohy.getText().toString().trim());
                int pro=Integer.parseInt(protine.getText().toString().trim());
                int fatt=Integer.parseInt(fat.getText().toString().trim());


                meal.setUid(userid.getText().toString().trim());
                meal.setMeal_type(mealtype.getText().toString().trim());
                meal.setFood_name(foodName.getText().toString().trim());
                meal.setDate(dateM.getText().toString().trim());


                meal.setGram_(grm_);
                meal.setCalories_(calo);
                meal.setCabohydrate(cabo);
                meal.setProtine(pro);
                meal.setFat(fatt);

                dbref1.push().setValue(meal);
                Toast.makeText(Add_Meal_2.this, "Food are saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Add_Meal_2.this, view_meal.class);
                startActivity(intent);



            }
        });

    }
}