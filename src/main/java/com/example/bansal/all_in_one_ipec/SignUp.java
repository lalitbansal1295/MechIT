package com.example.bansal.all_in_one_ipec;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText e3,e4,e5;
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        e3 = (EditText)findViewById(R.id.editText3);
        e4 = (EditText)findViewById(R.id.editText4);
        e5 = (EditText)findViewById(R.id.editText5);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e3.getText().toString();
                String s2 = e4.getText().toString();
                String s3 = e5.getText().toString();
                if(s1.equals("") || s2.equals("")|| s3.equals("")){
                    Toast.makeText(SignUp.this, "Fill All", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase data = openOrCreateDatabase("ipec",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student(name varchar, email varchar,password varchar)");
                    String s4 = "select * from student where name = '" + s1 +"' and email = '"+s2+"'";
                    Cursor cursor = data.rawQuery(s4,null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(SignUp.this, "You Already Have an account", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into student values('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(SignUp.this, "Account created", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(SignUp.this,Options.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }
}
