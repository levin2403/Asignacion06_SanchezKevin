/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.jdbcpizzeria_sanchezkevin;

import dao.ProductoDAO;
import entidades.Producto;
import interfaces.IProductoDAO;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IProductoDAO producto = new ProductoDAO();
        
        
        //Agregamos 3 productos.
        try{
            Producto producto1 = new Producto("pizza hawaiana", new BigDecimal(149.99), "piza con jamon y piña");
            Producto producto2 = new Producto("pizza clasica", new BigDecimal(99.99), "pizza con peperoni");
            Producto producto3 = new Producto("piza mexicana", new BigDecimal(119.99), "pizza con chorizo y jalapeño");
            
            producto.agregar(producto1);
            producto.agregar(producto2);
            producto.agregar(producto3);
            
            
            System.out.println("Productos agregados correctamente \n");
            
        }
        catch(Exception ex){
            System.out.println("El metodo de agregar ha fallado\n");
        }
        
        //Eliminamos un producto.
        try{
            producto.eliminar(1);
            System.out.println("El producto con id igual a 1 a sido eliminado \n");
        }
        catch(Exception ex){
            System.out.println("El metodo de eliminar producto a fallado \n");
        }
        
        //Consultamos por id.
        try{
            System.out.println(producto.consultar(2).toString());
            System.out.println("el producto con id igual a 2 a sido consultado \n");
        }
        catch(Exception ex){
            System.out.println("El metodo de consultar por id a fallado \n");
        }
        
        //imprimimos todos los productos
        try{
            List<Producto> lista = producto.consultarTodos();
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString());
            }
            System.out.println("La lista con todos los productos a sido consultada \n");
        }
        catch(Exception ex){
            System.out.println("El metodo de imprimir todos a fallado \n");
        }
        
    }
    
}
