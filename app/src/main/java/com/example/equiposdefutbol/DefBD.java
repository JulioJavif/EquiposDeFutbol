package com.example.equiposdefutbol;

public class DefBD {

    public static final String nameDb = "Equipos";
    public static final String tabla_est = "equipo";
    public static final String col_nombre= "nombre";
    public static final String col_pais = "pais";
    public static final String col_ciudad = "ciudad";
    public static final String col_tecnico = "tecnico";
    public static final String col_campeonatos = "campeonatos";

    public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_est + " ( " +
            DefBD.col_nombre + " text primary key," +
            DefBD.col_pais + " text," +
            DefBD.col_ciudad + " text," +
            DefBD.col_tecnico + " text," +
            DefBD.col_campeonatos + " text" +
            ");";


}
