package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;
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
    ArrayAdapter<String> adapter;
    EquipoController ec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);

        filtrar = findViewById(R.id.buscar);
        lista = findViewById(R.id.lvLista);

        ArrayList<String> busqueda;
        busqueda = ec.getEquipos();
        if (!busqueda.isEmpty()) {
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, busqueda);
            lista.setAdapter(adapter);
        } else {
            busqueda.add("No se encontraron equipos");
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, busqueda);
            lista.setAdapter(adapter);
        }

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