package com.example.equiposdefutbol;

public class Equipo {
    private String nombre;
    private  String pais;
    private String ciudad;
    private String tecnico;
    private String campeonatos;

    public Equipo(String nombre, String pais, String ciudad, String tecnico, String campeonatos) {
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.tecnico = tecnico;
        this.campeonatos = campeonatos;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }

    public void setPais(String pais) { this.pais = pais; }

    public String getCiudad() { return ciudad; }

    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getTecnico() { return tecnico; }

    public void setTecnico(String tecnico) { this.tecnico = tecnico; }

    public String getCampeonatos() { return campeonatos; }

    public void setCampeonatos(String campeonatos) { this.campeonatos = campeonatos; }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", tecnico='" + tecnico + '\'' +
                ", campeonatos='" + campeonatos + '\'' +
                '}';
    }
}
