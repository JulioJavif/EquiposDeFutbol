package com.example.equiposdefutbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class EquipoController {
    private BaseDatos bd;
    private Context c;

    public EquipoController(Context c) {
        this.bd = new BaseDatos(c, 1);
        this.c = c;
    }

    public void agregarEquipo(Equipo e) {
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_pais, e.getPais());
            valores.put(DefBD.col_ciudad, e.getCiudad());
            valores.put(DefBD.col_tecnico, e.getTecnico());
            valores.put(DefBD.col_campeonatos, e.getCampeonatos());
            long id = sql.insert(DefBD.tabla_est, null, valores);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Estudiante registrado", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(c, "Error agregando estudiante " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarEquipo(Equipo e) {
        String arg[] = new String[]{e.getNombre()};
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_est, null, "nombre=?", arg, null, null, null);
        if (c.getCount() > 0) {
            bd.close();
            return true;
        } else {
            bd.close();
            return false;
        }
    }

    public Cursor allEquipo2() {
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select nombre as  nombre, pais, ciudad, tecnico, campeonatos from equipo", null);
            return cur;
        } catch (Exception ex) {
            Toast.makeText(c, "Error consulta de equipo " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }

    }

    public void eliminarEquipo(String nomb) {
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {nomb};
            sql.delete(DefBD.tabla_est, "nombre=?", args);
            Toast.makeText(c, "Equipo eliminado", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(c, "Error eliminar Equipo " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarEquipo(Equipo e) {
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {e.getNombre()};
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_pais, e.getPais());
            valores.put(DefBD.col_ciudad, e.getCiudad());
            valores.put(DefBD.col_tecnico, e.getTecnico());
            valores.put(DefBD.col_campeonatos, e.getCampeonatos());
            sql.update(DefBD.tabla_est, valores, "nombre=?", args);
            Toast.makeText(c, "Equipo actualizado", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(c, "Error actualizar equipo" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
