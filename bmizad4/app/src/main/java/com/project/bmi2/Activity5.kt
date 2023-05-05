package com.project.bmi2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.helper.StaticLabelsFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class Activity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5)
        val graph = findViewById<View>(R.id.graph) as GraphView
        val staticLabelsFormatter = StaticLabelsFormatter(graph)
        val series = LineGraphSeries(arrayOf(
                DataPoint(0.0, 22.0),
                DataPoint(1.0, 22.5),
                DataPoint(1.0, 23.0),
                DataPoint(2.0, 23.5),
                DataPoint(2.0, 24.0),
                DataPoint(3.0, 24.5),
                DataPoint(4.0, 25.0)))
        graph.addSeries(series)
        staticLabelsFormatter.setHorizontalLabels(arrayOf("01-04-2023", "01-05-2023", "01-06-2023"))
        graph.gridLabelRenderer.labelFormatter = staticLabelsFormatter
        series.color = Color.rgb(0, 50, 20)
        series.isDrawDataPoints = true
        series.dataPointsRadius = 15f
        series.thickness = 15
        graph.addSeries(series)
        graph.title = "BMI progress"
        graph.titleTextSize = 50f
        graph.titleColor = Color.BLACK
        graph.legendRenderer.isVisible = true
        graph.legendRenderer.align = LegendRenderer.LegendAlign.TOP
        val gridLabel = graph.gridLabelRenderer
        gridLabel.horizontalAxisTitle = "X TIME"
        gridLabel.verticalAxisTitle = "Y YOUR BMI"
    }
}