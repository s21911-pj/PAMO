package com.project.bmi2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;

public class Activity5 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 22),
                new DataPoint(1, 22.5),
                new DataPoint(1, 23),
                new DataPoint(2, 23.5),
                new DataPoint(2, 24),
                new DataPoint(3, 24.5),
                new DataPoint(4, 25),

        });
        graph.addSeries(series);

        staticLabelsFormatter.setHorizontalLabels(new String[]{"01-04-2023", "01-05-2023", "01-06-2023"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        series.setColor(Color.rgb(0, 50, 20));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);
        series.setThickness(15);
        graph.addSeries(series);
        graph.setTitle("BMI progress");
        graph.setTitleTextSize(50);
        graph.setTitleColor(Color.BLACK);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        GridLabelRenderer gridLabel = graph.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("X TIME");
        gridLabel.setVerticalAxisTitle("Y YOUR BMI");

    }

}


