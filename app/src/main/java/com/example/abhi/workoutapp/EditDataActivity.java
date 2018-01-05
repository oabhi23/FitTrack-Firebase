package com.example.abhi.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Abhi on 1/1/2018.
 */

public class EditDataActivity extends AppCompatActivity{

    private Button saveBtn, deleteBtn;
    private EditText enteredWeight;

    DatabaseHelper mDatabaseHelper;

    private String selectedItem;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

        saveBtn = (Button)findViewById(R.id.savebtn);
        deleteBtn = (Button)findViewById(R.id.deletebtn);
        enteredWeight = (EditText)findViewById(R.id.enteredweight);
        mDatabaseHelper = new DatabaseHelper(this);

        Intent i = getIntent();
        selectedID = i.getIntExtra("id", -1);
        selectedItem = i.getStringExtra("name");

        enteredWeight.setText(selectedItem);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String item = enteredWeight.getText().toString();
                if(item != ""){
                    mDatabaseHelper.updateName(item, selectedID, selectedItem);
                    Intent i = new Intent(EditDataActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else{
                    toastMessage("You must enter a value");
                }
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID, selectedItem);
                enteredWeight.setText("");
                Intent i = new Intent(EditDataActivity.this, MainActivity.class);
                startActivity(i);
                toastMessage("Removed from database");
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
