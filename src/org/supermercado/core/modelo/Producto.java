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
public class Producto {
    private int id_producto;
    private String nombre, descripcion, poster;
    private Date fecha_ingreso;
    private double precio;
    private Marca marca;
    private Categoria categoria;
    private Usuario usuario;
    private List<Descripcion> descripcion_factura;

    public List<Descripcion> getDescripcion_factura() {
        return descripcion_factura;
    }

    public void setDescripcion_factura(List<Descripcion> descripcion_factura) {
        this.descripcion_factura = descripcion_factura;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Producto() {
    }

    public Producto(int id_producto, String nombre, String descripcion, String 
            poster, Date fecha_ingreso, double precio, Marca marca, Categoria categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poster = poster;
        this.fecha_ingreso = fecha_ingreso;
        this.precio = precio;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Producto(String nombre, String descripcion, String poster, Date 
            fecha_ingreso, double precio, Marca marca, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poster = poster;
        this.fecha_ingreso = fecha_ingreso;
        this.precio = precio;
        this.marca = marca;
        this.categoria = categoria;
    }
    
}
