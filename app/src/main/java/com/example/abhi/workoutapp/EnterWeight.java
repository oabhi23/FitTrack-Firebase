package com.example.abhi.workoutapp;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Abhi on 12/31/2017.
 */

public class EnterWeight extends AppCompatActivity {
    //private LinearLayout container2;
    DatabaseHelper mDatabaseHelper;
    BenchDatabaseHelper benchDatabaseHelper;
    SquatDatabaseHelper squatDatabaseHelper;
    DeadliftDatabaseHelper deadliftDataBaseHelper;
    OhpDatabaseHelper ohpDatabaseHelper;

    private Button addDataBtn, viewDataBtn;
    private EditText enteredWeight;
    private EditText enteredReps;

    private boolean hasBench = false;
    private boolean hasUserWeight = false;
    private boolean hasSquat = false;
    private boolean hasDeadlift = false;
    private boolean hasOhp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterweight);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(t);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        addDataBtn = (Button)findViewById(R.id.addbtn);
        viewDataBtn = (Button)findViewById(R.id.viewdatabtn);
        enteredWeight = (EditText)findViewById(R.id.enteredweight);
        enteredReps = (EditText)findViewById(R.id.enteredreps);

        Intent i = getIntent();
        Bundle extrasBundle = i.getExtras();

        if(extrasBundle.containsKey("benchWeight")){
            hasBench = true;
            enteredReps.setVisibility(View.VISIBLE);
            benchDatabaseHelper = new BenchDatabaseHelper(this, "benchWeight", 1);
        }
        if(extrasBundle.containsKey("squatWeight")){
            hasSquat = true;
            enteredReps.setVisibility(View.VISIBLE);
            squatDatabaseHelper = new SquatDatabaseHelper(this, "squatWeight", 1);
        }
        if(extrasBundle.containsKey("deadliftWeight")){
            hasDeadlift = true;
            enteredReps.setVisibility(View.VISIBLE);
            deadliftDataBaseHelper = new DeadliftDatabaseHelper(this, "deadliftWeight", 1);
        }
        if(extrasBundle.containsKey("ohpWeight")){
            hasOhp = true;
            enteredReps.setVisibility(View.VISIBLE);
            ohpDatabaseHelper = new OhpDatabaseHelper(this, "ohpWeight", 1);
        }
        if(extrasBundle.containsKey("userWeight")){
            hasUserWeight = true;
            mDatabaseHelper = new DatabaseHelper(this, "userWeight", 1);
        }



        addDataBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String newEntry = enteredWeight.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                Date date = new Date();
                String dateEntry = dateFormat.format(date).toString();

                String repsEntry = enteredReps.getText().toString();

                if(enteredWeight.length() != 0) {
                    if (hasBench){
                        AddBenchData(dateEntry + "        " + newEntry + "        " + repsEntry);
                    }
                    else if(hasUserWeight) {
                        AddUserData(dateEntry + "      " + newEntry);
                    }
                    else if(hasSquat){
                        AddSquatData(dateEntry + "      " + newEntry + "      " + repsEntry);
                    }
                    else if(hasDeadlift){
                        AddDeadliftData(dateEntry + "      " + newEntry + "      " + repsEntry);
                    }
                    else if (hasOhp){
                        AddOhpData(dateEntry + "    " + newEntry + "      " + repsEntry);
                    }
                    enteredReps.setText("");
                    enteredWeight.setText("");
                    toastMessage("Added to database");
                }
            }
        });

        viewDataBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = new Intent(EnterWeight.this, WeightTracker.class);
                if(hasBench) {
                    i.putExtra("benchWeight", "benchWeight");
                }
                else if(hasUserWeight){
                    i.putExtra("userWeight", "userWeight");
                }
                else if(hasSquat){
                    i.putExtra("squatWeight", "squatWeight");
                }
                else if(hasDeadlift) {
                    i.putExtra("deadliftWeight", "deadliftWeight");
                }
                else if(hasOhp){
                    i.putExtra("ohpWeight", "ohpWeight");
                }
                startActivity(i);
            }
        });
    }

    private void AddOhpData(String newEntry) { ohpDatabaseHelper.addData(newEntry); }

    private void AddDeadliftData(String newEntry) {
        deadliftDataBaseHelper.addData(newEntry);
    }

    public void AddUserData(String newEntry){
        mDatabaseHelper.addData(newEntry);
    }

    public void AddBenchData(String newEntry){
        benchDatabaseHelper.addData(newEntry);
    }

    public void AddSquatData(String newEntry){
        squatDatabaseHelper.addData(newEntry);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
