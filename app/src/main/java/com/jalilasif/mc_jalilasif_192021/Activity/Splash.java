package com.jalilasif.mc_jalilasif_192021.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.jalilasif.mc_jalilasif_192021.Activity.MainActivity;
import com.jalilasif.mc_jalilasif_192021.R;

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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
            }
        },3000);
    }
}