package pl.serdararici.app_16_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private static final int MIN_X_VALUE = -10;  // Minimum x value for the graph
    private static final int MAX_X_VALUE = 10;   // Maximum x value for the graph
    private static final int INTERVAL = 1;       // Interval between x values

    private LineGraphSeries<DataPoint> series;
    private double a = 2;  // coefficient 'a' in the quadratic equation
    private double b = 5;  // coefficient 'b' in the quadratic equation
    private double c = 2;  // coefficient 'c' in the quadratic equation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graphView = findViewById(R.id.graph);

        series = new LineGraphSeries<>();
        graphView.addSeries(series);

        // Generate data points for the quadratic equation
        for (double x = MIN_X_VALUE; x <= MAX_X_VALUE; x += INTERVAL) {
            double y = (a * Math.pow(x, 2)) + (b * x) + c;
            series.appendData(new DataPoint(x, y), true, 100, true);
        }
    }
}