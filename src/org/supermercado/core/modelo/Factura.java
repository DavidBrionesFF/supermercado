/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Factura {
    private int id_factura;
    private Date fecha_facturacion;
    private String descripcion;
    private double subtotal, total;
    private Usuario usuario;
    private List<Descripcion> descripcion_factura;

    public List<Descripcion> getDescripcion_factura() {
        return descripcion_factura;
    }

    public void setDescripcion_factura(List<Descripcion> descripcion_factura) {
        this.descripcion_factura = descripcion_factura;
    }

    public Factura() {
    }

    public Factura(int id_factura, Date fecha_facturacion, String descripcion, double subtotal, double total, Usuario usuario) {
        this.id_factura = id_factura;
        this.fecha_facturacion = fecha_facturacion;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.total = total;
        this.usuario = usuario;
    }

    public Factura(Date fecha_facturacion, String descripcion, double subtotal, double total, Usuario usuario) {
        this.fecha_facturacion = fecha_facturacion;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.total = total;
        this.usuario = usuario;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha_facturacion() {
        return fecha_facturacion;
    }

    public void setFecha_facturacion(Date fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
