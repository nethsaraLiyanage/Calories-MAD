package com.example.mad_y2s2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginUsers extends AppCompatActivity {

    DatabaseReference dbRef;
    String names;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button b_signup;
        final EditText userName, userPassword;

        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.password);
        b_signup = findViewById(R.id.signup_button);


        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String u_pwd = userPassword.getText().toString();
                String u_name = userName.getText().toString();

                if (u_name.isEmpty()) {

                    userName.setError("Insert Your Username");
                    userName.requestFocus();

                } else if (u_pwd.isEmpty()) {

                    userPassword.setError("Enter Password");
                    userPassword.requestFocus();
                } else {


                    dbRef = FirebaseDatabase.getInstance().getReference().child("Users/" + u_name);
                    dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if(dataSnapshot.getValue() != null ) {

                                names = dataSnapshot.child("username").getValue().toString();
                                Toast.makeText(getApplicationContext(), "this is from" + names, Toast.LENGTH_SHORT).show();

                            }
                            else{

                                Toast.makeText(getApplicationContext(),"In the else of ",Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    if (u_name.equals(names)) {


                        Intent intent = new Intent(getApplicationContext(), activity_home.class);
                        intent.putExtra("userName", u_name);
                        startActivity(intent);

                    } else {

                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

                    }

                }
            }

        });

}



}
