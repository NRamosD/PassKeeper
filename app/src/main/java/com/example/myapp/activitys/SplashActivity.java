package com.example.myapp.activitys;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;

public class SplashActivity extends AppCompatActivity {

    private final int duracion_splash=3000;

        @Override
        public void onCreate(Bundle savedInstaceState){
            super.onCreate(savedInstaceState);
            setContentView(R.layout.activity_splash);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }, duracion_splash);




        }
}
