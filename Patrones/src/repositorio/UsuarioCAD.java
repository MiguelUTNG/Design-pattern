/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import org.bytecode.dao.Conexion;

/**
 *
 * @author Luis Ventura
 */
public class UsuarioCAD extends Conexion implements Plantilla{

    @Override
    public boolean crear(Usuario user) {
        conectar();
        String sql = "insert into usuario (nombre, apellido, edad, correo, contrasena) values('"+user.getNombre()+"','"+user.getApellido()+"',"+user.getEdad()+",'"+user.getCorreo()+"','"+user.getContrasena()+"')";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Usuario user) {
        conectar();
        String sql = "update usuario set nombre='"+user.getNombre()+"', apellido='"+user.getApellido()+"', edad="+user.getEdad()+", contrasena='"+user.getContrasena()+"', correo='"+user.getCorreo()+"' where id_usuario="+user.getId()+"";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(int id) {
        conectar();
        String sql = "delete from usuario where id_usuario="+id+"";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Usuario> obtener() {
        conectar();
        List<Usuario> users = new ArrayList<>();
        
        String sql = "select * from usuario order by nombre";
        
        try {
            Statement st = conexion.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                users.add(new Usuario(rs.getString("nombre"), rs.getString("contrasena"), rs.getString("correo"), 
                        rs.getString("apellido"), rs.getInt("id_usuario"), rs.getInt("edad")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return users;
    }
    
}
