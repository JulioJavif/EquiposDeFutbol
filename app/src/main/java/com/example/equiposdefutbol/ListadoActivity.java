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
import java.util.StringTokenizer;

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

                String datos = lista.get(position);
                StringTokenizer tokenizer = new StringTokenizer(datos);
                String nombre = tokenizer.nextToken("|");

                //Toast.makeText( getApplicationContext(), nombre, Toast.LENGTH_LONG).show();

                Cursor cursor = equipoController.buscarEquipo(nombre);

                if (cursor!=null && cursor.moveToNext()){
                    Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                    //cursor.moveToFirst();
                    i.putExtra("nombre", cursor.getString(0));
                    i.putExtra("pais", cursor.getString(1));
                    i.putExtra("ciudad", cursor.getString(2));
                    i.putExtra("tecnico", cursor.getString(3));
                    i.putExtra("campeonatos", cursor.getString(4));
                    startActivity(i);
                }
            }
        });
    }
}