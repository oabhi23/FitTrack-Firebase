package com.example.abhi.workoutapp;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Abhi on 12/31/2017.
 */

public class EnterWeight extends AppCompatActivity implements View.OnClickListener{
    //private LinearLayout container2;
    DatabaseHelper mDatabaseHelper;

    private Button addDataBtn, viewDataBtn;
    private EditText enteredWeight;
    ArrayList<String> list = new ArrayList<>();
    //private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterweight);

        //container2 = (LinearLayout) findViewById(R.id.container2);
        addDataBtn = (Button)findViewById(R.id.addbtn);
        viewDataBtn = (Button)findViewById(R.id.viewdatabtn);
        enteredWeight = (EditText)findViewById(R.id.enteredweight);

        mDatabaseHelper = new DatabaseHelper(this);

        Intent i = getIntent();
        final Bundle extrasBundle = i.getExtras();

        addDataBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String newEntry = enteredWeight.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                Date date = new Date();
                String dateEntry = dateFormat.format(date).toString();
                if(enteredWeight.length() != 0) {
                    AddData(dateEntry + "    " + newEntry);
                    enteredWeight.setText("");
                }
            }
        });

        viewDataBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = new Intent(EnterWeight.this, WeightTracker.class);
                startActivity(i);
            }
        });
    }

    public void AddData(String newEntry){
        mDatabaseHelper.addData(newEntry);

    }

    @Override
    public void onClick(View view) {

    }
}
