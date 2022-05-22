package com.example.verveticket;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class events extends AppCompatActivity {
    Button jssrun,concert,event;
    TextView display,username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        jssrun=findViewById(R.id.jssrun);
        concert=findViewById(R.id.concertbtn);
        event=findViewById(R.id.eventsbtn);
        display=findViewById(R.id.welcomemsg);
        username=findViewById(R.id.userdisplay);

       jssrun.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(events.this,runselect.class));
               finish();
           }
       });



    }
}