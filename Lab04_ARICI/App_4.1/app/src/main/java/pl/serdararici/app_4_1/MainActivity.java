package pl.serdararici.app_4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tvResult;
    EditText et1;

    double temperature;
    double newTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        tv1 = findViewById(R.id.textViewHead);
        tvResult = findViewById(R.id.textViewResult);
        et1 = findViewById(R.id.editTextValue);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        temperature = Double.parseDouble(String.valueOf(et1.getText()));
        switch (item.getItemId()) {
            case R.id.action_edit:
                et1.setText("");
                tv1.setText("Converting Type");
                tvResult.setText("Result: ");

                return true;
            case R.id.CtoK:
                newTemperature = (temperature + 273.15);
                //number = Double.parseDouble(new DecimalFormat ( "##.###").format(number));
                tv1.setText("Celsius to Kelvin");
                tvResult.setText(String.valueOf(temperature) + " C° = " + String.valueOf(newTemperature) + " K°");
                return true;
            case R.id.CtoF:
                newTemperature = (temperature * 9) / 5 + 32;
                tv1.setText("Celsius to Fahrenheit");
                tvResult.setText(String.valueOf(temperature) + " C° = " + String.valueOf(newTemperature) + " F°");
                return true;
            case R.id.KtoC:
                newTemperature = (temperature - 273.15);
                tv1.setText("Kelvin to Celsius");
                tvResult.setText(String.valueOf(temperature) + " K° = " + String.valueOf(newTemperature) + " C°");
                return true;
            case R.id.KtoF:
                newTemperature = (temperature * 9) / 5 - 459.67;
                tv1.setText("Kelvin to Fahrenheit");
                tvResult.setText(String.valueOf(temperature) + " K° = " + String.valueOf(newTemperature) + " F°");
                return true;
            case R.id.FtoC:
                newTemperature = (temperature - 32) * 5 / 9;
                tv1.setText("Fahrenheit to Celsius");
                tvResult.setText(String.valueOf(temperature) + " F° = " + String.valueOf(newTemperature) + " C°");
                return true;
            case R.id.FtoK:
                newTemperature = (temperature + 459.67) * 5 / 9;
                tv1.setText("Fahrenheit to Kelvin");
                tvResult.setText(String.valueOf(temperature) + " F° = " + String.valueOf(newTemperature) + " K°");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}