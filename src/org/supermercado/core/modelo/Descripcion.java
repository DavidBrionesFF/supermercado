/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.modelo;

/**
 *
 * @author User
 */
public class Descripcion {
    private int id_descripcion;
    private int cantidad;
    private double precio;
    private Factura factura;
    private Producto producto;

    public Descripcion() {
    }

    public Descripcion(int id_descripcion, int cantidad, double precio, Factura factura,
            Producto producto) {
        this.id_descripcion = id_descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.factura = factura;
        this.producto = producto;
    }

    public Descripcion(int cantidad, double precio, Factura factura, Producto producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.factura = factura;
        this.producto = producto;
    }
    

    public int getId_descripcion() {
        return id_descripcion;
    }

    public void setId_descripcion(int id_descripcion) {
        this.id_descripcion = id_descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
}
