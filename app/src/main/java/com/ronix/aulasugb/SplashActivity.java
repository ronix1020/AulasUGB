package com.ronix.aulasugb;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ronix.aulasugb.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {


    //esta clase lo que hace es hacer la accion del contador del pre splashscreen para despues mostrar
    //un layout que lo hara pasar con ayuda de handler y callback. Como una especie de contenedor.
    private final Handler waitHandler = new Handler();
    private final Runnable waitCallback = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, CardView.class);
            startActivity(intent);
            finish();
        }
    };

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        //Fake wait 2s to simulate some initialization on cold start (never do this in production!)
        waitHandler.postDelayed(waitCallback, 1000);
    }

    @Override
    protected void onDestroy() {
        waitHandler.removeCallbacks(waitCallback);
        super.onDestroy();
    }
}
