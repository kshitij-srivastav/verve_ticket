package com.example.verveticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView t1;
FirebaseAuth auth;

    //@Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user= auth.getCurrentUser();
//        if (auth!=null){
//            startActivity( new Intent(MainActivity.this,events.class));
//            finish();
//        }
//        else{
//            startActivity( new Intent(MainActivity.this,login.class));
//            finish();
//        }
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(MainActivity.this, login.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 1500); // wait for 5 seconds

        auth=FirebaseAuth.getInstance();
    }
}