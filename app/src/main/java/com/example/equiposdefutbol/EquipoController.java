package com.example.equiposdefutbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Optional;

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
            Toast.makeText(c, "Equipo registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando equipo " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Cursor buscarEquipo(String nombre) {
        nombre = nombre.substring(0, nombre.length()-1);
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_est,
                new String[]{"nombre","pais","ciudad","tecnico", "campeonatos"},
                "nombre=?",
                new String[]{nombre},
                null,
                null,
                null);
        //Toast.makeText( this.c, "count: "+c.getCount()+"\nnombre: "+nombre+"\nlong: "+nombre.length(), Toast.LENGTH_LONG).show();
        if (c.getCount() > 0) {
            return c;
        } else {
            return null;
        }
    }

    public Cursor allEquipo2() {
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.query(DefBD.tabla_est,
                            new String[]{"nombre", "pais", "ciudad", "tecnico", "campeonatos"},
                            null,
                            null,
                            null,
                            null,
                            null);
            return cur;
        } catch (Exception ex) {
            Toast.makeText(c, "Error consulta de equipo " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }

    }

    public ArrayList<String> getEquipos() {
        try {
            SQLiteDatabase sqlite = bd.getReadableDatabase();
            Cursor cursor = sqlite.query(DefBD.tabla_est,
                    new String[]{"equipo", "pais", "campeonatos"},
                    null,
                    null,
                    null,
                    null,
                    null);
            ArrayList<String> lista = new ArrayList<String>();
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String equipo = cursor.getString(1) + " | " + cursor.getString(2) + " | " + cursor.getString(3);
                    lista.add(equipo);
                }
                return lista;
            }
            return lista;
        } catch (Exception e) {
            Toast.makeText(c, "Error al leer en la DDBB: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return null;
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
