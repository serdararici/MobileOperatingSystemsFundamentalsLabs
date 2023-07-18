package pl.serdararici.app_7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView drag, drop;
    TextView total, success;
    int totalCount, successCount;
    AudioAttributes audioAttributes;
    SoundPool mySounds;
    int winSound, loseSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drag = findViewById(R.id.drag);
        drop = findViewById(R.id.drop);
        total = findViewById(R.id.textViewTotal);
        success = findViewById(R.id.textViewSucces);

        audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();
        mySounds = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();
        // load(context, reference, priority)
        winSound = mySounds.load(this, R.raw.win, 1);
        loseSound = mySounds.load(this, R.raw.lose, 1);

        drag.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent arg1) {
                // newPlainText(CharSequence label, CharSequence text)
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow =
                        new View.DragShadowBuilder(drag);
                // startDragAndDrop(data to be dragged, drag shadow, local data, flags)
                v.startDragAndDrop(data, shadow, null, 0);
                return true;
            }
        });
        drop.setOnDragListener(new View.OnDragListener() {
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP: {
                        successCount = successCount + 1;
                        success.setText("Successful drops: " +
                                successCount);
                        mySounds.play(winSound, 0.9f, 0.9f, 1, 0, 1);
                        break;
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        totalCount = totalCount + 1;
                        total.setText("Total drops: " + totalCount);
                        mySounds.play(loseSound, 0.9f, 0.9f, 1, 0, 1);
                        break;
                    }
                }
                return true;
            }
        });
    }
}