package com.carlesramos.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Mac es una gena",Toast.LENGTH_LONG).show();
        Log.d(MainActivity.this.getLocalClassName(),"onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Erees el mes guapo",Toast.LENGTH_LONG).show();
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
