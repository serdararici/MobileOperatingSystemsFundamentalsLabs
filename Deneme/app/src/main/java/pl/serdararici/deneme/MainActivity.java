package pl.serdararici.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et1, et2;
    TextView tVFirstNum, tVSecondNum, tvResults, tVAddition, tVSubtraction, tVMultiplication, tVDivision;

    int addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startIntent(View v) {
        if (v.getId() == R.id.buttonSendData) {
            int firstNumber = Integer.parseInt(et1.getText().toString());
            int secondNumber = Integer.parseInt(et2.getText().toString());
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("firstNumber", firstNumber);
            i.putExtra("secondNumber", secondNumber);
            startActivity(i);
        } else {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.pollub.pl/"));
            startActivity(i);
        }
    }
}