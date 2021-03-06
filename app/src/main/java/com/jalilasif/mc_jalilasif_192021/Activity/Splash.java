package com.jalilasif.mc_jalilasif_192021.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jalilasif.mc_jalilasif_192021.DashboardActivity;
import com.jalilasif.mc_jalilasif_192021.R;
import com.jalilasif.mc_jalilasif_192021.SQL.MainActivity3;

public class Splash extends AppCompatActivity {
    ImageView img;
    TextView txt;
    Animation scale, bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img=findViewById(R.id.hover);
        txt=findViewById(R.id.finallab);

        scale= AnimationUtils.loadAnimation(this,R.anim.scale_animation);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom_to_top);

        img.setAnimation(scale);
        txt.setAnimation(bottom);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent i = new Intent(Splash.this, MainActivity3.class);
            startActivity(i);
        },6000);
    }
}