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
    public void agregar(Producto producto) {
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
    public void eliminar(int id) {
        String eliminar = "DELETE FROM productos WHERE id = ?";

        try {
            PreparedStatement eliminacion = conexion.crearConexion().prepareStatement(eliminar);
            eliminacion.setInt(1, id);

        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }

         
    }


    @Override
    public void actualizar(Producto producto) {
        String actualizar = "UPDATE productos SET nombre = ?, precio = ?, descripcion = ? WHERE id = ?";

        try {
            PreparedStatement actualizacion = conexion.crearConexion().prepareStatement(actualizar);

            actualizacion.setString(1, producto.getNombre());
            actualizacion.setBigDecimal(2, producto.getPrecio());
            actualizacion.setString(3, producto.getDescripcion());
            actualizacion.setInt(4, producto.getId());

        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }   
    }


    @Override
    public Producto consultar(int id) {
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
    public List<Producto> consultarTodos() {
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
