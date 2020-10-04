package com.example.mad_y2s2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MonthlyChart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_monthly_chart, container, false);
        //get graph from the layout
        GraphView graph = (GraphView) view.findViewById(R.id.graph);


        int week1 = 5;
        int week2 = 3;
        int week3 = 2;
        int week4 = 6;

        //from series
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, week1),
                new DataPoint(2, week2),
                new DataPoint(3, week3),
                new DataPoint(4, week4)
        });
        graph.addSeries(series);
        return view;


    }
}