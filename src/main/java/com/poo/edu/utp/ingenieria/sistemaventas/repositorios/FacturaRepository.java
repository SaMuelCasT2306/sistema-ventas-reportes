package com.poo.edu.utp.ingenieria.sistemaventas.repositorios;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProducto;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Factura;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class FacturaRepository {
    
    //atributos conexion DB
    private ConexionBaseDatos db;
    
    //Constructor 
    public FacturaRepository(ConexionBaseDatos db) {
        this.db = db;
    }
    
    public List<FacturaProducto> listaFacturasPorNombreProducto (String nombreProducto) throws SQLException{

        List<FacturaProducto> listafacturas = new ArrayList<>(); 
        String sql = "SELECT f.nroFactura,f.fecha,p.nombre AS producto,df.cantidad,df.precioUnitario,df.importe\r\n" + //
                        "FROM Factura f\r\n" + //
                        "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\r\n" + //
                        "INNER JOIN Producto p ON df.idProducto = p.idProducto\r\n" + //
                        "WHERE p.codigo = ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                
                FacturaProducto facturaProducto = new FacturaProducto();
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
    
    public void ImprimirFacturasPorNombreProducto (List<FacturaProducto> listaFacturaProductos){

        try {

            if (listaFacturaProductos.isEmpty()){
                throw new IllegalArgumentException("La lista esta vacia");
            }
            
            DecimalFormat df = new DecimalFormat("0.00");
            for (FacturaProducto fp : listaFacturaProductos){

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
