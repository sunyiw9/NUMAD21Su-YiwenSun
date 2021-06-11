package edu.neu.madcourse.numad21su_yiwensun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements LocationListener {

    Button location;
    TextView textView1;
    TextView textView2;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        location = findViewById(R.id.locatorID);

        location.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity4.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity4.this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, 1);
                }else{
                    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 0, MainActivity4.this);
                }
            }
        });
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        textView1 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView4);

        textView1.setText("Latitude: " + location.getLatitude());
        textView2.setText("Longtitude: " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}