package pl.serdararici.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton speak;
    EditText editText;
    TTSManager ttsManager = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager();
        ttsManager.init(this);
        editText = findViewById(R.id.editText);
        speak = findViewById(R.id.speakButton);
        speak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = editText.getText().toString();
                ttsManager.initQueue(text);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}