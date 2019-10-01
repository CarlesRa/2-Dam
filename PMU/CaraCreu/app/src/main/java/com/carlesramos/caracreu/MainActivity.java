package com.carlesramos.caracreu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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

        btCara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numRandom = rnd.nextInt(2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (numRandom){
                    case 0:{
                        ivQuestion.setImageResource(R.drawable.euro_cara);
                        tvResultado.setText(R.string.tvResultado);
                        break;
                    }
                    case 1:{
                        ivQuestion.setImageResource(R.drawable.euro_cruz);
                        tvResultado.setText(R.string.tvResultado1);
                        break;
                    }
                }
            }
        });

        btCruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numRandom = rnd.nextInt(2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (numRandom){
                    case 0:{
                        ivQuestion.setImageResource(R.drawable.euro_cruz);
                        tvResultado.setText(R.string.tvResultado);
                        break;
                    }
                    case 1:{
                        ivQuestion.setImageResource(R.drawable.euro_cara);
                        tvResultado.setText(R.string.tvResultado1);
                        break;
                    }
                }
            }
        });
    }
}
