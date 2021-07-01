package com.jalilasif.mc_jalilasif_192021.SQL;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jalilasif.mc_jalilasif_192021.R;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Objects.requireNonNull(getSupportActionBar()).hide();

        getSupportFragmentManager().beginTransaction().add(R.id.container,new addfrag()).commit();

    }

}