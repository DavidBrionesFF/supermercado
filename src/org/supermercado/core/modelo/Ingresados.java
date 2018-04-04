/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.modelo;

import java.util.Date;

/**
 *
 * @author User
 */
public class Ingresados {
    private Date fehca_ingreso;
    private boolean tipo;
    private Usuario usuario;

    public Ingresados(Date fehca_ingreso, boolean tipo, Usuario usuario) {
        this.fehca_ingreso = fehca_ingreso;
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Ingresados() {
    }

    public Date getFehca_ingreso() {
        return fehca_ingreso;
    }

    public void setFehca_ingreso(Date fehca_ingreso) {
        this.fehca_ingreso = fehca_ingreso;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
