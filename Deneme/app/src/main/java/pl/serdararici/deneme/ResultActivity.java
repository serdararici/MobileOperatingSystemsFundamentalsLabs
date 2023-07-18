package pl.serdararici.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int firstNumber, secondNumber, addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tv1 = findViewById(R.id.textViewFirstNumberValueSub);
        TextView tv2 = findViewById(R.id.textViewSecondNumberValueSub);
        firstNumber = getIntent().getIntExtra("firstNumber",0);
        secondNumber = getIntent().getIntExtra("secondNumber", 0);
        tv1.setText("Hello " + firstNumber);
        tv2.setText("You are " + String.valueOf(age) + " years old");
    }
}