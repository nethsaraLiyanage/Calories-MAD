package com.example.mad_y2s2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AddWater extends AppCompatActivity {

    TextView wateramtDate;

    private static final String TAG = "AddWater";

    private TextView wDisplayDate;
    private DatePickerDialog.OnDateSetListener wDateSetListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);
        wDisplayDate = (TextView) findViewById(R.id.dateWater);

        wateramtDate = (TextView) findViewById(R.id.dateWater);

        wDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                Calendar cal =  Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(AddWater.this,
                        android.R.style.Theme_DeviceDefault_Dialog,wDateSetListner,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        wDateSetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month+1;
                String waterDate = month +"/" + day + "/" + year ;
                wDisplayDate.setText(waterDate);

            }
        };

        Button btnddWater = (Button)findViewById(R.id.btnAddWater);
        btnddWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateValue = wateramtDate.getText().toString();
                Intent intent = new Intent(AddWater.this,WaterCount.class);
                intent.putExtra("wDate",dateValue);
                startActivity(intent);
            }
        });
    }
}