package pl.serdararici.app_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    Button buttonNext;
    TextView tvNumber;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonNext = findViewById(R.id.buttonNext3);
        tvNumber = findViewById((R.id.textViewNumber3));

        number = getIntent().getIntExtra("number", 0);
        tvNumber.setText(String.valueOf(number));

    }

    public void thirdIntent(View v){
        if(v.getId() == R.id.buttonNext3) {
            number = Integer.parseInt(tvNumber.getText().toString());
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("number", number+1);
            startActivity(i);
        }
    }

}