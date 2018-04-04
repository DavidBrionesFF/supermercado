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
public class Usuario {
    private String nombre, apellido, contrasena, perfil, nombre_usuario;
    private int id_usuario, rol;
    private boolean activo;
    private Date fecha_nacimiento;
    private List<Factura> facturas_realizadas;
    private List<Ingresados> ingresos;
    private List<Producto> productos_insertados;

    public List<Factura> getFacturas_realizadas() {
        return facturas_realizadas;
    }

    public void setFacturas_realizadas(List<Factura> facturas_realizadas) {
        this.facturas_realizadas = facturas_realizadas;
    }

    public List<Ingresados> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingresados> ingresos) {
        this.ingresos = ingresos;
    }

    public List<Producto> getProductos_insertados() {
        return productos_insertados;
    }

    public void setProductos_insertados(List<Producto> productos_insertados) {
        this.productos_insertados = productos_insertados;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario(String nombre, String apellido, String contrasena, String perfil, String nombre_usuario, int id_usuario, int rol, boolean activo, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.perfil = perfil;
        this.nombre_usuario = nombre_usuario;
        this.id_usuario = id_usuario;
        this.rol = rol;
        this.activo = activo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario(String nombre, String apellido, String contrasena, String perfil, String nombre_usuario, int rol, boolean activo, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.perfil = perfil;
        this.nombre_usuario = nombre_usuario;
        this.rol = rol;
        this.activo = activo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario() {
    }
    
    
    
    
}
