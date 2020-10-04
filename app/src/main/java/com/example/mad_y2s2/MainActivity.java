package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView pName;
    TextView uName;
    TextView pEmail;
    TextView pAge;
    TextView pWeight;
    TextView pHeight;

    UserProfile user;
    DatabaseReference dbRef;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"FIREBASE CONNECTED",Toast.LENGTH_LONG).show();

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Users").child("-MIGqe4jxNjLJTCAFpfS");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()){
                    pName.setText(snapshot.child("name").getValue().toString());
                    uName.setText(snapshot.child("username").getValue().toString());
                    pEmail.setText(snapshot.child("email").getValue().toString());
                    pAge.setText(snapshot.child("age").getValue().toString());
                    pWeight.setText(snapshot.child("weight").getValue().toString());
                    pHeight.setText(snapshot.child("height").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        Button btnUpdate = (Button)findViewById(R.id.btn_save);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UpdateActivity.class));
            }
        });

    }

}
