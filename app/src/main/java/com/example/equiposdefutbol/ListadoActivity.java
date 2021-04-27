package com.example.equiposdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

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
        EquipoCursorAdapter ecursor= new EquipoCursorAdapter(this,c,false);
        listado.setAdapter(ecursor);
    }
}