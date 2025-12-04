package com.poo.edu.utp.ingenieria.sistemaventas.dto;

import java.util.Date;

public class FacturaClienteDTO {
    
    private int id;
    private Date fecha;
    private String nombreCliente;
    private float total;
    private String condicionPago;
    private float subtotal;
    private float igv;
    private String nroFactura;

    public FacturaClienteDTO() {
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public float getTotal() {
        return total;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getIgv() {
        return igv;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setIgv(float igv) {
        this.igv = igv;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }
    
}
