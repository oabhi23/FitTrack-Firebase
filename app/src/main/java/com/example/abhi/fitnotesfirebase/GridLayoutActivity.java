package com.example.abhi.fitnotesfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.abhi.workoutapp.R;

/**
 * Created by Abhi on 1/10/2018.
 */

public class GridLayoutActivity extends AppCompatActivity{

    private GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridlayoutactivity);

        mainGrid = (GridLayout)findViewById(R.id.maingrid);

        final CardView cardView1 = (CardView)mainGrid.getChildAt(0);
        cardView1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("You are now viewing your workout");
                Intent i = new Intent(GridLayoutActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        final CardView cardView2 = (CardView)mainGrid.getChildAt(1);
        cardView2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("Track your weight");
                Intent i = new Intent(GridLayoutActivity.this, EnterWeight.class);
                i.putExtra("userWeight", "userWeight");
                startActivity(i);
            }
        });

        final CardView cardView3 = (CardView)mainGrid.getChildAt(2);
        cardView3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("Track your bench press lifts");
                Intent intent = new Intent(GridLayoutActivity.this, EnterWeight.class);
                intent.putExtra("benchWeight", "benchWeight");
                startActivity(intent);
            }
        });

        final CardView cardView4 = (CardView)mainGrid.getChildAt(3);
        cardView4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("Track your squat lifts");
                Intent i = new Intent(GridLayoutActivity.this, EnterWeight.class);
                i.putExtra("squatWeight", "squatWeight");
                startActivity(i);
            }
        });

        final CardView cardView5 = (CardView)mainGrid.getChildAt(4);
        cardView5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("Track your deadlifts");
                Intent i = new Intent(GridLayoutActivity.this, EnterWeight.class);
                i.putExtra("deadliftWeight", "deadliftWeight");
                startActivity(i);
            }
        });

        final CardView cardView6 = (CardView)mainGrid.getChildAt(5);
        cardView6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                toastMessage("Track your overhead press lifts");
                Intent i = new Intent(GridLayoutActivity.this, EnterWeight.class);
                i.putExtra("ohpWeight", "ohpWeight");
                startActivity(i);
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
