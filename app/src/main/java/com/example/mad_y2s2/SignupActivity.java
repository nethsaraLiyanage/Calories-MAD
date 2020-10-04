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




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openHome();
                std = new Users();
                dbRef = FirebaseDatabase.getInstance().getReference().child("Users");

                String full_name = name.getText().toString();
                String user_email = email.getText().toString();
                String user_username = username.getText().toString();
                String user_password = password.getText().toString();
                String user_weight = weight.getText().toString();
                String user_height = height.getText().toString();
                String user_signup = signUp.getText().toString();


                try {
                    if( full_name.isEmpty()){

                        name.setError("Enter Your Name");
                        name.requestFocus();
                    }
                    else if( user_email.isEmpty()){

                        email.setError("Enter Your Email");
                        email.requestFocus();
                    }
                    else if( user_username.isEmpty()){

                        username.setError("Enter Your Username");
                        username.requestFocus();
                    }
                    else if( user_password.isEmpty()){

                        password.setError("Enter Your Password");
                        password.requestFocus();
                    }
                    else if( user_weight.isEmpty()){

                        weight.setError("Enter Your Weight");
                        weight.requestFocus();
                    }
                    else if( user_height.isEmpty()){


                        height.setError("Enter Your Height");
                        height.requestFocus();
                    }
                    else{

                        std.setName(name.getText().toString().trim());
                        std.setEmail(email.getText().toString().trim());
                        std.setUsername(username.getText().toString().trim());
                        std.setPassword(password.getText().toString().trim());
                        std.setWeight(weight.getText().toString().trim());
                        std.setHeight(height.getText().toString().trim());

                        dbRef.child(""+username.getText().toString()).setValue(std);

                        Toast.makeText(getApplicationContext(),"Successfully Registered", Toast.LENGTH_SHORT).show();
                        clearControls();
                        Intent intent = new Intent(getApplicationContext(),LoginUsers.class);
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
                Intent object =  new Intent(getApplicationContext(), LoginUsers.class);
                startActivity(object);
            }
        }
        );
    }

    private void clearControls(){

        name.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        weight.setText("");
        height.setText("");
    }


}