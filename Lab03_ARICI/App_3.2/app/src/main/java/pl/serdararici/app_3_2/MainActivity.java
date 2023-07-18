package pl.serdararici.app_3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et1, et2;
    TextView tVFirstNum, tVSecondNum, tvResults, tVAddition, tVSubtraction, tVMultiplication, tVDivision;
    TextView et1Value, et2Value, tVAdditionValue, tVSubtractionValue, tVMultiplicationValue, tVDivisionValue;

    double addition, subtraction, multiplication, division;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.buttonSendData);
        et1 = findViewById(R.id.editTextFirstNumber);
        et2 = findViewById(R.id.editTextSecondNumber);
        tVFirstNum = findViewById(R.id.textViewFirstNumber);
        tVSecondNum = findViewById(R.id.textViewSecondNumber);
        tvResults = findViewById(R.id.textViewResult);
        tVAddition = findViewById(R.id.textViewAdditon);
        tVSubtraction = findViewById(R.id.textViewSubtraction);
        tVMultiplication = findViewById(R.id.textViewMultiplication);
        tVDivision = findViewById(R.id.textViewDivisionValue);
        tVAdditionValue = findViewById(R.id.textViewAdditionValue);
        tVSubtractionValue = findViewById(R.id.textViewSubtractionValue);
        tVMultiplicationValue = findViewById(R.id.textViewMultiplicationValue);
        tVDivisionValue = findViewById(R.id.textViewDivisionValue);
    }

    public void startIntent(View v){
        if (v.getId() == R.id.buttonSendData) {
            double firstNumber = Double.parseDouble(et1.getText().toString());
            double secondNumber = Double.parseDouble(et2.getText().toString());
            Intent i = new Intent(this, SubActivity.class);
            i.putExtra("firstNumber", firstNumber);
            i.putExtra("secondNumber", secondNumber);
            //startActivity(i);
            startActivityForResult(i, REQUEST_CODE);
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent i){
        super.onActivityResult(requestCode, resultCode, i);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            double firstNumber = i.getDoubleExtra("firstNumber", 0);
            double secondNumber = i.getDoubleExtra("secondNumber", 0);
            double addition = i.getDoubleExtra("addition", 0);
            double subtraction = i.getDoubleExtra("subtraction", 0);
            double multiplication = i.getDoubleExtra("multiplication", 0);
            double division = i.getDoubleExtra("division", 0);
            et1.setText(String.valueOf(firstNumber));
            et2.setText(String.valueOf(secondNumber));
            tVAdditionValue.setText(String.valueOf(addition));
            tVSubtractionValue.setText(String.valueOf(subtraction));
            tVMultiplicationValue.setText(String.valueOf(multiplication));
            tVDivisionValue.setText(String.valueOf(division));
        }
    }



}