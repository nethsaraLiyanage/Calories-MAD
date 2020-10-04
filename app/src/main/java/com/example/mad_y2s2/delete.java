package com.example.mad_y2s2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class delete extends AppCompatActivity {

    TextView name_meal;

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        name_meal = (TextView) findViewById(R.id.name);

        name_meal.setText(getIntent().getStringExtra("name"));

        String key = getIntent().getStringExtra("key").toString();

        reference = FirebaseDatabase.getInstance().getReference().child("meal").child(key);



        Button button_del = (Button) findViewById(R.id.button);
        button_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(delete.this, "the item deleted successfully", Toast.LENGTH_SHORT).show();
                            delete.this.finish();

                        }
                        else{
                            Toast.makeText(delete.this, "delete unsuccessful", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }
}