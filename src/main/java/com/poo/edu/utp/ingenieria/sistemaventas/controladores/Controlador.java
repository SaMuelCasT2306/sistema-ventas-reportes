package com.poo.edu.utp.ingenieria.sistemaventas.controladores;

import com.poo.edu.utp.ingenieria.sistemaventas.dto.ClienteProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaClienteDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaProductoDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.DetalleFactura;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Factura;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ClienteRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.FacturaRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.repositorios.ProductoRepository;
import com.poo.edu.utp.ingenieria.sistemaventas.servicios.ConexionBaseDatos;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Configuracion;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Login;
import com.poo.edu.utp.ingenieria.sistemaventas.utilidades.Reportes;
import java.sql.SQLException;
import java.util.List;

public class Controlador {

    ConexionBaseDatos cbd = new ConexionBaseDatos(Configuracion.DB_URL, Configuracion.DB_USUARIO, Configuracion.DB_PASSWORD);
    ClienteRepository cr = new ClienteRepository(cbd);
    ProductoRepository pr = new ProductoRepository(cbd);
    FacturaRepository fr = new FacturaRepository(cbd);
    Login l = new Login(cbd);

    //CONTROLADOR DE CLIENTES ------------------------------------------------------------------
    // ---> Pantalla Clientes
    public List<Cliente> cargarTablaClientes() throws SQLException {
        List<Cliente> list = cr.listarClientes();
        return list;
    }

    public void guardarCliente(Cliente cliente) throws SQLException{
        cr.insertarCliente(cliente);
    }
    
    //CONTROLADOR DE PRODUCTOS ------------------------------------------------------------------- 
    // ---> Pantalla Productos
    public List<Producto> cargarTablaProductos() throws SQLException {
        List<Producto> list = pr.listarProductos();
        return list;
    }

    // ---> Pantalla Productos
    public List<Producto> cargarTablaProductosDinamicos(String nombre) throws SQLException {
        List<Producto> list = pr.listarProductosDinamico(nombre);
        return list;
    }

    public void guardarProducto(Producto producto) throws SQLException {
        pr.insertarProducto(producto);
    }
    
    // <---- Pantalla Crear Producto
    public String obtenerProxCodigoProducto() throws SQLException {
        return pr.obtenerProxCodigoProducto();
    }

    //CONTROLADOR FACTURAS ----------------------------------------------------------------------------
    // ---> Pantalla Facturas
    public List<FacturaClienteDTO> cargarTablaFacturas() throws SQLException {
        return fr.listaFacturas();
    }

    // ---> Pantalla Facturas
    public List<FacturaClienteDTO> cargarTablaFacturasPorFecha(String fromDate, String toDate) throws SQLException {
        return fr.listaFacturasPorFecha(fromDate, toDate);
    }

    // <---- Pantalla Crear Factura
    public int guardarFactura(Factura factura) throws SQLException {
        return fr.insertarFactura(factura);
    }

    // <---- Pantalla Crear Factura
    public void guardarDetalleFactura(DetalleFactura detalle) throws SQLException {
        fr.insertarDetalle(detalle);
    }

    // <---- Pantalla Crear Factura
    public String obtenerProxNumeroFactura() throws SQLException {
        return fr.obtenerProxNumeroFactura();
    }

    //CONTROLADOR FACTURA PRODUCTOS ------------------------------------------------------------------------
    // ---> Pantalla Factura Producto
    public List<FacturaProductoDTO> cargarTablaFacturaProductos() throws SQLException {
        List<FacturaProductoDTO> list = fr.listaFacturasPorNombreProducto();
        return list;
    }

    // ---> Pantalla Factura Producto
    public List<FacturaProductoDTO> cargarTablaFacturasProductosDinamicos(String nombre) throws SQLException {
        List<FacturaProductoDTO> list = fr.listaFacturasPorNombreProductoDinamico(nombre);
        return list;
    }

    //CONTROLADOR CLIENTE PRODUCTOS ------------------------------------------------------------------------- 
    // ---> Pantalla Cliente Producto
    public List<ClienteProductoDTO> cargarTablaClientesProducto() throws SQLException {
        List<ClienteProductoDTO> list = cr.listarClientesPorProducto();
        return list;
    }

    // ---> Pantalla Cliente Producto
    public List<ClienteProductoDTO> cargarTablaClientesProductosDinamicos(String nombre) throws SQLException {
        List<ClienteProductoDTO> list = cr.listarClientesPorProductoDinamico(nombre);
        return list;
    }

    //GENERAR REPORTE PRODUCTO ---------------------------------------------------------------------------------
    // ---> Pantalla Producto
    public void generarReporte(String rutaPlantilla, String rutaReporte, List<Producto> p) {
        Reportes.crearReportesProductos(rutaPlantilla, rutaReporte, p);
    }

    //LOGIN ----------------------------------------------------------------------------------------------------
    // ---> Pantalla Login
    public boolean login(String usuario, String contraseña) throws SQLException {
        return l.validarLogin(usuario, contraseña);
    }

}
