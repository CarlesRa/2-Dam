package com.carlesramos.factorialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero;
    private Button btCalcular;
    private TextView tvResultado;
    private InputMethodManager inputMethodManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumero = findViewById(R.id.etNumero);
        btCalcular = findViewById(R.id.btCalcula);
        tvResultado = findViewById(R.id.tvResultado);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputMethodManager.hideSoftInputFromWindow(btCalcular.getWindowToken(), 0);
                if (Integer.parseInt(etNumero.getText().toString()) > 0) {
                    tvResultado.setText(String.valueOf(calcularFactorial(Integer.parseInt(etNumero.getText().toString()))));
                }
                else
                    tvResultado.setText("Error debe ser un entero positivo");
            }
        });
    }

    private long calcularFactorial(int numero){
        long resultado = 1;
        for (int i = numero; i>0; i--){
            resultado = resultado * i;
        }
        return resultado;
    }
}
