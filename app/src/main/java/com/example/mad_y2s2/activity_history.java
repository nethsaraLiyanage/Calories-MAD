package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_history extends AppCompatActivity {

    String bmi,status;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);


        TextView t1,t2,t3,t4,t5,s1,s2,s3,s4,s5;

        t1 = findViewById(R.id.b1);
        t2 = findViewById(R.id.b2);
        t3 = findViewById(R.id.b3);
        t4 = findViewById(R.id.b4);
        t5 = findViewById(R.id.b5);

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);


        DisplyDB();
        t1.setText("d"+bmi);



    }

    void DisplyDB(){

        DatabaseReference dbref;



        dbref = FirebaseDatabase.getInstance().getReference().child("BMI/Ashy");
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                bmi =snapshot.child("status").getValue().toString();
                Toast.makeText(getApplicationContext(),"DB reading"+bmi,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

}