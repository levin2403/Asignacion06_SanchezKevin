/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author skevi
 */
public class Conexion implements IConexion{

    String cadena = "jdbc:mysql://localhost:3306/pizzeria";
    String user = "root";
    String password = "Saymyname15";
    
    @Override
    public Connection crearConexion() {
       try{
           return DriverManager.getConnection(cadena, user, password);
       }
       catch(SQLException ex){
           
       }
       return null;
    }
    
}
