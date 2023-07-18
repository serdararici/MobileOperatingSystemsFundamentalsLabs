package pl.serdararici.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    EditText et1, et2;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        et1 = findViewById(R.id.editTextTextName);
        et2 = findViewById(R.id.editTextTextAge);
    }

    public void startIntent(View v){
        if (v.getId() == R.id.button) {
            String name = et1.getText().toString();
            int age = Integer.parseInt(et2.getText().toString());
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("name", name);
            i.putExtra("age", age);
            //startActivity(i);
            startActivityForResult(i, REQUEST_CODE);
        } else {
            Intent i = new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://www.pollub.pl/"));
                //startActivity(i);
                startActivityForResult(i, REQUEST_CODE);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent i){
        super.onActivityResult(requestCode, resultCode, i);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String name = i.getStringExtra("name");
            int year = i.getIntExtra("year", 0);
            Toast.makeText(this, name + ", you were born in " +
                    String.valueOf(year) + " \nor a year earlier",
                    Toast.LENGTH_LONG).show();
        }
    }

}