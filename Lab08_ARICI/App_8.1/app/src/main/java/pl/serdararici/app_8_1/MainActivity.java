package pl.serdararici.app_8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private PeopleAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.people_list);
        ArrayList<People> peopleList = new ArrayList<>();
        peopleList.add(new People(R.drawable.norris, "Chuck Norris","chuckie@gmail.com","111222333"));
        peopleList.add(new People(R.drawable.chan, "Jackie Chan","jackie@gmail.com","444555666"));
        peopleList.add(new People(R.drawable.seagal, "Steven Seagal","stevseag@gmail.com", "777888999"));
        cAdapter = new PeopleAdapter(this, peopleList);
        listView.setAdapter(cAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Uri uri = null;
                        if (position == 0) {
                            Toast.makeText(MainActivity.this,
                                    "Your choice is Chuck Norris",Toast.LENGTH_SHORT).show();
                        } else if (position == 1) {
                            Toast.makeText(MainActivity.this,
                                    "Your choice is Jackie Chan",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Your choice is Steven Seagal",Toast.LENGTH_SHORT).show();
                        }
                        //Intent i = new Intent(Intent.ACTION_VIEW, uri);
                        //startActivity(i);
                    }
                });
    }
}