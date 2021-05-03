package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombre,pais, ciudad,tecnico,campeonatos;
    Button guardar, regresar;
    Equipo e;
    EquipoController ec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre=findViewById(R.id.edtnombre);
        pais=findViewById(R.id.edtpais);
        ciudad=findViewById(R.id.edtciudad);
        tecnico=findViewById(R.id.edtecnico);
        campeonatos=findViewById(R.id.edtcampeonatos);
        guardar=findViewById(R.id.btnguardar);
        regresar=findViewById(R.id.btnregresar);
        guardar.setOnClickListener(this);
        regresar.setOnClickListener(this);
        ec= new EquipoController(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnguardar:
                if(TextUtils.isEmpty(nombre.getText().toString()) || TextUtils.isEmpty(pais.getText().toString()) ||
                   TextUtils.isEmpty(ciudad.getText().toString()) || TextUtils.isEmpty(tecnico.getText().toString()) || TextUtils.isEmpty(campeonatos.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();

                }else{
                    e= new Equipo(nombre.getText().toString(),pais.getText().toString(),ciudad.getText().toString(),
                            tecnico.getText().toString(),campeonatos.getText().toString());
                    if(ec.buscarEquipo(e.getNombre()+" ").moveToNext()){
                        Toast.makeText(this,"El equipo ya existe", Toast.LENGTH_LONG).show();
                    }else{
                        ec.agregarEquipo(e);
                    }
                }
        }
    }
}