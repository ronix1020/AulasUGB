package com.ronix.aulasugb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.ArrayList;
import java.util.List;

public class CardView extends AppCompatActivity {

    public static final String PREF_KEY_FIRST_START = "PREF_KEY_FIRST_START";
    public static final int REQUEST_CODE_INTRO = 1;

    /*
    Declarar instancias globales
     */
    private int posicion;
    private String titulo;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        boolean firstStart = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean(PREF_KEY_FIRST_START, true);

        if (firstStart) {
            Intent intent = new Intent(this, SplashIntroActivity.class);
            startActivityForResult(intent, REQUEST_CODE_INTRO);
        }

        // Inicializar Aulas
        List<Aulas> items = new ArrayList<>();

        items.add(new Aulas(R.drawable.oscar_romero, "Aula 3", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 4", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 5", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 6", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 7", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 8", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 9", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 10", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 11", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 12", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 13", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 14", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.oscar_romero, "Aula 15", "Edificio Monseñor Oscar Arnulfo Romero \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 16", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 17", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 18", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 19", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 20 (Sala de referencia virtual)", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 21", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 22", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 23", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_joaquin_guzman, "Aula 24 (Salón verde)", "Edificio Dr. David Joaquín Guzmán \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 28", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Diseño Digital Arquitectónico", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Laboratorio de Ciencias", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 1"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Laboratorio de Idiomas 1", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 29 (Aula Magna)", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 30", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 2"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 31", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 32 A", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 32 B", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 3"));
        items.add(new Aulas(R.drawable.edificio_jose_canas, "Aula 33", "Edificio Dr. Juan José Cañas \n" +
                "Nivel 3"));

        // Obtener el Recycler
        recycler = findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);
        recycler.setHasFixedSize(true);
        recycler.setItemAnimator(new DefaultItemAnimator());

        // Crear un nuevo adaptador
        adapter = new AulasAdaptador(items);
        recycler.setAdapter(adapter);

        final GestureDetector mGestureDetector = new GestureDetector(CardView.this, new GestureDetector.SimpleOnGestureListener() {
            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        recycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                try {
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                    if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {

                        posicion = recyclerView.getChildAdapterPosition(child);


                        //Toast.makeText(CardView.this,"El item cliqueado es: "+ position ,Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder alerta = new AlertDialog.Builder(CardView.this);
                        LayoutInflater factory = LayoutInflater.from(CardView.this);
                        final View view = factory.inflate(R.layout.carga_img_alert, null);

                        //TODO: mostrar las diferentes opciones al usuario en la lista cambiandolos dinamicamente

                        TextView descrip = view.findViewById(R.id.textoAlerta);
                        //ImageView imagenAula = view.findViewById(R.id.imagen_alerta);
                        SubsamplingScaleImageView imagenAula= view.findViewById(R.id.imagen_alerta);
                        imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                        switch(posicion){
                            case 0:
                            descrip.setText(R.string.edi1_nivel1);
                            imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                            titulo = "Aula 3";
                            break;

                            case 1:
                                descrip.setText(R.string.edi1_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 4";
                                break;
                            case 2:
                                descrip.setText(R.string.edi1_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 5";
                                break;
                            case 3:
                                descrip.setText(R.string.edi1_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 6";
                                break;
                            case 4:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 7";
                                break;
                            case 5:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 8";
                                break;
                            case 6:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 9";
                                break;
                            case 7:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 10";
                                break;
                            case 8:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 11";
                                break;
                            case 9:
                                descrip.setText(R.string.edi1_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 12";
                                break;
                            case 10:
                                descrip.setText(R.string.edi1_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 13";
                                break;
                            case 11:
                                descrip.setText(R.string.edi1_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 14";
                                break;
                            case 12:
                                descrip.setText(R.string.edi1_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.oscar_romero));
                                titulo = "Aula 15";
                                break;
                            case 13:
                                descrip.setText(R.string.edi2_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 16";
                                break;
                            case 14:
                                descrip.setText(R.string.edi2_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 17";
                                break;
                            case 15:
                                descrip.setText(R.string.edi2_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 18";
                                break;
                            case 16:
                                descrip.setText(R.string.edi2_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 19";
                                break;
                            case 17:
                                descrip.setText(R.string.edi2_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 20 (Sala de referencia virtual)";
                                break;
                            case 18:
                                descrip.setText(R.string.edi2_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 21";
                                break;
                            case 19:
                                descrip.setText(R.string.edi2_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 22";
                                break;
                            case 20:
                                descrip.setText(R.string.edi2_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 23";
                                break;
                            case 21:
                                descrip.setText(R.string.edi2_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_joaquin_guzman));
                                titulo = "Aula 24 (Salón verde)";
                                break;
                            case 22:
                                descrip.setText(R.string.edi3_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 28";
                                break;
                            case 23:
                                descrip.setText(R.string.edi3_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Diseño digital arquitectónico";
                                break;
                            case 24:
                                descrip.setText(R.string.edi3_nivel1);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Laboratorio de ciencias";
                                break;
                            case 25:
                                descrip.setText(R.string.edi3_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Laboratorio de idiomas 1";
                                break;
                            case 26:
                                descrip.setText(R.string.edi3_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 29 (Aula Magna)";
                                break;
                            case 27:
                                descrip.setText(R.string.edi3_nivel2);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 30";
                                break;
                            case 28:
                                descrip.setText(R.string.edi3_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 31";
                                break;
                            case 29:
                                descrip.setText(R.string.edi3_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 32 A";
                                break;
                            case 30:
                                descrip.setText(R.string.edi3_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 32 B";
                                break;
                            case 31:
                                descrip.setText(R.string.edi3_nivel3);
                                imagenAula.setImage(ImageSource.resource(R.drawable.edificio_jose_canas));
                                titulo = "Aula 33";
                                break;

                            default:
                                descrip.setText("Nothing for now");
                                imagenAula.setImage(ImageSource.resource(R.drawable.ic_mic_black_24dp));
                                titulo="Nothing for now";
                        }

                        alerta.setView(view);
                        alerta.setTitle(titulo)
                                .setCancelable(false)
                                .setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                        alerta.show();

                        return true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INTRO) {
            if (resultCode == RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, false)
                        .apply();
            } else {
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean(PREF_KEY_FIRST_START, true)
                        .apply();
                //El usuario podra salir solo y solo si termina la intro
                finish();
            }
        }
    }
}
