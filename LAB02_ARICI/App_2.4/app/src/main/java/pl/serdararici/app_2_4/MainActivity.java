package pl.serdararici.app_2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    TextView tvHeading,tvTop, tv_a, tv_b, tv_c, tv_x1, tv_x2;
    EditText et_a, et_b, et_c;
    double a,b,c, discriminant, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.buttonCalculate);
        tvHeading = findViewById(R.id.textViewHeading);
        tvTop = findViewById(R.id.textViewTop);
        tv_a = findViewById(R.id.textView_a);
        tv_b = findViewById(R.id.textView_b);
        tv_c = findViewById(R.id.textView_c);
        tv_x1 = findViewById(R.id.textViewX1);
        tv_x2 = findViewById(R.id.textViewX2);
        et_a = findViewById(R.id.editTextNumber_a);
        et_b = findViewById(R.id.editTextNumber_b);
        et_c = findViewById(R.id.editTextNumber_c);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(et_a.getText().toString().isEmpty() || et_b.getText().toString().isEmpty() || et_c.getText().toString().isEmpty()){
                    tvTop.setText("Please enter all coefficients!");
                }
                else{
                    try {
                        a = Double.parseDouble(String.valueOf(et_a.getText()));
                        b = Double.parseDouble(String.valueOf(et_b.getText()));
                        c = Double.parseDouble(String.valueOf(et_c.getText()));
                        discriminant = (b*b) - (4*a*c);
                        if(discriminant < 0){
                            tvTop.setText("Δ < 0  --> No Real Roots!");
                        }
                        else if (discriminant == 0){
                            tvTop.setText("Δ = 0");
                            x1= -b / (2*a);
                            tv_x1.setText("X1: " + String.valueOf(x1));
                            tv_x2.setText("X2: " + String.valueOf(x1));
                        }
                        else if (discriminant > 0){
                            tvTop.setText("Δ > 0");
                            x1 = (-b + Math.sqrt(discriminant)) / (2*a);
                            x2 = (-b - Math.sqrt(discriminant)) / (2*a);
                            tv_x1.setText("X1: " + String.valueOf(x1));
                            tv_x2.setText("X2: " + String.valueOf(x2));

                        }
                        else{
                            tvTop.setText("Please enter the correct numbers!");
                        }
                    } catch (NumberFormatException nfe) {
                        tvTop.setText("NumberFormat Exception: invalid input string");
                    }

                }
            }
        });

    }
}