package pl.serdararici.app_14_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1, tv2, tv3, tv4;
    SensorManager sensorManager;
    Sensor accelerometer;
    SmsManager smsManager = null;
    float [] values;
    float x, y, z;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        smsManager = SmsManager.getDefault();
        int SEND_SMS = 123;
        int hasPermission =
                checkSelfPermission(android.Manifest.permission.SEND_SMS);
        String[] permissions = new String[] {android.Manifest.permission.SEND_SMS};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, SEND_SMS);
        }
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            values = event.values;
            x = values[0];
            y = values[1];
            z = values[2];
            float acceleration = (x * x + y * y + z * z) /
                    (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            if (acceleration > 2.5) {
                tv1.setText("UWAGA UWAGA !!!");
                smsManager.sendTextMessage("emulator-5554" , null,
                        "UWAGA!! Acceleration is high.", null, null);
                smsManager.sendTextMessage("emulator-5556" , null,
                        "UWAGA!! Acceleration is high.", null, null);
                Toast.makeText(getApplicationContext(), "Message sent!",
                        Toast.LENGTH_LONG).show();
            }
        }
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
