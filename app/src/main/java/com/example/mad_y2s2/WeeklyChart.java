package com.example.mad_y2s2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class WeeklyChart extends Fragment {

    GraphView graph;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_monthly_chart, container, false);
        //get graph from the layout
        GraphView graph = (GraphView) view.findViewById(R.id.graph);


        //from series
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                //new DataPoint(0, 0),
                new DataPoint(10, 5),
                new DataPoint(11, 3),
                new DataPoint(12, 2),
                new DataPoint(13, 5),
                new DataPoint(14, 5),
                new DataPoint(15, 5),
                new DataPoint(16, 3)
        });
        graph.addSeries(series);
        return view;
    }
}