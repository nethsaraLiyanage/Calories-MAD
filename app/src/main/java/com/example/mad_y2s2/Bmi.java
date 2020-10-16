package com.example.mad_y2s2;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bmi extends AppCompatActivity {
    EditText weight,height,name;
    TextView final_result;

    String calculation,BMI_result;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);







        weight = findViewById(R.id.weight);
        name = findViewById(R.id.uName);
        height = findViewById(R.id.height);
        final_result = findViewById(R.id.final_result);




    }
    public void calculate(View view) {

        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        String Uname = name.getText().toString();

        float weightValue = Float.parseFloat(wString);
        float heightValue = Float.parseFloat(hString) / 100;


        float bmi = weightValue / (heightValue * heightValue);


        if (bmi < 16) {
            BMI_result = "Severely under weight";

        } else if (bmi < 18.5) {
            BMI_result = "Under weight";

        } else if (bmi >= 18.5 && bmi <= 24.9) {
            BMI_result = "Normal Weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            BMI_result = "Overweight";
        } else {
            BMI_result = "Obese";
        }

        calculation = "Your BMI is\n\n" + bmi + "\n" + BMI_result;


        final_result.setText(calculation);
        dbref = FirebaseDatabase.getInstance().getReference().child("BMI");
        dbref.child(Uname).child("status").setValue(BMI_result);
        dbref.child(Uname).child("BMI").setValue(bmi);

    }
}
