package com.example.mad_y2s2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class UpdateActivity extends AppCompatActivity {

    EditText pName;
    EditText uName;
    EditText pEmail;
    EditText pAge;
    EditText pWeight;
    EditText pHeight;

    Button btnUpdateProfile;
    DatabaseReference dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        pName = findViewById(R.id.)



    }
}
