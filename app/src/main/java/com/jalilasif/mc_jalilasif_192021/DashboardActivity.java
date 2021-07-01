package com.jalilasif.mc_jalilasif_192021;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.jalilasif.mc_jalilasif_192021.Fragment.fraghobby;
import com.jalilasif.mc_jalilasif_192021.Fragment.fraghobby1;

public class DashboardActivity extends AppCompatActivity {

    TextView txtLoc;

    Button btn;

    Button btn1,btn2;

    private FusedLocationProviderClient mfused;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        btn1= findViewById(R.id.hobby1);
        btn2= findViewById(R.id.hobby2);


        btn = findViewById(R.id.button);

        mfused = LocationServices.getFusedLocationProviderClient(this);

        getSupportFragmentManager().beginTransaction().add(R.id.container,new fraghobby()).commit();

        btn1.setOnClickListener(v -> getSupportFragmentManager().beginTransaction().replace(R.id.container,new fraghobby()).commit());
        btn2.setOnClickListener(v -> getSupportFragmentManager().beginTransaction().replace(R.id.container,new fraghobby1()).commit());


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED
                    ){
                        mfused.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<Location> task) {

                                Location location = task.getResult();
                                if(location!=null){
                                    Double lati = location.getLatitude();
                                    Double longi = location.getLongitude();
                                    float acc = location.getAccuracy();

                                    txtLoc.setText("Latitude : " + lati + "\nLongitude : " + longi);

                                    Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                                    intent.putExtra("lati",lati);
                                    intent.putExtra("longi",longi);
                                    startActivity(intent);
                                }

                            }
                        });
                    }

                    else{
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},7);
                    }
                }
            }
        });
    }
}