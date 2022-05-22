package com.example.verveticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class runselect extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runselect);
        b1=findViewById(R.id.btn3k);
        b2=findViewById(R.id.btn5k);
        b3=findViewById(R.id.btn10k);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(runselect.this,participantentery.class);
                i.putExtra("price","299");
                i.putExtra("category","3k");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(runselect.this,participantentery.class);
                i.putExtra("price","399");
                i.putExtra("category","5k");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(runselect.this,participantentery.class);
                i.putExtra("price","499");
                i.putExtra("category","10k");
                startActivity(i);
            }
        });
    }
}