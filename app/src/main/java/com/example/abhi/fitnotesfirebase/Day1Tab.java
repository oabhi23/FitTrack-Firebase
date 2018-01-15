package com.example.abhi.fitnotesfirebase; /**
 * Created by Abhi on 12/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.abhi.workoutapp.R;

public class Day1Tab extends Fragment{

    private TextView bench1;
    private TextView incline1;
    private TextView bentrow;
    private TextView latdown;
    private TextView ohp;
    private TextView curl1;
    private TextView tricepcable;

    private CheckBox cbBench;
    private boolean isBenchChecked = false;

    public static final String EXERCISE = "exercise";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day1, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        bench1 = getView().findViewById(R.id.bench1);
        incline1 = getView().findViewById(R.id.incline1);
        bentrow = getView().findViewById(R.id.bentrow);
        latdown = getView().findViewById(R.id.latdown);
        ohp = getView().findViewById(R.id.ohp);
        curl1 = getView().findViewById(R.id.curl1);
        tricepcable = getView().findViewById(R.id.tricepcable);


        cbBench = getView().findViewById(R.id.checkBox);

        cbBench.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(cbBench.isChecked()){
                    isBenchChecked = true;
                } else{
                    isBenchChecked = false;
                }
            }
        });

        bench1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("bench1", EXERCISE);
                i.putExtra("boolBench", isBenchChecked);
                getActivity().startActivity(i);
            }
        });
        incline1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("incline1", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        bentrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("bentRow", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        latdown.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("latDown", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        ohp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("ohp", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        curl1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("curl", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        tricepcable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("tricepCable1", EXERCISE);
                getActivity().startActivity(i);
            }
        });
    }
}
