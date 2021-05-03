package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdicionActivity extends AppCompatActivity {
       EditText dnombre, dpais, dciudad, dtecnico, dcampeonato;
       Button eliminar, actualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        Intent i= getIntent();
        String nombre= i.getStringExtra("nombre");
        String pais= i.getStringExtra("pais");
        String ciudad=i.getStringExtra("ciudad");
        String tecnico= i.getStringExtra("tecnico");
        String campeonato=i.getStringExtra("campeonatos");

        dnombre=findViewById(R.id.idnombre);
        dpais=findViewById(R.id.idpais);
        dciudad=findViewById(R.id.idciudad);
        dtecnico=findViewById(R.id.idtecnico);
        dcampeonato=findViewById(R.id.idcampeonatos);
        eliminar=findViewById(R.id.btneliminar);
        actualizar= findViewById(R.id.btnactualizar);

        if (!nombre.isEmpty()){
            dnombre.setText(nombre);
            dnombre.setEnabled(false);
            dpais.setText(pais);
            dciudad.setText(ciudad);
            dtecnico.setText(tecnico);
            dcampeonato.setText(campeonato);
        }

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquipoController ec= new EquipoController(getApplication());
                ec.eliminarEquipo(dnombre.getText().toString());
                Intent i=new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equipo e= new Equipo(dnombre.getText().toString(),dpais.getText().toString(),dciudad.getText().toString(),dtecnico.getText().toString(), dcampeonato.getText().toString());
                EquipoController ec=new EquipoController(getApplication());
                ec.actualizarEquipo(e);
                Intent i= new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });

    }
}