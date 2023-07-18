package pl.serdararici.sendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button b;
    SmsManager smsManager = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editTextTextMultiLine);
        et2 = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.buttonSend);
        smsManager = SmsManager.getDefault();
        int SEND_SMS = 123;
        int hasPermission =
                checkSelfPermission(android.Manifest.permission.SEND_SMS);
        String[] permissions = new String[] {android.Manifest.permission.SEND_SMS};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, SEND_SMS);
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
}