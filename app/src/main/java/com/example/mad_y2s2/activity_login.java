package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_login extends AppCompatActivity {

    private ImageButton toSignUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toSignUp = findViewById(R.id.imageButton5);
        toSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        login = findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }

    private void openSignUp(){
        Intent signupIntent = new Intent(this, SignupActivity.class);
        startActivity(signupIntent);
    }

    private void openHome(){
        Intent homeIntent = new Intent(this, activity_home.class);
        startActivity(homeIntent);
    }
}