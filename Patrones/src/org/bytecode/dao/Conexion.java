/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bytecode.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luis Ventura
 */
public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/cursosql";
    private String usuario  = "root";
    private String contrasena = "";
    protected Connection conexion;
    
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (Exception e) {
        }
    }
}
