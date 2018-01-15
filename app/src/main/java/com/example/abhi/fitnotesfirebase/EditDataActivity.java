package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abhi.workoutapp.R;

/**
 * Created by Abhi on 1/1/2018.
 */

public class EditDataActivity extends AppCompatActivity{

    private Button saveBtn, deleteBtn;
    private EditText enteredWeight;

    /*DatabaseHelper mDatabaseHelper;
    BenchDatabaseHelper benchDatabaseHelper;
    SquatDatabaseHelper squatDatabaseHelper;
    DeadliftDatabaseHelper deadliftDatabaseHelper;
    OhpDatabaseHelper ohpDatabaseHelper;*/

    private String selectedItem;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(t);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        saveBtn = (Button)findViewById(R.id.savebtn);
        deleteBtn = (Button)findViewById(R.id.deletebtn);
        enteredWeight = (EditText)findViewById(R.id.enteredweight);

        /*mDatabaseHelper = new DatabaseHelper(this, "userWeight", 1);
        benchDatabaseHelper = new BenchDatabaseHelper(this, "benchWeight", 1);
        squatDatabaseHelper = new SquatDatabaseHelper(this, "squatWeight", 1);
        deadliftDatabaseHelper = new DeadliftDatabaseHelper(this, "deadliftWeight", 1);
        ohpDatabaseHelper = new OhpDatabaseHelper(this, "ohpWeight", 1);*/

        Intent i = getIntent();
        final Bundle extrasBundle = i.getExtras();

        selectedID = i.getIntExtra("id", -1);
        selectedItem = i.getStringExtra("name");

        enteredWeight.setText(selectedItem);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String item = enteredWeight.getText().toString();
                if(item != ""){
                    if(extrasBundle.containsKey("editBench")){
                        //benchDatabaseHelper.updateName(item, selectedID, selectedItem);
                    }
                    else if(extrasBundle.containsKey("editWeight")){
                        //mDatabaseHelper.updateName(item, selectedID, selectedItem);
                    }
                    else if(extrasBundle.containsKey("editSquat")){
                        //squatDatabaseHelper.updateName(item, selectedID, selectedItem);
                    }
                    else if(extrasBundle.containsKey("editDeadlift")){
                        //deadliftDatabaseHelper.updateName(item, selectedID, selectedItem);
                    }
                    else if(extrasBundle.containsKey("editOhp")){
                        //ohpDatabaseHelper.updateName(item, selectedID, selectedItem);
                    }
                    toastMessage("Changes were saved to database");
                }
                else{
                    toastMessage("You must enter a value");
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(extrasBundle.containsKey("editBench")){
                    //benchDatabaseHelper.deleteName(selectedID, selectedItem);
                }
                else if (extrasBundle.containsKey("editWeight")){
                    //mDatabaseHelper.deleteName(selectedID, selectedItem);
                }
                else if (extrasBundle.containsKey("editSquat")){
                    //squatDatabaseHelper.deleteName(selectedID, selectedItem);
                }
                else if (extrasBundle.containsKey("editDeadlift")){
                    //deadliftDatabaseHelper.deleteName(selectedID, selectedItem);
                }
                else if(extrasBundle.containsKey("editOhp")){
                    //ohpDatabaseHelper.deleteName(selectedID, selectedItem);
                }
                enteredWeight.setText("");
                toastMessage("Removed from database");
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
