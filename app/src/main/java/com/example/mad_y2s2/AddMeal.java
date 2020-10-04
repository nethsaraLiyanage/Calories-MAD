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

public class AddMeal extends AppCompatActivity
{
EditText food1,grm1,cal1,food2,grm2,cal2,food3,grm3,cal3,food4,grm4,cal4,food5,grm5,cal5,food6,grm6,cal6,food7,grm7,cal7;
Button b1;
DatabaseReference dbref;
Food food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);


        b1=(Button)findViewById(R.id.btn_save);

        food1=(EditText)findViewById(R.id.fd1);
        food2=(EditText)findViewById(R.id.fd2);
        food3=(EditText)findViewById(R.id.fd3);
        food4=(EditText)findViewById(R.id.pName);
        food5=(EditText)findViewById(R.id.fd5);
        food6=(EditText)findViewById(R.id.fd6);
        food7=(EditText)findViewById(R.id.fd7);

        grm1=(EditText)findViewById(R.id.grm_1);
        grm2=(EditText)findViewById(R.id.grm_2);
        grm3=(EditText)findViewById(R.id.grm_3);
        grm4=(EditText)findViewById(R.id.grm_4);
        grm5=(EditText)findViewById(R.id.grm_5);
        grm6=(EditText)findViewById(R.id.grm_6);
        grm7=(EditText)findViewById(R.id.grm_7);

        cal1=(EditText)findViewById(R.id.cal_1);
        cal2=(EditText)findViewById(R.id.cal_2);
        cal3=(EditText)findViewById(R.id.cal_3);
        cal4=(EditText)findViewById(R.id.cal_4);
        cal5=(EditText)findViewById(R.id.cal_5);
        cal6=(EditText)findViewById(R.id.cal_6);
        cal7=(EditText)findViewById(R.id.cal_7);

        dbref= FirebaseDatabase.getInstance().getReference().child("Food");

         food = new Food();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gram1=Integer.parseInt(grm1.getText().toString().trim());
                int gram2=Integer.parseInt(grm2.getText().toString().trim());
                int gram3=Integer.parseInt(grm3.getText().toString().trim());
                int gram4=Integer.parseInt(grm4.getText().toString().trim());
                int gram5=Integer.parseInt(grm5.getText().toString().trim());
                int gram6=Integer.parseInt(grm6.getText().toString().trim());
                int gram7=Integer.parseInt(grm7.getText().toString().trim());

                int calorie1=Integer.parseInt(cal1.getText().toString().trim());
                int calorie2=Integer.parseInt(cal2.getText().toString().trim());
                int calorie3=Integer.parseInt(cal3.getText().toString().trim());
                int calorie4=Integer.parseInt(cal4.getText().toString().trim());
                int calorie5=Integer.parseInt(cal5.getText().toString().trim());
                int calorie6=Integer.parseInt(cal6.getText().toString().trim());
                int calorie7=Integer.parseInt(cal7.getText().toString().trim());

                //food.setFd1(food1.getText().toString().trim());
                food.setFd2(food2.getText().toString().trim());
                food.setFd3(food3.getText().toString().trim());
                food.setFd4(food4.getText().toString().trim());
                food.setFd5(food5.getText().toString().trim());
                food.setFd6(food6.getText().toString().trim());
                food.setFd7(food7.getText().toString().trim());

                food.setEtn1(gram1);
                food.setEtn2(gram2);
                food.setEtn3(gram3);
                food.setEtn4(gram4);
                food.setEtn5(gram5);
                food.setEtn6(gram6);
                food.setEtn7(gram7);

                food.setEtn8(calorie1);
                food.setEtn9(calorie2);
                food.setEtn10(calorie3);
                food.setEtn11(calorie4);
                food.setEtn12(calorie5);
                food.setEtn13(calorie6);
                food.setEtn14(calorie7);

                dbref.push().setValue(food);
                Toast.makeText(AddMeal.this, "Food are saved", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AddMeal.this, Update_meal.class);
                        startActivity(intent);



            }
        });

    }
}