package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button registrar, listado, buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registrar=findViewById(R.id.btnregistrar);
        listado=findViewById(R.id.btnlistado);
        buscar=findViewById(R.id.btnbuscar);
        registrar.setOnClickListener(this);
        listado.setOnClickListener(this);
        buscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnregistrar:
                Intent i= new Intent(this, RegistrarActivity.class);
                startActivity(i);
                break;
            case R.id.btnbuscar:
                Intent i2 = new Intent(this, FiltroActivity.class);
                startActivity(i2);
                break;
        }

    }
}