package com.mini.solaiman.policedhara.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mini.solaiman.policedhara.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SplashActivity extends AppCompatActivity {
    private static  int timer = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PROTHOMA.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,PartOfBook.class);
                startActivity(intent);
                finish();
            }
        },timer);

    }
}
