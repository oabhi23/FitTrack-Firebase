package com.example.abhi.workoutapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Abhi on 1/1/2018.
 */

public class WeightTracker extends AppCompatActivity {

    private boolean hasBench = false;
    private boolean hasSquat = false;
    private boolean hasDeadlift = false;
    private boolean hasOhp = false;

    DatabaseHelper mDatabaseHelper;
    BenchDatabaseHelper benchDatabaseHelper;
    SquatDatabaseHelper squatDatabaseHelper;
    DeadliftDatabaseHelper deadliftDatabaseHelper;
    OhpDatabaseHelper ohpDatabaseHelper;

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

        Intent i = getIntent();
        Bundle extrasBundle = i.getExtras();

        if(extrasBundle.containsKey("benchWeight")) {
            benchDatabaseHelper = new BenchDatabaseHelper(this, "benchWeight", 1);
            hasBench = true;
        }
        else if(extrasBundle.containsKey("squatWeight")){
            squatDatabaseHelper = new SquatDatabaseHelper(this, "squatWeight", 1);
            hasSquat = true;
        }
        else if(extrasBundle.containsKey("deadliftWeight")){
            deadliftDatabaseHelper = new DeadliftDatabaseHelper(this, "deadliftWeight", 1);
            hasDeadlift = true;
        }
        else if(extrasBundle.containsKey("ohpWeight")){
            ohpDatabaseHelper = new OhpDatabaseHelper(this, "ohpWeight", 1);
            hasOhp = true;
        }
        else{
            mDatabaseHelper = new DatabaseHelper(this, "userWeight", 1);
        }
        populateListView(hasBench, hasSquat, hasDeadlift, hasOhp);
    }

    private void populateListView(final boolean bench, final boolean squat, final boolean deadlift, final boolean ohp){

        Cursor data;
        if(bench){
            data = benchDatabaseHelper.getData();
        } else if(squat){
            data = squatDatabaseHelper.getData();
        } else if (deadlift){
            data = deadliftDatabaseHelper.getData();
        } else if(ohp){
            data = ohpDatabaseHelper.getData();
        } else{
            data = mDatabaseHelper.getData();
        }
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(1));
        }
        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();

                Cursor data;
                if(bench){
                    data = benchDatabaseHelper.getItemID(name);
                } else if(squat){
                    data = squatDatabaseHelper.getItemID(name);
                } else if (deadlift){
                    data = deadliftDatabaseHelper.getItemID(name);
                } else if(ohp){
                    data = ohpDatabaseHelper.getItemID(name);
                } else{
                    data = mDatabaseHelper.getItemID(name);
                }

                int itemID = -1;

                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }

                if(itemID > -1){
                    Intent editScreenIntent = new Intent(WeightTracker.this, EditDataActivity.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);

                    if(bench){
                        editScreenIntent.putExtra("editBench", "editBench");
                    } else if(squat){
                        editScreenIntent.putExtra("editSquat", "editSquat");
                    } else if (deadlift){
                        editScreenIntent.putExtra("editDeadlift", "editDeadlift");
                    } else if(ohp){
                        editScreenIntent.putExtra("editOhp", "editOhp");
                    } else{
                        editScreenIntent.putExtra("editWeight", "editWeight");
                    }
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that name");
                }
            }
        });
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
