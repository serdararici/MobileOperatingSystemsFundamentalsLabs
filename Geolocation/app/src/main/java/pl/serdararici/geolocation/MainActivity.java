package pl.serdararici.geolocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        LocationListener {
    TextView latitude, longitude;
    String provider, locationProvider;
    LocationManager locationManager;
    Location location, lastKnownLocation;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latitude = findViewById(R.id.tvLatitude);
        longitude = findViewById(R.id.tvLongitude);
        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, true);
        locationProvider = LocationManager.GPS_PROVIDER;
    }
    // Requesting updates at startup
    protected void onResume() {
        super.onResume();
        int ACCESS_FINE_LOCATION = 123;
        int hasPermission = checkSelfPermission(android.Manifest.permission.
                ACCESS_FINE_LOCATION);
        String[] permissions = new String[] {android.Manifest.permission.
                ACCESS_FINE_LOCATION};
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions, ACCESS_FINE_LOCATION);
        } else {
            location = locationManager.getLastKnownLocation(provider);
            lastKnownLocation =
                    locationManager.getLastKnownLocation(locationProvider);
            locationManager.requestLocationUpdates(provider, 0, 0, this);
            if (location != null) {
                onLocationChanged(location);
            } else {
                latitude.setText("Location not available");
                longitude.setText("Location not available");
            }
        }
    }
    // Removing the LocationListener updates when activity is paused
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }
    public void onLocationChanged(Location location) {
        float lat = (float) location.getLatitude();
        float lng = (float) location.getLongitude();
        latitude.setText("Latitude: " + String.valueOf(lat));
        longitude.setText("Longitude: " + String.valueOf(lng));
    }
    public void onStatusChanged(String provider,int status,Bundle extras){}
    public void onProviderEnabled(String provider) {}
    public void onProviderDisabled(String provider) {}
}
