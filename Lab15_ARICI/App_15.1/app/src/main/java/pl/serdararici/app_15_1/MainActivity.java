package pl.serdararici.app_15_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton apple, pear, plum;
    TTSManager ttsManager = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager();
        ttsManager.init(this);
        apple = findViewById(R.id.imageButtonApple);
        pear = findViewById(R.id.imageButtonPear);
        plum = findViewById(R.id.imageButtonPlum);
        apple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "Elma";
                ttsManager.initQueue(text);
            }
        });

        pear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "Armut";
                ttsManager.initQueue(text);
            }
        });

        plum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = "Erik";
                ttsManager.initQueue(text);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}