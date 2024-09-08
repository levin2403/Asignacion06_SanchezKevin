/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Producto;
import interfaces.IConexion;
import interfaces.IProductoDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class ProductoDAO implements IProductoDAO{

    private IConexion conexion;

    public ProductoDAO() {
        this.conexion = new Conexion();
    }
    
    
    @Override
    public void agregar(Producto producto) throws SQLException{
        String consulta = "INSERT INTO productos (nombre, precio, descripcion) VALUES(?,?,?)";

        try (Connection bd = conexion.crearConexion();
             PreparedStatement i = bd.prepareStatement(consulta)) {

            i.setString(1, producto.getNombre());
            i.setBigDecimal(2, producto.getPrecio()); 
            i.setString(3, producto.getDescripcion());

            i.executeUpdate(); 

        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
    }

    @Override
    public void eliminar(Producto producto) throws SQLException {
        String eliminar = "DELETE FROM productos WHERE id = ?";

        // Utilizar try-with-resources para manejar la conexión y el PreparedStatement
        try (Connection conn = conexion.crearConexion();
             PreparedStatement eliminacion = conn.prepareStatement(eliminar)) {

            // Establecer el valor del parámetro en la consulta
            eliminacion.setInt(1, producto.getId());

            // Ejecutar la actualización (DELETE)
            eliminacion.executeUpdate();

        } catch (SQLException ex) {
            // Manejo de excepciones
            ex.printStackTrace();
            throw ex; // Lanza la excepción si es necesario manejarla en otro lugar
        }
    }


    @Override
    public void actualizar(Producto producto) throws SQLException{
        String actualizar = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE nombre = ?";

        try {
            PreparedStatement actualizacion = conexion.crearConexion().prepareStatement(actualizar);

            actualizacion.setString(1, producto.getNombre());
            actualizacion.setBigDecimal(2, producto.getPrecio());
            actualizacion.setString(3, producto.getDescripcion());
            actualizacion.setString(4, producto.getNombre());

        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }   
    }


    @Override
    public Producto consultar(int id) throws SQLException{
        String consulta = "SELECT * FROM productos WHERE id = ?";

        try {
            PreparedStatement busqueda = conexion.crearConexion().prepareStatement(consulta);
            busqueda.setInt(1, id);

            ResultSet resultado = busqueda.executeQuery();

            if (resultado.next()) {
                return new Producto(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getBigDecimal("precio"),
                    resultado.getString("descripcion")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }

        return null; 
    }


    @Override
    public List<Producto> consultarTodos() throws SQLException{
        String consulta = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();

        try {
            PreparedStatement busqueda = conexion.crearConexion().prepareStatement(consulta);

            ResultSet resultado = busqueda.executeQuery();

            while (resultado.next()) {
                Producto producto = new Producto(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getBigDecimal("precio"),
                    resultado.getString("descripcion")
                );
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }

        return productos; 
    }

    
}
