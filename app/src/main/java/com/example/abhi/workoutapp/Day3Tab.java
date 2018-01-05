package com.example.abhi.workoutapp; /**
 * Created by Abhi on 12/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Day3Tab extends Fragment {

    private TextView bench2;
    private TextView incline2;
    private TextView cableRow;
    private TextView curl2;
    private TextView lateralRaise;
    private TextView tricepCable2;

    public static final String EXERCISE = "exercise";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day3, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        bench2 = getView().findViewById(R.id.bench2);
        incline2 = getView().findViewById(R.id.incline2);
        cableRow = getView().findViewById(R.id.cableRow);
        curl2 = getView().findViewById(R.id.curl2);
        lateralRaise = getView().findViewById(R.id.lateralRaise);
        tricepCable2 = getView().findViewById(R.id.tricepcable2);


        bench2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("bench2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        incline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("incline2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        cableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("cableRow", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        curl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("curl2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        lateralRaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("lateralRaise", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        tricepCable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("tricepCable2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
    }
}
