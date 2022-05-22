package com.example.verveticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    EditText t1;
    Button b1;
    TextView t11,t2;
   FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=findViewById(R.id.phonenumberedittxt);
        b1=findViewById(R.id.btnotp);
        t11=findViewById(R.id.notregdisplay);
        t2=findViewById(R.id.registertxtdisplay);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1.getText().toString().isEmpty()||t1.getText().toString().length()!=10){
                    Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(login.this, verfiyotp.class);
                    intent.putExtra("mobile",t1.getText().toString());
                    startActivity(intent);
                }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signUp.class));
                finish();
            }
        });
    }


//    @Override
//    protected void onStart() {
//
//        super.onStart();
//        auth = FirebaseAuth.getInstance();
//        if (auth.getCurrentUser() != null) {
//            startActivity(new Intent(login.this, events.class));
//            finish();
//        }
    }
