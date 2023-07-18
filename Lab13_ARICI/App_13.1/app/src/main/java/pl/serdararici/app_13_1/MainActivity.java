package pl.serdararici.app_13_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView imageView;
    private int currentImageIndex = 0;
    private String[] imageFiles = {"img01", "img02", "img03"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        displayImage(currentImageIndex);
    }

    public void onNextButtonClick(View view) {
        currentImageIndex = (currentImageIndex + 1) % imageFiles.length;
        displayImage(currentImageIndex);
    }

    public void onPreviousButtonClick(View view) {
        currentImageIndex = (currentImageIndex - 1 + imageFiles.length) % imageFiles.length;
        displayImage(currentImageIndex);
    }

    private void displayImage(int index) {
        int resourceId = getResources().getIdentifier(imageFiles[index], "drawable", getPackageName());
        imageView.setImageResource(resourceId);
    }
}