package com.example.bansal.all_in_one_ipec;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ComplainPreview extends AppCompatActivity {
    ListView l1;
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain_preview);
        l1 = (ListView)findViewById(R.id.listView);
        SQLiteDatabase data = openOrCreateDatabase("ipeccomplain",MODE_PRIVATE,null);
        data.execSQL("create table if not exists complain(name varchar, description varchar)");


    }
}
