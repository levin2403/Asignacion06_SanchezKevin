/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.ProductoDAO;
import entidades.Producto;
import interfaces.IProductoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skevi
 */
public class ProductoBO {
    
    private IProductoDAO productoDAO;

    public ProductoBO() {
        productoDAO = new ProductoDAO();
    }
    
    public JTable llenarTablaProductos(JTable tabla) throws SQLException {
        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        // Añadir las columnas al modelo
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripción");

        // Obtener los productos desde la capa DAO
        List<Producto> productos = productoDAO.consultarTodos(); 

        // Llenar el modelo con los productos
        for (Producto producto : productos) {
            Object[] fila = new Object[4];
            fila[0] = producto.getId();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getDescripcion();
            modelo.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tabla.setModel(modelo);

        // Devolver la tabla llena
        return tabla;
    }

    
    public void agregar(Producto producto) throws SQLException{
        try{
        productoDAO.agregar(producto);
        }
        catch(SQLException ex){
            throw new SQLException();
        }
    }
    
    public void eliminar(Producto producto) throws SQLException{
        try{
        productoDAO.eliminar(producto);
        }
        catch(Exception ex){
            throw new SQLException();
        }
    }
    
    public void actualizar(Producto producto) throws SQLException{
        try{
        productoDAO.actualizar(producto);
        }
        catch(Exception ex){
            throw new SQLException();
        }
    }
    
}
