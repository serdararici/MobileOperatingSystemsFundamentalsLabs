package pl.serdararici.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class LineChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 2.5),
                new DataPoint(2, 1),
                new DataPoint(3, 4),
                new DataPoint(4, 2.5),
                new DataPoint(5, 5),
                new DataPoint(6, 3),
                new DataPoint(7, 4),
                new DataPoint(8, 2),
                new DataPoint(9, 1.5),
                new DataPoint(10, 3)}
        );
        graph.addSeries(series);
        series.setColor(Color.RED);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(20);
        series.setThickness(10);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(11);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(6);
    }
}