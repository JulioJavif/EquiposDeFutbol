package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.widget.SearchView;
//import androidx.appcompat.widget.SearchView;
//import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FiltroActivity extends AppCompatActivity {

    SearchView filtrar;
    ListView lista;
    EquipoController ec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        filtrar = findViewById(R.id.buscar);
        lista = findViewById(R.id.lvLista);

        ec = new EquipoController(this);
        Cursor c = ec.allEquipo2();
        ArrayList<String> listado = new ArrayList<String>();
        while(c.moveToNext()){
            String equipo = c.getString(0)+" | "+c.getString(1)+" | "
                    +c.getString(2)+" | "+c.getString(3)+" | "+c.getString(4);
            listado.add(equipo);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        lista.setAdapter(adapter);

        filtrar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                ArrayList<String> nuevaLista;
                nuevaLista = coincidencias(ec.allEquipo2(), query);
                if (nuevaLista.isEmpty()){
                    Toast.makeText(getApplicationContext(), "No hay coincidencias", Toast.LENGTH_LONG).show();
                }else {
                    ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, nuevaLista);
                    lista.setAdapter(adapter2);
                }

                /*if (listado.contains(query)){
                    //adapter.getFilter().filter(query);
                    Toast.makeText(FiltroActivity.this, ""+query, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(FiltroActivity.this, "No hay coincidencias para: "+query, Toast.LENGTH_LONG).show();
                }*/
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public static ArrayList<String> coincidencias(Cursor c, String key){
        ArrayList<String> listado = new ArrayList<String>();
        while(c.moveToNext()){
            if (c.getString(0).equalsIgnoreCase(key) || c.getString(4).equalsIgnoreCase(key)){
                String equipo = c.getString(0)+" | "+c.getString(1)+" | "
                        +c.getString(2)+" | "+c.getString(3)+" | "+c.getString(4);
                listado.add(equipo);
            }
        }
        return listado;
    }
}