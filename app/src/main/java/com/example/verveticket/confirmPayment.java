package com.example.verveticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class confirmPayment extends AppCompatActivity {
Button confirmPayment,rejected;
String uid;
FirebaseFirestore db;
EditText paymentID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_payment);
        confirmPayment=findViewById(R.id.confirmPayment);
        rejected=findViewById(R.id.paymentRejected);
        paymentID=findViewById(R.id.paymentID);
        uid=getIntent().getStringExtra("uid");
        db=FirebaseFirestore.getInstance();
        confirmPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("jss_run").document(uid)
                        .update("paymentID", paymentID.getText().toString());
                Toast.makeText(getApplicationContext(),"Ticket Sent",Toast.LENGTH_LONG).show();
                Intent in= new Intent(com.example.verveticket.confirmPayment.this,events.class);
                startActivity(in);
            }
        });
        rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Cannot registered",Toast.LENGTH_LONG);
            }
        });
    }
}