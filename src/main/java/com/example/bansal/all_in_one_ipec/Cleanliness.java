package com.example.bansal.all_in_one_ipec;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cleanliness extends AppCompatActivity {
    EditText e6,e7;
    Button b10,b11,b12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleanliness);
        e6 = (EditText)findViewById(R.id.editText6);
        e7 = (EditText)findViewById(R.id.editText7);
        b10 = (Button)findViewById(R.id.button10);
        b11 = (Button)findViewById(R.id.button11);
        b12 = (Button)findViewById(R.id.button12);
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e6.getText().toString();
                String s2 = e7.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(Cleanliness.this, "Please Fill All", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("ipeccomplain",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists complain(name varchar,description varchar)");
                    data.execSQL("insert into complain values('"+s1+"','"+s2+"')");
                    Toast.makeText(Cleanliness.this, "Complain Added", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(Cleanliness.this,ComplainPreview.class);
                    startActivity(i);
                    finish();
                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cleanliness.this, ComplainPreview.class);
                startActivity(i);
                finish();
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cleanliness.this, Options.class);
                startActivity(i);
                finish();
            }
        });
    }
}
