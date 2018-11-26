package com.ronix.aulasugb;

//esta actividad esta en pruebas AUN


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    TextView grabar;
    ImageView grab;

    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*anuncios de Google
        MobileAds.initialize(this, "ca-app-pub-9184762309589310~8876571337");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        */


        grabar = findViewById(R.id.txtGrabarVoz);
        grab = findViewById(R.id.img_btn_hablar);

        grab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActionRecognizeSpeech = new Intent(
                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                // Configura el Lenguaje (Español-México)
                intentActionRecognizeSpeech.putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
                try {
                    startActivityForResult(intentActionRecognizeSpeech,
                            RECOGNIZE_SPEECH_ACTIVITY);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            "Tú dispositivo no soporta el reconocimiento por voz",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);

                    switch (strSpeech2Text){
                        case "aula 30":
                            grabar.setText("Ve a la direccion que se te indica");
                            break;
                        case "aula 40":
                            grabar.setText("No se ha encontrado");
                    }
                    //grabar.setText(strSpeech2Text);
                }
                break;
            default:
                break;
        }
    }
}
