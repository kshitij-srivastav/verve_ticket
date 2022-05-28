package com.example.verveticket;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class participantentery extends AppCompatActivity {
    EditText participantName,collegeName,emailAdd,phoneNum,paymentMode;
    Button b1;
    FirebaseFirestore root;
    String category,price,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantentery);
        participantName=findViewById(R.id.nameedittxt);
        collegeName=findViewById(R.id.collegeedittxt);
        emailAdd=findViewById(R.id.emailedittext);
        phoneNum=findViewById(R.id.phonenumberedittxt);
        category=getIntent().getStringExtra("category").toString();
        price=getIntent().getStringExtra("price").toString();
        UUID uuid=UUID.randomUUID();
        uid=uuid.toString();
        paymentMode=findViewById(R.id.paymentmode);


        b1=findViewById(R.id.submitbtn);
        root=FirebaseFirestore.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Map<String,Object> data= new HashMap<>();
                data.put("college",collegeName.getText().toString());
                data.put("createdAt",java.time.LocalDateTime.now());
                data.put("eventDetails",category);
                data.put("id",uid);
                data.put("isValid",true);
                data.put("mainEvent","");
                data.put("name",participantName.getText().toString());
                data.put("paymentMode",paymentMode.getText().toString());
                data.put("phone",phoneNum.getText().toString());
                data.put("refferedBy",  FirebaseAuth.getInstance().getCurrentUser().getUid().toString());
                data.put("paymentID","");
                FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
                CollectionReference usersRef = rootRef.collection("jss_run");
                usersRef.document(uid).set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        participantName.setText("");
                        collegeName.setText("");
                        phoneNum.setText("");
                        emailAdd.setText("");
                        paymentMode.setText("");
                        Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(participantentery.this,confirmPayment.class);
                            i.putExtra("uid",uid);
                            startActivity(i);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Fail to register ",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}