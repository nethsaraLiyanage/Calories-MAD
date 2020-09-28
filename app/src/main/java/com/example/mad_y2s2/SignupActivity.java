package com.example.mad_y2s2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private Button signUp;
    private ImageButton toLogIn;
    Users std;
    DatabaseReference dbRef;

    EditText name, email, username, password, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        name = findViewById(R.id.fname);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        weight = findViewById(R.id.sign_weight);
        height = findViewById(R.id.sign_height);
        signUp = findViewById(R.id.signup_button);


        std = new Users();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openHome();
            dbRef = FirebaseDatabase.getInstance().getReference().child("Users");
                try {
                    if(TextUtils.isEmpty(name.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(email.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(username.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(password.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(weight.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(height.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Name ia Empty", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        std.setName(name.getText().toString().trim());
                        std.setEmail(email.getText().toString().trim());
                        std.setUsername(username.getText().toString().trim());
                        std.setPassword(password.getText().toString().trim());
                        std.setWeight(weight.getText().toString().trim());
                        std.setHeight(height.getText().toString().trim());

                        dbRef.push().setValue(std);
                        Toast.makeText(getApplicationContext(),"Successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),activity_login.class);
                        startActivity(intent);
                    }
                }
                catch (NumberFormatException nfe) {

                    Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
                }
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