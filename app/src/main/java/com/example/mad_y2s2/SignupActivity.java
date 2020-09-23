package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignupActivity extends AppCompatActivity {

    private Button signUp;
    private ImageButton toLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp = findViewById(R.id.button2);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        toLogIn = findViewById(R.id.imageButton5);
        toLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogIn();
            }
        });
    }

    private void openHome(){
        Intent homeIntent = new Intent(this, activity_home.class);
        startActivity(homeIntent);
    }

    private void openlogIn(){
        Intent loginIntent = new Intent(this, activity_login.class);
        startActivity(loginIntent);
    }
}