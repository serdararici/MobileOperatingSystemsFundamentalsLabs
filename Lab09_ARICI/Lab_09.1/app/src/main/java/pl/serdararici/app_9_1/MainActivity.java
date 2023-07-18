package pl.serdararici.app_9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button b1, b2;
    static int itemSelected;
    static boolean isSelected;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.buttonStart);
        b2 = findViewById(R.id.buttonPause);
        b2 = findViewById(R.id.buttonStop);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    public void onClick(View v) {
        FragmentManager manager = getFragmentManager();
        Fragment fr = manager.findFragmentByTag("addCity");
        Fragment1 fr1 = (Fragment1)
                getFragmentManager().findFragmentById(R.id.list);
        if (v.equals(b1)) {
            if (fr != null) {
                manager.beginTransaction().remove(fr).commit();
            }
            Fragment2 fr2 = new Fragment2();
            fr2.show(manager, "addCity");
        }
        if (v.equals(b2)) {
            if (!fr1.cities.isEmpty()) {
                if (isSelected) {
                    fr1.cities.remove(itemSelected);
                    fr1.adapter.notifyDataSetChanged();
                    itemSelected = 0;
                    isSelected = false;
                    fr1.getListView()
                            .setSelector(android.R.color.transparent);
                } else {
                    Toast.makeText(this, "Select city to be deleted",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}