package pl.serdararici.app_2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;


public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    TextView tv1;
    EditText et1;
    RadioButton rb1, rb2;
    double number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.buttonConvert);
        b2 = findViewById(R.id.buttonAgain);
        tv1 = findViewById(R.id.textViewAnswer);
        et1 = findViewById(R.id.editTextTemperature);
        rb1 = findViewById(R.id.radioButtonFtoC);
        rb2 = findViewById(R.id.radioButtonCtoF);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()){
                    tv1.setText("Please give temperature!");
                }
                else{
                    number = Double.parseDouble(String.valueOf(et1.getText()));
                    if(rb2.isChecked()){
                        number = (number * 9) / 5 + 32;
                        //number = Double.parseDouble(new DecimalFormat ( "##.###").format(number));
                        tv1.setText(String.valueOf(number) + " Degree F°");
                    }
                    else if (rb1.isChecked()){
                        number = (number - 32) * 5 / 9;
                        //number = Double.parseDouble(new DecimalFormat ( "##.###").format(number));
                        tv1.setText((String.valueOf(number) + " Degree C°"));
                    }
                    else{
                        tv1.setText("Please select an option!");
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv1.setText("0.0");
                et1.setText("");
                rb2.setChecked(false);
                rb1.setChecked(false);
            }
        });

    }
}