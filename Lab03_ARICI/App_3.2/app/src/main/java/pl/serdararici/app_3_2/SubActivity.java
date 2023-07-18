package pl.serdararici.app_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SubActivity extends AppCompatActivity {

    double firstNumber, secondNumber, addition, subtraction, multiplication, division;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView tvReceivedData = findViewById(R.id.textViewReceivedData);
        TextView tVFirstNumSub = findViewById(R.id.textViewFirstNumberSub);
        TextView tVSecondNumSub = findViewById(R.id.textViewSecondNumberSub);
        TextView tVFirstNumSubValueSub = findViewById(R.id.textViewFirstNumberValueSub);
        TextView tVSecondNumSubValueSub = findViewById(R.id.textViewSecondNumberValueSub);

        firstNumber = getIntent().getDoubleExtra("firstNumber", 0);
        secondNumber = getIntent().getDoubleExtra("secondNumber", 0);
        addition = getIntent().getDoubleExtra("addition", 0);
        subtraction = getIntent().getDoubleExtra("subtraction", 0);
        multiplication = getIntent().getDoubleExtra("multiplication", 0);
        division = getIntent().getDoubleExtra("division", 0);
        tVFirstNumSubValueSub.setText(String.valueOf(firstNumber));
        tVSecondNumSubValueSub.setText(String.valueOf(secondNumber));

    }

    public void finish() {
        Intent i = new Intent();
        i.putExtra("firstNumber", firstNumber);
        i.putExtra("secondNumber", secondNumber);
        //yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age;
        addition = firstNumber + secondNumber;
        subtraction = firstNumber - secondNumber;
        multiplication = firstNumber * secondNumber;
        division = firstNumber / secondNumber;

        i.putExtra("addition", addition);
        i.putExtra("subtraction", subtraction);
        i.putExtra("multiplication", multiplication);
        i.putExtra("division", division);
        setResult(RESULT_OK, i);
        super.finish();
    }

}