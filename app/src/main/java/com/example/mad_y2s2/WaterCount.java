package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WaterCount extends AppCompatActivity {

    EditText waterAmt;
    Button btnAddWater;
    DatabaseReference dbRef;
    Water wtr;
    TextView tv;

    private void Clear(){
        waterAmt.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_count);

        tv = (TextView) findViewById(R.id.wDate);

        waterAmt = findViewById(R.id.waterAmount);

        btnAddWater = findViewById(R.id.btnAdd);

        wtr = new Water();

        tv.setText("Date: "+getIntent().getStringExtra("wDate"));

        btnAddWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Water");
                try {
                    if (TextUtils.isEmpty(waterAmt.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter your water intake",Toast.LENGTH_LONG).show();
                    else{
                        wtr.setAmt(Integer.parseInt(waterAmt.getText().toString().trim()));
                        wtr.setWaDate(tv.getText().toString().trim());
                        //inserting to the db
                        dbRef.push().setValue(wtr);
                        Toast.makeText(getApplicationContext(),"Insertion Successful",Toast.LENGTH_LONG).show();
                        Clear();
                    }
                }
                catch ( NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Amount",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}