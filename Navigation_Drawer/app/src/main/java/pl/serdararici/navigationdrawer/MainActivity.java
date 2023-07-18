package pl.serdararici.navigationdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.activity_main);
        abdt = new ActionBarDrawerToggle(this, dl, 0, 0);
        dl.addDrawerListener(abdt);
        //Synchronizes the state of the app bar button (ActionBarDrawerToggle
        //Returns a reference to object) with the linked DrawerLayout
        abdt.syncState();
        //Returns a reference to object) with the linked DrawerLayout. the app bar button object.
        //Enables the app bar home button.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        //attaches the OnNavigationItemSelected Listener interface to the NavigationView object.
        // This way, the click events on the list items in the drawer are handled.
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                        dl.closeDrawer(Gravity.LEFT);
                        return true;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this,
                                "Settings", Toast.LENGTH_SHORT).show();
                        dl.closeDrawer(Gravity.LEFT);
                        return true;
                    case R.id.mycart:
                        Toast.makeText(MainActivity.this,
                                "My Cart", Toast.LENGTH_SHORT).show();
                        dl.closeDrawer(Gravity.LEFT);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    //Shows and hides the drawer when the user cliks the app bar button.
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}