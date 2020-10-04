package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class exercise_display extends AppCompatActivity {

    TextView eName, eTime, eStep, bCal, desc;
    DatabaseReference dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_display);

        Intent intent = getIntent();
        String exID = intent.getStringExtra("cardId");


        eName = (TextView)findViewById(R.id.exerciseName);
        eTime = (TextView)findViewById(R.id.exptime);
        eStep = (TextView)findViewById(R.id.expstep);
        bCal = (TextView)findViewById(R.id.burncal);
        desc = (TextView)findViewById(R.id.description);

        dref = FirebaseDatabase.getInstance().getReference().child("Exercise").child(String.valueOf(exID));
        dref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("eName").getValue().toString();
                String time = snapshot.child("eTime").getValue().toString();
                String step = snapshot.child("eSteps").getValue().toString();
                String cal = snapshot.child("bCal").getValue().toString();
                String des = snapshot.child("description").getValue().toString();

                eName.setText(name);
                eTime.setText(time);
                eStep.setText(step);
                bCal.setText(cal);
                desc.setText(des);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}