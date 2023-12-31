package pl.serdararici.receivesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView tv1;
    static String phoneNumber, SMSBody;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        int RECEIVE_SMS = 123;
        int hasPermission =
                checkSelfPermission(android.Manifest.permission.RECEIVE_SMS);
        String[] permissions = new String[]
                {android.Manifest.permission.RECEIVE_SMS};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, RECEIVE_SMS);
        }
    }
    public static void setSmsDetails(String number, String body) {
        phoneNumber = number;
        SMSBody = body;
        tv1.setText("FROM: " + phoneNumber + "\n" + "SMS: " + SMSBody);
    }
}