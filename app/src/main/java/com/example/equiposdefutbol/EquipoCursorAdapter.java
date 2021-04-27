package com.example.equiposdefutbol;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

public class EquipoCursorAdapter extends CursorAdapter {
    public EquipoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_equipo,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nom = view.findViewById(R.id.txtnombre);
        TextView pai = view.findViewById(R.id.txtpais);
        TextView ciu = view.findViewById(R.id.txtciudad);
        TextView  tec=view.findViewById(R.id.txtecnico);
        TextView  cam=view.findViewById(R.id.txtcampeonatos);
        String nombre = cursor.getString(0);
        String pais = cursor.getString(1);
        String ciudad = cursor.getString(2);
        String tecnico=cursor.getString(3);
        String campeonatos=cursor.getString(4);
        nom.setText(nombre);
        pai.setText(pais);
        ciu.setText(ciudad);
        tec.setText(tecnico);
        cam.setText(campeonatos);
    }
}

