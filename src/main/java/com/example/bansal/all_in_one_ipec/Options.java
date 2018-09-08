package com.example.bansal.all_in_one_ipec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {
    Button b5,b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Options.this, CanteenOrders.class);
                startActivity(i);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Options.this, EventNotification.class);
                startActivity(i);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Options.this, LostAndFound.class);
                startActivity(i);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Options.this, Cleanliness.class);
                startActivity(i);
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Options.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
