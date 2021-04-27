package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.widget.SearchView;
//import androidx.appcompat.widget.SearchView;
//import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}