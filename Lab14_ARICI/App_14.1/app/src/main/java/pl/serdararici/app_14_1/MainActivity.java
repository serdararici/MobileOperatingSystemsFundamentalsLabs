package pl.serdararici.app_14_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static TextView tv1;
    static EditText et1,et2;
    static Button b;
    SmsManager smsManager = null;
    static String phoneNumber, SMSBody;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        et1 = findViewById(R.id.editTextTextMultiLine);
        et2 = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.buttonSend);

        int RECEIVE_SMS = 123;
        int hasPermission =
                checkSelfPermission(android.Manifest.permission.RECEIVE_SMS);
        String[] permissions = new String[]
                {android.Manifest.permission.RECEIVE_SMS};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, RECEIVE_SMS);
        }


        smsManager = SmsManager.getDefault();
        int SEND_SMS = 123;
        int hasPermissionSend =
                checkSelfPermission(android.Manifest.permission.SEND_SMS);
        String[] permissionsSend = new String[] {android.Manifest.permission.SEND_SMS};
        if (hasPermissionSend != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissionsSend, SEND_SMS);
        }
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                smsManager.sendTextMessage(et2.getText().toString(), null,
                        et1.getText().toString(), null, null);
                Toast.makeText(getApplicationContext(), "Message sent!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void setSmsDetails(String number, String body) {
        phoneNumber = number;
        SMSBody = body;
        tv1.setText("FROM: " + phoneNumber + "\n" + "SMS: " + SMSBody);
    }
}