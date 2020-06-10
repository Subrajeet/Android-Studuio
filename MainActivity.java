package com.example.leno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //slash screen duration 5 sec
    private static int SPLASH_SCREEN = 5000;

    //anim variables
    Animation topAnim, bottomAnim;
    TextView appName, appSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //no status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        
        appName = findViewById(R.id.app_name);
        appSlogan = findViewById(R.id.slogan_name);

        //anim elements
        appName.setAnimation(topAnim);
        appSlogan.setAnimation(bottomAnim);

        //after splash screen new page opens

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,getStarted.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}