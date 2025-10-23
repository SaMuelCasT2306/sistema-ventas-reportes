package com.poo.edu.utp.ingenieria.sistemaventas.repositorios;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class ProductoRepository {
    
     //atributos conexion DB
    private ConexionBaseDatos db;
    
    //Constructor 
    public ProductoRepository(ConexionBaseDatos db) {
        this.db = db;
    }
    
        //Metodos INSERT cliente 
    public void insertarProducto (Producto p) throws SQLException {
        
        //Asignar query con placeholders (?)
        String sql = "INSERT INTO Producto (codigo, nombre, precioUnitario) VALUES (?, ?, ?)";
        
        //try (abre la conexion a la base de datos, y abrir prepared statements que se encarga de ejecutar la query y devolver la PK generadas)
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            //reemplazar placeholders
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setFloat(3, p.getPrecioUnitario());
            
            //Ejecutar query
            ps.executeUpdate();
            
            //try (para recuperar los ids creados por la BD)
            try (ResultSet rs = ps.getGeneratedKeys()){
                
                if (rs.next()){
                    //obtener el id en la columna 1
                    p.setId(rs.getInt(1));
                }else{
                    throw new SQLException("No se pudo obtener el ID generado para el producto");
                }
                
            }
            
        }
        
    } 
    
    public void updateProducto (Producto p) throws SQLException{
        
        String sql = "UPDATE Cliente SET codigo=?, nombre=?, precioUnitario=? WHERE idProducto=?";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setFloat(3, p.getPrecioUnitario());
            ps.setInt(4, p.getId());
            int filas = ps.executeUpdate();
            
            if (filas >= 1){
                System.out.println("Se actualizo " + filas + " filas correctamente");
            }else{
                throw new SQLException("No se encontro el ID del producto");
            }
        } 
    }
    
    public void deleteProducto (Producto p)throws SQLException{
        
        String sql = "DELETE FROM Producto WHERE idProducto = ?;";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, p.getId());
            int filas = ps.executeUpdate();
            
            if (filas >= 1){
                System.out.println("Se elimino " + filas + " filas correctamente");
            }else{
                throw new SQLException("No se encontro el ID del producto");
            }
        }
        
    }
    
    public List<Producto> listarProductos() throws SQLException{
        
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT idProducto, codigo, nombre, precioUnitario FROM Producto ORDER BY idProducto ASC";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setCodigo(rs.getString(2));
                producto.setNombre(rs.getString(3));
                producto.setPrecioUnitario(rs.getFloat(4));
                productos.add(producto);
            }
        }
        return productos;
    }
    
    public void imprimirListaProductos (List<Producto> productos){
        
        try {
            if(productos.isEmpty()){
                throw new IllegalArgumentException("La lista no tiene ningun item");
            }else{
                for (Producto p : productos){
                    System.out.println("id: " + p.getId() + " | Codigo: " + p.getCodigo() + " | Nombre: " + p.getNombre() + " | Precio Unitario: " + p.getPrecioUnitario());
                }
            }
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
}
