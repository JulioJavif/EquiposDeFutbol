package com.example.equiposdefutbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

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
            Toast.makeText(c, "Equipo registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando estudiante " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public boolean buscarEquipo(Equipo e){
        String arg[]= new String[]{e.getNombre()};
        SQLiteDatabase sql= bd.getReadableDatabase();
        Cursor c=  sql.query(DefBD.tabla_est,null, "nombre=?",arg,null,null,null);
        if(c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }
    public Cursor allEquipo2(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur =
                    sql.query(DefBD.tabla_est,
                    new String[]{"nombre", "pais", "ciudad", "tecnico", "campeonatos"},
                            null,
                            null,
                            null,
                            null,
                            null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta de equipo " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }

    }


    /*public ArrayList<String> getFiltro(String clave){
        SQLiteDatabase sqlite = bd.getReadableDatabase();
        Cursor cursor = sqlite.query(DefBD.tabla_est,
                                        new String[]{"equipo", "pais", "campeonatos"},
                                "pais=? or campeonatos=?",
                                        new String[]{clave, clave},
                                null,
                                null,
                                null);
        if(cursor.getCount()>0){
            ArrayList<String> lista = new ArrayList<String>();
            while(cursor.moveToNext()){
                lista.add(cursor.getString(1)+" | "+cursor.getString(2)+" | "+cursor.getString(3));
            }
            return lista;
        }
        return null;
    }*/

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
}
