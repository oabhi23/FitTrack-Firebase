package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhi.workoutapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Abhi on 12/31/2017.
 */

public class EnterWeight extends AppCompatActivity {

    private Button addDataBtn;
    private Button deleteDataBtn;
    private EditText enteredWeight;
    private EditText enteredReps;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private ArrayList<String> dataEntries = new ArrayList<>();
    private ArrayList<String> benchEntries = new ArrayList<>();
    private ArrayList<String> squatEntries = new ArrayList<>();
    private ArrayList<String> deadliftEntries = new ArrayList<>();
    private ArrayList<String> ohpEntries = new ArrayList<>();

    private ArrayList<String> idWeightEntries = new ArrayList<>();
    private ArrayList<String> idBenchEntries = new ArrayList<>();
    private ArrayList<String> idSquatEntries = new ArrayList<>();
    private ArrayList<String> idDeadliftEntries = new ArrayList<>();
    private ArrayList<String> idOhpEntries = new ArrayList<>();

    private ArrayList<String> chosenEntryID = new ArrayList<>();

    private String chosenValue = "";

    private ListView mListView;

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

        mListView = (ListView)findViewById(R.id.listView2);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        addDataBtn = (Button)findViewById(R.id.addbtn);
        deleteDataBtn = (Button)findViewById(R.id.deleteBtn);
        deleteDataBtn.bringToFront();
        enteredWeight = (EditText)findViewById(R.id.enteredweight);
        enteredReps = (EditText)findViewById(R.id.enteredreps);

        Intent i = getIntent();
        Bundle extrasBundle = i.getExtras();

        if(extrasBundle.containsKey("benchWeight")){
            hasBench = true;
            enteredReps.setVisibility(View.VISIBLE);
            chosenValue = "Bench Press Lifts";
        }
        else if(extrasBundle.containsKey("squatWeight")){
            hasSquat = true;
            enteredReps.setVisibility(View.VISIBLE);
            chosenValue = "Squat Lifts";
        }
        else if(extrasBundle.containsKey("deadliftWeight")){
            hasDeadlift = true;
            enteredReps.setVisibility(View.VISIBLE);
            chosenValue = "Deadlifts";
        }
        else if(extrasBundle.containsKey("ohpWeight")){
            hasOhp = true;
            enteredReps.setVisibility(View.VISIBLE);
            chosenValue = "OHP Lifts";
        }
        else{
            hasUserWeight = true;
            chosenValue = "User Weight";
        }

        addDataBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String newEntry = enteredWeight.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                Date date = new Date();
                String dateEntry = dateFormat.format(date).toString();

                SimpleDateFormat dateFormatFirebase = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                Date date1 = new Date();
                String dateEntry1 = dateFormatFirebase.format(date1).toString();
                dateEntry1.replaceAll("\\s+", "");

                if(enteredWeight.length() != 0) {
                    if (hasUserWeight) {
                        myRef.child(chosenValue).child(dateEntry1).setValue(dateEntry + ": " + newEntry);
                        idWeightEntries.add(dateEntry1);
                        //dataEntries.add(newEntry);
                    } else {
                        String repsEntry = enteredReps.getText().toString();
                        myRef.child(chosenValue).child(dateEntry1).setValue(
                                dateEntry + ": " + newEntry + " - " + repsEntry + " rep(s)");

                        if(hasBench){
                            idBenchEntries.add(dateEntry1);
                        } else if(hasSquat){
                            idSquatEntries.add(dateEntry1);
                        } else if(hasDeadlift){
                            idDeadliftEntries.add(dateEntry1);
                        } else if(hasOhp){
                            idOhpEntries.add(dateEntry1);
                        }
                    }
                }
                enteredReps.setText("");
                enteredWeight.setText("");
                toastMessage("Added to database");
            }
        });

        deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasUserWeight) {
                    if (idWeightEntries.size() > 0) {
                        String pushID = myRef.child(chosenValue).child(
                                idWeightEntries.get(idWeightEntries.size() - 1).toString()).getKey();
                        idWeightEntries.remove(idWeightEntries.size() - 1);
                        myRef.child(chosenValue).child(pushID).removeValue();
                        toastMessage("Most recent item deleted");
                    }
                }
                else if (hasBench){
                    if (idBenchEntries.size() > 0) {
                        String pushID = myRef.child(chosenValue).child(
                                idBenchEntries.get(idBenchEntries.size() - 1).toString()).getKey();
                        idBenchEntries.remove(idBenchEntries.size() - 1);
                        myRef.child(chosenValue).child(pushID).removeValue();
                        toastMessage("Most recent item deleted");
                    }
                }
                else if (hasDeadlift){
                    if (idDeadliftEntries.size() > 0) {
                        String pushID = myRef.child(chosenValue).child(
                                idDeadliftEntries.get(idDeadliftEntries.size() - 1).toString()).getKey();
                        idDeadliftEntries.remove(idDeadliftEntries.size() - 1);
                        myRef.child(chosenValue).child(pushID).removeValue();
                        toastMessage("Most recent item deleted");
                    }
                }
                else if (hasSquat){
                    if (idSquatEntries.size() > 0) {
                        String pushID = myRef.child(chosenValue).child(
                                idSquatEntries.get(idSquatEntries.size() - 1).toString()).getKey();
                        idSquatEntries.remove(idSquatEntries.size() - 1);
                        myRef.child(chosenValue).child(pushID).removeValue();
                        toastMessage("Most recent item deleted");
                    }
                }
                else if (hasOhp){
                    if (idOhpEntries.size() > 0) {
                        String pushID = myRef.child(chosenValue).child(
                                idOhpEntries.get(idOhpEntries.size() - 1).toString()).getKey();
                        idOhpEntries.remove(idOhpEntries.size() - 1);
                        myRef.child(chosenValue).child(pushID).removeValue();
                        toastMessage("Most recent item deleted");
                    }
                }
            }
        });

        final ArrayAdapter<String> arrayAdapter;
        if (hasUserWeight){
            arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, dataEntries){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.WHITE);
                    return view;
                }
            };
        }
        else if (hasBench){
            arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, benchEntries){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.WHITE);
                    return view;
                }
            };
        }
        else if (hasSquat){
            arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, squatEntries){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.WHITE);
                    return view;
                }
            };
        }
        else if (hasDeadlift){
            arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, deadliftEntries){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.WHITE);
                    return view;
                }
            };
        }
        else{
            arrayAdapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, ohpEntries){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.WHITE);
                    return view;
                }
            };
        }
        mListView.setAdapter(arrayAdapter);

        myRef.child(chosenValue).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                if(hasUserWeight){
                    dataEntries.add(value);
                } else if(hasBench){
                    benchEntries.add(value);
                } else if (hasSquat){
                    squatEntries.add(value);
                } else if (hasDeadlift){
                    deadliftEntries.add(value);
                } else if (hasOhp){
                    ohpEntries.add(value);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(hasUserWeight){
                    dataEntries.remove(value);
                } else if(hasBench){
                    benchEntries.remove(value);
                } else if (hasSquat){
                    squatEntries.remove(value);
                } else if (hasDeadlift){
                    deadliftEntries.remove(value);
                } else if (hasOhp){
                    ohpEntries.remove(value);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
