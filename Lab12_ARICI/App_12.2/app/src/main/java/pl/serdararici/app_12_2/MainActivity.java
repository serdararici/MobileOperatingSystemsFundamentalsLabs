package pl.serdararici.app_12_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int azimuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCompassView compassView = new MyCompassView(this);
        setContentView(compassView);
        compassView.updateData(azimuth);
    }
}