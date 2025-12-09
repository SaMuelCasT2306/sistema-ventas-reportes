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
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.DetalleFactura;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Factura;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;

public class FacturaRepository {

    //atributos conexion DB
    private ConexionBaseDatos db;

    //Constructor 
    public FacturaRepository(ConexionBaseDatos db) {
        this.db = db;
    }

    public List<FacturaProductoDTO> listaFacturasPorNombreProducto() throws SQLException {

        List<FacturaProductoDTO> listafacturas = new ArrayList<>();
        String sql = "SELECT f.nroFactura,f.fecha,p.nombre AS producto,df.cantidad,df.precioUnitario,df.importe\r\n"
                + //
                "FROM Factura f\r\n"
                + //
                "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\r\n"
                + //
                "INNER JOIN Producto p ON df.idProducto = p.idProducto\r\n";
        //"WHERE p.codigo = ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

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

    public List<FacturaProductoDTO> listaFacturasPorNombreProductoDinamico(String nombreProducto) throws SQLException {

        List<FacturaProductoDTO> listafacturas = new ArrayList<>();
        String sql = "SELECT f.nroFactura, f.fecha, p.nombre AS producto, df.cantidad, df.precioUnitario, df.importe\n"
                + "FROM Factura f\n"
                + "INNER JOIN DetalleFactura df ON f.idFactura = df.idFactura\n"
                + "INNER JOIN Producto p ON df.idProducto = p.idProducto\n"
                + "WHERE p.nombre LIKE ?";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nombreProducto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

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

    public List<FacturaClienteDTO> listaFacturasPorFecha(String fromDate, String toDate) throws SQLException {

        List<FacturaClienteDTO> listafacturas = new ArrayList<>();
        String sql = "SELECT \n"
                + "       f.idFactura AS id,\n"
                + "       f.fecha,\n"
                + "       c.nombre AS Nombre_Cliente,\n"
                + "       f.total,\n"
                + "	f.condicionPago,\n"
                + "	f.subtotal,\n"
                + "	f.igv,\n"
                + "	f.nroFactura\n"
                + "       FROM Factura f\n"
                + "       INNER JOIN Cliente c ON f.idCliente = c.idCliente\n"
                + "       WHERE f.fecha BETWEEN ? AND ?;";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

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

    public List<FacturaClienteDTO> listaFacturas() throws SQLException {

        List<FacturaClienteDTO> listafacturas = new ArrayList<>();
        String sql = "SELECT \n"
                + "       f.idFactura AS id,\n"
                + "       f.fecha,\n"
                + "       c.nombre AS Nombre_Cliente,\n"
                + "       f.total,\n"
                + "	f.condicionPago,\n"
                + "	f.subtotal,\n"
                + "	f.igv,\n"
                + "	f.nroFactura\n"
                + "       FROM Factura f\n"
                + "       INNER JOIN Cliente c ON f.idCliente = c.idCliente\n";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FacturaClienteDTO facturas = new FacturaClienteDTO();
                facturas.setId(rs.getInt(1));                
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

    public void insertarDetalle(DetalleFactura detalle) throws SQLException {

        String sql = "INSERT INTO DetalleFactura (idFactura, idProducto, cantidad, precioUnitario, importe) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, detalle.getIdFactura());
            ps.setInt(2, detalle.getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setFloat(4, detalle.getPrecioUnitario());
            ps.setFloat(5, detalle.getImporte());

            ps.executeUpdate();
        }
    }

    public int insertarFactura(Factura factura) throws SQLException {

        String sql = "INSERT INTO Factura (nroFactura, fecha, condicionPago, subtotal, igv, total, idEmpresa, idCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, factura.getNumeroFactura());
            ps.setDate(2, new java.sql.Date(factura.getFecha().getTime()));
            ps.setString(3, factura.getCondicionPago());
            ps.setFloat(4, factura.getSubtotal());
            ps.setFloat(5, factura.getIgv());
            ps.setFloat(6, factura.getTotal());
            ps.setInt(7, factura.getIdEmpresa());
            ps.setInt(8, factura.getIdCliente());

            ps.executeUpdate();

            try (java.sql.ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para la factura");
                }
            }
        }
    }

    public void deleteFactura(Factura factura) throws SQLException {

        Connection con = db.conexion();

        try {

            // Eliminar el detalle
            String sqlDetalle = "DELETE FROM DetalleFactura WHERE idFactura = ?";
            try (PreparedStatement psDetalle = con.prepareStatement(sqlDetalle)) {
                psDetalle.setInt(1, factura.getId());
                int filasDetalle = psDetalle.executeUpdate();
                System.out.println("Se eliminaron " + filasDetalle + " detalles de la factura");
            }

            // Eliminar la factura
            String sqlFactura = "DELETE FROM Factura WHERE idFactura = ?";
            try (PreparedStatement psFactura = con.prepareStatement(sqlFactura)) {
                psFactura.setInt(1, factura.getId());
                int filasFactura = psFactura.executeUpdate();

                if (filasFactura >= 1) {
                    System.out.println("Se eliminó la factura correctamente");
                } else {
                    throw new SQLException("No se encontró la factura con ID: " + factura.getId());
                }
            }

            // Confirmar transacción
            con.commit();
            con.close();

        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
        }
    }

    public String obtenerProxNumeroFactura() throws SQLException {
        String sql = "SELECT MAX(CAST(SUBSTRING(nroFactura, 10, 4) AS INT)) as maxNum FROM Factura WHERE nroFactura LIKE 'F-2025-%'";

        try (Connection con = db.conexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            int proximoNumero = 1;
            if (rs.next()) {
                int maxNum = rs.getInt("maxNum");
                if (maxNum > 0) {
                    proximoNumero = maxNum + 1;
                }
            }

            return String.format("F-2025-%04d", proximoNumero);
        }
    }

}
