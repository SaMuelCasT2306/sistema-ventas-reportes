package com.poo.edu.utp.ingenieria.sistemaventas.modelos;

public class Cliente {
    
    //
    private int id;
    private long ruc;
    private String nombre;
    private String direccion;

    //
    public Cliente(int id, long ruc, String nombre, String direccion) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    //
    public int getId() {
        return id;
    }

    public long getRuc() {
        return ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    //
    public void setId(int id) {
        this.id = id;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
