/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.supermercado.core;

import java.util.Date;
import java.util.List;
import org.supermercado.core.modelo.Usuario;
import org.supermercado.core.repositorio.UsuarioCAD;

/**
 *
 * @author User
 */
public class App {
    
    public static void main(String[] args) {
        
        /*
        Usuario user = new Usuario();
        user.setContrasena("1234");
        user.setApellido("Enriquez");
        user.setNombre("Selaco");
        user.setFecha_nacimiento(new Date(2000, 10, 12));
        user.setNombre_usuario("enriquez_gerardo");
        user.setPerfil("default");
        user.setRol(1);
        user.setId_usuario(3);
        
        UsuarioCAD repos = new UsuarioCAD();
        repos.delete(user.getId_usuario());
        Date d = user.getFecha_nacimiento();
        System.out.println("Guardado " +d.getYear()+"-"+d.getMonth()+"-"+d.getDay());*/
        
        UsuarioCAD repo = new UsuarioCAD();
        List<Usuario> users = repo.findAll(0, 3);
        for (Usuario user : users) {
            System.out.println(user.getContrasena());
        }
        
        System.exit(0);
    }
    
}
