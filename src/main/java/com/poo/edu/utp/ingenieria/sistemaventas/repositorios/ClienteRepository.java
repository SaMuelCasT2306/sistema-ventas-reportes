package com.poo.edu.utp.ingenieria.sistemaventas.repositorios;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.ClienteProducto;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class ClienteRepository {
    
    //atributos conexion DB
    private ConexionBaseDatos db;
    
    //Constructor 
    public ClienteRepository(ConexionBaseDatos db) {
        this.db = db;
    }
    
    //Metodos INSERT cliente 
    public void insertarCliente (Cliente c) throws SQLException {
        
        //Asignar query con placeholders (?)
        String sql = "INSERT INTO Cliente (ruc, nombre, direccion) VALUES (?, ?, ?)";
        
        //try (abre la conexion a la base de datos, y abrir prepared statements que se encarga de ejecutar la query y devolver la PK generadas)
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            //reemplazar placeholders
            ps.setLong(1, c.getRuc());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            
            //Ejecutar query
            ps.executeUpdate();
            
            //try (para recuperar los ids creados por la BD)
            try (ResultSet rs = ps.getGeneratedKeys()){
                
                if (rs.next()){
                    //obtener el id en la columna 1
                    c.setId(rs.getInt(1));
                }else{
                    throw new SQLException("No se pudo obtener el ID Generado para el cliente");
                }
                
            }
            
        }
        
    } 
    
    public void updateCliente (Cliente c) throws SQLException{
        
        String sql = "UPDATE Cliente SET ruc=?, nombre=?, direccion=? WHERE idCliente=?";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setLong(1, c.getRuc());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDireccion());
            ps.setInt(4, c.getId());
            int filas = ps.executeUpdate();
            
            if (filas >= 1){
                System.out.println("Se actualizo " + filas + " filas correctamente");
            }else{
                throw new SQLException("No se encontro el ID del cliente");
            }
        } 
    }
    
    public void deleteCliente(Cliente e)throws SQLException{
        
        String sql = "DELETE FROM Cliente WHERE idCliente = ?;";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, e.getId());
            int filas = ps.executeUpdate();
            
            if (filas >= 1){
                System.out.println("Se elimino " + filas + " filas correctamente");
            }else{
                throw new SQLException("No se encontro el ID del cliente");
            }
        }
        
    }
    
    public List<Cliente> listarClientes() throws SQLException{
        
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT idCliente, ruc, nombre, direccion FROM Cliente ORDER BY idCliente ASC";
        
        try (Connection con = db.conexion();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setRuc(rs.getLong(2));
                cliente.setNombre(rs.getString(3));
                cliente.setDireccion(rs.getString(4));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    
    public void imprimirListaClientes (List<Cliente> clientes){
        
        try {
            if(clientes.isEmpty()){
                throw new IllegalArgumentException("La lista no tiene ningun item");
            }else{
                for (Cliente e : clientes){
                    System.out.println("id: " + e.getId() + " | ruc: " + e.getRuc() + " | nombre: " + e.getNombre() + " | direccion: " + e.getDireccion());
                }
            }
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
    public List<ClienteProducto> listarClientesPorProducto (String nombreProducto) throws SQLException{

        List<ClienteProducto> listaClientes = new ArrayList<>();
        String sql = "SELECT c.Nombre AS Cliente,c.RUC,f.NroFactura,f.Fecha,p.Nombre AS Producto,df.Cantidad\r\n" + //
                        "FROM Factura f\r\n" + //
                        "INNER JOIN Cliente c ON f.idCliente = c.idCliente\r\n" + //
                        "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\r\n" + //
                        "INNER JOIN Producto p ON df.idProducto = p.idProducto\r\n" + //
                        "WHERE p.codigo = ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                
                ClienteProducto clienteProducto = new ClienteProducto();
                clienteProducto.setNombreCliente(rs.getString(1));
                clienteProducto.setRuc(rs.getLong(2));
                clienteProducto.setNroFactura(rs.getString(3));
                clienteProducto.setFecha(rs.getDate(4));
                clienteProducto.setNombreProducto(rs.getString(5));
                clienteProducto.setCantidad(rs.getInt(6));
                listaClientes.add(clienteProducto);

            }

        }

        return listaClientes;

    }

    public void imprimirListaClientesPorProductos (List<ClienteProducto> listaClienteProductos){

        try {

            if (listaClienteProductos.isEmpty()){
                throw new IllegalArgumentException("La lista esta vacia");
            }
            
            DecimalFormat df = new DecimalFormat("0.00");
            for (ClienteProducto cp : listaClienteProductos){

                System.out.println("Nombre Cliente: " + cp.getNombreCliente() + " | RUC: " + cp.getRuc() + " | Código Factura: " + cp.getNroFactura() + " | Fecha " + cp.getFecha() + " | Nombre Producto: " + cp.getNombreProducto() + " | Cantidad: " + cp.getCantidad());

            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

}
