/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IProductoDAO {
    
    public void agregar(Producto producto) throws SQLException;
    public void eliminar(Producto producto)throws SQLException;
    public void actualizar(Producto producto) throws SQLException;
    public Producto consultar(int id) throws SQLException;
    public List<Producto> consultarTodos() throws SQLException; 
    
}
