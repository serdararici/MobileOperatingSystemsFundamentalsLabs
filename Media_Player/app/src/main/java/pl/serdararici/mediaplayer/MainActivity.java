package pl.serdararici.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    ImageButton ib1, ib2, ib3;
    MediaPlayer mp;
    double startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                mp = MediaPlayer.create(this, R.raw.sofia);
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