package pl.serdararici.app_2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText et1, et2;
    TextView tv1;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.buttonCalculate);
        et1 = findViewById(R.id.editTextNumber1);
        et2 = findViewById(R.id.editTextNumber2);
        tv1 = findViewById(R.id.textViewSolution);
        rb1 = findViewById(R.id.addition);
        rb2 = findViewById(R.id.subtraction);
        rb3 = findViewById(R.id.multiplication);
        rb4 = findViewById(R.id.division);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();
            }
        });

    }


    public void calculate(){
        if (rb1.isChecked()) {
            int n1 = Integer.parseInt(et1.getText().toString());
            int n2 = Integer.parseInt(et2.getText().toString());
            int result =n1 + n2;

            tv1.setText("Sum = " + result);
        }
        else if (rb2.isChecked()) {
            int n1 = Integer.parseInt(et1.getText().toString());
            int n2 = Integer.parseInt(et2.getText().toString());
            int result =n1 - n2;

            tv1.setText("Difference = " + result);
        } else if (rb3.isChecked()) {
            int n1 = Integer.parseInt(et1.getText().toString());
            int n2 = Integer.parseInt(et2.getText().toString());
            int result =n1 * n2;

            tv1.setText("Product = " + result);
        } else if (rb4.isChecked()) {
            int n1 = Integer.parseInt(et1.getText().toString());
            int n2 = Integer.parseInt(et2.getText().toString());
            if(n2!=0) {
                int result = n1 / n2;

                tv1.setText("Quotient = " + result);
            }
            else{
                Toast.makeText(this, "You can not divide zero. Change the number.",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            tv1.setTypeface(null, Typeface.NORMAL);
        }
        //tv2.setText(et3.getText());
    }

}