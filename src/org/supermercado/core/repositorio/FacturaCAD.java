/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.repositorio;

import org.supermercado.core.modelo.Factura;
import java.util.List;
/**
 *
 * @author User
 */
public class FacturaCAD extends Conexion {
    public boolean save(Factura f){
        boolean retorno = false;
        abrirConexion();
        try {
            retorno = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();
        return retorno;
    }
    
    public boolean update(){
        boolean retorno = false;
        abrirConexion();
        try {
            retorno = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();
        return retorno;
    }
    
    public boolean delete(){
        boolean retorno = false;
        abrirConexion();
        try {
            retorno = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();
        return retorno;
    }
    
    public List<Factura> findAll(){
        return null;
    }
}
