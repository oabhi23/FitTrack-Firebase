package com.example.abhi.fitnotesfirebase; /**
 * Created by Abhi on 12/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abhi.workoutapp.R;

public class Day2Tab extends Fragment{

    private TextView squat1;
    private TextView deadlift;
    private TextView legCurl1;
    private TextView legPress;
    private TextView calfPress1;

    public static final String EXERCISE = "exercise";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day2, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        squat1 = getView().findViewById(R.id.squat1);
        deadlift = getView().findViewById(R.id.deadlift);
        legCurl1 = getView().findViewById(R.id.legcurl);
        legPress = getView().findViewById(R.id.legpress);
        calfPress1 = getView().findViewById(R.id.standingcalf);


        squat1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("squat1", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        deadlift.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("deadlift", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        legCurl1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("legCurl1", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        legPress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("legPress", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        calfPress1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("calfPress1", EXERCISE);
                getActivity().startActivity(i);
            }
        });
    }
}
