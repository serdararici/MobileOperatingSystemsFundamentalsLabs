package pl.serdararici.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CountryAdapter cAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.countries_list);
        ArrayList<Country> countriesList = new ArrayList<>();
        countriesList.add(new Country(R.drawable.poland, "Poland","Warsaw"));
        countriesList.add(new Country(R.drawable.spain, "Spain","Madrid"));
        countriesList.add(new Country(R.drawable.turkey, "Turkey","Ankara"));
        cAdapter = new CountryAdapter(this, countriesList);
        listView.setAdapter(cAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Uri uri = null;
                        if (position == 0) {
                            uri = Uri.parse("https://en.wikipedia.org/wiki/Poland");
                        } else if (position == 1) {
                            uri = Uri.parse("https://en.wikipedia.org/wiki/Spain");
                        } else {
                            uri = Uri.parse("https://en.wikipedia.org/wiki/Turkey");
                        }
                        Intent i = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(i);
                    }
                });
    }
}