package com.jalilasif.mc_jalilasif_192021.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jalilasif.mc_jalilasif_192021.R;

import java.util.Objects;

public class Splash extends AppCompatActivity {

    ImageView hover;
    TextView finallab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);

        hover = findViewById(R.id.hover);
        finallab = findViewById(R.id.finallab);
        animations();

        new Handler().postDelayed(() -> {
            Intent i = new Intent(Splash.this,MainActivity.class);
            startActivity(i);
        }, 6000);
    }


    public void animations(){

        Animation scale_animation = AnimationUtils.loadAnimation(this,R.anim.scale_animation);
        hover.startAnimation(scale_animation);

        Animation bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_to_top);
        finallab.startAnimation(bottom_animation);

    }

}