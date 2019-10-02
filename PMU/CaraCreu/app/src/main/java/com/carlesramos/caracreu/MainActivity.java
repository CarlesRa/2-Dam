package com.carlesramos.caracreu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
    private Button btCara;
    private Button btCruz;
    private ImageView ivQuestion;
    private TextView tvResultado;
    private Random rnd;
    private int numRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCara = findViewById(R.id.btCara);
        btCruz = findViewById(R.id.btCruz);
        ivQuestion = findViewById(R.id.ivQuestion);
        tvResultado = findViewById(R.id.tvResultado);
        rnd = new Random();
        rotarImagen(ivQuestion);

        btCara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetText();
                numRandom = rnd.nextInt(2);
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
                resetText();
                numRandom = rnd.nextInt(2);
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
    public void mostrarCara(){
        ivQuestion.setVisibility(View.INVISIBLE);
        ivQuestion.postDelayed(new Runnable() {
            @Override
            public void run() {
                ivQuestion.setImageResource(R.drawable.euro_cara);
                ivQuestion.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }
    public void mostrarCruz(){
        ivQuestion.setVisibility(View.INVISIBLE);
        ivQuestion.postDelayed(new Runnable() {
            @Override
            public void run() {
                ivQuestion.setImageResource(R.drawable.euro_cruz);
                ivQuestion.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }
    public void mensajeVictoria(){
        sleep(3000);
        tvResultado.setText(R.string.tvResultado);
    }
    public void mensajeDerrota(){
        sleep(3000);
        tvResultado.setText(R.string.tvResultado1);
    }
    private void rotarImagen(View view){
        RotateAnimation animation = new RotateAnimation(0, 360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(800);
        animation.setRepeatCount(Animation.RELATIVE_TO_PARENT);
        animation.setRepeatMode(Animation.INFINITE);
        view.startAnimation(animation);
    }
    private void resetText(){
        tvResultado.setText(R.string.tvResultado0);
    }
}
