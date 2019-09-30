package com.carlesramos.salutacioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btSaludar;
    private EditText etNombre;
    private EditText etApellido;
    private String nombre;
    private String apellido;
    private InputMethodManager inputMethodManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        btSaludar = findViewById(R.id.btSaludar);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        btSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputMethodManager.hideSoftInputFromWindow(btSaludar.getWindowToken(), 0);
                nombre = etNombre.getText().toString();
                apellido = etApellido.getText().toString();
                etApellido.setText("");
                etNombre.setText("");
                Toast.makeText(MainActivity.this,"Hola " + nombre + " " + apellido
                ,Toast.LENGTH_LONG).show();
            }
        });
    }
}
