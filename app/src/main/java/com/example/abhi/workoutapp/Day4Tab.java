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

public class Day4Tab extends Fragment{

    private TextView squat2;
    private TextView legCurl2;
    private TextView legExtension;
    private TextView seatedCalfPress;
    private TextView calfPress2;

    public static final String EXERCISE = "exercise";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.day4, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        squat2 = getView().findViewById(R.id.squat2);
        legCurl2 = getView().findViewById(R.id.legcurl2);
        legExtension = getView().findViewById(R.id.legext);
        calfPress2 = getView().findViewById(R.id.calfPress2);
        seatedCalfPress = getView().findViewById(R.id.seatedCalfPress);


        squat2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("squat2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        legCurl2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("legCurl2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        legExtension.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("legExtension", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        calfPress2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("calfPress2", EXERCISE);
                getActivity().startActivity(i);
            }
        });
        seatedCalfPress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getActivity(), Info.class);
                i.putExtra("seatedCalfPress", EXERCISE);
                getActivity().startActivity(i);
            }
        });
    }
}
