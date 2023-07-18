package pl.serdararici.app_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonNext;
    TextView tvNumber;
    int  number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = findViewById(R.id.buttonNext);
        tvNumber = findViewById((R.id.textViewNumber));

        number = getIntent().getIntExtra("number", 0);
        tvNumber.setText(String.valueOf(number));

    }

    public void startIntent(View v) {
        if (v.getId() == R.id.buttonNext) {
            number = Integer.parseInt(tvNumber.getText().toString());
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("number", number+1);
            startActivity(i);
        }
    }

}