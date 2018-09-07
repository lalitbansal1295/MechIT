package com.example.bansal.all_in_one_ipec;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")){
                    Toast.makeText(HomeActivity.this, "PLEASE FILL ALL", Toast.LENGTH_SHORT).show();
            }
                else {
                    SQLiteDatabase data = openOrCreateDatabase("ipec", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists student(name varchar, email varchar, password varchar)");
                    String s3 = "select * from student where name='" + s1 + "' and password = '" + s2 +"'";
                    Cursor cursor = data.rawQuery(s3,null);
                    if(cursor.getCount() > 0) {
                        Intent i = new Intent(HomeActivity.this, Options.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(HomeActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
        }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, SignUp.class);
                startActivity(i);
                finish();
            }
        });
    }
}
