package com.carlesramos.caracreu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
    private Button btCara;
    private Button btCruz;
    private ImageView ivQuestion;
    private TextView tvResultado;
    private Random rnd;
    private int numRandom;
    private ProgressBar pbProgreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCara = findViewById(R.id.btCara);
        btCruz = findViewById(R.id.btCruz);
        ivQuestion = findViewById(R.id.ivQuestion);
        tvResultado = findViewById(R.id.tvResultado);
        rnd = new Random();

        btCara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numRandom = rnd.nextInt(2);
                esperar();
                switch (numRandom){
                    case 0:{
                        mostrarCara();
                        mensajeVictoria();
                        break;
                    }
                    case 1:{
                        mostrarCruz();
                        mensajeDerrota();
                        break;
                    }
                }
            }
        });

        btCruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numRandom = rnd.nextInt(2);
                esperar();
                switch (numRandom){
                    case 0:{
                        mostrarCruz();
                        mensajeVictoria();
                        break;
                    }
                    case 1:{
                        mostrarCara();
                        mensajeDerrota();
                        break;
                    }
                }
            }
        });
    }
    public void esperar(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void mostrarCara(){
        ivQuestion.setImageResource(R.drawable.euro_cara);
    }
    public void mostrarCruz(){
        ivQuestion.setImageResource(R.drawable.euro_cruz);
    }
    public void mensajeVictoria(){
        tvResultado.setText(R.string.tvResultado);
    }
    public void mensajeDerrota(){
        tvResultado.setText(R.string.tvResultado1);
    }
}
