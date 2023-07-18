package pl.serdararici.app_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    RadioGroup rg;
    RadioButton rb1, rb2, rb3;
    ImageButton ib1, ib2, ib3;
    MediaPlayer mp;
    double startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.RadioGroup);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        ib1 = findViewById(R.id.imageButtonPause);
        ib2 = findViewById(R.id.imageButtonPlay);
        ib3 = findViewById(R.id.imageButtonStop);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
    }
    public void onClick(View v) {

        if (v.equals(ib1)) {
            if (mp != null && mp.isPlaying()) {
                startTime = mp.getCurrentPosition();
                mp.pause();
            }
        } else if (v.equals(ib2)) {
            if (mp == null) {
                if (rb1.isChecked()) {
                    mp = MediaPlayer.create(this, R.raw.sara_perche_ti_amo);
                } else if (rb2.isChecked()) {
                    mp = MediaPlayer.create(this, R.raw.cheri_cheri_lady);
                } else if (rb3.isChecked()) {
                    mp = MediaPlayer.create(this, R.raw.me_gustas_tu);
                }
            }
            else{
                mp = null;
                Toast.makeText(this, "You need to choose a song!.",
                        Toast.LENGTH_LONG).show();
            }

            if (!mp.isPlaying()) {
                mp.seekTo((int) startTime);
                mp.start();
            }
        } else {
            if (mp != null && mp.isPlaying()) {
                startTime = 0;
                mp.stop();
                mp = null;
            }
        }
    }
}