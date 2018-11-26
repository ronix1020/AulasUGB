package com.ronix.aulasugb;


public class Aulas {
    private int imagen;
    private String nombre, descripcion;

    public Aulas(int imagen, String nombre, String descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }

}
