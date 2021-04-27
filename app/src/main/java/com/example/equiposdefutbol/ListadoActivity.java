package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}