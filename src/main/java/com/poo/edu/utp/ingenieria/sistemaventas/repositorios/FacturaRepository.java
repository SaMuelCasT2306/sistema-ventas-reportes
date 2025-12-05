package com.poo.edu.utp.ingenieria.sistemaventas.repositorios;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaClienteDTO;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Factura;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class FacturaRepository {
    
    //atributos conexion DB
    private ConexionBaseDatos db;
    
    //Constructor 
    public FacturaRepository(ConexionBaseDatos db) {
        this.db = db;
    }
    
    public List<FacturaProductoDTO> listaFacturasPorNombreProducto () throws SQLException{

        List<FacturaProductoDTO> listafacturas = new ArrayList<>(); 
        String sql = "SELECT f.nroFactura,f.fecha,p.nombre AS producto,df.cantidad,df.precioUnitario,df.importe\r\n" + //
                        "FROM Factura f\r\n" + //
                        "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\r\n" + //
                        "INNER JOIN Producto p ON df.idProducto = p.idProducto\r\n";
                        //"WHERE p.codigo = ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                
                FacturaProductoDTO facturaProducto = new FacturaProductoDTO();
                facturaProducto.setNroFactura(rs.getString(1));
                facturaProducto.setFecha(rs.getDate(2));
                facturaProducto.setProducto(rs.getString(3));
                facturaProducto.setCantidad(rs.getInt(4));
                facturaProducto.setPrecioUnitario(rs.getFloat(5));
                facturaProducto.setImporte(rs.getFloat(6));
                listafacturas.add(facturaProducto);

            }

        }

        return listafacturas;

    }
    
    public List<FacturaProductoDTO> listaFacturasPorNombreProductoDinamico (String nombreProducto) throws SQLException{

        List<FacturaProductoDTO> listafacturas = new ArrayList<>(); 
        String sql = "SELECT f.nroFactura, f.fecha, p.nombre AS producto, df.cantidad, df.precioUnitario, df.importe\n" +
                    "FROM Factura f\n" +
                    "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\n" +
                    "INNER JOIN Producto p ON df.idProducto = p.idProducto\n" +
                    "WHERE p.nombre LIKE ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, "%"+nombreProducto+"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                
                FacturaProductoDTO facturaProducto = new FacturaProductoDTO();
                facturaProducto.setNroFactura(rs.getString(1));
                facturaProducto.setFecha(rs.getDate(2));
                facturaProducto.setProducto(rs.getString(3));
                facturaProducto.setCantidad(rs.getInt(4));
                facturaProducto.setPrecioUnitario(rs.getFloat(5));
                facturaProducto.setImporte(rs.getFloat(6));
                listafacturas.add(facturaProducto);

            }

        }

        return listafacturas;

    }
    
    public List<FacturaClienteDTO> listaFacturas (String fromDate, String toDate) throws SQLException{
        
        List<FacturaClienteDTO> listafacturas = new ArrayList<>(); 
        String sql = "SELECT \n" +
"       f.idFactura AS id,\n" +
"       f.fecha,\n" +
"       c.nombre AS Nombre_Cliente, -- Aquí reemplazamos el número por el nombre\n" +
"       f.total,\n" +
"	f.condicionPago,\n" +
"	f.subtotal,\n" +
"	f.igv,\n" +
"	f.nroFactura\n" +
"       FROM Factura f\n" +
"       INNER JOIN Cliente c ON f.idCliente = c.idCliente\n" +
"       WHERE f.fecha BETWEEN ? AND ?;";
        
        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                
                FacturaClienteDTO facturas = new FacturaClienteDTO();
                facturas.setNroFactura(rs.getString(8));
                facturas.setFecha(rs.getDate(2));
                facturas.setNombreCliente(rs.getString(3));
                facturas.setCondicionPago(rs.getString(5));
                facturas.setSubtotal(rs.getFloat(6));
                facturas.setIgv(rs.getFloat(7));
                facturas.setTotal(rs.getFloat(4));                       
                listafacturas.add(facturas);

            }

        }
        
        return listafacturas;
    }
    
    public void ImprimirFacturasPorNombreProducto (List<FacturaProductoDTO> listaFacturaProductos){

        try {

            if (listaFacturaProductos.isEmpty()){
                throw new IllegalArgumentException("La lista esta vacia");
            }
            
            DecimalFormat df = new DecimalFormat("0.00");
            for (FacturaProductoDTO fp : listaFacturaProductos){

                String pUFormateado = "";
                String iFormateado = "";
                pUFormateado = df.format(fp.getPrecioUnitario());
                iFormateado = df.format(fp.getImporte());

                System.out.println("Codigo Factura: " + fp.getNroFactura() + " | Fecha: " + fp.getFecha() + " | Producto: " + fp.getProducto() + " | Cantidad: " + fp.getCantidad() + " | Precio Unitario: S/. " + pUFormateado + " | Importe Total: S/. " + iFormateado);

            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    } 

}
