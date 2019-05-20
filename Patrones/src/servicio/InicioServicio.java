/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Usuario;
import repositorio.UsuarioCAD;

public class InicioServicio {
    
    public void  crear(JTextField apellido, JTextField contrasena, JTextField correo, JTextField nombre, JTextField edad){
        UsuarioCAD obj = new UsuarioCAD();
        Usuario us = new Usuario();
        us.setApellido(apellido.getText());
        us.setContrasena(contrasena.getText());
        us.setCorreo(correo.getText());
        us.setNombre(nombre.getText());
        
        try{
            us.setEdad(Integer.parseInt(edad.getText()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingresa un numero");
        }
        
        if(obj.crear(us)){
            JOptionPane.showMessageDialog(null, "Creado", "Creado exitosamente", JOptionPane.DEFAULT_OPTION);
        }else{
            JOptionPane.showMessageDialog(null, "Error", "usuario no creado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarTaba(JTable tablaUsuarios){
        Object[] nombres ={"ID","Nombre", "Apellido","Edad", "Correo","Contrasena"};
        
        TableModel modelo = new DefaultTableModel(nombres, 10);
        
        UsuarioCAD obj = new UsuarioCAD();
        int i = 0;
        for(Usuario us : obj.obtener()){
            modelo.setValueAt(us.getId(), i, 0);
            modelo.setValueAt(us.getNombre(), i, 1);
            modelo.setValueAt(us.getApellido(), i, 2);
            modelo.setValueAt(us.getEdad(), i, 3);
            modelo.setValueAt(us.getCorreo(), i, 4);
            modelo.setValueAt(us.getContrasena(), i, 5);
            i++;
        }
        
        tablaUsuarios.setModel(modelo);
    }
    
    public void actualizar(JTextField apellido, JTextField contrasena, JTextField correo, 
            JTextField nombre, JTextField edad, JTextField id){
        UsuarioCAD obj = new UsuarioCAD();
        
        Usuario us = new Usuario();
        us.setApellido(apellido.getText());
        us.setContrasena(contrasena.getText());
        us.setCorreo(correo.getText());
        us.setNombre(nombre.getText());
        try{
            us.setEdad(Integer.parseInt(edad.getText()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingresa un numero");
        }
        
        try{
            us.setId(Integer.parseInt(id.getText()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingresa un numero");
        }
        
        if(obj.actualizar(us)){
            JOptionPane.showMessageDialog(null, "Actualizado", "Creado exitosamente", JOptionPane.DEFAULT_OPTION);
        }else{
            JOptionPane.showMessageDialog(null, "Error", "usuario no actualizado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(JTextField id){
        try{
            int ide = Integer.parseInt(id.getText());
            UsuarioCAD obj = new UsuarioCAD();
            obj.borrar(ide);
            JOptionPane.showMessageDialog(null, "Borrado", "Borrado exitosamente", JOptionPane.DEFAULT_OPTION);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingresa un numero de identificador");
        }
    }
}
