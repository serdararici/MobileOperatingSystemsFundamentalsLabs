package pl.serdararici.app_11_1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pl.serdararici.app_11_1.R;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private EditText editTextLatitude, editTextLongitude;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        editTextLatitude = findViewById(R.id.editTextLatitude);
        editTextLongitude = findViewById(R.id.editTextLongitude);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    public void showOnMap(View view) {
        String latitudeStr = editTextLatitude.getText().toString();
        String longitudeStr = editTextLongitude.getText().toString();

        if (latitudeStr.isEmpty() || longitudeStr.isEmpty()) {
            return;
        }

        double latitude = Double.parseDouble(latitudeStr);
        double longitude = Double.parseDouble(longitudeStr);

        LatLng location = new LatLng(latitude, longitude);
        map.clear();
        map.addMarker(new MarkerOptions().position(location));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }
}