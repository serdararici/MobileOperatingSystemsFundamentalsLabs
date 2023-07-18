package pl.serdararici.app_16_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class MainActivity extends AppCompatActivity {

    private GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graphView = new GraphView(this);
        LinearLayout graphContainer = findViewById(R.id.graphContainer);
        graphContainer.addView(graphView);

        createBarGraph();
    }

    private void createBarGraph() {
        // Create x-axis labels
        int[] xLabels = new int[]{0, 1, 2, 3, 4};

        // Create data tables
        int[] series1Data = new int[]{5, 3, 6, 4, 9};
        int[] series2Data = new int[]{2, 4, 1, 3, 5};

        // Create series
        BarGraphSeries<DataPoint> series1 = new BarGraphSeries<>();
        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>();

        // Loop to initialize DataPoint objects and add them to series
        for (int i = 0; i < xLabels.length; i++) {
            series1.appendData(new DataPoint(xLabels[i], series1Data[i]), true, xLabels.length);
            series2.appendData(new DataPoint(xLabels[i], series2Data[i]), true, xLabels.length);
        }

        // Customize series
        series1.setColor(Color.RED);
        series2.setColor(Color.BLUE);

        // Add series to the graph
        graphView.addSeries(series1);
        graphView.addSeries(series2);
    }
}