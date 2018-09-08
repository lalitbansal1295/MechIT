package com.example.bansal.all_in_one_ipec;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LostAndFound extends AppCompatActivity {
    EditText e8,e9;
    Button b15,b16,b17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found);
        e8 = (EditText)findViewById(R.id.editText8);
        e9 = (EditText)findViewById(R.id.editText9);
        b15 = (Button)findViewById(R.id.button15);
        b16 = (Button)findViewById(R.id.button16);
        b17 = (Button)findViewById(R.id.button17);
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LostAndFound.this, Options.class);
                startActivity(i);
                finish();
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e8.getText().toString();
                String s2 = e9.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(LostAndFound.this, "Please Fill All", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("ipeclost",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists lost(name varchar, description varchar)");
                    data.execSQL("insert into lost values('"+s1+"','"+s2+"')");
                    Toast.makeText(LostAndFound.this, "Please contact to HOD", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(LostAndFound.this,LostAndFound.class);
                    startActivity(i);
                    finish();

                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e8.getText().toString();
                String s2 = e9.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(LostAndFound.this, "Please Fill All", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("ipeclost",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists lost(name varchar, description varchar)");
                    data.execSQL("insert into lost values('"+s1+"','"+s2+"')");
                    Toast.makeText(LostAndFound.this, "Please Give to Respective HOD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
