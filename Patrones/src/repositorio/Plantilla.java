/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Luis Ventura
 */
public interface Plantilla {
    public boolean crear(Usuario user);
    public boolean actualizar(Usuario user);
    public boolean borrar(int id);
    public List<Usuario> obtener();
}
