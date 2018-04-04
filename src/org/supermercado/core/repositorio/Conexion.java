/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author David Briones
 */
public class Conexion {
    private String base_datos = "cursosql";
    private String url = "jdbc:mysql://localhost:3306/"+base_datos;
    private String nombre_usuario = "root";
    private String contrasena = "";
    protected Connection conexion;
    
    protected boolean abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection(url,nombre_usuario, contrasena);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    protected boolean cerrarConexion(){
        try {
            if(!conexion.isClosed()){
                conexion.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
