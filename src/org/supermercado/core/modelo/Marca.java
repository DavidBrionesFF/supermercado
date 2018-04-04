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
public class Marca {
    private int id_marca;
    private String nombre, descripcion;
    private Date fecha_integracion;
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    

    public Marca(int id_marca, String nombre, String descripcion, Date fecha_integracion) {
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_integracion = fecha_integracion;
    }

    public Marca(String nombre, String descripcion, Date fecha_integracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_integracion = fecha_integracion;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_integracion() {
        return fecha_integracion;
    }

    public void setFecha_integracion(Date fecha_integracion) {
        this.fecha_integracion = fecha_integracion;
    }
    
}
