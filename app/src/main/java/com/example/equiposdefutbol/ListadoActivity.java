package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    ListView listado;
    EquipoController equipoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listado=findViewById(R.id.listlistado);
        equipoController= new EquipoController(this);
        Cursor c = equipoController.allEquipo2();
        ArrayList<String> lista = new ArrayList<String>();
        while(c.moveToNext()){
            String equipo = c.getString(0)+" | "+c.getString(1)+" | "
                    +c.getString(2)+" | "+c.getString(3)+" | "+c.getString(4);
            lista.add(equipo);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listado.setAdapter(adapter);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nombre = view.findViewById(R.id.txtnombre);
                TextView pais = view.findViewById(R.id.txtpais);
                TextView ciudad = view.findViewById(R.id.txtciudad);
                TextView tecnico=view.findViewById(R.id.txtecnico);
                TextView campeonatos=view.findViewById(R.id.txtcampeonatos);
                Toast.makeText(getApplicationContext(),nombre.getText().toString() + "," + pais.getText().toString()
                        + "," + ciudad.getText().toString()+ "," + tecnico.getText() + ";" +campeonatos.getText(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("nombre", nombre.getText().toString());
                i.putExtra("pais", pais.getText().toString());
                i.putExtra("ciudad", ciudad.getText().toString());
                i.putExtra("tecnico", tecnico.getText().toString());
                i.putExtra("campeonatos", campeonatos.getText().toString());
                startActivity(i);
            }
        });
    }
}