/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Producto;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IProductoDAO {
    
    public void agregar(Producto producto);
    public void eliminar(int id);
    public void actualizar(Producto producto);
    public Producto consultar(int id);
    public List<Producto> consultarTodos(); 
    
}
