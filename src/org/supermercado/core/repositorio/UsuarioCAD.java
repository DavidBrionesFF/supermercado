/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core.repositorio;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.supermercado.core.modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author David
 */
public class UsuarioCAD extends Conexion{
    
    public boolean save(Usuario usuario){
        boolean retorno;
        abrirConexion();
        try {
            Date d = usuario.getFecha_nacimiento();
            CallableStatement pst = conexion.prepareCall("call sp_crearUsuario(?,?,?,?,?,?,?)");
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellido());
            pst.setString(3, usuario.getContrasena());
            pst.setString(4,d.getYear()+"-"+d.getMonth()+"-"+d.getDay());
            pst.setString(5, usuario.getNombre_usuario());
            pst.setString(6, usuario.getPerfil());
            pst.setInt(7, usuario.getRol());
            pst.executeUpdate();
            retorno = true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            retorno = false;
        }
        cerrarConexion();
        return retorno;
    }
    
    public boolean update(Usuario usuario){
        boolean retorno;
        abrirConexion();
        try {
            Date d = usuario.getFecha_nacimiento();
            CallableStatement pst = conexion.prepareCall("call sp_actualizarUsuario(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuario.getId_usuario());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellido());
            pst.setString(4, usuario.getContrasena());
            pst.setString(5,d.getYear()+"-"+d.getMonth()+"-"+d.getDay());
            pst.setString(6, usuario.getNombre_usuario());
            pst.setString(7, usuario.getPerfil());
            pst.setInt(8, usuario.getRol());
            pst.executeUpdate();
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
        cerrarConexion();
        return retorno;
    }
    
    public boolean delete(int id){
        boolean retorno;
        abrirConexion();
        try {
            CallableStatement pst = conexion.prepareCall("call sp_eliminar(?)");
            pst.setInt(1, id);
            pst.executeUpdate();
            retorno = true;
        } catch (Exception e) {
            retorno = false;
        }
        cerrarConexion();
        return retorno;
    }
    
    public List findAll(int offset, int limit){
        List<Usuario> retorno = new ArrayList<>();
        abrirConexion();
        try {
            retorno = new ArrayList<>();
            
            CallableStatement st = conexion.prepareCall("call sp_obtenerTodos(?,?)");
            st.setInt(1, offset);
            st.setInt(2, limit);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                retorno.add(new Usuario(rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("contrasena"), rs.getString("perfil"), rs.getString("nombre_usuario"),
                        rs.getInt("id_usuario"),
                        rs.getInt("rol"), rs.getBoolean("activo"), rs.getDate("fecha_nacimiento")));
            }
        } catch (Exception e) {
            retorno = null;
        }
        cerrarConexion();
        return retorno;
    }
    
    public List findByFactura(){
        List<Usuario> retorno = new ArrayList<>();
        abrirConexion();
        try {
            CallableStatement st = conexion.prepareCall("");
            
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                retorno.add(new Usuario(rs.getString("nombre"), rs.getString("apellido"),
                        rs.getString("contrasena"), rs.getString("perfil"), rs.getString("nombre_usuario"),
                        rs.getInt("id_usuario"),
                        rs.getInt("rol"), rs.getBoolean("activo"), rs.getDate("fecha_nacimiento")));
            }
            retorno = new ArrayList<>();
        } catch (Exception e) {
            retorno = null;
        }
        cerrarConexion();
        return retorno;
    }
}
