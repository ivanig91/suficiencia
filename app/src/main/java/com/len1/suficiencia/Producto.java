package com.len1.suficiencia;

public class Producto {
    String nombre;
    String cantidad;
    String precio;

    public Producto(String nombre, String cantidad, String precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Producto(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
