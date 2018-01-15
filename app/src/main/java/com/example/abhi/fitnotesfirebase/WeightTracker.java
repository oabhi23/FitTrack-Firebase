package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.abhi.workoutapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Abhi on 1/1/2018.
 */

public class WeightTracker extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private boolean hasBench = false;
    private boolean hasSquat = false;
    private boolean hasDeadlift = false;
    private boolean hasOhp = false;

    /*DatabaseHelper mDatabaseHelper;
    BenchDatabaseHelper benchDatabaseHelper;
    SquatDatabaseHelper squatDatabaseHelper;
    DeadliftDatabaseHelper deadliftDatabaseHelper;
    OhpDatabaseHelper ohpDatabaseHelper;*/

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar7);
        setSupportActionBar(t);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mListView = (ListView)findViewById(R.id.listView);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        Intent i = getIntent();
        Bundle extrasBundle = i.getExtras();

        if(extrasBundle.containsKey("benchWeight")) {
            //benchDatabaseHelper = new BenchDatabaseHelper(this, "benchWeight", 1);
            hasBench = true;
        }
        else if(extrasBundle.containsKey("squatWeight")){
            //squatDatabaseHelper = new SquatDatabaseHelper(this, "squatWeight", 1);
            hasSquat = true;
        }
        else if(extrasBundle.containsKey("deadliftWeight")){
            //deadliftDatabaseHelper = new DeadliftDatabaseHelper(this, "deadliftWeight", 1);
            hasDeadlift = true;
        }
        else if(extrasBundle.containsKey("ohpWeight")){
            //ohpDatabaseHelper = new OhpDatabaseHelper(this, "ohpWeight", 1);
            hasOhp = true;
        }
        else{
            //mDatabaseHelper = new DatabaseHelper(this, "userWeight", 1);
        }
        //populateListView(hasBench, hasSquat, hasDeadlift, hasOhp);
    }

    private void populateListView(final boolean bench, final boolean squat,
                                  final boolean deadlift, final boolean ohp, DataSnapshot dataSnapshot){
        for(DataSnapshot ds: dataSnapshot.getChildren()){
        }


    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
