package com.ronix.aulasugb;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.OnNavigationBlockedListener;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

public class SplashIntroActivity extends IntroActivity {
//Esta clase es la madre, es el centro de la explicacion de la intro al usuario, he aqui los bloques que se
    //le presentan al usuario.
public static final String EXTRA_PERMISSIONS = "EXTRA_PERMISSIONS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        boolean permissions = intent.getBooleanExtra(EXTRA_PERMISSIONS, true);

        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);
        setButtonBackVisible(false);
        setButtonNextVisible(false);
        setButtonCtaVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_TEXT);

        addSlide(new SimpleSlide.Builder()
                .title("Conoce tu universidad")
                .description("Te ayudaremos poco a poco a conocer tu universidad para que puedas guiarte de la mejor manera")
                .image(R.drawable.uno)
                .background(R.color.rojo_light)
                .backgroundDark(R.color.rojo_dark)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("La aplicacion que usaras siempre")
                .description("Si eres nuevo en la UGB no te asustes, puedes consultar todo lo relacionado con tus estudios por medio de esta app")
                .image(R.drawable.edificio_gerardo)
                .background(R.color.rojo_light)
                .backgroundDark(R.color.rojo_dark)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Nuestro objetivo: Que seas una excelencia")
                .description("En la Universidad Gerardo Barrios nos enfoncamos en que seas un profesional de alta calidad dispuesto a mejorar nuestro país y el mundo")
                .image(R.drawable.gerardo_barrios)
                .background(R.color.rojo_light)
                .backgroundDark(R.color.rojo_dark)
                .build());
        final Slide permissionsSlide;
        if (permissions) {
            permissionsSlide = new SimpleSlide.Builder()
                    .title("Solo necesitamos algo más para terminar")
                    .description("Esta aplicacion necesita acceder a tu camara, y otros permisos mas para brindarte un mejor servicio")
                    .background(R.color.rojo_light)
                    .backgroundDark(R.color.rojo_dark)
                    .permissions(new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.WRITE_CONTACTS,
                    Manifest.permission.CALL_PHONE})
                    .build();
            addSlide(permissionsSlide);
        } else {
            permissionsSlide = null;
        }

        addOnNavigationBlockedListener(new OnNavigationBlockedListener() {
            @Override
            public void onNavigationBlocked(int position, int direction) {
                View contentView = findViewById(android.R.id.content);
                if (contentView != null) {
                    Slide slide = getSlide(position);

                    if (slide == permissionsSlide) {
                        Toast.makeText(SplashIntroActivity.this, "Debes conceder los permisos", Toast.LENGTH_LONG)
                                .show();
                    }
                }
            }
        });
    }

}
