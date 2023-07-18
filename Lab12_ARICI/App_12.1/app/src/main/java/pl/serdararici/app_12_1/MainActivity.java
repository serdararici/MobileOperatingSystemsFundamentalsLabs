package pl.serdararici.app_12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1, tv2, tv3;
    SensorManager sensorManager;
    Sensor accelerometer;
    float [] values;
    float x, y, z;
    int shakeCount =0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.shakeCountTextView2);
        tv3 = findViewById(R.id.shakeCountTextView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            values = event.values;
            x = values[0];
            y = values[1];
            z = values[2];
            float acceleration = (x * x + y * y + z * z) /
                    (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            if (acceleration > 1.5) {
                shakeCount++;
                tv3.setText(String.valueOf(shakeCount));
            } else {
                tv3.setText(String.valueOf(shakeCount));
            }
        }
    }
    public void reset (View view){
        shakeCount = 0;
        tv3.setText(String.valueOf(shakeCount));
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    protected void onResume() {
        super.onResume();
        accelerometer =
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}