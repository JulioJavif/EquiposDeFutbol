package com.example.equiposdefutbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EquipoController {
    private BaseDatos bd;
    private Context c;
    public EquipoController( Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }
    public void agregarEquipo(Equipo e){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_pais, e.getPais());
            valores.put(DefBD.col_ciudad, e.getCiudad());
            valores.put(DefBD.col_tecnico,e.getTecnico());
            valores.put(DefBD.col_campeonatos,e.getCampeonatos());
            long id = sql.insert(DefBD.tabla_est, null, valores);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Estudiante registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando estudiante " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
