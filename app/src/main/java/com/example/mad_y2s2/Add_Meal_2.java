package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Add_Meal_2 extends AppCompatActivity {

    EditText dateM, mealtype, foodName, grm, cal, userid, cabohy, protine, fat;
    String dateM_valid, mealtype_valid, foodName_valid, grm_valid, cal_valid, userid_valid, cabohy_valid, protine_valid, fat_valid;
    Button save;
    DatabaseReference dbref1;
    Meal meal1;
    private Meal meal;
    int grm_,calo,cabo,pro,fatt;

    String saveCurrentDate,saveCurrentTime,productRandomKey;


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


                validateRegistration();



            }
        });

    }

    private void validateRegistration() {



        dateM_valid =  dateM.getText().toString();
        mealtype_valid = mealtype.getText().toString();
        foodName_valid = foodName.getText().toString();

        grm_valid = grm.getText().toString();
        cal_valid = cal.getText().toString();
        userid_valid =  userid.getText().toString();
        cabohy_valid = cabohy.getText().toString();
        protine_valid = protine.getText().toString();
        fat_valid = fat.getText().toString();

        if(TextUtils.isEmpty(dateM_valid)){
            Toast.makeText(this, "date field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(mealtype_valid)){
            Toast.makeText(this, "meal type field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(foodName_valid)){
            Toast.makeText(this, "foodName field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(grm_valid)){
            Toast.makeText(this, "gram field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(cal_valid)){
            Toast.makeText(this, "calories field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(userid_valid)){
            Toast.makeText(this, "user id field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(cabohy_valid)){
            Toast.makeText(this, "Carbohydrate field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(protine_valid)){
            Toast.makeText(this, "Protein field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(fat_valid)){
            Toast.makeText(this, "fat field field shouldn't be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            saveInformation();
        }

    }

    private void saveInformation() {

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM DD, YYYY");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

        grm_=Integer.parseInt(grm.getText().toString().trim());
        calo=Integer.parseInt(cal.getText().toString().trim());
        cabo=Integer.parseInt(cabohy.getText().toString().trim());
        pro=Integer.parseInt(protine.getText().toString().trim());
        fatt=Integer.parseInt(fat.getText().toString().trim());

        meal.setUid(userid.getText().toString().trim());
        meal.setMeal_type(mealtype.getText().toString().trim());
        meal.setFood_name(foodName.getText().toString().trim());
        meal.setDate(dateM.getText().toString().trim());
        meal.setKey(productRandomKey);


        meal.setGram_(grm_);
        meal.setCalories_(calo);
        meal.setCabohydrate(cabo);
        meal.setProtine(pro);
        meal.setFat(fatt);

        dbref1.child(productRandomKey).setValue(meal);
        Toast.makeText(Add_Meal_2.this, "Food are saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Add_Meal_2.this, view_meal.class);
        startActivity(intent);
    }
}