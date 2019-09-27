package com.carlesramos.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button btnGenRandom;
    private Random rnd;
    private int nRandom;
    private int numUsuario;
    private EditText nNumUsuario;
    private boolean seguir;
    private TextView tvVerRessultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.BtnJugar);
        nNumUsuario = findViewById(R.id.nNumUsuario);
        tvVerRessultado = findViewById(R.id.tvVerResultado);
        btnGenRandom = findViewById(R.id.btnGenerar);
        rnd = new Random();
        seguir = false;
        btnGenRandom.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                nRandom = rnd.nextInt((51))+1;
                nNumUsuario.setText("");
                tvVerRessultado.setText("Numero Random GENERADO!!");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numUsuario = Integer.parseInt(nNumUsuario.getText().toString());
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(nNumUsuario.getWindowToken(), 0);
                if (numUsuario == nRandom){
                    tvVerRessultado.setText("Enorabuena has GANADO!!");
                    Toast.makeText(MainActivity.this,"ERES UNA MAQUINA!!",Toast.LENGTH_LONG).show();
                    seguir = true;
                }
                else if(numUsuario > nRandom){
                    tvVerRessultado.setText("OHHHH tu numero es mayor");
                    nNumUsuario.setText("");
                    inputMethodManager.hideSoftInputFromWindow(nNumUsuario.getWindowToken(), 1);
                    }
                else{
                    tvVerRessultado.setText("OHHHH tu numero es menor");
                    nNumUsuario.setText("");
                    inputMethodManager.hideSoftInputFromWindow(nNumUsuario.getWindowToken(), 1);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.this.getLocalClassName(),"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.this.getLocalClassName(),"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivity.this.getLocalClassName(),"onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.this.getLocalClassName(),"onStop()");
    }
}
