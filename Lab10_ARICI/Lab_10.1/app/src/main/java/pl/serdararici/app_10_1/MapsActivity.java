package pl.serdararici.app_10_1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pl.serdararici.app_10_1.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button buttonCity1 = findViewById(R.id.button_city1);
        Button buttonCity2 = findViewById(R.id.button_city2);
        Button buttonCity3 = findViewById(R.id.button_city3);

        buttonCity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityOnMap(city1Latitude, city1Longitude, R.drawable.city1_flag);
            }
        });

        buttonCity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityOnMap(city2Latitude, city2Longitude, R.drawable.city2_flag);
            }
        });

        buttonCity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityOnMap(city3Latitude, city3Longitude, R.drawable.city3_flag);
            }
        });
    }

    private void showCityOnMap(double latitude, double longitude, int flagResourceId) {
        LatLng cityLatLng = new LatLng(latitude, longitude);

        mMap.clear(); // Clear any existing markers

        MarkerOptions markerOptions = new MarkerOptions()
                .position(cityLatLng)
                .icon(BitmapDescriptorFactory.fromResource(flagResourceId));
        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cityLatLng));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}