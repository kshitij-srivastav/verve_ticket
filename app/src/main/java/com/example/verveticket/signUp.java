package com.example.verveticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signUp extends AppCompatActivity {
    EditText t1,t2,t3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        t1=findViewById(R.id.nameedittxt);
        t2=findViewById(R.id.usnedittxt);
        t3=findViewById(R.id.numberedittext);
        b1=findViewById(R.id.btnsignup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signUp.this,verifyafterfirstregister.class);
                intent.putExtra("mobile",t3.getText().toString());
                intent.putExtra("name",t1.getText().toString());
                intent.putExtra("usn",t2.getText().toString());
                startActivity(intent);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });

    }
}