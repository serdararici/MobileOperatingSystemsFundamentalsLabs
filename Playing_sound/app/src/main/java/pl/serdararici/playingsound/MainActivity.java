package pl.serdararici.playingsound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv1;
    AudioAttributes audioAttributes;
    SoundPool mySounds;
    int bugleSound, fluteSound;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = findViewById(R.id.imageViewBugle);
        audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();
        mySounds = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();
        // load(context, reference, priority)
        bugleSound = mySounds.load(this, R.raw.reveille, 1);
        fluteSound = mySounds.load(this, R.raw.rhapsody, 1);
    }
    public void play(View v) {
        // if (v.getId() == R.id.imageView){ or
        if (v.equals(iv1)) {
            // play(index, leftVolume, rightVolume, priority, loop, rate)
            mySounds.play(bugleSound, 0.9f, 0.9f, 1, 0, 1);
        } else {
            mySounds.play(fluteSound, 0.9f, 0.9f, 1, 0, 1);
        }
    }
}