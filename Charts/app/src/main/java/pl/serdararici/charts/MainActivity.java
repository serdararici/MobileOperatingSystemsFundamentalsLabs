package pl.serdararici.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.buttonLine);
        b2 = findViewById(R.id.buttonBar);
    }

    public void openActivity() {
        Intent intent = new Intent(this, LineChart.class);
        startActivity(intent);
    }

    public void drawChart(View view)
    {
        openActivity();
    }

}