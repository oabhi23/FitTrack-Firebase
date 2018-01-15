package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhi.workoutapp.R;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifTextView;

import static com.example.abhi.workoutapp.R.drawable.benchgif;

/**
 * Created by Abhi on 12/29/2017.
 */

public class Info extends AppCompatActivity {

    private boolean hasBench;
    private boolean hasIncline;
    private boolean hasBentRow;
    private boolean hasLatDown;
    private boolean hasOhp;
    private boolean hasCurl;
    private boolean hasTricepCable;

    private boolean hasSquat;
    private boolean hasDeadlift;
    private boolean hasLegCurl;
    private boolean hasLegPress;
    private boolean hasCalfPress;

    private boolean hasCableRow;
    private boolean hasLateralRaise;

    private boolean hasLegExtension;
    private boolean hasSeatedCalfPress;

    private TextView exerciseName;
    private TextView sets;
    private TextView reps;
    private GifTextView formgif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar6);
        setSupportActionBar(t);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        exerciseName = (TextView)findViewById(R.id.exercise);
        reps = (TextView)findViewById(R.id.reps);
        sets = (TextView)findViewById(R.id.sets);
        formgif = (GifTextView)findViewById(R.id.formgif);

        Intent i = getIntent();
        Bundle extrasBundle = i.getExtras();

        if(!extrasBundle.isEmpty()){
            hasBench = extrasBundle.containsKey("bench1") || extrasBundle.containsKey("bench2");
            hasIncline = extrasBundle.containsKey("incline1") || extrasBundle.containsKey("incline2");
            hasBentRow = extrasBundle.containsKey("bentRow");
            hasLatDown = extrasBundle.containsKey("latDown");
            hasOhp = extrasBundle.containsKey("ohp");
            hasCurl = extrasBundle.containsKey("curl1") || extrasBundle.containsKey("curl2");
            hasTricepCable = extrasBundle.containsKey("tricepCable1") || extrasBundle.containsKey("tricepCable2");

            hasSquat = extrasBundle.containsKey("squat1") || extrasBundle.containsKey("squat2");
            hasDeadlift = extrasBundle.containsKey("deadlift");
            hasLegCurl = extrasBundle.containsKey("legCurl1") || extrasBundle.containsKey("legCurl2");
            hasLegPress = extrasBundle.containsKey("legPress");
            hasCalfPress = extrasBundle.containsKey("calfPress1") || extrasBundle.containsKey("calfPress2");

            hasCableRow = extrasBundle.containsKey("cableRow");
            hasLateralRaise = extrasBundle.containsKey("lateralRaise");

            hasLegExtension = extrasBundle.containsKey("legExtension");
            hasSeatedCalfPress = extrasBundle.containsKey("seatedCalfPress");
        }
        if(hasBench){
            exerciseName.setText("Barbell Bench Press");
            if(extrasBundle.containsKey("bench1")){
                sets.setText("5");
                reps.setText("5");
            } else {
                sets.setText("3");
                reps.setText("10");
            }
            formgif.setBackgroundResource(R.drawable.benchgif);
        }
        else if(hasIncline){
            exerciseName.setText("Incline Bench Press");
            sets.setText("3");
            reps.setText("8");
            formgif.setBackgroundResource(R.drawable.inclinegif);
        }
        else if(hasBentRow){
            exerciseName.setText("Dumbell Row");
            sets.setText("2");
            reps.setText("8");
            formgif.setBackgroundResource(R.drawable.dumbbellrow);
        }
        else if(hasLatDown){
            exerciseName.setText("Lat Pull Down");
            sets.setText("3");
            reps.setText("10");
            formgif.setBackgroundResource(R.drawable.latdowngif);
        }
        else if(hasOhp){
            exerciseName.setText("Overhead Press");
            sets.setText("3");
            reps.setText("8");
            formgif.setBackgroundResource(R.drawable.ohpgif);
        }
        else if(hasCurl){
            exerciseName.setText("Barbell Curl");
            if(extrasBundle.containsKey("curl1")) {
                sets.setText("3");
                reps.setText("10");
            } else {
                sets.setText("3");
                reps.setText("12");
            }
            formgif.setBackgroundResource(R.drawable.curlgif);
        }
        else if(hasTricepCable){
            exerciseName.setText("Tricep Cable Extension");
            if(extrasBundle.containsKey("tricepCable1")) {
                sets.setText("3");
                reps.setText("10");
            } else {
                sets.setText("3");
                reps.setText("12");
            }
            formgif.setBackgroundResource(R.drawable.tcegif);
        }
        else if(hasSquat){
            exerciseName.setText("Squat");
            if(extrasBundle.containsKey("squat1")){
                sets.setText("5");
                reps.setText("5");
            } else{
                sets.setText("3");
                reps.setText("10");
            }
            formgif.setBackgroundResource(R.drawable.squatgif);
        }
        else if(hasDeadlift){
            exerciseName.setText("Deadlift");
            sets.setText("3");
            reps.setText("5");
            formgif.setBackgroundResource(R.drawable.deadliftgif);
        }
        else if(hasLegCurl){
            exerciseName.setText("Leg Curl");
            if(extrasBundle.containsKey("legCurl1")){
                sets.setText("3");
                reps.setText("8");
            } else{
                sets.setText("3");
                reps.setText("10");
            }
            formgif.setBackgroundResource((R.drawable.legcurlgif));
        }
        else if(hasLegPress){
            exerciseName.setText("Leg Press");
            sets.setText("3");
            reps.setText("10");
            formgif.setBackgroundResource((R.drawable.legpressgif));
        }
        else if(hasCalfPress){
            exerciseName.setText("Standing Calf Press");
            if(extrasBundle.containsKey("calfPress1")){
                sets.setText("3");
                reps.setText("10");
            } else{
                sets.setText("3");
                reps.setText("12");
            }
            formgif.setBackgroundResource(R.drawable.standingcalfpressgif);
        }
        else if(hasCableRow){
            exerciseName.setText("Cable Row");
            sets.setText("3");
            reps.setText("10");
            formgif.setBackgroundResource(R.drawable.cablerowgif);
        }
        else if(hasLateralRaise){
            exerciseName.setText("Dumbbell Lateral Raise");
            sets.setText("3");
            reps.setText("10");
            formgif.setBackgroundResource(R.drawable.lateralraisegif);
        }
        else if(hasSeatedCalfPress){
            exerciseName.setText("Seated Calf Press");
            sets.setText("3");
            reps.setText("15");
            formgif.setBackgroundResource(R.drawable.calfpressgif);
        }
        else if(hasLegExtension){
            exerciseName.setText("Leg Extension");
            sets.setText("3");
            reps.setText("8");
            formgif.setBackgroundResource(R.drawable.legextensiongif);
        }

        formgif.getLayoutParams().height = 700;
        formgif.getLayoutParams().width = 900;
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
