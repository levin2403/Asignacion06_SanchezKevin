/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcpizzeria_sanchezkevin;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author skevi
 */
public class JDBCpizzeria_SanchezKevin {

    public static void main(String[] args) {
        
        String cadena = "jdbc:mysql://localhost:3306/pizzeria";
        String user = "root";
        String password = "Saymyname15";
        String i = "INSERT INTO productos (nombre, precio, descripcion) VALUES (?,?,?)";
        String buscar = "SELECT * FROM productos WHERE precio < ?";
        try{
            Connection c = DriverManager.getConnection(cadena, user, password);
            PreparedStatement insert = c.prepareStatement(i, Statement.RETURN_GENERATED_KEYS);
            /*
            insert.setString(1, "Pizza de Pepperoni");
            insert.setFloat(2, (float)80.0);
            insert.setString(3, "Pizza sencilla con base de tomate y queso, sin extra toppings");
            
            insert.executeUpdate();
            */
            PreparedStatement busqueda = c.prepareStatement(buscar);
            busqueda.setFloat(1, 100);
            
            ResultSet resultados = busqueda.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
