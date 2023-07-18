package pl.serdararici.popularcontrols;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2;
    EditText et1, et2, et3;
    TextView tv1, tv2;
    ImageButton ib1, ib2;
    ToggleButton tb1;
    Switch sw1;
    ImageView iv1;
    RadioButton rb1, rb2;
    CheckBox cb1, cb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        et1 = findViewById(R.id. editText);
        et2 = findViewById(R.id. editText2);
        tv1 = findViewById(R.id.textView);

        ib1 = findViewById(R.id.imageButton);
        ib2 = findViewById(R.id.imageButton2);
        tb1 = findViewById(R.id.toggleButton);
        sw1 = findViewById(R.id.switch1);
        iv1 = findViewById(R.id.imageView);

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        sw1.setOnClickListener(this);
        tb1.setOnClickListener(this);

        b2 = findViewById(R.id.button2);
        et3 = findViewById(R.id. editText3);
        tv2 = findViewById(R.id.textView2);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rewriteText();
            }
        });
    }

    public void add(View v) {
        float x = Float.parseFloat(et1.getText().toString());
        float y = Float.parseFloat(et2.getText().toString());
        float sum = x + y;
        tv1.setText("SUM = " + String.valueOf(sum));
    }

    public void onClick(View v) {
        if (v.equals(ib1)) {
            iv1.setImageResource(R.drawable.logo1);
        } else if (v.equals(ib2)) {
            iv1.setImageResource(R.drawable.logo2);
        } else if (v.equals(sw1)) {
            if (sw1.isChecked()) {
                iv1.setVisibility(View.VISIBLE);
            } else {
                iv1.setVisibility(View.INVISIBLE);
            }
        } else if (v.equals(tb1)) {
            if (tb1.isChecked()) {
                Toast.makeText(this, "ToggleButton is ON",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "ToggleButton is OFF",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    public void rewriteText(){
        if (rb1.isChecked()) {
            tv2.setTextColor(Color.rgb(0,255,0));
        } else {
            tv2.setTextColor(Color.rgb(0,0,255));
        }
        if (cb1.isChecked() && cb2.isChecked()) {
            tv2.setTypeface(null, Typeface.BOLD_ITALIC);
        } else if (cb1.isChecked() && !cb2.isChecked()) {
            tv2.setTypeface(null, Typeface.BOLD);
        } else if (!cb1.isChecked() && cb2.isChecked()) {
            tv2.setTypeface(null, Typeface.ITALIC);
        } else {
            tv2.setTypeface(null, Typeface.NORMAL);
        }
        tv2.setText(et3.getText());
    }



}